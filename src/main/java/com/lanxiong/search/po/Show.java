package com.lanxiong.search.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "showindex",type = "show")
public class Show implements Serializable {

    @Id
    private Long showid; //直播id
    private Long userid; //用户id
    private String title; //直播主题
    private String url;  //直播图片地址
    private String replayUrl; //回放地址
    private String remark; //备注

}
