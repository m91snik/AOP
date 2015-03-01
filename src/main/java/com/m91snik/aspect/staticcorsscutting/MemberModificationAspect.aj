package com.m91snik.aspect.staticcorsscutting;

import com.m91snik.business.session.dto.Session;

import java.util.UUID;

/**
 * Field and method introduction example. It will work only with ajc compilation
 */
public aspect MemberModificationAspect {
    private String Session.internalReferenceId;

    public String Session.getInternalReferenceId() {
        return internalReferenceId;
    }

    after (Session session): execution(Session.new(..)) && this(session){
        session.internalReferenceId = UUID.randomUUID().toString();
    }
}
