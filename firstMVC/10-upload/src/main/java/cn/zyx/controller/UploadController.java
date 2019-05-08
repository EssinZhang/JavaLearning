package cn.zyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * 文件上传
 */
@Controller
public class UploadController {

    /**
     * 处理单个文件上传
     * @param picture
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload01.do")
    public ModelAndView upload01(MultipartFile picture, HttpSession session)throws Exception{
        ModelAndView mv = new ModelAndView();

        //判断是否上传文件
        if (!picture.isEmpty()){
            //获取文件上传路径
            String path = session.getServletContext().getRealPath("/upload");
            //获取文件上传的名称
            String fileName = picture.getOriginalFilename();
            System.out.println(fileName);
            System.out.println(picture.getContentType());
            //限制文件上传类型
            if ("image/jpeg".equals(picture.getContentType())){
                File file = new File(path, fileName);
                picture.transferTo(file);
            }else {
                mv.addObject("msg","请选择jpg格式的图片上传");
                mv.setViewName("uploadFail");

                return mv;
            }
        }else {
            mv.addObject("msg","请上传一张jps格式的图片");
            mv.setViewName("uploadFail");

            return mv;
        }
        mv.setViewName("uploadSuccess");

        return mv;
    }

    /**
     * 处理多个文件上传
     * @param picture
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload02.do")
    public ModelAndView upload02(@RequestParam MultipartFile[] picture, HttpSession session)throws Exception{
        ModelAndView mv = new ModelAndView();

        //获取文件上传路径
        String path = session.getServletContext().getRealPath("/upload");
        for (MultipartFile mpf : picture){
            //判断是否上传文件
            if (!mpf.isEmpty()){
                //获取文件上传的名称
                String fileName = mpf.getOriginalFilename();
                //System.out.println(fileName);
                //System.out.println(mpf.getContentType());
                //限制文件上传类型
                if ("image/jpeg".equals(mpf.getContentType())){
                    File file = new File(path, fileName);
                    mpf.transferTo(file);
                }else {
                    mv.addObject("msg","请选择jpg格式的图片上传");
                    mv.setViewName("uploadFail");

                    return mv;
                }
            }else {
                mv.addObject("msg","请上传一张jps格式的图片");
                mv.setViewName("uploadFail");

                return mv;
            }
        }

        mv.setViewName("uploadSuccess");

        return mv;
    }
}
