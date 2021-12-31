package com.openplatform.webmaster.mapper;

import com.openplatform.webmaster.pojo.Menu;

import java.util.List;

public interface MenuMapper {

    /**
     * 查询全部数据
     * @return
     */
    List<Menu> findMenuAll();
}
