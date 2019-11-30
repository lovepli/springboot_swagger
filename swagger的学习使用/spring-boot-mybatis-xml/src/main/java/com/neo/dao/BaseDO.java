package com.neo.dao;

import com.alibaba.fastjson.annotation.JSONField;


import com.neo.tools.DateUtil;
import io.swagger.annotations.ApiModel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 *
 * ClassName: BaseDO <br/>
 * Function: 包含基础属性的DO. <br/>
 * Reason: 定义公共属性,如果为mapper的子类,可以覆盖方法(可选). <br/>
 * date: 2017年2月27日 下午2:19:50 <br/>
 *
 *
 * @version
 * @since
 */
@ApiModel
public abstract class BaseDO extends PersistentDO {

    private static final long serialVersionUID = 1534056643006312407L;

    /**
     * 主键 主键由数据库自增主键生成
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 租户编号
     */
    private String tenantId;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String wDesc;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * 修改时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    /**
     * 删除标记1.正常 0.删除 del_flag
     */
    private Integer delFlag;

    private Integer createBy;

    private Integer updateBy;

    /**
     * 创建人姓名
     */
    @Transient
    private String createrName;

    /**
     * 修改人姓名
     */
    @Transient
    private String updaterName;

    @Transient
    private String createDateStr;

    @Transient
    private String updateDateStr;

    /**
     * 忽略字段 加密KEY(行级数据认证字段)
     */
    @Transient
    private String rsv_;

    /**
     * 删除使用是否显示字段
     */
    @Transient
    private Boolean vis_ = false;

    /**
     * 此条记录是否被激活
     */
    @Transient
    private Boolean active_ = false;

    /**
     * 修改操作时候进行比对的名称
     */
    @Transient
    private String name_;

    /**
     * 排序名称
     */
    @Transient
    private String orderName;

    /**
     * 排序值
     */
    @Transient
    private String orderValue;

    @Transient
    private String idStr;

    public String getIdStr() {
        if(id != null){
            return id.toString();
        }
        return null;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getwDesc() {
        return wDesc;
    }

    public void setwDesc(String wDesc) {
        this.wDesc = wDesc;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    @Transient
    public String getId_() {
        return String.valueOf(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdStr(String id) {
        this.id = Integer.parseInt(id);
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }



    /**
     *
     * checkRsv_:(检查结果是否正确, 数据篡改). <br/>
     *
     * @author songs
     * @param
     * @return
     * @since
     */
//    public boolean checkRsv_(String curRsv_) {
//        return StrUtil.equals(curRsv_, this.rsv_);
//    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getUpdaterName() {return updaterName;}

    public void setUpdaterName(String updaterName) {this.updaterName = updaterName;}

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     *
     * getCreateDateStr:(创建时间格式化). <br/>
     *
     * @author songs
     * @return
     * @since
     */
    public String getCreateDateStr() {
        if (null != createDate) {
            createDateStr = DateUtil.formatDateTime(createDate);
        }
        return createDateStr;
    }

    /**
     *
     * getUpdateDateStr:(修改时间格式化). <br/>
     *
     * @author songs
     * @return
     * @since
     */
    public String getUpdateDateStr() {
        if (null != updateDate) {
            updateDateStr = DateUtil.formatDateTime(updateDate);
        }
        return updateDateStr;
    }

    public Boolean getVis_() {
        return vis_;
    }

    public void setVis_(Boolean vis_) {
        this.vis_ = vis_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public Boolean getActive_() {
        return active_;
    }

    public void setActive_(Boolean active_) {
        this.active_ = active_;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(String orderValue) {
        this.orderValue = orderValue;
    }
}
