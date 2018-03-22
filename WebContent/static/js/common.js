
//$.ajaxSetup({
//	contentType : "application/x-www-form-urlencoded;charset=utf-8",
//	complete : function(XMLHttpRequest, textStatus) {
//		// 通过XMLHttpRequest取得响应头，sessionstatus，
//		var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus"); 
//		if (sessionstatus == "timeout") {
//			// 如果超时就处理 ，指定要跳转的页面
//			window.location.replace("");
//		}
//	}
//});

function fmtTime(ms, formatter) {
	if (ms == null) {
		return "";
	}
	var date = new Date();
	date.setTime(ms);
	var year = date.getFullYear();
	var month = toDouble(date.getMonth() + 1);
	var day = toDouble(date.getDate());
	var hour = toDouble(date.getHours());
	var tHour = parseInt(hour) < 12 ? parseInt(hour) : parseInt(hour) - 12;
	var minute = toDouble(date.getMinutes());
	var second = toDouble(date.getSeconds());
	switch (formatter) {
	case 'yyyy-mm-dd':
		return year + '-' + month + '-' + day;
		break;
	case 'yyyy-mm-dd hh:mm:ss':
		return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':'
				+ second;
		break;
	case 'yyyy-mm-dd HH:mm:ss':
		return year + '-' + month + '-' + day + ' ' + tHour + ':' + minute
				+ ':' + second;
		break;
	default:
		return;
		break;
	}
}

function toDouble(num) {
	return num < 10 ? '0' + num : num;
}

function checkNull(val) {
	if (val == undefined || val == '' || val == null || val == 'null') {
		return '';
	}
	return val;
}

// 判空 true空 false 非空
function isEmpty(val) {
	if (val != undefined && val != '' && val != null && val != 'null'
			&& $.trim(val) != '') {
		return false;
	}
	return true;
}
// js中截取字符串
function subString(str, len) {
	if (!isEmpty(str)) {
		if (str.length > len) {
			return str.substring(0, len);
		}
		return str;
	}
	return "";
}
