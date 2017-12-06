/**
 * 
 */
package com.vision.edu.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.edu.dto.BaseSchoolDTO;
import com.vision.edu.dto.BaseSchoolMsgDTO;
import com.vision.edu.dto.CampusInformationDTO;
import com.vision.edu.dto.GardenerDTO;
import com.vision.edu.dto.ParentingKnowledgeDTO;
import com.vision.edu.dto.PrincipalMsgDTO;
import com.vision.edu.entity.base.BaseParentingKnowledge;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.member.MemApplyRecord;
import com.vision.edu.entity.member.MemComment;
import com.vision.edu.entity.member.MemPraise;
import com.vision.edu.entity.system.SysPrincipalMailbox;
import com.vision.edu.service.base.IBaseMemberService;
import com.vision.edu.service.base.IBaseParentingKnowledgeService;
import com.vision.edu.service.base.IBaseSchoolInfoService;
import com.vision.edu.service.base.IBaseSchoolService;
import com.vision.edu.service.member.IMemApplyRecordService;
import com.vision.edu.service.member.IMemCommentService;
import com.vision.edu.service.member.IMemPraiseService;
import com.vision.edu.service.system.ISysPrincipalMailboxService;

/*
 * 
*@author:zyml
*@date:2017年7月5日下午9:24:04
*/
@RunWith(SpringJUnit4ClassRunner.class)   //使用junit进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class JunitTest {
	
	@Autowired
	private IBaseSchoolService baseSchoolService;
	
	@Autowired
	private IBaseSchoolInfoService baseSchoolInfoService;
	
	@Autowired
	private IBaseMemberService baseMemberService;  
	
	@Autowired
	private IBaseParentingKnowledgeService baseParentingKnowledgeService;
	
	@Autowired
	private ISysPrincipalMailboxService sysPrincipalMailboxService;
	
	@Autowired
	private IMemCommentService memCommentService;  //注入IMemCommentService
	
	@Autowired
	private IMemPraiseService memPraiseService;  //注入IMemPraiseService
	
	@Autowired
	private IMemApplyRecordService memApplyRecordService; //注入IMemApplyRecordService
	
	/**测试查询园所对应的地区信息
	*@author:zyml
	*@date:2017年7月5日下午9:35:12
	*/
	@Test
	public void TestSelectSchool() {
		List<BaseSchoolDTO> list=baseSchoolService.findSchoolList();
		for (BaseSchoolDTO baseSchoolPo:list) {
			System.out.println(baseSchoolPo.getSchoolName());
			System.out.println(baseSchoolPo.getDistrict());
		}
	}

	
	/**
	 *模糊查询学校的信息
	*@author:zyml
	*@date:2017年7月6日上午9:31:04
	*/
/*	@Test
	public void TestvagueQuerySchoolMsg() {
		String strschoolname="红";
		List<String> baseSchools = baseSchoolService.findSchool(strschoolname);
		for(String baseSchool:baseSchools){
			 System.out.println(baseSchool.getName());
		}
	}*/
	
	
	/**
	*根据学校名称查询学校的所有信息
	*@author:zyml
	*@date:2017年7月6日下午2:46:43
	*/
	@Test
	public void TestSchoolMsg() {
		String schoolName="红太阳幼儿园";
		BaseSchoolMsgDTO baseSchoolMsgPo=baseSchoolService.findSchoolMsg(schoolName);
		System.out.println("-----------------"+baseSchoolMsgPo.getTelephone()+"--------------------");

	}
	
	
	/**
	 *查询图片墙的信息
	*@author:zyml
	*@date:2017年7月6日下午3:23:36
	*/
	/*@Test
	public void TestPhotoWall() {
		List<BaseSchoolInfo> listPhoto=baseSchoolInfoService.findPhotoAll();
		for (BaseSchoolInfo baseSchoolInfo:listPhoto) {
			System.out.println(baseSchoolInfo.getCoverImages());
			System.out.println(baseSchoolInfo.getLink());
		}
	}*/
	
