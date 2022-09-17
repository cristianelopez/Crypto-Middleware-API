package crypto.middleware.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import crypto.middleware.model.Account;

import org.springframework.data.repository.CrudRepository;

@Configuration
@Repository
public interface UserRepository extends CrudRepository<Account,Long>{

    @Query(value = "SELECT CAST(COUNT(1) AS BIT) FROM USER u WHERE u.wallet = :wallet", nativeQuery = true)
    boolean existWallet(@Param("wallet") String wallet);
}
