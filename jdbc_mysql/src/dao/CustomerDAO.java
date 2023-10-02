package dao;

import vo.CustomerVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO {
    //아이디 중복검사
    //회원가입
    //로그인
    // 아이디찾기
    // 회원정보 전체 수정
    // 회원 1명 전체 정보 조회
    // 회원탈퇴
    // 회원탈퇴 복구
    // 핸드폰 번호로 가입한 전체 회원 정보 조회
    public Connection connection; //연결객체
    public PreparedStatement preparedStatement; // 쿼리 객체
    public ResultSet resultSet; // 결과테이블이 있을경우 결과 테이블을 담아줄

    // 입력받은 아이디를 전달받는다.
    public boolean checkId(String customerId) {
        String query = "select count(customer_id) FROM tbl_customer WHERE customer_id = ?";
        //DB에서 customer_ID로 조회
        boolean check = false;
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerId);//db는 무조건 1부터 시작한다.
            resultSet = preparedStatement.executeQuery(); //쿼리에 결과 테이블이 있으면 executeQuery 셀렉트만

//            preparedStatement.executeUpdate(); 쿼리에 결과 테이블이 없으면 executeUpdate 그외에는
            resultSet.next();// 집계함수니깐 행하나밖에 없고, while문을 사용안해도됨
            // 조회한 개수가 1이면 중복된 아이디
            check = resultSet.getInt(1) == 1;//아이디가 있으면 1, 없으면 0
        } catch (SQLException e) {
            System.out.println("checkId() SQL문 오류");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // 닫다가 오류나면 프로세스 종료!
                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
            }
        }
        return check;
    }


    //회원가입
    // 외부에서 회원가입시 입력한 전체정보를 전달받음.
    public void sign_up(CustomerVO customerVO) {
        //쿼리를 작성한다.
        String query = "INSERT INTO tbl_customer(customer_id,customer_password, customer_name, customer_age, customer_phone_number, customer_status)  "
                + "VALUES(?,?,?,?,?,?)";

        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerVO.getCustomerId());
            preparedStatement.setString(2, customerVO.getCustomerPassword());
            preparedStatement.setString(3, customerVO.getCustomerName());
            preparedStatement.setInt(4, customerVO.getCustomerAge());
            preparedStatement.setString(5, customerVO.getCustomerPhoneNumber());
            preparedStatement.setString(6, String.valueOf(customerVO.getCustomerStatus()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("join() SQL문 오류");
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // 닫다가 오류나면 프로세스 종료!
                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
            }
        }

    }

//    //로그인
//    // 외부에서 입력한 아이디와 패스워드 전달받음.
    public int sign_in(String customerId, String customerPassword) {
        String query = "select customer_number from tbl_customer WHERE customer_id = ? AND customer_password =?";
        int customerNumber = 0;
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerId);
            preparedStatement.setString(2, customerPassword);
            resultSet = preparedStatement.executeQuery();
            // DB에서 조회된 행이 있다면
            if (resultSet.next()) {
                //로그인된 회원 번호 가져오기
                customerNumber = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("로그인 SQL 오류");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // 닫다가 오류나면 프로세스 종료!
                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
            }
        }
        return customerNumber;
    }
//
//
//    //회원정보 수정
//    // 수정완료된 전체 정보를 전달받는다.
//
    public void update(CustomerVO customerVO) {
        String query = "update  tbl_customer " +
                "set customer_id = ? , customer_password = ? , customer_name = ? , customer_age = ? , customer_phone_number = ? , customer_status = ?  "
                + "WHERE customer_number = ? ";
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerVO.getCustomerId());
            preparedStatement.setString(2, customerVO.getCustomerPassword());
            preparedStatement.setString(3, customerVO.getCustomerName());
            preparedStatement.setInt(4, customerVO.getCustomerAge());
            preparedStatement.setString(5, customerVO.getCustomerPhoneNumber());
            preparedStatement.setString(6, String.valueOf (customerVO.getCustomerStatus()));
            preparedStatement.setInt(7, customerVO.getCustomerNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update() SQL문 오류");
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // 닫다가 오류나면 프로세스 종료!
                System.out.println("opn");
                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
            }
        }
    }
