package com.projects.usermanagement.repository;

import com.projects.usermanagement.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByLoginId(@Param("loginId") String loginId);

}
