package com.openplatform.webmaster.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 9527zxl
 * @Date 2022/02/07 21:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LayUIDataResult {
    private Integer code;
    private Integer count;
    private String msg;
    private List<?> data;
}
