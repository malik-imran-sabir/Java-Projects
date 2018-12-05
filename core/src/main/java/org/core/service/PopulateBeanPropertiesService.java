package org.core.service;

import org.core.model.entity.BaseEntity;
import org.core.vo.BaseVO;

public interface PopulateBeanPropertiesService<VO extends BaseVO>  {

	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(VO source) throws Throwable;
	public <ENTITY extends BaseEntity> VO getDeepCopiedVO(ENTITY source) throws Throwable;
	
}
