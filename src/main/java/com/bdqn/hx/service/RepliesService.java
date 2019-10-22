package com.bdqn.hx.service;

import com.bdqn.hx.mapper.RepliesMapper;
import com.bdqn.hx.pojo.Replies;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RepliesService {

    @Resource
    private RepliesMapper repliesMapper;

    public boolean addreply(Replies replies) {
//        int i = repliesMapper.insertSelective(replies);
        int i = repliesMapper.insertReplies(replies);
        if (i == 1){
            return true;
        }
        return false;
    }
}
