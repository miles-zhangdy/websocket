$('.btn-setting').click(function(e) {
	e.preventDefault();
	$('#myModal').modal('show');
});

var _totalPage = 0;
var pageSize = 10;
var options = {
	theadData : [ {
		code : 'menuName',
		type : 'text'
	}, {
		code : 'menuUrl',
		type : 'text'
	}, {
		code : 'menuRank',
		type : 'text'
	}, {
		code : 'createTime',
		type : 'date'
	}, {
		code : 'op',
		type : 'op'
	} ],
	formatter : {
		date : 'yyyy-mm-dd HH:mm:ss'
	}
}
var fns = {
	op : fn
};

var table = new Table("menuTable", options, fns);

initList()
function initList() {

	var data = dataInfo;

	var _totalPage = data.maxPage;
	if (data.maxPage == 0) {
		_totalPage = 1;
	}

	$.jqPaginator('#pagetable', {
		totalPages : _totalPage,
		visiblePages : pageSize,
		currentPage : 1,
		prev : '<li class="prev"><a href="javascript:;">上页</a></li>',
		next : '<li class="next"><a href="javascript:;">下页</a></li>',
		first : '<li class="first"><a href="javascript:;">首页</a></li>',
		last : '<li class="last"><a href="javascript:;">尾页</a></li>',
		page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
		onPageChange : function(num, type) {
			if ((this.currentPage != 1) || (1 != num)) {
				queryList(num, false);
			}
		}
	});
	table.insert('dictionaryTable', data.data);
}
function queryList(page_index, pageinit) {
	$.get(
					"admin/menumgr/findMenuPageList",
					{
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
								$
										.jqPaginator(
												'#pagetable',
												{
													totalPages : _totalPage,
													visiblePages : pageSize,
													currentPage : 1,
													prev : '<li class="prev"><a href="javascript:;">上页</a></li>',
													next : '<li class="next"><a href="javascript:;">下页</a></li>',
													first : '<li class="first"><a href="javascript:;">首页</a></li>',
													last : '<li class="last"><a href="javascript:;">尾页</a></li>',
													page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
													onPageChange : function(
															num, type) {
														if ((this.currentPage != 1)
																|| (1 != num)) {
															queryList(num,
																	false);
														}
													}
												});

							}

							table.insert('menuTable', data.data);

						} else {
							alert(data.msg);
						}

					}, "json");

}

function fn(tr, data, head) {
	// console.log(table.getRowData());
	if (head.type == "op") {

		var td = "<td><a onclick='del(\"" + data.menuId + "\")'>删除</a>";
		td += "|<a onclick='getMenuChild(\"" + data.menuId
				+ "\", 1, true)'>查看子菜单</a>";
		td += '</td>';
		tr.append(td);

	}
}

var childOptions = {
	theadData : [ {
		code : 'menuName',
		type : 'text'
	}, {
		code : 'menuUrl',
		type : 'text'
	}, {
		code : 'menuRank',
		type : 'text'
	}, {
		code : 'createTime',
		type : 'date'
	}, {
		code : 'op',
		type : 'op'
	} ],
	formatter : {
		date : 'yyyy-mm-dd HH:mm:ss'
	}
}
var childFns = {
	op : childfn
};

var table = new Table("childMenuTable", childOptions, childFns);

function childfn(tr, data, head) {
	if (head.type == "op") {
		var td = "<td><a onclick='del(\"" + data.menuId + "\")'>删除</a></td>";
		tr.append(td);
	}
}

