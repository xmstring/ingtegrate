package com.multi.datasource.integrate.service.mapper2;

import com.multi.datasource.integrate.pojo.Book;

import java.util.List;

public interface BookMapper2Service {
    List<Book> getAllBooks2();
    void insertBook2(Book book);
}
