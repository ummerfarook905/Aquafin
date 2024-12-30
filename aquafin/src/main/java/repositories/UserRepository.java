package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByEmail(String email);
    List<User> findByRole(String role);
    List<User> findByRoleIn(List<String> roles);

}
