package com.example.usercenter.common;

public class ResultUtils {
    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<T>(0,data,"ok");
    }


    public static BaseResponse<String> success(String data) {
        return new BaseResponse<String>(0,data,"ok");
    }

    /**
     * 失败
     * @param errorCode
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse(errorCode.getCode(),null,errorCode.getMessage(),errorCode.getDescription());
    }

    /**
     *
     * @param code
     * @param message
     * @param description
     * @return
     */
    public static BaseResponse error(int code,String message,String description) {
        return new BaseResponse(code,null,message,description);
    }

    /**
     *
     * @param errorCode
     * @param message
     * @param description
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode,String message,String description) {
        return new BaseResponse(errorCode.getCode(),null,message,description);
    }
    /**
     *
     * @param errorCode
     * @param description
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode,String description) {
        return new BaseResponse(errorCode.getCode(),errorCode.getMessage(),description);
    }
}
