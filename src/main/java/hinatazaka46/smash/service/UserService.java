package hinatazaka46.smash.service;

import hinatazaka46.smash.Domain.User;
import java.util.Optional;

public interface UserService {
    
    User getById(int id);
    
    void add(User user);
}
