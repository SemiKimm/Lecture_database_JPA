package com.nhnacademy.springjpa.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PostRegisterRequest {
//    @Max(255)
    @NotBlank
    String Title;
//    @Max(3000)
    @NotBlank
    String content;
}
