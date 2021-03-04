package com.multi.datasource.integrate.service.mapper1.impl;

import com.multi.datasource.integrate.mapper.mapper1.BookMapper1;
import com.multi.datasource.integrate.pojo.Book;
import com.multi.datasource.integrate.service.mapper1.BookMapper1Service;
import com.multi.datasource.integrate.service.mapper2.BookMapper2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
/*
@Transactional
*/
public class BookMapper1ServiceImpl implements BookMapper1Service {
    @Autowired
    BookMapper1 bookMapper1;
    @Autowired
    BookMapper2Service bookMapper2Service;
    @Override
    public List<Book> getAllBooks1() {
        List<Book> books1 = bookMapper1.getAllBooks1();
        return  books1;
    }

    /*
    * 全局事务管理器管理全局事务
    * xaTransaction是在DataSourceConfig中注册到spring中的JTA事务管理器
    * */
    @Override
    @Transactional(transactionManager = "xaTransaction")
    public void insertBook1(Book book) {
        System.out.println("book1:"+book.toString());
        int i = bookMapper1.insertBook1(book);
        bookMapper2Service.insertBook2(book);
        return ;
    }
}
