$(function(){
        //单位树
        var setting = {
                check: {
                        enable: true,
                        chkStyle: "checkbox",
                        chkboxType: { "Y": "p", "N": "s" }
                },
                data: {
                        simpleData: {
                                enable: true,
                                idKey: "id",
                                pIdKey: "parentId",
                                rootPId: "#"
                        }
                },
                async: { //异步加载
                        type: "post",
                        enable: true,
                        url: ctx + "/index/getztree"
                }
//                callback: {
//                        onClick: zTreeBeforeClick
//                }
        };
        $.fn.zTree.init($("#ztreeDiv"), setting);//初始化树对象
//    	var zNodes =[
//    	     		{id:1, pId:0, name:"[core] 基本功能 演示", open:true},
//    	     		{id:101, pId:1, name:"最简单的树 --  标准 JSON 数据", file:"core/standardData"},
//    	     		{id:102, pId:1, name:"最简单的树 --  简单 JSON 数据", file:"core/simpleData"},
//    	     		{id:103, pId:1, name:"不显示 连接线", file:"core/noline"},
//    	     		{id:104, pId:1, name:"不显示 节点 图标", file:"core/noicon"},
//    	     		{id:105, pId:1, name:"自定义图标 --  icon 属性", file:"core/custom_icon"},
//    	     		{id:106, pId:1, name:"自定义图标 --  iconSkin 属性", file:"core/custom_iconSkin"},
//    	     		{id:107, pId:1, name:"自定义字体", file:"core/custom_font"},
//    	     		{id:115, pId:1, name:"超链接演示", file:"core/url"},
//    	     		{id:108, pId:1, name:"异步加载 节点数据", file:"core/async"},
//    	     		{id:109, pId:1, name:"用 zTree 方法 异步加载 节点数据", file:"core/async_fun"},
//    	     		{id:110, pId:1, name:"用 zTree 方法 更新 节点数据", file:"core/update_fun"},
//    	     		{id:111, pId:1, name:"单击 节点 控制", file:"core/click"},
//    	     		{id:112, pId:1, name:"展开 / 折叠 父节点 控制", file:"core/expand"},
//    	     		{id:113, pId:1, name:"根据 参数 查找 节点", file:"core/searchNodes"},
//    	     		{id:114, pId:1, name:"其他 鼠标 事件监听", file:"core/otherMouse"}];
//		$.fn.zTree.init($("#ztreeDiv"), setting, zNodes);

//        checkAll();
//        noCheckAll();
//        expandAllNodes();
//        closeAllNodes();
});