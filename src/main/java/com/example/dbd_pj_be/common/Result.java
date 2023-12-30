package com.example.dbd_pj_be.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private Integer code; //响应码——200成功，400失败
    private String msg;//响应请求的具体信息

    private Integer activityId; //商店预设后给前端传活动id
    private Integer userId; //用户登录后给前端传id
    private Integer shopId; //如果是商户登录再返回一个shopId, 前端将其存在session里面
    private Integer role; //给前端反馈role类型
    private T data; //传输数据

    public Result() {}

    public void setCode(Integer code) {
        this.code = code;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public void setData(T data) {
        this.data = data;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public void getData(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void succ(T data) {
        getData(200, "操作成功", data);
    }
    public void fail(String msg) {
        getData(400, msg, null);
    }

}

