package org.api.model.jpa.dao;

import java.io.Serializable;

import org.api.model.jpa.entity.QuestionsAnswersEntity;
import org.core.model.dao.BaseJPADAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPAQuestionsAnswersDAO extends BaseJPADAO<QuestionsAnswersEntity, Serializable> {
}
