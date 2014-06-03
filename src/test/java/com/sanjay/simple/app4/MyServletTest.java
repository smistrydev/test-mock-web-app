package com.sanjay.simple.app4;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MyServletTest {

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Test
	public void testDoGetReqResponseKmGood() throws IOException, ServletException {

		when(request.getParameter("distanceUnit")).thenReturn("km");
		when(request.getParameter("distanceValue")).thenReturn("123.45");

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(printWriter);

		MyServlet myServlet = new MyServlet();

		myServlet.doGet(request, response);

		String result = stringWriter.getBuffer().toString().trim();

		String expected = "Result: 123.45km = 76.70827368169887miles";

		assertEquals(expected, result);
	}

	@Test
	public void testDoGetReqResponseMileGood() throws IOException, ServletException {

		when(request.getParameter("distanceUnit")).thenReturn("mile");
		when(request.getParameter("distanceValue")).thenReturn("123.45");

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(printWriter);

		MyServlet myServlet = new MyServlet();

		myServlet.doGet(request, response);

		String result = stringWriter.getBuffer().toString().trim();

		String expected = "Result: 123.45miles = 198.67351680000002km";

		assertEquals(expected, result);
	}

	@Test
	public void testDoGetReqResponseUnitBad() throws IOException, ServletException {

		when(request.getParameter("distanceUnit")).thenReturn("miles");
		when(request.getParameter("distanceValue")).thenReturn("123.45");

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(printWriter);

		MyServlet myServlet = new MyServlet();

		myServlet.doGet(request, response);

		String result = stringWriter.getBuffer().toString().trim();

		String expected = "Unit of unknown type!";

		assertEquals(expected, result);
	}

	@Test
	public void testDoGetReqResponseValueBad() throws IOException {

		when(request.getParameter("distanceUnit")).thenReturn("mile");
		when(request.getParameter("distanceValue")).thenReturn("");

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(printWriter);

		MyServlet myServlet = new MyServlet();

		try {
			myServlet.doGet(request, response);
		} catch (Exception e) {
			String expected = "empty String";
			assertEquals(expected, e.getMessage());
		}

	}

}
