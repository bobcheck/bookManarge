package com.thunisoft.booksdemo.service;

import com.thunisoft.booksdemo.bean.ReaderInfo;
import com.thunisoft.booksdemo.mapper.ReaderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderInfoService {
    @Autowired
    private ReaderInfoMapper ReaderInfoMapper;

    public List<ReaderInfo> all(){
        return ReaderInfoMapper.selectAll();
    }

    public List<ReaderInfo> sel(ReaderInfo book){
        return ReaderInfoMapper.sel(book);
    }

    public int up(ReaderInfo reader){
        return ReaderInfoMapper.update1(reader);
    }

    public int insertStu(ReaderInfo reader){
        return ReaderInfoMapper.insertStu(reader);
    }

    public int insertTeacher(ReaderInfo reader){
        return ReaderInfoMapper.insertTeacher(reader);
    }

    public int delete(ReaderInfo reader){
        return ReaderInfoMapper.delete1(reader);
    }
}
