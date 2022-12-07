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

    public int insertUser(UserVO vo) {
        return userDAO.insertUser(vo);
    }
    public int deleteUser(int seq) {
        return userDAO.deleteUser(seq);
    }
    public int updateUser(UserVO vo) {
        return userDAO.updateUser(vo);
    }
    public UserVO getUser(UserVO vo) {
        return userDAO.getUser(vo);
    }
    public List<UserVO> getUserList() {
        return userDAO.getUserList();
    }

}
