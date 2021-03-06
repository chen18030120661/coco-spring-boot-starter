package com.cxy.spring.boot.test.redis.mapper;

import com.cxy.spring.boot.module.msgqueue.MsgQueueEntity;

import java.util.List;

/**
 * @author : xy.chen
 * @time : 2019/7/24
 * @desc : Mapper
 */
public interface TestMapper {
    /**
     * 批量保存
     *
     * @param list
     * @return
     */
    int insertTestBath(List<MsgQueueEntity> list);

}
