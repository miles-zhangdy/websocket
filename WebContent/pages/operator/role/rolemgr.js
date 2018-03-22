
var _totalPage = 0;
var pageSize = 10;
var options = {theadData : [ 
	              {code : 'roleName',type : 'text'},
	              {code : 'createName',type : 'text'},
	              {code : 'createTime',type : 'date'},
	              {code : 'op',type : 'op'} ],
	formatter : {
		date : 'yyyy-mm-dd HH:mm:ss'
	}
}
var fns = {
	op : fn
};

var table = new Table("roleTable", options, fns);

initList()
function initList() {
	
	var data = dataInfo;

	var _totalPage = data.maxPage;
	if (data.maxPage == 0) {
		_totalPage = 1;
	}

	$.jqPaginator('#pagetable',{
		totalPages : _totalPage,
		visiblePages : pageSize,
		currentPage : 1,
		prev : '<li class="prev"><a href="javascript:;">上页</a></li>',
		next : '<li class="next"><a href="javascript:;">下页</a></li>',
		first : '<li class="first"><a href="javascript:;">首页</a></li>',
		last : '<li class="last"><a href="javascript:;">尾页</a></li>',
		page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
		onPageChange : function(num, type) {
			if ((this.currentPage != 1)|| (1 != num)) {
				queryList(num,false);
			}
		}
	});
	table.insert('dictionaryTable', data.data);
}
function queryList(page_index, pageinit) {
	$.get("admin/rolemgr/findRolePageList",{
			"page" : page_index,
			"pageSize" : pageSize,
			"menuRank" : 1,
			"aliveFlag" : 1
		},
		function(data) {
			if (data.success == true) {
				var _totalPage = data.maxPage;
				if (data.maxPage == 0) {
					_totalPage = 1;
				}
				if (pageinit) {
					$.jqPaginator('#pagetable',{
						totalPages : _totalPage,
						visiblePages : pageSize,
						currentPage : 1,
						prev : '<li class="prev"><a href="javascript:;">上页</a></li>',
						next : '<li class="next"><a href="javascript:;">下页</a></li>',
						first : '<li class="first"><a href="javascript:;">首页</a></li>',
						last : '<li class="last"><a href="javascript:;">尾页</a></li>',
						page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
						onPageChange : function(num, type) {
							if ((this.currentPage != 1)|| (1 != num)) {
								queryList(num,false);
							}
						}
					});

				}

				table.insert('roleTable', data.data);

			} else{
				alert(data.msg);
			}

		}, "json");

}

function fn(tr, data, head) {
	// console.log(table.getRowData());
	if (head.type == "op") {

		var td = "<td><a onclick='del(\""+data.menuId+"\")'>删除</a>";
		td += "|<a onclick='getMenuChild(\""+data.menuId+"\", 1, true)'>查看</a>";
		td += '</td>';
		tr.append(td);

	}
}

//$('.btn-setting').click(function () {
//	var setting = {
//         check: {
//             enable: false,
//             chkStyle: "checkbox",
//             chkboxType: { "Y": "p", "N": "s" }
//         },
//         data: {
//             simpleData: {
//                 enable: true,
//                 idKey: "id",
//                 pIdKey: "parent",
//                 rootPId: "#"
//             }
//         }
//    };
//	$.fn.zTree.init($("#menuTree"), setting, menuList.jsontree);
//});


