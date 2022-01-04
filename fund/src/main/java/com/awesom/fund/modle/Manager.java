package com.awesom.fund.modle;

import java.io.Serializable;

/**
 * @author yangdejun
 * @date 2020/09/22
 **/
public class Manager implements Serializable {
    private static final long serialVersionUID = 2079745765153623919L;
    private Integer id;
    private String fundManagerCode;
    private String fundManagerName;
    private String appointmentDate;
    private Integer appointmentDays;
    private Integer workingDays;
    private Integer managerFundNum;
    private String companyCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFundManagerCode() {
        return fundManagerCode;
    }

    public void setFundManagerCode(String fundManagerCode) {
        this.fundManagerCode = fundManagerCode;
    }

    public String getFundManagerName() {
        return fundManagerName;
    }

    public void setFundManagerName(String fundManagerName) {
        this.fundManagerName = fundManagerName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Integer getAppointmentDays() {
        return appointmentDays;
    }

    public void setAppointmentDays(Integer appointmentDays) {
        this.appointmentDays = appointmentDays;
    }

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
    }

    public Integer getManagerFundNum() {
        return managerFundNum;
    }

    public void setManagerFundNum(Integer managerFundNum) {
        this.managerFundNum = managerFundNum;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", fundManagerCode='" + fundManagerCode + '\'' +
                ", fundManagerName='" + fundManagerName + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", appointmentDays=" + appointmentDays +
                ", workingDays=" + workingDays +
                ", managerFundNum=" + managerFundNum +
                ", companyCode='" + companyCode + '\'' +
                '}';
    }
}
