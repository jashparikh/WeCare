package com.springboot.wecare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity  //annotation for table class this class is a table
@Table(name = "CaregiverSchedule")

public class CaregiverSchedule {
	@Id
	@Column(name = "shiftId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shiftId;
	
	@Column(name = "caregiver_id")
	private long caregiverid;

	@Column(name = "date")
	private LocalDate date; //format it like 0800, 1530

	@Column(name = "startTime")
	private int startTime; //format it like 0800, 1530
	
	@Column(name = "endTime")
	private int endTime;

	public long getshiftId() {
		return shiftId;
	}

	public void setshiftId(int shiftId) {
		this.shiftId = shiftId;
	}

	public long getCaregiverid() {
		return caregiverid;
	}

	public void setCaregiverid(long caregiverid) {
		this.caregiverid = caregiverid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public CaregiverSchedule(long shiftId, long caregiverid, LocalDate date, int startTime, int endTime) {
		super();
		this.shiftId = shiftId;
		this.caregiverid = caregiverid;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}	
}
