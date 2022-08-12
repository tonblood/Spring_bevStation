package com.example.demo;

 
 
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	  List<Product> findBypname(String pname);
}