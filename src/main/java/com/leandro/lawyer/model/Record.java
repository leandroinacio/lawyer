/**package com.leandro.lawyer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Records")
public class Record implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RecordId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "OwnerId", nullable = false)
	private String owner;
	private String recordTitle;
	private String recordDescription;
	private Integer recordType;
	private Date dtCreated;
	private Date dtUpdated;

	public Record() {
		super();
	}

	public Record(Long id, String owner, String recordTitle, String recordDescription, Integer recordType,
			Date dtCreated, Date dtUpdated) {
		super();
		this.id = id;
		this.owner = owner;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public Integer getRecordType() {
		return recordType;
	}

	public void setRecordType(Integer recordType) {
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
		return "Record [id=" + id + ", owner=" + owner + ", recordTitle=" + recordTitle + ", recordDescription="
				+ recordDescription + ", recordType=" + recordType + ", dtCreated=" + dtCreated + ", dtUpdated="
				+ dtUpdated + "]";
	}
}
**/