//
//    //회원정보 조회
    public CustomerVO findByCustomerNumber(int customerNumber) {
        String query = "select  customer_number,customer_id,customer_password,customer_name,customer_age,customer_phone_number,customer_status from tbl_customer  "
                + "where customer_number = ? ";
        CustomerVO customerVO = null;

        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerNumber);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // 조회된 결과가 있을 때에만 객체화를 진행해준다.
                customerVO =new CustomerVO();
                customerVO.setCustomerNumber(resultSet.getInt(1));
                customerVO.setCustomerId(resultSet.getString(2));
                customerVO.setCustomerPassword(resultSet.getString(3));
                customerVO.setCustomerName(resultSet.getString(4));
                customerVO.setCustomerAge(resultSet.getInt(5));
                customerVO.setCustomerPhoneNumber(resultSet.getString(6));
                customerVO.setCustomerStatus((resultSet.getString(7)).charAt(0)  );
            }


        } catch (SQLException e) {
            System.out.println("findby customer name sql오류");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // 닫다가 오류나면 프로세스 종료!
                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
            }
        }

        return customerVO;
    }
    /// 회원 정보 전체 조회

    public CustomerVO customerSelect(int customerNumber) {
        String query = "update  tbl_customer " +
                "set  customer_status = -1 "
                + "WHERE customer_number = ? ";
        CustomerVO customerVO = null;

        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerNumber);
            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            System.out.println("findby customer name sql오류");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // 닫다가 오류나면 프로세스 종료!
                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
            }
        }

        return customerVO;
    }
//
//    //회원탈퇴
//    //회원번호를 전달받는다.
    public void sign_withdrawal(int customerNumber) {
        String query = "DELETE FROM TBL_customer WHERE customer_NUMBER = ? ";
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerNumber);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("delete sql문 에러");
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // 닫다가 오류나면 프로세스 종료!
                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
            }
        }
    }
//
//    //아이디 찾기 휴대폰 번호로
//    // 외부에서 핸드폰 번호를 받아온다.
    public String findIdByCustomerPhoneNumber(String customerPhoneNumber) {
        String query = "SELECT customer_id from tbl_customer WHERE customer_phone_number =? ";
        String customerId = null;
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerPhoneNumber);
            resultSet = preparedStatement.executeQuery();
            //유효한 핸드폰 번호라면
            if (resultSet.next()) {
                // 아이디를 가져온다.
                customerId = resultSet.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("findBycustomerPhoneNumber sql오류");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // 닫다가 오류나면 프로세스 종료!
                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
            }
        }
        return customerId;
    }
