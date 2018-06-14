package com.lanxiong.search.service.es;

import com.lanxiong.search.po.Show;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ShowEsService extends ElasticsearchRepository<Show,Long> {
}
