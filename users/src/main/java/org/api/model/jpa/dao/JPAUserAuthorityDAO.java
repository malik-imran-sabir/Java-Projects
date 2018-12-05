package org.api.model.jpa.dao;

import org.api.model.jpa.entity.UserAuthorityEntity;
import org.core.model.dao.BaseJPADAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPAUserAuthorityDAO extends BaseJPADAO<UserAuthorityEntity, Long> {}
