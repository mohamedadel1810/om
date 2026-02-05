package com.OMSystem.Order.Management.System.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private T data;
    private ApiError error;


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

}
