package com.awesom.fund.modle;

/**
 * @author yangdejun
 * @date 2020/09/23
 **/
public class Fund {
    private Integer id;
    private String fundCode;
    private String fundName;
    private Double fundScale;
    private String companyCode;
    private String fundManagerCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Double getFundScale() {
        return fundScale;
    }

    public void setFundScale(Double fundScale) {
        this.fundScale = fundScale;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getFundManagerCode() {
        return fundManagerCode;
    }

    public void setFundManagerCode(String fundManagerCode) {
        this.fundManagerCode = fundManagerCode;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "id=" + id +
                ", fundCode='" + fundCode + '\'' +
                ", fundName='" + fundName + '\'' +
                ", fundScale=" + fundScale +
                ", companyCode='" + companyCode + '\'' +
                ", fundManagerCode='" + fundManagerCode + '\'' +
                '}';
    }
}
