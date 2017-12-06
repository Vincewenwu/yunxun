
package com.vision.edu.service.base.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.BabySurrogateDTO;
import com.vision.edu.dto.BaseBabySchoolDTO;
import com.vision.edu.dto.BaseParentingKnowledgeDTO;
import com.vision.edu.dto.PreantInfomationDTO;
import com.vision.edu.dto.apiVo.BabyPo;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.entity.base.BaseGroup;
import com.vision.edu.entity.base.BaseMember;
import com.vision.edu.entity.base.BaseParentingKnowledge;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.entity.base.BaseSurrogate;
import com.vision.edu.entity.member.MemBabyCards;
import com.vision.edu.entity.member.MemBabySurrogate;
import com.vision.edu.entity.member.MemMember;
import com.vision.edu.entity.member.MemMemberGroup;
import com.vision.edu.entity.member.MemParentBaby;
import com.vision.edu.enums.EnumBabyState;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.mapper.base.BaseBabyMapper;
import com.vision.edu.mapper.base.BaseGroupMapper;
import com.vision.edu.mapper.base.BaseMemberMapper;
import com.vision.edu.mapper.base.BaseParentingKnowledgeMapper;
import com.vision.edu.mapper.base.BaseSchoolMapper;
import com.vision.edu.mapper.base.BaseSurrogateMapper;
import com.vision.edu.mapper.member.MemBabyCardsMapper;
import com.vision.edu.mapper.member.MemBabySurrogateMapper;
import com.vision.edu.mapper.member.MemMemberGroupMapper;
import com.vision.edu.mapper.member.MemMemberMapper;
import com.vision.edu.mapper.member.MemParentBabyMapper;
import com.vision.edu.service.base.IBaseBabyService;
import com.xiaoleilu.hutool.date.DateUtil;

/**
 * <p>
 * 宝贝表 服务实现类
 * </p>
 * @author XieFan
 * @since 2017-07-03
 */
@Service
public class BaseBabyServiceImpl extends ServiceImpl<BaseBabyMapper, BaseBaby> implements IBaseBabyService {
	@Autowired
	private BaseBabyMapper baseBabyMapper;
	@Autowired
	private BaseSurrogateMapper baseSurrogateMapper;
	@Autowired
	private MemBabySurrogateMapper memBabySurrogateMapper;
	@Autowired
	private MemBabyCardsMapper memBabyCardsMapper;

	@Autowired
	private BaseGroupMapper baseGroupMapper;
	@Autowired
	private MemMemberGroupMapper memMemberGroupMapper;
	@Autowired
	private BaseParentingKnowledgeMapper baseParentingKnowledgeMapper;

	@Autowired
	private BaseSchoolMapper baseSchoolMapper;

	@Autowired
	private MemMemberMapper memMemberMapper;

	@Autowired
	private BaseMemberMapper baseMemberMapper;
	@Autowired
	private MemParentBabyMapper memParentBabyMapper;
	
	@Autowired
	private MemBabyCardsMapper nemBabyCardsMapper;

	/**
	 * 查宝贝信息加分页
	 * @param page 分页实体
	 * @param babyname 宝贝名称
	 * @param shoolName 学校名称
	 * @param workCar 考勤号
	 * @return=
	 */
	@Override
	public List<BaseBabySchoolDTO> findBaseBabyPage(Page<BaseBabySchoolDTO> page, BaseBabySchoolDTO baseBabySchoolDTO) {
		return baseBabyMapper.findBaseBabyPage(page, baseBabySchoolDTO);
	}

	/**
	 * 查宝贝接送人信息信息加分页
	 * @author ChenWenWu
	 * @date 2017年7月6日 下午5:35:32
	 * @param page 分页实体
	 * @param babyname 宝贝ID
	 * @return
	 */
	@Override
	public List<BabySurrogateDTO> findBaseBabySurrogatePage(String babyid) {
		return baseBabyMapper.findBaseBabySurrogatePage(babyid);
	}

	@Override
	public List<BabySurrogateDTO> findSurrogateidBYboyid(String babyid) {
		return baseBabyMapper.findSurrogateidBYboyid(babyid);
	}

