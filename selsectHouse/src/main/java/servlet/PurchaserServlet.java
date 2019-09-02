package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PurchaserDao;
import dao.PurchaserDaoImplement;
import entry.Purchaser;
import util.MyUTF;
import util.RandomPwd;

public class PurchaserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PurchaserDao purchaserDao = new PurchaserDaoImplement();
	public String id = "";

	public PurchaserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		System.out.println(method);
		switch (method) {
		// case "add": add(request,response) ;break;
		case "PurchaserQuery":
			PurchaserQuery(request, response);
			request.getRequestDispatcher("/afterView/yonghuxinxiguanli.jsp").forward(request, response);
			break;
		case "afterPurchaserQuery":
			PurchaserQuery(request, response);
			request.getRequestDispatcher("/afterView/yonghuxinxiguanli.jsp").forward(request, response);
			break;
		case "adminPurchaserQuery":
			PurchaserQuery(request, response);
			request.getRequestDispatcher("/afterView/guanliyuan-yonghuxinxiguanli.jsp").forward(request, response);
			break;
		case "purChaseraddInfo":
			purChaseraddInfo(request, response);
			break;
		case "show_index":
			show_indexQuery(request, response);
			request.getRequestDispatcher("show_index.jsp").forward(request, response);
			//request.getRequestDispatcher("show_index.jsp").forward(request, response);
			break;

		// case "staffLogin": staffLogin(request,response) ;break;
		// case "staffQuery": staffQuery(request,response) ;break;
		// case "delete": delete(request,response) ;break;
		}
	}

	private void show_indexQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("进入方法");
		String str;
		try {
			HttpSession session	= request.getSession();
			str = session.getAttribute("userid").toString();
			System.out.println(str);
			Purchaser purchaser =  purchaserDao.selectInfoByid(Integer.parseInt(str));
			request.setAttribute("purchaser", purchaser);
			
		} catch (Exception e) {
			System.out.println("请先登录");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

	private void purChaseraddInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = MyUTF.getNewString(request.getParameter("username"));
		String password = new RandomPwd().makeRandom();
		String tel_num = MyUTF.getNewString(request.getParameter("tel_number"));
		String id_card = MyUTF.getNewString(request.getParameter("card_number"));
		String personStle = MyUTF.getNewString(request.getParameter("type"));
		String need_family = MyUTF.getNewString(request.getParameter("type1"));
		System.out.println("login    __purChaserVerifyInfo");
		System.out.println("姓名：" + username + "密码：" + password + "电话号：" + tel_num + "证件号：" + id_card + "身份类型"
				+ personStle + "购置类型：" + need_family);

		Purchaser purchaser = new Purchaser();
		purchaser.setREALNAME(username);
		purchaser.setCARDTYPE(personStle);
		purchaser.setCARDCODE(id_card);
		purchaser.setMOBILEPHONE(tel_num);
		purchaser.setPURCHASETYPE(need_family);
		purchaser.setPASSWORD(password);
		
        
		 int  istrue=0;
		 istrue=purchaserDao.addInfo( 0, username, personStle, 
			id_card, tel_num, 
			need_family, password, 0, 
			 "未审核", "请求", 0, 
			new Date(System.currentTimeMillis()), null);
		
		 System.out.println(istrue);
		if(istrue>0) {
			request.setAttribute("purchaser", purchaser);
			request.getRequestDispatcher("show_my_info.jsp").forward(request,response) ;
		
		}else {
		 request.getRequestDispatcher("/index2.jsp").forward(request,response);
		 System.out.println("denglushibai ");
		 }

	}

	private void PurchaserDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("PurchaserDelete: ");

	}

	private void PurchaserQuery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Purchaser> purchaser = purchaserDao.selectInfo();
		// 把houseSources放入request集合中
		request.setAttribute("Purchasers", purchaser);
		System.out.println("PurchaserQuery: " + purchaser.toString());

		// 转发页面到index.jsp(不能使用重定向)
		// request.getRequestDispatcher("/index.jsp").forward(request, response);
		// request.getRequestDispatcher("/selsectHouse/afterView/xiaoshouxinxiguanli.jsp").forward(request,response)
		// ;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
