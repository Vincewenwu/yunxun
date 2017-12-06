package com.vision.edu.platform.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @title 
 * @filename StringToEnumConverterFactory.java
 * @author XieFan
 * @date 2017年6月27日 上午10:43:07
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
final class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {

    @SuppressWarnings({ "unchecked" })
	public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
    	  return new StringToEnumConverter(targetType);
    }

	private final class StringToEnumConverter<T extends Enum> implements Converter<String, T> {
    	private Class<T> enumType;

        public StringToEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }

        @SuppressWarnings("unchecked")
		public T convert(String source) {
        	try{
        		return (T) Enum.valueOf(this.enumType, source.trim());
        	}catch(Exception ex){
        		return null;
        	}
        }
    }
}

