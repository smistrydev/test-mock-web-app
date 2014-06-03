test-mock-web-app
=================

A simple example of a java servlet web-application. Read wiki for more details.
* Code has a Distance converter
* Exposed the distance via a servlet
* JUnit test - simple for the distance
* JUnit with Mockito - for testing the servlet.
 

Code is deployed for testing:
http://my-simple-app.smistrydev.cloudbees.net/MyServlet?distanceUnit=km&distanceValue=100

where the parameters can be:
distanceUnit:  "km" or "mile"
distanceValue: any value. (not nothing!).

* If the url goes into sleep mode is not used. So, if you hit the url and it response "Activating.." then re-try after 1 minute.

