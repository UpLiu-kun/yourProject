package com.example.yourproject.userManage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @创建人 LiuKun
 * @创建时间 ReqBean$
 * @描述
 */
@Data
public class ReqBean {

    @ApiModelProperty("主键ID")
    private String resumeId;
}
