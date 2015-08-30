package org.ship.common.uniquecode;

import java.text.SimpleDateFormat;
import java.util.Random;

import org.ship.common.MsgCodeConstant;

/**
 * 生成唯一编码
 * @author Administrator1
 *
 */
public class CommonUniqueCode {

	
	
	public String uniqueCode(String typeCode){
		String result = "";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");  
		java.util.Date date=new java.util.Date();  
		String str=sdf.format(date); 
		Random random = new Random();
		int s1 = random.nextInt(99)%(99-0+1) + 0;
		int s2 = random.nextInt(99)%(99-0+1) + 0;
		if(!typeCode.isEmpty()){
			if(typeCode.equals(MsgCodeConstant.RESOURCE_CODE)){
				result = MsgCodeConstant.RESOURCE_CODE + s1 + str + s2;
			}
			if(typeCode.equals(MsgCodeConstant.USER_CODE)){
				result = MsgCodeConstant.USER_CODE + s1 + str + s2;
			}
			if(typeCode.equals(MsgCodeConstant.ROLE_CODE)){
				result = MsgCodeConstant.ROLE_CODE + s1 + str + s2;
			}
		}else {
			return MsgCodeConstant.ERROR;
		}
		return result;
	}
}
