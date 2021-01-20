package com.huynhbaoloc.reponsitory;

import com.huynhbaoloc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customerReponsitory")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
