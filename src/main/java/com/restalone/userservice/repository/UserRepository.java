package com.restalone.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.restalone.userservice.model.User;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    // Example custom queries
    List<User> findByFirstName(String firstName);
    List<User> findByGender(String gender);
    List<User> findByQualification(String qualification);
    List<User> findByAccesslevel(String accesslevel);
    List<User> findByLastName(String lastName);
}
