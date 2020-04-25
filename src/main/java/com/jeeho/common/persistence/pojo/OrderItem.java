package com.jeeho.common.persistence.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_order_item.id
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_order_item.user_id
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_order_item.order_no
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    private Long orderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_order_item.product_id
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    private Integer productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_order_item.product_name
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_order_item.product_image
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    private String productImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_order_item.current_unit_price
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    private BigDecimal currentUnitPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_order_item.quantity
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_order_item.total_price
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    private BigDecimal totalPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_order_item.create_time
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_order_item.update_time
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_order_item.id
     *
     * @return the value of mmall_order_item.id
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_order_item.id
     *
     * @param id the value for mmall_order_item.id
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_order_item.user_id
     *
     * @return the value of mmall_order_item.user_id
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_order_item.user_id
     *
     * @param userId the value for mmall_order_item.user_id
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_order_item.order_no
     *
     * @return the value of mmall_order_item.order_no
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public Long getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_order_item.order_no
     *
     * @param orderNo the value for mmall_order_item.order_no
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_order_item.product_id
     *
     * @return the value of mmall_order_item.product_id
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_order_item.product_id
     *
     * @param productId the value for mmall_order_item.product_id
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_order_item.product_name
     *
     * @return the value of mmall_order_item.product_name
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_order_item.product_name
     *
     * @param productName the value for mmall_order_item.product_name
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_order_item.product_image
     *
     * @return the value of mmall_order_item.product_image
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public String getProductImage() {
        return productImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_order_item.product_image
     *
     * @param productImage the value for mmall_order_item.product_image
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_order_item.current_unit_price
     *
     * @return the value of mmall_order_item.current_unit_price
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public BigDecimal getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_order_item.current_unit_price
     *
     * @param currentUnitPrice the value for mmall_order_item.current_unit_price
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_order_item.quantity
     *
     * @return the value of mmall_order_item.quantity
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_order_item.quantity
     *
     * @param quantity the value for mmall_order_item.quantity
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_order_item.total_price
     *
     * @return the value of mmall_order_item.total_price
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_order_item.total_price
     *
     * @param totalPrice the value for mmall_order_item.total_price
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_order_item.create_time
     *
     * @return the value of mmall_order_item.create_time
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_order_item.create_time
     *
     * @param createTime the value for mmall_order_item.create_time
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_order_item.update_time
     *
     * @return the value of mmall_order_item.update_time
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_order_item.update_time
     *
     * @param updateTime the value for mmall_order_item.update_time
     *
     * @mbggenerated Sun Oct 13 00:10:04 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}