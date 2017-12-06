package com.vision.edu.service.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.member.MemInfoGroup;
import com.vision.edu.mapper.member.MemInfoGroupMapper;
import com.vision.edu.mapper.member.MemParentBabyMapper;
import com.vision.edu.service.member.IMemInfoGroupService;

/**
 * <p>
 * 资讯组表 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemInfoGroupServiceImpl extends ServiceImpl<MemInfoGroupMapper, MemInfoGroup> implements IMemInfoGroupService {
	 @Autowired
     private MemInfoGroupMapper memInfoGroupMapper;

	public MemInfoGroupMapper getMemInfoGroupMapper() {
		return memInfoGroupMapper;
	}

	public void setMemInfoGroupMapper(MemInfoGroupMapper memInfoGroupMapper) {
		this.memInfoGroupMapper = memInfoGroupMapper;
	}
	 /**
     * 修改咨询组表
     * @author ChenWenWu
     * @date 2017年7月7日 下午4:16:15
     * @param baseGroupId 会员组D 
     * @param meninfoGroupId 咨询组ID
     * @return
     */
	public boolean editOnemeninfoGroup(MemInfoGroup memInfoGroup) {
		return memInfoGroupMapper.editOnemeninfoGroup(memInfoGroup);
	}
}
