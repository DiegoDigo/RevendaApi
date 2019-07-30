package br.com.control.revenda.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity(name="roles")
public class Role {
    @Id
    private String id;
    @Column(columnDefinition = "varchar(30)", length = 30)
    private String name;

    public Role() {
        this.id = UUID.randomUUID().toString();
    }

    public Role(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
