package com.OMSystem.Order.Management.System.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private T data;
    private ApiError error;

    public ApiResponse(boolean b, T data, Object o) {
    }


    public static <T> ApiResponse <T> ok(T data){
        return new ApiResponse<>(true,data,null);
    }
    public static ApiResponse<Void> okMessage(String message){
        return new ApiResponse<>(true ,null,new ApiError("SUCCESS",message));
    }

    public static <T> ApiResponse<T> fail(
            String code,
            String message
            ){

        return new ApiResponse<>(false,null,new ApiError(code,message));

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }
}
