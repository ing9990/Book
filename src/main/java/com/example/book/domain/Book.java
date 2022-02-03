package com.example.book.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // 서버 실행 시 테이블이 h2 db에 생성된다.
public class Book {

    @Id //PK
    @GeneratedValue(strategy= GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    private String title;

    private String author;

}
