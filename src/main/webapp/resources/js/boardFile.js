/**
 * 
 */
 //다시 불러오는거기 때문에 id를 걸어서 이벤트를 줄수가 없다
  let file = '<div class="input-group mb-3">';
 	file = file + '<input type="file" name="files" class="form-control" aria-describedby="button-addon2">';
 	file = file + '<button class="btn btn-outline-secondary del" type="button" id="button-addon2">X</button>';
 	file = file + '</div>'
 
 let count = 0;
 /*let index = 0*/
 function setCount(c){
	count = c;
}
 
 function updateCount(){
	count--;
}
 
  $('#fileAdd').click(function(){
		/*index++;
	let file = '<div class="input-group mb-3" id="del'+index+'">';
 	file = file + '<input type="file" class="form-control" aria-describedby="button-addon2">';
 	file = file + '<button data-btn-id="'+index+'" class="btn btn-outline-secondary del" type="button" id="button-addon2">X</button>';
 	file = file + '</div>'*/ 
 	
	if(count<5){
		count++;
		$("#fileAddResult").append(file);
	}else{
		alert('최대 5개까지만 가능합니다');
	}
});

/*$(".del").click(function(){
	alert('test');
});*/

$('#fileAddResult').on('click', '.del', function(){
	/*let num = $(this).attr('data-btn-id');
	$('#del'+num).remove();*/
	$(this).parent().remove();
	
	count--;
});
	