package com.vision.edu.service.base;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.member.MemPraise;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 校园资讯 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseSchoolInfoService extends IService<BaseSchoolInfo> {

	/**
	*查询 banner图片墙的基本信息
	*@author:zyml
	*@date:2017年7月6日下午3:06:53
	*@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	*/
	List<BaseEntity> findPhotoAll(Map<String, Object> map);
	
	/**
	 *根据图片的id查询图片的详细信息
	 *@author:zyml
	 *@date:2017年7月7日下午3:07:24
	 *@param strCode 图片的id
	 */
	BaseEntity findPhotoAllDetail(String strCode);

	/**
	 *查询最新的主题信息
	 *@author:zyml
	 *@date:2017年7月6日下午4:06:56
	 *@param strCode   资源id
	 *@param infoType 资讯类型
	 */
	List<BaseSchoolInfo> findAllThemeAct(String strCode,int infoType);

	/**
	 *@author:zyml
	 *@date:2017年7月6日下午4:51:50
	 */
	List<BaseSchoolInfo> findAllNews();

	/**
	 *查询公告标题的最新信息
	 *@author:zyml
	 *@date:2017年7月6日下午3:40:56
	 *@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	 */
	List<BaseEntity> findAdvertisTitle(Map<String, Object> map);

	/**
	 *根据公告标题查询公告详情信息
	 *@author:zyml
	 *@date:2017年7月7日上午9:12:44
	 *@param strCode 公告id
	 */
	BaseEntity findAdvertisDetail(String strCode);

	/**
	 *查看资讯活动基本最新信息
	 *@author:zyml
	 * @param map
	 *@date:2017年7月7日上午10:14:52
	 *@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	 */
	List<BaseEntity> findInforMation(Map<String, Object> map);

	/**
	 * 根据ID查看资讯详细信息
	 * @author:zyml
	 * @date:2017年7月7日下午5:18:37
	 * @param strCode 资讯id
	 * @param memberId 当前登录人id
	 */
	BaseSchoolInfo findInforMationDetail(String strCode, String memberId);

	/**
	 *开始查询咨询的评论信息
	 *@author:zyml
	 *@date:2017年7月8日下午9:17:00
	 *@param strCode 资讯id
	 */
	List<BaseEntity> findInforMationDetailNext(String strCode);

	/**
	 *根据id查看主题活动的详情信息
	 *@author:zyml
	 *@date:2017年7月9日上午9:09:47
	 *@param strCode 主题id
	 */
	BaseSchoolInfo findAllThemeActDetailById(String strCode);

	/**
	 *资讯点赞数的修改
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param BaseSchoolInfo 校园资讯点赞增加
	 */
	public JsonResult UpdateZiXunDianZanNum(MemPraise memPraise);

	/**
	 *资讯浏览量的增加
	 *@author:zyml
	 *@date:2017年7月12日上午9:09:24
	 *@param BaseSchoolInfo 校园资讯实体
	 */
	public JsonResult addZiXunLiuLanCount(BaseSchoolInfo baseSchoolInfo);

	/**
	 *活动浏览量的增加
	 *@author:zyml
	 *@date:2017年7月12日上午9:09:24
	 *@param BaseSchoolInfo 校园资讯实体
	 */
	JsonResult addActLiuLanCount(BaseSchoolInfo baseSchoolInfo);

	/**
	 *资讯点赞数的增加
	 *@author:zyml
	 *@date:2017年7月23日上午8:33:16
	 *@param BaseSchoolInfo 校园资讯
	 */
	public JsonResult insertZiXunPraseCount(MemPraise memPraise);

	/**
	 *查看资讯活动更多信息
	 *@author:zyml
	 *@date:2017年7月7日上午10:12:13findInforMationMore
	 *@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	 */
	List<BaseEntity> findInforMationMore(Map<String, Object> map);
}
