package dao;

import vo.UserVO;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UserDAO {
    //아이디 중복검사
    // 회원가입
    //로그인
    // 회원탈퇴(회원삭제)
    // 아이디 찾기
    // 회원정보 수정
    // 회원정보 조회
    // 추천수
    // 나를 추천한 사람
    // 내가 추천한 사람
    /*
     * 쿼리작성
     * 쿼리객체
     * 쿼리실행
     * 결과객체에 담아준다
     * 행을 접근한다
     * 열에 접근한다
     * */
    public Connection connection; //연결객체
    public PreparedStatement preparedStatement; // 쿼리 객체
    public ResultSet resultSet; // 결과테이블이 있을경우 결과 테이블을 담아줄

    // 입력받은 아이디를 전달받는다.
    public boolean checkId(String userId) {
        String query = "SELECT count(USER_ID) FROM TBL_USER WHERE USER_ID = ?";
        //DB에서 USER_ID로 조회
        boolean check = false;
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);//db는 무조건 1부터 시작한다.
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
    public void join(UserVO userVO) {
        //쿼리를 작성한다.
        String query = "INSERT INTO TBL_USER(USER_NUMBER, USER_NAME, USER_PASSWORD, USER_PHONE_NUMBER, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTHDATE,USER_GENDER, USER_RECOMMENDER, USER_JOB,USER_ID)  "
                + "VALUES(SEQ_USER.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userVO.getUserName());
            preparedStatement.setString(2, userVO.getUserPassword());
            preparedStatement.setString(3, userVO.getUserPhoneNumber());
            preparedStatement.setString(4, userVO.getUserNickname());
            preparedStatement.setString(5, userVO.getUserEmail());
            preparedStatement.setString(6, userVO.getUserAddress());
            preparedStatement.setString(7, userVO.getUserBirthdate());
            preparedStatement.setString(8, userVO.getUserGender());
            preparedStatement.setString(9, userVO.getUserRecommender());
            preparedStatement.setString(10, userVO.getUserJob());
            preparedStatement.setString(11, userVO.getUserId());

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


    //로그인
    // 외부에서 입력한 아이디와 패스워드 전달받음.
    public int login(String userId, String userPassword) {
        String query = "SELECT USER_NUMBER FROM TBL_USER WHERE USER_ID = ? AND USER_PASSWORD =?";
        int userNumber = 0;
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, userPassword);
            resultSet = preparedStatement.executeQuery();
            // DB에서 조회된 행이 있다면
            if (resultSet.next()) {
                //로그인된 회원 번호 가져오기
                userNumber = resultSet.getInt(1);
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
        return userNumber;
    }


    //회원정보 수정
    // 수정완료된 전체 정보를 전달받는다.

    public void update(UserVO userVO) {
        String query = "UPDATE  TBL_USER " +
                "SET USER_NAME = ? , USER_PASSWORD= ? , USER_PHONE_NUMBER = ? , USER_NICKNAME= ? , USER_EMAIL = ? , USER_ADDRESS = ? , USER_BIRTHDATE = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS') ,USER_GENDER = ?  , USER_JOB = ?  "
                // TO_DATE()를 사용하지 않았을 때 format관련 오류 발생시 TO_DATE로 알맞는 형식을 작성해준다.
                // DBMS의 DATE에 문자열 또는 NULL을 넣기 위해서는 TO_DATE()함수를 사용하여 넣어준다.
                + "WHERE USER_NUMBER = ? ";
        String date = null;
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userVO.getUserName());
            preparedStatement.setString(2, userVO.getUserPassword());
            preparedStatement.setString(3, userVO.getUserPhoneNumber());
            preparedStatement.setString(4, userVO.getUserNickname());
            preparedStatement.setString(5, userVO.getUserEmail());
            preparedStatement.setString(6, userVO.getUserAddress());
            date = userVO.getUserBirthdate();
            System.out.println(date);
            if (date != null) {
                System.out.println("들어옴1");
                preparedStatement.setString(7, date);
                System.out.println("들어옴2");
            } else {
                System.out.println("Asdf");
                preparedStatement.setString(7, "1900-01-01");
            }
            preparedStatement.setString(8, userVO.getUserGender());
            preparedStatement.setString(9, userVO.getUserJob());
            preparedStatement.setInt(10, userVO.getUserNumber());

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
                System.out.println("opn");
                throw new RuntimeException(e.getMessage());//하드웨어가 중요하기 때문에 프로그램을 강제 종료를 시켜야함.
            }
        }
    }

    //회원정보 조회
    public UserVO findByUserNumber(int userNumber) {
        String query = "SELECT USER_NUMBER, USER_NAME, USER_PASSWORD, USER_PHONE_NUMBER, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTHDATE,USER_GENDER, USER_RECOMMENDER, USER_JOB,USER_ID FROM TBL_USER  "
                + "WHERE USER_NUMBER = ? ";
        UserVO userVO = null;

        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userNumber);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // 조회된 결과가 있을 때에만 객체화를 진행해준다.
                userVO =new UserVO();
                userVO.setUserNumber(resultSet.getInt(1));
                userVO.setUserName(resultSet.getString(2));
                userVO.setUserPassword(resultSet.getString(3));
                userVO.setUserPhoneNumber(resultSet.getString(4));
                userVO.setUserNickname(resultSet.getString(5));
                userVO.setUserEmail(resultSet.getString(6));
                userVO.setUserAddress(resultSet.getString(7));
                userVO.setUserBirthdate(resultSet.getString(8));
                userVO.setUserGender(resultSet.getString(9));
                userVO.setUserRecommender(resultSet.getString(10));
                userVO.setUserJob(resultSet.getString(11));
                userVO.setUserId(resultSet.getString(12));
            }


        } catch (SQLException e) {
            System.out.println("findby user name sql오류");
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

        return userVO;
    }

    //회원탈퇴
    //회원번호를 전달받는다.
    public void delete(int userNumber) {
        String query = "DELETE FROM TBL_USER WHERE USER_NUMBER = ? ";
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userNumber);
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

    //아이디 찾기 휴대폰 번호로
    // 외부에서 핸드폰 번호를 받아온다.
    public String findIdByUserPhoneNumber(String userPhoneNumber) {
        String query = "SELECT USER_ID FROM TBL_USER WHERE USER_PHONE_NUMBER =? ";
        String userId = null;
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userPhoneNumber);
            resultSet = preparedStatement.executeQuery();
            //유효한 핸드폰 번호라면
            if (resultSet.next()) {
                // 아이디를 가져온다.
                userId = resultSet.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("findByUserPhoneNumber sql오류");
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
        return userId;
    }

    // 비밀번호 변경
    //아이디랑 새로운 비밀번호를 전달받는다.
    public void updateUserPassword(String userId, String userPassword) {
        // 아이디로 조회하여 기존 비밀번호를 새로운 비밀번호로 변경한다.
        String query = "UPDATE TBL_USER SET USER_PASSWORD = ? WHERE USER_ID = ? ";
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userPassword);
            preparedStatement.setString(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("updateUserPassword() SQL오류");
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

    //추천수
    // 로그인된 회원의 아이디를 전달받는다.

    public int geRecommendCount(String userId) {
        // 회원을 추천한 사람들의 수를 센다.
        String query = "SELECT COUNT(USER_RECOMMENDER) FROM TBL_USER " + "  WHERE USER_RECOMMENDER = ? ";
        int recommenderCount = 0;
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            recommenderCount = resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("getRecommenderCount() sql오류");
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

        return recommenderCount;
    }

    // 나를 추천한 사람
    public ArrayList<UserVO> geRecommendedUsers(String userId) {
        String query = "SELECT USER_NUMBER, USER_NAME, USER_PASSWORD, USER_PHONE_NUMBER, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTHDATE,USER_GENDER, USER_RECOMMENDER, USER_JOB,USER_ID  FROM TBL_USER "
                + "WHERE USER_RECOMMENDER = ? ";
        ArrayList<UserVO> users = new ArrayList<UserVO>();

        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            resultSet = preparedStatement.executeQuery();

            // 몇명이 추천했을 지 알 수 없기 때문에 더 이상 결과가 없을때까지 하나씩 행을 가져온다.

            while (resultSet.next()) {
                UserVO userVO = new UserVO();
                userVO.setUserNumber(resultSet.getInt(1));
                userVO.setUserName(resultSet.getString(2));
                userVO.setUserPassword(resultSet.getString(3));
                userVO.setUserPhoneNumber(resultSet.getString(4));
                userVO.setUserNickname(resultSet.getString(5));
                userVO.setUserEmail(resultSet.getString(6));
                userVO.setUserAddress(resultSet.getString(7));
                userVO.setUserBirthdate(resultSet.getString(8));
                userVO.setUserGender(resultSet.getString(9));
                userVO.setUserRecommender(resultSet.getString(10));
                userVO.setUserJob(resultSet.getString(11));
                userVO.setUserId(resultSet.getString(12));
                // 전체 정보가 담긴 MODEL객체를 ArrayList 자료구조에 순서대로 담아준다.
                users.add(userVO);
            }
        } catch (SQLException e) {
            System.out.println("getRecommendedUsers() sql오류");
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

        return users;
    }

    // 내가 추천한 사람
    // 로그인 시 입력한 아이디를 전달받는다.
    public UserVO userIRecommend(String userId) {
        //(2) 추천한 사람의 아이디로 전체 정보를 조회한다.
        String query = "SELECT USER_NUMBER, USER_NAME, USER_PASSWORD, USER_PHONE_NUMBER, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTHDATE,USER_GENDER, USER_RECOMMENDER, USER_JOB,USER_ID  FROM TBL_USER " +
                "  WHERE USER_ID =  " +
                " ( " +
                //(1) 회원의 아이디로 추천한 사람의 아이디를 조회한다. 만약 NULL일 경우 빈 문자열로 처리한다.
                " SELECT NVL(USER_RECOMMENDER,\'\') FROM TBL_USER " +
                " WHERE USER_ID = ? " +
                " ) ";


        UserVO userVO = null;
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userVO =new UserVO();
                userVO.setUserNumber(resultSet.getInt(1));
                userVO.setUserName(resultSet.getString(2));
                userVO.setUserPassword(resultSet.getString(3));
                userVO.setUserPhoneNumber(resultSet.getString(4));
                userVO.setUserNickname(resultSet.getString(5));
                userVO.setUserEmail(resultSet.getString(6));
                userVO.setUserAddress(resultSet.getString(7));
                userVO.setUserBirthdate(resultSet.getString(8));
                userVO.setUserGender(resultSet.getString(9));
                userVO.setUserRecommender(resultSet.getString(10));
                userVO.setUserJob(resultSet.getString(11));
                userVO.setUserId(resultSet.getString(12));
            }
        } catch (SQLException e) {
            System.out.println("getRecommenderCount() sql오류");
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

        return userVO;
    }
}




















