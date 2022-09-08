package hinatazaka46.smash.repository;


import static org.mockito.Mockito.doReturn;

import hinatazaka46.smash.repository.mybatis.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserRepositoryImplTest {
    
    @Mock
    private SqlSession sqlSession;
    
    @Mock
    private UserMapper userMapper;
    
    @BeforeEach
    void before() {
        doReturn(userMapper).when(sqlSession).getMapper(UserMapper.class);
    }
    
    @Test
    void getByIdTest_指定したIDのUserを返す() {
    
    }
    
}