//
//    // 비밀번호 변경
//    //아이디랑 새로운 비밀번호를 전달받는다.
//    public void updatecustomerPassword(String customerId, String customerPassword) {
//        // 아이디로 조회하여 기존 비밀번호를 새로운 비밀번호로 변경한다.
//        String query = "UPDATE TBL_customer SET customer_PASSWORD = ? WHERE customer_ID = ? ";
//        try {
//            connection = DBConnector.getConnection();
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, customerPassword);
//            preparedStatement.setString(2, customerId);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("updatecustomerPassword() SQL오류");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                // 닫다가 오류나면 프로세스 종료!
//                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
//            }
//        }
//
//    }
//
//    //추천수
//    // 로그인된 회원의 아이디를 전달받는다.
//
//    public int geRecommendCount(String customerId) {
//        // 회원을 추천한 사람들의 수를 센다.
//        String query = "SELECT COUNT(customer_RECOMMENDER) FROM TBL_customer " + "  WHERE customer_RECOMMENDER = ? ";
//        int recommenderCount = 0;
//        try {
//            connection = DBConnector.getConnection();
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, customerId);
//            resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//            recommenderCount = resultSet.getInt(1);
//        } catch (SQLException e) {
//            System.out.println("getRecommenderCount() sql오류");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                // 닫다가 오류나면 프로세스 종료!
//                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
//            }
//        }
//
//        return recommenderCount;
//    }
//
//    // 나를 추천한 사람
//    public ArrayList<CustomerVO>  geRecommendedcustomers(String customerId) {
//        String query = "SELECT customer_NUMBER, customer_NAME, customer_PASSWORD, customer_PHONE_NUMBER, customer_NICKNAME, customer_EMAIL, customer_ADDRESS, customer_BIRTHDATE,customer_GENDER, customer_RECOMMENDER, customer_JOB,customer_ID  FROM TBL_customer "
//                + "WHERE customer_RECOMMENDER = ? ";
//        ArrayList<CustomerVO>  customers = new ArrayList<CustomerVO> ();
//
//        try {
//            connection = DBConnector.getConnection();
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, customerId);
//            resultSet = preparedStatement.executeQuery();
//
//            // 몇명이 추천했을 지 알 수 없기 때문에 더 이상 결과가 없을때까지 하나씩 행을 가져온다.
//
//            while (resultSet.next()) {
//                CustomerVO customerVO = new customerVO();
//                customerVO.setcustomerNumber(resultSet.getInt(1));
//                customerVO.setcustomerName(resultSet.getString(2));
//                customerVO.setcustomerPassword(resultSet.getString(3));
//                customerVO.setcustomerPhoneNumber(resultSet.getString(4));
//                customerVO.setcustomerNickname(resultSet.getString(5));
//                customerVO.setcustomerEmail(resultSet.getString(6));
//                customerVO.setcustomerAddress(resultSet.getString(7));
//                customerVO.setcustomerBirthdate(resultSet.getString(8));
//                customerVO.setcustomerGender(resultSet.getString(9));
//                customerVO.setcustomerRecommender(resultSet.getString(10));
//                customerVO.setcustomerJob(resultSet.getString(11));
//                customerVO.setcustomerId(resultSet.getString(12));
//                // 전체 정보가 담긴 MODEL객체를 ArrayList 자료구조에 순서대로 담아준다.
//                customers.add(customerVO);
//            }
//        } catch (SQLException e) {
//            System.out.println("getRecommendedcustomers() sql오류");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                // 닫다가 오류나면 프로세스 종료!
//                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
//            }
//        }
//
//        return customers;
//    }
//
//    // 내가 추천한 사람
//    // 로그인 시 입력한 아이디를 전달받는다.
//    public CustomerVO customerIRecommend(String customerId) {
//        //(2) 추천한 사람의 아이디로 전체 정보를 조회한다.
//        String query = "SELECT customer_NUMBER, customer_NAME, customer_PASSWORD, customer_PHONE_NUMBER, customer_NICKNAME, customer_EMAIL, customer_ADDRESS, customer_BIRTHDATE,customer_GENDER, customer_RECOMMENDER, customer_JOB,customer_ID  FROM TBL_customer " +
//                "  WHERE customer_ID =  " +
//                " ( " +
//                //(1) 회원의 아이디로 추천한 사람의 아이디를 조회한다. 만약 NULL일 경우 빈 문자열로 처리한다.
//                " SELECT NVL(customer_RECOMMENDER,\'\') FROM TBL_customer " +
//                " WHERE customer_ID = ? " +
//                " ) ";
//
//
//        CustomerVO customerVO = null;
//        try {
//            connection = DBConnector.getConnection();
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, customerId);
//            resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                customerVO =new customerVO();
//                customerVO.setcustomerNumber(resultSet.getInt(1));
//                customerVO.setcustomerName(resultSet.getString(2));
//                customerVO.setcustomerPassword(resultSet.getString(3));
//                customerVO.setcustomerPhoneNumber(resultSet.getString(4));
//                customerVO.setcustomerNickname(resultSet.getString(5));
//                customerVO.setcustomerEmail(resultSet.getString(6));
//                customerVO.setcustomerAddress(resultSet.getString(7));
//                customerVO.setcustomerBirthdate(resultSet.getString(8));
//                customerVO.setcustomerGender(resultSet.getString(9));
//                customerVO.setcustomerRecommender(resultSet.getString(10));
//                customerVO.setcustomerJob(resultSet.getString(11));
//                customerVO.setcustomerId(resultSet.getString(12));
//            }
//        } catch (SQLException e) {
//            System.out.println("getRecommenderCount() sql오류");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                // 닫다가 오류나면 프로세스 종료!
//                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
//            }
//        }

//        return customerVO;
//    }
}
