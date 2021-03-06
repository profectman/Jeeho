package com.jeeho.common.persistence.dao;

import com.jeeho.common.persistence.pojo.Order;
import com.jeeho.common.persistence.pojo.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_order
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    int countByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_order
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    int deleteByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_order
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_order
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_order
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_order
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_order
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_order
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_order
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_order
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_order
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    int updateByPrimaryKey(Order record);
}