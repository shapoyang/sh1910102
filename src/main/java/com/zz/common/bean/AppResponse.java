package com.zz.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//响应类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppResponse<T> {
	//响应状态码：决定响应成功还是失败 ：00000：代表成功，其他的都代表失败
	private String code;
	//响应描述字符串
	private String message;
	//响应数据
	private T data;
	
	//业务bean ：成功的响应，失败的响应(左边那个泛型是方法的泛型，右边的是返回值的泛型)
	public static <T> AppResponse<T> ok(T data) {
		return new AppResponse<T>("00000","success",data);
	}
	
	public static <T> AppResponse<T> fail(String code,String message) {
		return new AppResponse<T>(code,message,null);
	}
	
	
}
