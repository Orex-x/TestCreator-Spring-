package com.example.testcratorspring.group_user;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserRepository extends CrudRepository<GroupUser, Long> {
}
