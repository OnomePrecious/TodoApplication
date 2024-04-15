package africa.semicolon.toDoApplication.repository;

import africa.semicolon.toDoApplication.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}