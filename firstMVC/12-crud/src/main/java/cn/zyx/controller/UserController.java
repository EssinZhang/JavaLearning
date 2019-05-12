package cn.zyx.controller;

import cn.zyx.bean.User;
import cn.zyx.util.DataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * 实现模拟无库的增删改查
 */

@Controller
public class UserController {

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        HashMap<String, User> allUser = DataUtil.findAll();

        ModelAndView mv = new ModelAndView();
        mv.addObject("allUser",allUser);
        mv.setViewName("user_list");

        return mv;
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id )throws Exception{
        ModelAndView mv = new ModelAndView();
        User user = DataUtil.findUserByID(id);
        HashMap<String,User> userHashMap = new HashMap<>();
        userHashMap.put(id,user);

        mv.addObject("id",id);
        mv.addObject("allUser",userHashMap);

        mv.setViewName("user_list");

        return mv;
    }

    /**
     * 添加用户
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/create.do")
    public String create(User user) throws Exception{
        DataUtil.createUser(user);

        return "redirect:findAll.do";
    }

    /**
     * 删除用户
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete.do")
    public String delete(String id)throws Exception{
        DataUtil.delete(id);

        return "redirect:findAll.do";
    }

    /**
     * 更改用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/goUpdate.do")
    public ModelAndView goUpdate(String id)throws Exception{
        User user = DataUtil.findUserByID(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.addObject("id",id);

        mv.setViewName("user_update");
        return mv;
    }

    @RequestMapping("/update.do")
    public String update(String id,User user)throws Exception{
        DataUtil.update(id,user);

        return "redirect:findAll.do";
    }
}
