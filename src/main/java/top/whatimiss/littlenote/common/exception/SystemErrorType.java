package top.whatimiss.littlenote.common.exception;

import lombok.Getter;


/**
 * Copyright (c) 2020 Cloud-Ark Inc.
 * Author(s): Ma Wei (mawei@cloud-ark.com)
 */
@Getter
public enum SystemErrorType implements ErrorType {

    SYSTEM_ERROR("500", "系统异常"),
    SYSTEM_BUSY("000001", "系统繁忙,请稍候再试"),

    GATEWAY_NOT_FOUND_SERVICE("404", "服务未找到"),

    GATEWAY_ERROR("010500", "网关异常"),
    GATEWAY_CONNECT_TIME_OUT("010002", "网关超时"),

    ARGUMENT_NOT_VALID("020000", "请求参数校验不通过"),
    UPLOAD_FILE_SIZE_LIMIT("020010", "上传文件大小超过限制"),

    DUPLICATE_PRIMARY_KEY("030000", "数据库中已存在该记录"),

    ILLEGAL_CHARACTER("040000", "包含非法字符"),

    NO_AUTHORIZATION("050000", "没有权限，请联系管理员授权"),
    GENERATE_TOKEN_ERROR("050001", "生成Token失败"),
    TOKEN_INVALID("020001", "invalid token"),
    TOKEN_EXPIRED("020002", "expired token"),
    UNAUTHORIZED("401", "Unauthorized"),

    ACCOUNT_INEXISTENCE("060000", "账号不存在"),
    ERROR_PASSWORD("060001", "密码不正确");

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String mesg;

    SystemErrorType(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }
}
