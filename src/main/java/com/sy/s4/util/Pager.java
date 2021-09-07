package com.sy.s4.util;

public class Pager {
	
	
	private Long pn;
	//한 페이지에 출력할 글의 갯수
	private Long perPage;
	//한페이지에 출력할 pn의 갯수 - 5
	private Long perBlock;
	
	public Long getPerBlock() {
		this.perBlock=5L;
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	//------------RowNum Mapper에서 사용----------------
	private Long startRow;
	private Long lastRow;
	
	private Long startNum;
	private Long lastNum;
	
	private Long totalPage;
	
	private String kind;
	private String search;
	
	//---------------rownum 계산-----------------
	public void makeRow() {		
		this.startRow = (this.getPn() - 1)*this.getPerPage()+1;
		this.lastRow = this.getPn()*this.getPerPage();
	}
	
	//---------------startNum, lastNum jsp 번호 출력---------------------
	public void makeNum(Long totalCount) {
		//1. totalCount 구하기 : 전체 글의 갯수
		//Long totalCount = 210L;
		
		//2. totalPage 구하기 : 전체 페이지 갯수
		totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			//totalPage = totalPage + 1;
			totalPage++;
		}
		
		//3. totalBlock 구하기 : 전체 페이지블럭 계산
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0 ) {
			totalBlock++;
		}
		
		//4.paramater로 넘오오는 pn으로 curblock(현제블럭) 번호 구하기 -> 나열될 페이지블럭을 정하기 위해서
		//예) 6번 페이지면 6,7,8,9,10 이고 2번 페이지면 1,2,3,4,5
		if(totalPage<this.getPn()) {
			this.setPn(totalPage);
		}
		
		Long curBlock = this.getPn()/this.getPerBlock();
		if(this.getPn()%this.getPerBlock() != 0){
			curBlock++;
		}
		
		//5. curBlock로 startNum, lastNum 구하기
		this.lastNum = curBlock*this.getPerBlock();
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		
		//6. curblock이 마지막 블럭일때 lastNum 변경
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
	}
	
	
	
	public Long getPn() { // 주소창에 적어도 0 이상의 값을 입력해야하기 때문에 예외를 처리해준다
		if(this.pn==null || this.pn<=0) {
			this.pn=1L;
		}
		return pn;
	}
	public void setPn(Long pn) {
		this.pn = pn;
	}
	public Long getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage = 10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() { //검색어가 없는 경우를 처리해준다
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	
	
	
	
	
}
