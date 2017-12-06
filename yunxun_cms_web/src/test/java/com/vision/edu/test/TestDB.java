package com.vision.edu.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.dto.BabySurrogateDTO;
import com.vision.edu.dto.BaseBabySurrogateDTO;
import com.vision.edu.dto.BaseSchoolInfoTwoDTO;
import com.vision.edu.dto.ParentBaseMemberDTO;
import com.vision.edu.dto.SysRecipeBankDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseDuties;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.base.BaseSurrogate;
import com.vision.edu.entity.member.MemBabySurrogate;
import com.vision.edu.entity.member.MemMemberGroup;
import com.vision.edu.entity.member.MemParentBaby;
import com.vision.edu.entity.system.SysRecipeBank;
import com.vision.edu.enums.EnumInfoType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseBabyService;
import com.vision.edu.service.base.IBaseDutiesService;
import com.vision.edu.service.base.IBaseSchoolInfoService;
import com.vision.edu.service.base.IBaseSchoolService;
import com.vision.edu.service.base.IBaseSurrogateService;
import com.vision.edu.service.member.IMemBabySurrogateService;
import com.vision.edu.service.member.IMemMemberGroupService;
import com.vision.edu.service.member.IMemParentBabyService;
import com.vision.edu.service.system.ISysRecipeBankService;

