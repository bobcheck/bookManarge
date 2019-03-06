package com.thunisoft.booksdemo.service;

import com.thunisoft.booksdemo.bean.BorrowInfo;
import com.thunisoft.booksdemo.mapper.BorrowInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowInfoService {
    @Autowired
    private BorrowInfoMapper borrowInfoMapper;

    public List<BorrowInfo> all(){
        return borrowInfoMapper.selectAll();
    }

    public List<BorrowInfo> sel(BorrowInfo bi){
        return borrowInfoMapper.sel(bi);
    }

    public int insert(BorrowInfo br){
        return borrowInfoMapper.insert1(br);
    }

    public int bookUpdate(BorrowInfo br){
        return borrowInfoMapper.bookupdate(br);
    }

    public int readerUpdate(BorrowInfo br){
        return borrowInfoMapper.readerupdate(br);
    }

    public int delete(BorrowInfo br){
        return borrowInfoMapper.delete1(br);
    }

}
