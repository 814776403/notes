package com.liaoheng.notes;

import com.liaoheng.notes.mapper.NoteMapper;
import com.liaoheng.notes.service.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
        private NoteMapper noteMapper;

    @Test
    public void contextLoads() {



    }

    @Test
    public void del() {

    }

}
