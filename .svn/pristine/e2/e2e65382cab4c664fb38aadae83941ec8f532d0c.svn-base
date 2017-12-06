package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.AnnouncementDTO;
import com.vision.edu.dto.BaseSchoolInfoTwoDTO;
import com.vision.edu.entity.base.BaseSchoolInfo;

/**
 * <p>
  * 校园资讯表 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-03
 */
public interface BaseSchoolInfoMapper extends BaseMapper<BaseSchoolInfo> {
	
	/**
	 * 只根据学院ID查询所有  学院名称是模糊查询 banner 咨询
	 * @author ChenWenWu
	 * @date 2017年7月13日 下午5:48:18
	 * @param page 分页实体
	 * @param schoolId 学院id 
	 * @param schoolname 学院名称
	 * @return
	 */
	List<BaseSchoolInfoTwoDTO> findShoolInfofoPage(Pagination page,@Param("schoolId") String schoolId,@Param ("schoolname") String schoolname,@Param ("infotype") String infotype);

	/**
	 * 查询活动
	 * @author ChenWenWu
	 * @date 2017年7月23日 下午3:27:13
	 * @param page
	 * @param baseSchoolInfoTwoDTO 参数实体
	 * @return
	 */
	List<BaseSchoolInfoTwoDTO> findShoolHuoDong(Pagination page,@Param ("baseSchoolInfoTwoDTO") BaseSchoolInfoTwoDTO baseSchoolInfoTwoDTO);

	
	
	/**
	 * 分页+模糊查询Banner
	 * @author ChenWenWu
	 * @date 2017年7月9日 下午7:40:15
	 * @param page  分页实体
	 * @param schoolname   学校名称
	 * @param infoType    学校类型
	 * @return
	 */
	List<BaseSchoolInfoTwoDTO> findBaseSchoolInfoPage(Pagination page,@Param ("schoolname") String schoolname,@Param ("infoType") int infoType,@Param ("schoolId") String schoolId);

	
	/**
	 * 分页+模糊查询 校园咨询的查询
	 * @author ChenWenWu
	 * @date 2017年7月11日 下午8:24:55
	 * @param page 分页实体
	 * @param title 标题
	 * @param schoolname 学院名称
	 * @param infoType 咨询类型
	 * @param schoolId 学院ID
	 * @return
	 */
	List<BaseSchoolInfoTwoDTO> findXiaoYuanZiXunPage(Pagination page,@Param ("title") String title , @Param ("schoolname") String schoolname,@Param ("infoType") int infoType,@Param ("schoolId") String schoolId);

	
	/**
	 * 查询院所动态根据时间段
	 * @author ChenWenWu
	 * @date 2017年7月9日 下午9:35:57
	 * @param page
	 * @param startTime 开始时间 
	 * @param endTime 介绍时间
	 * @return
	 */
	List<BaseSchoolInfoTwoDTO> findBaseYuanSuoPage(Pagination page,@Param ("startTime") String startTime,@Param ("endTime") String endTime);

	
	/**
	 * 查询公告
	 * @author jiangwangying
	 * @date 2017年7月22日 下午10:40:38
	 * @param page 分页
	 * @param infoType 资讯类型
	 * @param title 标题
	 * @param schoolName 园校名称
	 * @param schoolId 园校id
	 * @param rangeType 推送范围
	 * @param platform 平台标记
	 * @return
	 */
	List<AnnouncementDTO> findAnnouncement(Pagination page,@Param("infoType") Integer infoType,@Param("title") String title,@Param("schoolName") String schoolName,@Param("schoolId") String schoolId,@Param("rangeType")Integer rangeType,@Param("platform") Integer platform);

	
	/**
	 * 修改之前查询出来
       @author ChenWenWu
	 * @param baseSchoolInfo 咨询D 
	 * @return=
	 */
	BaseSchoolInfoTwoDTO findOneShoolInFo(@Param("baseSchoolInfo") String baseSchoolInfo);
	
	/**
	 * 修改之前查询出来(差的是《没》有咨询分组得分组)
       @author ChenWenWu
	 * @param baseSchoolInfo 咨询D 
	 * @return=
	 */
	BaseSchoolInfoTwoDTO findOneShoolInFoONGroup(@Param("baseSchoolInfo") String baseSchoolInfo);
}