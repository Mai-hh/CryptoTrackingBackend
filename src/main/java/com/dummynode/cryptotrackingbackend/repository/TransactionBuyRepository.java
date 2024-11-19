package com.dummynode.cryptotrackingbackend.repository;

import com.dummynode.cryptotrackingbackend.entity.model.TransactionBuy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionBuyRepository extends JpaRepository<TransactionBuy,Long> {
}
