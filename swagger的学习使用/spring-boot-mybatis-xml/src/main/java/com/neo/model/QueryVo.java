package com.neo.model;

import java.util.List;

/**
 * @author: lipan
 * @date: 2019-06-15
 * @description:  包装pojo
 */
public class QueryVo {

    //里层也是一个pojo
    private User user;

    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                '}';
    }
}