	/**
	 * 补考勤_查询学员
	 * <p>Title: findBabyBysIdandcId</p>
	 * <p>Description: </p>
	 * @param page 分页
	 * @param schoolId 园校id
	 * @param classId 班级id
	 * @return=
	 */
	@Override
	public List<BaseBaby> findBabyBysIdandcId(Pagination page, String schoolId, String classId) {

		return baseBabyMapper.findBabyBysIdandcId(page, schoolId, classId);
	}
	/**
	 * 作为学号判断
	 * @author ChenWenWu
	 * @date 2017年8月10日 下午8:29:50
	 * @param cc
	 * @return
	 */
	 public static String jiao(String cc){
	    	String aa="0"+ cc;
			return aa;
	    }
	/**
	 * 新增baby 同时新增宝贝卡表
	 * @param baseBaby
	 * @param shengri 生日
	 * @param ruxueshijian 入学年份
	 * @param car0 卡号
	 * @param car1
	 * @param car2
	 * @param car3
	 * @param car4
	 * @return=
	 */
	@Override
	public Integer addBaby(BaseBaby baseBaby, String shengri, String ruxueshijian, String cars) {
		Date birthday = DateUtil.parse(shengri);
		Calendar cal = Calendar.getInstance();
		Date entranceTime = DateUtil.parse(ruxueshijian);
		int year = cal.get(Calendar.YEAR);
		int lod = Integer.parseInt(shengri.substring(0, 4));
		int nian = year - lod;
		Integer num2 =0;
		EntityWrapper<BaseSchool> ew = new EntityWrapper<BaseSchool>();
		ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
		ew.where("id",baseBaby.getSchoolId());
		ew.setSqlSelect("id,code");
		List<BaseSchool> baseSchoollist=baseSchoolMapper.selectList(ew);//查询院校编号
		BaseBaby baseBabyCode=baseBabyMapper.findbabyCodeByshoolID(baseBaby.getSchoolId());
		String code="";
		String stunumber="";
		Calendar a=Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置你想要的格式
		if(baseBabyCode==null){//第一次进入这个学院新学号谱的条件
			stunumber =baseSchoollist.get(0).getCode()+   //学院ID
					df.format(a.getTime()).substring(2, 4)+ //年份结尾
					"0001";//学院序号
		} else {
			 Integer size=Integer.valueOf(baseBabyCode.getStudentNum().substring(12, 16));
	          code=size+1+"";
	          while(code.toString().length()<4){
	        	  code=jiao(code);
	         }
	          stunumber=baseSchoollist.get(0).getCode()+   //学院ID
						df.format(a.getTime()).substring(2, 4) //年份结尾
						 +code;
		}
		baseBaby.setStudentNum(stunumber);
		baseBaby.setAge(nian);
		baseBaby.setState(EnumBabyState.WFF.getValue());
		baseBaby.setWarningDays(0);
		baseBaby.setBirthday(birthday);
		baseBaby.setEntranceTime(entranceTime);
		baseBaby.setCreateTime(new Date());
		baseBaby.setCreateMam("wenwu");
		String bindingCode = huoqu6weishu();
		baseBaby.setBindingCode(bindingCode);
		baseBaby.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		Integer num = baseBabyMapper.insert(baseBaby);
		String[] id = cars.split(",");
		String[] aa = new String[id.length];
		for (int i = 0; i < id.length; i++) {
			aa[i] = id[i];
		}
		for (int i = 0; i < aa.length; i++) {
			if (aa[i].trim().length() > 0) {
				MemBabyCards memBabyCards = new MemBabyCards();
				memBabyCards.setBabyId(baseBaby.getId());
				memBabyCards.setCardNum(aa[i]);
				memBabyCards.setCreateMan(baseBaby.getCreateMam());
				memBabyCards.setBlockupFlag(EnumDeleteFlag.WSC.getValue());
				memBabyCards.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
				memBabyCards.setCreateTime(new Date());
				num2 = memBabyCardsMapper.insert(memBabyCards);
			}
		}
		return num2;
	}
	public String huoqu6weishu() {
		String s = "";
		s = BaseBabyServiceImpl.random(6);
		EntityWrapper<BaseBaby> ew = new EntityWrapper<BaseBaby>();
		ew.where("binding_code = {0}", s.toString());
		List<BaseBaby> baseSurrogate = baseBabyMapper.selectList(ew);
		if (baseSurrogate.size() < 1) {
			s = BaseBabyServiceImpl.random(6);
		} else {
			huoqu6weishu();
		}
		return s;
	}

