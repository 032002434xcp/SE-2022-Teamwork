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
public class PersonalTask {
    String UID;
    String taskname;
    Integer current;
    Integer end;
    String type;
    String reward;
    String date;

}
