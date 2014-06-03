package com.sanjay.simple.app4.distance;

import static org.junit.Assert.*;

import org.junit.Test;

public class DistanceTest {

	@Test
	public void testConvertKilometerToMileString() {
		String str_kms = "100.0";
		double miles = Distance.convertKilometerToMile(str_kms);
		double expected = 160.934;
		assertEquals("Failed", expected, miles, 0.001);
	}

	@Test
	public void testConvertMileToKilometerString() {
		String str_miles = "100.0";
		double kms = Distance.convertMileToKilometer(str_miles);
		double expected = 62.137;
		assertEquals("Failed", expected, kms, 0.001);
	}

	@Test
	public void testConvertKilometerToMileDouble() {
		double kms = 123.456;
		double miles = Distance.convertKilometerToMile(kms);
		double expected = 198.683;
		assertEquals("Failed", expected, miles, 0.001);
	}

	@Test
	public void testConvertMileToKilometerDouble() {
		double miles = 98.765;
		double kms = Distance.convertMileToKilometer(miles);
		double expected = 61.369;
		assertEquals("Failed", expected, kms, 0.001);
	}

}
