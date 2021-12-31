package com.openplatform.webmaster.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Menu implements Serializable {
    private Integer id;
    private String name;
    private Integer parentId;
    private String url;
    private String icon;
    private String perms;
    private Integer type;
    private Integer sort;
}
