package com.example.testcratorspring.group_test;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupTestRepository extends CrudRepository<GroupTest, Long> {
}
