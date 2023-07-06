package nl.novi.loahy_v3.repositories;

import nl.novi.loahy_v3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;



public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByUserEmailIs(String userEmail);
}
