package com.bridgelabz2;

public interface IComputeEmpWage {
 void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth);
 void computeEmpWage();
 int getTotalWage(String company);
}

