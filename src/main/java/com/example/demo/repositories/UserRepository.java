package com.example.demo.repositories;


import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Конфигуратор SQL запросов
     */
    private final SqlCMD sqlQuery;

    /**
     * Поиск пользователя по id
     * @param id
     * @return
     */
    public User findUserById(Integer id) {
//        String sql = "SELECT * FROM userTable WHERE id=?";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };

        // Используем queryForObject для получения одного результата
        return jdbcTemplate.queryForObject(sqlQuery.getFindUserById(), userRowMapper, id);
    }


    //    Получение всех пользователей из БД
    public List<User> findAll(){
//        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbcTemplate.query(sqlQuery.getFindAll(), userRowMapper);
    }

    //    добавление в БД
    public User save(User user) {
//        String sql = "INSERT INTO userTable (firstName, lastName, age, email) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery.getSave(), user.getFirstName(), user.getLastName(), user.getAge(), user.getEmail());
        return user;
    }

    //    удаление из БД
    public void deleteById (int id) {
//        String sql = "DELETE FROM userTable WHERE id=?";
        jdbcTemplate.update(sqlQuery.getDeleteById(), id);
    }

    /* Обновление пользователя в БД */
    public void update(User user){
//        String sql = "UPDATE userTable SET firstName=?, lastName=?, age=?, email=? WHERE id=?";
        jdbcTemplate.update(sqlQuery.getUpdate(), user.getFirstName(), user.getLastName(), user.getAge(), user.getEmail(), user.getId());
    }

}