	public static String random(int length) {//传入的字符串的长度
		StringBuilder builder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {

			int r = (int) (Math.random() * 3);
			int rn1 = (int) (48 + Math.random() * 10);
			int rn2 = (int) (65 + Math.random() * 26);
			int rn3 = (int) (97 + Math.random() * 26);

			switch (r) {
				case 0:
					builder.append((char) rn1);
					break;
				case 1:
					builder.append((char) rn2);
					break;
				case 2:
					builder.append((char) rn3);
					break;
			}
		}
		return builder.toString();
	}

	/**
	 * 修改宝贝
	 * @author ChenWenWu
	 * @date 2017年7月20日 下午2:04:35
	 * @param baseBaby 宝贝实体
	 * @return
	 */
	@Override
	public Integer editBaby(BaseBaby baseBaby, String shengri, String ruxueshijian, String babyid,String cars) {
		Date birthday = DateUtil.parse(shengri);
		Calendar cal = Calendar.getInstance();
		Date entranceTime = DateUtil.parse(ruxueshijian);
		int year = cal.get(Calendar.YEAR);
		int lod = Integer.parseInt(shengri.substring(0, 4));
		int nian = year - lod;
		baseBaby.setId(babyid);
		baseBaby.setAge(nian);
		baseBaby.setState(1);
		baseBaby.setWarningDays(3);
		baseBaby.setBirthday(birthday);
		baseBaby.setEntranceTime(entranceTime);
		baseBaby.setCreateTime(new Date());
		baseBaby.setCreateMam("wenwu");
		baseBaby.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		int num = baseBabyMapper.updateById(baseBaby);
		Integer num2 =0;
		
		EntityWrapper<MemBabyCards> ew = new EntityWrapper<MemBabyCards>();
		ew.where("baby_id = {0}",babyid);
		ew.setSqlSelect("card_num as cardNum");
	List<MemBabyCards> list=nemBabyCardsMapper.selectList(ew);
	String[] str = new String[list.size()];
		for(int j=0;j<list.size();j++){
			str[j]=list.get(j).getCardNum();
		}
		
		String[] id = cars.split(",");
		String[] aa = new String[id.length];
		for (int i = 0; i < id.length; i++) {
			aa[i] = id[i];
		}
	 String[] zz=arrContrast(aa,str);
		for (int i = 0; i < zz.length; i++) {
			if (zz[i].trim().length() > 0) {
				MemBabyCards memBabyCards = new MemBabyCards();
				memBabyCards.setBabyId(baseBaby.getId());
				memBabyCards.setCardNum(zz[i]);
				memBabyCards.setCreateMan(baseBaby.getCreateMam());
				memBabyCards.setBlockupFlag(EnumDeleteFlag.WSC.getValue());
				memBabyCards.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
				memBabyCards.setCreateTime(new Date());
				num2 = memBabyCardsMapper.insert(memBabyCards);
			}
		}
		return num;
	}
	 private  String[] arrContrast(String[] arr1, String[] arr2){  
	      List<String> list = new LinkedList<String>();  
	      for (String str : arr1) {                //处理第一个数组,list里面的值为1,2,3,4  
	          if (!list.contains(str)) {  
	              list.add(str);  
	          }  
	      }  
	      for (String str : arr2) {      //如果第二个数组存在和第一个数组相同的值，就删除  
	          if(list.contains(str)){  
	              list.remove(str);  
	          }  
	      }  
	      String[] result = {};   //创建空数组  
	      return list.toArray(result);    //List to Array  
	  }  
	/**
	 * 删除宝贝 同时删除他的联系人
	 * @author ChenWenWu
	 * @date 2017年7月20日 下午2:04:35
	 * @param baseBaby 宝贝ids
	 * @return
	 */
	@Override
	public Integer delBaby(String babyids) {
		String[] id = babyids.split(",");
		String[] aa = new String[id.length];
		BaseBaby baseBaby = new BaseBaby();
		baseBaby.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		Integer num = 0;
		for (int i = 0; i < id.length; i++) {
			aa[i] = id[i];
		}
		for (int i = 0; i < aa.length; i++) {
			baseBaby.setId(aa[i]);
			num += baseBabyMapper.updateById(baseBaby);//删除宝贝
			System.out.println(baseBaby.getId());
			List<BabySurrogateDTO> baseBabySurrogateDTO = baseBabyMapper.findBaseBabySurrogatePage(baseBaby.getId());
			int j = baseBabySurrogateDTO.size();
			for (int z = 0; z < j; z++) {
				BaseSurrogate baseSurrogate = new BaseSurrogate();
				baseSurrogate.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
				baseSurrogate.setId(baseBabySurrogateDTO.get(z).getMemsurrogateID());
				baseSurrogateMapper.updateById(baseSurrogate);
				memBabySurrogateMapper.delOneBabySurrogate(EnumDeleteFlag.YSC.getValue(), baseBabySurrogateDTO.get(z).getMemsurrogateID());
			}
		}
		return num;
	}



