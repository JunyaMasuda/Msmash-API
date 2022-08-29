package hinatazaka46.smash.repository;

import hinatazaka46.smash.Domain.User;
import hinatazaka46.smash.repository.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryImpl implements UserRepository{

    private final SqlSession sqlSession;

    public UserRepositoryImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public void insert(User user) {
        this.sqlSession.getMapper(UserMapper.class).add(user);
    }
}
