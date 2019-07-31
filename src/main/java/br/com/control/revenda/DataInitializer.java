package br.com.control.revenda;

import br.com.control.revenda.entity.Role;
import br.com.control.revenda.entity.User;
import br.com.control.revenda.service.RoleService;
import br.com.control.revenda.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {


    private final UserService userService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public DataInitializer(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Criando usuario admin e suporte");

        Stream.of(new Role("ROLE_ADMIN"), new Role("ROLE_SUPORT"))
                .forEach(role -> {
                    if (roleService.findByName(role.getName()) == null) {
                        roleService.save(role);
                    }
                });
        Stream.of(
                new User("admin", bCryptPasswordEncoder.encode("@c0ntr0lr3v3nd@"), Collections.singletonList(roleService.findByName("ROLE_ADMIN"))),
                new User("suporte", bCryptPasswordEncoder.encode("@sup0rt3r3v3nd@"), Collections.singletonList(roleService.findByName("ROLE_SUPORT")))
        ).forEach(user -> {
            if (!userService.findByUserName(user.getUsername()).isPresent()) {
                userService.save(user);
            }
        });

    }
}
