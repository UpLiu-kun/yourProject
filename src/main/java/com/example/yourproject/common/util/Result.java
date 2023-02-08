package com.example.yourproject.common.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("请求结果")
public class Result<T> {

    @ApiModelProperty("接口请求码")
    private String code;
    @ApiModelProperty("返回信息")
    private String msg;
    @ApiModelProperty("返回结果")
    private T result;

    public Result(){
        super();
    }
    public Result(String code,String msg,T result){
        super();
        this.code=code;
        this.msg=msg;
        this.result=result;
    }
    public Result(String code,String msg){
        super();
        this.code=code;
        this.msg=msg;
    }
    public Result(T result){
        super();
        this.code="200";
        this.msg="操作成功";
        this.result=result;
    }
    public static Result<Object> success(){
        return new Result<>("200","成功");
    }
    public static Result<Object> success(Object result){
        return new Result<>("200","成功",result);
    }
    public static Result<Object> error() {
        return new Result<>("202","失败");
    }
    public static Result<Object> error(String msg) {
        return new Result<>("202",msg);
    }
}
