package crypto.middleware.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crypto.middleware.model.User;

@Repository
public interface UserPersistence extends JpaRepository<User, String> {}
