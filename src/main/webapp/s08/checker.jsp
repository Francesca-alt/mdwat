<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<!-- java.util -->
<html>
<head>
<meta charset="utf-8">
<title>JSP &amp; request</title>
</head>
<body>
	<h1>Hello!</h1>
	<p id="result">
		The user name
		<%
		@SuppressWarnings("unchecked")
		Set<Character> set = (Set<Character>) request.getAttribute("set");// vai agli attributi della request e metti l attributo che mi ritorna.
		if (set == null || set.isEmpty()) {// questo è un down cast
			out.print("is empty");
		} else {
			out.print("contains these letters:");

			Iterator<Character> it = set.iterator();// iteratore come cursore. next finchè c'è un elemento nel set(un sucessore);
			while (it.hasNext()) {
				out.print(" " + it.next());
			}
		}
	%>
	</p>
</body>
</html>