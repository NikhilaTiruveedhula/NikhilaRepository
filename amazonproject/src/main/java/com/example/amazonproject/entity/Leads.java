package com.example.amazonproject.entity;
import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import java.time.Instant;
import javax.persistence.ManyToOne;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "LEADS_TBL")
public class Leads {
	@Id
	private @NonNull Integer id;
	private @NonNull String name;
	private @NonNull Long contactNo;
	private @NonNull String emailId;
	private @NonNull String type;
	private @NonNull String location;
	private @NonNull Integer score;
	private @NonNull String leadsource;
	private Instant createdTime;
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private Users user;
}