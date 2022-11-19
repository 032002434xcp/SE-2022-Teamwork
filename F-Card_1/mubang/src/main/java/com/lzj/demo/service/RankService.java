package com.lzj.demo.service;

import com.lzj.demo.entity.Rank;

import java.util.List;
import java.util.Map;

/**
 * @author xcp
 * @version 1.0
 */
public interface RankService {

    List<Rank> queryRank();
    List<Rank> queryRankTop10ByGrade();
    List<Map<String,Integer>> getCollegeRankTop10();
    Rank queryRankByName(String name);
    boolean insertRank(Rank rank);
    boolean updateRank(Rank rank);
    boolean deleteRank(Rank rank);
    void updateAllUserRank();



}
