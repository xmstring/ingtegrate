package com.multi.datasource.integrate.service.mapper1;

import com.multi.datasource.integrate.pojo.Book;

import java.util.List;

public interface BookMapper1Service {
    List<Book> getAllBooks1();
    void insertBook1(Book book);
}
