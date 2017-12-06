package com.vision.edu.service.base;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.base.BaseEvalContent;

/**
 * <p>
 * 评测内容 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseEvalContentService extends IService<BaseEvalContent> 
{
	/**
	 * 获取评测内容 列表
	 * @author ChenYuanRong
	 * @date 2017年7月25日 下午4:01:00
	 * @return
	 */
	public List<BaseEvalContent> getEvalContentList( String evalProjectId);
}
