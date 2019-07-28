package br.com.control.revenda.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
public class UserApplication {

    @Id
    private String id;
    @NotNull
    @NotEmpty
    @Column(columnDefinition = "varchar(50)", length = 50)
    private String username;
    @NotNull
    @NotEmpty
    @Column(columnDefinition = "varchar(60)", length = 60)
    private String password;

    public UserApplication() {
        this.id = UUID.randomUUID().toString();
    }


    public UserApplication(String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }
}
