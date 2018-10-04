package com.liwen.hello;

public class TestZip {
	public static void main(String[] args) {
		ZipCompress zipCom = new ZipCompress("H:\\temp\\电影.zip", "H:\\temp\\催记下载");
		try {
			zipCom.zip();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
