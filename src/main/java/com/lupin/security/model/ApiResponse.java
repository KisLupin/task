package com.lupin.security.model;

import com.lupin.security.common.ErrorCode;
import com.lupin.security.exception.RestApiException;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {

    private Integer status;

    private Object data;

    private String errorCode;

    private String message;

    public ApiResponse(Integer status, Object data, String errorCode, String message) {
        super();
        this.status = status;
        this.data = data;
        this.errorCode = errorCode;
        this.message = message;
    }

    public ApiResponse(Integer status, Object data) {
        super();
        this.status = status;
        this.data = data;
    }

    public ApiResponse(RestApiException ex) {
        super();
//        this.status = ApiResponseStatus.FAILED.getValue();
        this.errorCode = ex.getErrorCode();
        this.message = ex.getDefaultMessage();
        this.data = ex.getData();
    }

    public ApiResponse(Exception ex, ErrorCode errorCode) {
        super();
//        this.status = ApiResponseStatus.FAILED.getValue();
        this.errorCode = errorCode.getErrorCode();
        this.message = ex.getMessage();
    }
}