	/**
	 * 新增家长的时候同时新增他的关系
	 * @param baseMember 用户基础信息实体
	 * @param relationship  关系
	 * @param babyid  babyId
	 * @param creatMan 创建人
	 * @param disabled 判断是否是新增家长还是原有家长信息 作为其他表的新增
	 * @param baseMemberID
	 * @return=
	 */
	@Override
	public Integer addParentConnection(BaseMember baseMember, Integer relationship, String babyid,String creatMan,boolean disabled,String baseMemberID) {
		//首先增加表base_member 再查mem_member 再 mem_parent_baby 再 mem_baby_surrogate 再 base_surrogate
		if(disabled){//代表是修改
			baseMember.setId(baseMemberID);
			baseMember.setCreateMan(creatMan);
			baseMemberMapper.updateById(baseMember);
			//根据已经注册用户的人
			EntityWrapper<MemMember> ew = new EntityWrapper<MemMember>();
			ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
			ew.where("base_member_id = {0}",baseMemberID);
			ew.setSqlSelect("id");
			List<MemMember> memMemberlist=memMemberMapper.selectList(ew);
			MemParentBaby memParentBaby = new MemParentBaby();//家长宝贝表
			if (memMemberlist.size()>0){
			memParentBaby.setMemberId(memMemberlist.get(0).getId());
			memParentBaby.setBabyId(babyid);
			memParentBaby.setRelationship(relationship);
			memParentBaby.setCreateTime(new Date());
			memParentBaby.setCreateMam(baseMember.getCreateMan());
			memParentBaby.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			Integer num2 = memParentBabyMapper.insert(memParentBaby);
			}else {
				return 0;
			}
		}else{
			baseMember.setCreateMan(creatMan);
			baseMember.setCreateTime(new Date());//用户信息基础表
			baseMember.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			Integer num = baseMemberMapper.insert(baseMember);

			MemMember memMember=new MemMember();
			memMember.setBaseMemberId(baseMember.getId());
			memMember.setBabyId(babyid);
			memMember.setDisableFlag(0);
			memMember.setDeleteFlag(0);
			memMember.setCreateTime(new Date());
			memMemberMapper.insert(memMember);

			MemParentBaby memParentBaby = new MemParentBaby();//家长宝贝表
			memParentBaby.setMemberId(memMember.getId());
			memParentBaby.setBabyId(babyid);
			memParentBaby.setRelationship(relationship);
			memParentBaby.setCreateTime(new Date());
			memParentBaby.setCreateMam(baseMember.getCreateMan());
			memParentBaby.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			Integer num2 = memParentBabyMapper.insert(memParentBaby);
		}

		BaseSurrogate baseSurrogate = new BaseSurrogate();//接送人
		baseSurrogate.setHeadurl(baseMember.getHeadPortrait());//这里的头像是parent的头像作为接送的
		baseSurrogate.setName(baseMember.getName());
		baseSurrogate.setPhone(baseMember.getPhoneNum());
		baseSurrogate.setCreateTime(new Date());
		baseSurrogate.setCreateMam(baseMember.getCreateMan());
		baseSurrogate.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		Integer num3 = baseSurrogateMapper.insert(baseSurrogate);

		MemBabySurrogate memBabySurrogate = new MemBabySurrogate();//宝贝接送人
		memBabySurrogate.setSurrogateId(baseSurrogate.getId());
		memBabySurrogate.setParentBabyId(babyid);
		memBabySurrogate.setRelationship(relationship);
		memBabySurrogate.setCreateTime(new Date());
		memBabySurrogate.setCreateMam(baseMember.getCreateMan());
		memBabySurrogate.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		Integer num4 = memBabySurrogateMapper.insert(memBabySurrogate);
		return num4;
	}

