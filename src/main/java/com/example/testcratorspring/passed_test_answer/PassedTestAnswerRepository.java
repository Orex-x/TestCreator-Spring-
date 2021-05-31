package com.example.testcratorspring.passed_test_answer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PassedTestAnswerRepository extends CrudRepository<PassedTestAnswer, Long> {
}
