package zw.example.learn.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zw.example.learn.service.hello.HelloService;
import zw.example.learn.service.hello.model.Diary;
import zw.example.learn.service.hello.model.validate.AddDiary;
import zw.example.learn.service.hello.model.validate.UpdateDiary;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zw on 2017/2/11 22:27.
 */
@RestController
@RequestMapping("/hello")
class HelloController {
    private HelloService helloService;

    @Autowired
    HelloController(HelloService a_helloService) {
        this.helloService = a_helloService;
    }

    @GetMapping("/name")
    public String getGreeting(@RequestParam(value = "name", required = false)
                                      String name) {
        return helloService.hello(name);
    }

    @PostMapping("/addDiary")
    public ResponseEntity<Integer> addDiary(@RequestBody @Validated({AddDiary
            .class})
    Diary
                                     diary) {
        return ResponseEntity.ok(helloService.add(diary));
    }

    @PostMapping("/updateDiary")
    public ResponseEntity<Diary> updateDiary(@RequestBody @Validated
            ({UpdateDiary.class})Diary diary){
        helloService.update(diary);
        return ResponseEntity.ok(helloService.getById(diary.getId()));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Diary>> getAll(){
        return ResponseEntity.ok(helloService.getAll());
    }

    @GetMapping("/getById/{id:\\d+}")
    public ResponseEntity<Diary> getById(@PathVariable(value = "id")Integer id){
        return ResponseEntity.ok(helloService.getById(id));
    }
}

