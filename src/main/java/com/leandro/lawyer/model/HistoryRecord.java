package com.leandro.lawyer.model;

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

/**
 * @author Leandro Inácio
 */
@Entity
@Table(name="HistoryRecord")
public class HistoryRecord implements Serializable{

	private static final long serialVersionUID = 1L;
			
	@Id 
	@Column(name = "RecordId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long recordId;	
	 
	@ManyToOne(optional=false)
	@JoinColumn(name="OwnerId",referencedColumnName="OwnerId")
    private Owner owner;
	
	@Column(name = "RecordTitle")
	private String recordTitle;
	
	@Column(name = "RecordDescription")
	private String eecordDescription;
	
	@Column(name = "DtCreated")
	private Date dtCreated;
	
	@Column(name = "DtUpdated")
	private Date dtUpdated;
	
	
}

