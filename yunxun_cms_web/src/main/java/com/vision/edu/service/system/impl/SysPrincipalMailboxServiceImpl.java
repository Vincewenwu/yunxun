package com.vision.edu.service.system.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.EmailDTO;
import com.vision.edu.entity.system.SysPrincipalMailbox;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.enums.EnumMessageState;
import com.vision.edu.mapper.system.SysPrincipalMailboxMapper;
import com.vision.edu.platform.common.result.JsonResult;
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
	private SysPrincipalMailboxMapper sysPrincipalMailboxMapper;

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
	@Override
	public List<EmailDTO> findPrincipalMail(Pagination page,Integer senderType,String schoolId,String vague) {

		return sysPrincipalMailboxMapper.findPrincipalMail(page,senderType,schoolId, vague);
	}
	
	/**
	 * 查询发送人发送内容
	 * @author jiangwangying
	 * @date 2017年8月7日 上午10:52:00
	 * @param id
	 * @param memberId
	 * @return
	 */
    public List<EmailDTO> findMailById(String id, String memberId){
	   return sysPrincipalMailboxMapper.findMailById(id,memberId);
	}
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
	public JsonResult addPrincipalMail(String id, String content, String memberId, String createMan){
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.setSuccess(false);
		int result = 0;
		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(content) || StringUtils.isEmpty(createMan) || id.trim()=="" || content.trim()=="") {
			jsonResult.setMsg("空值啦");
			return jsonResult;
		}
		
		EntityWrapper<SysPrincipalMailbox> ew = new EntityWrapper<SysPrincipalMailbox>();
  		ew.where("id = {0}",id);
		ew.setSqlSelect("recipient_id AS recipientId,sender_id as senderId,state,delete_flag as deleteFlag");
		List<SysPrincipalMailbox> mailList = sysPrincipalMailboxMapper.selectList(ew);
		if (mailList.size() == 0) {
			jsonResult.setMsg("row = 0");
			return jsonResult;
		} 
		
		if (!memberId.equals(mailList.get(0).getRecipientId())) {
			jsonResult.setMsg("出错啦");
			return jsonResult;
		}
		
		
		SysPrincipalMailbox sysPrincipalMailbox = null;;
		
		sysPrincipalMailbox = new SysPrincipalMailbox();
		sysPrincipalMailbox.setId(id);
		sysPrincipalMailbox.setState(EnumMessageState.YHF.getValue());
		sysPrincipalMailbox.setSeeTime(new Date());
		result += sysPrincipalMailboxMapper.updateById(sysPrincipalMailbox);
		
		sysPrincipalMailbox = new SysPrincipalMailbox();
		sysPrincipalMailbox.setCreateTime(new Date());
		sysPrincipalMailbox.setSenderId(mailList.get(0).getRecipientId());
		sysPrincipalMailbox.setRecipientId(mailList.get(0).getSenderId());
		sysPrincipalMailbox.setLetterContent(content);
		sysPrincipalMailbox.setFatherId(id);
		sysPrincipalMailbox.setSenderType(EnumMemberType.YZ.getValue());
		sysPrincipalMailbox.setState(EnumMessageState.WD.getValue());
		sysPrincipalMailbox.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		result += sysPrincipalMailboxMapper.insert(sysPrincipalMailbox);
		if (result>0) {
			jsonResult.setMsg("回复成功");
			jsonResult.setSuccess(true);
		}else {
			jsonResult.setMsg("回复失败");
		}
		
		return jsonResult;
	}
	
	/**
	 * 删除信件
	 * @author jiangwangying
	 * @date 2017年7月24日 下午11:36:48
	 * @param mailIds
	 * @return
	 */
	@Override
	public JsonResult delMail(String mailIds){
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.setSuccess(false);
		if (StringUtils.isEmpty(mailIds)) {
			return jsonResult;
		}
		
		String[] ids = mailIds.split(",");
		Integer idsLength = ids.length;
		Integer result = 0;
		
		SysPrincipalMailbox sysPrincipalMailbox = null;
		
		for (int i = 0; i < idsLength; i++) {
			sysPrincipalMailbox = new SysPrincipalMailbox();
			sysPrincipalMailbox.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			sysPrincipalMailbox.setId(ids[i]);
			result += sysPrincipalMailboxMapper.updateById(sysPrincipalMailbox);
			if (result==idsLength) {
				jsonResult.setSuccess(true);
			}
		}
		
		return jsonResult;
	}
}
