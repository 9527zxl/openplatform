package com.openplatform.webmaster.mapper;

import com.openplatform.webmaster.pojo.ApiMapping;
import com.openplatform.webmaster.vo.ApiMappingVo;

import java.util.List;

public interface ApiMappingMapper {
    List<ApiMapping> findApiMapperAll(ApiMappingVo vo);
}
