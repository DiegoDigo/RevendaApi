package br.com.control.revenda.entity.yml;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PortalWeb {
    private String image;
    private String restart;
    private String[] ports;
    private String[] networks;
    @JsonProperty("depends_on")
    private String[] dependsOn;

}
