/**
 * 
 */
 
 const c1 = document.getElementsByClassName('c1');
 const btn =document.getElementById('btn');
 
btn.addEventListener('click', function(){
	for(let ch of c1){
		ch.checked = true;
	}
});

/*	for(let ch of c1){
	if(ch.checked){
			ch.checked = !ch.checked;			
		}else{
			ch.checked = !ch.checked;
		}
	}*/

 
/* for(let s of c1){
 	s.addEventListener('click', function(){
		alert(s.checked);	
		if(s.checked == true){
			alert("check finish");
		}else{
			alert("check please");
		}
	});
}*/

