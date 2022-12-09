package com.example.user;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    @Autowired
    SqlSession sqlSession;

    //C
    public int insertUser(UserVO vo) {
        System.out.println("===> myBatis로 insertUser() 기능 처리");
        return sqlSession.insert("UserDAO.insertUser", vo);
    }

    //D
    public int deleteUser(int seq) {
        System.out.println("===> myBatis로 deleteUser() 기능 처리");
        return sqlSession.insert("UserDAO.deleteUser", seq);
    }

    //U
    public int updateUser(UserVO vo) {
        System.out.println("===> myBatis로 updateUser() 기능 처리");
        return sqlSession.insert("UserDAO.updateUser", vo);
    }

    //R
    public UserVO getUser(UserVO vo) {
        System.out.println("===> jdbcTemplate으로 getUser() 기능 처리");
        return sqlSession.selectOne("UserDAO.getUser", vo);
    }

    //Rrrrr
    public List<UserVO> getUserList(){
        System.out.println("===> myBatis로 getUserList() 기능 처리");
        return sqlSession.selectList("UserDAO.getUserList");
    }

}