package africa.semicolon.toDoApplication.data.repository;

import africa.semicolon.toDoApplication.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findUserByUsername(String username);
}