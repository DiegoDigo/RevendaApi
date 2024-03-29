package br.com.control.revenda.utility;

import br.com.control.revenda.entity.Config;
import br.com.control.revenda.entity.enums.EnvironmentEnum;
import br.com.control.revenda.entity.yml.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class Utility {


    public static InputStream readYaml(Config config) throws Exception {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        File file = ResourceUtils.getFile("classpath:temp/docker-compose.yml");
        ConfigYml configYml = mapper.readValue(file, ConfigYml.class);
        File output = new ClassPathResource("temp/formatted.yml").getFile();

        setValuePortalWeb(config, configYml.getService().getPortalWeb());
        setValuePortalApi(config, configYml.getService().getPortalApi());
        setValueFila(config, configYml.getService().getFila());
        setValueDatabase(config, configYml.getService().getDb());
        mapper.writerWithDefaultPrettyPrinter().writeValue(output, configYml);
        return new FileInputStream(output);

    }

    private static void setValueFila(Config config, ActiveMq fila) {
        String[] environment = new String[]{
                "ACTIVEMQ_MIN_MEMORY=512",
                "ACTIVEMQ_MAX_MEMORY=2048",
                "ACTIVEMQ_ENABLED_AUTH=false",
                String.format("ACTIVEMQ_ADMIN_LOGIN=%s", config.getFila().getUsername()),
                String.format("ACTIVEMQ_ADMIN_PASSWORD=%s", config.getFila().getPassword()),
        };
        fila.setPorts(new String[]{
                String.format("%s:8161", config.getFila().getPortPainel()),
                String.format("%s:61616", config.getFila().getPortTcp())
        });
        fila.setEnvironment(environment);
    }

    private static void setValueDatabase(Config config, Db db) {
        HashMap<String, String> environment = new HashMap<>();
        environment.put("POSTGRES_DB", config.getDatabase().getTablenName());
        environment.put("POSTGRES_USER", config.getDatabase().getUsername());
        environment.put("POSTGRES_PASSWORD", config.getDatabase().getPassword());
        db.setEnvironment(environment);
        db.setPorts(new String[]{String.format("%s:5432", config.getDatabase().getPort())});
    }

    private static void setValuePortalApi(Config config, PortalApi portalApi) {
        HashMap<String, String> environment = new HashMap<>();
        environment.put("DATABASE_URL", String.format("jdbc:postgresql://db:5432/%s?reWriteBatchedInserts=true",
                config.getDatabase().getTablenName()));
        environment.put("DATABASE_USER", config.getDatabase().getUsername());
        environment.put("DATABSE_PASSWORD", config.getDatabase().getPassword());
        environment.put("ACTIVEMQ", "tcp://fila:61616");
        environment.put("PORT", String.valueOf(config.getApi().getPort()));
        environment.put("MATRICULA", String.valueOf(config.getRevenda().getLicense()));
        environment.put("HOSTFRONT", config.getWeb().getHost() + "/#");
        environment.put("AMBIENTE", EnvironmentEnum.valueOf(config.getRevenda().getEnvironment().toString()).enviroment.toLowerCase());
        environment.put("LOGS", "/usr/local/tomcat/logs/");
        environment.put("CATALINA_OPTS", "-Xmx2g -Xms2g -Xss2m -XX:MaxPermSize=1024m");
        environment.put("JAVA_OPTS", "-Xms2g -Xmx2g -Xss2m -XX:PermSize=1024m -XX:MaxPermSize=1024m");
        portalApi.setEnvironment(environment);
        portalApi.setImage(String.format("linkedby/portal-api-%s", EnvironmentEnum.valueOf(config.getRevenda().getEnvironment().toString()).enviroment.toLowerCase()));
        portalApi.setPorts(new String[]{String.format("%s:8080", config.getApi().getPort())});
    }


    private static void setValuePortalWeb(Config config, PortalWeb portalWeb) {
        HashMap<String, String> environment = new HashMap<>();
        environment.put("API",String.format("http://%s/",config.getWeb().getHostApi()));
        environment.put("HOST",config.getWeb().getHost());
        portalWeb.setEnvironment(environment);
        portalWeb.setImage(String.format("linkedby/portal-web-%s", EnvironmentEnum.valueOf(config.getRevenda().getEnvironment().toString()).enviroment.toLowerCase()));
        portalWeb.setPorts(new String[]{String.format("%s:80", config.getWeb().getPort())});
    }


}
