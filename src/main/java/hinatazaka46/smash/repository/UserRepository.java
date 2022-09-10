package hinatazaka46.smash.repository;

import hinatazaka46.smash.Domain.User;

public interface UserRepository {

    /**
     * Userの新規登録処理
     *
     * @param user 登録内容
     *
     */
    void insert (User user);

    /**
     * ID指定による1検索削除
     */
    void delete(int id);
}
