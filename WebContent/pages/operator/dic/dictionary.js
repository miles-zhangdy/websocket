$('.btn-setting').click(function(e) {
	e.preventDefault();
	$('#myModal').modal('show');
});

var _totalPage = 0;
var pageSize = 10;
var options = {
	theadData : [ {
		code : 'dicName',
		type : 'text'
	}, {
		code : 'dicCode',
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
var table = new Table("dictionaryTable", options, fns);

function pageCallback(page_index, jq) {
	page_index = page_index + 1;
	if (page_index > 0) {
		queryList(page_index, false);
	}

}
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
	$.get("admin/dictionary/findDictionaryPageList", {
			"page" : page_index,
			"pageSize" : pageSize
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

				table.insert('dictionaryTable', data.data);

			} else {
				alert(data.msg);
			}

		}, "json");

}

function fn(tr, data, head) {
	if (head.type == "op") {
		var td = '';
		tr.append(td);

	}
}

function insertDictionaryValueValidate() {
	$("#insertDictionaryValueform").validate(
			{
				submitHandler : function(form) {
					/**
					 * 响应添加按钮事件
					 */
					insertDictionary();
				},
				rules : {
					valueName : {
						required : true
					},
					valueCode : {
						required : true
					}
				},
				messages : {
					valueName : {
						required : "必须输入"
					},
					valueCode : {
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
