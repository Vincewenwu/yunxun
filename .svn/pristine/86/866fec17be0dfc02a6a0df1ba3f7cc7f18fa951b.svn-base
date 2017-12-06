package com.vision.edu.platform.core.controller;

import com.vision.edu.framework.support.HttpCode;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * 信息返回控制器
 * @title 
 * @filename ResponseController.java
 * @author XieFan
 * @date 2017年3月28日 下午8:14:11
 * @version 1.0
 */
public class ResponseController {
    /**
     * 渲染失败数据
     *
     * @return result
     */
    protected JsonResult renderError() {
        JsonResult result = new JsonResult();
        result.setSuccess(false);
        result.setStatus(HttpCode.OK.name());
        return result;
    }

    /**
     * 渲染失败数据（带消息）
     *
     * @param msg 需要返回的消息
     * @return result
     */
    protected JsonResult renderError(String msg) {
        JsonResult result = renderError();
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染成功数据
     *
     * @return result
     */
    protected JsonResult renderSuccess() {
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setStatus(HttpCode.BAD_REQUEST.name());
        return result;
    }

    /**
     * 渲染成功数据（带信息）
     *
     * @param msg 需要返回的信息
     * @return result
     */
    protected JsonResult renderSuccess(String msg) {
        JsonResult result = renderSuccess();
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染成功数据（带数据）
     *
     * @param obj 需要返回的对象
     * @return result
     */
    protected JsonResult renderSuccess(Object obj) {
        JsonResult result = renderSuccess();
        result.setObj(obj);
        return result;
    }
    
    /**
     * 返回其他数据数据（带数据）
     *
     * @param obj 需要返回的对象
     * @return result
     */
    protected JsonResult renderOther(String code,String mes) {
        JsonResult result = renderSuccess();
        result.setMsg(mes);
        result.setStatus(code);
        return result;
    }
}
