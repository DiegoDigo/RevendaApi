package br.com.control.revenda.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties({"portal-api", "db", "fila"})
public class Service {

    @JsonProperty("portal-web")
    private PortalWeb portalWeb;
    @JsonIgnore
    @JsonProperty("portal-api")
    public String teste;
    @JsonIgnore
    @JsonProperty("db")
    public String db;
    @JsonIgnore
    @JsonProperty("fila")
    public String fila;

}
