package com.retail.loyalty.repository;

import com.retail.loyalty.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Long>{

}
