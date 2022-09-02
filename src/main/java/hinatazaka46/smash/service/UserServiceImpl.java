package hinatazaka46.smash.service;


import hinatazaka46.smash.Domain.User;
import hinatazaka46.smash.repository.UserRepository;
import hinatazaka46.smash.repository.UserRepositoryImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void add(User user) {
        this.userRepository.insert(user);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void remove(int id) {
        this.userRepository.delete(id);
    }
}
