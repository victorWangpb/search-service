package com.lanxiong.search.controller;

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

@RestController
@RequestMapping("/solr/")
public class SolrController {

    @Autowired
    private SolrClient solrClient;
    @Autowired
    private SolrClient showSolrClient;

    @RequestMapping("index")
    public String index() {
        return "hello solr";
    }

    @RequestMapping("addShowData")
    public String addShowData() {
        String test = "";
        try {
            SolrInputDocument document = new SolrInputDocument();
            document.addField("show_id", 11);
            document.addField("show_title", "多core测试");
            document.addField("show_url", 11);
            document.addField("show_replayurl", 11);
            document.addField("show_remark", 11);
            document.addField("show_userid", 11);
            showSolrClient.add(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            showSolrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return test;
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
            query.setQuery("show_title:core");
            query.setStart(1);
            query.setRows(10);
            QueryResponse queryResponse = solrClient.query(query);
            list = queryResponse.getResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
