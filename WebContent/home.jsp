<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="logic.Result" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Timeburning</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div id="page">
    <div id="statusline">
    	<table>
    	<tr>
    	<td class="center"><img src="resouces/human.jpg" alt="Adam" width="120px" height="100px"></td>
    	<td class="center">
			<% if(request.getAttribute("winner") == null){
					out.print("VS"); 
				} else {
					out.print(request.getAttribute("winner")+" wins!");%>
				<br>
					Your last choice: <%=request.getAttribute("yourChoice")%>
				<br>
					Robot last choice:  <%=request.getAttribute("robotChoice")%>
				<% }		
			%>
		</td>
		<td class="center"><img src="resouces/android.jpg" alt="Android" width="100px" height="100px"></td>
		</tr>
		</table>
    </div>
<hr>
    <div id="body">
    <div id="gamefield">
	 	<form action="game">
		
		Make Your choice: <br>
		<div id="form">
		<input type="radio" name ="choice" value="0" checked="checked"> Paper <br>
		<input type="radio" name ="choice" value="1"> Scissors <br>
		<input type="radio" name ="choice" value="2"> Stone
		</div>		
		<br>
		<input type="submit" value="Play!">
	</form>
    </div>
    <div id="results">
	<table>
	    <caption> Statistics </caption>
	    <tr>
	        <th> Robot Choice </th>
	        <th> Human Choice </th>
	        <th> Winner </th>
	    </tr>
	    <% 
	    if(request.getAttribute("statList")!= null){
	    List<Result> result = (ArrayList<Result>) request.getAttribute("statList");
	       for( int i = 0; i<result.size();i++ ){
		    Result current = result.get(i);
	    %>
	    <tr class="<%out.print("stat"+(i%2+1));%>">
	        <td> <%= current.getRobotChoice() %> </td>
	        <td> <%= current.getHumanChoice() %> </td>
	        <td> <%= current.getWinner() %> </td>
	    </tr>
	    	
	    	<%
	    	}
	    }
	    %>
	   </table>
    </div>
    </div>
    <hr>
    <div id = "statistics">
	<p class="center"><%=request.getAttribute("statistics") != null ? request.getAttribute("statistics"): "" %></p>
    </div>
</div>

</body>
</html>