(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6faac8a0"],{"268f":function(t,e,a){t.exports=a("fde4")},"85f2":function(t,e,a){t.exports=a("454f")},a4bb:function(t,e,a){t.exports=a("8aae")},bf90:function(t,e,a){var r=a("36c3"),n=a("bf0b").f;a("ce7e")("getOwnPropertyDescriptor",function(){return function(t,e){return n(r(t),e)}})},cebc:function(t,e,a){"use strict";var r=a("268f"),n=a.n(r),o=a("e265"),i=a.n(o),s=a("a4bb"),c=a.n(s),l=a("85f2"),d=a.n(l);function u(t,e,a){return e in t?d()(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}function p(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{},r=c()(a);"function"===typeof i.a&&(r=r.concat(i()(a).filter(function(t){return n()(a,t).enumerable}))),r.forEach(function(e){u(t,e,a[e])})}return t}a.d(e,"a",function(){return p})},e265:function(t,e,a){t.exports=a("ed33")},e876:function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("a-alert",{staticStyle:{"margin-bottom":"10px"},attrs:{message:"错误的设置项可能会导致系统崩溃",banner:"",closable:""}}),a("div",{staticClass:"top"},[a("div"),a("a-button",{attrs:{type:"primary",shape:"circle",icon:"plus"},on:{click:function(e){t.drawerShow=!0}}},[t._v("添加")])],1),a("a-table",{attrs:{columns:t.columns,rowKey:function(t){return t.key},dataSource:t.tableData,pagination:t.pagination,loading:t.loading,bordered:""},on:{change:t.handleTableChange},scopedSlots:t._u([{key:"operation",fn:function(e,r){return[a("a-button",{staticStyle:{"margin-right":"6px"},attrs:{type:"primary",size:"small"},on:{click:function(e){return t.showDrawer(r)}}},[t._v("查看\n      ")]),a("a-popconfirm",{attrs:{title:"确定删除？",cancelText:"取消",okText:"确认"},on:{confirm:function(e){return t.remove(r)}}},[a("a-icon",{staticStyle:{color:"red"},attrs:{slot:"icon",type:"question-circle-o"},slot:"icon"}),a("a-button",{attrs:{type:"danger",size:"small"}},[t._v("删除")])],1)]}},{key:"expandedRowRender",fn:function(e){return[a("a-table",{attrs:{columns:t.columnsC,dataSource:e.child,size:"small",pagination:!1,bordered:""},scopedSlots:t._u([{key:"expandedRowRender",fn:function(e){return[a("a-table",{staticStyle:{"margin-left":"0"},attrs:{columns:t.columnsF,dataSource:e.child,size:"small",pagination:!1,bordered:""},scopedSlots:t._u([{key:"operation",fn:function(e,r){return[a("a-button",{staticStyle:{"margin-right":"6px"},attrs:{type:"primary",size:"small"},on:{click:function(e){return t.showDrawer(r)}}},[t._v("查看\n              ")]),a("a-popconfirm",{attrs:{title:"确定删除？",cancelText:"取消",okText:"确认"},on:{confirm:function(e){return t.remove(r)}}},[a("a-icon",{staticStyle:{color:"red"},attrs:{slot:"icon",type:"question-circle-o"},slot:"icon"}),a("a-button",{attrs:{type:"danger",size:"small"}},[t._v("删除")])],1)]}}],null,!0)})]}},{key:"operation",fn:function(e,r){return[a("a-button",{staticStyle:{"margin-right":"6px"},attrs:{type:"primary",size:"small"},on:{click:function(e){return t.showDrawer(r)}}},[t._v("查看\n          ")]),a("a-popconfirm",{attrs:{title:"确定删除？",cancelText:"取消",okText:"确认"},on:{confirm:function(e){return t.remove(r)}}},[a("a-icon",{staticStyle:{color:"red"},attrs:{slot:"icon",type:"question-circle-o"},slot:"icon"}),a("a-button",{attrs:{type:"danger",size:"small"}},[t._v("删除")])],1)]}}],null,!0)})]}}])}),a("a-drawer",{attrs:{title:"权限",width:720,visible:t.drawerShow,wrapClassName:"drawer-cont",destroyOnClose:""},on:{close:function(){return t.drawerShow=!1}}},[a("a-form",{attrs:{form:t.form},on:{submit:t.handleSubmit}},[a("a-row",{attrs:{gutter:16}},[a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"权限名称"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["id"],expression:"['id']"}],attrs:{type:"hidden"}}),a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["name"],expression:"['name']"}]})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"权限描述"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["description"],expression:"['description']"}],attrs:{type:"textarea"}})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"请求地址"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["url"],expression:"['url']"}]})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"父菜单id"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["pid"],expression:"['pid']"}]})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"权限标识"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["perms"],expression:"['perms']"}]})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"显示顺序"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["order_num"],expression:"['order_num']"}]})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"权限类型"}},[a("a-select",{directives:[{name:"decorator",rawName:"v-decorator",value:["menu_type"],expression:"['menu_type']"}]},[a("a-select-option",{attrs:{value:"M"}},[t._v("主目录")]),a("a-select-option",{attrs:{value:"C"}},[t._v("子菜单")]),a("a-select-option",{attrs:{value:"F"}},[t._v("按钮")])],1)],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"菜单状态"}},[a("a-select",{directives:[{name:"decorator",rawName:"v-decorator",value:["visible"],expression:"['visible']"}]},[a("a-select-option",{attrs:{value:0}},[t._v("显示")]),a("a-select-option",{attrs:{value:1}},[t._v("隐藏")])],1)],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"菜单图标"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["icon"],expression:"['icon']"}]})],1)],1),a("a-col",{attrs:{span:12}},[a("a-form-item",{attrs:{label:"前端组件"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["component"],expression:"['component']"}]})],1)],1)],1),a("div",{staticClass:"drawer-footer"},[a("a-button",{style:{marginRight:"8px"},on:{click:function(){return t.drawerShow=!1}}},[t._v("取消")]),a("a-button",{attrs:{type:"primary","html-type":"submit"}},[t._v("保存")])],1)],1)],1)],1)},n=[],o=a("cebc"),i={name:"access",data:function(){return{columns:[{title:"id",dataIndex:"id"},{title:"主目录",dataIndex:"name"},{title:"权限描述",dataIndex:"description"},{title:"请求地址",dataIndex:"url"},{title:"权限标识",dataIndex:"perms"},{title:"显示顺序",dataIndex:"order_num"},{title:"菜单状态",dataIndex:"visible",customRender:function(t,e,a){return 0===t?"显示":"隐藏"}},{title:"前端组件",dataIndex:"component"},{title:"操作",dataIndex:"operation",width:"160px",scopedSlots:{customRender:"operation"}}],columnsC:[{title:"id",dataIndex:"id"},{title:"子菜单",dataIndex:"name"},{title:"权限描述",dataIndex:"description"},{title:"请求地址",dataIndex:"url"},{title:"权限标识",dataIndex:"perms"},{title:"显示顺序",dataIndex:"order_num"},{title:"菜单状态",dataIndex:"visible",customRender:function(t,e,a){return 0===t?"显示":"隐藏"}},{title:"前端组件",dataIndex:"component"},{title:"操作",dataIndex:"operation",width:"160px",scopedSlots:{customRender:"operation"}}],columnsF:[{title:"按钮名称",dataIndex:"name"},{title:"权限描述",dataIndex:"description"},{title:"请求地址",dataIndex:"url"},{title:"权限标识",dataIndex:"perms"},{title:"操作",dataIndex:"operation",width:"160px",scopedSlots:{customRender:"operation"}}],tableData:[],pagination:{},loading:!1,drawerShow:!1,form:this.$form.createForm(this)}},methods:{handleSubmit:function(t){var e=this;t.preventDefault(),this.form.validateFields(function(t,a){for(var r in a)a[r]||delete a[r];t||e.$ajax({url:a.id?"perms/updatePerm":"perms/insertPerm",data:a}).then(function(t){1===t.data.code&&(e.$message.success(t.data.msg),e.fetch(e.pagination),e.drawerShow=!1)})})},showDrawer:function(t){var e=this;this.drawerShow=!0,setTimeout(function(){e.form.setFieldsValue(t)},500)},handleTableChange:function(t,e,a){var r=Object(o["a"])({},this.pagination);r.current=t.current,this.pagination=r,this.fetch(Object(o["a"])({limit:t.pageSize,page:t.current},e))},fetch:function(){var t=this,e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};e.page=e.page||e.current||1,e.limit=e.limit||10,this.loading=!0,this.$ajax({url:"perms/selectPermsTreeData",data:Object(o["a"])({},e)}).then(function(e){var a=Object(o["a"])({},t.pagination);a.total=e.data.count,t.loading=!1,t.tableData=e.data.data,t.pagination=a})},remove:function(t){var e=this;this.$ajax({url:"perms/deletePerm",data:{id:t.id}}).then(function(t){1===t.data.code&&(e.$message.success(t.data.msg),e.fetch(e.pagination))})}},mounted:function(){this.fetch()}},s=i,c=a("2877"),l=Object(c["a"])(s,r,n,!1,null,null,null);e["default"]=l.exports},ed33:function(t,e,a){a("014b"),t.exports=a("584a").Object.getOwnPropertySymbols},fde4:function(t,e,a){a("bf90");var r=a("584a").Object;t.exports=function(t,e){return r.getOwnPropertyDescriptor(t,e)}}}]);