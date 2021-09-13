/**
 * 
 */
 //모든걸 체크하면 다 하자
 $("#all").click(function(){
	$(".c1").prop("checked", $("#all").prop("checked"));
});

$(".c1").click(function(){
	let result = true;
	$(".c1").each(function(v1, v2){
		if(!$(v2).prop("checked")){
			result = false;
			console.log(v1, $(v2).prop("checked"));
			//break; 는 esch문 안에서 사용x
		}
	});
	$("#all").prop("checked", result);	
});

$("#btn").click(function(){
	if($("#all").prop("checked")){
		location.href = "join";
	}else{
		alert("약관 동의는 필수 입니다");
	}		
});


 

 