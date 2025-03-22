package com.entity.model;

import com.entity.ChanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 产品追溯
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChanpinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 追溯码
     */
    private String chanpinUuidNumber;


    /**
     * 产品名称
     */
    private String chanpinName;


    /**
     * 产品类型
     */
    private Integer chanpinTypes;


    /**
     * 产品图片
     */
    private String chanpinPhoto;


    /**
     * 种植企业
     */
    private String chanpinZhongzhi;


    /**
     * 加工企业
     */
    private String chanpinJiagong;


    /**
     * 运输企业
     */
    private String chanpinYunshu;


    /**
     * 销售企业
     */
    private String chanpinXiaoshou;


    /**
     * 主要原材料
     */
    private String chanpinYuancailiao;


    /**
     * 种子
     */
    private String chanpinZhongzi;


    /**
     * 肥料
     */
    private String chanpinFeiliao;


    /**
     * 农药
     */
    private String chanpinNongyao;


    /**
     * 数量
     */
    private Integer chanpinNumber;


    /**
     * 单位
     */
    private String chanpinDanwei;


    /**
     * 生产日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chanpinTime;


    /**
     * 保质期(天)
     */
    private Integer chanpinBaozhi;


    /**
     * 创建时间 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：追溯码
	 */
    public String getChanpinUuidNumber() {
        return chanpinUuidNumber;
    }


    /**
	 * 设置：追溯码
	 */
    public void setChanpinUuidNumber(String chanpinUuidNumber) {
        this.chanpinUuidNumber = chanpinUuidNumber;
    }
    /**
	 * 获取：产品名称
	 */
    public String getChanpinName() {
        return chanpinName;
    }


    /**
	 * 设置：产品名称
	 */
    public void setChanpinName(String chanpinName) {
        this.chanpinName = chanpinName;
    }
    /**
	 * 获取：产品类型
	 */
    public Integer getChanpinTypes() {
        return chanpinTypes;
    }


    /**
	 * 设置：产品类型
	 */
    public void setChanpinTypes(Integer chanpinTypes) {
        this.chanpinTypes = chanpinTypes;
    }
    /**
	 * 获取：产品图片
	 */
    public String getChanpinPhoto() {
        return chanpinPhoto;
    }


    /**
	 * 设置：产品图片
	 */
    public void setChanpinPhoto(String chanpinPhoto) {
        this.chanpinPhoto = chanpinPhoto;
    }
    /**
	 * 获取：种植企业
	 */
    public String getChanpinZhongzhi() {
        return chanpinZhongzhi;
    }


    /**
	 * 设置：种植企业
	 */
    public void setChanpinZhongzhi(String chanpinZhongzhi) {
        this.chanpinZhongzhi = chanpinZhongzhi;
    }
    /**
	 * 获取：加工企业
	 */
    public String getChanpinJiagong() {
        return chanpinJiagong;
    }


    /**
	 * 设置：加工企业
	 */
    public void setChanpinJiagong(String chanpinJiagong) {
        this.chanpinJiagong = chanpinJiagong;
    }
    /**
	 * 获取：运输企业
	 */
    public String getChanpinYunshu() {
        return chanpinYunshu;
    }


    /**
	 * 设置：运输企业
	 */
    public void setChanpinYunshu(String chanpinYunshu) {
        this.chanpinYunshu = chanpinYunshu;
    }
    /**
	 * 获取：销售企业
	 */
    public String getChanpinXiaoshou() {
        return chanpinXiaoshou;
    }


    /**
	 * 设置：销售企业
	 */
    public void setChanpinXiaoshou(String chanpinXiaoshou) {
        this.chanpinXiaoshou = chanpinXiaoshou;
    }
    /**
	 * 获取：主要原材料
	 */
    public String getChanpinYuancailiao() {
        return chanpinYuancailiao;
    }


    /**
	 * 设置：主要原材料
	 */
    public void setChanpinYuancailiao(String chanpinYuancailiao) {
        this.chanpinYuancailiao = chanpinYuancailiao;
    }
    /**
	 * 获取：种子
	 */
    public String getChanpinZhongzi() {
        return chanpinZhongzi;
    }


    /**
	 * 设置：种子
	 */
    public void setChanpinZhongzi(String chanpinZhongzi) {
        this.chanpinZhongzi = chanpinZhongzi;
    }
    /**
	 * 获取：肥料
	 */
    public String getChanpinFeiliao() {
        return chanpinFeiliao;
    }


    /**
	 * 设置：肥料
	 */
    public void setChanpinFeiliao(String chanpinFeiliao) {
        this.chanpinFeiliao = chanpinFeiliao;
    }
    /**
	 * 获取：农药
	 */
    public String getChanpinNongyao() {
        return chanpinNongyao;
    }


    /**
	 * 设置：农药
	 */
    public void setChanpinNongyao(String chanpinNongyao) {
        this.chanpinNongyao = chanpinNongyao;
    }
    /**
	 * 获取：数量
	 */
    public Integer getChanpinNumber() {
        return chanpinNumber;
    }


    /**
	 * 设置：数量
	 */
    public void setChanpinNumber(Integer chanpinNumber) {
        this.chanpinNumber = chanpinNumber;
    }
    /**
	 * 获取：单位
	 */
    public String getChanpinDanwei() {
        return chanpinDanwei;
    }


    /**
	 * 设置：单位
	 */
    public void setChanpinDanwei(String chanpinDanwei) {
        this.chanpinDanwei = chanpinDanwei;
    }
    /**
	 * 获取：生产日期
	 */
    public Date getChanpinTime() {
        return chanpinTime;
    }


    /**
	 * 设置：生产日期
	 */
    public void setChanpinTime(Date chanpinTime) {
        this.chanpinTime = chanpinTime;
    }
    /**
	 * 获取：保质期(天)
	 */
    public Integer getChanpinBaozhi() {
        return chanpinBaozhi;
    }


    /**
	 * 设置：保质期(天)
	 */
    public void setChanpinBaozhi(Integer chanpinBaozhi) {
        this.chanpinBaozhi = chanpinBaozhi;
    }
    /**
	 * 获取：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
