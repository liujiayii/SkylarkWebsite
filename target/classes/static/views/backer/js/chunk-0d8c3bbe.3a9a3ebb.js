(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0d8c3bbe"],{"28fb":function(e,a,t){"use strict";t.r(a);var n=function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("div",[t("forumTable",{attrs:{"forum-name":"玉琼债餐饮"}})],1)},o=[],c=t("cb99"),s={name:"YuQiong",components:{forumTable:c["a"]}},r=s,d=t("2877"),i=Object(d["a"])(r,n,o,!1,null,"7bb61b5f",null);a["default"]=i.exports},"9a1c":function(e,a,t){"use strict";var n=t("9add"),o=t.n(n);o.a},"9add":function(e,a,t){},cb99:function(e,a,t){"use strict";var n=function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("div",[t("a-divider",[e._v(e._s(e.forumName))]),t("div",{staticClass:"top"},[t("a-input-search",{staticStyle:{width:"200px"},attrs:{placeholder:"input search text"},on:{search:e.onSearch}})],1),t("a-table",{attrs:{columns:e.columns,dataSource:e.data}})],1)},o=[],c=(t("7f7f"),{name:"ForumTable",props:{forumName:String},data:function(){return{data:[{key:"1",name:"John Brown",age:32,address:"New York No. 1 Lake Park"},{key:"2",name:"Jim Green",age:42,address:"London No. 1 Lake Park"},{key:"3",name:"Joe Black",age:32,address:"Sidney No. 1 Lake Park"}],columns:[{title:"Name",dataIndex:"name"},{title:"Age",dataIndex:"age"},{title:"Address",dataIndex:"address"}]}},methods:{show:function(e){this.$Modal.info({title:"User Info",content:"Name：".concat(this.data6[e].name,"<br>Age：").concat(this.data6[e].age,"<br>Address：").concat(this.data6[e].address)})},remove:function(e){var a=this;this.$Modal.confirm({title:"提示",content:"<p>是否删除帖子</p>",onOk:function(){a.$Message.info("Clicked ok"),a.data6.splice(e,1)},onCancel:function(){a.$Message.info("Clicked cancel")}})},onSearch:function(e){console.log(e)}}}),s=c,r=(t("9a1c"),t("2877")),d=Object(r["a"])(s,n,o,!1,null,"7fd0ac30",null);a["a"]=d.exports}}]);