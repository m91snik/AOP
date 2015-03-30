/**
 * Created by nikolay.garbuzov on 23.02.15.
 */
package com.m91snik.business.session.dto;

public class Session{
    private final String userId;
    private final Group group;

    public Session(String userId, Group group) {
        this.group = group;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public Group getGroup() {
        return group;
    }
}
