package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 应急文件信息实体
 *
 * @author zyl
 * @date 2026-04-02
 */
@Data
@TableName("T_CC_EMERGENCYFILEINFO")
public class EmergencyFileInfoEntity {

    private String otherSystem;
    private String emergencyFileCode;
    private String emergencyFileName;
    private String emergencyFileUrl;
    private String emergencyFilePDF;
    private String triggerPage;
    private String businessTag;
    private String payChannel;
    private String businessType;
    /********** 继承CheckableEntity需要定义的属性 **********/
    private String checkerId;
    private Boolean checkState;
    private Date checkTime;
}
