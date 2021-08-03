package com.lingDream.llfEnglish.tool.root;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.llfEnglish.tool.result.Result;
import com.lingDream.llfEnglish.tool.result.ResultCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-06-09 10:05
 */
public class ThereController<T> {
    protected IService<T> service;
    private final String COMMENT;

    public ThereController(IService<T> service, String COMMENT) {
        this.service = service;
        this.COMMENT = COMMENT;
    }

    @GetMapping("getPage")
    @ResponseBody
    public Result getPage(@RequestParam(defaultValue = "1") Integer thisPage,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          T entity) {
        return new Result(
                ResultCode.SUCCESS,
                service.page(
                        new Page<>(thisPage, pageSize),
                        new QueryWrapper<>(entity)
                )
        );
    }

    @RequestMapping("/getComment")
    public Result getCOMMENT() {
        return new Result(ResultCode.SUCCESS, COMMENT);
    }


    protected Result save(T t) {
        Result result;
        if (service.save(t)) {
            result = new Result(ResultCode.SUCCESS, t);
        } else {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    protected Result removeById(Serializable serializable, T t) {
        if (service.removeById(serializable)) {
            return new Result(ResultCode.SUCCESS, t);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    protected Result updateById(T t) {
        Result result;
        if (service.updateById(t)) {
            result = new Result(ResultCode.SUCCESS);
        } else {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }
}
