/*
 * 商品详图切换
 */

$(function() {
	var $lis = $('.small-view li:not(:last)');
	console.log($lis);
	var $contents = $('.big-view>div');
	console.log($contents);
	$lis.click(function() {
	$lis.removeClass('current');
	this.className = 'current';
	//隐藏所有$contents
	$contents.hide();
	//获取当前下标
	var index = $(this).index();
	//显示对应当前的content
	$contents.eq(index).show();
	//$contents[index].style.display = 'block';
	});
})
