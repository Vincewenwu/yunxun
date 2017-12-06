package com.vision.edu.service.system.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MyMessageDto;
import com.vision.edu.dto.TheTeacherAddressBookDao;
import com.vision.edu.entity.system.SysMessage;
import com.vision.edu.mapper.system.SysMessageMapper;
import com.vision.edu.service.system.ISysMessageService;

/**
 * <p>
 * 消息通知 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
@Transactional
public class SysMessageServiceImpl extends ServiceImpl<SysMessageMapper, SysMessage> implements ISysMessageService {
	
	@Autowired
	private SysMessageMapper sysMessageMapper;//注入SysMessageMapper
	
	/**
	 * 根据宝贝id查询个人消息
	 * @author lichenglong
	 * @date 2017年7月19日 下午9:10:38
	 * @param sendeeId 接收人id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	@Override
	public List<MyMessageDto> findPersonalDetails(String sendeeId,Integer deleteFlag){
		List<MyMessageDto> listMyMessageDto = sysMessageMapper.findPersonalDetails(sendeeId, deleteFlag);
		return listMyMessageDto;
	}
	
	/**
	 * 根据消息id查询消息详情
	 * @author lichenglong
	 * @date 2017年7月20日 下午8:47:29
	 * @param messageId 信息id
	 * @return
	 */
	@Override
	public List<MyMessageDto> findMessageForDetails(String messageId){
		List<MyMessageDto> listMyMessageDto = sysMessageMapper.findMessageForDetails(messageId);
		return listMyMessageDto;
	}
	
	/**
	 * 老师通讯录
	 * @author lichenglong
	 * @date 2017年7月21日 下午4:25:02
	 * @param babyId 宝贝id
	 * @return
	 */
	@Override
	public List<TheTeacherAddressBookDao> findAddressBook(String babyId){
		List<TheTeacherAddressBookDao> listTheTeacherAddressBookDao = sysMessageMapper.findAddressBook(babyId);
		return listTheTeacherAddressBookDao;
	}
	
	/**
	 * 根据教师id查询教师消息
	 * @author lichenglong
	 * @date 2017年7月24日 上午10:01:33
	 * @param sendId 教师id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	@Override
	public List<MyMessageDto> findtheTeacherAMessage(String sendId,Integer deleteFlag){
		List<MyMessageDto> listMyMessageDto = sysMessageMapper.findtheTeacherAMessage(sendId, deleteFlag);
		return listMyMessageDto;
	}
	
	/**
	 * 查看没有阅读消息条数
	 * @author lichenglong
	 * @date 2017年7月24日 上午10:22:42
	 * @param sendId 发送人id
	 * @param readFlag 阅读状态
	 * @param deleteFlag 删除类型
	 * @return
	 */
	@Override
	public List<SysMessage> findDidnReadTheMessage(String sendId,Integer readFlag,Integer deleteFlag){
		List<SysMessage> listSysMessage = sysMessageMapper.findDidnReadTheMessage(sendId, readFlag, deleteFlag);
		return listSysMessage;
	}
}
