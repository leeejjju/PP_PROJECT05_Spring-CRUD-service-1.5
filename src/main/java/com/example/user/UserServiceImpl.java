package com.example.user;

import com.example.user.UserDAO;
import com.example.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl{
    @Autowired
    UserDAO userDAO;

    public int insertBoard(UserVO vo) {
        return userDAO.insertUser(vo);
    }
    public int deleteBoard(int seq) {
        return userDAO.deleteUser(seq);
    }
    public int updateBoard(UserVO vo) {
        return userDAO.updateUser(vo);
    }
    public UserVO getBoard(int seq) {
        return userDAO.getUser(seq);
    }
    public List<UserVO> getBoardList() {
        return userDAO.getUserList();
    }

}
