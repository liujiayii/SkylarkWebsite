(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d207919"],{a0a5:function(t,a,e){"use strict";e.r(a);var i=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("div",{staticClass:"top"},[e("div"),e("a-button",{attrs:{type:"primary",shape:"circle",icon:"plus"},on:{click:function(a){t.drawerShow=!0}}},[t._v("添加")])],1),e("a-table",{attrs:{columns:t.columns,rowKey:function(t){return t.id},dataSource:t.tableData,pagination:t.pagination,loading:t.loading,bordered:""},on:{change:t.handleTableChange},scopedSlots:t._u([{key:"operation",fn:function(a,i){return[e("a-popconfirm",{attrs:{title:"确定删除？",cancelText:"取消",okText:"确认"},on:{confirm:function(a){return t.remove(i)}}},[e("a-icon",{staticStyle:{color:"red"},attrs:{slot:"icon",type:"question-circle-o"},slot:"icon"}),e("a-button",{attrs:{type:"danger",size:"small"}},[t._v("删除")])],1)]}}])}),e("a-drawer",{attrs:{title:"规格",width:720,visible:t.drawerShow,wrapClassName:"drawer-cont",destroyOnClose:""},on:{close:function(){return t.drawerShow=!1}}},[e("a-form",{attrs:{form:t.form},on:{submit:t.handleSubmit}},[e("a-form-item",{attrs:{label:"规格分类"}},[e("a-select",{directives:[{name:"decorator",rawName:"v-decorator",value:["producttypeid"],expression:"['producttypeid']"}],attrs:{labelInValue:""}},t._l(t.class_two,function(a){return e("a-select-option",{attrs:{value:a.id}},[t._v(t._s(a.name))])}),1)],1),e("a-form-item",{attrs:{label:"规格名称"}},[e("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["specificationsName"],expression:"['specificationsName']"}]})],1),e("div",{staticClass:"drawer-footer"},[e("a-button",{style:{marginRight:"8px"},on:{click:function(){return t.drawerShow=!1}}},[t._v("取消")]),e("a-button",{attrs:{type:"primary","html-type":"submit"}},[t._v("保存")])],1)],1)],1)],1)},n=[],o=e("cebc"),r={name:"specs",data:function(){return{columns:[{title:"规格分类",dataIndex:"producttypename"},{title:"规格名称",dataIndex:"specificationsName"},{title:"操作",dataIndex:"operation",width:"160px",scopedSlots:{customRender:"operation"}}],tableData:[],pagination:{},loading:!1,drawerShow:!1,form:this.$form.createForm(this),class_two:[]}},methods:{handleSubmit:function(t){var a=this;t.preventDefault(),this.form.validateFields(function(t,e){if(!t){var i=e.producttypeid;e.producttypeid=i.key,e.producttypename=i.label,a.$ajax({url:"saveSpecificationsVo",data:e}).then(function(t){1===t.data.code&&(a.$message.success(t.data.msg),a.fetch(a.pagination),a.drawerShow=!1)})}})},showDrawer:function(t){var a=this;this.drawerShow=!0,this.$nextTick(function(){a.form.setFieldsValue(t)})},handleTableChange:function(t,a,e){var i=Object(o["a"])({},this.pagination);i.current=t.current,this.pagination=i,this.fetch(Object(o["a"])({limit:t.pageSize,page:t.current},a))},fetch:function(){var t=this,a=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};a.page=a.page||a.current||1,a.limit=a.limit||10,this.loading=!0,this.$ajax({url:"listAllSpecifications",data:Object(o["a"])({},a)}).then(function(a){var e=Object(o["a"])({},t.pagination);e.total=a.data.count,t.loading=!1,t.tableData=a.data.data,t.pagination=e})},remove:function(t){var a=this;this.$ajax({url:"deleteSpecificationsVoById",data:{specificationsId:t.specificationsId}}).then(function(t){1===t.data.code&&(a.$message.success(t.data.msg),a.fetch(a.pagination))})},getClass_two:function(){var t=this;this.$ajax({url:"selectAllProductTypeList",data:{page:1,limit:100}}).then(function(a){t.class_two=a.data.data})}},mounted:function(){this.getClass_two(),this.fetch()}},s=r,c=e("2877"),l=Object(c["a"])(s,i,n,!1,null,null,null);a["default"]=l.exports}}]);