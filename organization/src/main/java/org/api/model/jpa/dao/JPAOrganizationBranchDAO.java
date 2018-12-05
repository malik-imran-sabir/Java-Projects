package org.api.model.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.api.model.jpa.entity.OrganizationBranchEntity;
import org.core.model.dao.BaseJPADAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPAOrganizationBranchDAO extends BaseJPADAO<OrganizationBranchEntity, Serializable> {
	Collection<OrganizationBranchEntity> findByNigranid(Long id);
	Collection<OrganizationBranchEntity> findByLocationIn(List<String> ids);

}
