
package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import com.example.user.UserServiceImpl;
import com.example.user.UserVO;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session, UserVO vo){
        if(session.getAttribute("login") != null){
            session.removeAttribute("login");
        }
        return "login";
    }

    //try login
    @RequestMapping(value = "/loginOK", method = RequestMethod.POST)
    public String loginCheck(HttpSession session, UserVO vo){
        String returnURL="";
        if(session.getAttribute("login") != null){
            session.removeAttribute("login");
        }

        UserVO loginvo = userService.getUser(vo);
        if(loginvo != null){
            System.out.println("login ok!");
            session.setAttribute("login", loginvo);
            returnURL = "redirect:/board/list";
        }else{
            System.out.println("login fail");
            returnURL = "redirect:/login/login";
        }
        return returnURL;
    }


    //logout
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession sessioin){
        sessioin.invalidate();
        return "redirect:/login/login";
    }

//    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
//    public String userlist(Model model){
//        model.addAttribute("list", userService.getUserList());
//        return "posts";
//    }
//
//    @RequestMapping(value = "/board/add", method = RequestMethod.GET)
//    public String addPost(){
//        return "addpostform";
//    }
//
//    @RequestMapping(value = "/board/addok", method = RequestMethod.POST)
//    public String addPostOK(BoardVO vo){
//        int i = userService.insertBoard(vo);
//        if(i == 0){
//            System.out.println("데이터 추가 실패");
//        }else{
//            System.out.println("데이터 추가 성공!!!");
//        }
//        return "redirect:list";
//    }
//
//    @RequestMapping(value = "/board/editpost/{id}", method = RequestMethod.GET)
//    public String editPost(@PathVariable("id") int id, Model model){
//        BoardVO boardVO = userService.getBoard(id);
//        model.addAttribute("boardVO", boardVO);
//        return "editform";
//    }
//
//    @RequestMapping(value = "/board/viewPost/{id}", method = RequestMethod.GET)
//    public String viewPost(@PathVariable("id") int id, Model model){
//        BoardVO boardVO = userService.getBoard(id);
//        model.addAttribute("boardVO", boardVO);
//        return "viewPost";
//    }
//
//    @RequestMapping(value = "/board/editok", method = RequestMethod.POST)
//    public String editPostOK(BoardVO vo){
//        int i = userService.updateBoard(vo);
//        if(i == 0){
//            System.out.println("데이터 수정 실패");
//        }else{
//            System.out.println("데이터 수정 성공!!!");
//        }
//        return "redirect:list";
//    }
//
//    @RequestMapping(value = "/board/delete/{id}", method = RequestMethod.GET)
//    public String deletePostOK(@PathVariable("id") int id){
//        int i = userService.deleteBoard(id);
//        if(i == 0){
//            System.out.println("데이터 삭제 실패");
//        }else{
//            System.out.println("데이터 삭제 성공!!!");
//        }
//        return "redirect:../list";
//    }



}
