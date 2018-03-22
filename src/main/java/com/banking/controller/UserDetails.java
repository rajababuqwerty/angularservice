package com.banking.controller;

public class UserDetails {
	String fromAccountNumber;
	String toAccountNumber;
	int amount;
	String remarks;

	/**
	 * @return the fromAccountNumber
	 */
	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	/**
	 * @param fromAccountNumber
	 *            the fromAccountNumber to set
	 */
	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	/**
	 * @return the toAccountNumber
	 */
	public String getToAccountNumber() {
		return toAccountNumber;
	}

	/**
	 * @param toAccountNumber
	 *            the toAccountNumber to set
	 */
	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks
	 *            the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
