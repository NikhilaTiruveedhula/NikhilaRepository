package com.example.amazonproject.entity;
import javax.persistence.CascadeType;
import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TASKS_TBL")
public class Tasks {
	@Id
	private @NonNull Integer id;
	private String description;
	private String status;
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private Users user;
}