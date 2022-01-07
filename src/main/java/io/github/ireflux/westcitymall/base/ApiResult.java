package io.github.ireflux.westcitymall.base;

import io.github.ireflux.westcitymall.enums.ResponseStatus;

public class ApiResult {

    private Integer code;
    private String msg;
    private Object data;

    public ApiResult() {
    }

    public ApiResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ApiResult success(){
        return new ApiResult(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMsg(), null);
    }

    public static ApiResult success(Object data){
        return new ApiResult(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMsg(), data);
    }

    public static ApiResult success(String msg, Object data){
        return new ApiResult(ResponseStatus.SUCCESS.getCode(), msg, data);
    }
    public static ApiResult success(Integer code,String msg, Object data){
        return new ApiResult(code,msg, data);
    }

    public static ApiResult fail(){
        return new ApiResult(ResponseStatus.FAIL.getCode(), ResponseStatus.SUCCESS.getMsg(), null);
    }

    public static ApiResult fail(Object data){
        return new ApiResult(ResponseStatus.FAIL.getCode(), ResponseStatus.SUCCESS.getMsg(), null);
    }

    public static ApiResult fail(String msg, Object data){
        return new ApiResult(ResponseStatus.FAIL.getCode(), msg, data);
    }

    public static ApiResult fail(Integer code,String msg, Object data){
        return new ApiResult(code,msg, data);
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
