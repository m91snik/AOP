/**
 * Created by nikolay.garbuzov on 23.02.15.
 */
package com.m91snik.business.session.impl;

import com.m91snik.business.session.SessionService;
import com.m91snik.business.session.dto.Group;
import com.m91snik.business.session.dto.Session;
import org.springframework.stereotype.Service;


@Service
public class SessionServiceImpl implements SessionService {

    private ThreadLocal<Session> SESSION = new ThreadLocal<>();

    @Override
    public Session getCurrentSession() {
        return SESSION.get();
    }

    @Override
    public void createSession(String userId, Group group) {
        SESSION.set(new Session(userId, group));
    }
}
