/**
 * Huaihao Mo
 */

package com.dummynode.cryptotrackingbackend.repository;

import com.dummynode.cryptotrackingbackend.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUserId(String userId);
}
