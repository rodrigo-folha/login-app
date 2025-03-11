package folha.rodrigo.login_auth_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import folha.rodrigo.login_auth_api.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);
    
}
