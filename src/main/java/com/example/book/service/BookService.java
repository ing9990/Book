package com.example.book.service;


import com.example.book.domain.Book;
import com.example.book.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
   Service
     - 기능 정의
     - 트랜잭션

   @RequiredArgsCons
     - final이 붙은 멤버의 생성자를 자동으로 생성?
*/

@Service
@RequiredArgsConstructor
public class BookService{

    private final BookRepository bookRepository;

    @Transactional // 만약 서비스에 오류가 생겨서 종료가 되면 다시 rollback한다.
    public Book 저장하기(Book book){
        return bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public Book 한권가져오기(Long id){
        return bookRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("id에 해당하는 책을 찾을 수 없습니다."));

        // 만약 findById로 책을 찾는다면 return 시키고 찾지 못한다면 Exception을 발생시킨다.

    }

    @Transactional(readOnly = true)
    public List<Book> 모두가져오기(){
        return bookRepository.findAll();
    }


    @Transactional
    public Book 수정하기(Long id,Book book){

        Book bookEntity = bookRepository.findById(id)
                .orElseThrow(()->new IllegalStateException("id에 해당하는 책을 찾을 수 없습니다."));

        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());

        return bookEntity;
    }

    @Transactional
    public String 삭제하기(Long id){
        bookRepository.deleteById(id);

        return "OK";
    }






}











