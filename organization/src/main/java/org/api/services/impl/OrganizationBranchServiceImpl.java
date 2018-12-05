package org.api.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import org.apache.log4j.Logger;
import org.api.model.jpa.dao.JPAOrganizationBranchDAO;
import org.api.model.jpa.entity.OrganizationBranchEntity;
import org.api.util.RestUtil;
import org.api.vo.OrganizationBranchVO;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.core.util.DateUtils;
import org.core.util.FileUploadUtils;
import org.core.util.JsonUtil;
import org.core.view.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("OrganizationBranchService")
public class OrganizationBranchServiceImpl extends CRUDServiceImpl<OrganizationBranchEntity, OrganizationBranchVO>
		implements OrganizationBranchService {
	


	private static String URL_API_HOST = "http://localhost:8080";
	//private static String URL_API_HOST = "http://jpcloudusa004.nshostserver.net:33226";
	private static final String URL_LOCATION_API = URL_API_HOST+"/locations/locationData/";
	private static final String URL_USERS_API = URL_API_HOST+"/users/user/";
	private static final String JSON_VALUE_KEY = "value";

	@Autowired
	private JPAOrganizationBranchDAO branchesRepo;
	@Autowired
	private RestTemplateService restTemplateService;

	private Logger logger = Logger.getLogger(this.getClass());
	Date currentTime = DateUtils.getCurrentDateTime();
	private RestUtil util = new RestUtil();
	private BeanUtils beanUtil = new BeanUtils();

	
	public OrganizationBranchServiceImpl(BaseDAO<OrganizationBranchEntity, Serializable> dao) {
		super(dao);
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(OrganizationBranchVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, OrganizationBranchEntity.class);

	}

	@Override
	public <ENTITY extends BaseEntity> OrganizationBranchVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, OrganizationBranchVO.class);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getCustomBranchData() {
		Collection<OrganizationBranchEntity> branchesList = new ArrayList<OrganizationBranchEntity>();
		Collection<OrganizationBranchEntity> branches = branchesRepo.findAll();

		for (OrganizationBranchEntity branch : branches) {
			OrganizationBranchEntity branchEntity = new OrganizationBranchEntity();
			branchEntity.setId(branch.getId());
			branchEntity.setName(branch.getName());
			branchEntity.setLat(branch.getLat());
			branchEntity.setLng(branch.getLng());

			branchEntity.setCreatedBy(branch.getCreatedBy());
			branchEntity.setCreatedOn(branch.getCreatedOn());
			branchEntity.setStatus(branch.getStatus());
			branchEntity.setLastUpdatedBy(branch.getLastUpdatedBy());
			branchEntity.setLastUpdatedOn(branch.getLastUpdatedOn());
			branchEntity.setOrganizationId(branch.getOrganizationId());

			String location = getJsonData(JSON_VALUE_KEY, branch.getLocation(),
					URL_LOCATION_API + branch.getLocation());
			String nigran = getJsonData("name", branch.getLocation(), URL_USERS_API + branch.getNigranid());

			branchEntity.setNigran(nigran);
			branchEntity.setLocation(location);

			branchesList.add(branchEntity);
		}

		return util.convertIntoJson(branchesList);

	}

	public String getJsonData(String jsonKey, String searchId, String url) {
		try {
			String result = restTemplateService.consumeRestCall(url);

			if (result != null && !"".equals(result))
				return util.getJsondata(jsonKey, result);
			else
				return "";

		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getNigrans(Long id) {
		Collection<OrganizationBranchEntity> branches = branchesRepo.findByNigranid(id);
		List<OrganizationBranchEntity> listBranches = new ArrayList<OrganizationBranchEntity>();

		branches.forEach(item -> {
			try {

				item = beanUtil.shallowCopy(item, OrganizationBranchEntity.class);
				String location = getJsonData(JSON_VALUE_KEY, item.getLocation(),
						URL_LOCATION_API + item.getLocation());
				String nigran = getJsonData("name", item.getLocation(), URL_USERS_API + item.getNigranid());

				item.setNigran(nigran);
				item.setLocation(location);

				listBranches.add(item);

			} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
			}
		});

		return util.convertIntoJson(listBranches);
	}

	
	@Override
	public ResponseEntity<JSONResponse<?>> saveUpdate(OrganizationBranchVO branch, String imageath) {
		OrganizationBranchEntity branchEntity;
		try {
			
			
			try {
				if (branch.getImage() != null) {
					byte[] byteImage = FileUploadUtils.decode(branch.getImage());
					String path = FileUploadUtils.UploadFile(byteImage, imageath);
					path = path.split("web")[2];
					branch.setImage(path);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			
			try {
				if (branch.getImageString() != null) {
					byte[] byteImage = FileUploadUtils.decode(branch.getImageString());
					String path = FileUploadUtils.UploadFile(byteImage, imageath);
					path = path.split("web")[2];
					branch.setImage(path);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			branchEntity = BeanUtils.shallowCopy(branch, OrganizationBranchEntity.class);
			branchEntity.setCreatedOn(currentTime);
			branchEntity.setLastUpdatedOn(currentTime);
			OrganizationBranchEntity savedBranch = null;//branchesRepo.save(branchEntity);
			
			return JsonUtil.convertSingleEntityToJson(savedBranch);

		} catch (Exception e) {
			logger.error("ERROR=>"+e.getLocalizedMessage());
			return null;
		}
	}

	
	@Override
	public ResponseEntity<JSONResponse<?>> ListBranchesByLocation(List<String>locationIds) throws Exception{
		
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		/*	String sql = "  select " + 
						"   s.id, " + 
						"		s.salarydate, " + 
						"    r.status, " + 
						"    s.createdOn " + 
						" from salary s" + 
						" left join salary_received r on r.salaryId = s.id " + 
						" and userId = :q1 ";
				
				EntityManager enityManager = entityManagerFactory.createEntityManager();

				Query query = (Query) enityManager.createNativeQuery(sql);
				query.setParameter("q1", id);

				List<Object[]> attendanceRecords =  query.getResultList();
				List<OrganizationBranchVO> listObject = new ArrayList<>();

				attendanceRecords.forEach(datalist -> {
					
					OrganizationBranchVO obj = new OrganizationBranchVO();
					
					obj.setId((long)datalist[0]);
					//obj.setLastUpdatedOn((String)datalist[0]);
					obj.setStatus((String)datalist[0]);
					obj.setCreatedBy((String)datalist[0]);
					obj.setName((String)datalist[0]);
					obj.setLocation((String)datalist[0]);
					obj.setLat((String)datalist[0]);
					obj.setLng((String)datalist[0]);
					obj.setNigranid((long)datalist[0]);
					//obj.setOrganizationId((int)datalist[0]);
					obj.setImage((String)datalist[0]);
					obj.setLocationLabel((String)datalist[0]);
					obj.setAreaHeadName((String)datalist[0]);
					obj.setFirstWitnessName((String)datalist[0]);
					
					obj.setStatus((String)datalist[2]);
					//obj.setCreatedOn((java.sql.Date)datalist[3]);
					
					listObject.add(obj);		
					
				});

				return JsonUtil.convertIntoJson(listObject);*/
				
				
			Collection<OrganizationBranchEntity> listBranches = branchesRepo.findByLocationIn(locationIds);
			Collection<OrganizationBranchEntity> branches =new ArrayList<OrganizationBranchEntity>();
			listBranches.forEach(branch-> {
				try {
					OrganizationBranchEntity branchEnitity = BeanUtils.shallowCopy(branch, OrganizationBranchEntity.class);
					String location = getJsonData(JSON_VALUE_KEY, branch.getLocation(),	URL_LOCATION_API + branch.getLocation());
					branchEnitity.setLocation(location);
					branches.add(branchEnitity);
				} catch (Exception e) {
					logger.error("ERROR=>"+e.getLocalizedMessage());
				}
			});
			return JsonUtil.convertIntoJson(branches);

	}

}
