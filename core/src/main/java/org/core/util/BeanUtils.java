package org.core.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import org.core.model.entity.BaseEntity;
import org.core.vo.BaseVO;

@Component
public class BeanUtils {
	
	private static Logger logger = Logger.getLogger(BeanUtils.class);
	public static ApplicationContext context;
	
	@Autowired
	public void setApplicationContext(ApplicationContext ctx){
		context = ctx;
	}
	
	public static<S,D> D shallowCopy(S source, Class<D> dest) throws Exception{

		logger.info("<START>: shallowCopy()");
		logger.info("source: "+source.getClass());

		D destinationBean = getBeanInstance(dest);
		logger.info("destinationBean : "+destinationBean.getClass());

		//BeanUtils.<S,D>populateDateProperties(source, destinationBean);
		
		String[] propertiesToIgnore = BeanUtils.getpropertiesToIgnore(source);
		org.springframework.beans.BeanUtils.copyProperties(source, destinationBean,propertiesToIgnore);
		
		logger.info("<END>: shallowCopy()");
		return destinationBean;
	}

	public static<S,D> Collection<D> shallowCopyCollection(Collection<S> source, Class<D> dest) throws Exception {

		Collection<D> destinationList = new ArrayList<>();
		D destination = null;
		for(Iterator<S> it = source.iterator(); it.hasNext();){
			destination = BeanUtils.<S,D>shallowCopy(it.next(),dest);
			destinationList.add(destination);
		}
		return destinationList;

	}

	private static <D> D getBeanInstance(Class<D> dest) throws ReflectiveOperationException{
		
		D destinationBean =null;
		
		try{
			destinationBean = context.getBean(dest);
		} catch(NoSuchBeanDefinitionException e) {
			//e.printStackTrace();
			try {

				destinationBean = dest.newInstance();
				
			} catch (InstantiationException | IllegalAccessException e1) {
				logger.error("Exception while instantiating Destination bean instance"+e1.getMessage());
				throw e1;
			}
		}

		return destinationBean;
	}
	
	public static <T> String[] getpropertiesToIgnore(T obj){

		Class<?> superClass= obj.getClass();
		logger.info("CLass : "+obj.getClass());
		logger.info("Super CLass : "+superClass);
		
		Annotation annottion  = superClass.getAnnotation(Entity.class);
		logger.info("Annotation : "+annottion);
				
		if(annottion != null) {
			List<String> properties = new ArrayList<>(); 
			for(Field field : superClass.getDeclaredFields()) {
				logger.info(field.getName() +" : "+field.getType());
				
				//Avoid copy Collection from JPA entity to prevent 'LazyInitializationException' 
				if(Collection.class.equals(field.getType()) || 
						field.getType().getClass().getAnnotation(Entity.class) != null) {
					
					logger.info("[Props Added] : "+field.getName() +" : "+field.getType());
					properties.add(field.getName());
					
				}
  			}
			return properties.toArray(new String[]{});
		}
		
		return null;
	}
	
	
	public static <S,D> void populateDateProperties(S src, D dest) throws Exception {
		logger.info("<ENTER> populateDateProperties()");
		
		logger.info("Source Type : "+src.getClass());
		logger.info("Destination Type : "+dest.getClass());
		
		Date currentTime = DateUtils.getCurrentDateTime();
		
		if(src instanceof BaseVO) {
			String createdOn = (String)callMethod("getCreatedOn", src,null,null);
			//String lastUpdatedOn = (String)callMethod("getLastUpdatedOn", src,null,null);
			
			callMethod("setCreatedOn", dest,new Class[]{Date.class},
					new Object[]{DateUtils.convertStringToDefaultDateFormat(createdOn)});
			
			callMethod("setLastUpdatedOn", dest,new Class[]{Date.class},
					new Object[]{currentTime});
			
		} else if(src instanceof BaseEntity) {
				Date createdOn = (Date)callMethod("getCreatedOn", src,null,null);
				Date lastUpdatedOn = (Date)callMethod("getCreatedOn", src,null,null);
				createdOn = (isNew(src) || createdOn == null ?  currentTime: createdOn);
				
				callMethod("setCreatedOn", dest,new Class[]{String.class},
						new Object[]{DateUtils.convertDateToDefaultStringFormat(createdOn)});
				
				callMethod("setLastUpdatedOn", dest,new Class[]{String.class},
						new Object[]{DateUtils.convertDateToDefaultStringFormat(lastUpdatedOn)});
		}
			
		logger.info("<EXIT> populateDateProperties()");

	}
	
	public static<T>  boolean isNew(T t ) throws Exception{
		Long id = (Long)callMethod("getId", t, null,null);
		return (id == null || id <=0L);
	}

	private static Object callMethod(String methodName, Object obj, Class<?>[] clazzArgs, Object... args) throws Exception{
		
		Method m;
		try {
			
			m = obj.getClass().getMethod(methodName, clazzArgs);
			Object o = m.invoke(obj, args);
			return o;
			
		} catch (Exception e){
			e.printStackTrace();
			logger.error("Exception : "+e.getMessage());
			throw e;
		}
		
		

	}
}
