package com.stone.service.Impl;

import com.stone.entity.Input;
import com.stone.entity.Insert;
import com.stone.entity.Result;
import com.stone.mapper.InsertMapper;
import com.stone.service.SortData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class SortDataImpl implements SortData {
    private  static int id = 0; //给每次插入的数据一个id，则可根据id查询

    @Autowired
    private InsertMapper insertMapper;

    @Override
    public Result sort(Input input) {
        id++;
        String type = input.getType();
        Result result = Result.ok();
        if(type.equals("Integer")){
            List<Integer> list = input.getList();
            for(int i = 0; i < list.size(); i++){ //将排序前的整数放入数据库
                Insert insert = new Insert(id, i, false, list.get(i));
                insertMapper.insertIntegerBeforeSort(insert);
            }

            Collections.sort(list);
            for(int i = 0; i < list.size(); i++){ //将排序后的整数放入数据库
                Insert insert = new Insert(id, i, true, list.get(i));
                insertMapper.insertIntegerAfterSort(insert);
            }
            result.data("SortedInteger", list); // 放置排序后数据
            result.id(id); //id用来标识是第几次插入
        } else if(type.equals("String")){
            List<String> list = input.getList();
            for(int i = 0; i < list.size(); i++){ //将排序前的String放入数据库
                Insert insert = new Insert(id, i, false, list.get(i));
                insertMapper.insertStringBeforeSort(insert);
            }
            Collections.sort(list);
            for(int i = 0; i < list.size(); i++){ //将排序后的String放入数据库
                Insert insert = new Insert(id, i, true, list.get(i));
                insertMapper.insertStringAfterSort(insert);
            }
            result.data("SortedString", list);
            result.id(id);
        } else if(type.equals("BigDecimal")){
            List<BigDecimal> list = input.getList();
            for(int i = 0; i < list.size(); i++){ //将排序前的BigDecimal放入数据库
                Insert insert = new Insert(id, i, false, list.get(i));
                insertMapper.insertBigDecimalBeforeSort(insert);
            }
            Collections.sort(list);
            for(int i = 0; i < list.size(); i++){ //将排序后的BigDecimal放入数据库
                Insert insert = new Insert(id, i, true, list.get(i));
                insertMapper.insertBigDecimalAfterSort(insert);
            }
            result.data("SortedBigDecimal", list);
            result.id(id);
        } else { //没有输入准确的type名称
            Result error = Result.error();
            error.setMessage("type请输入Integer, String 或者BigDecimal");
            return error;
        }
        return result;
    }


    @Override
    public Result getData(int id) {
        Integer t1 = insertMapper.searchIntegerTable(id);
        Integer t2 = insertMapper.searchStringTable(id);
        Integer t3 = insertMapper.searchBigDecimalTable(id);
        Result result = Result.ok();
        if(t1 != null){
            List<Integer> list1 = insertMapper.getIntegerBeforeSort(id);
            List<Integer> list2 = insertMapper.getIntegerAfterSort(id);
            result.data("IntegerBeforeSort", list1);
            result.data("IntegerAfterSort", list2);
            result.id(id);
        } else if(t2 != null){
            List<String> list1 = insertMapper.getStringBeforeSort(id);
            List<String> list2 = insertMapper.getStringAfterSort(id);
            result.data("StringBeforeSort", list1);
            result.data("StringAfterSort", list2);
            result.id(id);
        } else if(t3 != null){
            List<BigDecimal> list1 = insertMapper.getBigDecimalBeforeSort(id);
            List<BigDecimal> list2 = insertMapper.getBigDecimalAfterSort(id);
            result.data("BigDecimalBeforeSort", list1);
            result.data("BigDecimalAfterSort", list2);
            result.id(id);
        } else {
            Result error = Result.error();
            error.setMessage("这个id不存在。");
            return error;
        }
        return result;
    }
    
}
