package com.vision.edu.service.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.AnnouncementDTO;
import com.vision.edu.dto.BaseSchoolInfoTwoDTO;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 校园资讯表 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-03
 */
public interface IBaseSchoolInfoService extends IService<BaseSchoolInfo> {
	
	
	/**
	 * 只根据学院ID查询所有 
	 * @author ChenWenWu
	 * @date 2017年7月11日 下午9:19:07
	 * @param schoolId
	 * @return
	 */
	List<BaseSchoolInfoTwoDTO> findShoolInfofoPage(Pagination page,String schoolId,String schoolname,String infotype);

	
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
	  * @date 2017年7月9日 下午7:50:51
	  * @param page  分页实体
	  * @param schoolname 学院名称
	  * @param infoType banner类型
	  * @return
	  */
	List<BaseSchoolInfoTwoDTO> findBaseSchoolInfoPage(Page<BaseSchoolInfoTwoDTO> page,String schoolname,int   infoType,String schoolId);
	
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
	List<BaseSchoolInfoTwoDTO> findXiaoYuanZiXunPage(Pagination page,String title , String schoolname,int infoType, String schoolId);

	
	/**
	 * 查询院所动态根据时间段
	 * @author ChenWenWu
	 * @date 2017年7月9日 下午9:35:57
	 * @param page
	 * @param startTime 开始时间 
	 * @param endTime 介绍时间
	 * @return
	 */
	List<BaseSchoolInfoTwoDTO> findBaseYuanSuoPage(Pagination page, String startTime, String endTime);
   
	/**
	 *1、 新增Banner 2、校园咨询发布 3、发布活动那里的新增
	 *   同时新增咨询组表，
	 * @author ChenWenWu
	 * @date 2017年7月5日 下午4:17:41
	 */
	Integer all(BaseSchoolInfo bif,String group,String  time);
	
	/**
	 * 1、修改单条Banner 2、校园咨询的编辑 
	 * @author ChenWenWu
	 * @date 2017年7月5日 下午4:50:41
	 */
	Integer edti(BaseSchoolInfo bif,String time,String group,String shoolinofid);
	
	
	/**
	 * 修改之前查询出来(差的是有咨询分组得分组)
       @author ChenWenWu
	 * @param baseSchoolInfo 咨询D 
	 * @return=
	 */
	BaseSchoolInfoTwoDTO findOneShoolInFo(String baseSchoolInfo);
	
	/**
	 * 修改之前查询出来(差的是《没》有咨询分组得分组)
       @author ChenWenWu
	 * @param baseSchoolInfo 咨询D 
	 * @return=
	 */
	BaseSchoolInfoTwoDTO findOneShoolInFoONGroup(String baseSchoolInfo);
   
	/**
	 * 删除——banner
	 * @author ChenWenWu
	 * @date 2017年7月18日 下午3:01:22
	 * @return
	 */
	Integer delShoolinfo(String shoolinfoID);
	/**
	 * 审核——banner
	 * @author ChenWenWu
	 * @date 2017年7月18日 下午3:01:22
	 * @return
	 */
	Integer checkShoolinfo(String shoolinfoID,Integer type);
	
	/**
	 * 查询公告
	 * @author jiangwangying
	 * @date 2017年7月22日 下午10:43:02
	 * @param page 分页
	 * @param InfoType 资讯类型
	 * @param title 标题
	 * @param schoolName 园校名称
	 * @param schoolId 园校id
	 * @param rangeType 推送范围
	 * @param platform 平台标记
	 * @return
	 */
	List<AnnouncementDTO> findAnnouncement(Pagination page, Integer InfoType, String title, String schoolName,String schoolId,Integer rangeType, Integer platform);
	
	/**
	 * 新增公告
	 * @author jiangwangying
	 * @date 2017年7月23日 下午2:47:54
	 * @param groupIds 分组id集合
	 * @param schoolId 园校id
	 * @param memberType 用户类型
	 * @param createMan 创建人
	 * @return
	 */
	JsonResult addAnnouncement(BaseSchoolInfo baseSchoolInfo,String groupIds,String schoolId,Integer memberType,String createMan);

	/**
	 * 下架\审核通过\审核不通过 公告
	 * @author jiangwangying
	 * @date 2017年7月23日 下午8:57:18
	 * @param schoolInfoIds 公告id集合
	 * @param flag 操作标记:flag=1为下架操作 flag=2为审核通过操作 flag=3为审核不通过操作
	 * @param updateMan 修改人
	 * @return
	 */
    JsonResult CheckAnnouncement(String schoolInfoIds,Integer flag,String updateMan);

    /**
     * 编辑公告
     * @author jiangwangying
     * @date 2017年7月29日 上午08:46:08
     * @param title 标题
     * @param content 内容
     * @param schoolInfoId 资讯组id
     * @param groupIds 组id  平台id\园校id\资讯组id
     * @param updateMan 修改人
     * @param memberType 用户类型
     * @param gongGaoImg 公告图片
     * @return
     */
	JsonResult editAnnouncement(String title,String content,String schoolInfoId,String groupIds,String updateMan, Integer memberType, String gongGaoImg);
}
