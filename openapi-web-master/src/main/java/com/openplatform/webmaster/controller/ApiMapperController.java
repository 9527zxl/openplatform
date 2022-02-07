package com.openplatform.webmaster.controller;

import com.openplatform.webmaster.commons.LayUIDataResult;
import com.openplatform.webmaster.service.ApiMappingService;
import com.openplatform.webmaster.vo.ApiMappingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 9527zxl
 * @Date 2022/02/07 21:21
 */
@RestController
public class ApiMapperController {

    @Autowired
    private ApiMappingService apiMappingService;

    @RequestMapping("/sys/api_mapping/table")
    public LayUIDataResult mapperTableHandler(ApiMappingVo vo){
        return apiMappingService.getApiMapperLimit(vo);
    }
}
