package com.winner.mytabisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-05-22
 */
@Data  //提供类的get、set、equals、hashCode、canEqual、toString方法
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("BASE_USER")
public class BaseUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "BU00")
    private Integer bu00;

    /**
     * 难搞
     */
    @TableField("BU01")
    private String bu01;

    @TableField("BU02")
    private String bu02;

    @TableField("BU03")
    private String bu03;

    @TableField("BU04")
    private String bu04;

    @TableField("BU05")
    private String bu05;

    @TableField("BU06")
    private String bu06;

    @TableField("BU07")
    private String bu07;

    @TableField("BU08")
    private String bu08;

    @TableField("BU09")
    private String bu09;

    @TableField("BU10")
    private String bu10;

    @TableField("BU11")
    private String bu11;

    @TableField("BU12")
    private String bu12;

    @TableField("BU13")
    private String bu13;

    @TableField("BU14")
    private String bu14;

    @TableField("BU15")
    private String bu15;

    @TableField("BU16")
    private String bu16;

    @TableField("BU17")
    private String bu17;

    @TableField("BU18")
    private String bu18;

    @TableField("BU19")
    private String bu19;

    @TableField("BU20")
    private String bu20;

    @TableField("BU21")
    private String bu21;

    @TableField("BU22")
    private Double bu22;

    @TableField("BU23")
    private Double bu23;

    @TableField("BU24")
    private String bu24;

    @TableField("BU25")
    private String bu25;

    @TableField("BU26")
    private String bu26;

    @TableField("BU27")
    private String bu27;

    @TableField("BU28")
    private String bu28;

    @TableField("BU29")
    private String bu29;

    @TableField("BU30")
    private String bu30;

    @TableField("BU31")
    private String bu31;

    @TableField("BU32")
    private String bu32;

    @TableField("BU33")
    private String bu33;


    
}
