package com.vision.edu.web.controller.upload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.vision.edu.core.base.BaseController;
import com.vision.edu.dto.uploadVo.UploadVo;
import com.vision.edu.framework.util.UploadUtil;

/**
 * 上传图片controller
 * @title 
 * @filename UploadController.java
 * @author llj
 * @date 2017年8月10日 下午8:15:53
 * @version 1.0
 */
@Controller
@RequestMapping("upload")
public class UploadController extends BaseController {
	
	@ResponseBody
	@RequestMapping("uploadImg")
	public UploadVo uploadImg() {
		UploadVo uploadVo = new UploadVo();
		String[] strings = UploadUtil.uploadImage1(super.getRequest(), "editor");
		if (strings != null) {
			uploadVo.setErrno(0);
			uploadVo.setData(strings);
		} else {
			uploadVo.setErrno(-1);
			uploadVo.setData(null);
		}
		return uploadVo;
	}

}
