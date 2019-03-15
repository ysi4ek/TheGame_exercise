package control;

import java.io.IOException;
import logic.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class game
 */
public class game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Result lastResult = new Result(Integer.parseInt(request.getParameter("choice")), Robot.getRobot().newChoice());
		request.setAttribute("robotChoice", lastResult.getRobotChoice());
		request.setAttribute("yourChoice", lastResult.getHumanChoice());
		request.setAttribute("winner", lastResult.getWinner());
		
		Stat.getInstance(request.getSession()).addResult(lastResult);
		Stat.getInstance(request.getSession()).countStat();
		
		request.setAttribute("statList", Stat.getInstance(request.getSession()).getList());
		request.setAttribute("statistics", "Human wins: "+Stat.getInstance(request.getSession()).getHumanWins()+"% games<br>Robot Wins: "+Stat.getInstance(request.getSession()).getRobotWins()+"% games");
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
