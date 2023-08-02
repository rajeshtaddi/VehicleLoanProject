package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VehicleLoan.Loan;

public class LoanDAOImplementation implements LoanDAO{
	Connection conn;
	public LoanDAOImplementation() {
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			conn = 	DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb", "SA", "");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertLoanApplication(Loan loan) {
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO LOAN VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, loan.getName());
			pst.setString(2,loan.getUserId());
			pst.setString(3,loan.getPassWord());
			pst.setInt(4, loan.getAge());
			pst.setDouble(5,loan.getSalary());
			pst.setInt(6,loan.getCreditScore());
			pst.setString(7, loan.getVehicleModel());
			pst.setDouble(8,loan.getPrice());
			pst.setDouble(9,loan.getTentureOfLoan());
			pst.setDouble(10, loan.getInterestRate());
			pst.setDouble(11,loan.getDownPayment());
			
			int rows = pst.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Loan selectLoanApplication(String userName, String Password) {
		Statement statement = conn.createStatement();
		
		
		
		ResultSet result = statement.executeQuery("SELECT * FROM LOAN WHERE USERID="+userName);
		
		Loan loanObj = new Loan();
		if(result.next()) {
			
			loanObj.setName(result.getString(1));
			loanObj.setUserId(result.getString(2));
			loanObj.setPassWord(result.getString(3));
		}// TODO Auto-generated method stub
		return loanObj;
	}

	@Override
	public List<Loan> selectLoanApplications() {
		List<Loan> loanList = new ArrayList<Loan>();
		try {
			
			 
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery("SELECT * FROM LOAN");
			
			//5. process teh result if any
			while(result.next()) {
				Loan loanObj = new Loan(); //blank object
				
				loanObj.setName(result.getString(1));
				loanObj.setUserId(result.getString(2));
				loanObj.setDepartmentName(result.getString(3));
				loanList.add(loanObj); // add this object to the LIST 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loanList;
	}

	@Override
	public void updateLoanApplication(Loan loan) {
		// TODO Auto-generated method stub
		

	@Override
	public void deleteLoanApplication(Loan loan) {
		// TODO Auto-generated method stub
		
	}
	

}
