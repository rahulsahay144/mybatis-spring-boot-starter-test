package com.github.cockpit.mapper;


import com.github.cockpit.domain.Usr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Mapper of Usr. *
 * Created on 2017/3/7.
 * @author Asin Liu
 */
public interface UsrMapper {
    /**
     * @param account
     * @return
     */
    @Select("SELECT * FROM test_usr WHERE account = #{account}")
    List<Usr> listUsrByAccount(@Param("account") String account);

    @Insert("insert into test_usr (account,phone,password) values (#{account},#{phone},#{password})")
    long addNew(@Param("account") String account,
                @Param("phone") String phone, @Param("password") String password);

}
