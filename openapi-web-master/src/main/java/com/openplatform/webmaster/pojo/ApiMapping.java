package com.openplatform.webmaster.pojo;

import lombok.Data;

/**
 * @author 9527zxl
 * @Date 2022/02/07 21:12
 */
@Data
public class ApiMapping {
    private Integer id;
    private String gatewayApiName;
    private String insideApiUrl;
    private Integer state;
    private String description;
    private String serviceId;
    private String idempotents;
    private String needfee;
}
