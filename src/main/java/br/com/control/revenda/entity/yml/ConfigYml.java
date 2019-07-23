package br.com.control.revenda.entity.yml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "version", "service", "volumes", "networks"})
public class ConfigYml {

    @JsonProperty
    public String version;
    @JsonProperty("services")
    public Service service;
    public Volume volumes;
    public Networks networks;

}
