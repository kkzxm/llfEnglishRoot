package com.lingDream.llfEnglish.tool.exception;

import com.lingDream.llfEnglish.tool.result.ResultCode;
import lombok.Getter;

import java.text.MessageFormat;

import static java.util.Objects.isNull;

/**
 * 自定义异常
 */
@Getter
public class CommonException extends RuntimeException {

    private final ResultCode resultCode;
    private Object object;

    public CommonException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public CommonException(ResultCode resultCode, Object object) {
        this.resultCode = resultCode;
        this.object = object;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}\n[{1}]",
                this.resultCode,
                isNull(object) ? "" : object);
    }
}
