package by.kovalyov.diplomgym.dto;

import lombok.Data;

public class SignupUserResponseDto {
    private String result;

    public SignupUserResponseDto(String result) {
        this.result = result;
    }
}
