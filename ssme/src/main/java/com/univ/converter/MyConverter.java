package com.univ.converter;

import org.springframework.core.convert.converter.Converter;

/** 
 * @author univ 
 * @date 2016年1月12日 下午3:40:39 
 * @version v1.0
 * @Description: 自定义类型转换器
 */
public class MyConverter implements Converter<String, Integer>{

	public Integer convert(String source) {
		return 222;
	}

}

