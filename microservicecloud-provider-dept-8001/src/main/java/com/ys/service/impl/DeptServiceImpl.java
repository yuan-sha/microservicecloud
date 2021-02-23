package com.ys.service.impl;

import com.ys.dao.DeptDao;
import com.ys.entity.Dept;
import com.ys.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long Id) {
        return deptDao.findById(Id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
