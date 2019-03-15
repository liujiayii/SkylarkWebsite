package com.websit.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.websit.until.JsonUtil;

/**
 * <p>
 * 评论图片表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */

@Controller
@RequestMapping("/t_comment_pictures")
public class T_comment_picturesController{
    @RequestMapping("/save_photo")
	@ResponseBody

	public void  addDish( MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String path = "D:/update";// 文件路径
        String json = "";
        if (file!=null) {// 判断上传的文件是否为空
 
            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type = fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;
                    // 设置存放图片文件的路径
                    path = realPath+trueFileName;
                    System.out.println("存放图片文件的路径:"+path);
                    System.out.println("项目在容器中实际发布运行的根路径:"+realPath);
                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");                  
                    }
                    json = "{\"res\":1}";
                }else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    //return null;
                    json = "{\"res\":0}";
                }
            }else {
                System.out.println("文件类型为空");
                //return null;
                json = "{\"res\":0}";
                
            }
          //return JsonUtil.getResponseJson(1, msg, null, null);
        }
	
//	              else {
//            System.out.println("没有找到相对应的文件");
//            json = "{\"res\":0}";
//            //return null;
//        }
//       response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().print(json);
      
    
    }




    
   
 
   



