package br.com.control.revenda.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@ToString
@Entity(name = "fila")
public class Fila {

    @Id
    private String id;
    @NotNull
    @NotEmpty
    @Column(columnDefinition = "varchar(50)", length = 50)
    private String username;
    @NotNull
    @NotEmpty
    @Column(columnDefinition = "varchar(50)", length = 50)
    private String password;
    @NotNull
    private int portPainel;
    @NotNull
    private int portTcp;

    public Fila() {
        this.id = UUID.randomUUID().toString();
    }

    public Fila(String username, String password, int portPainel, int portTcp) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.portPainel = portPainel;
        this.portTcp = portTcp;
    }
}
