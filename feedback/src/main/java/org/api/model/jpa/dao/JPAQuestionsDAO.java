package org.api.model.jpa.dao;

import java.io.Serializable;

import org.api.model.jpa.entity.QuestionsEntity;
import org.core.model.dao.BaseJPADAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPAQuestionsDAO extends BaseJPADAO<QuestionsEntity, Serializable> {
	
}
