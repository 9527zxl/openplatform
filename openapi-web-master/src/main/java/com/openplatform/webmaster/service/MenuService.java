package com.openplatform.webmaster.service;

import com.openplatform.webmaster.commons.LayUiDataFormat;

import java.util.List;

public interface MenuService {

    /**
     * 查询全部数据
     * @return
     */
    List<LayUiDataFormat> getMenu();
}