	/**
	 * 查找家长信息
	 * @author ChenWenWu
	 * @date 2017年7月21日 下午5:18:06
	 * @param page 分页实体
	 * @param babyid 宝贝ID
	 * @param parentid 家长ID
	 * @return
	 */
	@Override
	public List<BaseBaby> findParentInfonation(Pagination page, String babyid, String parentid) {
		return baseBabyMapper.findParentInfonation(page, babyid, parentid);
	}

	/**
	 * 修改家长信息以及他的子关系
	 * @author ChenWenWu
	 * @date 2017年7月21日 下午3:54:57
	 * @param baseMember
	 * @param relationship
	 * @param babyid
	 * @return
	 */
	@Override
	public Integer editParentConnection(BaseMember baseMember, Integer relationship, String babyid, String parentid, String fphone) {
		MemMember memMember = new MemMember();//会员表
		//查询用户信息基础表ID
		memMember = memMemberMapper.selectById(parentid);

		//修改用户信息基础表
		baseMember.setUpdateTime(new Date());
		baseMember.setId(memMember.getBaseMemberId());
		Integer num = baseMemberMapper.updateById(baseMember);

		//根据家长ID查找家长宝贝ID
		PreantInfomationDTO preantInfomationDTO = baseBabyMapper.findMenParentBabyID(parentid);
		MemParentBaby memParentBaby = new MemParentBaby();//家长宝贝表
		memParentBaby.setRelationship(relationship);
		memParentBaby.setUpdateTime(new Date());
		memParentBaby.setId(preantInfomationDTO.getMemParentBabyID());
		Integer num2 = memParentBabyMapper.updateById(memParentBaby);
		//宝贝接送人表
		EntityWrapper<BaseSurrogate> ew = new EntityWrapper<BaseSurrogate>();
		ew.where("phone = {0}", fphone);//这个参数是为了改电话号码的
		List<BaseSurrogate> baseSurrogate = baseSurrogateMapper.selectList(ew);
		baseSurrogate.get(0).setName(baseMember.getName());
		baseSurrogate.get(0).setPhone(baseMember.getPhoneNum());
		baseSurrogate.get(0).setHeadurl(baseMember.getHeadPortrait());
		baseSurrogate.get(0).setUpdateTime(new Date());
		baseSurrogate.get(0).setId(baseSurrogate.get(0).getId());
		Integer num3 = baseSurrogateMapper.updateById(baseSurrogate.get(0));

		EntityWrapper<MemBabySurrogate> ew1 = new EntityWrapper<MemBabySurrogate>();
		ew1.where("surrogate_id = {0}", baseSurrogate.get(0).getId());
		List<MemBabySurrogate> memBabySurrogate = memBabySurrogateMapper.selectList(ew1);
		memBabySurrogate.get(0).setRelationship(relationship);
		memBabySurrogate.get(0).setUpdateTime(new Date());
		boolean num4 = memBabySurrogateMapper.editOneBabySurrogate(memBabySurrogate.get(0));
		return num3;
	}

