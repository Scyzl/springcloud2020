package com.scy.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Scy
 * @Date 2020/9/10 11:13
 * @Version 1.0
 */
@Data
public class Payment implements Serializable {

    private Long id;
    private String serial;
}
