package com.thunisoft.booksdemo.service;

import com.thunisoft.booksdemo.bean.ReturnInfo;
import com.thunisoft.booksdemo.mapper.ReturnInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnInfoService {
    @Autowired
    private ReturnInfoMapper returnInfoMapper;

    public List<ReturnInfo> all(){
        return returnInfoMapper.selectAll();
    }

    public List<ReturnInfo> sel(ReturnInfo bi){
        return returnInfoMapper.sel(bi);
    }

    public int insert(ReturnInfo br){
        return returnInfoMapper.insert1(br);
    }

    public int bookUpdate(ReturnInfo br){
        return returnInfoMapper.bookupdate(br);
    }

    public int readerUpdate(ReturnInfo br){
        return returnInfoMapper.readerupdate(br);
    }

    public int delete(ReturnInfo br){
        return returnInfoMapper.delete1(br);
    }
}
