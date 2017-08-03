package com.rest.messenger.convertor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.rest.messenger.model.MyDate;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider{

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		if(rawType.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					
					Calendar cal = Calendar.getInstance();
					
					if(value.equalsIgnoreCase("tomorrow")) {
						cal.add(Calendar.DATE, 1);
					}else if(value.equalsIgnoreCase("yesterday")) {
						cal.add(Calendar.DATE, -1);
					}	
					return rawType.cast(new MyDate(cal.get(Calendar.DATE),cal.get(Calendar.MONTH),cal.get(Calendar.YEAR)));
				}

				@Override
				public String toString(T value) {
					return value.toString();
				}
			};
		}
		return null;
	}


}
