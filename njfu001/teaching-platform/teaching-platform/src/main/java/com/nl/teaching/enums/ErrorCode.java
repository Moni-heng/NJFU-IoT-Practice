package com.nl.teaching.enums;

/**
 * 系统错误码
 **/
public enum ErrorCode {

    OK("1000", "成功"),
    SYSTEM_ERROR("1001", "系统内部异常"),

    IMAGE_CODE_KEY_ERROR("2001", "图片验证码标识不能为空"),
    VERIFY_CODE_ERROR("2002", "验证码错误"),
    SMS_INTERVAL_ERROR("2011", "频繁获取短信验证码，请稍后再试"),

    ACCESS_DENIED_EXCEPTION("3001", "没有权限访问"),
    AUTHENTICATION_ENTRY_POINT("3002", "没有登录");


    //错误码
    private String code;
    //错误信息
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

