package com.sy.s4.board;

import java.util.List;

import com.sy.s4.util.Pager;

public interface BoardDAO {

	//file save
	public int setFile(BoardFilesDTO boardFilesDTO) throws Exception;
	
	//전체 갯수 가져오기
	public Long getCount(Pager pager) throws Exception;
	
	//List 가져오기
	public abstract List<BoardDTO> getList(Pager pager) throws Exception;
	
	//상세 페이지 가져오기
	public abstract BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
		
	//글쓰기
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//삭ㅈㅔ
	public int setDelete(Long num) throws Exception;
	
	//수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//조회수 업데이트
	public int setHitUpdate(BoardDTO boardDTO) throws Exception;
	
}
