package com.openplatform.webmaster.vo;

import com.openplatform.webmaster.pojo.ApiMapping;
import lombok.Data;

/**
 * @author 9527zxl
 * @Date 2022/02/07 21:33
 */
@Data
public class ApiMappingVo extends ApiMapping {
    private Integer limit;
    private Integer page;
}
