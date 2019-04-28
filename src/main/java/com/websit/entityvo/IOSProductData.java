package com.websit.entityvo;

import java.util.List;
/**
 * 
 *
 * @ClassName: IOSProductData

 * @description 用一句话描述这个类的作用
 *
 * @author lishaozhang
 * @createDate 2019年4月24日
 */
public class IOSProductData {

	private String specificationName;
	private List<Name> list;

	public String getSpecificationName() {
		return specificationName;
	}

	public void setSpecificationName(String specificationName) {
		this.specificationName = specificationName;
	}

	public List<Name> getList() {
		return list;
	}

	public void setList(List<Name> list) {
		this.list = list;
	}

	public IOSProductData() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "IOSProductData [specificationName=" + specificationName + ", list=" + list + "]";
	}

}
