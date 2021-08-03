package com.lingDream.llfEnglish.tool.handler;

import com.lingDream.llfEnglish.tool.exception.CommonException;
import com.lingDream.llfEnglish.tool.result.Result;
import com.lingDream.llfEnglish.tool.result.ResultCode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义的公共异常处理器
 * 1.声明异常处理器
 * 2.对异常统一处理
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        Result result = new Result(ResultCode.SERVER_ERROR);
        if (e instanceof CommonException) {
            final CommonException commonException = (CommonException) e;
            result = new Result(commonException.getResultCode());
        } else if (e instanceof DuplicateKeyException) {
            result = new Result(ResultCode.FAIL);
        } else if (e instanceof DataIntegrityViolationException) {
            result = new Result(ResultCode.FAIL).setMessage("数据操作失败");
        } else {
            e.printStackTrace();
        }
        return result;
    }
}
