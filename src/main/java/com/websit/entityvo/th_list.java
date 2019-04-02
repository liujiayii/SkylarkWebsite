package com.websit.entityvo;

import java.util.Date;

public class th_list extends order_list{







	    private Integer sales_id;

	    /**
	     * 订单id
	     */
	    private Integer order_id;

	    /**
	     * 退货原因
	     */
	    private String sales_cause;

	    /**
	     * 退货类别
	     */
	    private String cause_type;

	    /**
	     * 退货说明
	     */
	    private String cause_explain;

	    /**
	     * 退货时间
	     */
	    private Date cause_time;
	    /**
	     * 退货状态
	     */
	    private String  stele;
	    /*
	      * * 昵称
	     */
	    private String nickname;
	    /*
	      * * 订单编号
	     */
	    private String sales_no;
	    /*
	      * * 订单编号
	     */
	    private Integer youhuijine;

	    public Integer getYouhuijine() {
			return youhuijine;
		}

		public void setYouhuijine(Integer youhuijine) {
			this.youhuijine = youhuijine;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cause_explain == null) ? 0 : cause_explain.hashCode());
			result = prime * result + ((cause_time == null) ? 0 : cause_time.hashCode());
			result = prime * result + ((cause_type == null) ? 0 : cause_type.hashCode());
			result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
			result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
			result = prime * result + ((sales_cause == null) ? 0 : sales_cause.hashCode());
			result = prime * result + ((sales_id == null) ? 0 : sales_id.hashCode());
			result = prime * result + ((sales_no == null) ? 0 : sales_no.hashCode());
			result = prime * result + ((stele == null) ? 0 : stele.hashCode());
			result = prime * result + ((youhuijine == null) ? 0 : youhuijine.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			th_list other = (th_list) obj;
			if (cause_explain == null) {
				if (other.cause_explain != null)
					return false;
			} else if (!cause_explain.equals(other.cause_explain))
				return false;
			if (cause_time == null) {
				if (other.cause_time != null)
					return false;
			} else if (!cause_time.equals(other.cause_time))
				return false;
			if (cause_type == null) {
				if (other.cause_type != null)
					return false;
			} else if (!cause_type.equals(other.cause_type))
				return false;
			if (nickname == null) {
				if (other.nickname != null)
					return false;
			} else if (!nickname.equals(other.nickname))
				return false;
			if (order_id == null) {
				if (other.order_id != null)
					return false;
			} else if (!order_id.equals(other.order_id))
				return false;
			if (sales_cause == null) {
				if (other.sales_cause != null)
					return false;
			} else if (!sales_cause.equals(other.sales_cause))
				return false;
			if (sales_id == null) {
				if (other.sales_id != null)
					return false;
			} else if (!sales_id.equals(other.sales_id))
				return false;
			if (sales_no == null) {
				if (other.sales_no != null)
					return false;
			} else if (!sales_no.equals(other.sales_no))
				return false;
			if (stele == null) {
				if (other.stele != null)
					return false;
			} else if (!stele.equals(other.stele))
				return false;
			if (youhuijine == null) {
				if (other.youhuijine != null)
					return false;
			} else if (!youhuijine.equals(other.youhuijine))
				return false;
			return true;
		}

		public String getSales_no() {
			return sales_no;
		}

		public void setSales_no(String sales_no) {
			this.sales_no = sales_no;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getStele() {
			return stele;
		}

		public void setStele(String stele) {
			this.stele = stele;
		}

		public Integer getSales_id() {
	        return sales_id;
	    }

	    public void setSales_id(Integer sales_id) {
	        this.sales_id = sales_id;
	    }
	    public Integer getOrder_id() {
	        return order_id;
	    }

	    public void setOrder_id(Integer order_id) {
	        this.order_id = order_id;
	    }
	    public String getSales_cause() {
	        return sales_cause;
	    }

	    public void setSales_cause(String sales_cause) {
	        this.sales_cause = sales_cause;
	    }
	    public String getCause_type() {
	        return cause_type;
	    }

	    public void setCause_type(String cause_type) {
	        this.cause_type = cause_type;
	    }
	    public String getCause_explain() {
	        return cause_explain;
	    }

	    public void setCause_explain(String cause_explain) {
	        this.cause_explain = cause_explain;
	    }
	    public Date getCause_time() {
	        return cause_time;
	    }

	    public void setCause_time(Date cause_time) {
	        this.cause_time = cause_time;
	    }



	    @Override
		public String toString() {
			return "th_list [sales_id=" + sales_id + ", order_id=" + order_id + ", sales_cause=" + sales_cause
					+ ", cause_type=" + cause_type + ", cause_explain=" + cause_explain + ", cause_time=" + cause_time
					+ ", stele=" + stele + ", nickname=" + nickname + ", sales_no=" + sales_no + ", youhuijine="
					+ youhuijine + "]";
		}
	}


