package com.openplatform.webmaster.commons;

import com.openplatform.webmaster.pojo.Menu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class LayUiDataFormat extends Menu {
    private List<LayUiDataFormat> children=new ArrayList<>();
}
