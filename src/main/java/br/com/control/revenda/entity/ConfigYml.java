package br.com.control.revenda.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties({"volumes", "networks"})
public class ConfigYml {

    @JsonProperty
    public String version;
    @JsonProperty("services")
    public Service service;
    @JsonIgnore
    @JsonProperty("volumes")
    public String volumes;
    @JsonIgnore
    @JsonProperty("networks")
    public String networks;

}
