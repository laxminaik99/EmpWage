package com.bridgelabz2;

public class EmpBuilderObject {

	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
	
	private final String company;
	private final int empRatePerhour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
	
	public EmpBuilderObject(String company,int empRatePerhour,int numOfWorkingDays,int maxHoursPerMonth) {
		this.company=company;
		this.empRatePerhour=empRatePerhour;
		this.numOfWorkingDays=numOfWorkingDays;
		this.maxHoursPerMonth=maxHoursPerMonth;
	}
	
	public void computeEmpWage() {
				//variables
				int empHrs=0, totalEmpHrs=0,totalWorkingDays=0;
				
				//Computation
				while (totalEmpHrs <= maxHoursPerMonth && 
						totalWorkingDays < numOfWorkingDays) {
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
				totalEmpWage=totalEmpHrs*empRatePerhour;
				
				
	}
	@Override
	public String toString() {
		return "Total Emp Wage for Company: "+company+ " is: " + totalEmpWage;
	}
	public static void main(String[] args) {
		EmpBuilderObject dMart=new EmpBuilderObject("DMart",20,2,10);
		EmpBuilderObject reliance=new EmpBuilderObject("Reliance",10,4,20);
		dMart.computeEmpWage();
		System.out.println(dMart);
		reliance.computeEmpWage();
		System.out.println(reliance);
	}



}
