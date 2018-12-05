package org.api.model.jpa.dao;

import java.io.Serializable;
import java.util.Collection;

import org.api.model.jpa.entity.LocationMappingDataEntity;
import org.core.model.dao.BaseJPADAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPALocationDataDAO extends BaseJPADAO<LocationMappingDataEntity, Serializable> {
	//LocationMappingDataEntity findByLocationMappingIds (long id);
	Collection<?> findByLocationMappingDataId(Long id);
	Collection<?> findByLocationMappingId(long id);

}
