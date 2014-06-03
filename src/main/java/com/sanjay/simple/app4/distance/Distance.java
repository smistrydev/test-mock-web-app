/**
 * 
 */
package com.sanjay.simple.app4.distance;

/**
 * @author i300716
 * 
 */
public class Distance {

	private static double RATIO_M2K = 1.609344;

	public static double convertKilometerToMile(String str_km) {
		double km = Double.parseDouble(str_km);
		return convertKilometerToMile(km);
	}

	public static double convertMileToKilometer(String str_mile) {
		double mile = Double.parseDouble(str_mile);
		return convertMileToKilometer(mile);
	}

	public static double convertKilometerToMile(double km) {
		return km / RATIO_M2K;
	}

	public static double convertMileToKilometer(double mile) {
		return mile * RATIO_M2K;
	}

}
