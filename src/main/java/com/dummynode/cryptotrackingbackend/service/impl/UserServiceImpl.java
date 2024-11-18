/**
 * HuaiHao Mo
 */
package com.dummynode.cryptotrackingbackend.service.impl;

import com.dummynode.cryptotrackingbackend.entity.model.User;
import com.dummynode.cryptotrackingbackend.entity.model.Wallet;
import com.dummynode.cryptotrackingbackend.repository.UserRepository;
import com.dummynode.cryptotrackingbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        if (userRepository.existsByUserId(user.getUserId())) {
            throw new IllegalArgumentException("User ID already exists");
        }
        user.setCreatedAt(LocalDateTime.now());
        user.setModifiedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        if (!userRepository.existsById(user.getUserId())) {
            throw new IllegalArgumentException("User not found");
        }
        user.setModifiedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(userId);
    }

    @Override
    public BigDecimal getWalletBalance(String userId) {
        Optional<User> userOptional = userRepository.findByUserId(userId);
        if (userOptional.isPresent()) {
            return userOptional.get().getBalance();
        } else {
            throw new IllegalArgumentException("User not found: " + userId);
        }
    }
}
