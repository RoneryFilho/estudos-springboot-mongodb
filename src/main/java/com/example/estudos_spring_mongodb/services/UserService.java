package com.example.estudos_spring_mongodb.services;

import com.example.estudos_spring_mongodb.domain.User;
import com.example.estudos_spring_mongodb.dto.UserDTO;
import com.example.estudos_spring_mongodb.repositories.UserRepository;
import com.example.estudos_spring_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

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

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public void update(User user){
        User newUser = findById(user.getId());
        updateData(newUser, user);
        userRepository.save(newUser);
    }

    private void updateData(User newUser, User user){
        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }
}
