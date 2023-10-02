package vo;

//	USER_NUMBER number,
//            USER_NAME VARCHAR2(1000),
//            USER_PASSWORD VARCHAR2(1000),
//            USER_PHONE_NUMBER VARCHAR2(1000),
//            USER_NICKNAME VARCHAR2(1000),
//            USER_EMAIL VARCHAR2(1000),
//            USER_ADDRESS VARCHAR2(1000),
//            USER_BIRTHDATE DATE,
//            USER_GENDER CHAR(1) DEFAULT 'W' NOT NULL CONSTRAINT BAN_GENDER CHECK(USER_GENDER ='M' OR USER_GENDER ='W'),
//            USER_RECOMMENDER VARCHAR2(1000),
//            USER_JOB VARCHAR2(1000)

public class UserVO {
    private int userNumber;
    private String userName;
    private String userPassword;
    private String userPhoneNumber;
    private String userNickname;
    private String userEmail;
    private String userAddress;
    private String userBirthdate;
    private String userGender;
    private String userRecommender;
    private String userJob;
    private String userId;
    public UserVO(){;}

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserBirthdate() {
        return userBirthdate;
    }

    public void setUserBirthdate(String userBirthdate) {
        this.userBirthdate = userBirthdate;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserRecommender() {
        return userRecommender;
    }

    public void setUserRecommender(String userRecommender) {
        this.userRecommender = userRecommender;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userNumber=" + userNumber +
                ", userName='" + userName + ',' +
                ", userPassword='" + userPassword + ',' +
                ", userPhoneNumber='" + userPhoneNumber + ',' +
                ", userNickname='" + userNickname + ',' +
                ", userEmail='" + userEmail + ',' +
                ", userAddress='" + userAddress + ',' +
                ", userBirthdate='" + userBirthdate + ',' +
                ", userGender='" + userGender + ',' +
                ", userRecommender='" + userRecommender + ',' +
                ", userJob='" + userJob + ',' +
                ", userId='" + userId + ',' +
                '}';
    }
}
