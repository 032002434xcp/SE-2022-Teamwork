package com.lzj.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author xcp
 * @version 1.0
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    Integer questionAbility1;
    Integer questionAbility2;
    Integer questionAbility3;
    Integer questionAbility4;
    Integer questionAbility5;
    String questionName;
    String preferance;

}
