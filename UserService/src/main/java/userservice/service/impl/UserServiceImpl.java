package userservice.service.impl;

import userservice.entity.User;
import userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import userservice.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Iterable<User> getAll() {
         return userRepository.findAll();
    }
}