	public List<PreantInfomationDTO> findMenParentBabyID(String parentid) {
		return null;
	}

	/**
	 * 删除家长及其关系
	 * @author ChenWenWu
	 * @date 2017年7月21日 下午3:54:57
	 * @return
	 */
	@Override
	public Integer delParentConnection(String parentid, String fphone) {
		Integer num3 = 0;
		if (parentid != null) {
			//根据家长ID查找家长宝贝ID
			PreantInfomationDTO preantInfomationDTO = baseBabyMapper.findMenParentBabyID(parentid);
			MemParentBaby memParentBaby = new MemParentBaby();//家长宝贝表
			memParentBaby.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			memParentBaby.setId(preantInfomationDTO.getMemParentBabyID());
			Integer num2 = memParentBabyMapper.updateById(memParentBaby);
			//宝贝接送人表
			EntityWrapper<BaseSurrogate> ew = new EntityWrapper<BaseSurrogate>();
			ew.where("phone = {0}", fphone);//这个参数是为了改电话号码的
			List<BaseSurrogate> baseSurrogate = baseSurrogateMapper.selectList(ew);
			baseSurrogate.get(0).setId(baseSurrogate.get(0).getId());
			baseSurrogate.get(0).setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			num3 = baseSurrogateMapper.updateById(baseSurrogate.get(0));

			EntityWrapper<MemBabySurrogate> ew1 = new EntityWrapper<MemBabySurrogate>();
			ew1.where("surrogate_id = {0}", baseSurrogate.get(0).getId());
			List<MemBabySurrogate> memBabySurrogate = memBabySurrogateMapper.selectList(ew1);
			memBabySurrogate.get(0).setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			boolean num4 = memBabySurrogateMapper.editOneBabySurrogate(memBabySurrogate.get(0));
		} else {

		}
		return num3;
	}

	/**
	 * @author ChenWenWu
	 * @date 2017年7月22日 下午5:13:35
	 * @param baseSurrogate 接送人实体
	 * @param relationship 关系
	 * @param babyid 宝贝ID
	 * @return
	 */
	@Override
	public Integer addBaseSurrogate(BaseSurrogate baseSurrogate, Integer relationship, String babyid) {

		baseSurrogate.setCreateTime(new Date());
		baseSurrogate.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		Integer num1 = baseSurrogateMapper.insert(baseSurrogate);

		MemBabySurrogate memBabySurrogate = new MemBabySurrogate();//宝贝接送人
		memBabySurrogate.setSurrogateId(baseSurrogate.getId());
		memBabySurrogate.setParentBabyId(babyid);
		memBabySurrogate.setCreateMam(baseSurrogate.getCreateMam());
		memBabySurrogate.setRelationship(relationship);
		memBabySurrogate.setCreateTime(new Date());
		memBabySurrogate.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		Integer num2 = memBabySurrogateMapper.insert(memBabySurrogate);
		return num2;
	}

	/**
	 * 修改接送人
	 * @author ChenWenWu
	 * @date 2017年7月23日 上午10:30:41
	 * @param baseSurrogate 接送人实体
	 * @param relationship 关系
	 * @param babyid 宝贝ID
	 * @return
	 */
	@Override
	public Integer editBaseSurrogate(BaseSurrogate baseSurrogate, Integer relationship) {
//		EntityWrapper<BaseSurrogate> ew = new EntityWrapper<BaseSurrogate>();
//		ew.where("phone = {0}",fphone );//这个参数是为了改电话号码的
//   	List<BaseSurrogate> baseSurrogate=baseSurrogateMapper.selectList(ew);
		baseSurrogate.setUpdateTime(new Date());
		Integer num3 = baseSurrogateMapper.updateById(baseSurrogate);

		EntityWrapper<MemBabySurrogate> ew1 = new EntityWrapper<MemBabySurrogate>();
		ew1.where("surrogate_id = {0}", baseSurrogate.getId());
		List<MemBabySurrogate> memBabySurrogate = memBabySurrogateMapper.selectList(ew1);
		memBabySurrogate.get(0).setRelationship(relationship);
		memBabySurrogate.get(0).setUpdateTime(new Date());
		boolean num4 = memBabySurrogateMapper.editOneBabySurrogate(memBabySurrogate.get(0));
		return num3;
	}

