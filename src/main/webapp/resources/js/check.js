/**
 * 
 */
 
 const all = document.getElementById('all');
 const c1 = document.getElementsByClassName('c1');
 const btn = document.getElementById('btn');
 const ch = document.getElementsByClassName('ch');
 
 all.addEventListener('click', function(){
	
	/*전체 체크, 체크해제*/
	for(let s of c1){
		s.checked = all.checked;					
	}
});	

	/*하나라도 체크안되있으면 all 체크 해제, 모두 체크상태면 all 체크*/
	for(let s of c1){
		s.addEventListener('click', function(){
			let result = true;
			/*alert(s.dataset.checkNum);*/
			for(c of c1){
				if(!c.checked){
					result = false;	
					break;				
				}							
			}			
			all.checked = result;			
		})
	}
	
	btn.addEventListener('click', function(){
		let result = true;
		
		for(let cs of ch){
			if(!cs.checked){
				result = false;
				break;
			}
		}
		
		if(result){
			location.href = "./join";
		}else{
			alert("필수 약관에 동의하셔야 합니다");
		}
	});
	