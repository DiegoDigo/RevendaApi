package br.com.control.revenda.entity.yml;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.Data;

import java.util.Map;

@Data
public class Networks {
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    @JsonAlias({"teste"})
    private Map<String, String> portal;

}
