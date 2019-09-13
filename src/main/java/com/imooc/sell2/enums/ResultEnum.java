package com.imooc.sell2.enums;

import lombok.Getter;

/**
 * 返回给前端提示的一个消息
 *
 * @author Shuhao Bai on 9/12/19
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
