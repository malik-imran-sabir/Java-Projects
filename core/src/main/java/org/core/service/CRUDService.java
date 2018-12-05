package org.core.service;

import java.util.Collection;

import org.core.model.entity.BaseEntity;
import org.core.vo.BaseVO;



public interface CRUDService<VO extends BaseVO> extends BaseService<VO>, PopulateBeanPropertiesService<VO> {

	
	public VO save(VO body) throws Throwable ;
	public VO update(VO body) throws Throwable ;
	public VO getById(String Id) throws Throwable ;
	public Collection<VO> getAll() throws Throwable ;
	public void remove(Long[] ids);
	public <E extends BaseEntity> E getEntityById(Long id);

	
}
