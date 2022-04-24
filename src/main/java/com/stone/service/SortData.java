package com.stone.service;

import com.stone.entity.Input;
import com.stone.entity.Result;

public interface SortData {
    Result sort(Input input);
    Result getData(int id);
}
