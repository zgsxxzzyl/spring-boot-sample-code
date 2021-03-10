package com.action;

import com.dao.TDaHyflDAO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vo.TDaHyfl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BaseController {
    @Autowired
    TDaHyflDAO tDaHyflDAO;

    @GetMapping("/add")
    public void add() {
        TDaHyfl tDaHyfl = new TDaHyfl();
        tDaHyfl.setBz("测试数据");
        tDaHyfl.setFdate(LocalDate.now());
        tDaHyflDAO.insert(tDaHyfl);
    }

    @RequestMapping("/pageinfo")
    public PageInfo pageInfo() {
        PageHelper.startPage(1, 5);
        List<TDaHyfl> all = tDaHyflDAO.findAll();
        PageInfo info = new PageInfo(all);
        return info;
    }

    @GetMapping("list")
    public List<TDaHyfl> list() {
        return tDaHyflDAO.findAll();
    }
}
