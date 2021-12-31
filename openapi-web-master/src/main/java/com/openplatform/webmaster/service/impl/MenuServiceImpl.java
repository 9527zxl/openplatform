package com.openplatform.webmaster.service.impl;

import com.openplatform.webmaster.commons.LayUiDataFormat;
import com.openplatform.webmaster.mapper.MenuMapper;
import com.openplatform.webmaster.pojo.Menu;
import com.openplatform.webmaster.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl  implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<LayUiDataFormat> getMenu() {
        List<Menu> menuList = menuMapper.findMenuAll();
        List<LayUiDataFormat> list = new ArrayList<>();
        List<LayUiDataFormat> childrenList = new ArrayList<>();

        for (Menu menu : menuList) {
            if (menu.getType()==1){
                LayUiDataFormat dataFormat = new LayUiDataFormat();
                dataFormat.setName(menu.getName());
                dataFormat.setType(menu.getType());
                dataFormat.setUrl(menu.getUrl());

                if (menu.getParentId()!=null){
                    childrenList.add(dataFormat);
                }else {
                    list.add(dataFormat);
                }
            }
        }

        for (Menu menu : menuList) {
            if (menu.getType()==0){
                LayUiDataFormat dataFormat = new LayUiDataFormat();
                dataFormat.setName(menu.getName());
                dataFormat.setType(1);
                dataFormat.setUrl(menu.getUrl());
                dataFormat.setChildren(childrenList);
                list.add(dataFormat);
            }
        }
        return list;
    }
}
