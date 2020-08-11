package com.retail.loyalty.repository;

import com.retail.loyalty.models.Customer;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends MongoRepository<Customer, Long>{

}
