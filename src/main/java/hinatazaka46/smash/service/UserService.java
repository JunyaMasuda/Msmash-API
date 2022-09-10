package hinatazaka46.smash.service;

import hinatazaka46.smash.Domain.User;

public interface UserService {

    void add(User user);

    void remove(int id);
}
