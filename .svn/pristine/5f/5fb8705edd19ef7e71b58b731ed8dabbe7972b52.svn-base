package com.vision.edu.service.member.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysql.fabric.xmlrpc.base.Data;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.member.MemApplyRecord;
import com.vision.edu.mapper.base.BaseSchoolInfoMapper;
import com.vision.edu.mapper.member.MemApplyRecordMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.member.IMemApplyRecordService;

/**
 * <p>
 * 报名记录 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemApplyRecordServiceImpl extends ServiceImpl<MemApplyRecordMapper, MemApplyRecord> implements IMemApplyRecordService {
	
	@Autowired
	private MemApplyRecordMapper memApplyRecordMapper;	//注入MemApplyRecordMapper
	
	@Autowired
	private BaseSchoolInfoMapper baseSchoolInfoMapper;
	
	/**
	*活动报名的新增
	*@author:zyml
	*@date:2017年7月11日下午8:26:39
	*@param MemApplyRecord 活动报名实体
	*/
	@Override
	public JsonResult addActBaoMing(MemApplyRecord r) {
		
		/*JsonResult rs =null;
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
		*/
		JsonResult rs=new JsonResult();
		try {
			r.setCreateTime(new Date());
			r.setDeleteFlag(0);
			r.setRemark("新增成功!");
			r.setResourcesType(1);
		    String resId = r.getResourcesId();
			int result=	this.memApplyRecordMapper.insert(r);
			if (result>0) {
				rs.setMsg("报名成功!");
				rs.setObj(result);
				rs.setSuccess(true);
			  //根据id进行查询资讯的消息	
			  BaseSchoolInfo baseSchoolInfo= baseSchoolInfoMapper.findAllThemeActDetailById(resId);
			  int applyCount = baseSchoolInfo.getApplyCount();
			  int newApplyCount = applyCount+1;
			  baseSchoolInfo.setId(resId);
			  baseSchoolInfo.setApplyCount(newApplyCount);   //将新的报名数进行获取赋值
			  this.baseSchoolInfoMapper.updateById(baseSchoolInfo);
			}else{
				rs.setMsg("报名失败！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
