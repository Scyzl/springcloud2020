package com.scy.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Scy
 * @Date 2020/9/10 11:16
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("公用结果集封装对象：CommonResult")
public class CommonResult<T> {
    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("状态信息描述")
    private String message;
    @ApiModelProperty("数据")
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
