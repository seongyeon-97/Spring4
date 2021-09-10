/**
 * 
 */
 const c1 = document.getElementsByClassName('c1');
 const btn = document.getElementById('btn');
 const pws = document.getElementsByClassName('pw');
 const frm = document.getElementById('frm');
 const id = document.getElementById('id');
 const idResult = document.getElementById('idResult');
 const pwResult = document.getElementById('pwResult');
 const idCheck = document.getElementById('idCheck');
 
/* id.addEventListener('keyup', function(){
	if(id.value.trim().length>=6){
		idResult.innerHTML='올바른 입력입니다';
	}else{
		idResult.innerHTML='6글자 이상이여야 합니다';
	}
});
 
 id.addEventListener('blur', function(){
	id.value = '';
});*/
 
/* id.addEventListener('blur', function(){
	if(id.value.trim().length < 6){
		id.focus();	
	}
});*/
 
 
 idCheck.addEventListener('click', function(){
	open("./idCheck?id="+id.value, "", "width=400,height=400,top=200");
})
 
 id.addEventListener('change', function(){
	alert('change');
	
});
 
btn.addEventListener('click', function(){
	//비어있는거 검사 결과 담는 ce
	let ce = checkEmpty(c1);
	//비밀번호, 확인 값이 같은지 검사 값을 담는 ceq
	let ceq = checkEqual(pws[0], pws[1])
	//비밀번호 길이가 6자 이상인것을 검사한 값을 담는 cl
	let cl = checkLength();

	if(ce && ceq && cl){
		alert('success');
		frm.submit();
	}else{
		alert('fail');
	}
	
});

function checkEmpty(puts){
	let result = true;
	
	for(c of puts){
		if(c.value.trim() == ""){
			result = false;
			break;
		}
	}
	
	return result;
	
}

function checkEqual(check1, check2){

	return check1.value == check2.value;
	
}

function checkLength(){
	//전역변수인 pws 사용
	let l = pws[0].value.trim().length;
	
	if(l>=6){
		return true;
	}else{
		return false;
	}
}

