package com.awesom.fund.mapper;

import com.awesom.fund.modle.Fund;

/**
 * @author yangdejun
 * @date 2020/09/23
 **/
public interface FundMapper {
    /**
     * 插入一条基金数据
     * @param fund
     */
    void insertOne(Fund fund);

    /**
     * 更新一条基金数据
     * @param fund
     */
    void updateOne(Fund fund);
}
