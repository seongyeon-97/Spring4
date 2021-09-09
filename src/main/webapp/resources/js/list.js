/**
 * 
 */
 


const btn = document.getElementById('btn');
const c1 = document.getElementsByClassName('c1');


for(let s of c1){
	s.addEventListener('click', function(){
		let num = s.dataset.writerNum;

		num = document.getElementById('w'+num);
		alert(num.innerHTML);
	});
}

/*for(let i in c1){
	let id = document.getElementById('id'+i);
	id.addEventListener('click', function(){
	alert('id'+1);
	});
}*/

let ar = ['a','b','c'];

btn.addEventListener("click", function(){
	
	for(let i of c1){
		console.log(i.innerHTML);
	}
	
	/*for(let i=0; i<ar.length; i++){
		console.log(ar[i]);
	}*/
	
	/*for(let i in ar){
		console.log(ar[i]);
	}*/
	
	/*for(let i of ar){
		console.log(i);
	}*/
	
	/*ar.forEach(function(v, i, ar){
		console.log(v, i, ar);		
	});*/
	
	
});