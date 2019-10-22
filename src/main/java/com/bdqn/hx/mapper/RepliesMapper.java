package com.bdqn.hx.mapper;

import com.bdqn.hx.pojo.Replies;
import org.apache.ibatis.annotations.Insert;
import tk.mybatis.mapper.common.Mapper;

public interface RepliesMapper  extends Mapper<Replies> {

    @Insert("insert into replies (content, replytime, infoid) values (#{content}, #{replytime}, #{infoid})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertReplies(Replies replies);

}