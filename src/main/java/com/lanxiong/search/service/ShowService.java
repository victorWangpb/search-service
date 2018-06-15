package com.lanxiong.search.service;

import com.lanxiong.search.po.Show;

import java.util.List;

public interface ShowService {
    void add(Show show);
    void delete(Long showid);
    List<Show> getList(Integer pageNumber, String query);
}
