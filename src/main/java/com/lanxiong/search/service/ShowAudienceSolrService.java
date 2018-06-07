package com.lanxiong.search.service;

import com.lanxiong.search.po.ShowAudience;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;

public interface ShowAudienceSolrService {

    void addShowAudienceData(ShowAudience showAudience) throws Exception;

    void delShowAudience(String id) throws Exception;

    void updateShowAudienceData(ShowAudience showAudience) throws Exception;

    List<ShowAudience> listShowData(String title) throws Exception;

}
