(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-634af104"],{"05a0":function(t,e,a){},"32b6":function(t,e,a){"use strict";var n=a("05a0"),o=a.n(n);o.a},"9e28":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("forumTable",{attrs:{"forum-name":"闪电传媒"}})],1)},o=[],r=a("cb99"),s={name:"ShanDian",components:{forumTable:r["a"]}},i=s,c=a("2877"),l=Object(c["a"])(i,n,o,!1,null,"48741d59",null);e["default"]=l.exports},cb99:function(t,e,a){"use strict";var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("Divider",[t._v(t._s(t.forumName))]),a("div",{staticClass:"top"},[a("Input",{staticStyle:{width:"300px"},attrs:{search:"",placeholder:"Enter something..."}}),a("Button",{attrs:{type:"primary",shape:"circle",icon:"md-add"}},[t._v("\n      添加\n    ")])],1),a("Table",{attrs:{border:"",columns:t.columns12,data:t.data6},scopedSlots:t._u([{key:"name",fn:function(e){var n=e.row;return[a("strong",[t._v(t._s(n.name))])]}},{key:"action",fn:function(e){e.row;var n=e.index;return[a("Button",{staticStyle:{"margin-right":"5px"},attrs:{type:"primary",size:"small"},on:{click:function(e){return t.show(n)}}},[t._v("查看")]),a("Button",{attrs:{type:"error",size:"small"},on:{click:function(e){return t.remove(n)}}},[t._v("删除")])]}}])}),a("div",{staticClass:"page-box"},[a("Page",{attrs:{total:40,size:"small","show-elevator":"","show-total":""}})],1)],1)},o=[],r=(a("7f7f"),{name:"ForumTable",props:{forumName:String},data:function(){return{columns12:[{title:"贴主编号",slot:"name"},{title:"贴主",key:"age"},{title:"贴吧主题",key:"address"},{title:"被评论数",key:"age"},{title:"操作",slot:"action",width:150,align:"center"}],data6:[{name:"John Brown",age:18,address:"New York No. 1 Lake Park"},{name:"Jim Green",age:24,address:"London No. 1 Lake Park"},{name:"Joe Black",age:30,address:"Sydney No. 1 Lake Park"},{name:"Jon Snow",age:26,address:"Ottawa No. 2 Lake Park"}]}},methods:{show:function(t){this.$Modal.info({title:"User Info",content:"Name：".concat(this.data6[t].name,"<br>Age：").concat(this.data6[t].age,"<br>Address：").concat(this.data6[t].address)})},remove:function(t){var e=this;this.$Modal.confirm({title:"提示",content:"<p>是否删除帖子</p>",onOk:function(){e.$Message.info("Clicked ok"),e.data6.splice(t,1)},onCancel:function(){e.$Message.info("Clicked cancel")}})}}}),s=r,i=(a("32b6"),a("2877")),c=Object(i["a"])(s,n,o,!1,null,"4fad29e0",null);e["a"]=c.exports}}]);