function getMenuChild(parentId, curPage, pageInit) {

	if (pageInit) {
		$("#childMenuModal").modal('show');
		$("#insertChildMenuBtn").attr('val', parentId);
	}

	$
			.get(
					  "admin/menumgr/findMenuPageList",
					{
						"page" : curPage,
						"pageSize" : pageSize,
						"parentId" : parentId,
						"menuRank" : 2,
						"aliveFlag" : 1
					},
					function(data) {
						if (data.success == true) {
							var _totalPage = data.maxPage;
							if (data.maxPage == 0) {
								_totalPage = 1;
							}
							if (pageInit) {
								$
										.jqPaginator(
												'#childPageTable',
												{
													totalPages : _totalPage,
													visiblePages : pageSize,
													currentPage : 1,
													prev : '<li class="prev"><a href="javascript:;">上页</a></li>',
													next : '<li class="next"><a href="javascript:;">下页</a></li>',
													first : '<li class="first"><a href="javascript:;">首页</a></li>',
													last : '<li class="last"><a href="javascript:;">尾页</a></li>',
													page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
													onPageChange : function(
															num, type) {
														if ((this.currentPage != 1)
																|| (1 != num)) {
															getMenuChild(
																	parentId,
																	num, false);
														}
													}
												});

							}
							table.insert('childMenuTable', data.data);
						} else {
							alert(data.msg);
						}

					}, "json");

}

$(function() {
	insertValidate();

	insertChildValidate();

	$("#insertChildMenuBtn").click(function() {
		insertChildMenuShow($(this));
	});
});

function insertChildMenuShow(obj) {
	var parentId = obj.attr('val');
	$("#insertChildMenuform").find("input[name='parentId']").val(parentId);
	$("#insertChildModal").modal('show');

}

function insertValidate() {
	$("#insertMenuform").validate(
			{
				submitHandler : function(form) {
					/**
					 * 响应添加按钮事件
					 */
					insertMenu();
				},
				rules : {
					menuName : {
						required : true
					},
					menuUrl : {
						required : true
					},
					remark : {
						required : true
					}
				},
				messages : {
					menuName : {
						required : "必须输入"
					},
					menuUrl : {
						required : "必须输入"
					},
					remark : {
						required : "必须输入"
					}
				},
				errorElement : "em",
				errorPlacement : function(error, element) {

					error.addClass("help-block");

					if (element.prop("type") === "checkbox") {
						error.insertAfter(element.parent("label"));
					} else {
						error.insertAfter(element);
					}
				},
				highlight : function(element, errorClass, validClass) {
					$(element).parents(".col-sm-5").addClass("has-error")
							.removeClass("has-success");
				},
				unhighlight : function(element, errorClass, validClass) {
					$(element).parents(".col-sm-5").addClass("has-success")
							.removeClass("has-error");
				}

			});
}

function insertMenu() {
	$.ajax({
		url : 'admin/menumgr/insertMenu',
		type : 'post',
		data : $("#insertMenuform").serialize(),
		dataType : 'json',
		success : function(result) {
			if (result.success == true) {
				alert(result.msg);
				queryList(1, false)
				$("#myModal").modal('hide');
			} else {
				alert(result.msg);
			}
		}
	});
}

function insertChildMenu() {
	$.ajax({
		url :  '/admin/menumgr/insertMenu',
		type : 'post',
		data : $("#insertChildMenuform").serialize(),
		dataType : 'json',
		success : function(result) {
			if (result.success == true) {
				alert(result.msg);
				getMenuChild($("#insertChildMenuform").find(
						'input[name="parentId"]').val(), 1, false), $(
						"#insertChildModal").modal('hide');
			} else {
				alert(result.msg);
			}
		}
	});
}

function insertChildValidate() {
	$("#insertChildMenuform").validate(
			{
				submitHandler : function(form) {
					/**
					 * 响应添加按钮事件
					 */
					insertChildMenu();
				},
				rules : {
					menuName : {
						required : true
					},
					menuUrl : {
						required : true
					},
					remark : {
						required : true
					}
				},
				messages : {
					menuName : {
						required : "必须输入"
					},
					menuUrl : {
						required : "必须输入"
					},
					remark : {
						required : "必须输入"
					}
				},
				errorElement : "em",
				errorPlacement : function(error, element) {

					error.addClass("help-block");

					if (element.prop("type") === "checkbox") {
						error.insertAfter(element.parent("label"));
					} else {
						error.insertAfter(element);
					}
				},
				highlight : function(element, errorClass, validClass) {
					$(element).parents(".col-sm-5").addClass("has-error")
							.removeClass("has-success");
				},
				unhighlight : function(element, errorClass, validClass) {
					$(element).parents(".col-sm-5").addClass("has-success")
							.removeClass("has-error");
				}

			});
}
