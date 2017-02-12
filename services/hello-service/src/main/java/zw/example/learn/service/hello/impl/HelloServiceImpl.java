package zw.example.learn.service.hello.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zw.example.learn.service.hello.HelloService;
import zw.example.learn.service.hello.mapper.DiaryMapper;
import zw.example.learn.service.hello.model.Diary;

import java.util.List;

/**
 * Created by zw on 2017/2/11 22:29.
 */
@Service
public class HelloServiceImpl implements HelloService{

    private DiaryMapper diaryMapper;

    @Autowired
    public HelloServiceImpl(DiaryMapper a_diaryMapper){
        this.diaryMapper = a_diaryMapper;
    }


    @Override
    public String hello(String name) {
        if (name == null || name.isEmpty()){
            name = "world";
        }

        return "hello" + name;
    }

    @Override
    public List<Diary> getAll() {
        return diaryMapper.getAll();
    }

    @Override
    public void deleteAll() {
        diaryMapper.deleteAll();
    }

    @Override
    @Transactional
    public Integer add(Diary diary) {
        diaryMapper.insertSelective(diary);
        return diary.getId();
    }

    @Override
    @Transactional
    public Diary update(Diary diary) {
        diaryMapper.updateByPrimaryKeyWithBLOBs(diary);
        return diaryMapper.selectByPrimaryKey(diary.getId());
    }

    @Override
    public Diary getById(Integer id) {
        return diaryMapper.selectByPrimaryKey(id);
    }
}
