package userservice.service;

import userservice.entity.User;

public interface UserService {
    Iterable<User> getAll();
}