/*	*//**
	*根据图片的id进行查看图片详情
	*@author:zyml
	*@date:2017年7月7日下午3:24:36
	*//*
	@Test
	public void TestPhotoWallDetail() {
		String strCode="1596ab2ee2544a76ba36469e510fea7c";
		BaseSchoolInfo photoWallDetail=baseSchoolInfoService.findPhotoAllDetail(strCode);
		System.out.println("===================="+photoWallDetail.getContent()+"====================");

	}
*/
	/**
	 *查询公告标题信息
	*@author:zyml
	*@date:2017年7月6日下午3:51:25
	*/
	/*@Test
	public void TestAdvertisTitle() {
		int info_type=2;
		List<BaseSchoolInfo> listAdv=baseSchoolInfoService.findAdvertisTitle(info_type);
		for (BaseSchoolInfo baseSchoolInfo:listAdv) {
			 System.out.println(baseSchoolInfo.getTitle());
			 System.out.println(baseSchoolInfo.getInfoType());
			 
		}
	}*/
	
	/**
	*查询公告详情的信息
	*@author:zyml
	*@date:2017年7月7日上午9:44:35
	*/
	/*@Test
	public void TestAdvDetail() {
		String strCode="1596ab2ee2544a76ba36469e510fea7c";
		BaseSchoolInfo baseSchool=baseSchoolInfoService.findAdvertisDetail(strCode);
		System.out.println("==========="+baseSchool.getContent()+"===========");
	}*/
	
	/**
	*查看资讯最新的基本信息
	*@author:zyml
	*@date:2017年7月7日下午4:43:48
	*/
	/*@Test
	public void TestZixunBase() {
		int info_type=2;
		List<BaseSchoolInfo> zixunBase=baseSchoolInfoService.findInforMation(info_type);
		for (BaseSchoolInfo baseSchoolInfo:zixunBase) {
			 System.out.println(baseSchoolInfo.getTitle());
			 System.out.println(baseSchoolInfo.getInfoType());
			 
		}
		
	}*/
	
	/**
	*查询资讯的详情上部分
	*@author:zyml
	*@date:2017年7月8日下午8:24:44
	*/
	/*@Test
	public void TestZixunBaseOne() {
		String strCode="1b0421ac5a8d404cbb4671587731fc96";
		BaseSchoolInfo zixunBaseOne=baseSchoolInfoService.findInforMationDetail(strCode);
		System.out.println("============================================");
		System.out.println(zixunBaseOne.getTitle());
		System.out.println(zixunBaseOne.getContent());
		System.out.println(zixunBaseOne.getCoverImages());
		System.out.println("============================================");
	}*/
	
	/**
	*查询资讯的详情下部分
	*@author:zyml
	*@date:2017年7月8日下午9:19:27
	*/
/*	@Test
	public void TestZixunBaseTwo() {
		String strCode="1596ab2ee2544a76ba36469e510fea7c";
		List<CampusInformationDTO> listZixunBaseTwo=baseSchoolInfoService.findInforMationDetailNext(strCode);
		for (CampusInformationDTO listBaseSchoolInfo:listZixunBaseTwo) {
			System.out.println(listBaseSchoolInfo.getPcount());
		}
	}*/
	
	
	/**
	 *查询主题活动的最新信息
	*@author:zyml
	*@date:2017年7月6日下午4:20:34
	*/
	@Test
	public void TestThemeAct() {
		String strCode="1b0421ac5a8d404cbb4671587731fc92";
		int info_type=3;
		List<BaseSchoolInfo> listThemeAct=baseSchoolInfoService.findAllThemeAct(strCode,info_type);
		for (BaseSchoolInfo baseSchoolInfo:listThemeAct) {
			System.out.println(baseSchoolInfo.getTitle());
			System.out.println(baseSchoolInfo.getIntro());
			System.out.println(baseSchoolInfo.getCreateTime());
		}
	}
	
	
	/**
	*根据id进行查询资讯的详情
	*@author:zyml
	*@date:2017年7月9日上午9:16:53
	*/
/*	@Test
	public void TestThemeActDetail() {
		String strCode="1b0421ac5a8d404cbb4671587731fc92";
		BaseSchoolInfo themActDetail=baseSchoolInfoService.findAllThemeActDetailById(strCode);
		System.out.println(themActDetail.getContent());
		System.out.println(themActDetail.getUpdateMan());

	}*/
	
	
	
	/**
	*查询新闻信息
	*@author:zyml
	*@date:2017年7月6日下午4:20:34
	*/
	@Test
	public void TestNews() {
		List<BaseSchoolInfo> listThemeAct=baseSchoolInfoService.findAllNews();
		for (BaseSchoolInfo baseSchoolInfo:listThemeAct) {
			System.out.println(baseSchoolInfo.getContent());
			System.out.println(baseSchoolInfo.getTitle());
			System.out.println(baseSchoolInfo.getIntro());
			System.out.println(baseSchoolInfo.getCreateTime());
		}
	}
	
	
	/**
	*根据学校id查询园长风采的基本信息
	*@author:zyml
	*@date:2017年7月9日上午11:08:59
	*/
	/*@Test
	public void TestYuanZhangFengCaiBaseById() {
		String strSchoolId="1";
		String roleId="1";
		PrincipalMsgDTO principalMsgPo=baseMemberService.findPrincipalById(strSchoolId, roleId);
		System.out.println(principalMsgPo.getIntro());
	}*/
	
	/**通过园长的id查询园长的详细信息*/
	/*
	*@author:zyml
	*@date:2017年7月9日下午2:37:23
	*/
