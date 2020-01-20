package com.example.mongoDemo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EmployeeAggregate")
public class EmployeeAggregate {

    @Id
    private ObjectId id;
    private long totalEmployeeCount;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public long getTotalEmployeeCount() {
        return totalEmployeeCount;
    }

    public void setTotalEmployeeCount(long totalEmployeeCount) {
        this.totalEmployeeCount = totalEmployeeCount;
    }
}
