package com.github.cockpit.mapper;

import com.github.cockpit.domain.Fr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created on 2017/3/9.
 * @author Asin Liu
 */
public interface FrMapper {

    @Insert("Insert into test_fr (name) values (#{name})")
    long addNewFr(@Param("name") String name);

    @Select("Select * from test_fr where name=#{name}")
    List<Fr> getFrByName(@Param("name") String name);
}


