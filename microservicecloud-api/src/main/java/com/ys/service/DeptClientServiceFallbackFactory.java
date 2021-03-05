package com.ys.service;

import com.ys.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long Id) {
                return new Dept().setDeptno(Id).setDname("There is no record for the Id: "+ Id +", null--@HystrixCommand").setDb_source("no record in database");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
