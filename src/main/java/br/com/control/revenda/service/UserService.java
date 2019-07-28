package br.com.control.revenda.service;

import br.com.control.revenda.entity.UserApplication;
import br.com.control.revenda.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserApplication findByUserName(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApplication applicationUserApplication = this.userRepository.findByUsername(username);
        if (applicationUserApplication == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUserApplication.getUsername(), applicationUserApplication.getPassword(), emptyList());
    }

    public UserApplication save(UserApplication user) {
        return userRepository.save(user);
    }
}
