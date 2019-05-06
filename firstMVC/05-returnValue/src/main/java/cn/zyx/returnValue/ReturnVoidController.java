package cn.zyx.returnValue;

import cn.zyx.bean.Student;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 方法无返回参数
 */
@Controller
public class ReturnVoidController {

    /**
     * 通过原生servlet实现跳转
     * @param request
     * @param response
     * @param student
     * @throws Exception
     */
    @RequestMapping("/servletJump.do")
    public void servletJump(HttpServletRequest request, HttpServletResponse response, Student student)throws Exception{

        request.setAttribute("student",student);
        request.getRequestDispatcher("/jsp/welcome.jsp").forward(request,response);
    }

    @RequestMapping("/ajaxJump.do")
    public void ajaxJump(HttpServletRequest request, HttpServletResponse response, Student student)throws Exception{

        PrintWriter writer = response.getWriter();
        String jsonString = JSON.toJSONString(student);
        writer.write(jsonString);
    }
}
