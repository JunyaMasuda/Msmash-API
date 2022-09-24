package hinatazaka46.smash.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import hinatazaka46.smash.Domain.User;
import hinatazaka46.smash.repository.mybatis.UserMapper;
import hinatazaka46.smash.util.DBUnitUtil;
import java.io.File;
import java.util.Arrays;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

@MybatisTest
public class UserMapperTest {
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataSource dataSource;
    
    @Test
    void getByIdTest_statementsのデータを取得できる() {
        User excepted = new User();
        excepted.setId(1);
        excepted.setUserName("mj");
        excepted.setPassword("mj");
        excepted.setImage("mj");
        
        User actual = userMapper.getById(1);
        
        assertThat(excepted).isEqualTo(actual);
    }

    @Test
    void ユーザを追加する() {

        File expected = new File("./data/insert_expected.xlsx");

        User user = new User();
        user.setUserName("fk");
        user.setPassword("fk");
        user.setImage("fk");
        userMapper.add(user);
        DBUnitUtil.assertMutateResult(
                dataSource,
                "Sheet1",
                expected,
                Arrays.asList("ID")
        );
    }
}
