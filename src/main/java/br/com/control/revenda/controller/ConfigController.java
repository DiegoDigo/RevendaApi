package br.com.control.revenda.controller;

import br.com.control.revenda.entity.Config;
import br.com.control.revenda.service.ConfigService;
import br.com.control.revenda.utility.Utility;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("config")
@Api(value = "Config")
public class ConfigController {

    @Autowired
    ConfigService configService;


    @ApiOperation(value = "Cria uma configuração de uma revenda.")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Config config) throws Exception {
        Optional<Config> save = Optional.of(configService.save(config));
        if(save.isPresent()){
            return ResponseEntity.ok(save.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Retorna as configurações de uma revenda.")
    @GetMapping
    public ResponseEntity<?> all(HttpServletResponse response) {
        List<Config> configs = configService.getAll();
        if(configs.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(configs);
    }

    @ApiOperation(value = "Retorna o arquivo baseado no id da configuração")
    @GetMapping("{id}")
    public ResponseEntity<?> download(HttpServletResponse response,
                                      @PathVariable("id") String revendaId){
        try{
            Config config = configService.findByRevendaId(revendaId);
            if(config != null){
                response.setContentType("application/yml");
                response.setHeader("Content-Disposition", "attachment; filename=docker-compose.yml");
                response.setHeader("filename", "docker-compose.yml");
                IOUtils.copy(Utility.readYaml(config), response.getOutputStream());
                response.flushBuffer();
                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            if(e instanceof NoSuchElementException){
                return  ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

    }




}
