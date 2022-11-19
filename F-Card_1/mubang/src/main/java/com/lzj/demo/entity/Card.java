package com.lzj.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 林子键
 * @version 1.0
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    Integer ability1;
    Integer ability2;
    Integer ability3;
    Integer ability4;
    Integer ability5;
    Integer cardLevel;
    Integer experience;
    String rank; //讲师，副教授，教授，院士
    String cardName;
    String introduction;
    String preferance;

}
