package com.lq.lqproj.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
/*@Data不起作用则在setting的plugins处安装lombok插件*/
@Data
public class Student {

    private Integer id;
    @NotNull(message = "请输入学号")
    private String num;
    @NotBlank(message = "请输入名称")
    @Length(message = "名称不能超过个 {max} 字符", max = 10)
    private String sname;

    private String sex;
    @Range(message = "年龄范围为 {min} 到 {max} 之间", min = 1, max = 100)
    private String age;

    private Date cretim;

}