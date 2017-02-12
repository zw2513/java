package zw.example.learn.service.hello.mapper;

import zw.example.learn.service.hello.model.Diary;

import java.util.List;

public interface DiaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Diary record);

    int insertSelective(Diary record);

    Diary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Diary record);

    int updateByPrimaryKeyWithBLOBs(Diary record);

    int updateByPrimaryKey(Diary record);

    List<Diary> getAll();

    void deleteAll();
}