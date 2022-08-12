package com.example.demo;

 
 
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface MemberRepository extends CrudRepository<Member, Integer> {

	  List<Member> findByfname(String fname);
}