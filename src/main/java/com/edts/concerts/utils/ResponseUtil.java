package com.edts.concerts.utils;

import com.edts.concerts.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

    public static <T> BaseResponse<T> success() {
        return success((T) null);
    }

    public static <T> BaseResponse<T> success(T result) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setCode(String.valueOf(HttpStatus.OK.value()));
        baseResponse.setMessage("success");
        baseResponse.setResult(result);
        return baseResponse;
    }

    public static <T> BaseResponse<T> failed(T result) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        baseResponse.setMessage("failed");
        baseResponse.setResult(result);
        return baseResponse;
    }

}
