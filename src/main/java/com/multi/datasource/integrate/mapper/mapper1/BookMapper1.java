package com.multi.datasource.integrate.mapper.mapper1;


import com.multi.datasource.integrate.pojo.Book;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BookMapper1  extends Mapper<Book> {

    List<Book> getAllBooks1();
    int insertBook1(Book book);
}
