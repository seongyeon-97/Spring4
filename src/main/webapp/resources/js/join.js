/**
 * 
 */

//id, pw, name, phone, email 이 비어있으면 가입x

$("#btn").click(function(){

	let result = true;
	let t;
	
	$(".c1").each(function(s1, s2){
	
		if($(s2).val() == ""){
			result = false;
			t=s2;
			}
		});
		
	if(result){
		alert("완료");
		/*$("#frm").submit();*/
	}else{
		alert("입력 확인 필요");
		$(t).focus();	
	}
	
});
