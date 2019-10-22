package com.bdqn.hx.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Informations implements Serializable {
    @KeySql(useGeneratedKeys = true)
    @Id
    private Long id;

    private String title;

    private String content;

    private Integer replycount;

    private Integer viewcount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reporttime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastposttime;

    @Transient
    private List<Replies> replies;
}