package epolsoft.practice.smart_surveys.repository;

import epolsoft.practice.smart_surveys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Optional<User> findByName(String name);
    Boolean existsByName(String name);

    Boolean existsByEmail(String email);
}
