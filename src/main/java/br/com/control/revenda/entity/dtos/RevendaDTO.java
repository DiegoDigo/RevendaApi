package br.com.control.revenda.entity.dtos;

import br.com.control.revenda.entity.enums.EnvironmentEnum;
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
    @NotNull
    private EnvironmentEnum environment;
    @NotNull
    @NotEmpty
    private String cnpj;
}
