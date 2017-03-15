package com.github.cockpit.mapper;

import com.github.cockpit.domain.Fr;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.caches.ignite.IgniteCacheAdapter;

import java.util.List;

/**
 * Created on 2017/3/9.
 *
 * @author Asin Liu
 */

@CacheNamespace(implementation = IgniteCacheAdapter.class, size = Integer.MAX_VALUE/100000)
public interface FrMapper {

    @Insert("Insert into test_fr (name) values (#{name})")
    long addNewFr(@Param("name") String name);

    @Select("Select * from test_fr where name=#{name}")
    List<Fr> getFrByName(@Param("name") String name);
}


