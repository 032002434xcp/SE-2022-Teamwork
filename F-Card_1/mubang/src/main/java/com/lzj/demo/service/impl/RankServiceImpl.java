package com.lzj.demo.service.impl;

import com.lzj.demo.dao.RankDao;
import com.lzj.demo.entity.Rank;
import com.lzj.demo.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author xcp
 * @version 1.0
 */
@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankDao rankDao;



    @Override
    public List<Rank> queryRank() {
        return rankDao.queryRank();
    }

    @Transactional
    @Override
    public List<Rank> queryRankTop10ByGrade(){return rankDao.queryRankTop10ByGrade();}
    @Transactional
    @Override
    public List<Map<String,Integer>> getCollegeRankTop10(){return rankDao.getCollegeRankTop10();}

    @Override
    public Rank queryRankByName(String name) {
        return rankDao.queryRankByName(name);
    }

    @Transactional
    @Override
    public boolean insertRank(Rank rank) {
        if (rank.getName() != null && !"".equals(rank.getName())) {
            try {
                int effectedNum = rankDao.insertRank(rank);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入排名失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入排名失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("排名名称不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean updateRank(Rank rank) {
        if (rank.getName() != null && !"".equals(rank.getName())) {
            try {
                int effectedNum = rankDao.updateRank(rank);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新排名失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新排名失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("排名名称不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean deleteRank(Rank rank) {
        if (rank.getName() != null && !"".equals(rank.getName())) {
            try {
                int effectedNum = rankDao.deleteRank(rank);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除排名失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除排名失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("排名名称不能为空!");
        }
    }

    @Transactional
    @Override
    public void updateAllUserRank(){
        try {
            int effectedNum = rankDao.updateAllUserRank();
            if (effectedNum > 0) {
            } else {
                throw new RuntimeException("更新所有人rank成功");
            }
        } catch (Exception e) {
            throw new RuntimeException("更新所有人rank失败" + e.getMessage());
        }

    }




}