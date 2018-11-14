package com.liaoheng.notes.mapper;

import com.liaoheng.notes.domain.Note;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
public interface NoteMapper {

    /***
     * 查询所有
     * @return
     */
         List<Note> selAll(@Param("title")String title, @Param("beginDate")Date beginDate,
                           @Param("endDate")Date endDate);

    /***
     * 新增note
     * id自增
     * @param note
     * @return
     */
    @Insert("insert into note(title,content,time) values(#{title},#{content},#{time})")
         int insNote(Note note);


    /***
     * 修改
     */

    @Update("update note set title=#{title},content=#{content},time=#{time} where id=#{id}")
    int updNote(Note note);

    /**
     * 删除
     */
    @Delete("delete from note where id=#{id}")
     int delNote(Integer id);


    /***
     * 根据id查询
     */
    @Select("select id,title,content,time  from note where id=#{id}")
    Note queryByID(Integer id);
}
