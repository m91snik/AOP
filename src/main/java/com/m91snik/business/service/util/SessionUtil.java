/**
 * Created by m91snik on 09.04.15.
 */
package com.m91snik.business.service.util;

import com.m91snik.business.session.SessionService;
import com.m91snik.business.session.dto.Group;

public class SessionUtil {

    private SessionService sessionService;

    public boolean validateSession(Group group) {
        return group == sessionService.getCurrentSession().getGroup();
    }
}
