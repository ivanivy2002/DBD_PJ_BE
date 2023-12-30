package com.example.dbd_pj_be.config;//package com.example.dbd_pj_be.config;
//
//import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
//import org.apache.ibatis.reflection.MetaObject;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//@Component
//public class MetaObjectHandlerConfig implements MetaObjectHandler {
//    @Override
//    public void insertFill(MetaObject metaObject) {
//        this.strictInsertFill(metaObject,"create_time", Date.class,new Date());
//        this.strictUpdateFill(metaObject, "update_time", Date.class, new Date());
//    }
//
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        this.strictUpdateFill(metaObject, "update_time", Date.class, new Date());
//    }
//}
