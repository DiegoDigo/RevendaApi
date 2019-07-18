package br.com.control.revenda.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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


    public Revenda(Integer license, String name) {
        this.id = UUID.randomUUID().toString();
        this.license = license;
        this.name = name;
    }

    public Revenda() {
        this.id = UUID.randomUUID().toString();
    }
}
