/**
 * 
 */
  let file = '<div class="input-group mb-3">';
 file = file + '<input type="file" class="form-control" aria-describedby="button-addon2">';
 file = file + '<button class="btn btn-outline-secondary" type="button" id="button-addon2">Button</button>';
 file = file + '</div>' 
 
 let count = 0;
  $('#fileAdd').click(function(){
	if(count<5){
		count++;
		$("#fileAddResult").append(file);
	}else{
		alert('최대 5개까지만 가능합니다');
	}
});