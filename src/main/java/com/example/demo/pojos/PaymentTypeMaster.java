package com.example.demo.pojos;
// Generated 20 Sep, 2022 5:56:57 PM by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PaymentTypeMaster generated by hbm2java
 */
@Entity
@Table(name = "payment_type_master", catalog = "computersikho")
public class PaymentTypeMaster implements java.io.Serializable {

	private int paymentTypeid;
	private String paymentTypeDesc;
	private Set<Payment> payments = new HashSet(0);

	public PaymentTypeMaster() {
	}

	public PaymentTypeMaster(int paymentTypeid, String paymentTypeDesc) {
		this.paymentTypeid = paymentTypeid;
		this.paymentTypeDesc = paymentTypeDesc;
	}

	public PaymentTypeMaster(int paymentTypeid, String paymentTypeDesc, Set<Payment> payments) {
		this.paymentTypeid = paymentTypeid;
		this.paymentTypeDesc = paymentTypeDesc;
		this.payments = payments;
	}

	@Id

	@Column(name = "payment_typeid", unique = true, nullable = false)
	public int getPaymentTypeid() {
		return this.paymentTypeid;
	}

	public void setPaymentTypeid(int paymentTypeid) {
		this.paymentTypeid = paymentTypeid;
	}

	@Column(name = "payment_type_desc", nullable = false, length = 100)
	public String getPaymentTypeDesc() {
		return this.paymentTypeDesc;
	}

	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paymentTypeMaster")
	public Set<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

}
