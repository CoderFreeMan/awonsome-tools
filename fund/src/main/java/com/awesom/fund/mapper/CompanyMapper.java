package com.awesom.fund.mapper;

import com.awesom.fund.modle.Company;

import java.util.List;

/**
 * @author yangdejun
 * @date 2020/09/21
 **/
public interface CompanyMapper {
    /**
     * 插入一个公司
     * @param company
     */
    void insertCompany(Company company);

    /**
     * 查询所有基金公司
     * @return
     */
    List<Company> findAllCompany();
}
