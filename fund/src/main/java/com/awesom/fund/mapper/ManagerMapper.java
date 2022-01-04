package com.awesom.fund.mapper;

import com.awesom.fund.modle.Manager;

import java.util.List;

/**
 * @author yangdejun
 * @date 2020/09/22
 **/
public interface ManagerMapper {
    /**
     * sdf
     * @param manager
     */
    void insertOneManager(Manager manager);

    /**
     * 查询所有基金经理数据
     * @return
     */
    List<Manager> selectAll();
}
