package com.vision.edu.service.member;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.CommentinfoDto;
import com.vision.edu.entity.member.MemComment;

/**
 * <p>
 * 评论记录 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemCommentService extends IService<MemComment> {

	/**
	 *新增育儿知识详情评论
	 *@author:zyml
	 *@date:2017年7月10日下午5:49:46
	 *@param memComment 评论实体
	 */
	public void addYunErKnowComment(MemComment memComment);

	/**
	 *增加资讯详情的评论
	 *@author:zyml
	 *@date:2017年7月11日下午9:49:00
	 *@param MemComment 评论实体
	 */
	public void addZiXunComment(MemComment memComment);

	/**
	 *根据来源id查询消息评论回复
	 * @author lichenglong
	 * @date 2017年7月23日 下午12:14:25
	 * @param sourceId 来源id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	public List<CommentinfoDto> findCommentinfo(String sourceId, Integer deleteFlag);

	/**
	 * 新增评论/回复
	 * @author zhangfeihong
	 * @date 2017年7月24日 上午11:45:15
	 * @param memComment
	 *            必需参数:【MemberId，SourceId，CommentType，comment】，可选参数：FatherId[回复]
	 * @return
	 */
	public MemComment addCommentOrReply(MemComment memComment);

	/**
	 * 删除评论/回复
	 * @author zhangfeihong
	 * @date 2017年7月24日 下午12:15:38
	 * @param memComment
	 *            必需参数:【MemberId，SourceId，CommentType，comment】，可选参数：id[回复]
	 * @return
	 */
	public MemComment delComment(MemComment memComment);

	/**
	 * 查询评论及回复
	 * @author zhangfeihong
	 * @date 2017年7月24日 下午12:23:14
	 * @param memComment
	 * @return
	 */
	public List<MemComment> findComment(Page<MemComment> pageComment, String memberId, String sourceId);


}
