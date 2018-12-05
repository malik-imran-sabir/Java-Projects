package org.api.services.impl;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import org.api.model.jpa.dao.JPAAttendanceDAO;
import org.api.model.jpa.entity.AttendanceEntity;
import org.api.vo.AttendanceBulkVO;
import org.api.vo.AttendanceVO;
import org.api.vo.Shift;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.core.util.DateUtils;
import org.core.util.HttpUtils;
import org.core.view.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("AttendanceService")
public class AttendanceServiceImp extends CRUDServiceImpl<AttendanceEntity, AttendanceVO>implements AttendanceService{
	
	@Autowired
	JPAAttendanceDAO attendanceDao;
	
	public AttendanceServiceImp(BaseDAO<AttendanceEntity, Serializable> dao) {
		super(dao);
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(AttendanceVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, AttendanceEntity.class);

	}

	@Override
	public <ENTITY extends BaseEntity> AttendanceVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, AttendanceVO.class);

	}

	@Override
	public ResponseEntity<JSONResponse<?>> storeAttendence(AttendanceBulkVO attendanceBulk) {
		
		
		Date date = attendanceBulk.getDate();
		java.util.Date currentTime = DateUtils.getCurrentDateTime();
		Collection<Shift> shifts = attendanceBulk.getShifts();
		
		
		shifts.forEach(shift -> {
			Collection<AttendanceEntity> students =  shift.getStudents();
			System.out.println("StartTime"+shift.getStartTime());
			students.forEach(student-> {
				AttendanceEntity attendence =  new AttendanceEntity();
				attendence.setDate(date);
				attendence.setShiftId(shift.getShiftId());
				attendence.setStartTime(shift.getStartTime());
				attendence.setEndTime(shift.getEndTime());
				attendence.setLessonStart(shift.getLessonStart());
				attendence.setLessonEnd(shift.getLessonEnd());
				
				attendence.setUserId(student.getUserId());
				attendence.setClassId(student.getClassId());
				attendence.setCreatedOn(currentTime);
				attendence.setLastUpdatedOn(currentTime);
				attendence.setPresenceStatus(student.getPresenceStatus());
				attendanceDao.save(attendence);
			
			});
		});
		
		
		
		JSONResponse<?> jsonResp = new JSONResponse<>();
		jsonResp.setMessage("Success");
		jsonResp.setStatus("OK");
		return HttpUtils.getResponseEntity(jsonResp, HttpStatus.OK);
	}

}
