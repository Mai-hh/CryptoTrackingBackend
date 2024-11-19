package com.dummynode.cryptotrackingbackend.repository;

import com.dummynode.cryptotrackingbackend.entity.model.TransactionSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionSellRepository extends JpaRepository<TransactionSell,Long> {
}
