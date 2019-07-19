package br.com.control.revenda.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@ToString
@Entity(name = "portal_api")
public class Api {

    @Id
    @JsonIgnore
    private String id;
    @NotNull
    private int port;


    public Api(int port) {
        this.id = UUID.randomUUID().toString();
        this.port = port;
    }

    public Api() {
        this.id = UUID.randomUUID().toString();
    }
}
