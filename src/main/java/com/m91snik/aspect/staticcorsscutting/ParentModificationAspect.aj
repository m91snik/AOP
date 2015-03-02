/**
 * Created by m91snik on 02.03.15.
 */
package com.m91snik.aspect.staticcorsscutting;

public aspect ParentModificationAspect {

    declare parents : com.m91snik.business.session.dto..* implements com.m91snik.contract.HasRefId;
}
