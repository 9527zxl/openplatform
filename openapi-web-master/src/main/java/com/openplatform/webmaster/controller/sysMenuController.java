package com.openplatform.webmaster.controller;

import com.openplatform.webmaster.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class sysMenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/side")
    public Map<String, Object> menuMethod(){
        Map<String, Object> map = new HashMap<>();
        map.put("result",menuService.getMenu());
        return map;
    }

}
