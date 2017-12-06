package com.vision.edu.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.system.SysPrincipalMailbox;
import com.vision.edu.mapper.system.SysPrincipalMailboxMapper;
import com.vision.edu.service.system.ISysPrincipalMailboxService;

/**
 * <p>
 * 园长信箱 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class SysPrincipalMailboxServiceImpl extends ServiceImpl<SysPrincipalMailboxMapper, SysPrincipalMailbox> implements ISysPrincipalMailboxService {

	@Autowired
	private SysPrincipalMailboxMapper sysPrincipalMailboxMapper; //注入sysPrincipalMailboxMapper
	
	/**
	 *新增园长信箱的信息
	 *@param sysPrincipalMailbox 园长信箱对象
	 */
	@Override
	public void addPrincipal(SysPrincipalMailbox sysPrincipalMailbox) {
		this.sysPrincipalMailboxMapper.insert(sysPrincipalMailbox);

	}
	
}
