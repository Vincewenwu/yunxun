package com.vision.edu.service.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.ParentBaseMemberDTO;
import com.vision.edu.entity.member.MemParentBaby;
import com.vision.edu.mapper.member.MemParentBabyMapper;
import com.vision.edu.service.member.IMemParentBabyService;

/**
 * <p>
 * 家长宝贝表 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-03
 */
@Service
public class MemParentBabyServiceImpl extends ServiceImpl<MemParentBabyMapper, MemParentBaby> implements IMemParentBabyService {
       @Autowired
      private MemParentBabyMapper memParentBabyMapper;

       
       /**
   	 * 根据家长ID查家长的基本信息
   	 * @author ChenWenWu
   	 * @date 2017年7月8日 下午10:07:43
   	 * @param memberid
   	 * @return
   	 */
	public ParentBaseMemberDTO findParentBaseMemberDTO(String memberid) {
		return memParentBabyMapper.findParentBaseMemberDTO(memberid);
	}
	
	
}
