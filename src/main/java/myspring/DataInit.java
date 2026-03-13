package myspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import myspring.model.User;
import myspring.repository.UserRepository;

@Component
public class DataInit {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            User u = new User();
            u.setUsername("admin");
            u.setPassword("admin");
            userRepository.save(u);
        }
    }
}
