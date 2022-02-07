package com.openplatform.webmaster.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.openplatform.webmaster.commons.LayUIDataResult;
import com.openplatform.webmaster.mapper.ApiMappingMapper;
import com.openplatform.webmaster.pojo.ApiMapping;
import com.openplatform.webmaster.service.ApiMappingService;
import com.openplatform.webmaster.vo.ApiMappingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 9527zxl
 * @Date 2022/02/07 21:18
 */
@Service
public class ApiMappingServiceImpl implements ApiMappingService {
    @Autowired
    private ApiMappingMapper apiMappingMapper;

    @Override
    public LayUIDataResult getApiMapperLimit(ApiMappingVo vo) {
        PageHelper.startPage(vo.getPage(),vo.getLimit());
        List<ApiMapping> apiMappingList = apiMappingMapper.findApiMapperAll(vo);
        PageInfo<ApiMapping> info = new PageInfo<>(apiMappingList);

        LayUIDataResult result = new LayUIDataResult(0, (int) info.getTotal(),"",info.getList());

        return result;
    }
}
