package br.com.control.revenda.entity.yml;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;

import java.util.Map;

@Data
public class Db {
    @JsonRawValue
    private String image;
    private String restart;
    private String[] ports;
    private String[] volumes;
    private Map<String, String> environment;
    private String[] networks;
}
