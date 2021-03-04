package com.multi.datasource.integrate.controller;

import com.multi.datasource.integrate.mapper.mapper1.BookMapper1;
import com.multi.datasource.integrate.mapper.mapper2.BookMapper2;
import com.multi.datasource.integrate.pojo.Book;
import com.multi.datasource.integrate.service.mapper1.BookMapper1Service;
import com.multi.datasource.integrate.service.mapper2.BookMapper2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    BookMapper1Service bookMapper1Service;

    @Autowired
    BookMapper2Service bookMapper2Service;

    @RequestMapping("/book1")
    public Map<String, Object> test1() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "获取成功");
        map.put("data1", bookMapper1Service.getAllBooks1());
        map.put("data2", bookMapper2Service.getAllBooks2());
        return map;
    }

    @RequestMapping("/insertBook")
    public String insertBook(@RequestBody Book book) {
        System.out.println(book.toString());
        bookMapper1Service.insertBook1(book);

       bookMapper2Service.insertBook2(book);
        return "success";
    }
}
