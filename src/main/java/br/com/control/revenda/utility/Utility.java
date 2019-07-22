package br.com.control.revenda.utility;

import br.com.control.revenda.entity.Config;
import br.com.control.revenda.entity.ConfigYml;
import br.com.control.revenda.entity.PortalWeb;
import br.com.control.revenda.entity.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Utility {


    public static InputStream readYaml(Config config) throws Exception {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory()); // jackson databind
        File file = ResourceUtils.getFile("classpath:docker-compose.yml");
        ConfigYml configYml = mapper.readValue(file, ConfigYml.class);
        File output = new File("src/main/resources/teste.yml");

        setValuePortalWeb(config, configYml.getService().getPortalWeb());
        mapper.writeValue(output, configYml);
        return new FileInputStream(output);

    }

    private static void setValuePortalWeb(Config config, PortalWeb portalWeb) {
        portalWeb.setImage("linkedby/portal-web");
        portalWeb.setPorts(new String[]{String.format("%s:80", config.getWeb().getPort())});
    }


}
