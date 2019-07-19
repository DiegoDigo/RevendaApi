package br.com.control.revenda.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@ToString
@Entity(name = "portal_web")
public class Web {


    @Id
    private String id;
    @NotNull
    @NotEmpty
    @Column(columnDefinition = "varchar(100)")
    private String hostApi;
    @NotNull
    @NotEmpty
    @Column(columnDefinition = "varchar(100)")
    private String host;
    @NotNull
    private int port;


    public Web(String hostApi, String host, int port) {
        this.id = UUID.randomUUID().toString();
        this.hostApi = hostApi;
        this.host = host;
        this.port = port;
    }

    public Web() {
        this.id = UUID.randomUUID().toString();
    }
}
