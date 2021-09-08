/**
 * 
 */
 
 function fn1(){
	alert("Are you sure???");
	let title = document.getElementById("title");
	let writer = document.getElementById("writer");
	let frm = document.getElementById("frm");
	
	let t1 = document.getElementById("t_1");
	t1.innerHTML="";
	let w1 = document.getElementById("w_1");	
	w1.innerHTML="";
	
	let t = title.value;
	let w = writer.value;
	
	let check=true;
	
	/*if(t == "" || w ==""){
		check = false;
	}else if(t != "" && w != ""){
		check = true;
	}*/
	
	if(t == ""){
		check=false;
		t1.innerHTML = 'check again';
	}
	
	if(w == ""){
		check=false;
		w1.innerHTML = 'check again';
	}
	
	if(check){
		frm.submit();
	}else{		
		alert("NOT COMPLETE");
	}
	
}



let b1 = document.getElementById("b1");
b1.addEventListener("click", fn1);