package com.stone.controller;

import com.stone.entity.Input;
import com.stone.entity.Result;
import com.stone.service.SortData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SortController {

    @Autowired
    SortData sortData;

    @PostMapping("/insert")
    public Result sortData(@RequestBody Input input){
        return sortData.sort(input);
    }

    @GetMapping("/getData/{id}") //根据插入id查询
    public Result getBeforeSort(@PathVariable int id){
        return sortData.getData(id);
    }


}
