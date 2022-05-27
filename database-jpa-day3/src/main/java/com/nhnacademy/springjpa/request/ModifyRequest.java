package com.nhnacademy.springjpa.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ModifyRequest {
    @NotBlank
    String title;
    @NotBlank
    String content;
}
