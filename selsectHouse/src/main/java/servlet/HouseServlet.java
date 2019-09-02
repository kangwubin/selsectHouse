package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.HouseSourceDao;
import dao.HouseSourceDaoImplement;
import entry.HouseSource;
import util.MyUTF;


public class HouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private HouseSourceDao houseSourceDao=new HouseSourceDaoImplement();


	
    public HouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		System.out.println(method);
		switch(method){
			//case "add":		add(request,response) ;break;
			case "HouseQuery":	Housequery(request,response) ;request.getRequestDispatcher("/index.jsp").forward(request,response) ;break;
			case "HouseQuery1":	Housequery(request,response) ;request.getRequestDispatcher("/sale_show_time.jsp").forward(request,response) ;break;
			case "HouseQueryByESTATE_NAME":	HousequeryByname(request,response) ;request.getRequestDispatcher("/index.jsp").forward(request,response) ;break;
			case "aFterHouseQuery": Housequery(request,response) ;request.getRequestDispatcher("/afterView/fangyuanxinxiguanli.jsp").forward(request,response) ;break;
			case "adminHouseQuery": Housequery(request,response) ;request.getRequestDispatcher("/afterView/guanliyuan-fangyuanxinxi.jsp").forward(request,response) ;break;
			case "shouSellTime": Housequery1(request,response) ;request.getRequestDispatcher("/afterView/guanliyuan-xiaoshouxinxiguanli.jsp").forward(request,response) ;break;
			case "shouSellTime1": Housequery1(request,response) ;request.getRequestDispatcher("/afterView/xiaoshouxinxiguanli.jsp").forward(request,response) ;break;
			case "houseAdd":	houseAdd(request,response) ;request.getRequestDispatcher("/afterView/guanliyuan-xiaoshouxinxiguanli.jsp").forward(request,response);break;
			
			
			//case "fadfaHousequery":	Housequery(request,response) ; break;
			
			
			//case "staffLogin":	staffLogin(request,response) ;break;
			//case "staffQuery":	staffQuery(request,response) ;break;
			//case "delete":	delete(request,response) ;break;
		}
	}

	private void Housequery1(HttpServletRequest request, HttpServletResponse response) {
		List<HouseSource> houseSources=houseSourceDao.selectInfoByname();

		//把houseSources放入request集合中
		request.setAttribute("HouseSource", houseSources);
		//转发页面到index.jsp(不能使用重定向)
		//request.getRequestDispatcher("").forward(request, response);
		System.out.println("发送信息成功-------------->"+houseSources.toString()); 
		
	}


	private void houseAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String start = MyUTF.getNewString(request.getParameter("starTime").toString()) ;
		String end = MyUTF.getNewString(request.getParameter("starTime").toString());
		String name = MyUTF.getNewString(request.getParameter("name")) ;
		 
		System.out.println("发布摇号开始时间"+start+"发布摇号结束时间"+end+"  id: "+name);
		boolean istrue =   houseSourceDao.verifyInfo(name, start, end);
		if(istrue) {
			System.out.println("发布成功");
		}else
			
		System.out.println("发布失败");
		
	}


	private void HousequeryByname(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("根据楼盘名称查数据");
		String ESTATE_NAME=MyUTF.getNewString(request.getParameter("subName"));
		List<HouseSource> houseSources=houseSourceDao.selectInfoAll(ESTATE_NAME);
		request.setAttribute("HouseSource", houseSources);
		
		
	}


	private void Housequery(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<HouseSource> houseSources=houseSourceDao.selectInfoAll();

		//把houseSources放入request集合中
		request.setAttribute("HouseSource", houseSources);
		//转发页面到index.jsp(不能使用重定向)
		//request.getRequestDispatcher("").forward(request, response);
		System.out.println("发送信息成功-------------->"+houseSources.toString()); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
