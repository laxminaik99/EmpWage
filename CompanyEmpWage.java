package com.bridgelabz2;

public class CompanyEmpWage {

	public final String company;
	public final int empRatePerhour;
	public final int numOfWorkingDays;
	public final int maxHoursPerMonth;
	public int totalEmpWage;
	
	public CompanyEmpWage(String company,int empRatePerhour,int numOfWorkingDays,int maxHoursPerMonth) {
		this.company=company;
		this.empRatePerhour=empRatePerhour;
		this.numOfWorkingDays=numOfWorkingDays;
		this.maxHoursPerMonth=maxHoursPerMonth;
	}
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage=totalEmpWage;
	}
	
	
	@Override
	public String toString() {
		return "Total Emp Wage for Company: "+company+ " is: " + totalEmpWage;
	}
	
}
