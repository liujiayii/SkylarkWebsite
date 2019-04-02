package com.websit.entityvo;

import java.util.List;

import com.websit.entity.T_company;
import com.websit.entity.T_plate;

public class PlateCompanyVo extends T_company {

	private static final long serialVersionUID = 1L;
	
	/** 版块列表 */
	private List<T_plate> t_plate;

	public List<T_plate> getT_plate() {
		return t_plate;
	}

	public void setT_plate(List<T_plate> t_plate) {
		this.t_plate = t_plate;
	}

	@Override
	public String toString() {
		return "PlateCompanyVo [t_plate=" + t_plate + "]";
	}

	
}
