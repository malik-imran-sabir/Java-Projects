package org.api.model.jpa.dao;

import java.io.Serializable;

import org.api.model.jpa.entity.AttendanceEntity;
import org.core.model.dao.BaseJPADAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPAAttendanceDAO extends BaseJPADAO<AttendanceEntity, Serializable> {

}