/*	@Test
	public void TestfindPrincipalDetailByUserId() {
		String userId="1596ab2ee2544a76ba36469e510fea7c";
		String sourceId="1596ab2ee2544a76ba36469e510fea7c";
		PrincipalMsgDTO principalMsgPo=baseMemberService.findPrincipalDetailByUserId(userId, sourceId);
		System.out.println(principalMsgPo.getUserName());
		System.out.println(principalMsgPo.getPcount());
	}*/
	
	
	/**
	 *查询一个园校所有老师的基本信息
	*@author:zyml
	*@date:2017年7月9日下午4:08:07
	*/
	/*@Test
	public void TestfindListTeacher() {
		String strCode="1";
		List<GardenerDTO> listTeacher=baseMemberService.findListTeacher(strCode);
		for (GardenerDTO gardenerPo:listTeacher) {
			System.out.println(gardenerPo.getSchoolName());
		}

	}*/
	
	/**
	*根据园丁的id查询园丁的详细信息
	*@author:zyml
	*@date:2017年7月9日下午5:50:34
	*/
	/*@Test
	public void TestFindListTeacherDetailById() {
		String strCode="1";
		GardenerDTO gardenerPo=baseMemberService.findListTeacherDetailById(strCode);
		System.out.println(gardenerPo.getHeadPortrait());
	}*/

	
	/**
	*查询育儿知识的基本信息的集合
	*@author:zyml
	*@date:2017年7月10日上午9:07:08
	*/
	/*@Test
	public void TestfindParentingKnowledge() {
		String schoolId="1";
		List<ParentingKnowledgeDTO> listParentingKnowledge=baseParentingKnowledgeService.findParentingKnowledge(schoolId);
		for (ParentingKnowledgeDTO parentingKnowledgePo:listParentingKnowledge) {
			System.out.println(parentingKnowledgePo.getPointCount());
		}
	}
	*/
	
	/**
	*根据育儿知识id进行育儿知识详情查看
	*@author:zyml
	*@date:2017年7月10日上午9:51:57
	*//*
	@Test
	public void TestfindParentingKnowledgeDetailById() {
		String knowId="2";
		ParentingKnowledgeDTO parentingKnowledgePo=baseParentingKnowledgeService.findParentingKnowledgeDetailById(knowId);
		System.out.println(parentingKnowledgePo.getTitle());
	}
	*/
	
	
	/**
	*根据育儿知识id查看相应的评论信息
	*@author:zyml
	*@date:2017年7月10日上午10:30:51
	*@param knowId 育儿知识id
	*/
	/*@Test
	public void TestfindParentingKnowledgeCommentById() {
		String knowId="1596ab2ee2544a76ba36469e510fea7c";
		List<ParentingKnowledgeDTO> lsitParentingKnowledgePo=baseParentingKnowledgeService.findParentingKnowledgeCommentById(knowId);
		for (ParentingKnowledgeDTO parentingKnowledgePo:lsitParentingKnowledgePo) {
			System.out.println(parentingKnowledgePo.getUserName());
		}
	}
	
	*//**
	 *根据学校的id查询学校的详细信息
	*@author:zyml
	*@date:2017年7月10日下午2:47:08
	*/
	/*@Test
	public void TestFindSchoolMsgDetail() {
		String strSchoolId="1";
		BaseSchoolMsgDTO baseSchoolMsgPo=baseSchoolService.findSchoolMsgDetail(strSchoolId);
		System.out.println(baseSchoolMsgPo.getName());
	}*/
	
	/**
	*新增园长新箱信息
	*@author:zyml
	*@date:2017年7月10日下午4:52:13
	*/
	@Test
	public void TestInsertPricalMsg() {
		SysPrincipalMailbox sysPrincipalMailbox=new SysPrincipalMailbox();
		sysPrincipalMailbox.setFatherId("1");
		sysPrincipalMailbox.setSenderId("2");
		sysPrincipalMailbox.setLetterContent("zhangyi");
		sysPrincipalMailbox.setRecipientId("1");
		sysPrincipalMailbox.setSenderType(1);
		sysPrincipalMailboxService.addPrincipal(sysPrincipalMailbox);
	}
	
	
	/**
	*新增育儿知识详情评论
	*@author:zyml
	*@date:2017年7月10日下午6:01:10
	*@param MemComment 评论实体
	*/
	@Test
	public void TestaddYunErKnowComment() {
		MemComment memComment=new MemComment();
		memComment.setSourceId("1b0421ac5a8d404cbb4671587731fc98");
		memComment.setUpdateMan("张毅");
		boolean inserttb=memCommentService.insert(memComment);

	}
	
	
	/**
	*新增育儿知识评论的点赞记录
	*@author:zyml
	*@date:2017年7月11日上午8:18:17
	*/
	@Test
	public void TestAddCommentParise() {
		MemPraise memPraise=new MemPraise();
		memPraise.setMemberId("test");
		memPraise.setCreateTime(new Date());
		memPraise.setPraiseType(1);
		memPraise.setSourceId("64f4566c600645799a751bc50ffc47f6");
		memPraise.setCancelNo(1);
		memPraise.setUpdateTime(new Date());
		memPraise.setUpdateMan("zhangmei");
		memPraise.setDeleteFlag(1);
		boolean tbmemparise=memPraiseService.insert(memPraise);
		System.out.println(tbmemparise);
	}
	
	
	/**
	*育儿知识点赞数的增加,更新一条数据
	*@author:zyml
	*@date:2017年7月11日上午9:20:59
	*/
	/*@Test
	public void TestupdateYunErKnow() {
		String knowId="1";
		ParentingKnowledgeDTO parentingKnowledgePo=baseParentingKnowledgeService.findParentingKnowledgeDetailById(knowId);
		Integer pariseCount=parentingKnowledgePo.getPointCount();
	    int newPariseCount=pariseCount+1;
		System.out.println("==================="+newPariseCount+"===========");
		BaseParentingKnowledge baseParentingKnowledge=new BaseParentingKnowledge();
		baseParentingKnowledge.setId(knowId);
		baseParentingKnowledge.setPointCount(newPariseCount);
		boolean tb=baseParentingKnowledgeService.updateById(baseParentingKnowledge);
		System.out.println(tb);
		System.out.println("==========="+parentingKnowledgePo.getPointCount() +"==========");
	}*/
	
	
	
	/**
	*育儿知识浏览量的增加 
	*@author:zyml
	*@date:2017年7月11日上午10:12:38
	*/
