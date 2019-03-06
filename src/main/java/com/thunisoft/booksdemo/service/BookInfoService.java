package com.thunisoft.booksdemo.service;

import com.thunisoft.booksdemo.bean.BookInfo;
import com.thunisoft.booksdemo.mapper.BookInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoService {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    public List<BookInfo> all(){
        return bookInfoMapper.selectAll();
    }

    public List<BookInfo> sel(BookInfo book){
        return bookInfoMapper.sel(book);
    }

    public int up(BookInfo book){
        return bookInfoMapper.update1(book);
    }

    public int insert(BookInfo book){
        return bookInfoMapper.insert1(book);
    }

    public int delete(BookInfo book){
        return bookInfoMapper.delete1(book);
    }

}
