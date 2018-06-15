package com.lanxiong.search.controller;

import com.lanxiong.search.po.Show;
import com.lanxiong.search.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/es/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/add")
    public String add(Show show){
        if(show==null || show.getShowid()==null){
            return "error";
        }
        showService.add(show);
        return "success";
    }

    @PostMapping("/delete")
    public String delete(Show show){
        if(show==null ||show.getShowid()==null){
            return "error";
        }
        showService.delete(show.getShowid());
        return "success";
    }

    @RequestMapping("/listData")
    public List<Show> queryData(Integer pageNumber,String query){
        List<Show> list = showService.getList(pageNumber, query);
        return list;
    }
}
