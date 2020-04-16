package com.hemaobin.webDemo.domain;

import java.io.Serializable;
/**
 * 文件上传信息保存
 * @author hemb
 * @date   2019年10月3日
 */
import java.sql.Timestamp;
public class fileInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 文件id
	 */
	private int id;
	
	/**
	 * 文件大小
	 */
	private long fileSize;
	
	/**
	 * 真实文件名
	 */
	private String fileName;
	
	/**
	 * 文件上传路径
	 */
	private String filePath;
	
	/**
	 * 文件后上传保存文件名
	 */
	private String realFileName;
	
	/**
	 * 文件上传时间
	 */
	private Timestamp creattime;
	
	/**
	 * 文件上传者
	 */
	private String creatName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getRealFileName() {
		return realFileName;
	}

	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}

	public Timestamp getCreattime() {
		return creattime;
	}

	public void setCreattime(Timestamp creattime) {
		this.creattime = creattime;
	}

	public String getCreatName() {
		return creatName;
	}

	public void setCreatName(String creatName) {
		this.creatName = creatName;
	}

	
	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "fileInfoVO [id=" + id + ", fileSize=" + fileSize + ", fileName=" + fileName + ", filePath=" + filePath
				+ ", realFileName=" + realFileName + ", creattime=" + creattime + ", creatName=" + creatName + "]";
	}
}
