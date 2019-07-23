package br.com.control.revenda.entity.yml;

import lombok.Data;

@Data
public class ActiveMq {

    private String image;
    private String restart;
    private String[] ports;
    private String[] volumes;
    private String[] environment;
    private String[] networks;

}
