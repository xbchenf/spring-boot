package com.xbchen.springcloud.mongodb.dao;

import com.xbchen.springcloud.model.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xbchen on 2018/06/
 * Mongodb 操作入库
 */
@Component
public class UserMongodbDao extends BasicDAO<User, ObjectId> {

    @Autowired
    public UserMongodbDao(Datastore datastore) {
        super(datastore);
    }
}
