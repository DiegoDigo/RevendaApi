package br.com.control.revenda.entity;

import br.com.control.revenda.entity.enums.EnvironmentEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@ToString
@Entity(name = "revendas")
public class Revenda implements Serializable {

    @Id
    private String id;
    @NotNull
    @Column(unique = true)
    private int license;
    @NotNull
    @NotEmpty
    @Column(columnDefinition = "varchar(50)", length = 50)
    private String name;
    @Enumerated(EnumType.STRING)
    private EnvironmentEnum environment;
    @NotNull
    @NotEmpty
    @Column(columnDefinition = "varchar(15)", length = 15)
    private String cnpj;
    private Boolean configured;


    public Revenda(int license, String name, EnvironmentEnum environment, String cnpj) {
        this.id = UUID.randomUUID().toString();
        this.license = license;
        this.name = name;
        this.environment = environment;
        this.cnpj = cnpj;
        this.configured = false;
    }


    public Revenda() {
        this.id = UUID.randomUUID().toString();
        this.configured = false;
    }


}