	/**
	 * 修改联系人信息以及他的子关系
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午5:35:32
	 * @return
	 */
	@Override
	public Integer delBaseSurrogate(String parentid) {
		BaseSurrogate baseSurrogate = new BaseSurrogate();
		baseSurrogate.setId(parentid);
		baseSurrogate.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		Integer num3 = baseSurrogateMapper.updateById(baseSurrogate);

		EntityWrapper<MemBabySurrogate> ew1 = new EntityWrapper<MemBabySurrogate>();
		ew1.where("surrogate_id = {0}", baseSurrogate.getId());
		List<MemBabySurrogate> memBabySurrogate = memBabySurrogateMapper.selectList(ew1);
		memBabySurrogate.get(0).setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		memBabySurrogate.get(0).setSurrogateId(baseSurrogate.getId());
		boolean num4 = memBabySurrogateMapper.editOneBabySurrogate(memBabySurrogate.get(0));
		return num3;
	}

	/**
	 * 查询班级、年级、宝贝
	 * <p>Title: findGradeAndClass</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 上午10:57:02
	 * @param map
	 * @return
	 */
	@Override
	public List<BaseBaby> findGradeAndClass(Map<String, Object> map) {
		List<BaseBaby> baseClasses = this.baseBabyMapper.findGradeAndClass(map);
		return baseClasses;
	}

	/**
	 * 查宝贝信息加分页加分组
	 * @author ChenWenWu
	 * @date 2017年7月24日 上午10:30:39
	 * @param page
	 * @param baseBabySchoolDTO
	 * @return
	 */
	@Override
	public List<BaseBabySchoolDTO> findBaseBabyPageAndGroup(Pagination page, BaseBabySchoolDTO baseBabySchoolDTO) {

		return baseBabyMapper.findBaseBabyPageAndGroup(page, baseBabySchoolDTO);
	}

	/**
	 * 查询分班、未分班baby
	 * @author jiangwangying
	 * @param page 分页
	 * @param selType 查询条件
	 * @param schoolId 园校id
	 * @param classId 班级
	 * @param vague 关键字
	 * @return=
	 */
	@Override
	public List<BaseBaby> findBabyToFenBan(Pagination page, String selType,String schoolId,String classId,String vague) {

		return baseBabyMapper.findBabyToFenBan(page, selType, schoolId, classId, vague);
	}
	
	
	/**
	 * 删除宝贝分组
	 * @author ChenWenWu
	 * @date 2017年7月30日 下午5:49:25
	 * @param ids
	 * @return
	 */
	@Override
	public Integer delgropu(String ids) {
		BaseGroup baseGroup = new BaseGroup();
		MemMemberGroup memMemberGroup = new MemMemberGroup();
		String[] id = ids.split(",");
		String[] aa = new String[id.length];
		Integer num = 0;
		for (int i = 0; i < id.length; i++) {
			aa[i] = id[i];
		}
		baseGroup.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		for (String lj : aa) {
			baseGroup.setId(lj);
			num += baseGroupMapper.updateById(baseGroup);
      //同时删除会员对应分组的数据
			EntityWrapper<MemMemberGroup> ew = new EntityWrapper<MemMemberGroup>();
			ew.where("group_id = {0}", lj);
			ew.setSqlSelect("id");
			List<MemMemberGroup> list = memMemberGroupMapper.selectList(ew);
			for (MemMemberGroup sel : list) {
				memMemberGroup.setId(sel.getId());
				memMemberGroup.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
				memMemberGroupMapper.updateById(memMemberGroup);
			}
		}
		return num;
	}

	@Override
	public List<BaseBaby> findBabyAll() {
		return baseMapper.selectList(null);
	}

