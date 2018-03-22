$(document).ready(
			function() {
				$.fn.fullpage({
					slidesColor : [ '#0075D1', '#C2E5FF', '#FDF6E1', '#E9E9E9',
							'#F3F3F3', '#F9F3DC' ],
					anchors : [ 'page1', 'page2', 'page3', 'page4', 'page5',
							'page6' ],
					menu : '#menu',
					afterRender : function() {
						$('.screen-main span').each(function() {
							var $rel = $(this).attr('rel');
							var $arr = $rel.split(',');
							$(this).animate({
								left : $arr[2] + 'px',
								top : $arr[3] + 'px'
							}, 500);
						});
						$('.inner a').each(function() {
							var $rel = $(this).attr('rel');
							var $arr = $rel.split(',');
							$(this).animate({
								left : $arr[0] + 'px',
								top : $arr[1] + 'px'
							}, 500);
						});
					},
					afterLoad : function(anchorLink, index) {
						if (index == 1) {
							$('.screen-main span').each(function() {
								var $rel = $(this).attr('rel');
								var $arr = $rel.split(',');
								$(this).animate({
									left : $arr[2] + 'px',
									top : $arr[3] + 'px'
								}, 500);
							});
						}
						if (index == 2 || index == 3 || index == 4
								|| index == 5) {
							$('.inner').eq(index - 2).find('a').each(
									function() {
										var $rel = $(this).attr('rel');
										var $arr = $rel.split(',');
										$(this).animate({
											left : $arr[2] + 'px',
											top : $arr[3] + 'px'
										}, 500);
									});
						}
						if (index == 6) {
							$('.zanzhu-con a').fadeIn(1000);
						}
					},
					onLeave : function(index, direction) {
						if (index == 1) {
							$('.screen-main span').each(function() {
								var $rel = $(this).attr('rel');
								var $arr = $rel.split(',');
								$(this).animate({
									left : $arr[0] + 'px',
									top : $arr[1] + 'px'
								}, 500);
							});
						}
						if (index == 2 || index == 3 || index == 4
								|| index == 5) {
							$('.inner').eq(index - 2).find('a').each(
									function() {
										var $rel = $(this).attr('rel');
										var $arr = $rel.split(',');
										$(this).animate({
											left : $arr[0] + 'px',
											top : $arr[1] + 'px'
										}, 500);
									});
						}
						if (index == 6) {
							$('.zanzhu-con a').fadeOut(1000);
						}
					}
				});
			});