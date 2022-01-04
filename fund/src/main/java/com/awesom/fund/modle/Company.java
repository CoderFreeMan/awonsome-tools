package com.awesom.fund.modle;

import java.io.Serializable;

/**
 * @author yangdejun
 * @date 2020/09/21
 **/
public class Company implements Serializable {

    private static final long serialVersionUID = -2584786028809383987L;

    private Integer id;
    private String companyCode;
    private String companyName;
    private String established;
    private Integer fundTotal;
    private Integer fundManagerTotal;
    private String fundScale;
    private String overallRating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEstablished() {
        return established;
    }

    public void setEstablished(String established) {
        this.established = established;
    }

    public Integer getFundTotal() {
        return fundTotal;
    }

    public void setFundTotal(Integer fundTotal) {
        this.fundTotal = fundTotal;
    }

    public Integer getFundManagerTotal() {
        return fundManagerTotal;
    }

    public void setFundManagerTotal(Integer fundManagerTotal) {
        this.fundManagerTotal = fundManagerTotal;
    }

    public String getFundScale() {
        return fundScale;
    }

    public void setFundScale(String fundScale) {
        this.fundScale = fundScale;
    }

    public String getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(String overallRating) {
        this.overallRating = overallRating;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyCode='" + companyCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", established='" + established + '\'' +
                ", fundTotal=" + fundTotal +
                ", fundManagerTotal=" + fundManagerTotal +
                ", fundScale='" + fundScale + '\'' +
                ", overallRating='" + overallRating + '\'' +
                '}';
    }
}
