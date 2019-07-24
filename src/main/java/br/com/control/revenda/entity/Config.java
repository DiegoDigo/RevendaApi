package br.com.control.revenda.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@ToString
@Entity(name = "config")
public class Config {

    @Id
    private String id;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "revenda_id", referencedColumnName = "id", unique = true)
    private Revenda revenda;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "database_id", referencedColumnName = "id")
    private Database database;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fila_id", referencedColumnName = "id")
    private Fila fila;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "portal_api_id", referencedColumnName = "id")
    private Api api;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "portal_web_id", referencedColumnName = "id")
    private Web web;



    public Config() {
        this.id = UUID.randomUUID().toString();
    }

    public Config(Revenda revenda, Database database, Fila fila, Api api, Web web) {
        this.id = UUID.randomUUID().toString();
        this.revenda = revenda;
        this.database = database;
        this.fila = fila;
        this.api = api;
        this.web = web;
    }
}
