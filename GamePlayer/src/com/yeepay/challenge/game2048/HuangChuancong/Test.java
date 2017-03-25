/**
 * 文件名：Test.java
 * 所在包：com.yeepay.challenge.game2048.HuangChuancong
 * 日期：2014-11-19 下午9:39:44
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package com.yeepay.challenge.game2048.HuangChuancong;

import com.yeepay.challenge.game2048.GameConsole;

/**
 *
 * 项目名称：GamePlayer
 * 类名称：Test
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-19 下午9:39:44
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Test {
	public static void main(String[] args) {
		GameConsole.start(PlayerImpl.class);
	}
}
