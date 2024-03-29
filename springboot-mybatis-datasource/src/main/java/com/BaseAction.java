package com;

import com.master.mapper.MasterUserMapper;
import com.slave1.mapper.Slave1UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BaseAction {

    @Resource
    private MasterUserMapper masterUserMapper;

    @Resource
    private Slave1UserMapper slave1UserMapper;

    @RequestMapping("a")
    public List<User> master() {
        return masterUserMapper.queryAll();
    }

    @RequestMapping("b")
    public List<User> slave() {
        return slave1UserMapper.queryAll();
    }
}
