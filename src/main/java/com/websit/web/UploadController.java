package com.websit.web;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.websit.until.UpdateFile;


/**
 *
 * @ClassName: UploadController
 * 
 * @description 图片上传的Controller层
 *
 * @author
 * @createDate 2018年11月27日
 */
@Controller
public class UploadController {
	// 上传图片
	@RequestMapping(value = "/upload"/* ,method=RequestMethod.POST */)
	@ResponseBody
	public Map<String, Object> image(MultipartFile file, HttpServletRequest request) {
		int n;
		// System.out.println(file.getSize());
		Map<String, Object> map = new HashMap<String, Object>();
		String fileType;
		try {
			
			 File f = null;
		        // 输出文件的新name 就是指上传后的文件名称
		        System.out.println("getName:"+file.getName());
		        // 输出源文件名称 就是指上传前的文件名称
		        System.out.println("Oriname:"+file.getOriginalFilename());
		        // 创建文件
		        f = new File(file.getOriginalFilename());
		        try ( InputStream in  = file.getInputStream(); OutputStream os = new FileOutputStream(f)){
		            // 得到文件流。以文件流的方式输出到新文件
		            // 可以使用byte[] ss = multipartFile.getBytes();代替while
		            byte[] buffer = new byte[4096];
		            while ((n = in.read(buffer,0,4096)) != -1){
		                os.write(buffer,0,n);
		            }
		            // 读取文件第一行
		            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
		            System.out.println(bufferedReader.readLine());
		            // 输出路径
		            bufferedReader.close();
		        }catch (IOException e){
		            e.printStackTrace();
		        }
		        // 输出file的URL
		        System.out.println(f.toURI().toURL().toString());
		        // 输出文件的绝对路径
		        System.out.println(f.getAbsolutePath());
		        // 操作完上的文件 需要删除在根目录下生成的文件
		        File files = new File(f.toURI());
		        if (files.delete()){
		            System.out.println("删除成功");
		        }else {
		            System.out.println("删除失败");

		        }

			// String name = file.getOriginalFilename();//上传文件的真实名称
			// String suffixName =
			// name.substring(name.lastIndexOf(".")+1);//获取后缀名
			// 图片的存储位置
			// String path =
			// request.getServletContext().getRealPath("/public/image//"/*+suffixName+"\\"*/);
			// String path
			// ="D:/workspace/SilverCollectingSystem/src/main/webapp/public/image";
			// String path =
			// request.getSession().getServletContext().getRealPath("/public/imge");
			// String path ="D:/img";
			// String image = UploadUtil.uploadFile(file, path);
			String image = UpdateFile.putObject(f,f.getName().substring(f.getName().lastIndexOf(".")) , f.getName());
			
			System.out.println("image"+image);
			map.put("code", 0);
			map.put("message", "上传成功");
			map.put("data",image);
			
		} catch (Exception e) {
			map.put("code", -1);
			e.printStackTrace();
		}
		return map;
	}

}
