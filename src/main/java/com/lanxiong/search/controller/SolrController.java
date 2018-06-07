package com.lanxiong.search.controller;

import com.lanxiong.search.po.ShowAudience;
import com.lanxiong.search.service.ShowAudienceSolrService;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/solr/")
public class SolrController {

    @Autowired
    private SolrClient solrClient;
    @Autowired
    private SolrClient showSolrClient;
    @Autowired
    private ShowAudienceSolrService showAudienceSolrService;


    @RequestMapping("addShowData")
    public String addShowData(ShowAudience show) {

        try {
            showAudienceSolrService.addShowAudienceData(show);
        } catch (Exception e) {
            log.info(e.getMessage(),e);
            return "添加失败";
        }

        return "添加成功";
    }

    @RequestMapping("queryData")
    public String queryData() {
        String test = "";
        try {
            SolrDocument document = solrClient.getById("e1fc63ae-e038-471d-a6bb-609d87258ef1");
            if (document != null) {
                test = document.toString();
            }

            SolrDocument document1 = showSolrClient.getById("e1fc63ae-e038-471d-a6bb-609d87258ef1");
            if (document1 != null) {
                System.out.println(document1.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return test;
    }

    @RequestMapping("listData")
    public List<SolrDocument> listData() {
        List<SolrDocument> list = new ArrayList<SolrDocument>();
        try {
            SolrQuery query = new SolrQuery();
            query.setQuery("show_title:北京");
            query.setStart(1);
            query.setRows(10);
            QueryResponse queryResponse = solrClient.query(query);
            list = queryResponse.getResults();
            for (SolrDocument document:list){
                log.info(document.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
