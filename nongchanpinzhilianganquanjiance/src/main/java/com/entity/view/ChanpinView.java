package com.entity.view;

import com.entity.ChanpinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 产品追溯
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chanpin")
public class ChanpinView extends ChanpinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 产品类型的值
		*/
		private String chanpinValue;



	public ChanpinView() {

	}

	public ChanpinView(ChanpinEntity chanpinEntity) {
		try {
			BeanUtils.copyProperties(this, chanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 产品类型的值
			*/
			public String getChanpinValue() {
				return chanpinValue;
			}
			/**
			* 设置： 产品类型的值
			*/
			public void setChanpinValue(String chanpinValue) {
				this.chanpinValue = chanpinValue;
			}









}
