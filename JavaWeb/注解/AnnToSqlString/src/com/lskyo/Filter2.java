package com.lskyo;


@Table("department")
public class Filter2 {

	@Column("id")
	private int id;
	
	@Column("name")
	private String name;
	
	@Column("leader")
	private String leader;
	
	@Column("amount")
	private int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}
