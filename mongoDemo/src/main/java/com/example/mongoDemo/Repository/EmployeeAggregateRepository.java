package com.example.mongoDemo.Repository;
import com.example.mongoDemo.entity.EmployeeAggregate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeAggregateRepository extends MongoRepository<EmployeeAggregate, Long> {
}
