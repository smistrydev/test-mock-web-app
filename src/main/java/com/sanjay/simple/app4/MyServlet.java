package com.sanjay.simple.app4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanjay.simple.app4.distance.Distance;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MyServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String distanceUnit = request.getParameter("distanceUnit");
		String strDistanceValue = request.getParameter("distanceValue");

		if (distanceUnit == null || distanceUnit.isEmpty()) {
			out.print("Unit not specified!");
			return;
		}

		if (distanceUnit.equals("km")) {
			double miles = Distance.convertKilometerToMile(strDistanceValue);
			out.print("Result: " + strDistanceValue + "km = " + miles + "miles");
			return;
		}

		if (distanceUnit.equals("mile")) {
			double kms = Distance.convertMileToKilometer(strDistanceValue);
			out.print("Result: " + strDistanceValue + "miles = " + kms + "km");
			return;
		}

		out.print("Unit of unknown type!");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
