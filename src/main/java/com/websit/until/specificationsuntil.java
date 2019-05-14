package com.websit.until;

import java.util.Map;

import com.alibaba.fastjson.JSON;
/**
 * 判断json字段是否相同
 * @author 陈志浩
 *
 */
public class specificationsuntil {
	public static boolean specification(String specification, String  spec) {
		boolean fig = false;
		Map maps = (Map) JSON.parse(specification);
		Map mapt = (Map) JSON.parse(spec);
		if (maps.size() == mapt.size()) {
			for (Object map : maps.entrySet()) {
			
				for (Object ma : mapt.entrySet()) {
					   
					 //System.out.println(((Map.Entry) map).getKey().toString()+"11111111111111"+((Map.Entry) ma).getKey().toString());
					if (specificationsuntil.tert(((Map.Entry) map).getKey().toString()).equals(specificationsuntil.tert(specificationsuntil.tert(((Map.Entry) ma).getKey().toString())))) {
						// System.out.println(((Map.Entry) map).getValue().toString()+"222222222222222"+((Map.Entry) ma).getValue().toString());
						if (specificationsuntil.tert(((Map.Entry) map).getValue().toString()).equals(specificationsuntil.tert(((Map.Entry) ma).getValue().toString()))) {
							fig = true;
							//System.out.println("相同");
							
						} else {
							fig = false;
							//System.out.println("不相同");
							return fig;
							
						}
					}
			}
			}
		}
		return fig;
	}
	/**
	 * 去掉双引号
	 * @param specification
	 * @return
	 */
	public static String tert(String specification) {
		 char[] temp = specification.toCharArray();  
		 StringBuffer tre=new StringBuffer();
	      for(int i=0;i<temp.length;i++) {
	    	  if(temp[i]!='"') {//判断是否是",如果是则不添加到新的对象中
	    		  tre.append(temp[i]);//将字符串添加到对象中
	    		  
	    	  }
	      }
	       

	     return  tre.toString();//返回新的字符串
	}

}
