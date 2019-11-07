package io.yosep.agile.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Period;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 작성일: 2019년 08월 07일
// 작성자: 전요셉
// 내용: 프로젝트 시간관련 기능을 하는 유틸 클래스
public class TimeUtils {
	private static final Logger logger = LoggerFactory.getLogger(TimeUtils.class);
	
	public static Timestamp getStartTime(int year, int month, int day, int hour, int min, int sec) {
		return Timestamp.valueOf(LocalDateTime.of(year, month, day, hour, min,sec));
	}
	
	public static Timestamp getDefaultEndTime(int year, int month, int day, int hour, int min, int sec) {
//		return Timestamp.valueOf(LocalDateTime.of(year, month, day, hour, min,sec).plus(Period.ofWeeks(4)));
		return Timestamp.valueOf(LocalDateTime.of(year, month, day, hour, min,sec));
	}

}
