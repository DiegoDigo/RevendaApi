package br.com.control.revenda.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevendaDTO {

    @NotNull
    private Integer license;
    @NotNull
    @NotEmpty
    private String name;

}
