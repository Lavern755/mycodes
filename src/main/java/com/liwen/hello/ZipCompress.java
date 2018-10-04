package com.liwen.hello;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;

public class ZipCompress {
	private String zipFileName; // 目的地Zip文件
	private String sourceFileName; // 源文件（带压缩的文件或文件夹）

	public ZipCompress(String zipFileName, String sourceFileName) {
		this.zipFileName = zipFileName;
		this.sourceFileName = sourceFileName;
	}

	public void zip() throws Exception {
		// File zipFile = new File(zipFileName);
		System.out.println("压缩中...");
		// 创建zip输出流
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		// 创建缓冲输出流
		BufferedOutputStream bos = new BufferedOutputStream(out);
		File sourceFile = new File(sourceFileName);

		// 调用函数
		compress(out, bos, sourceFile, sourceFile.getName());

		bos.close();
		out.close();
		System.out.println("压缩完成");

	}

	public void compress(ZipOutputStream out, BufferedOutputStream bos, File sourceFile, String base) throws Exception {

		ZipParameters zipParameters = new ZipParameters();
		File[] flist;

		// 如果路径为目录（文件夹）
		if (sourceFile.isDirectory()) {
			// 取出文件夹中的文件（或子文件夹）
			flist = sourceFile.listFiles();
			for (int i = 0; i < flist.length; i++) {
				out.putNextEntry(flist[i], zipParameters);
			}
			FileInputStream fos = new FileInputStream(sourceFile);
			BufferedInputStream bis = new BufferedInputStream(fos);
			try {
				int tag;
				System.out.println(base);
				// 将源文件写入到zip文件中
				while ((tag = bis.read()) != -1) {
					bos.write(tag);
				}

			} catch (Exception e) {

			} finally {
				if (bos != null) {
					bos.close();
				}
				if (bis != null) {
					bis.close();
				}
			}

		}

	}
}
