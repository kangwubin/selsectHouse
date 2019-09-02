package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entry.HouseSource;
import util.DBConnector;

public class HouseSourceDaoImplement implements HouseSourceDao{

	DBConnector dbConnection = new DBConnector();
	
	
	@Override
	public boolean addInfo(String ESTATE_NAME,
						   String ENTERPRISE_NAME,
						   String PHONE,
						   String BUDING_NO,
						   Date RECEIVE_METERIAL_TIME,
						   Date PURPOSE_REGISTER_START_TIME,
						   Date PURPOSE_REGISTER_END_TIME,
						   int IDENTIFICATION_ID,
						   String RECEIVE_METERIAL_ADDRESS,
						   Date LOTTERY_START_TIME,
						   Date LOTTERY_END_TIME,
						   Date SELECT_HOUSE_START_TIME,
						   Date SELECT_HOUSE_END_TIME) {
		
		int row=0;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = dbConnection.connect();
			// 预编译sql语句
			String sql = "INSERT INTO `houselottery`.`tb_real_estate_info` "
					+ "( ESTATE_NAME,  ENTERPRISE_NAME,  PHONE,  BUDING_NO," + 
					"	 RECEIVE_METERIAL_TIME,  PURPOSE_REGISTER_START_TIME,  PURPOSE_REGISTER_END_TIME," + 
					"	 IDENTIFICATION_ID,  RECEIVE_METERIAL_ADDRESS,  LOTTERY_START_TIME,  LOTTERY_END_TIME," + 
					"	 SELECT_HOUSE_START_TIME,  SELECT_HOUSE_END_TIME) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
			statement = connection.prepareStatement(sql);
			statement.setString(1, ESTATE_NAME);
			statement.setString(2, ENTERPRISE_NAME);
			statement.setString(3, PHONE);
			statement.setString(4, BUDING_NO);
			statement.setDate(5, RECEIVE_METERIAL_TIME);
			statement.setDate(6, PURPOSE_REGISTER_START_TIME);
			statement.setDate(7, PURPOSE_REGISTER_END_TIME);
			statement.setInt(8, IDENTIFICATION_ID);
			statement.setString(9, RECEIVE_METERIAL_ADDRESS);
			statement.setDate(10, LOTTERY_START_TIME);
			statement.setDate(11, LOTTERY_END_TIME);
			statement.setDate(12, SELECT_HOUSE_START_TIME);
			statement.setDate(13, SELECT_HOUSE_END_TIME);
			
			 row = statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(row>0) {
			return true;
		}else
		return false;
	}

