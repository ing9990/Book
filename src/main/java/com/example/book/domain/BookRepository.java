package com.example.book.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// JPARepository는 CRUD 함수를 기본 내장함.

public interface BookRepository extends JpaRepository<Book,Long> {

}
