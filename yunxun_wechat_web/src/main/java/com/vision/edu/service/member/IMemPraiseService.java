package com.vision.edu.service.member;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.member.MemPraise;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 点赞记录 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemPraiseService extends IService<MemPraise> {

	/**
	 *新增育儿知识详情评论的点赞信息
	 *@author:zyml
	 *@date:2017年7月10日下午9:59:12
	 *@param memPraise 表扬实体
	 */
	public void addYunErKnowCommentParise(MemPraise memPraise);

	/**
	 *园丁点赞数的新增
	 *@author:zyml
	 *@date:2017年7月11日上午11:24:01
	 *@param memPraise 表扬实体
	 */
	public JsonResult addTeacherParise(MemPraise memPraise);

	/**
	 *新增园长的点赞数
	 *@author:zyml
	 *@date:2017年7月11日下午7:42:33
	 *@param MemPraise 表扬实体
	 */
	public void addPrincipalParise(MemPraise memPraise);

	/**
	 *根据id进行查询点赞数是否唯一显示相应的状态
	 *@author:zyml
	 *@date:2017年7月22日下午5:46:45
	 *@param userId 用户id
	 */
	public MemPraise findByUserId(String userId,String sourceId);

	/**
	 *园丁点赞数取消点赞
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param BaseSchoolInfo 校园资讯
	 */
	public JsonResult UpdateDianZanNum(MemPraise memPraise);

	/**
	 *园长赞数的修改
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param BaseSchoolInfo 校园资讯
	 */
	public JsonResult UpdateYuanZhangDianZanNum(MemPraise memPraise);

	/**
	 *@author:zyml
	 *@date:2017年7月23日下午9:02:37
	 *@param memPraise
	 *@return
	 */
	public JsonResult insertZiXunPraseCount(MemPraise memPraise);

	/**
	 *园长点赞数的增加
	 *@author:zyml
	 *@date:2017年7月23日上午8:33:16
	 *@param BaseSchoolInfo 校园资讯
	 */
	public JsonResult insertYuanZhangPraseCount(MemPraise memPraise);

	/**
	 *根据点赞记录id进行查询
	 *@author:zyml
	 *@date:2017年7月23日下午10:06:42
	 *@param priaseId 点赞记录id
	 */
	public MemPraise findByPriaseId(String priaseId);

	/**
	 *园长点赞数的修改
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param BaseSchoolInfo 校园资讯
	 */
	public JsonResult UpdateYuanDingDianZanNum(MemPraise memPraise);

	/**
	 * 点赞,必须参数为：[MemberId，SourceId，PraiseType]
	 * @author zhangfeihong
	 * @date 2017年7月24日 上午10:30:57
	 * @param memPraise 点赞
	 * @param typeEnum 资源类型
	 * @return
	 */
	public MemPraise changePraise(MemPraise memPraise);

}
