package org.example.Java_SpringBoot.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyPersonJPaRepo extends JpaRepository<MyPerson,Integer> {
}
