package com.ys.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ys.entity.Dept;
import com.ys.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method= RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long Id) {
        Dept dept = deptService.get(Id);
        if(dept == null){
            throw new RuntimeException("Can't find the record for Id: "+Id);
        }
        return dept;
    }

    @RequestMapping(value = "/dept/list", method= RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }

    @RequestMapping(value = "/dept/discovery", method= RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("*********"+list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element:srvList) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }
        return this.discoveryClient;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long Id){
        return new Dept().setDeptno(Id).setDname("There is no record for the Id: "+ Id +", null--@HystrixCommand").setDb_source("no record in database");
    }
}
