package org.api.model.jpa.dao;

import java.io.Serializable;

import org.api.model.jpa.entity.LocationMappingEntity;
import org.core.model.dao.BaseJPADAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPALocationDAO extends BaseJPADAO<LocationMappingEntity, Serializable> {

}
