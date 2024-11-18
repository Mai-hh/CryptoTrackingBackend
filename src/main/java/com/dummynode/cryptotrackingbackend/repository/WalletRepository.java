package com.dummynode.cryptotrackingbackend.repository;


import com.dummynode.cryptotrackingbackend.entity.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

    List<Wallet> findByUserUserId(String userId);
}
