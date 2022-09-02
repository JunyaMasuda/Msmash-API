package hinatazaka46.smash.repository;

import hinatazaka46.smash.Domain.User;
import hinatazaka46.smash.repository.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    
    private final SqlSession sqlSession;
    
    @Override
    public User getById(int id) {
        return this.sqlSession.getMapper(UserMapper.class).getById(id);
    }
    
    @Override
    public void insert(User user) {
        this.sqlSession.getMapper(UserMapper.class).add(user);
    }
}
