(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-35b26c8c"],{"3b2b":function(t,e,a){var r=a("7726"),o=a("5dbc"),n=a("86cc").f,s=a("9093").f,i=a("aae3"),l=a("0bfb"),c=r.RegExp,d=c,u=c.prototype,m=/a/g,f=/a/g,p=new c(m)!==m;if(a("9e1e")&&(!p||a("79e5")(function(){return f[a("2b4c")("match")]=!1,c(m)!=m||c(f)==f||"/a/i"!=c(m,"i")}))){c=function(t,e){var a=this instanceof c,r=i(t),n=void 0===e;return!a&&r&&t.constructor===c&&n?t:o(p?new d(r&&!n?t.source:t,e):d((r=t instanceof c)?t.source:t,r&&n?l.call(t):e),a?this:u,c)};for(var h=function(t){t in c||n(c,t,{configurable:!0,get:function(){return d[t]},set:function(e){d[t]=e}})},g=s(d),v=0;g.length>v;)h(g[v++]);u.constructor=c,c.prototype=u,a("2aba")(r,"RegExp",c)}a("7a56")("RegExp")},b00f:function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"top"},[a("Input",{staticStyle:{width:"300px"},attrs:{search:"",placeholder:"Enter something..."}}),a("Button",{attrs:{type:"primary",shape:"circle",icon:"md-add",disabled:""}},[t._v("\n      添加\n    ")])],1),a("Table",{attrs:{border:"",columns:t.columns,data:t.tableData.data},scopedSlots:t._u([{key:"action",fn:function(e){var r=e.row;return[a("Button",{staticStyle:{"margin-right":"5px"},attrs:{type:"primary",size:"small",disabled:""},on:{click:function(e){return t.show(r)}}},[t._v("\n        查看\n      ")]),a("Button",{attrs:{type:"error",size:"small"},on:{click:function(e){return t.remove(r)}}},[t._v("\n        退货\n      ")])]}}])}),a("div",{staticClass:"page-box"},[a("Page",{attrs:{total:t.tableData.count,size:"small","show-elevator":"","show-total":""},on:{"on-change":t.pageChange}})],1),a("Drawer",{attrs:{title:"编辑",width:"720","mask-closable":!1,styles:t.styles},model:{value:t.drawerShow,callback:function(e){t.drawerShow=e},expression:"drawerShow"}},[a("Table",{attrs:{border:"",columns:t.columnsGoods,data:t.tableDataGoods}}),a("Form",{attrs:{model:t.formData}},[a("Row",{attrs:{gutter:32}},[a("Col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"姓名"}},[a("Input",{attrs:{size:"large",readonly:""},model:{value:t.formData.nickname,callback:function(e){t.$set(t.formData,"nickname",e)},expression:"formData.nickname"}})],1)],1),a("Col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"电话"}},[a("Input",{attrs:{size:"large",readonly:""},model:{value:t.formData.goods_tel,callback:function(e){t.$set(t.formData,"goods_tel",e)},expression:"formData.goods_tel"}})],1)],1),a("Col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"收货地址"}},[a("Input",{attrs:{size:"large",readonly:""},model:{value:t.formData.goods_address,callback:function(e){t.$set(t.formData,"goods_address",e)},expression:"formData.goods_address"}})],1)],1),a("Col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"订单状态"}},[a("Select",{attrs:{size:"large",readonly:""},model:{value:t.formData.order_state,callback:function(e){t.$set(t.formData,"order_state",e)},expression:"formData.order_state"}},[a("Option",{attrs:{value:"-1"}},[t._v("\n                订单取消\n              ")]),a("Option",{attrs:{value:"0"}},[t._v("\n                待付款\n              ")]),a("Option",{attrs:{value:"1"}},[t._v("\n                已付款，代发货\n              ")]),a("Option",{attrs:{value:"2"}},[t._v("\n                已发货\n              ")]),a("Option",{attrs:{value:"3"}},[t._v("\n                已签收\n              ")]),a("Option",{attrs:{value:"4"}},[t._v("\n                已完成\n              ")]),a("Option",{attrs:{value:"5"}},[t._v("\n                退货中\n              ")]),a("Option",{attrs:{value:"6"}},[t._v("\n                退货审核通过\n              ")]),a("Option",{attrs:{value:"7"}},[t._v("\n                退货审核不通过\n              ")])],1)],1)],1),a("Col",{directives:[{name:"show",rawName:"v-show",value:t.formData.order_state>0,expression:"formData.order_state>0"}],attrs:{span:"12"}},[a("FormItem",{attrs:{label:"物流单号"}},[a("Input",{attrs:{size:"large",readonly:""},model:{value:t.formData.order_shouhuo_id,callback:function(e){t.$set(t.formData,"order_shouhuo_id",e)},expression:"formData.order_shouhuo_id"}})],1)],1),a("Col",{directives:[{name:"show",rawName:"v-show",value:t.formData.order_state>0,expression:"formData.order_state>0"}],attrs:{span:"12"}},[a("FormItem",{attrs:{label:"货物状态"}},[a("Input",{attrs:{size:"large"},model:{value:t.formData.order_state,callback:function(e){t.$set(t.formData,"order_state",e)},expression:"formData.order_state"}})],1)],1),a("Col",{directives:[{name:"show",rawName:"v-show",value:t.formData.order_state>4,expression:"formData.order_state>4"}],attrs:{span:"12"}},[a("FormItem",{attrs:{label:"退款原因"}},[a("Input",{attrs:{size:"large"},model:{value:t.formData.sales_cause,callback:function(e){t.$set(t.formData,"sales_cause",e)},expression:"formData.sales_cause"}})],1)],1)],1)],1),a("div",{staticClass:"demo-drawer-footer"},[a("Button",{staticStyle:{"margin-right":"8px"},on:{click:function(e){t.drawerShow=!1}}},[t._v("\n        取消\n      ")]),a("Button",{attrs:{type:"primary"},on:{click:function(e){t.drawerShow=!1}}},[t._v("\n        退货\n      ")])],1)],1)],1)},o=[],n=a("f4e6"),s={name:"Return",data:function(){return{drawerShow:!1,styles:{height:"calc(100% - 55px)",overflow:"auto",paddingBottom:"53px",position:"static"},formData:{},ruleValidate:n["c"],columnsGoods:[{title:"订单编号",key:"order_id"},{title:"商品名称",key:"name"},{title:"单价",key:"danjia"},{title:"优惠金额",key:"youhuijine"},{title:"总价",key:"zongjia"}],columns:[{title:"订单编号",key:"order_id"},{title:"订单金额(元)",key:"zongjia"},{title:"姓名",key:"nickname"},{title:"订单状态",key:"order_state",render:function(t,e){return t("div",Object(n["b"])(e.row.order_state))}},{title:"操作",slot:"action",width:150,align:"center"}],tableData:{data:[],count:0},tableDataGoods:[]}},methods:{show:function(t){Object(this.formData,t),this.drawerShow=!0},remove:function(t){var e=this;this.$Modal.confirm({title:"提示",content:"<p>是否退货</p>",okText:"通过",cancelText:"拒绝",onOk:function(){e.$ajax({method:"post",url:"/t_order/ordercan",data:{order_id:t.order_id,order_state:6}}).then(function(t){1===t.data.code?(e.$Notice.success({title:t.data.msg}),e.pageChange(1)):e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})},onCancel:function(){e.$ajax({method:"post",url:"/t_order/ordercan",data:{order_id:t.order_id,order_state:7}}).then(function(t){1===t.data.code?(e.$Notice.success({title:t.data.msg}),e.pageChange(1)):e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})}})},pageChange:function(t){var e=this;this.$ajax({method:"post",url:"t_sales/thlist",data:{page:t,limit:10}}).then(function(t){1===t.data.code?e.tableData=t.data:e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})}},mounted:function(){this.pageChange(1)}},i=s,l=a("2877"),c=Object(l["a"])(i,r,o,!1,null,"7f1c1381",null);e["default"]=c.exports},f4e6:function(t,e,a){"use strict";a.d(e,"a",function(){return o}),a.d(e,"b",function(){return r}),a.d(e,"c",function(){return n});a("3b2b"),a("a481");function r(t){return-1==t?"订单取消":0==t?"待付款":1==t?"已付款，待发货":2==t?"已发货":3==t?"已签收":4==t?"已完成":5==t?"退货中":6==t?"退货审核通过":7==t?"退货审核不通过":void 0}function o(t,e){var a={"M+":t.getMonth()+1,"d+":t.getDate(),"h+":t.getHours(),"m+":t.getMinutes(),"s+":t.getSeconds(),S:t.getMilliseconds()};for(var r in/(y+)/.test(e)&&(e=e.replace(RegExp.$1,(t.getFullYear()+"").substr(4-RegExp.$1.length))),a)new RegExp("("+r+")").test(e)&&(e=e.replace(RegExp.$1,1===RegExp.$1.length?a[r]:("00"+a[r]).substr((""+a[r]).length)));return e}var n={}}}]);