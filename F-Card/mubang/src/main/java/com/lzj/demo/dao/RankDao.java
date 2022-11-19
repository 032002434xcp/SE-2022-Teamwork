package com.lzj.demo.dao;

import com.lzj.demo.entity.Rank;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xcp
 * @version 1.0
 */
@Mapper
@Repository
public interface RankDao {
    List<Rank> queryRank();
    List<Rank> queryRankTop10ByGrade();
    List<Map<String,Integer>> getCollegeRankTop10();
    int updateAllUserRank();
    Rank queryRankByName(String name);
    int insertRank(Rank rank);
    int updateRank(Rank rank);
    int deleteRank(Rank rank);

}
