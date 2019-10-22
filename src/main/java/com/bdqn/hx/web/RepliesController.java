package com.bdqn.hx.web;

import com.bdqn.hx.pojo.Replies;
import com.bdqn.hx.service.RepliesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("reply")
public class RepliesController {

    @Resource
    private RepliesService repliesService;

    /**
    * @Description: 添加说明
    * @Param:
    * @return:
    * @Author:
    * @Date: 2019/10/22
    */
    @PostMapping("addreply")
    private ResponseEntity<Replies> addreply(Replies replies){
        replies.setReplytime(new Date());
        boolean addreply = repliesService.addreply(replies);
        if (addreply){
            return ResponseEntity.ok(replies);
        }
        return ResponseEntity.ok().build();
    }
}