/*	@Test
	public void TestYuErKnowLiuLanLiang() {
		String knowId="1";
		ParentingKnowledgeDTO parentingKnowledgePo=baseParentingKnowledgeService.findParentingKnowledgeDetailById(knowId);
		Integer browse_count=parentingKnowledgePo.getBrowseCount();
		System.out.println("--------------"+browse_count+"------------------");
		Integer newBrowCount=browse_count+1;
		BaseParentingKnowledge baseParentingKnowledge=new BaseParentingKnowledge();
		baseParentingKnowledge.setId(knowId);
		baseParentingKnowledge.setBrowseCount(newBrowCount);
		boolean tb=baseParentingKnowledgeService.updateById(baseParentingKnowledge);
		System.out.println("============"+newBrowCount+"================");
	}*/
	
	/**
	*园丁点赞数的增加
	*@author:zyml
	*@date:2017年7月11日上午11:27:34
	*/
/*	@Test
	public void TestAddTeacherParise() {
		String strCode="1";
		GardenerDTO gardenerPo=baseMemberService.findListTeacherDetailById(strCode);
		MemPraise memPraise=new MemPraise();
		memPraise.setMemberId("1");
		memPraise.setCreateTime(new Date());
		memPraise.setPraiseType(1);
		memPraise.setSourceId(strCode);
		memPraise.setCancelNo(1);
		memPraise.setUpdateTime(new Date());
		memPraise.setUpdateMan("zhagnyi");
		memPraise.setDeleteFlag(1);
		memPraiseService.insert(memPraise);
	}*/
	
	
	/**
	*新增园长的点赞信息
	*@author:zyml
	*@date:2017年7月11日下午7:38:29
	*/
	@Test
	public void TestAddPrincipalParise() {
		MemPraise memPraise=new MemPraise();
		memPraise.setMemberId("12");
		memPraise.setCreateTime(new Date());
		memPraise.setPraiseType(1);
		memPraise.setSourceId("64f4566c600645799a751bc50ffc47f8");
		memPraise.setCancelNo(1);
		memPraise.setUpdateTime(new Date());
		memPraise.setUpdateMan("zhangmei");
		memPraise.setDeleteFlag(1);
		boolean tb=memPraiseService.insert(memPraise);
		System.out.println(tb);
	}
	
	/**
	*新增报名信息
	*@author:zyml
	*@date:2017年7月11日下午8:41:03
	*/
	@Test
	public void TestaddActBaoMing() {
		MemApplyRecord memApplyRecord=new MemApplyRecord();
		memApplyRecord.setMemberId("1");
		memApplyRecord.setResourcesType(1);
		memApplyRecord.setResourcesId("64f4566c600645799a751bc50ffc47f8");
		memApplyRecord.setName("meiling");
		memApplyRecord.setSex(1);
		memApplyRecord.setPhoneNum("13005678479");
		memApplyRecord.setCreateTime(new Date());
		memApplyRecord.setDeleteFlag(1);
		memApplyRecord.setRemark("aaa");
		boolean tb=this.memApplyRecordService.insert(memApplyRecord);
		System.out.println(tb);
	}
	
	
	
	/**
	*资讯点赞数的增加 
	*@author:zyml
	*@date:2017年7月12日上午8:20:24
	*@param BaseSchoolInfo 校园资讯点赞增加
	*/
	/*@Test
	public void TestAddZiXunDianZanNums() {
		String strCode="b340767b5e9b47d2ae45e6f6e740ca17";
		BaseSchoolInfo inforMationDetail=baseSchoolInfoService.findInforMationDetail(strCode);
		Integer pointCount=inforMationDetail.getPointCount();
		System.out.println("==========="+pointCount+"==============");
		Integer newPointCount=pointCount+1;
		BaseSchoolInfo baseSchoolInfo =new BaseSchoolInfo();
		baseSchoolInfo.setId(strCode);
		baseSchoolInfo.setPointCount(newPointCount);
		boolean tb=baseSchoolInfoService.updateById(baseSchoolInfo);
		System.out.println(tb);
		System.out.println("================"+inforMationDetail.getPointCount()+"=================");

	}*/
	
	/**
	*资讯浏览量的增加
	*@author:zyml
	*@date:2017年7月12日上午9:09:24
	*@param BaseSchoolInfo 校园资讯实体
	*/
	/*@Test
	public void TestaddZiXunLiuLanCount() {
		String strCode="b340767b5e9b47d2ae45e6f6e740ca17";
		BaseSchoolInfo inforMationDetail=baseSchoolInfoService.findInforMationDetail(strCode);
		Integer browCount=inforMationDetail.getBrowseCount();
		System.out.println("================="+browCount+"=====================");
		Integer newBrowCount=browCount+1;
		BaseSchoolInfo baseSchoolInfo=new BaseSchoolInfo();getClass();
		baseSchoolInfo.setId(strCode);
		baseSchoolInfo.setBrowseCount(newBrowCount);
		boolean tb=baseSchoolInfoService.updateById(baseSchoolInfo);
		System.out.println("================="+newBrowCount+"=====================");
	}*/
	
	/**
	*资讯评论点赞数的增加
	*@author:zyml
	*@date:2017年7月12日上午9:32:56
	*@param MemPraise 点赞实体
	*/
	/*@Test
	public void TestAddZiXunCommentParise() {
		String strCode="1b0421ac5a8d404cbb4671587731fc96";
		BaseSchoolInfo zixunBaseOne=baseSchoolInfoService.findInforMationDetail(strCode);
		MemPraise memPraise=new MemPraise();
		memPraise.setId(strCode);
		memPraise.setMemberId(strCode);
		memPraise.setCreateTime(new Date());
		memPraise.setPraiseType(1);
		memPraise.setSourceId(strCode);
		memPraise.setCancelNo(1);
		memPraise.setUpdateTime(new Date());
		memPraise.setUpdateMan("admin");
		memPraise.setDeleteFlag(1);
		boolean tb=memPraiseService.insert(memPraise);
		System.out.println(tb);

	}
	*/
}
