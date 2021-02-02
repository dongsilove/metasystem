package com.metasystem.common;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public abstract class CommonTbl {
	@Temporal(TemporalType.DATE)
	@Column(name="regist_dt")
	protected Date registDt;

	@Column(name="regist_id")
	protected String registId;

	@Temporal(TemporalType.DATE)
	@Column(name="modify_dt")
	protected Date modifyDt;

	@Column(name="modify_id")
	protected String modifyId;

	////@ApiModelProperty(value = "생성자")
	//@Column(name = "REG_ID")
	////@CreatedBy
	//protected String regId;
	//
	////@ApiModelProperty(value = "생성일")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	//@CreationTimestamp
	//@Column(name = "REG_DT")
	//protected LocalDateTime  regDt;
	//
	////@ApiModelProperty(value = "수정자")
	//@Column(name = "UPD_ID", nullable=true)
	////@LastModifiedBy
	//protected String updId;
	//
	////@ApiModelProperty(value = "수정일")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	//@UpdateTimestamp
	//@Column(name = "UPD_DT", nullable=true)
	//protected LocalDateTime  updDt;
}
