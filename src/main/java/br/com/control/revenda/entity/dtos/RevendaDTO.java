package br.com.control.revenda.entity.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RevendaDTO {

    @NotNull
    private Integer license;
    @NotNull
    @NotEmpty
    private String name;

}
