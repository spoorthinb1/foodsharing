package com.napier.foodsharing.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * The persistent class for the share_group database table.
 * 
 */
@Entity
@Table(name="share_group")
@NamedQuery(name="ShareGroup.findAll", query="SELECT s FROM ShareGroup s")
public class ShareGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="group_id")
	private String groupId;

	private String group_Description;

	@Column(name="group_name")
	private String groupName;

	//bi-directional many-to-many association to Customer
	@ManyToMany
	@JoinTable(
		name="share_member"
		, joinColumns={
			@JoinColumn(name="group_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="user_id")
			}
		)
	private List<Customer> customers;

	public ShareGroup() {
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroup_Description() {
		return this.group_Description;
	}

	public void setGroup_Description(String group_Description) {
		this.group_Description = group_Description;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}