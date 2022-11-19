package com.lzj.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author  xcp
 * @version 1.0
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Rank {
    Integer collegeInfluence;
    Integer grade;
    String name;
    Integer rank;
    String college;
    String dateTime;
}
