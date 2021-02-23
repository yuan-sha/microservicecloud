package com.ys.controller;

import com.ys.entity.Dept;
import com.ys.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add", method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method= RequestMethod.GET)
    public Dept get(@PathVariable("id") Long Id) {
        return deptService.get(Id);
    }

    @RequestMapping(value = "/dept/list", method= RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }
}