	@Override
	public boolean verifyInfo(int ESTATE_ID,
							  String ESTATE_NAME,
							  String ENTERPRISE_NAME,
			  			      String PHONE,
			  			      String BUDING_NO,
			  			      Date RECEIVE_METERIAL_TIME,
			  			      Date PURPOSE_REGISTER_START_TIME,
			  			      Date PURPOSE_REGISTER_END_TIME,
			  			      int IDENTIFICATION_ID,
			  			      String RECEIVE_METERIAL_ADDRESS,
			  			      Date LOTTERY_START_TIME,
			  			      Date LOTTERY_END_TIME,
			  			      Date SELECT_HOUSE_START_TIME,
			  			      Date SELECT_HOUSE_END_TIME) {
		int row=0;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = dbConnection.connect();
			// 预编译sql语句
			String sql = "UPDATE  `houselottery`.`tb_real_estate_info SET" + 
					"  `ESTATE_ID` = '?'," + 
					"  `ESTATE_NAME` = '?'," + 
					"  `ENTERPRISE_NAME` = '?'," + 
					"  `PHONE` = '?'," + 
					"  `BUDING_NO` = '?'," + 
					"  `RECEIVE_METERIAL_TIME` = '?'," + 
					"  `PURPOSE_REGISTER_START_TIME` = '?'," + 
					"  `PURPOSE_REGISTER_END_TIME` = '?'," + 
					"  `IDENTIFICATION_ID` = '?'," + 
					"  `RECEIVE_METERIAL_ADDRESS` = '?'," + 
					"  `LOTTERY_START_TIME` = '?'," + 
					"  `LOTTERY_END_TIME` = '?'," + 
					"  `SELECT_HOUSE_START_TIME` = '?'," + 
					"  `SELECT_HOUSE_END_TIME` = '?'" + 
					"WHERE `ESTATE_ID` = '?';";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, ESTATE_ID);
			statement.setString(2, ENTERPRISE_NAME);
			statement.setString(3, ENTERPRISE_NAME);
			statement.setString(4, PHONE);
			statement.setString(5, BUDING_NO);
			statement.setDate(6, RECEIVE_METERIAL_TIME);
			statement.setDate(7, PURPOSE_REGISTER_START_TIME);
			statement.setDate(8, PURPOSE_REGISTER_END_TIME);
			statement.setInt(9, IDENTIFICATION_ID);
			statement.setString(10, RECEIVE_METERIAL_ADDRESS);
			statement.setDate(11, LOTTERY_START_TIME);
			statement.setDate(12, LOTTERY_END_TIME);
			statement.setDate(13, SELECT_HOUSE_START_TIME);
			statement.setDate(14, SELECT_HOUSE_END_TIME);
			statement.setInt(15, ESTATE_ID);
			 row = statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(row>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteInfo(String BUDING_NO) {
		
		int row=0;
		Connection connection=null;
		PreparedStatement statement=null;
		connection=dbConnection.connect();
		
		try {
			String sql="DELETE FROM  `houselottery`.`tb_real_estate_info` WHERE `BUDING_NO` = '"+BUDING_NO+"';";
			statement=connection.prepareStatement(sql);
			row=statement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(row>0) {
			return true;
		}else	return false;
	}

	
	@Override
	public List<HouseSource> selectInfoAll() {
		List<HouseSource> houseSources=new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		
		connection=dbConnection.connect();
		
		String sql="SELECT * FROM tb_real_estate_info";
		try {
			statement=connection.prepareStatement(sql);
			
			
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
			      HouseSource houseSource=new HouseSource();
			      
			      houseSource.setEATATE_ID(resultSet.getInt(1));
			      houseSource.setEATATE_NAME(resultSet.getString(2));
			      houseSource.setENTERPRISE_NAME(resultSet.getString(3));
			      houseSource.setPHONE(resultSet.getString(4));
			      houseSource.setBUILDING_NO(resultSet.getString(5));
			      houseSource.setRECEIVE_METERIAL_TIME(resultSet.getDate(6));
			      houseSource.setPURPOSE_REGISTER_START_TIME(resultSet.getDate(7));
			      houseSource.setPURPOSE_REGISTER_END_TIME(resultSet.getDate(8));
			      houseSource.setIDENTIFICATION_ID(resultSet.getInt(9));
			      houseSource.setRECEIVE_METERIAL_ADDRESS(resultSet.getString(10));
			      houseSource.setLOTIERY_START_TIME(resultSet.getDate(11));
			      houseSource.setLOTIERY_END_TIME(resultSet.getDate(12));
			      houseSource.setSELECT_HOUSE_START_TIME(resultSet.getDate(13));
			      houseSource.setSELECT_HOUSE_END_TIME(resultSet.getDate(14));
			      houseSources.add(houseSource);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//statement=connection.createStatement();
		//statement.
		
		
		return houseSources;
	}

	

	@Override
	public boolean deleteInfo(int IDENTIFICATION_ID) {
		int row=0;
		Connection connection=null;
		PreparedStatement statement=null;
		connection=dbConnection.connect();
		
		try {
			String sql="DELETE FROM  `houselottery`.`tb_real_estate_info` WHERE `IDENTIFICATION_ID` = '"+IDENTIFICATION_ID+"';";
			statement=connection.prepareStatement(sql);
			row=statement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(row>0) {
			return true;
		}else	return false;
	}
	
	@Override
	public HouseSource selectInfo(String BUDING_NO) {
		Connection connection = null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		
		connection=dbConnection.connect();
		
		String sql="SELECT * FROM tb_real_estate_info where BUDING_NO='"+BUDING_NO+"'";
		HouseSource houseSource=new HouseSource();
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
			      
			      houseSource.setEATATE_ID(resultSet.getInt(1));
			      houseSource.setEATATE_NAME(resultSet.getString(2));
			      houseSource.setENTERPRISE_NAME(resultSet.getString(3));
			      houseSource.setPHONE(resultSet.getString(4));
			      houseSource.setBUILDING_NO(resultSet.getString(5));
			      houseSource.setRECEIVE_METERIAL_TIME(resultSet.getDate(6));
			      houseSource.setPURPOSE_REGISTER_START_TIME(resultSet.getDate(7));
			      houseSource.setPURPOSE_REGISTER_END_TIME(resultSet.getDate(8));
			      houseSource.setIDENTIFICATION_ID(resultSet.getInt(9));
			      houseSource.setRECEIVE_METERIAL_ADDRESS(resultSet.getString(10));
			      houseSource.setLOTIERY_START_TIME(resultSet.getDate(11));
			      houseSource.setLOTIERY_END_TIME(resultSet.getDate(12));
			      houseSource.setSELECT_HOUSE_START_TIME(resultSet.getDate(13));
			      houseSource.setSELECT_HOUSE_END_TIME(resultSet.getDate(14));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//statement=connection.createStatement();
		//statement.
		
		
		return houseSource;

	}

	
	
	@Override
	public HouseSource selectInfo(int IDENTIFICATION_ID) {
		
		Connection connection = null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		
		connection=dbConnection.connect();
		HouseSource houseSource=new HouseSource();
		
		String sql="SELECT * FROM tb_real_estate_info WHERE IDENTIFICATION_ID="+IDENTIFICATION_ID+"";
		try {
			statement=connection.prepareStatement(sql);
			
			
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
			      
			      houseSource.setEATATE_ID(resultSet.getInt(1));
			      houseSource.setEATATE_NAME(resultSet.getString(2));
			      houseSource.setENTERPRISE_NAME(resultSet.getString(3));
			      houseSource.setPHONE(resultSet.getString(4));
			      houseSource.setBUILDING_NO(resultSet.getString(5));
			      houseSource.setRECEIVE_METERIAL_TIME(resultSet.getDate(6));
			      houseSource.setPURPOSE_REGISTER_START_TIME(resultSet.getDate(7));
			      houseSource.setPURPOSE_REGISTER_END_TIME(resultSet.getDate(8));
			      houseSource.setIDENTIFICATION_ID(resultSet.getInt(9));
			      houseSource.setRECEIVE_METERIAL_ADDRESS(resultSet.getString(10));
			      houseSource.setLOTIERY_START_TIME(resultSet.getDate(11));
			      houseSource.setLOTIERY_END_TIME(resultSet.getDate(12));
			      houseSource.setSELECT_HOUSE_START_TIME(resultSet.getDate(13));
			      houseSource.setSELECT_HOUSE_END_TIME(resultSet.getDate(14));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//statement=connection.createStatement();
		//statement.
		
		
		return houseSource;

	}
	
	public static void main(String[] args) {
		HouseSourceDaoImplement house=new HouseSourceDaoImplement();
	System.out.println(new HouseSourceDaoImplement().selectInfoAll().toString());
	
//	boolean istrue=new HouseSourceDaoImplement().addInfo("盛大地产",
//				"小怪兽",
//				 "1268832763",
//				 "a-123",
//				 new Date(System.currentTimeMillis()),
//				 new Date(System.currentTimeMillis()),
//				 new Date(System.currentTimeMillis()),
//			   123,
//			   "陕西西安",
//			   new Date(System.currentTimeMillis()),
//			   new Date(System.currentTimeMillis()),
//			   new Date(System.currentTimeMillis()),
//			   new Date(System.currentTimeMillis()));
//	
//	System.out.println(istrue);
	//boolean istrue=false;
	//根据预（现）售楼栋号删除房源信息
	
	
	System.out.println(house.selectInfo(123).toString());
//	if(istrue) {
//		System.out.println("删除成功");
//	}else
//		System.out.println("你所删除的数据不存在");
//	
	}

	@Override
	public List<HouseSource> selectInfoAll(String ESTATE_NAME) {
		List<HouseSource> houseSources=new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		
		connection=dbConnection.connect();
		
		String sql="SELECT * FROM tb_real_estate_info where ESTATE_NAME='"+ESTATE_NAME+"'";
		try {
			statement=connection.prepareStatement(sql);
			//System.out.println("sql 语句："+sql);
			
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
			      HouseSource houseSource=new HouseSource();
			      
			      houseSource.setEATATE_ID(resultSet.getInt(1));
			      houseSource.setEATATE_NAME(resultSet.getString(2));
			      houseSource.setENTERPRISE_NAME(resultSet.getString(3));
			      houseSource.setPHONE(resultSet.getString(4));
			      houseSource.setBUILDING_NO(resultSet.getString(5));
			      houseSource.setRECEIVE_METERIAL_TIME(resultSet.getDate(6));
			      houseSource.setPURPOSE_REGISTER_START_TIME(resultSet.getDate(7));
			      houseSource.setPURPOSE_REGISTER_END_TIME(resultSet.getDate(8));
			      houseSource.setIDENTIFICATION_ID(resultSet.getInt(9));
			      houseSource.setRECEIVE_METERIAL_ADDRESS(resultSet.getString(10));
			      houseSource.setLOTIERY_START_TIME(resultSet.getDate(11));
			      houseSource.setLOTIERY_END_TIME(resultSet.getDate(12));
			      houseSource.setSELECT_HOUSE_START_TIME(resultSet.getDate(13));
			      houseSource.setSELECT_HOUSE_END_TIME(resultSet.getDate(14));
			      houseSources.add(houseSource);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//statement=connection.createStatement();
		//statement.
		
		
		return houseSources;
	}

	@Override
	public boolean verifyInfo(String ESTATE_ID, String LOTTERY_START_TIME, String LOTTERY_END_TIME) {

		int row=0;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = dbConnection.connect();
			// 预编译sql语句
			String sql = "UPDATE `houselottery`.`tb_real_estate_info` SET `LOTTERY_START_TIME` = ?, `LOTTERY_END_TIME` = ? WHERE ESTATE_NAME = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, LOTTERY_START_TIME);
			statement.setString(2, LOTTERY_END_TIME);
			statement.setString(3, ESTATE_ID);

			 row = statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(row>0) {
			return true;
		}else
		return false;
	}

	@Override
	public List<HouseSource> selectInfoByname() {
		Connection connection = null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		List<HouseSource> houseSources=new ArrayList<>();
		connection=dbConnection.connect();
		HouseSource houseSource=new HouseSource();
		
		String sql="SELECT\r\n" + 
				"\r\n" + 
				"  DISTINCT `ESTATE_NAME`,\r\n" + 
				"  `LOTTERY_START_TIME`,\r\n" + 
				"  `LOTTERY_END_TIME`\r\n" + 
				" \r\n" + 
				"FROM\r\n" + 
				"  `houselottery`.`tb_real_estate_info`";
		try {
			statement=connection.prepareStatement(sql);
			
			
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
			      
			    
			      houseSource.setEATATE_NAME(resultSet.getString(1));
			      
			      houseSource.setLOTIERY_START_TIME(resultSet.getDate(2));
			       houseSource.setLOTIERY_END_TIME(resultSet.getDate(3));
			      houseSources.add(houseSource);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//statement=connection.createStatement();
		//statement.
		
		
		return houseSources;
	}

	
}
