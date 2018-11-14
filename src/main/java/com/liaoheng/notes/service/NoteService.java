package com.liaoheng.notes.service;


import com.liaoheng.notes.domain.Note;
import com.liaoheng.notes.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteMapper noteMapper;

    /***
     * 动态查询
     * @param title
     * @param beginDate
     * @param endDate
     * @return
     */
    public List<Note> selAll(String title, Date beginDate,Date endDate){
        return noteMapper.selAll(title,beginDate,endDate);
    }

    /***
     * 新增
     * @param note
     * @return
     */
    public int insNote(Note note){
        return noteMapper.insNote(note);
    }

    /***
     * 修改
     * @param note
     * @return
     */
    public int updNote(Note note){
        return noteMapper.updNote(note);
    }

    /***
     * 删除
     * @param id
     * @return
     */
    public int delNote(Integer id){
        return noteMapper.delNote(id);
    }

    /***
     * 查询方法
     * @param id
     * @return
     */
    public  Note queryById(Integer id){
        return noteMapper.queryByID(id);
    }

}
