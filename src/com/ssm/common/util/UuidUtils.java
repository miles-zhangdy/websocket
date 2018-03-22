package com.ssm.common.util;

import java.io.Serializable;
import java.util.UUID;

public class UuidUtils implements Serializable{

	private static final long serialVersionUID = -6683397699809848749L;

	public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

}
