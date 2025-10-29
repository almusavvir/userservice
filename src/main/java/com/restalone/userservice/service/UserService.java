package com.restalone.userservice.service;

import com.restalone.userservice.model.User;
import com.restalone.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getUserById(String id) {
        return repo.findById(id);
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public User updateUser(String id, User updatedUser) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setFirstName(updatedUser.getFirstName());
                    existing.setLastName(updatedUser.getLastName());
                    existing.setGender(updatedUser.getGender());
                    existing.setDob(updatedUser.getDob());
                    existing.setQualification(updatedUser.getQualification());
                    existing.setGuardian(updatedUser.getGuardian());
                    existing.setCqtype(updatedUser.getCqtype());
                    existing.setCqscore(updatedUser.getCqscore());
                    existing.setAccesslevel(updatedUser.getAccesslevel());
                    return repo.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(String id) {
        repo.deleteById(id);
    }

    // Optional: custom methods
    public List<User> getUsersByGender(String gender) {
        return repo.findByGender(gender);
    }

    public List<User> getUsersByQualification(String qualification) {
        return repo.findByQualification(qualification);
    }

    public List<User> getUsersByAccessLevel(String accesslevel) {
        return repo.findByAccesslevel(accesslevel);
    }
    public List<User> getUsersByFirstName(String firstName) {
        return repo.findByFirstName(firstName);
    }

    public List<User> getUsersByLastName(String lastName) {
        return repo.findByLastName(lastName);
    }
    public List<User> getUsersByCqType(String cqtype) {
        return repo.findByCqType(cqtype);
    }
}
