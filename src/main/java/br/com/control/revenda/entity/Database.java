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
@Entity(name = "database")
public class Database {

    @Id
    private String id;
    @Column(columnDefinition = "varchar(100)", length = 100)
    private String url;
    @NotEmpty
    @NotNull
    @Column(columnDefinition = "varchar(20)", length = 20)
    private String username;
    @NotEmpty
    @NotNull
    @Column(columnDefinition = "varchar(50)", length = 50)
    private String password;
    @NotNull
    private int port;


    public Database() {
        this.id = UUID.randomUUID().toString();
    }

    public Database(String url,String username, String password, int port) {
        this.id = UUID.randomUUID().toString();
        this.url = url;
        this.username = username;
        this.password = password;
        this.port = port;
    }
}
