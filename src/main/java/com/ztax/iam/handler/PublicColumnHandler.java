package com.ztax.iam.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ztax.iam.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis plus拦截器，可以用来处理公共字段
 */
@Slf4j
@Component
public class PublicColumnHandler implements MetaObjectHandler {

    private static final String CREATE_ID = "createId";
    private static final String CREATE_TIME = "createTime";

    private static final String UPDATE_ID = "updateId";
    private static final String UPDATE_TIME = "updateTime";

    private static final String DEL_ID = "delId";
    private static final String DEL_TIME = "delTime";
    private static final String DEL_FLG = "delFlg";

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setFieldValByName(CREATE_TIME, LocalDateTime.now(), metaObject);
        this.setFieldValByName(CREATE_ID, WebUtils.getUserId(), metaObject);

    }


    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");

        //处理逻辑删除 字段填充
        if (metaObject.hasGetter(DEL_FLG) && metaObject.getValue(DEL_FLG) == Boolean.TRUE) {
            this.setFieldValByName(DEL_TIME, LocalDateTime.now(), metaObject);
            this.setFieldValByName(DEL_ID, WebUtils.getUserId(), metaObject);

            //普通更新操作
        } else {
            this.setFieldValByName(UPDATE_TIME, LocalDateTime.now(), metaObject);
            this.setFieldValByName(UPDATE_ID, WebUtils.getUserId(), metaObject);
        }
    }

}