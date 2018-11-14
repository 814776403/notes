package com.liaoheng.notes.controller;

import com.liaoheng.notes.domain.Note;
import com.liaoheng.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")

public class NoteController {
    @Autowired
    private NoteService noteService;

    /***
     * 删除
     */
    @RequestMapping(value = "del",method = RequestMethod.GET)
    public ResponseEntity<?>delNote(@RequestParam(name = "id")Integer id){
        int ret=noteService.delNote(id);
        System.out.println(ret);
        return new ResponseEntity<>(ret,HttpStatus.OK);
    }

    /***
     * 动态查询
     * @param title
     * @param beginDate
     * @param endDate
     * @return
     */
    @RequestMapping(value = "sel",method = RequestMethod.GET)
    public ResponseEntity<List<Note>> query(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "beginDate",required = false)  @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
            @RequestParam(value = "endDate",required = false)  @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        List<Note> noteList  = noteService.selAll(title,beginDate,endDate);
        if(noteList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(noteList,HttpStatus.OK);
    }


    //新增或者修改
    @ResponseBody
    @RequestMapping(value = "ins",method = RequestMethod.GET)
    public ResponseEntity<?> addCar(@RequestParam(name = "title",required = false)String title,  @RequestParam(name = "content",required = false)String content,
                                    @RequestParam(name = "time",required = false)
                                    @DateTimeFormat(pattern = "yyyy-MM-dd")Date time,@RequestParam(name = "id",required = false)Integer id){
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        note.setTime(time);
        int count=0;
        if(id==0){
             count = noteService.insNote(note);

        }else{
             note.setId(id);
             count=noteService.updNote(note);
        }
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    /***
     * 根据id查询
     * @param id
     * @return
     */
    //produces返回参数类型是json  utf-8
    @RequestMapping(value = "upd",method = RequestMethod.GET)
    public ResponseEntity<Note> queryByid(@RequestParam(value = "id")Integer id){
        Note note=  noteService.queryById(id);
        return new ResponseEntity<>(note,HttpStatus.OK);
    }


}
