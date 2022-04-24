package com.stone.mapper;

import com.stone.entity.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface InsertMapper {

    void insertIntegerBeforeSort(Insert<Integer> insert);

    void insertIntegerAfterSort(Insert insert);

    void insertStringBeforeSort(Insert insert);

    void insertStringAfterSort(Insert insert);

    void insertBigDecimalBeforeSort(Insert insert);

    void insertBigDecimalAfterSort(Insert insert);

    Integer searchIntegerTable(int id);
    Integer searchStringTable(int id);
    Integer searchBigDecimalTable(int id);

    List<Integer> getIntegerBeforeSort(int id);
    List<Integer> getIntegerAfterSort(int id);

    List<String> getStringBeforeSort(int id);
    List<String> getStringAfterSort(int id);

    List<BigDecimal> getBigDecimalBeforeSort(int id);
    List<BigDecimal> getBigDecimalAfterSort(int id);


}
