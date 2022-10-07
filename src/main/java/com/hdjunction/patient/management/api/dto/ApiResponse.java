package com.hdjunction.patient.management.api.dto;

public class ApiResponse<T> {

    private String message;
    private T body;

    private ApiResponse(String message, T body) {
        this.message = message;
        this.body = body;
    }

    public static ApiResponse error(String message) {
        return new ApiResponse(message, null);
    }

    public static <T> ApiResponse<T> success(T body) {
        return new ApiResponse<>("", body);
    }

    public String getMessage() {
        return message;
    }

    public T getBody() {
        return body;
    }
}
