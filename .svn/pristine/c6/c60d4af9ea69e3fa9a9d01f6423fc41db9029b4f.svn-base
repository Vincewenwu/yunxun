package com.vision.edu.service.member.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.member.MemPraise;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumPraiseFlag;
import com.vision.edu.enums.EnumResourceType;
import com.vision.edu.framework.exception.BusinessException;
import com.vision.edu.mapper.base.BaseSchoolInfoMapper;
import com.vision.edu.mapper.member.MemPraiseMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.member.IMemPraiseService;

/**
 * <p>
 * 点赞记录 服务实现类
 * </p>
 * @author XieFan
 * @since 2017-07-14
 */
@Transactional
@Service
public class MemPraiseServiceImpl extends ServiceImpl<MemPraiseMapper, MemPraise> implements IMemPraiseService {

	@Autowired
	private MemPraiseMapper memPraiseMapper; //注入MemPraiseMapper

	@Autowired
	private BaseSchoolInfoMapper baseSchoolInfoMapper;

	/**
	 * 新增育儿知识详情评论的点赞信息
	 * @param 表扬实体
	 */
	@Override
	public void addYunErKnowCommentParise(MemPraise memPraise) {
		this.memPraiseMapper.insert(memPraise);

	}

	/**
	 * 园丁点赞数的新增
	 * @author:zyml
	 * @date:2017年7月11日上午11:24:01
	 * @param memPraise 表扬实体
	 */
	@Override
	public JsonResult addTeacherParise(MemPraise memPraise) {
		JsonResult rs = null;
		try {
			System.out.println("================================");
			rs = new JsonResult();
			String userId = memPraise.getMemberId(); //获取用户id
			Integer cancel = 1; //已经
			String sourseId = memPraise.getSourceId();
			memPraise.setMemberId(userId);
			memPraise.setCancelNo(cancel);
			memPraise.setSourceId(sourseId);
			memPraise.setCreateTime(new Date());
			memPraise.setPraiseType(1);
			memPraise.setDeleteFlag(1);
			this.memPraiseMapper.insert(memPraise);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 根据id进行查询点赞数是否唯一显示相应的状态
	 * @author:zyml
	 * @date:2017年7月22日下午5:46:45
	 * @param userId 用户id
	 */
	@Override
	public MemPraise findByUserId(String userId, String sourceId) {
		MemPraise memPraise = memPraiseMapper.findByUserId(userId, sourceId);
		return memPraise;
	}

	@Override
	public void addPrincipalParise(MemPraise memPraise) {
		// TODO Auto-generated method stub

	}

	@Override
	public JsonResult UpdateDianZanNum(MemPraise memPraise) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 园长赞数的修改
	 * @author:zyml
	 * @date:2017年7月12日上午8:20:24
	 * @param BaseSchoolInfo 校园资讯
	 */
	@Override
	public JsonResult UpdateYuanZhangDianZanNum(MemPraise memPraise) {
		JsonResult rs = null;
		try {
			rs = new JsonResult();
			String priaseId = memPraise.getId();
			memPraise = memPraiseMapper.findByPriaseId(priaseId);
			Integer cancel = memPraise.getCancelNo();
			if (cancel == 0) {
				cancel = 1;
			} else if (cancel == 1) {
				cancel = 0;
			}
			memPraise.setCancelNo(cancel);
			this.memPraiseMapper.updateById(memPraise);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public JsonResult insertZiXunPraseCount(MemPraise memPraise) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 园长点赞数的增加
	 * @author:zyml
	 * @date:2017年7月23日上午8:33:16
	 * @param MemPraise 点赞实体
	 */
	@Override
	public JsonResult insertYuanZhangPraseCount(MemPraise memPraise) {
		JsonResult rs = null;
		try {
			System.out.println("================================");
			rs = new JsonResult();
			String userId = memPraise.getMemberId(); //获取用户id
			Integer cancel = 1; //已经
			String sourseId = memPraise.getSourceId();
			memPraise.setMemberId(userId);
			memPraise.setCancelNo(cancel);
			memPraise.setSourceId(sourseId);
			memPraise.setCreateTime(new Date());
			memPraise.setPraiseType(1);
			memPraise.setDeleteFlag(1);
			this.memPraiseMapper.insert(memPraise);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 根据点赞记录id进行查询
	 * @author:zyml
	 * @date:2017年7月23日下午10:06:42
	 * @param priaseId 点赞记录id
	 */
	@Override
	public MemPraise findByPriaseId(String priaseId) {
		MemPraise memPraise = memPraiseMapper.findByPriaseId(priaseId);
		return memPraise;
	}

	/**
	 * 园长点赞数的修改
	 * @author:zyml
	 * @date:2017年7月23日上午8:33:16
	 * @param MemPraise 点赞实体
	 */
	@Override
	public JsonResult UpdateYuanDingDianZanNum(MemPraise memPraise) {
		JsonResult rs = null;
		try {
			rs = new JsonResult();
			String priaseId = memPraise.getId();
			memPraise = memPraiseMapper.findByPriaseId(priaseId);
			Integer cancel = memPraise.getCancelNo();
			if (cancel == 0) {
				cancel = 1;
			} else if (cancel == 1) {
				cancel = 0;
			}
			memPraise.setCancelNo(cancel);
			this.memPraiseMapper.updateById(memPraise);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public MemPraise changePraise(MemPraise memPraise) {
		if (StringUtils.isAnyBlank(memPraise.getMemberId(), memPraise.getSourceId()) || memPraise.getPraiseType() == null) {
			throw new BusinessException("参数不全，所需参数为：MemberId，SourceId，PraiseType");
		}
		EnumResourceType typeEnum = EnumResourceType.get(memPraise.getPraiseType());
		if (typeEnum == null) {
			throw new BusinessException("PraiseType参数不正确");
		}
		if (StringUtils.isNotBlank(memPraise.getId())) {
			if (memPraise.getCancelNo() == EnumPraiseFlag.DZ.getValue()) {
				memPraise = this.cancelPraise(memPraise, typeEnum);//取消点赞
			} else {
				memPraise = this.addAgainPraise(memPraise, typeEnum);//再次点赞
			}
		} else {
			memPraise = this.addPraise(memPraise, typeEnum);//首次点赞
		}
		return memPraise;
	}

	/**
	 * 取消点赞
	 * @author zhangfeihong
	 * @date 2017年7月25日 下午8:26:15
	 * @param memPraise
	 * @param typeEnum
	 * @return
	 */
	private MemPraise cancelPraise(MemPraise memPraise, EnumResourceType typeEnum) {
		memPraise.setCancelNo(EnumPraiseFlag.QXDZ.getValue());
		memPraise.setUpdateTime(new Date());
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
				BaseSchoolInfo baseSchoolInfo = baseSchoolInfoMapper.selectById(memPraise.getSourceId());
				baseSchoolInfo.setPointCount(baseSchoolInfo.getPointCount() - 1);
				baseSchoolInfoMapper.updateById(baseSchoolInfo);
				break;
			default:
				break;
		}
		baseMapper.updateById(memPraise);
		return memPraise;
	}

	/**
	 * 取消点赞后的再次点赞
	 * @author zhangfeihong
	 * @date 2017年7月25日 下午8:21:45
	 * @param memPraise
	 * @param typeEnum
	 */
	private MemPraise addAgainPraise(MemPraise memPraise, EnumResourceType typeEnum) {
		memPraise.setCancelNo(EnumPraiseFlag.DZ.getValue());
		memPraise.setUpdateTime(new Date());
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
				BaseSchoolInfo baseSchoolInfo = baseSchoolInfoMapper.selectById(memPraise.getSourceId());
				baseSchoolInfo.setPointCount(baseSchoolInfo.getPointCount() + 1);
				baseSchoolInfoMapper.updateById(baseSchoolInfo);
				break;
			default:
				break;
		}
		baseMapper.updateById(memPraise);
		return memPraise;

	}

	/**
	 * 新增点赞
	 * @author zhangfeihong
	 * @date 2017年7月25日 下午8:18:59
	 * @param memPraise
	 * @param typeEnum
	 */
	private MemPraise addPraise(MemPraise memPraise, EnumResourceType typeEnum) {
		memPraise.setCreateTime(new Date());
		memPraise.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		memPraise.setCancelNo(EnumPraiseFlag.DZ.getValue());
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
				BaseSchoolInfo baseSchoolInfo = baseSchoolInfoMapper.selectById(memPraise.getSourceId());
				baseSchoolInfo.setPointCount(baseSchoolInfo.getPointCount() + 1);
				baseSchoolInfoMapper.updateById(baseSchoolInfo);
				break;
		}
		baseMapper.insert(memPraise);
		return memPraise;
	}
}
