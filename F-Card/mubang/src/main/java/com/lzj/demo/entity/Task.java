package com.lzj.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author frf
 * @version 1.0
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    String taskName;
    String date;
    Integer current;
    Integer end;
    String type;
    String reward;
}
