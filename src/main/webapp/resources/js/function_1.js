/**
 * 
 */
 
 function fn1(){
	alert('fn1');
}

let  fn2 = function(){
	alert("2222");
};

let d3 = document.getElementById("d3");
/*d3.onmouseenter = fn2; */
d3.addEventListener("mouseleave", fn2);