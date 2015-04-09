package com.m91snik.aspect.staticcorsscutting;

import java.io.IOException;

/**
 * Created by m91snik on 09.04.15.
 */
public aspect ExceptionSofteningAspect {
    declare soft :IOException: execution(* com.m91snik.business.service.util.BytesUtil.*(..));
}
