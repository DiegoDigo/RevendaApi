package br.com.control.revenda.entity.yml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "image", "restart", "ports", "volumes", "environment", "networks"})
public class ActiveMq {

    private String image;
    private String restart;
    private String[] ports;
    private String[] volumes;
    private String[] environment;
    private String[] networks;

}
