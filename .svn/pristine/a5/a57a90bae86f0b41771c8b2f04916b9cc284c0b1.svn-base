package com.vision.edu.service.base;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.BabySurrogateDTO;
import com.vision.edu.dto.BaseBabySchoolDTO;
import com.vision.edu.dto.BaseParentingKnowledgeDTO;
import com.vision.edu.dto.apiVo.BabyPo;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.entity.base.BaseMember;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.entity.base.BaseSurrogate;
import com.vision.edu.entity.member.MemBabyCards;

/**
 * <p>
 * 宝贝表 服务类
 * </p>
 * @author XieFan
 * @since 2017-07-03
 */
public interface IBaseBabyService extends IService<BaseBaby> {

	/**
	 * 新增宝贝
	 * @author ChenWenWu
	 * @date 2017年7月20日 下午2:04:35
	 * @param baseBaby 宝贝实体
	 * @return
	 */
	Integer addBaby(BaseBaby baseBaby, String shengri, String ruxueshijian, String cars);

	/**
	 * 查宝贝信息加分页加分组
	 * @author ChenWenWu
	 * @date 2017年7月24日 上午10:30:39
	 * @param page
	 * @param baseBabySchoolDTO
	 * @return
	 */
	List<BaseBabySchoolDTO> findBaseBabyPageAndGroup(Pagination page, BaseBabySchoolDTO baseBabySchoolDTO);

	/**
	 * 修改宝贝
	 * @author ChenWenWu
	 * @date 2017年7月20日 下午2:04:35
	 * @param baseBaby 宝贝实体
	 * @return
	 */
	Integer editBaby(BaseBaby baseBaby, String shengri, String ruxueshijian, String babyid,String cars);

	/**
	 * 删除宝贝 同时删除他的联系人
	 * @author ChenWenWu
	 * @date 2017年7月20日 下午2:04:35
	 * @param baseBaby 宝贝ids
	 * @return
	 */
	Integer delBaby(String babyids);

	/**
	 * 新增家长的时候同时新增他的关系
	 * @author ChenWenWu
	 * @date 2017年7月21日 下午3:54:57
	 * @param baseMember
	 * @param relationship
	 * @param babyid
	 * @return
	 */
	Integer addParentConnection(BaseMember baseMember, Integer relationship, String babyid,String creatMan,boolean disabled,String baseMemberID);

	/**
	 * 修改家长信息
	 * @author ChenWenWu
	 * @date 2017年7月21日 下午3:54:57
	 * @param baseMember
	 * @param relationship
	 * @param babyid
	 * @param fphone 这个是修改之前为了查他是联系人的角色的信息
	 * @return
	 */
	Integer editParentConnection(BaseMember baseMember, Integer relationship, String babyid, String parentid, String fphone);

	/**
	 * 删除家长及其信息
	 * @author ChenWenWu
	 * @date 2017年7月21日 下午3:54:57
	 * @param fphone 这个是修改之前为了查他是联系人的角色的信息
	 * @return
	 */
	Integer delParentConnection(String parentid, String fphone);

	/**
	 * 查宝贝信息加分页
	 * @author ChenWenWu
	 * @date 2017年7月9日 下午7:49:31
	 * @param page 分页实体
	 * @param babyname 宝贝名称
	 * @param shoolName 学院名称
	 * @param workCar 考勤号
	 * @return
	 */
	List<BaseBabySchoolDTO> findBaseBabyPage(Page<BaseBabySchoolDTO> page, BaseBabySchoolDTO baseBabySchoolDTO);

	/**
	 * 根据不啊宝贝ID删除联系人
	 * @author ChenWenWu
	 * @date 2017年7月6日 下午5:35:32
	 * @param page 分页实体
	 * @param babyid 宝贝D
	 * @return
	 */

	List<BabySurrogateDTO> findBaseBabySurrogatePage(String babyid);

	List<BabySurrogateDTO> findSurrogateidBYboyid(String babyid);

	/**
	 * 补考勤_查询宝贝
	 * @author jiangwangying
	 * @date 2017年7月9日 上午8:30:00
	 * @param page
	 * @param schoolId
	 * @param classId
	 * @return
	 */
	List<BaseBaby> findBabyBysIdandcId(Pagination page, String schoolId, String classId);

