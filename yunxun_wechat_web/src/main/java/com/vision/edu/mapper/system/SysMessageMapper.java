package com.vision.edu.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.dto.MyMessageDto;
import com.vision.edu.dto.TheTeacherAddressBookDao;
import com.vision.edu.entity.system.SysMessage;

/**
 * <p>
  * 消息通知 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface SysMessageMapper extends BaseMapper<SysMessage> {
	
	/**
	 * 根据宝贝id查询个人消息
	 * @author lichenglong
	 * @date 2017年7月19日 下午9:10:38
	 * @param sendeeId 接收人id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<MyMessageDto> findPersonalDetails(@Param("sendeeId")String sendeeId,@Param("deleteFlag")Integer deleteFlag);

	/**
	 * 根据消息id查询消息详情
	 * @author lichenglong
	 * @date 2017年7月20日 下午8:47:29
	 * @param messageId 信息id
	 * @return
	 */
	List<MyMessageDto> findMessageForDetails(@Param("messageId")String messageId);
	
	/**
	 * 老师通讯录
	 * @author lichenglong
	 * @date 2017年7月21日 下午4:25:02
	 * @param babyId 宝贝id
	 * @return
	 */
	List<TheTeacherAddressBookDao> findAddressBook(@Param("babyId")String babyId);
	
	/**
	 * 根据教师id查询教师消息
	 * @author lichenglong
	 * @date 2017年7月24日 上午10:01:33
	 * @param sendId 教师id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<MyMessageDto> findtheTeacherAMessage(@Param("sendId")String sendId,@Param("deleteFlag")Integer deleteFlag);
	
	/**
	 * 查看没有阅读消息条数
	 * @author lichenglong
	 * @date 2017年7月24日 上午10:22:42
	 * @param sendeeId 发送人id
	 * @param readFlag 阅读状态
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<SysMessage> findDidnReadTheMessage(@Param("sendId")String sendId,@Param("readFlag")Integer readFlag,@Param("deleteFlag")Integer deleteFlag);
}