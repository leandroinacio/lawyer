package com.leandro.lawyer.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "record")
public class Record implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@NotNull
	private String user;
	private String recordTitle;
	private String recordDescription;

	@NotNull
	private List<RecordType> recordType;

	private Date dtCreated;
	private Date dtUpdated;

	public Record() {
		super();
	}

	public Record(Long id, String user, String recordTitle, String recordDescription, List<RecordType> recordType,
			Date dtCreated, Date dtUpdated) {
		super();
		this.id = id;
		this.user = user;
		this.recordTitle = recordTitle;
		this.recordDescription = recordDescription;
		this.recordType = recordType;
		this.dtCreated = dtCreated;
		this.dtUpdated = dtUpdated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRecordTitle() {
		return recordTitle;
	}

	public void setRecordTitle(String recordTitle) {
		this.recordTitle = recordTitle;
	}

	public String getRecordDescription() {
		return recordDescription;
	}

	public void setRecordDescription(String recordDescription) {
		this.recordDescription = recordDescription;
	}

	public List<RecordType> getRecordType() {
		return recordType;
	}

	public void setRecordType(List<RecordType> recordType) {
		this.recordType = recordType;
	}

	public Date getDtCreated() {
		return dtCreated;
	}

	public void setDtCreated(Date dtCreated) {
		this.dtCreated = dtCreated;
	}

	public Date getDtUpdated() {
		return dtUpdated;
	}

	public void setDtUpdated(Date dtUpdated) {
		this.dtUpdated = dtUpdated;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", user=" + user + ", recordTitle=" + recordTitle + ", recordDescription="
				+ recordDescription + ", recordType=" + recordType + ", dtCreated=" + dtCreated + ", dtUpdated="
				+ dtUpdated + "]";
	}
}