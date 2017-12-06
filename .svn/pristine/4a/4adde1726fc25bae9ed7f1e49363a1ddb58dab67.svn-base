package com.vision.edu.mapper.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.base.BaseSchoolInfo;

/**
 * <p>
 * 校园资讯 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseSchoolInfoMapper extends BaseMapper<BaseSchoolInfo> {

	/**
	*查询 banner图片墙的基本信息
	*@author:zyml
	*@date:2017年7月6日下午3:06:53
	*@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	*/
	List<BaseEntity> findPhotoAll(@Param("map") Map<String, Object> map);
	/**
	*查询图片的详细信息
	*@author:zyml
	*@date:2017年7月7日下午3:09:07
	*@param strCode 图片的id
	*/
	BaseEntity findPhotoAllDetail(@Param("id") String strCode);


	/**
	*查询学校新闻信息
	*@author:zyml
	*@date:2017年7月6日下午4:52:56
	*/
	List<BaseSchoolInfo> findAllNews();

	/**
	*查询公告标题的最新信息
	*@author:zyml
	*@date:2017年7月7日上午9:02:48
	*@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	*/
	List<BaseEntity> findAdvertisTitle(@Param("map") Map<String, Object> map);

	/**
	*根据公告标题查询公告的详情信息
	*@author:zyml
	*@date:2017年7月7日上午9:14:20
	*@param strCode 公告id
	*/
	BaseEntity findAdvertisDetail(@Param("strCode") String strCode);

	/**
	 *查看资讯活动基本最新信息
	 *@author:zyml
	 *@date:2017年7月7日上午10:16:04
	 *@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	 */
	List<BaseEntity> findInforMation(@Param("map") Map<String, Object> map);


	/**
	 * 根据ID查看资讯详细信息
	 * @author:zyml
	 * @date:2017年7月7日下午5:20:47
	 * @param strCode 资讯id
	 * @param memberId
	 */
	BaseSchoolInfo findInforMationDetail(@Param("strCode") String strCode, @Param("memberId") String memberId);

	/**
	 *开始查询咨询的评论信息
	 *@author:zyml
	 *@date:2017年7月8日下午9:18:51
	 *@param strCode 资讯id
	 */
	List<BaseEntity> findInforMationDetailNext(@Param("id") String strCode);


	/**
	 *查询最新的主题信息
	 *@author:zyml
	 *@date:2017年7月6日下午4:09:33
	 *@param strCode   资源id
	 *@param infoType 资讯类型
	 */
	List<BaseSchoolInfo> findAllThemeAct(@Param("id") String strCode,@Param("infoType") int infoType);

	/**
	 *根据id查看主题活动的详情信息
	 *@author:zyml
	 *@date:2017年7月9日上午9:11:36
	 *@param strCode 主题id
	 */
	BaseSchoolInfo findAllThemeActDetailById(@Param("id") String strCode);

	/**
	 *查看资讯活动更多信息
	 *@author:zyml
	 *@date:2017年7月7日上午10:12:13findInforMationMore
	 *@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	 */
	List<BaseEntity> findInforMationMore(@Param("map") Map<String, Object> map);

}