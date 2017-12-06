package com.vision.edu.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.EmailDTO;
import com.vision.edu.entity.system.SysPrincipalMailbox;

/**
 * <p>
  * 园长信箱 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface SysPrincipalMailboxMapper extends BaseMapper<SysPrincipalMailbox> {

	/**
	 * 查询园长信箱
	 * @author jiangwangying
	 * @date 2017年8月7日 上午8:44:33
	 * @param page 分页
	 * @param senderType 发件人类型
	 * @param schoolId 园校id
	 * @param vague 模糊搜索
	 * @return
	 */
	public List<EmailDTO> findPrincipalMail(Pagination page,@Param("senderType")Integer senderType,@Param("schoolId") String schoolId,@Param("vague") String vague);

	/**
	 * 查询发送人发送内容
	 * @author jiangwangying
	 * @date 2017年8月7日 上午10:52:00
	 * @param id
	 * @param memberId
	 * @return
	 */
	public List<EmailDTO> findMailById(@Param("id") String id,@Param("memberId") String memberId);
}