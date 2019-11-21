package com.l7.dto;

public class TempletDto {
	private static int currentTempleteNumber;
	private static int TotalNUmberOfTemeplete;

	public  int getCurrentTempleteNumber() {
		return currentTempleteNumber;
	}

	public  void setCurrentTempleteNumber(int currentTempNumber) {
		if (currentTempleteNumber > TotalNUmberOfTemeplete)
			currentTempleteNumber = 1;
		else
			currentTempleteNumber = currentTempNumber;
	}

	public  int getTotalNUmberOfTemeplete() {
		return TotalNUmberOfTemeplete;
	}

	public  void setTotalNUmberOfTemeplete(int totalNUmberOfTemeplete) {
		TotalNUmberOfTemeplete = totalNUmberOfTemeplete;
	}

	public  void updateCurrentTempleteNumber() {
		if (currentTempleteNumber >=TotalNUmberOfTemeplete)
			currentTempleteNumber = 1;
		else
			currentTempleteNumber++;
	}

}
