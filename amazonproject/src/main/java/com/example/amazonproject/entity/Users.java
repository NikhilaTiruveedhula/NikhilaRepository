package com.example.amazonproject.entity;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "USERS_TBL")
public class Users {
	@Id
	private @NonNull Integer id;
	private @NonNull String name;
	private @NonNull Long contactNo;
	private @NonNull String emailId;
	private @NonNull Integer rank;
	private @NonNull String location;
	private @NonNull Integer countOfLeads;
	@OneToMany(mappedBy="user")
	private List<Leads> leads;
	@OneToMany(mappedBy="user")
	private List<Tasks> tasks;
}