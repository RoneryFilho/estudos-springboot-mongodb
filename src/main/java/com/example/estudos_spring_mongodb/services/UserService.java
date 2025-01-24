package com.example.estudos_spring_mongodb.services;

import com.example.estudos_spring_mongodb.domain.User;
import com.example.estudos_spring_mongodb.dto.UserDTO;
import com.example.estudos_spring_mongodb.repositories.UserRepository;
import com.example.estudos_spring_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto User não encontrado"));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
