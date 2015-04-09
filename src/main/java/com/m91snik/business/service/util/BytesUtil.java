/**
 * Created by m91snik on 09.04.15.
 */
package com.m91snik.business.service.util;

import com.m91snik.business.session.SessionService;
import com.m91snik.business.session.dto.Group;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;

public class BytesUtil {

    public String bytesToString(byte[] bytes) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(bytes);
        out.close();
        return out.toString();
    }

}
