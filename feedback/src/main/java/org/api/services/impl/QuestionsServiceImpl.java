package org.api.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.api.model.jpa.dao.JPAQuestionsDAO;
import org.api.model.jpa.entity.QuestionsEntity;
import org.api.vo.QuestionsVO;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("QuestionsService1")
public class QuestionsServiceImpl extends CRUDServiceImpl<QuestionsEntity, QuestionsVO>implements QuestionsService{
	
	@Autowired
	JPAQuestionsDAO questionsDAO;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	//** The util. *//*
	
	public QuestionsServiceImpl(BaseDAO<QuestionsEntity, Serializable> dao) {
		super(dao);
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(QuestionsVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, QuestionsEntity.class);
		
	}

	@Override
	public <ENTITY extends BaseEntity> QuestionsVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, QuestionsVO.class);
	}

}
