package br.com.control.revenda;

import br.com.control.revenda.entity.UserApplication;
import br.com.control.revenda.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RevendaApplication extends SpringBootServletInitializer implements CommandLineRunner {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RevendaApplication(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RevendaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RevendaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        UserApplication admin = userService.findByUserName("admin");
        if (admin == null) {
            userService.save(new UserApplication("admin",
                    bCryptPasswordEncoder.encode("admin")));
        }
    }
}