	/**
	 * 查找家长信息
	 * @author ChenWenWu
	 * @date 2017年7月21日 下午5:18:06
	 * @param page 分页实体
	 * @param babyid 宝贝ID
	 * @param parentid 家长ID
	 * @return
	 */
	List<BaseBaby> findParentInfonation(Pagination page, String babyid, String parentid);

	/**
	 * @author ChenWenWu
	 * @date 2017年7月22日 下午5:13:35
	 * @param baseSurrogate 接送人实体
	 * @param relationship 关系
	 * @param babyid 宝贝ID
	 * @return
	 */
	Integer addBaseSurrogate(BaseSurrogate baseSurrogate, Integer relationship, String babyid);

	/**
	 * 查询班级、年级、宝贝信息
	 * <p>Title: findGradeAndClass</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 上午10:54:43
	 * @param map
	 * @return
	 */
	List<BaseBaby> findGradeAndClass(Map<String, Object> map);

	/**
	 * 修改接送人及其关系
	 * @author ChenWenWu
	 * @date 2017年7月23日 上午10:30:41
	 * @param baseSurrogate 接送人实体
	 * @param relationship 关系
	 * @return
	 */
	Integer editBaseSurrogate(BaseSurrogate baseSurrogate, Integer relationship);

	/**
	 * 删除接送人及其关系
	 * @author ChenWenWu
	 * @date 2017年7月23日 上午10:30:41
	 * @param baseSurrogate 接送人实体
	 * @param relationship 关系
	 * @return
	 */
	Integer delBaseSurrogate(String parentid);

	/**
	 * 查询分班、未分班baby
	 * @author jiangwangying
	 * @date 2017年8月7日 下午10:02:20
	 * @param page 分页
	 * @param selType 查询类型
	 * @param schoolId 园校id
	 * @param classId 班级id
	 * @param vague 关键字
	 * @return
	 */
	List<BaseBaby> findBabyToFenBan(Pagination page, String selType,String schoolId,String classId,String vague);
	/**
	 * 查询所有宝贝信息【云讯接口】
	 * @author zhangfeihong
	 * @date 2017年7月30日 下午3:31:17
	 * @return
	 */
	List<BaseBaby> findBabyAll();

	/**
	 * 根据班级id查询孩子
	 * @author zhangfeihong
	 * @date 2017年7月30日 下午11:01:31
	 * @param baseClass
	 * @return
	 */
	List<BaseBaby> findBabyByClassId(BaseClass baseClass);

	/**
	 * 根据卡号查询宝贝信息
	 * @author zhangfeihong
	 * @date 2017年7月31日 上午8:46:12
	 * @param memBabyCards
	 * @return
	 */
	BaseBaby findBybyByCardNum(MemBabyCards memBabyCards);

	/**
	 * 根据园校id查询园校的所有孩子
	 * @author zhangfeihong
	 * @date 2017年7月31日 下午12:08:19
	 * @param baseSchool
	 * @return
	 */
	List<BabyPo> findBabyBySchoolId(BaseSchool baseSchool);
	/**
	 * 删除宝贝分组
	 * @author ChenWenWu
	 * @date 2017年7月30日 下午5:49:25
	 * @param ids
	 * @return
	 */
	Integer delgropu(String ids);

	/**
	 * 查询育儿知识
	 * @author ChenWenWu
	 * @date 2017年8月3日 上午11:26:44
	 * @param page
	 * @param baseParentingKnowledgeDTO 育儿知识实体
	 * @return
	 */
	List<BaseParentingKnowledgeDTO> findBaseParentingKnowledge(Pagination page, BaseParentingKnowledgeDTO baseParentingKnowledgeDTO);
	/**
	 * 查询一条育儿知识方便修改
	 * @author ChenWenWu
	 * @date 2017年8月3日 下午2:55:47
	 * @param id 
	 * @return
	 */
      BaseParentingKnowledgeDTO findOneBaseParentingKnowledge( String id );
     /**
      * 删除育儿知识
      * @author ChenWenWu
      * @date 2017年8月3日 下午5:42:02
      * @return
      */
	Integer delParentingKnowledge(String ids);
	/**
	 * 修改下架状态
	 * @author ChenWenWu
	 * @date 2017年8月3日 下午5:42:02
	 * @return
	 */
	Integer editParentingKnowledgedisableNo(String ids);
	
	/**
	 * 查询教师ID和宝贝姓名
	 * @author XieFan
	 * @date 2017年8月12日 下午4:54:46
	 * @param babyId
	 * @return
	 */
	BaseEntity findBabyNameAndTeacherId(String babyId);

}
