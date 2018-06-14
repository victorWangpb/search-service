package com.lanxiong.search.controller;

import com.lanxiong.search.po.Show;
import com.lanxiong.search.service.ShowService;
import com.lanxiong.search.service.es.ShowEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/es/show")
public class ShowEsController {

    @Autowired
    private ShowService showService;

    @PostMapping("/add")
    public String add(){
        showService.add();
        return "success";
    }

    @RequestMapping("/listData")
    public List<Show> queryData(Integer pageNumber,String query){
        List<Show> list = showService.getList(pageNumber, query);
        return list;
    }
}
