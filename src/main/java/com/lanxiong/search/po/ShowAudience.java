package com.lanxiong.search.po;

import lombok.Data;

@Data
public class ShowAudience {

    private String id;  //索引id
    private Long showid; //直播id
    private Long userid; //用户id
    private String title; //直播主题
    private String url;  //直播图片地址
    private String replayUrl; //回放地址
    private String remark; //备注

}
