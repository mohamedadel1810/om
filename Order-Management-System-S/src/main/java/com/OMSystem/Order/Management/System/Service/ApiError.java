package com.OMSystem.Order.Management.System.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiError {

    private String code;
    private String message;

    public ApiError(String success, String message) {
    }
}