	@Override
	public List<BaseBaby> findBabyByClassId(BaseClass baseClass) {
		Wrapper<BaseBaby> wrapper = new EntityWrapper<>();
		wrapper.where("class_id", baseClass.getId());
		return baseMapper.selectList(wrapper);
	}

	@Override
	public BaseBaby findBybyByCardNum(MemBabyCards memBabyCards) {
		memBabyCards.setCardNum(memBabyCards.getCardNum());
		memBabyCards.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		MemBabyCards babyCards = memBabyCardsMapper.selectOne(memBabyCards);
		if (babyCards == null) {
			return null;
		}
		return baseMapper.selectById(babyCards.getBabyId());
	}

	/**
	 * 根据园校id查询园校的所有孩子
	 * @author zhangfeihong
	 * @date 2017年8月7日 下午3:58:00
	 * @param baseSchool
	 * @return
	 */
	@Override
	public List<BabyPo> findBabyBySchoolId(BaseSchool baseSchool) {
		return baseMapper.findBabyBySchoolId(baseSchool);
	}
	/**
	 * 查询育儿知识
	 *
	 * @author ChenWenWu
	 * @date 2017年8月3日 上午11:26:44
	 * @param page
	 * @param baseParentingKnowledgeDTO 育儿知识实体
	 * @return
	 */

	@Override
	public List<BaseParentingKnowledgeDTO> findBaseParentingKnowledge(Pagination page,
			BaseParentingKnowledgeDTO baseParentingKnowledgeDTO) {
		return baseBabyMapper.findBaseParentingKnowledge(page, baseParentingKnowledgeDTO);
	}
	/**
	 * 查询一条育儿知识方便修改
	 * @author ChenWenWu
	 * @date 2017年8月3日 下午2:55:47
	 * @param id
	 * @return
	 */
	@Override
	public BaseParentingKnowledgeDTO findOneBaseParentingKnowledge(String id) {
		return baseBabyMapper.findOneBaseParentingKnowledge(id);
	}
	/**
	 * 删除育儿知识
	 * @author ChenWenWu
	 * @date 2017年8月3日 下午5:42:02
	 * @return
	 */
	@Override
	public Integer delParentingKnowledge(String ids) {
		BaseGroup baseGroup = new BaseGroup();
		BaseParentingKnowledge baseParentingKnowledge = new BaseParentingKnowledge();
		String[] id = ids.split(",");
		String[] aa = new String[id.length];
		Integer num = 0;
		for (int i = 0; i < id.length; i++) {
			aa[i] = id[i];
		}
		baseGroup.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		for (String lj : aa) {
			baseParentingKnowledge.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			baseParentingKnowledge.setId(lj);
			num+=	baseParentingKnowledgeMapper.updateById(baseParentingKnowledge);
		}
		return num;
	}
	/**
	 * 修改下架状态
	 * @author ChenWenWu
	 * @date 2017年8月3日 下午5:42:02
	 * @return
	 */
	@Override
	public Integer editParentingKnowledgedisableNo(String ids) {
		BaseGroup baseGroup = new BaseGroup();
		BaseParentingKnowledge baseParentingKnowledge = new BaseParentingKnowledge();
		String[] id = ids.split(",");
		String[] aa = new String[id.length];
		Integer num = 0;
		for (int i = 0; i < id.length; i++) {
			aa[i] = id[i];
		}
		baseGroup.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		for (String lj : aa) {
			baseParentingKnowledge.setId(lj);
			baseParentingKnowledge.setDisableNo(EnumDeleteFlag.YSC.getValue());//当做已下架
			num+=	baseParentingKnowledgeMapper.updateById(baseParentingKnowledge);
		}
		return num;
	}

	/**
	 * 查询教师ID和宝贝姓名
	 * @author XieFan
	 * @date 2017年8月12日 下午4:54:46
	 * @param babyId
	 * @return
	 */
	@Override
	public BaseEntity findBabyNameAndTeacherId(String babyId) {
		return baseMapper.findBabyNameAndTeacherId(babyId);
	}
}
