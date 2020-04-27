package top.whatimiss.littlenote.common.exception;


/**
 * Copyright (c) 2020 Cloud-Ark Inc.
 * Author(s): Ma Wei (mawei@cloud-ark.com)
 */
public interface ErrorType {
    /**
     * 返回code
     *
     * @return
     */
    String getCode();

    /**
     * 返回mesg
     *
     * @return
     */
    String getMesg();
}
