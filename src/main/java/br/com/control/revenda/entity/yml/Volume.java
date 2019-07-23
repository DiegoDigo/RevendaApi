package br.com.control.revenda.entity.yml;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Volume {
    @JsonProperty("activemq_db")
    private Map<String, String> activemqDb;
    @JsonProperty("database_data")
    private Map<String, String> databaseData;
}
