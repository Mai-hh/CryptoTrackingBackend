package com.dummynode.cryptotrackingbackend.repository;


import com.dummynode.cryptotrackingbackend.entity.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findByUserUserId(String userId);

    Optional<Wallet> findByUserUserIdAndSymbol(String userId, String symbol);



    @Query(value = "SELECT * \n" +
            "FROM crypto_tracking.wallet \n" +
            "WHERE user_id = :userId AND symbol = :symbol AND remaining_qty > 0 \n" +
            "ORDER BY created_at ASC",nativeQuery = true)
    List<Wallet> findByUserIdAndSymbol(String userId, String symbol);
}
