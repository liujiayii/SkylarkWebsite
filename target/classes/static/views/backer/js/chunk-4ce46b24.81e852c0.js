(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4ce46b24"],{"1d94":function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("a-divider",{attrs:{orientation:"left"}},[t._v("首页轮播图")]),a("div",{staticClass:"top"},[a("div"),a("Upload",{attrs:{action:"/t_carousel/insert","show-upload-list":!1,"on-success":t.bannerSuc,format:["jpg","jpeg","png"],"on-format-error":t.formatError}},[a("a-button",{attrs:{type:"primary",shape:"circle",icon:"plus"},on:{click:function(e){t.drawerShowBanner=!0}}},[t._v("上传图片")])],1)],1),a("Table",{attrs:{border:"",columns:t.columnsBanner,data:t.tableDataBanner.data},scopedSlots:t._u([{key:"action",fn:function(e){var o=e.row;return[a("a-button",{attrs:{type:"danger",size:"small"},on:{click:function(e){return t.removeBanner(o)}}},[t._v("删除")])]}}])}),a("div",{staticClass:"page-box"},[a("Page",{attrs:{total:t.tableDataBanner.count,size:"small","show-elevator":"","show-total":""},on:{"on-change":t.pageChangeBanner}})],1),a("a-divider",{attrs:{orientation:"left"}},[t._v("商品专区")]),a("div",{staticClass:"top"},[a("div"),a("a-button",{attrs:{type:"primary",shape:"circle",icon:"plus"},on:{click:function(e){t.drawerShowSpec=!0}}},[t._v("\n      添加\n    ")])],1),a("Table",{attrs:{border:"",columns:t.columnsSpec,data:t.tableDataSpec.data},scopedSlots:t._u([{key:"action",fn:function(e){var o=e.row;return[a("a-button",{staticStyle:{"margin-right":"5px"},attrs:{type:"primary",size:"small"},on:{click:function(e){return t.editSpec(o)}}},[t._v("\n        修改\n      ")]),a("a-button",{attrs:{type:"danger",size:"small"},on:{click:function(e){return t.removeSpec(o)}}},[t._v("\n        删除\n      ")])]}}])}),a("div",{staticClass:"page-box"},[a("Page",{attrs:{total:t.tableDataSpec.count,size:"small","show-elevator":"","show-total":""},on:{"on-change":t.pageChangeSpec}})],1),a("a-divider",{attrs:{orientation:"left"}},[t._v("一级分类")]),a("div",{staticClass:"top"},[a("div"),a("a-button",{attrs:{type:"primary",shape:"circle",icon:"plus"},on:{click:function(e){t.drawerShow=!0}}},[t._v("\n      添加\n    ")])],1),a("Table",{attrs:{border:"",columns:t.columns,data:t.tableData.data},scopedSlots:t._u([{key:"action",fn:function(e){var o=e.row;return[a("a-button",{staticStyle:{"margin-right":"5px"},attrs:{type:"primary",size:"small"},on:{click:function(e){return t.edit(o)}}},[t._v("\n        修改\n      ")]),a("a-button",{attrs:{type:"danger",size:"small"},on:{click:function(e){return t.remove(o)}}},[t._v("\n        删除\n      ")])]}}])}),a("div",{staticClass:"page-box"},[a("Page",{attrs:{total:t.tableData.count,size:"small","show-elevator":"","show-total":""},on:{"on-change":t.pageChange}})],1),a("a-divider",{attrs:{orientation:"left"}},[t._v("二级分类")]),a("div",{staticClass:"top"},[a("div"),a("a-button",{attrs:{type:"primary",shape:"circle",icon:"plus"},on:{click:function(e){t.drawerShowSec=!0}}},[t._v("\n      添加\n    ")])],1),a("Table",{attrs:{border:"",columns:t.columnsSec,data:t.tableDataSec.data},scopedSlots:t._u([{key:"action",fn:function(e){var o=e.row;return[a("a-button",{staticStyle:{"margin-right":"5px"},attrs:{type:"primary",size:"small"},on:{click:function(e){return t.editSec(o)}}},[t._v("\n        修改\n      ")]),a("a-button",{attrs:{type:"danger",size:"small"},on:{click:function(e){return t.removeSec(o)}}},[t._v("\n        删除\n      ")])]}}])}),a("div",{staticClass:"page-box"},[a("Page",{attrs:{total:t.tableDataSec.count,size:"small","show-elevator":"","show-total":""},on:{"on-change":t.pageChangeSec}})],1),a("Drawer",{attrs:{title:"编辑",width:"720","mask-closable":!1,styles:t.styles},on:{"on-close":t.closeDrawer},model:{value:t.drawerShowSpec,callback:function(e){t.drawerShowSpec=e},expression:"drawerShowSpec"}},[a("Form",{ref:"formDataSpec",attrs:{model:t.formDataSpec,rules:t.ruleValidate}},[a("Row",{attrs:{gutter:32}},[a("Col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"专区名称",prop:"name"}},[a("Input",{attrs:{size:"large"},model:{value:t.formDataSpec.name,callback:function(e){t.$set(t.formDataSpec,"name",e)},expression:"formDataSpec.name"}})],1)],1)],1),a("Upload",{attrs:{action:"/upload","on-success":t.handleUploadSpec,format:["jpg","jpeg","png"],"on-format-error":t.formatError,"show-upload-list":!1}},[a("a-button",{attrs:{icon:"upload"}},[t._v("\n          上传图标\n        ")])],1)],1),a("div",{staticClass:"demo-drawer-footer"},[a("a-button",{attrs:{type:"primary"},on:{click:function(e){return t.submitSpec("formDataSpec")}}},[t._v("\n        保存\n      ")])],1)],1),a("Drawer",{attrs:{title:"编辑",width:"720","mask-closable":!1,styles:t.styles},on:{"on-close":t.closeDrawer},model:{value:t.drawerShow,callback:function(e){t.drawerShow=e},expression:"drawerShow"}},[a("Form",{ref:"formData",attrs:{model:t.formData,rules:t.ruleValidate}},[a("Row",{attrs:{gutter:32}},[a("Col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"一级分类名称",prop:"name"}},[a("Input",{attrs:{size:"large"},model:{value:t.formData.name,callback:function(e){t.$set(t.formData,"name",e)},expression:"formData.name"}})],1)],1)],1),a("Upload",{attrs:{action:"/upload","on-success":t.handleUpload,format:["jpg","jpeg","png"],"on-format-error":t.formatError,"show-upload-list":!1}},[a("a-button",{attrs:{icon:"upload"}},[t._v("\n          上传图标\n        ")])],1)],1),a("div",{staticClass:"demo-drawer-footer"},[a("a-button",{attrs:{type:"primary"},on:{click:function(e){return t.submit("formData")}}},[t._v("\n        保存\n      ")])],1)],1),a("Drawer",{attrs:{title:"编辑",width:"720","mask-closable":!1,styles:t.styles},on:{"on-close":t.closeDrawer},model:{value:t.drawerShowSec,callback:function(e){t.drawerShowSec=e},expression:"drawerShowSec"}},[a("Form",{ref:"formDataSec",attrs:{model:t.formDataSec,rules:t.ruleValidate}},[a("Row",{attrs:{gutter:32}},[a("Col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"一级分类名称",prop:"classificationId"}},[a("Select",{attrs:{size:"large"},model:{value:t.formDataSec.classificationId,callback:function(e){t.$set(t.formDataSec,"classificationId",e)},expression:"formDataSec.classificationId"}},t._l(t.tableData.data,function(e){return a("Option",{key:e.id,attrs:{value:e.id}},[t._v("\n              "+t._s(e.name)+"\n            ")])}),1)],1)],1),a("Col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"二级分类名称",prop:"name"}},[a("Input",{attrs:{size:"large"},model:{value:t.formDataSec.name,callback:function(e){t.$set(t.formDataSec,"name",e)},expression:"formDataSec.name"}})],1)],1)],1),a("Upload",{attrs:{action:"/upload","on-success":t.handleUploadSec,format:["jpg","jpeg","png"],"on-format-error":t.formatError,"show-upload-list":!1}},[a("a-button",{attrs:{icon:"upload"}},[t._v("\n          上传图标\n        ")])],1)],1),a("div",{staticClass:"demo-drawer-footer"},[a("a-button",{attrs:{type:"primary"},on:{click:function(e){return t.submitSec("formDataSec")}}},[t._v("\n        保存\n      ")])],1)],1)],1)},n=[],r=a("5176"),i=a.n(r),c=(a("7f7f"),a("f4e6")),s={name:"Sort",data:function(){return{drawerShow:!1,drawerShowSec:!1,drawerShowSpec:!1,styles:{height:"calc(100% - 55px)",overflow:"auto",paddingBottom:"53px",position:"static"},formData:{},ruleValidate:c["c"],formDataSec:{},formDataSpec:{},formDataBanner:{},columns:[{title:"编号",key:"id"},{title:"商品分类名称",key:"name"},{title:"商品分类图片",key:"image",render:function(t,e){return t("div",[t("img",{attrs:{src:e.row.image},style:{width:"50px",height:"50px"}})])}},{title:"创建时间",key:"create_time",render:function(t,e){return t("div",Object(c["a"])(new Date(e.row.create_time),"yyyy-MM-dd"))}},{title:"操作",slot:"action",width:150,align:"center"}],columnsSec:[{title:"编号",key:"id"},{title:"商品一级分类名称",key:"classificationName"},{title:"商品分类名称",key:"name"},{title:"商品分类图片",key:"ioc",render:function(t,e){return t("div",[t("img",{attrs:{src:e.row.ioc},style:{width:"50px",height:"50px"}})])}},{title:"创建时间",key:"create_time",render:function(t,e){return t("div",Object(c["a"])(new Date(e.row.create_time),"yyyy-MM-dd"))}},{title:"操作",slot:"action",width:150,align:"center"}],columnsBanner:[{title:"编号",key:"id"},{title:"图片",key:"ioc",render:function(t,e){return t("div",[t("img",{attrs:{src:e.row.path},style:{width:"50px",height:"50px"}})])}},{title:"创建时间",key:"creat_time",render:function(t,e){return t("div",Object(c["a"])(new Date(e.row.creat_time),"yyyy-MM-dd"))}},{title:"操作",slot:"action",width:150,align:"center"}],columnsSpec:[{title:"编号",key:"id"},{title:"商品分类名称",key:"name"},{title:"商品专区图片",key:"image",render:function(t,e){return t("div",[t("img",{attrs:{src:e.row.image},style:{width:"50px",height:"50px"}})])}},{title:"创建时间",key:"create_time",render:function(t,e){return t("div",Object(c["a"])(new Date(e.row.create_time),"yyyy-MM-dd"))}},{title:"操作",slot:"action",width:150,align:"center"}],tableDataSpec:{data:[],count:0},tableDataBanner:{data:[],count:0},tableData:{data:[],count:0},tableDataSec:{data:[],count:0}}},methods:{formatError:function(){this.$Notice.error({title:"文件格式错误"})},closeDrawer:function(){this.formData={},this.formDataSec={},this.formDataSpec={}},submit:function(t){var e=this;this.$refs[t].validate(function(t){t?e.$ajax({method:"post",url:e.formData.id?"updateClassification":"saveClassification",data:e.formData}).then(function(t){1===t.data.code?(e.$Notice.success({title:t.data.msg}),e.pageChange(1),e.drawerShow=!1):e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})}):e.$Message.error("Fail!")})},submitSec:function(t){var e=this;this.$refs[t].validate(function(t){t?(delete e.formDataSec._index,delete e.formDataSec._rowKey,e.$ajax({method:"post",url:e.formDataSec.id?"updateProductType":"saveProductType",data:e.formDataSec}).then(function(t){1===t.data.code?(e.$Notice.success({title:t.data.msg}),e.pageChangeSec(1),e.drawerShowSec=!1):e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})):e.$Message.error("Fail!")})},submitSpec:function(t){var e=this;this.$refs[t].validate(function(t){t?(delete e.formDataSpec._index,delete e.formDataSpec._rowKey,delete e.formDataSpec.create_time,e.$ajax({method:"post",url:e.formDataSpec.id?"updateZone":"saveZone",data:e.formDataSpec}).then(function(t){1===t.data.code?(e.$Notice.success({title:t.data.msg}),e.pageChangeSpec(1),e.drawerShowSpec=!1):e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})):e.$Message.error("Fail!")})},bannerSuc:function(){this.pageChangeBanner(1)},handleUpload:function(t){this.formData.image=t.data},handleUploadSec:function(t){this.formDataSec.ioc=t.data},handleUploadSpec:function(t){this.formDataSpec.image=t.data},edit:function(t){i()(this.formData,t),this.drawerShow=!0},editSpec:function(t){i()(this.formDataSpec,t),this.drawerShowSpec=!0},editSec:function(t){i()(this.formDataSec,t),this.drawerShowSec=!0},remove:function(t){var e=this;this.$Modal.confirm({title:"提示",content:"<p>是否删除</p>",onOk:function(){e.$ajax({method:"post",url:"deleteClassificationById",data:t}).then(function(t){1===t.data.code?(e.$Notice.success({title:t.data.msg}),e.pageChange(1)):e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})},onCancel:function(){e.$Message.info("Clicked cancel")}})},removeSpec:function(t){var e=this;this.$Modal.confirm({title:"提示",content:"<p>是否删除</p>",onOk:function(){e.$ajax({method:"post",url:"deleteZoneById",data:t}).then(function(t){1===t.data.code?(e.$Notice.success({title:t.data.msg}),e.pageChangeSpec(1)):e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})},onCancel:function(){e.$Message.info("Clicked cancel")}})},removeBanner:function(t){var e=this;this.$Modal.confirm({title:"提示",content:"<p>是否删除</p>",onOk:function(){e.$ajax({method:"post",url:"t_carousel/deleatById",data:t}).then(function(t){1===t.data.code?(e.$Notice.success({title:t.data.msg}),e.pageChangeBanner(1)):e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})},onCancel:function(){e.$Message.info("Clicked cancel")}})},removeSec:function(t){var e=this;this.$Modal.confirm({title:"提示",content:"<p>是否删除</p>",onOk:function(){e.$ajax({method:"post",url:"deleteProductTypeById",data:t}).then(function(t){1===t.data.code?(e.$Notice.success({title:t.data.msg}),e.pageChangeSec(1)):e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})},onCancel:function(){e.$Message.info("Clicked cancel")}})},pageChangeSec:function(t){var e=this;this.$ajax({method:"post",url:"selectAllProductTypeList",data:{page:t,limit:10}}).then(function(t){1===t.data.code?e.tableDataSec=t.data:e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})},pageChangeBanner:function(t){var e=this;this.$ajax({method:"post",url:"t_carousel/selectAll",data:{page:t,limit:10}}).then(function(t){1===t.data.code?e.tableDataBanner=t.data:e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})},pageChangeSpec:function(t){var e=this;this.$ajax({method:"post",url:"selectZoneList",data:{page:t,limit:10}}).then(function(t){1===t.data.code?e.tableDataSpec=t.data:e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})},pageChange:function(t){var e=this;this.$ajax({method:"post",url:"listAllClassification",data:{page:t,limit:10}}).then(function(t){1===t.data.code?e.tableData=t.data:e.$Notice.error({title:t.data.msg})}).catch(function(t){e.$Notice.error({title:t.data.msg})})}},mounted:function(){this.pageChange(1),this.pageChangeSec(1),this.pageChangeSpec(1),this.pageChangeBanner(1)}},l=s,d=a("2877"),u=Object(d["a"])(l,o,n,!1,null,"4c3a6d9c",null);e["default"]=u.exports},"3b2b":function(t,e,a){var o=a("7726"),n=a("5dbc"),r=a("86cc").f,i=a("9093").f,c=a("aae3"),s=a("0bfb"),l=o.RegExp,d=l,u=l.prototype,m=/a/g,p=/a/g,f=new l(m)!==m;if(a("9e1e")&&(!f||a("79e5")(function(){return p[a("2b4c")("match")]=!1,l(m)!=m||l(p)==p||"/a/i"!=l(m,"i")}))){l=function(t,e){var a=this instanceof l,o=c(t),r=void 0===e;return!a&&o&&t.constructor===l&&r?t:n(f?new d(o&&!r?t.source:t,e):d((o=t instanceof l)?t.source:t,o&&r?s.call(t):e),a?this:u,l)};for(var h=function(t){t in l||r(l,t,{configurable:!0,get:function(){return d[t]},set:function(e){d[t]=e}})},g=i(d),S=0;g.length>S;)h(g[S++]);u.constructor=l,l.prototype=u,a("2aba")(o,"RegExp",l)}a("7a56")("RegExp")},f4e6:function(t,e,a){"use strict";a.d(e,"a",function(){return n}),a.d(e,"b",function(){return o}),a.d(e,"c",function(){return r});a("3b2b"),a("a481");function o(t){return-1==t?"订单取消":0==t?"待付款":1==t?"已付款，待发货":2==t?"已发货":3==t?"已签收":4==t?"已完成":5==t?"退货中":6==t?"退货审核通过":7==t?"退货审核不通过":void 0}function n(t,e){var a={"M+":t.getMonth()+1,"d+":t.getDate(),"h+":t.getHours(),"m+":t.getMinutes(),"s+":t.getSeconds(),S:t.getMilliseconds()};for(var o in/(y+)/.test(e)&&(e=e.replace(RegExp.$1,(t.getFullYear()+"").substr(4-RegExp.$1.length))),a)new RegExp("("+o+")").test(e)&&(e=e.replace(RegExp.$1,1===RegExp.$1.length?a[o]:("00"+a[o]).substr((""+a[o]).length)));return e}var r={}}}]);