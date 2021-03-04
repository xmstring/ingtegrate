package com.multi.datasource.integrate.mapper.mapper2;


import com.multi.datasource.integrate.pojo.Book;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BookMapper2 extends Mapper<Book> {

    List<Book> getAllBooks2();
    int insertBook2(Book book);

}
