package com.entity.vo;

import com.entity.ChanpinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 产品追溯
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chanpin")
public class ChanpinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 追溯码
     */

    @TableField(value = "chanpin_uuid_number")
    private String chanpinUuidNumber;


    /**
     * 产品名称
     */

    @TableField(value = "chanpin_name")
    private String chanpinName;


    /**
     * 产品类型
     */

    @TableField(value = "chanpin_types")
    private Integer chanpinTypes;


    /**
     * 产品图片
     */

    @TableField(value = "chanpin_photo")
    private String chanpinPhoto;


    /**
     * 种植企业
     */

    @TableField(value = "chanpin_zhongzhi")
    private String chanpinZhongzhi;


    /**
     * 加工企业
     */

    @TableField(value = "chanpin_jiagong")
    private String chanpinJiagong;


    /**
     * 运输企业
     */

    @TableField(value = "chanpin_yunshu")
    private String chanpinYunshu;


    /**
     * 销售企业
     */

    @TableField(value = "chanpin_xiaoshou")
    private String chanpinXiaoshou;


    /**
     * 主要原材料
     */

    @TableField(value = "chanpin_yuancailiao")
    private String chanpinYuancailiao;


    /**
     * 种子
     */

    @TableField(value = "chanpin_zhongzi")
    private String chanpinZhongzi;


    /**
     * 肥料
     */

    @TableField(value = "chanpin_feiliao")
    private String chanpinFeiliao;


    /**
     * 农药
     */

    @TableField(value = "chanpin_nongyao")
    private String chanpinNongyao;


    /**
     * 数量
     */

    @TableField(value = "chanpin_number")
    private Integer chanpinNumber;


    /**
     * 单位
     */

    @TableField(value = "chanpin_danwei")
    private String chanpinDanwei;


    /**
     * 生产日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chanpin_time")
    private Date chanpinTime;


    /**
     * 保质期(天)
     */

    @TableField(value = "chanpin_baozhi")
    private Integer chanpinBaozhi;


    /**
     * 创建时间 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：追溯码
	 */
    public String getChanpinUuidNumber() {
        return chanpinUuidNumber;
    }


    /**
	 * 获取：追溯码
	 */

    public void setChanpinUuidNumber(String chanpinUuidNumber) {
        this.chanpinUuidNumber = chanpinUuidNumber;
    }
    /**
	 * 设置：产品名称
	 */
    public String getChanpinName() {
        return chanpinName;
    }


    /**
	 * 获取：产品名称
	 */

    public void setChanpinName(String chanpinName) {
        this.chanpinName = chanpinName;
    }
    /**
	 * 设置：产品类型
	 */
    public Integer getChanpinTypes() {
        return chanpinTypes;
    }


    /**
	 * 获取：产品类型
	 */

    public void setChanpinTypes(Integer chanpinTypes) {
        this.chanpinTypes = chanpinTypes;
    }
    /**
	 * 设置：产品图片
	 */
    public String getChanpinPhoto() {
        return chanpinPhoto;
    }


    /**
	 * 获取：产品图片
	 */

    public void setChanpinPhoto(String chanpinPhoto) {
        this.chanpinPhoto = chanpinPhoto;
    }
    /**
	 * 设置：种植企业
	 */
    public String getChanpinZhongzhi() {
        return chanpinZhongzhi;
    }


    /**
	 * 获取：种植企业
	 */

    public void setChanpinZhongzhi(String chanpinZhongzhi) {
        this.chanpinZhongzhi = chanpinZhongzhi;
    }
    /**
	 * 设置：加工企业
	 */
    public String getChanpinJiagong() {
        return chanpinJiagong;
    }


    /**
	 * 获取：加工企业
	 */

    public void setChanpinJiagong(String chanpinJiagong) {
        this.chanpinJiagong = chanpinJiagong;
    }
    /**
	 * 设置：运输企业
	 */
    public String getChanpinYunshu() {
        return chanpinYunshu;
    }


    /**
	 * 获取：运输企业
	 */

    public void setChanpinYunshu(String chanpinYunshu) {
        this.chanpinYunshu = chanpinYunshu;
    }
    /**
	 * 设置：销售企业
	 */
    public String getChanpinXiaoshou() {
        return chanpinXiaoshou;
    }


    /**
	 * 获取：销售企业
	 */

    public void setChanpinXiaoshou(String chanpinXiaoshou) {
        this.chanpinXiaoshou = chanpinXiaoshou;
    }
    /**
	 * 设置：主要原材料
	 */
    public String getChanpinYuancailiao() {
        return chanpinYuancailiao;
    }


    /**
	 * 获取：主要原材料
	 */

    public void setChanpinYuancailiao(String chanpinYuancailiao) {
        this.chanpinYuancailiao = chanpinYuancailiao;
    }
    /**
	 * 设置：种子
	 */
    public String getChanpinZhongzi() {
        return chanpinZhongzi;
    }


    /**
	 * 获取：种子
	 */

    public void setChanpinZhongzi(String chanpinZhongzi) {
        this.chanpinZhongzi = chanpinZhongzi;
    }
    /**
	 * 设置：肥料
	 */
    public String getChanpinFeiliao() {
        return chanpinFeiliao;
    }


    /**
	 * 获取：肥料
	 */

    public void setChanpinFeiliao(String chanpinFeiliao) {
        this.chanpinFeiliao = chanpinFeiliao;
    }
    /**
	 * 设置：农药
	 */
    public String getChanpinNongyao() {
        return chanpinNongyao;
    }


    /**
	 * 获取：农药
	 */

    public void setChanpinNongyao(String chanpinNongyao) {
        this.chanpinNongyao = chanpinNongyao;
    }
    /**
	 * 设置：数量
	 */
    public Integer getChanpinNumber() {
        return chanpinNumber;
    }


    /**
	 * 获取：数量
	 */

    public void setChanpinNumber(Integer chanpinNumber) {
        this.chanpinNumber = chanpinNumber;
    }
    /**
	 * 设置：单位
	 */
    public String getChanpinDanwei() {
        return chanpinDanwei;
    }


    /**
	 * 获取：单位
	 */

    public void setChanpinDanwei(String chanpinDanwei) {
        this.chanpinDanwei = chanpinDanwei;
    }
    /**
	 * 设置：生产日期
	 */
    public Date getChanpinTime() {
        return chanpinTime;
    }


    /**
	 * 获取：生产日期
	 */

    public void setChanpinTime(Date chanpinTime) {
        this.chanpinTime = chanpinTime;
    }
    /**
	 * 设置：保质期(天)
	 */
    public Integer getChanpinBaozhi() {
        return chanpinBaozhi;
    }


    /**
	 * 获取：保质期(天)
	 */

    public void setChanpinBaozhi(Integer chanpinBaozhi) {
        this.chanpinBaozhi = chanpinBaozhi;
    }
    /**
	 * 设置：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
