package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class UserService {
    /*Объект репозитория для работы с БД*/
    private final UserRepository userRepository;

//    /*Конструктор*/
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
    public User getUserById (Integer id){
        return userRepository.findUserById(id);
    }

    /* Получение списка всех пользователей*/
    public List<User> findAll(){
        return userRepository.findAll();
    }

    /**
     * Создание нового пользователя
     * @param user объект пользователя
     * @return объект пользователя с присвоением id
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Удаление пользователя
     * @param id уникальный идентификатор пользователя
     */
    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    /**
     * Обновление данных пользователя
     * @param user объект пользователя с обновленными данными
     */
    public void updateUser(User user){
        userRepository.update(user);
    }
}
