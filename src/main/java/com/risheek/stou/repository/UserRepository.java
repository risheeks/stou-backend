package com.risheek.stou.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.risheek.stou.compositeKey.UserKey;
import com.risheek.stou.model.User;

public interface UserRepository extends JpaRepository<User, UserKey>{

}
