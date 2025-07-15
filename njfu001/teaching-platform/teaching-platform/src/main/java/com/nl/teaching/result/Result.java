package com.nl.teaching.result;

import com.nl.teaching.common.constants.Constant;
import com.nl.teaching.enums.ErrorCode;
import lombok.Data;

import org.slf4j.MDC;

import static com.nl.teaching.common.constants.ErrorInfo.Code.FAILED;
import static com.nl.teaching.common.constants.ErrorInfo.Code.SUCCESS;
import static com.nl.teaching.common.constants.ErrorInfo.Msg.OK;


@Data
public class Result<T> {
    private int code; //业务状态码，200-成功，其它-失败
    private String msg; // 响应消息
    private T data; //响应数据
    private String requestId; //请求id

    public static Result<Void> ok() {
        return new Result<Void>(SUCCESS, OK, null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(SUCCESS, OK, data);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(FAILED, msg, null);
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> error(ErrorCode errorCode) {
        return new Result<>(Integer.valueOf(errorCode.getCode()), errorCode.getMessage(), null);
    }
    public Result() {
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.requestId = MDC.get(Constant.REQUEST_ID_HEADER);
    }

    public boolean success(){
        return code == SUCCESS;
    }

    public Result<T> requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
}
