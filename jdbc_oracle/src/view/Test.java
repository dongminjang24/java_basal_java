package view;

import dao.DBConnector;
import dao.UserDAO;
import vo.UserVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class Test {
    public static void main(String[] args) {
        Connection connection = DBConnector.getConnection();
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        UserDAO userDAO = new UserDAO();
//       중복검사
//        if (userDAO.checkId("hds1234")) {
//            System.out.println("중복된 아이디");
//        } else {
//            System.out.println("사용 가능한 아이디");
//        }

        //회원가입
//        UserVO userVO = new UserVO();
//        userVO.setUserId("yesoryes");
//        userVO.setUserPassword("0113");
//        userVO.setUserRecommender("hds");
//        userVO.setUserName("김예슬");
//        userVO.setUserGender("W");
//        userVO.setUserPhoneNumber("01079211388");
////
//        userDAO.join(userVO);
        //로그인
//        System.out.println(userDAO.login("hgd","3333"));

        //로그인하고 번호 확인하고, 조회된 결과를 수정해야
//        UserVO userVO = userDAO.findByUserNumber(userDAO.login("hds","1234"));
//        System.out.println(userDAO.login("hds","1234"));
//        System.out.println(userVO);
//        userVO.setUserJob("개발자");
//        userDAO.update(userVO);
//
//        System.out.println("난 바보");



        //아이디 찾기
//        System.out.println(userDAO.findIdByUserPhoneNumber("01057862039"));

        //비밀번호 수정
//        userDAO.updateUserPassword("hds","99999");
//        System.out.println(userDAO.login("hds","99999"));

        //회원탈퇴
//        System.out.println(userDAO.login("jdm3710","9427"));
//        userDAO.delete(userDAO.login("jdm3710","9427"));

        //추천수
//        System.out.println(userDAO.geRecommendCount("hds"));
        //나를 추천한 사람
//        userDAO.geRecommendedUsers("hds").forEach(System.out::println);

        //내가 추천한 사람
//        System.out.println( userDAO.userIRecommend("hds"));

    }


}














