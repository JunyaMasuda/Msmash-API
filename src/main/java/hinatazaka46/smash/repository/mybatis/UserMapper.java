package hinatazaka46.smash.repository.mybatis;

import hinatazaka46.smash.Domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int add(User user);
}
