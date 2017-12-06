package com.vision.edu.service.member.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.CommentinfoDto;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.member.MemComment;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumResourceType;
import com.vision.edu.framework.exception.BusinessException;
import com.vision.edu.mapper.base.BaseSchoolInfoMapper;
import com.vision.edu.mapper.member.MemCommentMapper;
import com.vision.edu.service.member.IMemCommentService;

/**
 * <p>
 * 评论记录 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemCommentServiceImpl extends ServiceImpl<MemCommentMapper, MemComment> implements IMemCommentService {

	@Autowired
	private MemCommentMapper memCommentMapper;    //注入MemCommentMapper

	@Autowired
	private BaseSchoolInfoMapper baseSchoolInfoMapper;
	/**
	 *新增育儿知识详情评论
	 *@param memComment 评论实体
	 */
	@Override
	public void addYunErKnowComment(MemComment memComment) {
		this.memCommentMapper.insert(memComment);
	}

	/**
	 *增加资讯详情的评论
	 *@author:zyml
	 *@date:2017年7月11日下午9:49:00
	 *@param MemComment 评论实体
	 */
	@Override
	public void addZiXunComment(MemComment memComment) {
		this.memCommentMapper.insert(memComment);
	}

	/**
	 *根据来源id查询消息评论回复
	 * @author lichenglong
	 * @date 2017年7月23日 下午12:14:25
	 * @param sourceId 来源id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	@Override
	public List<CommentinfoDto> findCommentinfo(String sourceId,Integer deleteFlag){
		List<CommentinfoDto> listCommentinfoDto =  memCommentMapper.findCommentinfo(sourceId, deleteFlag);
		return listCommentinfoDto;
	}

	@Override
	public MemComment addCommentOrReply(MemComment memComment) {
		if (StringUtils.isAnyBlank(memComment.getMemberId(), memComment.getSourceId(), memComment.getComment()) || memComment.getCommentType() == null) {
			throw new BusinessException("参数不全，所需参数为：MemberId，SourceId，CommentType，comment");
		}
		EnumResourceType typeEnum = EnumResourceType.get(memComment.getCommentType());
		if (typeEnum == null) {
			throw new BusinessException("CommentType参数不正确");
		}
		memComment.setCreateTime(new Date());
		memComment.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		memComment.setPointCount(0);
		//父id不为空则是评论，否则是回复,回复直接保存
		if (StringUtils.isBlank(memComment.getFatherId())) {
			switch (typeEnum) {
				case SP://食谱
					break;
				case CZGJ://成长轨迹
					break;
				case BN://banner
					break;
				case DT://动态
					break;
				case GG://公告
					break;
				case HD://活动
					break;
				case QD://签到
					break;
				case ZX://资讯
					BaseSchoolInfo baseSchoolInfo = baseSchoolInfoMapper.selectById(memComment.getSourceId());
					BaseSchoolInfo entity = new BaseSchoolInfo();
					entity.setId(baseSchoolInfo.getId());
					entity.setCommentCount(baseSchoolInfo.getCommentCount() + 1);
					baseSchoolInfoMapper.updateById(entity);
					break;
				default:
					break;
			}
		}
		baseMapper.insert(memComment);
		return memComment;
	}

	@Override
	public MemComment delComment(MemComment memComment) {
		if (StringUtils.isAnyBlank(memComment.getId(), memComment.getMemberId(), memComment.getSourceId(), memComment.getComment()) || memComment.getCommentType() == null) {
			throw new BusinessException("参数不全，所需参数为：id,MemberId，SourceId，CommentType，comment");
		}
		EnumResourceType typeEnum = EnumResourceType.get(memComment.getCommentType());
		if (typeEnum == null) {
			throw new BusinessException("CommentType参数不正确");
		}
		memComment.setCreateTime(new Date());
		memComment.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		//父id不为空则是评论，否则是回复,回复直接保存
		if (StringUtils.isBlank(memComment.getFatherId())) {
			switch (typeEnum) {
				case SP://食谱
					break;
				case CZGJ://成长轨迹
					break;
				case BN://banner
					break;
				case DT://动态
					break;
				case GG://公告
					break;
				case HD://活动
					break;
				case QD://签到
					break;
				case ZX://资讯
					BaseSchoolInfo baseSchoolInfo = baseSchoolInfoMapper.selectById(memComment.getSourceId());
					BaseSchoolInfo entity = new BaseSchoolInfo();
					entity.setId(baseSchoolInfo.getId());
					entity.setPointCount(baseSchoolInfo.getCommentCount() - 1);
					baseSchoolInfoMapper.updateById(entity);
					break;
				default:
					break;
			}
		}
		baseMapper.updateById(memComment);
		return memComment;
	}

	@Override
	public List<MemComment> findComment(Page<MemComment> pageComment, String memberId, String sourceId) {
		List<MemComment> commentsList = baseMapper.selectTopCommentList(pageComment, memberId, sourceId);
		if (commentsList == null || commentsList.isEmpty()) {
			return null;
		}
		List<MemComment> list = findChildComment(commentsList, memberId, sourceId);
		pageComment.setRecords(list);
		return list;
	}

	private List<MemComment> findChildComment(List<MemComment> commentsList, String memberId, String sourceId) {
		List<MemComment> childComment = commentsList;
		if (commentsList == null || commentsList.isEmpty()) {
			return null;
		}
		for (MemComment memComment : commentsList) {
			List<MemComment> list = baseMapper.selectChildCommentList(memComment, memberId, sourceId);
			if (findChildComment(list, memberId, sourceId) == null) {
				return childComment;
			}
			memComment.setReplys(list);
			childComment.add(memComment);
		}
		return childComment;
	}
}
