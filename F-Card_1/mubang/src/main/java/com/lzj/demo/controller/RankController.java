package com.lzj.demo.controller;

import com.lzj.demo.entity.Rank;
import com.lzj.demo.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xcp
 * @version 1.0
 */
@RestController
@RequestMapping("/rank")
public class RankController {
    @Autowired
    private RankService rankService;
    @RequestMapping(value = "/listrank", method = RequestMethod.GET)
    private Map<String,Object> listRank(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Rank> list = rankService.queryRank();
        modelMap.put("rankList",list);
        return modelMap;
    }
    @RequestMapping(value = "/getrankbyname",method = RequestMethod.GET)
    private Map<String,Object> getRankByName(String name){
        Map<String,Object> modelMap = new HashMap<>();
        Rank rank = rankService.queryRankByName(name);
        modelMap.put("rank",rank);
        return modelMap;
    }
    @RequestMapping(value = "/insertrank",method = RequestMethod.POST)
    private Map<String,Object> insertRank(@RequestBody Rank rank){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",rankService.insertRank(rank));
        return modelMap;
    }
    @RequestMapping(value = "/updaterank",method = RequestMethod.POST)
    private Map<String,Object> undateRank(@RequestBody Rank rank){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",rankService.updateRank(rank));
        return modelMap;
    }
    @RequestMapping(value = "/deleterank",method = RequestMethod.POST)
    private Map<String,Object> deleteRank(@RequestBody Rank rank){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",rankService.deleteRank(rank));
        return modelMap;
    }
    @RequestMapping(value = "/getAllRank",method = RequestMethod.POST)
    private Map<String,Object> getAllRank(@RequestBody Rank rank){
        Map<String,Object> modelMap = new HashMap<>();
        rankService.updateRank(rank);
        rankService.updateAllUserRank();
        modelMap.put("User",rankService.queryRankByName(rank.getName()));
        modelMap.put("CollegeRank",rankService.getCollegeRankTop10());
        modelMap.put("RankTop10",rankService.queryRankTop10ByGrade());
        return modelMap;
    }

}
