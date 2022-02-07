package com.openplatform.webmaster.service;

import com.openplatform.webmaster.commons.LayUIDataResult;
import com.openplatform.webmaster.vo.ApiMappingVo;

public interface ApiMappingService {
    LayUIDataResult getApiMapperLimit(ApiMappingVo vo);
}
