package com.vision.edu.service.system;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.EmailDTO;
import com.vision.edu.entity.system.SysPrincipalMailbox;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 园长信箱 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface ISysPrincipalMailboxService extends IService<SysPrincipalMailbox> {

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
	List<EmailDTO> findPrincipalMail(Pagination page,Integer senderType,String schoolId,String vague);

	/**
	 * 发送人发送内容
	 * @author jiangwangying
	 * @date 2017年8月7日 上午10:52:00
	 * @param id
	 * @param memberId
	 * @return
	 */
    List<EmailDTO> findMailById(String id, String memberId);
    
	/**
	 * 园长回复
	 * @author jiangwangying
	 * @date 2017年8月7日 上午11:42:36
	 * @param id 父id
	 * @param content 内容
	 * @param memberId  园长的 memberId
	 * @param createMan 新建人
	 * @return
	 */
	JsonResult addPrincipalMail(String id, String content, String memberId, String createMan);

	/**
	 * 删除信件
	 * @author jiangwangying
	 * @date 2017年7月24日 下午11:36:48
	 * @param mailIds
	 * @return
	 */
	JsonResult delMail(String mailIds);
}
