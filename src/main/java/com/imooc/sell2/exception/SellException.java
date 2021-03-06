package com.imooc.sell2.exception;

import com.imooc.sell2.enums.ResultEnum;
import lombok.Getter;

/**
 * Exceptions on seller side
 *
 * @author Shuhao Bai on 9/12/19
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;

    }
}
