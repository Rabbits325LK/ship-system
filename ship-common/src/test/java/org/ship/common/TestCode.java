package org.ship.common;

import org.ship.common.uniquecode.CommonUniqueCode;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 CommonUniqueCode uniqueCode = new  CommonUniqueCode();
		String code = uniqueCode.uniqueCode(MsgCodeConstant.RESOURCE_CODE);
		System.out.println(code);
	}

}
