package com.udian.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 公交车辆基础信息表
 * </p>
 *
 * @author Junkie
 * @since 2018-05-18
 */
@TableName("tbl_base_bus")
public class TblBaseBus implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 车辆数据主键
     */
    @TableId("bus_id")
    private String busId;
    /**
     * 车牌号
     */
    @TableField("bus_plate_number")
    private String busPlateNumber;
    /**
     * 车辆自编号
     */
    @TableField("bus_self_id")
    private String busSelfId;
    /**
     * 燃料类型   1:汽油 2:柴油 3:纯电 4:混合
     */
    @TableField("bus_fuel_type")
    private Integer busFuelType;
    /**
     * 车辆型号表数据主键
     */
    @TableField("bus_type_id")
    private String busTypeId;
    /**
     * 购买日期
     */
    @TableField("bus_purchase_date")
    private Date busPurchaseDate;
    /**
     * 车辆投放日期
     */
    @TableField("bus_delivery_date")
    private Date busDeliveryDate;
    /**
     * 车辆计划报废日期
     */
    @TableField("bus_plan_scrap_date")
    private Date busPlanScrapDate;
    /**
     * 车辆实际报废日期
     */
    @TableField("bus_real_scrap_date")
    private Date busRealScrapDate;
    /**
     * 车辆运营证号
     */
    @TableField("bus_operate_license")
    private String busOperateLicense;
    /**
     * 车辆行驶证号
     */
    @TableField("bus_driving_license")
    private String busDrivingLicense;
    /**
     * 营运性质 1:营运  2:非营运
     */
    @TableField("bus_is_operate")
    private Integer busIsOperate;
    /**
     * 车辆状态 1:使用  2:停用 3:报废
     */
    @TableField("bus_status")
    private Integer busStatus;
    /**
     * 车辆VIN码
     */
    @TableField("bus_vin_code")
    private String busVinCode;
    /**
     * 车辆底盘号
     */
    @TableField("bus_chassis_no")
    private String busChassisNo;
    /**
     * 车辆发动机号
     */
    @TableField("bus_engine_id")
    private String busEngineId;
    /**
     * 车辆保修日期
     */
    @TableField("bus_warranty_date")
    private Date busWarrantyDate;
    /**
     * 车辆出厂日期
     */
    @TableField("bus_product_date")
    private Date busProductDate;
    /**
     * 车辆购买价格
     */
    @TableField("bus_price")
    private BigDecimal busPrice;
    /**
     * 备注
     */
    @TableField("bus_memos")
    private String busMemos;
    /**
     * 车辆所属组织ID
     */
    @TableField("bus_org_id")
    private String busOrgId;
    @TableField("bus_plate_own")
    private String busPlateOwn;
    @TableField("bus_purpose")
    private String busPurpose;
    /**
     * 车牌号颜色
     */
    @TableField("bus_plate_color")
    private String busPlateColor;
    /**
     * 图片名称可以多张图片
     */
    @TableField("picture_name_json")
    private String pictureNameJson;
    /**
     * 是否删除 0:否 1：是
     */
    @TableField("is_delete")
    private Integer isDelete;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;
    /**
     * 最后一次操作人
     */
    @TableField("modify_user_id")
    private String modifyUserId;


    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusPlateNumber() {
        return busPlateNumber;
    }

    public void setBusPlateNumber(String busPlateNumber) {
        this.busPlateNumber = busPlateNumber;
    }

    public String getBusSelfId() {
        return busSelfId;
    }

    public void setBusSelfId(String busSelfId) {
        this.busSelfId = busSelfId;
    }

    public Integer getBusFuelType() {
        return busFuelType;
    }

    public void setBusFuelType(Integer busFuelType) {
        this.busFuelType = busFuelType;
    }

    public String getBusTypeId() {
        return busTypeId;
    }

    public void setBusTypeId(String busTypeId) {
        this.busTypeId = busTypeId;
    }

    public Date getBusPurchaseDate() {
        return busPurchaseDate;
    }

    public void setBusPurchaseDate(Date busPurchaseDate) {
        this.busPurchaseDate = busPurchaseDate;
    }

    public Date getBusDeliveryDate() {
        return busDeliveryDate;
    }

    public void setBusDeliveryDate(Date busDeliveryDate) {
        this.busDeliveryDate = busDeliveryDate;
    }

    public Date getBusPlanScrapDate() {
        return busPlanScrapDate;
    }

    public void setBusPlanScrapDate(Date busPlanScrapDate) {
        this.busPlanScrapDate = busPlanScrapDate;
    }

    public Date getBusRealScrapDate() {
        return busRealScrapDate;
    }

    public void setBusRealScrapDate(Date busRealScrapDate) {
        this.busRealScrapDate = busRealScrapDate;
    }

    public String getBusOperateLicense() {
        return busOperateLicense;
    }

    public void setBusOperateLicense(String busOperateLicense) {
        this.busOperateLicense = busOperateLicense;
    }

    public String getBusDrivingLicense() {
        return busDrivingLicense;
    }

    public void setBusDrivingLicense(String busDrivingLicense) {
        this.busDrivingLicense = busDrivingLicense;
    }

    public Integer getBusIsOperate() {
        return busIsOperate;
    }

    public void setBusIsOperate(Integer busIsOperate) {
        this.busIsOperate = busIsOperate;
    }

    public Integer getBusStatus() {
        return busStatus;
    }

    public void setBusStatus(Integer busStatus) {
        this.busStatus = busStatus;
    }

    public String getBusVinCode() {
        return busVinCode;
    }

    public void setBusVinCode(String busVinCode) {
        this.busVinCode = busVinCode;
    }

    public String getBusChassisNo() {
        return busChassisNo;
    }

    public void setBusChassisNo(String busChassisNo) {
        this.busChassisNo = busChassisNo;
    }

    public String getBusEngineId() {
        return busEngineId;
    }

    public void setBusEngineId(String busEngineId) {
        this.busEngineId = busEngineId;
    }

    public Date getBusWarrantyDate() {
        return busWarrantyDate;
    }

    public void setBusWarrantyDate(Date busWarrantyDate) {
        this.busWarrantyDate = busWarrantyDate;
    }

    public Date getBusProductDate() {
        return busProductDate;
    }

    public void setBusProductDate(Date busProductDate) {
        this.busProductDate = busProductDate;
    }

    public BigDecimal getBusPrice() {
        return busPrice;
    }

    public void setBusPrice(BigDecimal busPrice) {
        this.busPrice = busPrice;
    }

    public String getBusMemos() {
        return busMemos;
    }

    public void setBusMemos(String busMemos) {
        this.busMemos = busMemos;
    }

    public String getBusOrgId() {
        return busOrgId;
    }

    public void setBusOrgId(String busOrgId) {
        this.busOrgId = busOrgId;
    }

    public String getBusPlateOwn() {
        return busPlateOwn;
    }

    public void setBusPlateOwn(String busPlateOwn) {
        this.busPlateOwn = busPlateOwn;
    }

    public String getBusPurpose() {
        return busPurpose;
    }

    public void setBusPurpose(String busPurpose) {
        this.busPurpose = busPurpose;
    }

    public String getBusPlateColor() {
        return busPlateColor;
    }

    public void setBusPlateColor(String busPlateColor) {
        this.busPlateColor = busPlateColor;
    }

    public String getPictureNameJson() {
        return pictureNameJson;
    }

    public void setPictureNameJson(String pictureNameJson) {
        this.pictureNameJson = pictureNameJson;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    @Override
    public String toString() {
        return "TblBaseBus{" +
        ", busId=" + busId +
        ", busPlateNumber=" + busPlateNumber +
        ", busSelfId=" + busSelfId +
        ", busFuelType=" + busFuelType +
        ", busTypeId=" + busTypeId +
        ", busPurchaseDate=" + busPurchaseDate +
        ", busDeliveryDate=" + busDeliveryDate +
        ", busPlanScrapDate=" + busPlanScrapDate +
        ", busRealScrapDate=" + busRealScrapDate +
        ", busOperateLicense=" + busOperateLicense +
        ", busDrivingLicense=" + busDrivingLicense +
        ", busIsOperate=" + busIsOperate +
        ", busStatus=" + busStatus +
        ", busVinCode=" + busVinCode +
        ", busChassisNo=" + busChassisNo +
        ", busEngineId=" + busEngineId +
        ", busWarrantyDate=" + busWarrantyDate +
        ", busProductDate=" + busProductDate +
        ", busPrice=" + busPrice +
        ", busMemos=" + busMemos +
        ", busOrgId=" + busOrgId +
        ", busPlateOwn=" + busPlateOwn +
        ", busPurpose=" + busPurpose +
        ", busPlateColor=" + busPlateColor +
        ", pictureNameJson=" + pictureNameJson +
        ", isDelete=" + isDelete +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", modifyUserId=" + modifyUserId +
        "}";
    }
}
