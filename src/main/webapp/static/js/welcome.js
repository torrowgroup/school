'use strict';

var $circle = document.querySelector('.card__circle');
var $smallCircle = document.querySelector('.card__smallCircle');
var $year = document.querySelector('.card__year');
var $card = document.querySelector('.card');
var $cardOrangeShine = document.querySelector('.card__orangeShine');
var $cardThankYou = document.querySelector('.card__thankyou');
var $cardComet = document.querySelector('.card__cometOuter');
var $cardFooter = document.querySelector('.card__footer');

var generateTranslate = function generateTranslate(el, e, value) {
	el.style.transform = 'translate(' + e.clientX * value + 'px, ' + e.clientY * value + 'px)';
};
var cumulativeOffset = function cumulativeOffset(element) {
	var top = 0,
	    left = 0;
	do {
		top += element.offsetTop || 0;
		left += element.offsetLeft || 0;
		element = element.offsetParent;
	} while (element);

	return {
		top: top,
		left: left
	};
};
window.onload = function(){
	var $divfooter__1 = document.querySelector('.card__footer__1');
	$divfooter__1.style.left = 0+'px';
	$divfooter__1.style.opacity = 1;
	
}
setTimeout(function(){
	document.onmousemove = function (event) {
		// console.log(cumulativeOffset($card));
		var e = event || window.event;
		var x = (e.pageX - cumulativeOffset($card).left - 350 / 2) * -1 / 100;
		var y = (e.pageY - cumulativeOffset($card).top - 350 / 2) * -1 / 100;
	
		var matrix = [[1, 0, 0, -x * 0.00005], [0, 1, 0, -y * 0.00005], [0, 0, 1, 1], [0, 0, 0, 1]];
	
		generateTranslate($smallCircle, e, 0.03);
		generateTranslate($cardThankYou, e, 0.03);
		generateTranslate($cardOrangeShine, e, 0.09);
		generateTranslate($circle, e, 0.05);
		generateTranslate($year, e, 0.03);
		generateTranslate($cardComet, e, 0.05);
		generateTranslate($cardFooter, e, 0.05);
	
		$card.style.transform = 'matrix3d(' + matrix.toString() + ')';
	};
},1500);	