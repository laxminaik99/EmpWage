package com.bridgelabz2;

import java.util.*;


public  class EmpWageBuilder implements IComputeEmpWage{

	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
	
	private int numOfCompany=0;
	private LinkedList<CompanyEmpWage> companyEmpWageList;
	private Map<String,CompanyEmpWage> companyToEmpWageMap;
	
	public  EmpWageBuilder() {
		companyEmpWageList=new LinkedList<>();
		companyToEmpWageMap=new HashMap<>();
	}
	
	public void addCompanyEmpWage(String company,int empRatePerhour,int numOfWorkingDays,int maxHoursPerMonth) {
		CompanyEmpWage companyEmpWage =new CompanyEmpWage(company,empRatePerhour,numOfWorkingDays,maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company,companyEmpWage);
	}

	public void computeEmpWage() {
	for(int i=0;i<companyEmpWageList.size();i++) {
		CompanyEmpWage companyEmpWage=companyEmpWageList.get(i);
		companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
		System.out.println(companyEmpWage);
	}
	
}
	@Override
	public int getTotalWage(String company) {
		return companyToEmpWageMap.get(company).totalEmpWage;
	}
	
	public int computeEmpWage(CompanyEmpWage companyEmpWage) {
		//variables
		int empHrs=0, totalEmpHrs=0,totalWorkingDays=0;
		
		//Computation
		while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && 
				totalWorkingDays <  companyEmpWage.numOfWorkingDays) {
			totalWorkingDays++;
		int empCheck=(int)Math.floor(Math.random()*10) % 3;
		
		switch (empCheck)  {
		case IS_PART_TIME:
			empHrs=4;
			break;
		case IS_FULL_TIME:
			empHrs=8;
			break;
		default:
			 empHrs=0;
		}
					
		totalEmpHrs+=empHrs;
		System.out.println("Days#: "+totalWorkingDays+" Emp Hr: "+empHrs);
		}
		return totalEmpHrs* companyEmpWage.empRatePerhour;
		
		
}
	
	

public static void main(String[] args) {
	IComputeEmpWage empWageBuilder=new EmpWageBuilder();
	empWageBuilder.addCompanyEmpWage("DMart",20,2,10);
	empWageBuilder.addCompanyEmpWage("Reliance",10,4,20);
	empWageBuilder.computeEmpWage();
	System.out.println("Total Wage for zdMart Company: "+empWageBuilder.getTotalWage("DMart"));
}
}