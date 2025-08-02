package in.codesworld.aman.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.codesworld.aman.bean.StudentDto;
import in.codesworld.aman.factory.StudentServiceFactory;
import in.codesworld.aman.service.IStudentService;

/**
 * Servlet implementation class ControllerService
 */
@WebServlet("/controller/*")
public class ControllerService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IStudentService stdService = StudentServiceFactory.getStudentService();

		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("PathInfo    :: " + request.getPathInfo());

		// Requesting for :: addform
		if (request.getRequestURI().endsWith("addform")) {

			// Collecting the inputs
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddr");

			// Creating a dto to transfer to service layer
			StudentDto dto = new StudentDto();
			dto.setSaddress(saddress);
			dto.setSname(sname);
			dto.setSage(Integer.parseInt(sage));

			// requesting service layer to perform operation
			String status = stdService.insertRecord(dto);
			System.out.println(status);

			RequestDispatcher rd = null;

			// Redirecting to suitable pages based on the result
			if (status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../insertResult.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("status", "failure");
				rd = request.getRequestDispatcher("../insertResult.jsp");
				rd.forward(request, response);
			}
		}

		// Requesting for :: searchform
		if (request.getRequestURI().endsWith("searchform")) {
			String sid = request.getParameter("sid");

			StudentDto student = stdService.readRecord(Integer.parseInt(sid));
			request.setAttribute("student", student);

			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../display.jsp");
			rd.forward(request, response);

		}

		// Requesting for :: deleteform
		if (request.getRequestURI().endsWith("deleteform")) {

			String sid = request.getParameter("sid");
			String status = stdService.deleteRecord(Integer.parseInt(sid));

			System.out.println(status);

			RequestDispatcher rd = null;

			// Redirecting to suitable pages based on the result
			if (status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../deleteResult.jsp");
				rd.forward(request, response);
			} else if (status.equals("failure")) {
				request.setAttribute("status", "failure");
				rd = request.getRequestDispatcher("../deleteResult.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("status", "not found");
				rd = request.getRequestDispatcher("../deleteResult.jsp");
				rd.forward(request, response);
			}

		}

		// Requesting for :: editform
		if (request.getRequestURI().endsWith("editform")) {

			String sid = request.getParameter("sid");

			StudentDto student = stdService.readRecord(Integer.parseInt(sid));

			// redirect to a JSP Page
			RequestDispatcher rd = null;
			request.setAttribute("student", student);
			rd = request.getRequestDispatcher("../updateForm.jsp");
			rd.forward(request, response);

		}

		// Request for :: updateRecord
		if (request.getRequestURI().endsWith("updateRecord")) {

			// Collect the inputs from UI Page
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddress");

			// Store the input to DTO
			StudentDto dto = new StudentDto();
			dto.setSid(Integer.parseInt(sid));
			dto.setSname(sname);
			dto.setSaddress(saddress);
			dto.setSage(Integer.parseInt(sage));

			// Calling the service to perform update operation
			String status = stdService.updateRecord(dto);
			System.out.println(status);

			RequestDispatcher rd = null;
			// Redirecting to suitable pages based on the result
			request.setAttribute("status", status);
			rd = request.getRequestDispatcher("../../updateResult.jsp");
			rd.forward(request, response);

		}
	}
}
