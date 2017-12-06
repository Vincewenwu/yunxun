package com.vision.edu.service.system;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.MyMessageDto;
import com.vision.edu.dto.TheTeacherAddressBookDao;
import com.vision.edu.entity.system.SysMessage;

/**
 * <p>
 * 消息通知 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface ISysMessageService extends IService<SysMessage> {

	/**
	 * 根据宝贝id查询个人消息
	 * @author lichenglong
	 * @date 2017年7月19日 下午9:10:38
	 * @param sendeeId 接收人id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<MyMessageDto> findPersonalDetails(String sendeeId, Integer deleteFlag);

	/**
	 * 根据消息id查询消息详情
	 * @author lichenglong
	 * @date 2017年7月20日 下午8:47:29
	 * @param messageId 信息id
	 * @return
	 */
	List<MyMessageDto> findMessageForDetails(String messageId);

	/**
	 * 老师通讯录
	 * @author lichenglong
	 * @date 2017年7月21日 下午4:25:02
	 * @param babyId 宝贝id
	 * @return
	 */
	List<TheTeacherAddressBookDao> findAddressBook(String babyId);

	/**
	 * 根据教师id查询教师消息
	 * @author lichenglong
	 * @date 2017年7月24日 上午10:01:33
	 * @param sendId 教师id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<MyMessageDto> findtheTeacherAMessage(String sendId, Integer deleteFlag);

	/**
	 * 查看没有阅读消息条数
	 * @author lichenglong
	 * @date 2017年7月24日 上午10:22:42
	 * @param sendId 发送人id
	 * @param readFlag 阅读状态
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<SysMessage> findDidnReadTheMessage(String sendId, Integer readFlag, Integer deleteFlag);
	
	
	
}
