package com.l7.pegasus.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateConversion {
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}

}
