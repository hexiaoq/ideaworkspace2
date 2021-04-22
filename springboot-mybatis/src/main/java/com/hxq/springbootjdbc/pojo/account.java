package com.hxq.springbootjdbc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class account {
    private Integer id;
    private String name;
    private float money;
}
