package org.example.common.errorcode;

import com.westsecu.inf.base.errorcode.ErrorCode;
import com.westsecu.inf.base.errorcode.ErrorCodeConstant;

/**
 * 服务编码(2位) + 模块编码(3位) + 自定义错误码(3位)
 * 01            00               000
 */
public abstract class AppErrorCodeConstant extends ErrorCodeConstant {
    public static final int CODE_PREFIX = 100000;

    public static final ErrorCode CREATE_BOOK_FAILURE = new ErrorCode(CODE_PREFIX + 1, "create book failure");
}
