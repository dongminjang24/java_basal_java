import dao.CustomerDAO;
import dao.DBConnector;
import vo.CustomerVO;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAO();

        //       중복검사
//        if (customerDAO.checkId("hds")) {
//            System.out.println("중복된 아이디");
//        } else {
//            System.out.println("사용 가능한 아이디");
//        }

        //회원가입
//        CustomerVO customerVO = new CustomerVO();
//        customerVO.setCustomerId("yesoryes");
//        customerVO.setCustomerPassword("0113");
//        customerVO.setCustomerName("김예슬");
//        customerVO.setCustomerAge(20);
//        customerVO.setCustomerPhoneNumber("01079211388");
//        customerVO.setCustomerStatus('0');
////
//        customerDAO.sign_up(customerVO);
        // 로그인
//        CustomerVO customerVO=customerDAO.findByCustomerNumber(customerDAO.sign_in("yesoryes","0113"));
//        customerVO.setCustomerAge(29);
//        customerVO.setCustomerPassword("0224");
//        customerDAO.update(customerVO);
//        System.out.println(customerDAO.customerSelect(customerDAO.sign_in("yesoryes","0224")))
         customerDAO.customerSelect( customerDAO.sign_in("yesoryes","0224"));
                //        customerDAO.update(customerDAO.sign_in("yesoryes","0113"));
    }
}
