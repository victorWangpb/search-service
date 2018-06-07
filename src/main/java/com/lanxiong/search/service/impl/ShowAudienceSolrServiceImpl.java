package com.lanxiong.search.service.impl;

import com.lanxiong.search.po.ShowAudience;
import com.lanxiong.search.service.ShowAudienceSolrService;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("showAudienceSolrService")
public class ShowAudienceSolrServiceImpl implements ShowAudienceSolrService {

    @Autowired
    private SolrClient showSolrClient;

    @Override
    public void addShowAudienceData(ShowAudience showAudience) throws Exception {
        SolrInputDocument document = new SolrInputDocument();
        document.addField("show_id", showAudience.getShowid());
        document.addField("show_title", showAudience.getTitle());
        document.addField("show_url", showAudience.getUrl());
        document.addField("show_replayurl", showAudience.getReplayUrl());
        document.addField("show_remark", showAudience.getRemark());
        document.addField("show_userid", showAudience.getUserid());
        showSolrClient.add(document);
        log.info(document.toString());
        UpdateResponse commit = showSolrClient.commit();
        System.out.println(commit.toString());

    }

    @Override
    public void delShowAudience(String id) throws Exception{

        showSolrClient.deleteById(id);
        showSolrClient.commit();

    }

    @Override
    public void updateShowAudienceData(ShowAudience showAudience) throws Exception {

        SolrInputDocument document = new SolrInputDocument();
        document.addField("id",showAudience.getId());
        document.addField("show_id", showAudience.getShowid());
        document.addField("show_title", showAudience.getTitle());
        document.addField("show_url", showAudience.getUrl());
        document.addField("show_replayurl", showAudience.getReplayUrl());
        document.addField("show_remark", showAudience.getRemark());
        document.addField("show_userid", showAudience.getUserid());
        showSolrClient.add(document);
        log.info(document.toString());
        UpdateResponse commit = showSolrClient.commit();
        System.out.println(commit.toString());

    }

    @Override
    public List<ShowAudience> listShowData(String title) throws Exception{

        SolrQuery query = new SolrQuery();
        query.setQuery("show_title:"+title);
        query.setStart(1);
        query.setRows(100);
        QueryResponse queryResponse = showSolrClient.query(query);
        SolrDocumentList results = queryResponse.getResults();
        List<ShowAudience> list=new ArrayList<ShowAudience>();
        for (SolrDocument document:results){
            ShowAudience sa=new ShowAudience();
            sa.setShowid(Long.parseLong(document.get("show_id").toString()));
            sa.setUserid(Long.parseLong(document.get("show_userid").toString()));
            sa.setId(document.get("id").toString());
            sa.setTitle(document.get("show_title").toString());
            sa.setReplayUrl(document.get("show_replayurl")==null ?"":document.get("show_replayurl").toString());
            sa.setUrl(document.get("show_url")==null?"":document.get("show_url").toString());
            list.add(sa);
        }

        return list;
    }
}
