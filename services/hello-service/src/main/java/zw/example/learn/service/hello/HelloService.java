package zw.example.learn.service.hello;

import zw.example.learn.service.hello.model.Diary;

import java.util.List;

/**
 * Created by zw on 2017/2/11 22:29.
 */
public interface HelloService {
    String hello(String name);

    Integer add(Diary diary);

    Diary getById(Integer id);

    Diary update(Diary diary);

    List<Diary> getAll();

    void deleteAll();
}
