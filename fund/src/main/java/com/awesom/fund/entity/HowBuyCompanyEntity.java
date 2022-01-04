package com.awesom.fund.entity;

import java.io.Serializable;

/**
 * @author yangdejun
 * @date 2020/09/21
 **/
public class HowBuyCompanyEntity implements Serializable {

    private static final long serialVersionUID = -5340562200580338995L;

    private String clrq;
    private String jgdm;
    private String jgjc;
    private String jjdm;
    private double jjhb;
    private String jjjc;
    private int jjjlsl;
    private int jjsl;
    private String jjzcjz;
    private String rydm;
    private String ryxm;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getClrq() {
        return clrq;
    }

    public void setClrq(String clrq) {
        this.clrq = clrq;
    }

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    public String getJgjc() {
        return jgjc;
    }

    public void setJgjc(String jgjc) {
        this.jgjc = jgjc;
    }

    public String getJjdm() {
        return jjdm;
    }

    public void setJjdm(String jjdm) {
        this.jjdm = jjdm;
    }

    public double getJjhb() {
        return jjhb;
    }

    public void setJjhb(double jjhb) {
        this.jjhb = jjhb;
    }

    public String getJjjc() {
        return jjjc;
    }

    public void setJjjc(String jjjc) {
        this.jjjc = jjjc;
    }

    public int getJjjlsl() {
        return jjjlsl;
    }

    public void setJjjlsl(int jjjlsl) {
        this.jjjlsl = jjjlsl;
    }

    public int getJjsl() {
        return jjsl;
    }

    public void setJjsl(int jjsl) {
        this.jjsl = jjsl;
    }

    public String getJjzcjz() {
        return jjzcjz;
    }

    public void setJjzcjz(String jjzcjz) {
        this.jjzcjz = jjzcjz;
    }

    public String getRydm() {
        return rydm;
    }

    public void setRydm(String rydm) {
        this.rydm = rydm;
    }

    public String getRyxm() {
        return ryxm;
    }

    public void setRyxm(String ryxm) {
        this.ryxm = ryxm;
    }

    @Override
    public String toString() {
        return "HowBuyCompanyEntity{" +
                "clrq='" + clrq + '\'' +
                ", jgdm='" + jgdm + '\'' +
                ", jgjc='" + jgjc + '\'' +
                ", jjdm='" + jjdm + '\'' +
                ", jjhb=" + jjhb +
                ", jjjc='" + jjjc + '\'' +
                ", jjjlsl=" + jjjlsl +
                ", jjsl=" + jjsl +
                ", jjzcjz=" + jjzcjz +
                ", rydm='" + rydm + '\'' +
                ", ryxm='" + ryxm + '\'' +
                '}';
    }
}
