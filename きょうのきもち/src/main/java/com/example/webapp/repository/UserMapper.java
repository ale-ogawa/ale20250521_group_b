package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.webapp.entity.User;



@Mapper
public interface UserMapper {

  List<User> getUserSet(@Param("id") Integer id);
   /**
    @Update("""
    	    UPDATE accounts
    	    SET nickname = #{nickname},
    	        choice = #{choice}
    	    WHERE id = #{id}
    	""")
    	void updateUser(Setting setting);
    @Select("SELECT id, name FROM diseases ORDER BY id")
    List<Disease> getAllDiseases();*/
}