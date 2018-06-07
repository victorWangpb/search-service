package com.lanxiong.search.controller;

import com.lanxiong.search.po.ShowAudience;
import com.lanxiong.search.service.ShowAudienceSolrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/show/solr/")
public class ShowAudienceSolrController {

    @Autowired
    private ShowAudienceSolrService showAudienceSolrService;

    @PostMapping("addShowData")
    public String addShowData(ShowAudience show) {

        if(show==null){
            return "添加的信息不能为空";
        }

        try {
            showAudienceSolrService.addShowAudienceData(show);
        } catch (Exception e) {
            log.info(e.getMessage(),e);
            return "添加失败";
        }

        return "添加成功";
    }

    @PostMapping("delShowData")
    public String delShowData(@PathParam("id")String id){

        try {
            showAudienceSolrService.delShowAudience(id);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return "删除失败";
        }

        return "删除成功";
    }

    @PostMapping("updateShowData")
    public String updateShowData(ShowAudience show){

        if(show==null){
            return  "更新的数据不能为空";
        }

        try {
            showAudienceSolrService.updateShowAudienceData(show);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return "更新失败";
        }

        return "更新成功";
    }

    @PostMapping("/queryData")
    public List<ShowAudience> queryData(@PathParam("title")String title){

        List<ShowAudience> list=null;
        try {
            list = showAudienceSolrService.listShowData(title);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return null;
        }

        return list;
    }


}
