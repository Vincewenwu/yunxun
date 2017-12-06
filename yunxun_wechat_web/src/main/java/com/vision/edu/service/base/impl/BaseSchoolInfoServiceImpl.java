package com.vision.edu.service.base.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.member.MemPraise;
import com.vision.edu.enums.EnumInfoType;
import com.vision.edu.enums.EnumPlatform;
import com.vision.edu.mapper.base.BaseSchoolInfoMapper;
import com.vision.edu.mapper.member.MemPraiseMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseSchoolInfoService;

/**
 * <p>
 * 校园资讯 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseSchoolInfoServiceImpl extends ServiceImpl<BaseSchoolInfoMapper, BaseSchoolInfo> implements IBaseSchoolInfoService {

	@Autowired
	private BaseSchoolInfoMapper  baseSchoolInfoMapper;   //注入BaseSchoolInfoMapper

	@Autowired
	private MemPraiseMapper memPraiseMapper;

	/**
	 *查询 banner图片墙的基本信息
	 *@author:zyml
	 *@date:2017年7月6日下午3:06:53
	 *@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	 */
	@Override
	public List<BaseEntity> findPhotoAll(Map<String, Object> map) {
		List<BaseEntity> listPhoto=baseSchoolInfoMapper.findPhotoAll(map);
		return listPhoto;
	}

	/**
	 *查询最新的主题信息
	 *@param strCode   资源id
	 *@param infoType 资讯类型
	 */
	@Override
	public List<BaseSchoolInfo> findAllThemeAct(String strCode,int infoType) {
		List<BaseSchoolInfo> listThemeAct=baseSchoolInfoMapper.findAllThemeAct(strCode,infoType);
		return listThemeAct;
	}

	/**
	 * 查询所有的新闻信息
	 */
	@Override
	public List<BaseSchoolInfo> findAllNews() {
		List<BaseSchoolInfo> listNews=baseSchoolInfoMapper.findAllNews();
		return listNews;
	}

	/**
	 *查询公告标题的最新信息
	 *@author:zyml
	 *@date:2017年7月6日下午3:40:56
	 *@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	 */
	@Override
	public List<BaseEntity> findAdvertisTitle(Map<String, Object> map) {
		List<BaseEntity> listAdvTitle = baseSchoolInfoMapper.findAdvertisTitle(map);
		return listAdvTitle;
	}

	/**
	 *根据公告标题查询公告详情信息
	 *@param strCode 公告id
	 */
	@Override
	public BaseEntity findAdvertisDetail(String strCode) {
		BaseEntity baseSchoolInfo=baseSchoolInfoMapper.findAdvertisDetail(strCode);
		return baseSchoolInfo;
	}

	/**
	 *查看资讯活动基本最新信息
	 *@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	 */
	@Override
	public List<BaseEntity> findInforMation(Map<String, Object> map) {
		List<BaseEntity> listInforMation = baseSchoolInfoMapper.findInforMation(map);
		return listInforMation;
	}

	/**
	 *根据图片的id查询图片的详细信息
	 *@param strCode 图片的id
	 */
	@Override
	public BaseEntity findPhotoAllDetail(String strCode) {
		BaseEntity photoAllDetail=baseSchoolInfoMapper.findPhotoAllDetail(strCode);
		return photoAllDetail;
	}

	/**
	 *根据ID查看资讯详细信息
	 *@param strCode 资讯id
	 */
	@Override
	public BaseSchoolInfo findInforMationDetail(String strCode, String memberId) {
		BaseSchoolInfo baseSchoolInfo = baseSchoolInfoMapper.findInforMationDetail(strCode, memberId);
		return baseSchoolInfo;
	}

	/**
	 * 开始查询咨询的评论信息
	 * @param strCode 资讯id
	 */
	@Override
	public List<BaseEntity> findInforMationDetailNext(String strCode) {
		List<BaseEntity> listInforMationDetailNext=baseSchoolInfoMapper.findInforMationDetailNext(strCode);
		return listInforMationDetailNext;
	}

	/**
	 *根据id查看主题活动的详情信息
	 *@param strCode 主题id
	 */
	@Override
	public BaseSchoolInfo findAllThemeActDetailById(String strCode) {
		BaseSchoolInfo themeActDetail=baseSchoolInfoMapper.findAllThemeActDetailById(strCode);
		return themeActDetail;
	}

	/**
	 *资讯点赞数的增加
	 *@author:zyml
	 *@date:2017年7月23日上午8:33:16
	 *@param BaseSchoolInfo 校园资讯
	 */
	@Override
	public JsonResult insertZiXunPraseCount(MemPraise memPraise) {
		JsonResult rs=null;
		try {
			System.out.println("================================");
			rs=new JsonResult();
			String userId =memPraise.getMemberId();   //获取用户id
			Integer cancel =1;                        //已经
			String sourseId=memPraise.getSourceId();
			memPraise.setMemberId(userId);
			memPraise.setCancelNo(cancel);
			memPraise.setSourceId(sourseId);
			memPraise.setCreateTime(new Date());
			memPraise.setPraiseType(1);
			memPraise.setDeleteFlag(1);
			this.memPraiseMapper.insert(memPraise);

			System.out.println("================进行修改操作====================");
			BaseSchoolInfo baseSchoolInfo = baseSchoolInfoMapper.findInforMationDetail(sourseId, null); //查询相关的数据
			Integer praiseId=baseSchoolInfo.getPointCount();
			Integer newpraiseId=praiseId+1;
			baseSchoolInfo.setPointCount(newpraiseId);
			baseSchoolInfoMapper.updateById(baseSchoolInfo);
			System.out.println("===============================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 *资讯点赞数的修改
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param BaseSchoolInfo 校园资讯点赞增加
	 */
	@Override
	public JsonResult UpdateZiXunDianZanNum(MemPraise memPraise) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			String sourseId=memPraise.getSourceId();
			System.out.println("================================");
			Integer newpraiseId= null;
			System.out.println("================进行修改操作====================");
			BaseSchoolInfo baseSchoolInfo = baseSchoolInfoMapper.findInforMationDetail(sourseId, null); //查询相关的数据
			Integer praiseId=baseSchoolInfo.getPointCount();
			Integer cancel=memPraise.getCancelNo();
			if (cancel==0) {
				newpraiseId = praiseId-1;
				cancel=1;
			}else if(cancel==1){
				cancel=0;
				newpraiseId = praiseId + 1;
			}

			memPraise.setCancelNo(cancel);
			this.memPraiseMapper.updateById(memPraise);
			baseSchoolInfo.setPointCount(newpraiseId);
			baseSchoolInfoMapper.updateById(baseSchoolInfo);
			System.out.println("===============================================");


			System.out.println("=================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 *资讯浏览量的增加
	 *@author:zyml
	 *@date:2017年7月12日上午9:09:24
	 *@param BaseSchoolInfo 校园资讯实体
	 */
	@Override
	public JsonResult addZiXunLiuLanCount(BaseSchoolInfo baseSchoolInfo) {
		JsonResult rs =null;
		try {
			rs=new JsonResult();
			int i = baseSchoolInfo.getBrowseCount();
			int newI=i+1;
			baseSchoolInfo.setBrowseCount(newI);
			this.baseSchoolInfoMapper.updateById(baseSchoolInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 *活动浏览量的增加
	 *@author:zyml
	 *@date:2017年7月12日上午9:09:24
	 *@param BaseSchoolInfo 校园资讯实体
	 */
	@Override
	public JsonResult addActLiuLanCount(BaseSchoolInfo baseSchoolInfo) {
		JsonResult rs =null;
		try {
			rs=new JsonResult();
			System.out.println("===============================================");
			int i = baseSchoolInfo.getBrowseCount();
			int newI=i+1;
			baseSchoolInfo.setBrowseCount(newI);
			this.baseSchoolInfoMapper.updateById(baseSchoolInfo);
			System.out.println("===============================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 *查看资讯活动更多信息
	 *@author:zyml
	 *@date:2017年7月7日上午10:12:13findInforMationMore
	 *@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	 */
	@Override
	public List<BaseEntity> findInforMationMore(Map<String, Object> map) {
		List<BaseEntity> listInforMation = baseSchoolInfoMapper.findInforMationMore(map);
		return listInforMation;
	}



}
