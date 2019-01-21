package com.naztech.maven_date;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class ConvertTest {


	@Test
	public void testConvertCalendarToLocalDate() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.set(2019,Calendar.JANUARY, 1);
		LocalDate ld = LocalDate.of(2019, 1, 1);
		assertEquals(ld, Convert.convertCalendarToLocalDate(cal));

	}

	@Test
	public void testConvertCalendarToLocalTime() {
		Calendar cal = Calendar.getInstance();
		int lh = LocalTime.now().getHour();
		int lm = LocalTime.now().getMinute();
		assertEquals(lh, Convert.convertCalendarToLocalTime(cal).getHour());
		assertEquals(lm, Convert.convertCalendarToLocalTime(cal).getMinute());
	}

	@Test
	public void testConvertCalendarToLocalDateTime() {
		Calendar cal = Calendar.getInstance();
		LocalDateTime d1 = LocalDateTime.now();
		assertEquals(d1.getYear(), Convert.convertCalendarToLocalDateTime(cal).getYear());
		assertEquals(d1.getMonth(), Convert.convertCalendarToLocalDateTime(cal).getMonth());
		assertEquals(d1.getDayOfMonth(), Convert.convertCalendarToLocalDateTime(cal).getDayOfMonth());
		assertEquals(d1.getHour(), Convert.convertCalendarToLocalDateTime(cal).getHour());
		assertEquals(d1.getMinute(), Convert.convertCalendarToLocalDateTime(cal).getMinute());
	}

	@Test
	public void testConvertCalendarToZonedTime() {
		ZoneId zoneid = ZoneId.of("Asia/Tokyo");
		Calendar cal = Calendar.getInstance();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneid);
		assertEquals(zonedDateTime.getHour(), Convert.convertCalendarToZonedTime(cal, zoneid).getHour());
		assertEquals(zonedDateTime.getMinute(), Convert.convertCalendarToZonedTime(cal, zoneid).getMinute());
	}

	@Test
	public void testConvertDateToOffsetDateTime() {
		Calendar cal = Calendar.getInstance();
		ZoneOffset offset = ZoneOffset.ofHoursMinutes(1, 30);
		OffsetDateTime dateTime = OffsetDateTime.of(LocalDateTime.of(2017, 05, 12, 05, 45),
	            ZoneOffset.ofHoursMinutes(6, 30));
		assertNotEquals(dateTime,Convert.convertDateToOffsetDateTime(cal, offset));
		
	}

	@Test
	public void testUsingCalenderToFetchMonthDay() {
		Calendar cal = Calendar.getInstance();
		cal.set(2019,Calendar.JANUARY,3);
		LocalDate ld = LocalDate.of(2019, 1,3);
		assertEquals(ld.getDayOfMonth(), Convert.usingCalenderToFetchMonthDay(cal));
	}

	@Test
	public void testUsingClaendarToFindPeriod() {
		LocalDate da2 = LocalDate.of(2019, 1, 16);
		LocalDate da1 = LocalDate.of(1895, 1, 16);
		Period p = Period.between(da1, da2);
		assertEquals(p.getYears(), Convert.usingClaendarToFindPeriod(da1, da2).getYears());
	}

	@Test
	public void testConvertDateToLocalDate() throws Exception {
		Calendar cal = Calendar.getInstance();
		String str = "1/17/2019";
		Date d1 =Convert.convertStringToDate(str);
		LocalDate d2 = LocalDate.of(2019, 1, 17);
		
		assertEquals(d1,Convert.convertDateToLocalDate(d2));
	}

}