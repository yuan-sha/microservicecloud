package com.ys.dao;

import com.ys.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);
    public Dept findById(Long Id);
    public List<Dept> findAll();
}
