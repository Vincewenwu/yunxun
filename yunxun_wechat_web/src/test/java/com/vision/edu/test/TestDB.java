package com.vision.edu.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vision.edu.entity.base.BaseDuties;
import com.vision.edu.entity.member.MemGrowth;
import com.vision.edu.service.base.IBaseDutiesService;
import com.vision.edu.service.member.IMemGrowthService;

/**
 * crud测试
 * @author XieFan
 * @date 2017年7月4日 下午8:39:07
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试 
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) 
public class TestDB {
	
	@Autowired
	private IBaseDutiesService baseDutiesService;

	
/*	@Before
	public void before(){                                                                    
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});
		baseDutiesService = (IBaseDutiesService) context.getBean("baseDutiesServiceImpl");
	}
	*/
	//单条新增
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
		String s = baseDuties.getId();//controller null  serviceImpl 可以获取
		System.out.println(insertb);
	}
	
	//批量新增
	public void insertBatch(){
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
	
	//修改
	public void update(){
		BaseDuties baseDuties = new BaseDuties();
		//baseDuties.setCreateMam("谢帆");
		baseDuties.setCreateTime(new Date());
		baseDuties.setDeleteFlag2(0);
		baseDuties.setDescription("123");
		baseDuties.setDutiesName("123123");
		baseDuties.setSchoolId("qweqwe");
		baseDuties.setUpdateMan("谢帆");
		baseDuties.setUpdateTime(new Date());
		baseDuties.setId("40d584c24b5742d1912d4bb183fb21e6");
		//boolean updateb = baseDutiesService.updateById(baseDuties);//修改需要修改的列
		baseDutiesService.updateAllColumnById(baseDuties);//修改所有列
		//System.out.println(updateb);
	}
	
	//批量修改
	public void updateBatch(){
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
	
	//删除
	public void delete(){
		boolean deleteb = baseDutiesService.deleteById("c48b6b8cb97c46acaa6cd81a5fb9b131");
		System.out.println(deleteb);
	}
	
	@Test
	public void select1(){
		EntityWrapper<BaseDuties> ew = new EntityWrapper<BaseDuties>();
		ew.setEntity(new BaseDuties());
		ew.where("id = {0}", "");
		System.out.println(ew);
	}
}
