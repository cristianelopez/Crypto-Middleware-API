package crypto.middleware.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crypto.middleware.model.Role;

@Repository
public interface RolePersistence extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
