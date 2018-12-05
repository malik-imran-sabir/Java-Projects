package org.api.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.api.model.jpa.dao.JPAQuestionsDAO;
import org.api.model.jpa.entity.ExamDataEntity;
import org.api.model.jpa.entity.QuestionsAnswersEntity;
import org.api.services.impl.ExamDataService;
import org.api.services.impl.SalaryReceivedService;
import org.api.services.impl.SalaryService;
import org.api.services.impl.UserService;
import org.api.vo.CommonUserVO;
import org.api.vo.ExamDataVOList;
import org.api.vo.QuestionsAnswersVOList;
import org.api.vo.SalaryReceivedVO;
import org.api.vo.SalaryVO;
import org.api.vo.UserVO;
import org.core.service.CRUDService;
import org.core.util.FileUploadUtils;
import org.core.util.JsonUtil;
import org.core.view.JSONResponse;
import org.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserVO>{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ExamDataService examDataService;
	
	@Autowired
	private JPAQuestionsDAO qService;
	
	@Autowired
	private SalaryService salaryService;
	
	@Autowired
	private SalaryReceivedService salaryReceivedService;
	
	/** The Constant extention. */
	private final static String extention = ".jpeg";
	
	@Autowired
	public UserController(CRUDService<UserVO> service) {
		super(service);
	}
	
	@GetMapping("/byType/{userTypeId}")
	public ResponseEntity<JSONResponse<?>> userByType(@PathVariable("userTypeId") long userTypeId) {
		return userService.usersByType(userTypeId);
	}
	
	@GetMapping("/userexists/{user}")
	public ResponseEntity<JSONResponse<?>> userexist(@PathVariable("user") String user) {
		return userService.userexist(user);
	}
	
	@GetMapping("/customizedList")
	public ResponseEntity<JSONResponse<?>> userDetail() {
		return userService.userDetail();
	}
	
	@GetMapping("/getstudentlist")
	public ResponseEntity<JSONResponse<?>> getStudentList() {
		return userService.getstudentlist();
	}
	

	@PostMapping("/save")
	public ResponseEntity<JSONResponse<?>> saveUpdateUser(@RequestBody CommonUserVO user, HttpServletRequest request) {
	
		String imagePath = FileUploadUtils.getBasePath(request) 
				+ File.separatorChar 
				+ FileUploadUtils.randomAlphaNumeric(10) 
				+ extention;
		try {
			

		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		return userService.saveUpdateUser(user, imagePath);
	}
	
	@GetMapping("/by-type-and-madarsa/{madarsaId}/{userTypeId}")
	public ResponseEntity<JSONResponse<?>> userByTypeAndMadarsa(@PathVariable("madarsaId") List<Long> madarsaId, @PathVariable("userTypeId") String userTypeId) {
		return userService.usersByTypeAndMadarsa(madarsaId,userTypeId);
	}

	@GetMapping("/list/{id}")
	public ResponseEntity<JSONResponse<?>> getUser(@PathVariable("id") long id) {
		return userService.getUser(id);
	}
	
	//for salary report
	@GetMapping("/allUsers")
	public ResponseEntity<JSONResponse<?>> allUsers() {
		//return userService.userDetail();
		return userService.allUserList();
		
	}
	
	@GetMapping("/salaryReport")
	public ResponseEntity<JSONResponse<?>> salaryReport() {
		return userService.salaryReportList();
	}
	
	@GetMapping("/monthlyAttendanceReport")
	public ResponseEntity<JSONResponse<?>> monthlyAttendanceReport() {
		return userService.monthlyAttendanceReport();
	}
	
	@GetMapping("/attendanceRegisterReport")
	public ResponseEntity<JSONResponse<?>> salaryRegisterReport() {
		return userService.salaryRegisterReport();
	}
	
	@GetMapping("/getExamsList")
	public ResponseEntity<JSONResponse<?>> getExamsList() {
		return examDataService.getExamList();
	}
	
	@PostMapping("/save-exams")
	public ResponseEntity<JSONResponse<?>> saveFeedback(@RequestBody  ExamDataVOList questionsAnswers) {
		try {
			ExamDataEntity entity =  examDataService.saveAnswers(questionsAnswers);
			return JsonUtil.convertSingleEntityToJson(entity);
			
		} catch (Throwable e) {
			e.printStackTrace();	
			return null;
		}
		
	}
	
	
	@GetMapping("/exam-list")
	public ResponseEntity<JSONResponse<?>> examlist() {
		return examDataService.examlist();
	}
	
	@GetMapping("/exam-detail-list/{id}")
	public ResponseEntity<JSONResponse<?>> examdetail(@PathVariable("id") String id) {
		return examDataService.examdetail(id);
	}
	
	
	@GetMapping("/list-questions")
	public ResponseEntity<JSONResponse<?>> questions() {
		try {
			return JsonUtil.convertIntoJson(qService.findAll());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/save-feedback")
	public ResponseEntity<JSONResponse<?>> saveFeedback(@RequestBody  QuestionsAnswersVOList questionsAnswers) {
		try {
			QuestionsAnswersEntity entity =  examDataService.saveAnswers(questionsAnswers);
			return JsonUtil.convertSingleEntityToJson(entity);
			
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/feedback-answer/{id}")
	public ResponseEntity<JSONResponse<?>> feedbackAnswer(@PathVariable("id") String id) {
		return examDataService.feedbackAnswer(id);
	}
	
	
	@GetMapping("/getstudentcount/")
	public ResponseEntity<JSONResponse<?>> getstudentcount() {
		return userService.getStudentCount();
	}

	
	@GetMapping("/getteachercount/")
	public ResponseEntity<JSONResponse<?>> getteachercount() {
		return userService.getTeacherCount();
	}
	
	
	@GetMapping("/getsalaries")
	public ResponseEntity<JSONResponse<?>> getsalaries() {
		return salaryService.getSalaryList();
	}
	
	@GetMapping("/getsalariesbyuser/{id}")
	public ResponseEntity<JSONResponse<?>> getsalariesbyuser(@PathVariable("id") String id) {
		return salaryService.getSalaryListbyid(id);
	}
	
	
	@GetMapping("/getreceivedsalary")
	public ResponseEntity<JSONResponse<?>> getsalaryreceived() {
		return salaryReceivedService.getSalaryReceivedList();
	}
	
	@GetMapping("/getsalaryby/{id}")
	public ResponseEntity<JSONResponse<?>> getsalarybyid(@PathVariable("id") String id) {
		return salaryReceivedService.getSalaryById(id);
	}
	
	@PostMapping("/save-salaries")
	public ResponseEntity<JSONResponse<?>> savesalaries(@RequestBody SalaryVO salary) {		
		return salaryService.saveUpdateSalary(salary);
	}
	
	@PostMapping("/save-salaries-received")
	public ResponseEntity<JSONResponse<?>> savesalaryreceived(@RequestBody SalaryReceivedVO salary) {		
		return salaryReceivedService.saveUpdateSalaryReceived(salary);
	}
	
	
	@GetMapping("/saveimage")
	public ResponseEntity<JSONResponse<?>> saveimage(@RequestBody CommonUserVO user) {
		
	
		
		String imagePath =System.getProperty("user.dir")
				+ File.separatorChar 
				+ FileUploadUtils.randomAlphaNumeric(10) 
				+ extention;
		try {
			

		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		return userService.saveImages(user,imagePath);
	}
	
	@GetMapping("/decrypt/{pwd}")
	public ResponseEntity<JSONResponse<?>> getdecoded(@PathVariable("pwd") String password) {
		return userService.getDecoded(password);
	}
}
