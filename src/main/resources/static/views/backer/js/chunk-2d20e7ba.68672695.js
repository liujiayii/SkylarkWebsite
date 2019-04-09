(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d20e7ba"],{b00f:function(t,a,e){"use strict";e.r(a);var o=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("div",{staticClass:"top"},[e("Input",{staticStyle:{width:"300px"},attrs:{search:"",placeholder:"Enter something..."}}),e("Button",{attrs:{type:"primary",shape:"circle",icon:"md-add",disabled:""}},[t._v("\n      添加\n    ")])],1),e("Table",{attrs:{border:"",columns:t.columns,data:t.tableData.data},scopedSlots:t._u([{key:"action",fn:function(a){var o=a.row;return[e("Button",{staticStyle:{"margin-right":"5px"},attrs:{type:"primary",size:"small",disabled:""},on:{click:function(a){return t.show(o)}}},[t._v("\n        查看\n      ")]),e("Button",{attrs:{type:"error",size:"small"},on:{click:function(a){return t.remove(o)}}},[t._v("\n        退货\n      ")])]}}])}),e("div",{staticClass:"page-box"},[e("Page",{attrs:{total:t.tableData.count,size:"small","show-elevator":"","show-total":""},on:{"on-change":t.pageChange}})],1),e("Drawer",{attrs:{title:"编辑",width:"720","mask-closable":!1,styles:t.styles},model:{value:t.drawerShow,callback:function(a){t.drawerShow=a},expression:"drawerShow"}},[e("Table",{attrs:{border:"",columns:t.columnsGoods,data:t.tableDataGoods}}),e("Form",{attrs:{model:t.formData}},[e("Row",{attrs:{gutter:32}},[e("Col",{attrs:{span:"12"}},[e("FormItem",{attrs:{label:"姓名"}},[e("Input",{attrs:{size:"large",readonly:""},model:{value:t.formData.nickname,callback:function(a){t.$set(t.formData,"nickname",a)},expression:"formData.nickname"}})],1)],1),e("Col",{attrs:{span:"12"}},[e("FormItem",{attrs:{label:"电话"}},[e("Input",{attrs:{size:"large",readonly:""},model:{value:t.formData.goods_tel,callback:function(a){t.$set(t.formData,"goods_tel",a)},expression:"formData.goods_tel"}})],1)],1),e("Col",{attrs:{span:"12"}},[e("FormItem",{attrs:{label:"收货地址"}},[e("Input",{attrs:{size:"large",readonly:""},model:{value:t.formData.goods_address,callback:function(a){t.$set(t.formData,"goods_address",a)},expression:"formData.goods_address"}})],1)],1),e("Col",{attrs:{span:"12"}},[e("FormItem",{attrs:{label:"订单状态"}},[e("Select",{attrs:{size:"large",readonly:""},model:{value:t.formData.order_state,callback:function(a){t.$set(t.formData,"order_state",a)},expression:"formData.order_state"}},[e("Option",{attrs:{value:"-1"}},[t._v("\n              订单取消\n            ")]),e("Option",{attrs:{value:"0"}},[t._v("\n              待付款\n            ")]),e("Option",{attrs:{value:"1"}},[t._v("\n              已付款，代发货\n            ")]),e("Option",{attrs:{value:"2"}},[t._v("\n              已发货\n            ")]),e("Option",{attrs:{value:"3"}},[t._v("\n              已签收\n            ")]),e("Option",{attrs:{value:"4"}},[t._v("\n              已完成\n            ")]),e("Option",{attrs:{value:"5"}},[t._v("\n              退货中\n            ")]),e("Option",{attrs:{value:"6"}},[t._v("\n              退货审核通过\n            ")]),e("Option",{attrs:{value:"7"}},[t._v("\n              退货审核不通过\n            ")])],1)],1)],1),e("Col",{directives:[{name:"show",rawName:"v-show",value:t.formData.order_state>0,expression:"formData.order_state>0"}],attrs:{span:"12"}},[e("FormItem",{attrs:{label:"物流单号"}},[e("Input",{attrs:{size:"large",readonly:""},model:{value:t.formData.order_shouhuo_id,callback:function(a){t.$set(t.formData,"order_shouhuo_id",a)},expression:"formData.order_shouhuo_id"}})],1)],1),e("Col",{directives:[{name:"show",rawName:"v-show",value:t.formData.order_state>0,expression:"formData.order_state>0"}],attrs:{span:"12"}},[e("FormItem",{attrs:{label:"货物状态"}},[e("Input",{attrs:{size:"large"},model:{value:t.formData.order_state,callback:function(a){t.$set(t.formData,"order_state",a)},expression:"formData.order_state"}})],1)],1),e("Col",{directives:[{name:"show",rawName:"v-show",value:t.formData.order_state>4,expression:"formData.order_state>4"}],attrs:{span:"12"}},[e("FormItem",{attrs:{label:"退款原因"}},[e("Input",{attrs:{size:"large"},model:{value:t.formData.sales_cause,callback:function(a){t.$set(t.formData,"sales_cause",a)},expression:"formData.sales_cause"}})],1)],1)],1)],1),e("div",{staticClass:"demo-drawer-footer"},[e("Button",{staticStyle:{"margin-right":"8px"},on:{click:function(a){t.drawerShow=!1}}},[t._v("\n        取消\n      ")]),e("Button",{attrs:{type:"primary"},on:{click:t.submit}},[t._v("\n        退货\n      ")])],1)],1)],1)},r=[],s=e("d930"),n={name:"Return",data:function(){return{drawerShow:!1,styles:{height:"calc(100% - 55px)",overflow:"auto",paddingBottom:"53px",position:"static"},formData:{},ruleValidate:s["c"],columnsGoods:[{title:"订单编号",key:"order_id"},{title:"商品名称",key:"name"},{title:"单价",key:"danjia"},{title:"优惠金额",key:"youhuijine"},{title:"总价",key:"zongjia"}],columns:[{title:"订单编号",key:"order_id"},{title:"订单金额(元)",key:"zongjia"},{title:"姓名",key:"nickname"},{title:"订单状态",key:"order_state",render:function(t,a){return t("div",Object(s["b"])(a.row.order_state))}},{title:"操作",slot:"action",width:150,align:"center"}],tableData:{data:[],count:0},tableDataGoods:[]}},methods:{show:function(t){Object(this.formData,t),this.drawerShow=!0},remove:function(t){var a=this;this.$Modal.confirm({title:"提示",content:"<p>是否退货</p>",onOk:function(){a.$ajax({method:"post",url:"/t_order/ordercan",data:{order_id:t.order_id,order_state:6}}).then(function(t){1===t.data.code?(a.$Notice.success({title:t.data.msg}),a.pageChange(1)):a.$Notice.error({title:t.data.msg})}).catch(function(t){a.$Notice.error({title:t.data.msg})})},onCancel:function(){a.$Message.info("Clicked cancel")}})},pageChange:function(t){var a=this;this.$ajax({method:"post",url:"t_sales/thlist",data:{page:t,limit:10}}).then(function(t){1===t.data.code?a.tableData=t.data:a.$Notice.error({title:t.data.msg})}).catch(function(t){a.$Notice.error({title:t.data.msg})})},submit:function(){}},mounted:function(){this.pageChange(1)}},l=n,i=e("2877"),d=Object(i["a"])(l,o,r,!1,null,"0a9a9ede",null);a["default"]=d.exports}}]);