package br.com.control.revenda.entity.yml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Service {

    @JsonProperty("portal-web")
    private PortalWeb portalWeb;
    @JsonProperty("portal-api")
    public PortalApi portalApi;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Db db;
    public ActiveMq fila;

}
