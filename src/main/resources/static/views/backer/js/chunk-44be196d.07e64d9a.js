(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-44be196d"],{"11e9":function(t,e,a){var r=a("52a7"),o=a("4630"),n=a("6821"),s=a("6a99"),i=a("69a8"),c=a("c69a"),d=Object.getOwnPropertyDescriptor;e.f=a("9e1e")?d:function(t,e){if(t=n(t),e=s(e,!0),c)try{return d(t,e)}catch(a){}if(i(t,e))return o(!r.f.call(t,e),t[e])}},"3b2b":function(t,e,a){var r=a("7726"),o=a("5dbc"),n=a("86cc").f,s=a("9093").f,i=a("aae3"),c=a("0bfb"),d=r.RegExp,l=d,u=d.prototype,p=/a/g,v=/a/g,m=new d(p)!==p;if(a("9e1e")&&(!m||a("79e5")(function(){return v[a("2b4c")("match")]=!1,d(p)!=p||d(v)==v||"/a/i"!=d(p,"i")}))){d=function(t,e){var a=this instanceof d,r=i(t),n=void 0===e;return!a&&r&&t.constructor===d&&n?t:o(m?new l(r&&!n?t.source:t,e):l((r=t instanceof d)?t.source:t,r&&n?c.call(t):e),a?this:u,d)};for(var h=function(t){t in d||n(d,t,{configurable:!0,get:function(){return l[t]},set:function(e){l[t]=e}})},f=s(l),_=0;f.length>_;)h(f[_++]);u.constructor=d,d.prototype=u,a("2aba")(r,"RegExp",d)}a("7a56")("RegExp")},"552d":function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"top"},[a("a-form",{attrs:{form:t.searchForm,layout:"inline"},on:{submit:t.handleSearch}},[a("a-form-item",[a("a-select",{directives:[{name:"decorator",rawName:"v-decorator",value:["order_state"],expression:"['order_state']"}],staticStyle:{width:"300px"},attrs:{placeholder:"选择订单状态"}},[a("a-select-option",{attrs:{value:""}},[t._v("查看全部")]),a("a-select-option",{attrs:{value:"-1"}},[t._v("订单取消")]),a("a-select-option",{attrs:{value:"0"}},[t._v("待付款")]),a("a-select-option",{attrs:{value:"1"}},[t._v("已付款，待发货")]),a("a-select-option",{attrs:{value:"2"}},[t._v("已发货")]),a("a-select-option",{attrs:{value:"3"}},[t._v("已签收")]),a("a-select-option",{attrs:{value:"4"}},[t._v("已完成")]),a("a-select-option",{attrs:{value:"5"}},[t._v("退货中")]),a("a-select-option",{attrs:{value:"6"}},[t._v("退货审核通过")]),a("a-select-option",{attrs:{value:"7"}},[t._v("退货审核不通过")])],1)],1),a("a-form-item",[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["date"],expression:"['date']"}],staticStyle:{width:"300px"},attrs:{placeholder:"输入关键词搜索……"}})],1),a("a-form-item",[a("a-button",{staticStyle:{"margin-right":"6px"},attrs:{type:"primary","html-type":"submit"}},[t._v("搜索")]),a("a-button",{on:{click:function(){return t.searchForm.resetFields()}}},[t._v("重置")])],1)],1)],1),a("a-table",{attrs:{columns:t.columns,rowKey:function(t){return t.id},dataSource:t.tableData,pagination:t.pagination,loading:t.loading,bordered:""},on:{change:t.handleTableChange},scopedSlots:t._u([{key:"operation",fn:function(e,r){return[a("a-button",{staticStyle:{"margin-right":"6px"},attrs:{type:"primary",size:"small"},on:{click:function(e){return t.showDrawer(r)}}},[t._v("查看")])]}},{key:"expandedRowRender",fn:function(e){return[a("a-table",{attrs:{columns:t.columnsGoods,dataSource:e.shping,size:"small",pagination:!1,bordered:""}})]}}])}),a("a-drawer",{attrs:{title:"订单详情",width:720,visible:t.drawerShow,wrapClassName:"drawer-cont",destroyOnClose:""},on:{close:function(){return t.drawerShow=!1}}},[a("a-form",{attrs:{form:t.form},on:{submit:t.handleSubmit}},[a("a-row",{attrs:{gutter:16}},[a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"姓名"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["goods_name"],expression:"['goods_name']"}],attrs:{readOnly:""}}),a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["order_id"],expression:"['order_id']"}],attrs:{type:"hidden"}})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"电话"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["goods_tel"],expression:"['goods_tel']"}],attrs:{readOnly:""}})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"省"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["goods_Province"],expression:"['goods_Province']"}],attrs:{readOnly:""}})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"市"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["goods_city"],expression:"['goods_city']"}],attrs:{readOnly:""}})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"县"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["goods_CountyArea"],expression:"['goods_CountyArea']"}],attrs:{readOnly:""}})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"详细地址"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["goods_address"],expression:"['goods_address']"}],attrs:{readOnly:""}})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"订单状态"}},[a("a-select",{directives:[{name:"decorator",rawName:"v-decorator",value:["order_state"],expression:"['order_state']"}],attrs:{disabled:""}},[a("a-select-option",{attrs:{value:"-1"}},[t._v("订单取消")]),a("a-select-option",{attrs:{value:"0"}},[t._v("待付款")]),a("a-select-option",{attrs:{value:"1"}},[t._v("已付款，待发货")]),a("a-select-option",{attrs:{value:"2"}},[t._v("已发货")]),a("a-select-option",{attrs:{value:"3"}},[t._v("已签收")]),a("a-select-option",{attrs:{value:"4"}},[t._v("已完成")]),a("a-select-option",{attrs:{value:"5"}},[t._v("退货中")]),a("a-select-option",{attrs:{value:"6"}},[t._v("退货审核通过")]),a("a-select-option",{attrs:{value:"7"}},[t._v("退货审核不通过")])],1)],1)],1),a("a-col",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"isShow"}],attrs:{span:12}},[a("a-form-item",{attrs:{label:"物流单号"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["order_shouhuo_id"],expression:"['order_shouhuo_id']"}]})],1)],1)],1),a("div",{staticClass:"drawer-footer"},[a("a-button",{style:{marginRight:"8px"},on:{click:function(){return t.drawerShow=!1}}},[t._v("取消")]),a("a-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"isShow"}],attrs:{type:"primary","html-type":"submit"}},[t._v("发货")])],1)],1)],1)],1)},o=[],n=a("cebc"),s=(a("a481"),a("28a5"),a("f4e6")),i={name:"Order",data:function(){return{columns:[{title:"订单编号",dataIndex:"order_no"},{title:"订单状态",dataIndex:"order_state",customRender:function(t,e,a){return Object(s["b"])(t)}},{title:"创建时间",dataIndex:"order_time",customRender:function(t,e,a){return Object(s["a"])(new Date(t),"yyyy-MM-dd hh:mm:ss")}},{title:"操作",dataIndex:"operation",width:"160px",scopedSlots:{customRender:"operation"}}],columnsGoods:[{title:"商品名称",dataIndex:"productName"},{title:"规格",dataIndex:"shoping_specifications",customRender:function(t,e,a){return t.replace("{","").replace("}","").split('"')}},{title:"单价",dataIndex:"danjia"},{title:"优惠金额",dataIndex:"youhuijine"},{title:"总价",dataIndex:"zongjia"}],tableData:[],pagination:{},loading:!1,drawerShow:!1,form:this.$form.createForm(this),searchForm:this.$form.createForm(this),searchKey:{date:"",order_state:""},isShow:!1}},methods:{handleSearch:function(t){var e=this;t.preventDefault(),this.searchForm.validateFields(function(t,a){t||(e.searchKey={date:a.date||"",order_state:a.order_state||""},e.handleTableChange({current:1}))})},handleSubmit:function(t){var e=this;t.preventDefault(),this.form.validateFields(function(t,a){t||e.$ajax({url:"t_order/ordercant",data:{order_id:a.order_id,order_state:2,order_shouhuo_id:a.order_shouhuo_id}}).then(function(t){1===t.data.code&&(e.$message.success(t.data.msg),e.fetch(e.pagination),e.drawerShow=!1)})})},showDrawer:function(t){var e=this;this.drawerShow=!0,this.isShow=t.order_state>0,this.$nextTick(function(){e.form.setFieldsValue(t)})},handleTableChange:function(t,e,a){var r=Object(n["a"])({},this.pagination);r.current=t.current,this.pagination=r,this.fetch(Object(n["a"])({limit:t.pageSize,page:t.current},e))},fetch:function(){var t=this,e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};e.page=e.page||e.current||1,e.limit=e.limit||10,this.loading=!0,this.$ajax({url:"t_order/orderweblist",data:Object(n["a"])({},this.searchKey,e)}).then(function(e){var a=Object(n["a"])({},t.pagination);a.total=e.data.count,t.loading=!1,t.tableData=e.data.data,t.pagination=a})}},mounted:function(){this.fetch()}},c=i,d=a("2877"),l=Object(d["a"])(c,r,o,!1,null,null,null);e["default"]=l.exports},"5dbc":function(t,e,a){var r=a("d3f4"),o=a("8b97").set;t.exports=function(t,e,a){var n,s=e.constructor;return s!==a&&"function"==typeof s&&(n=s.prototype)!==a.prototype&&r(n)&&o&&o(t,n),t}},"8b97":function(t,e,a){var r=a("d3f4"),o=a("cb7c"),n=function(t,e){if(o(t),!r(e)&&null!==e)throw TypeError(e+": can't set as prototype!")};t.exports={set:Object.setPrototypeOf||("__proto__"in{}?function(t,e,r){try{r=a("9b43")(Function.call,a("11e9").f(Object.prototype,"__proto__").set,2),r(t,[]),e=!(t instanceof Array)}catch(o){e=!0}return function(t,a){return n(t,a),e?t.__proto__=a:r(t,a),t}}({},!1):void 0),check:n}},9093:function(t,e,a){var r=a("ce10"),o=a("e11e").concat("length","prototype");e.f=Object.getOwnPropertyNames||function(t){return r(t,o)}},f4e6:function(t,e,a){"use strict";a.d(e,"a",function(){return o}),a.d(e,"b",function(){return r});a("3b2b"),a("a481");function r(t){return-1==t?"订单取消":0==t?"待付款":1==t?"已付款，待发货":2==t?"已发货":3==t?"已签收":4==t?"已完成":5==t?"退货中":6==t?"退货审核通过":7==t?"退货审核不通过":void 0}function o(t,e){var a={"M+":t.getMonth()+1,"d+":t.getDate(),"h+":t.getHours(),"m+":t.getMinutes(),"s+":t.getSeconds(),S:t.getMilliseconds()};for(var r in/(y+)/.test(e)&&(e=e.replace(RegExp.$1,(t.getFullYear()+"").substr(4-RegExp.$1.length))),a)new RegExp("("+r+")").test(e)&&(e=e.replace(RegExp.$1,1===RegExp.$1.length?a[r]:("00"+a[r]).substr((""+a[r]).length)));return e}}}]);