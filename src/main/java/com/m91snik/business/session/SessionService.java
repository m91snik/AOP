/**
 * Created by nikolay.garbuzov on 23.02.15.
 */
package com.m91snik.business.session;

import com.m91snik.business.session.dto.Group;
import com.m91snik.business.session.dto.Session;

public interface SessionService {

    Session getCurrentSession();

    Session createSession(String userId, Group group);
}
