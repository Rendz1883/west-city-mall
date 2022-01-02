package io.github.ireflux.westcitymall.enums;

public enum ResponseStatus {

    SUCCESS(200, "成功"),
    FAIL(500, "失败"),
    ERROR(9999, "系统错误"),

    ;

    private int code;
    private String msg;

    ResponseStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
