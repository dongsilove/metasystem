package com.metasystem.common;

import java.time.LocalDateTime;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


public class CommonTbl {
	//@ApiModelProperty(value = "생성자")
	@Column(name = "REG_ID")
	//@CreatedBy
	protected String regId;
	
	//@ApiModelProperty(value = "생성일")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@CreationTimestamp
	@Column(name = "REG_DT")
	protected LocalDateTime  regDt;
	
	//@ApiModelProperty(value = "수정자")
	@Column(name = "UPD_ID", nullable=true)
	//@LastModifiedBy
	protected String updId;
	
	//@ApiModelProperty(value = "수정일")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@UpdateTimestamp
	@Column(name = "UPD_DT", nullable=true)
	protected LocalDateTime  updDt;
}
