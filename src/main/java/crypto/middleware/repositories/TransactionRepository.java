package crypto.middleware.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import crypto.middleware.model.Transaction;

import java.util.List;

@Configuration
@Repository
public interface  TransactionRepository  extends CrudRepository<Transaction,Long> {

    List<Transaction> findAll();

    @Query(value = "SELECT * FROM TRANSACTION t WHERE t.user = :id", nativeQuery = true)
    List<Transaction> getTransactionsByUserId(@Param("id") Long id);
}
