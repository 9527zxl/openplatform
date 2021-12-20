package com.openplatform.cache.utils;

import com.openplatform.cache.exception.KeyException;
import org.apache.commons.lang.StringUtils;

public class KeyUtils {

    /**
     * 判断redis中key值不能为空
     * @param key
     */
    public static void exit(String key){
        if (StringUtils.isEmpty(key)){
            throw new KeyException("key的值不能为空");
        }
    }
}
