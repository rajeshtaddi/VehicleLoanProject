package dao;
import java.util.List;

import VehicleLoan.*;
public interface LoanDAO {
        public void insertLoanApplication(Loan loan);
        public Loan selectLoanApplication(String userName,String Password);
        public List<Loan> selectLoanApplications();
        public void updateLoanApplication(Loan loan);
        public void deleteLoanApplication(Loan loan);
        
}
