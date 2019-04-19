package com.websit.entityvo;

import java.math.BigDecimal;

public class jiaobiao {
	private int dfk;//待付款
	private int dsh;//待收货
	private int daf;//代发货
	private int ysh;//待收货
	private int quantum;//待收货
	private int sales ;//退货
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getQuantum() {
		return quantum;
	}
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
	public int getDfk() {
		return dfk;
	}
	public void setDfk(int dfk) {
		this.dfk = dfk;
	}
	public int getDsh() {
		return dsh;
	}
	public void setDsh(int dsh) {
		this.dsh = dsh;
	}
	public int getDaf() {
		return daf;
	}
	public void setDaf(int daf) {
		this.daf = daf;
	}
	public int getYsh() {
		return ysh;
	}
	public void setYsh(int ysh) {
		this.ysh = ysh;
	}
	@Override
	public String toString() {
		return "jiaobiao [dfk=" + dfk + ", dsh=" + dsh + ", daf=" + daf + ", ysh=" + ysh + ", quantum=" + quantum
				+ ", sales=" + sales + "]";
	}
	
}
