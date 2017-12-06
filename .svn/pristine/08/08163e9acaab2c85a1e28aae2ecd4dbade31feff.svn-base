package com.vision.edu.service.member.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MemClassCircleDTO;
import com.vision.edu.dto.OneBabybaseSurrogateDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.member.MemClassCircle;
import com.vision.edu.entity.member.MemDynamic;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumResourceType;
import com.vision.edu.mapper.member.MemClassCircleMapper;
import com.vision.edu.mapper.member.MemDynamicMapper;
import com.vision.edu.service.member.IMemClassCircleService;

/**
 * <p>
 * 班级圈 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemClassCircleServiceImpl extends ServiceImpl<MemClassCircleMapper, MemClassCircle> implements IMemClassCircleService {
      @Autowired
      private MemClassCircleMapper memClassCircleMapper;
      
      @Autowired
      private MemDynamicMapper memDynamicMapper;
      /**
  	 * 查询班级《圈》信息
  	 * @author ChenWenWu
  	 * @date 2017年7月24日 下午3:27:03
  	 * @param page
  	 * @param memClassCircleDTO 班级圈实体
  	 * @return
  	 */
	public List<MemClassCircleDTO> findMemClassCircleDTO(Pagination page,
			MemClassCircleDTO memClassCircleDTO) {
		return memClassCircleMapper.findMemClassCircleDTO(page, memClassCircleDTO);
	}
	 /**
	  * 删除班级圈
	  * @author ChenWenWu
	  * @date 2017年7月24日 下午4:10:45
	  * @param ids 班级圈集合
	  * @return
	  */
	public Integer delMemClassCircle(String ids,String updateMan) {
		String [] id = ids.split(",");
		String []  aa=new String[id.length];
		 Integer num=0;
		 MemClassCircle memClassCircle=new MemClassCircle();
		 memClassCircle.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
	     memClassCircle.setUpdateMan(updateMan);
		 for (int i = 0; i < id.length; i++) {
			 aa[i]=id[i];
		 }
		 for(int i = 0; i <aa.length; i++){
			 memClassCircle.setId(aa[i]);
		     num+= memClassCircleMapper.updateById(memClassCircle);
		 }
		return num;
	}
	 /**
	  * 新增班级圈同时发布动态
	  * @author ChenWenWu
	  * @date 2017年7月24日 下午4:10:45
	  * @param MemClassCircle 班级圈集合
	  * @return
	  */
	@Override
	public Integer addClassDT(MemClassCircle memClassCircle) {
		memClassCircle.setCreateTime(new Date());
    	memClassCircle.setBrowseCount(0);
    	memClassCircle.setPointCount(0);
    	memClassCircle.setCommentNum(0);
    	memClassCircle.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
	Integer i = memClassCircleMapper.insert(memClassCircle);
	Integer j=0;
		if (i>0) {
		MemDynamic memDynamic = new MemDynamic();
		memDynamic.setResourcesId(memClassCircle.getId()); //班级圈
		memDynamic.setResourcesType(EnumResourceType.DT.getValue());
		memDynamic.setClassId(memClassCircle.getClassId());
		memDynamic.setSchoolId(memClassCircle.getSchoolId());
		memDynamic.setBrowseCount(0);//浏览数
		memDynamic.setPointCount(0);//点赞数
		memDynamic.setCreateTime(new Date());
		memDynamic.setCreateMamId(memClassCircle.getCreateMamId());
        memDynamic.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		 j=memDynamicMapper.insert(memDynamic);
		}else{
			return 0;
		}
		return j;
	}
	
}
