package com.lanxiong.search.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SolrClientConfiguration implements InitializingBean{
    @Autowired
    private Environment environment;

    private String requiredProperty=null;
    @Override
    public void afterPropertiesSet() throws Exception {
        requiredProperty=environment.getRequiredProperty("spring.data.solr.host");
    }

    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient(requiredProperty+"new_core");
    }

    @Bean
    public SolrClient showSolrClient() {
        return new HttpSolrClient(requiredProperty+"show_audience");
    }

}
