package zw.example.learn.service.hello.model;

import org.springframework.validation.annotation.Validated;
import zw.example.learn.service.hello.model.validate.AddDiary;
import zw.example.learn.service.hello.model.validate.UpdateDiary;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Diary {

    @NotNull(message = "when update ,id can not be null",groups =
            {UpdateDiary.class})
    private Integer id;

    @NotNull(message = "title can not be null",groups = {AddDiary.class})
    @Size(max = 100,groups = {AddDiary.class})
    private String title;

    private Date time = new Date();

    private Integer readnum = 0;

    @NotNull(message = "content can not be null",groups = {AddDiary.class})
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getReadnum() {
        return readnum;
    }

    public void setReadnum(Integer readnum) {
        this.readnum = readnum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}