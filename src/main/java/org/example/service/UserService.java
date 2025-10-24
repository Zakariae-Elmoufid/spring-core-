package org.example.service;

import jakarta.transaction.Transactional;
import org.example.dto.UserResponseDTO;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {

        return repo.findAll();
    }

    public User save(User user) {
        return repo.save(user);
    }

    public UserResponseDTO update(long id, User user) {
        User existingUser = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        User  userR = repo.save(existingUser);
        return new UserResponseDTO(userR.getId(), userR.getName(), userR.getEmail(), userR.getRole());
    }


    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteUserById(Long id){
        repo.deleteById(id);
    }


}
