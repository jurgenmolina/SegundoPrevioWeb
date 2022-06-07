package co.empresa.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.test.dao.BillDao;
import co.empresa.test.dao.BillDaoFactory;
import co.empresa.test.dao.UserDao;
import co.empresa.test.dao.UserDaoFactory;
import co.empresa.test.modelo.Bill;
import co.empresa.test.modelo.User;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UserDao userDao;
	private BillDao billDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
    }
    
    public void init() throws ServletException {
		String type = getServletContext().getInitParameter("type");
		
		this.userDao = UserDaoFactory.getUserDao(type);
		this.billDao = BillDaoFactory.getBillDao(type);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		try {
		switch(action) {
			case "/new":
				showNewForm(request, response);
				break;
				
			case "/newBill":
				showNewFormBill(request, response);
				break;	
			case "/insertBill":
				insertarBill(request, response);
				break;
			case "/delete":
				eliminarBill(request, response);
				break;
			case "/listBill":
				showList(request, response);
				break;
				
			case "/verUsers":
				listaUsuarios(request, response);
				break;
		
				
			case "/crear":
				showUser(request, response);
				break;
			case "/login":
				showLogin(request, response);
				break;
				
			case "/insertarUser":
				insertarUser(request, response);
				break;
				
			case "/logearse":
				logearUser(request, response);
				break;
				
			
			default:
				showLogin(request, response);
				break;
		
		}
		}catch(SQLException e) {
			throw new ServletException(e);
		}
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		User userActual = userDao.select(user_id);
		List<Bill> bills = billDao.selectAll(userActual.getId());
		
		List<Object> list = new ArrayList<>();
		list.add(userActual);
		list.add(bills);
		
		
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("billList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewFormBill(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		
		int user_id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("user_id", user_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bill.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarBill(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		User user = new User();
		user.setId(user_id);
		String date_bill = request.getParameter("date_bill");
		int value = Integer.parseInt(request.getParameter("value"));
		String typex = request.getParameter("type");
		int type = 1;
		if(typex.equals("Ingreso")) {
			type = 0;
		}
		
		String observation = request.getParameter("observation");
		
		Bill bill = new Bill (date_bill, user, value, type, observation);
		
		billDao.insert(bill);
		
		User userActual = userDao.select(user_id);
		List<Bill> bills = billDao.selectAll(userActual.getId());
		
		List<Object> list = new ArrayList<>();
		list.add(userActual);
		list.add(bills);
		
		
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("billList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void eliminarBill(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Bill bill = billDao.select(id);
		
		billDao.delete(id);
		
		User userActual = userDao.select(bill.getUser_id().getId());
		List<Bill> bills = billDao.selectAll(userActual.getId());
		
		List<Object> list = new ArrayList<>();
		list.add(userActual);
		list.add(bills);
		
		
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("billList.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	private void logearUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		List <User> users = userDao.selectAll();
		
		
		for(User e: users) {
			
			if(e.getUsername().equals(user) && e.getPass().equals(password)) {
				
				User userActual = userDao.selectName(user);
				List<Bill> bills = billDao.selectAll(userActual.getId());
				
				List<Object> list = new ArrayList<>();
				list.add(userActual);
				list.add(bills);
				
				
				
				request.setAttribute("list", list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("billList.jsp");
				dispatcher.forward(request, response);
				return;
				
			}
			
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	
	private void listaUsuarios(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List <User> listUsers = userDao.selectAll();
		request.setAttribute("listUsers", listUsers);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("listUser.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("crearUser.jsp");
		dispatcher.forward(request, response);
	}

	
	
	private void insertarUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User usuario = new User(username, password, email);
		
		userDao.insert(usuario);
		
		response.sendRedirect("login");
	}
	
	

	
	
	
}