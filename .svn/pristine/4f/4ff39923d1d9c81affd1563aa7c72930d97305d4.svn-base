package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.dto.CommentinfoDto;
import com.vision.edu.entity.member.MemComment;

/**
 * <p>
 * 评论记录 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemCommentMapper extends BaseMapper<MemComment> {

	/**
	 *根据来源id查询消息评论回复
	 * @author lichenglong
	 * @date 2017年7月23日 下午12:14:25
	 * @param sourceId 来源id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<CommentinfoDto> findCommentinfo(@Param("sourceId")String sourceId,@Param("deleteFlag")Integer deleteFlag);

	/**
	 * 查询评论回复
	 * @author zhangfeihong
	 * @date 2017年7月24日 下午2:06:37
	 * @param memComment
	 * @param sourceId
	 * @param memberId
	 * @param count
	 * @return
	 */
	List<MemComment> selectChildCommentList(@Param("memComment") MemComment memComment, @Param("memberId") String memberId, @Param("sourceId") String sourceId);

	/**
	 * 分页查询顶级评论
	 * @author zhangfeihong
	 * @date 2017年7月24日 下午4:17:48
	 * @param pageComment
	 * @param sourceId
	 * @param sourceId2
	 * @return
	 */
	List<MemComment> selectTopCommentList(@Param("pageComment") Page<MemComment> pageComment, @Param("memberId") String memberId, @Param("sourceId") String sourceId);
}