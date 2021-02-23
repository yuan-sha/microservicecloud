package com.ys.service;

import com.ys.entity.Dept;

import java.util.List;

public interface DeptService {
    public boolean add(Dept dept);
    public Dept get(Long Id);
    public List<Dept> list();
}
