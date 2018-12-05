package org.api.model.jpa.dao;

import java.io.Serializable;

import org.api.model.jpa.entity.TeacherStudentEntity;
import org.core.model.dao.BaseJPADAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPATeacherStudentDAO extends BaseJPADAO<TeacherStudentEntity, Serializable> {}
