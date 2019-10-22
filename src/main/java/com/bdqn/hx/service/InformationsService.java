package com.bdqn.hx.service;

import com.bdqn.hx.mapper.InformationsMapper;
import com.bdqn.hx.mapper.RepliesMapper;
import com.bdqn.hx.pojo.Informations;
import com.bdqn.hx.pojo.Replies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InformationsService {

    @Resource
    InformationsMapper informationsMapper;
    @Resource
    RepliesMapper repliesMapper;
    /*第1步、在需要记录日志的类里写上这一行
    如果在工具类中引入log，由于工具类的方法为static的，所以log也要声明为static才行。
    private static final Logger aop=LoggerFactory.getLogger(FileUtils.class);*/
    private final Logger logger = LoggerFactory.getLogger(InformationsService.class);

    public List<Informations> queryAll(){
        List<Informations> list = null;
//        try {
//            int i = 4/0;
            list = informationsMapper.selectAll();  //第2步，在可能抛出异常的地方try-catch，aop.xxx()
       /* } catch (Exception e) {
            logger.error("失败");
            logger.error(e.getMessage());
        }*/
        return list;
    }

    public Informations queryInformationsById(Long id) {
        Informations informations = informationsMapper.selectByPrimaryKey(id);
        Replies replies = new Replies();
        replies.setInfoid(id);
        informations.setReplies(repliesMapper.select(replies));
        return informations;
    }
}
