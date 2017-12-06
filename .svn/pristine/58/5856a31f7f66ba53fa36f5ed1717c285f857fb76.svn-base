package com.vision.edu.mapper.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.BabySurrogateDTO;
import com.vision.edu.dto.BaseBabySchoolDTO;
import com.vision.edu.dto.BaseParentingKnowledgeDTO;
import com.vision.edu.dto.PreantInfomationDTO;
import com.vision.edu.dto.apiVo.BabyPo;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseSchool;

/**
 * <p>
 * 宝贝表 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-03
 */
public interface BaseBabyMapper extends BaseMapper<BaseBaby> {
	/**
	 * 查宝贝信息加分页
	 * @author ChenWenWu
	 * @date 2017年7月6日 下午5:35:32
	 * @param page
	 * @param babyname
	 * @return
	 */
	List<BaseBabySchoolDTO> findBaseBabyPage(Pagination page,@Param("baseBabySchoolDTO")BaseBabySchoolDTO baseBabySchoolDTO);

	/**
	 * 查宝贝信息加分页加分组
	 * @author ChenWenWu
	 * @date 2017年7月24日 上午10:30:39
	 * @param page
	 * @param baseBabySchoolDTO
	 * @return
	 */
	List<BaseBabySchoolDTO> findBaseBabyPageAndGroup(Pagination page,@Param("baseBabySchoolDTO")BaseBabySchoolDTO baseBabySchoolDTO);


	/**
	 * 根据不啊宝贝ID删除联系人
	 * @author ChenWenWu
	 * @date 2017年7月6日 下午5:35:32
	 * @param page 分页实体
	 * @param babyid 宝贝D
	 * @return
	 */
	List<BabySurrogateDTO> findBaseBabySurrogatePage( @Param ("babyid") String babyid);




	List<BabySurrogateDTO> findSurrogateidBYboyid(@Param ("babyid") String babyid);


	/**
	 * 补考勤_查询宝贝
	 * @author jiangwangying
	 * @date 2017年7月9日 上午8:37:20
	 * @param page 分页
	 * @param schoolId 园校id
	 * @param classId 班级id
	 * @return
	 */
	List<BaseBaby> findBabyBysIdandcId(Pagination page,@Param("schoolId") String schoolId,@Param("classId") String classId);

	/**
	 * 查找家长信息
	 * @author ChenWenWu
	 * @date 2017年7月21日 下午5:18:06
	 * @param page 分页实体
	 * @param babyid 宝贝ID
	 * @param parentid 家长ID
	 * @return
	 */
	List<BaseBaby> findParentInfonation(Pagination page,@Param("babyid") String babyid,@Param ("parentid") String parentid);

	/**
	 * 根据家长ID查找家长宝贝ID
	 * @author ChenWenWu
	 * @date 2017年7月21日 下午5:18:06
	 * @param parentid 家长ID
	 * @return
	 */
	PreantInfomationDTO findMenParentBabyID(@Param("parentid") String parentid);

	/**
	 * 查询班级、年级、宝贝
	 * <p>Title: findGradeAndClass</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 上午10:58:42
	 * @param map
	 * @return
	 */
	List<BaseBaby> findGradeAndClass(@Param("map")Map<String, Object> map);

	/**
	 * 查询分班、未分班baby   
	 * @author jiangwangying
	 * @date 2017年8月7日 下午10:07:41
	 * @param page 分页
	 * @param selType 查询类型
	 * @param schoolId 园校id
	 * @param classId 班级id
	 * @param vague 园校id
	 * @return
	 */
	List<BaseBaby> findBabyToFenBan(Pagination page,@Param("selType") String selType,@Param("schoolId") String schoolId,@Param("classId") String classId,@Param("vague") String vague);

	/**
	 * 根据园校id查询园校的所有孩子
	 * @author zhangfeihong
	 * @date 2017年8月1日 上午10:02:18
	 * @param baseSchool
	 * @return
	 */
	List<BabyPo> findBabyBySchoolId(@Param("baseSchool") BaseSchool baseSchool);

	/**
	 * 查询育儿知识
	 * @author ChenWenWu
	 * @date 2017年8月3日 上午11:26:44
	 * @param page
	 * @param baseParentingKnowledgeDTO 育儿知识实体
	 * @return
	 */
	List<BaseParentingKnowledgeDTO> findBaseParentingKnowledge(Pagination page,@Param("baseParentingKnowledgeDTO") BaseParentingKnowledgeDTO baseParentingKnowledgeDTO);
	/**
	 * 查询一条育儿知识方便修改
	 * @author ChenWenWu
	 * @date 2017年8月3日 下午2:55:47
	 * @param id 
	 * @return 
	 */
      BaseParentingKnowledgeDTO findOneBaseParentingKnowledge(@Param("id") String id );
   /**
    * 查询Baby编号
    * @author ChenWenWu
    * @date 2017年8月6日 上午10:21:41
    * @param schoolid
    * @return
    */
      BaseBaby findbabyCodeByshoolID(@Param("schoolid") String schoolid );
      
      /**
       * 查询教师ID和宝贝姓名
       * @author XieFan
       * @date 2017年8月12日 下午4:50:03
       * @param babyId
       * @return
       */
      BaseEntity findBabyNameAndTeacherId(@Param("babyId")String babyId);

}