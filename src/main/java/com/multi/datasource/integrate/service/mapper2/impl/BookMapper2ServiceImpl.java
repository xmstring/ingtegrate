package com.multi.datasource.integrate.service.mapper2.impl;

import com.multi.datasource.integrate.mapper.mapper1.BookMapper1;
import com.multi.datasource.integrate.mapper.mapper2.BookMapper2;
import com.multi.datasource.integrate.pojo.Book;
import com.multi.datasource.integrate.service.mapper2.BookMapper2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
@Transactional
*/
@Service
public class BookMapper2ServiceImpl implements BookMapper2Service {
    @Autowired
    BookMapper2 bookMapper2;
    @Override
    public List<Book> getAllBooks2() {
        List<Book> books = bookMapper2.getAllBooks2();
        return books;
    }

    @Override
    public void insertBook2(Book book) {
        System.out.println("book2:"+book.toString());
        bookMapper2.insertBook2(book);
        int j=5/0;
        return ;
    }
}
