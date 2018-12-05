package org.core.service;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import org.core.model.dao.BaseDAO;
import org.core.model.dao.BaseJPADAO;
import org.core.model.entity.BaseEntity;
import org.core.util.BeanUtils;
import org.core.util.Constants;
import org.core.util.DateUtils;
import org.core.vo.BaseVO;

public abstract class CRUDServiceImpl<ENTITY extends BaseEntity,VO extends BaseVO> implements CRUDService<VO> {
	

	protected BaseDAO<ENTITY, Serializable> dao;
	private Logger logger = Logger.getLogger(this.getClass());
	
	public CRUDServiceImpl(BaseDAO<ENTITY,Serializable> dao) {
		this.dao = dao;
	}
	
	@Override
	@Transactional
	public VO save(VO e) throws Throwable {
		
		ENTITY entity =  this.<ENTITY>getDeepCopiedEntity(e);
		
		Date currentTime = DateUtils.getCurrentDateTime();
		entity.setLastUpdatedOn(currentTime);
		
		
		//IF entity is for save first time;
		if(entity.getId() == null || entity.getId() <= 0L)
			entity.setCreatedOn(currentTime);
		
		entity = this.dao.saveBaseDAO(entity);
		
		return this.getDeepCopiedVO(entity);
		
	}

	@Override
	@Transactional
	public VO update(VO e) throws Throwable {
		return this.save(e);
		
	}

	@Override
	@Transactional
	public VO getById(String id) throws Throwable  {
		logger.info("<Start> getBId()");
		
		ENTITY e = this.getEntityById(Long.parseLong(id));
		VO vo = this.getDeepCopiedVO(e);
		
		logger.info("<END> getBId()");
		return vo;
		
	}

	@Override
	@Transactional
	public Collection<VO> getAll()throws Throwable  {
		Collection<ENTITY> elements = this.dao.findByStatus(Constants.STATUS.ACITVE.getValue());
		Collection<VO> vos = new ArrayList<>();
		elements.forEach((e)->{
			try {
				VO v = this.getDeepCopiedVO(e);
				vos.add(v);
			} catch (Throwable ex) {
				
			}
		});
		return vos;
	}
	
	@Override
	@Transactional
	public  void remove(Long[] ids) {
		this.dao.updateByIds(Constants.STATUS.DELETED.getValue(), Arrays.asList(ids));
	}

	@Override
	@Transactional
	public ENTITY getEntityById(Long id) {
		logger.info("<Start> getEntityById()");
		
		ENTITY e = this.dao.findByIdAndStatus(id, Constants.STATUS.ACITVE.getValue());
		
		logger.info("<END> getEntityById()");
		return e;
	}
	
}