/**
 * crud测试
 * 
 * @author XieFan
 * @date 2017年7月4日 下午8:39:07
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestDB {

	@Autowired
	private IBaseDutiesService baseDutiesService;
	@Autowired
	private IBaseSchoolInfoService baseSchoolInfoService;
	@Autowired
	private IBaseSchoolService baseSchoolService;

	/*
	 * @Before public void before(){
	 * 
	 * @SuppressWarnings("resource") ApplicationContext context = new
	 * ClassPathXmlApplicationContext(new
	 * String[]{"classpath:applicationContext.xml"}); baseDutiesService =
	 * (IBaseDutiesService) context.getBean("baseDutiesServiceImpl"); }
	 */
	// 单条新增
	public void insert() {
		BaseDuties baseDuties = new BaseDuties();
		baseDuties.setCreateMam("谢帆");
		baseDuties.setCreateTime(new Date());
		baseDuties.setDeleteFlag2(0);
		baseDuties.setDescription("12321");
		baseDuties.setDutiesName("haode");
		baseDuties.setSchoolId("2313123123213");
		baseDuties.setUpdateMan("谢帆");
		baseDuties.setUpdateTime(new Date());
		boolean insertb = baseDutiesService.insert(baseDuties);
		String s = baseDuties.getId();// controller null serviceImpl 可以获取
		System.out.println(insertb);
	}

	// 批量新增
	public void insertBatch() {
		BaseDuties baseDuties = new BaseDuties();
		baseDuties.setCreateMam("xf");
		baseDuties.setCreateTime(new Date());
		baseDuties.setDeleteFlag2(0);
		baseDuties.setDescription("qweytu");
		baseDuties.setDutiesName("2132123");
		baseDuties.setSchoolId("adgasdjasgdasg");
		baseDuties.setUpdateMan("尽快哈斯柯");
		baseDuties.setUpdateTime(new Date());

		BaseDuties baseDuties1 = new BaseDuties();
		baseDuties1.setCreateMam("XieFan");
		baseDuties1.setCreateTime(new Date());
		baseDuties1.setDeleteFlag2(0);
		baseDuties1.setDescription("123");
		baseDuties1.setDutiesName("haode");
		baseDuties1.setSchoolId("2313123123213");
		baseDuties1.setUpdateMan("尽快哈市科技");
		baseDuties1.setUpdateTime(new Date());

		List<BaseDuties> baseDutieses = new ArrayList<BaseDuties>();
		baseDutieses.add(baseDuties);
		baseDutieses.add(baseDuties1);

		boolean insertbs = baseDutiesService.insertBatch(baseDutieses);
		System.out.println(insertbs);
	}

	// 修改
	public void update() {
		BaseDuties baseDuties = new BaseDuties();
		// baseDuties.setCreateMam("谢帆");
		baseDuties.setCreateTime(new Date());
		baseDuties.setDeleteFlag2(0);
		baseDuties.setDescription("123");
		baseDuties.setDutiesName("123123");
		baseDuties.setSchoolId("qweqwe");
		baseDuties.setUpdateMan("谢帆");
		baseDuties.setUpdateTime(new Date());
		baseDuties.setId("40d584c24b5742d1912d4bb183fb21e6");
		// boolean updateb = baseDutiesService.updateById(baseDuties);//修改需要修改的列
		baseDutiesService.updateAllColumnById(baseDuties);// 修改所有列
		// System.out.println(updateb);
	}

	// 批量修改
	public void updateBatch() {
		BaseDuties baseDuties = new BaseDuties();
		baseDuties.setCreateMam("xf");
		baseDuties.setCreateTime(new Date());
		baseDuties.setDeleteFlag2(0);
		baseDuties.setDescription("qweytu");
		baseDuties.setDutiesName("2132123");
		baseDuties.setSchoolId("adgasdjasgdasg");
		baseDuties.setUpdateMan("尽快哈斯柯");
		baseDuties.setUpdateTime(new Date());
		baseDuties.setId("");

		BaseDuties baseDuties1 = new BaseDuties();
		baseDuties1.setCreateMam("XieFan");
		baseDuties1.setCreateTime(new Date());
		baseDuties1.setDeleteFlag2(0);
		baseDuties1.setDescription("123");
		baseDuties1.setDutiesName("haode");
		baseDuties1.setSchoolId("2313123123213");
		baseDuties1.setUpdateMan("尽快哈市科技");
		baseDuties1.setUpdateTime(new Date());
		baseDuties1.setId("");

		List<BaseDuties> baseDutieses = new ArrayList<BaseDuties>();
		baseDutieses.add(baseDuties);
		baseDutieses.add(baseDuties1);

		boolean updatebs = baseDutiesService.updateBatchById(baseDutieses);
		System.out.println(updatebs);
	}

	// 删除
	public void delete() {
		boolean deleteb = baseDutiesService.deleteById("c48b6b8cb97c46acaa6cd81a5fb9b131");
		System.out.println(deleteb);
	}

	public void select1() {
		EntityWrapper ew = new EntityWrapper();
		ew.setEntity(new BaseDuties());
		ew.where("id = {0}", "");
		
		EntityWrapper<BaseDuties> ew1 = new EntityWrapper<BaseDuties>();
	}


	@Test
	public void testMethod() {

//		List<BaseSchool> schoolList = baseSchoolService.findSchoolBySchoolName("红星");
//		System.out.println(schoolList.size());
		
		List<BaseSchool> list =	 null;
		EntityWrapper<BaseSchool> ew = new EntityWrapper<BaseSchool>();
	    list = baseSchoolService.selectList(ew);
		int j = list.size();
		for (int i = 0; i < j; i++) {
			System.out.println(list.get(i).getName());
		}
	}
	
    @Autowired
    private IBaseBabyService baseBabyService;
    @Autowired
    private IMemParentBabyService memParentBabyService;
    @Autowired
    private IBaseSurrogateService baseSurrogateService;
    @Autowired
    private IMemBabySurrogateService memBabySurrogateService;
    @Autowired
    private IMemMemberGroupService memMemberGroupService;
	@Test
	public void test(){
		Page<BaseSchoolInfoTwoDTO> page =new Page<BaseSchoolInfoTwoDTO>(1,10);
   	 String  startTime="2017-07-05 16:54:15";
   	 String endTime="2017-07-05 16:54:15";
   	//List<BaseSchoolInfoTwoDTO> baseSchoolInfo= baseSchoolInfoService.findBaseYuanSuoPage(page, startTime, endTime);
      // System.out.println(baseSchoolInfo);
	}
	
}  
