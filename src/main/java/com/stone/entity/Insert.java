package com.stone.entity;

import lombok.Data;

@Data
public class Insert<T> {  //放入数据库的对象
    private int id; //插入数据时的id
    private int index; // 在list中的index
    private boolean sort; //是否排序
    private T value; //本身的值

    public Insert( Integer id, Integer index, boolean sort, T value){
        this.index = index;
        this.id = id;
        this.sort = sort;
        this.value = value;
    }
}
