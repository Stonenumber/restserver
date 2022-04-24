package com.stone.entity;

import lombok.Data;

import java.util.List;

@Data
public class Input<T> { //输入的类型和list
    String type;
    List<T> list;
}
