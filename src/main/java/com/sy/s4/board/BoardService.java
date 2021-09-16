package com.sy.s4.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sy.s4.util.Pager;

public interface BoardService {
	
	//List 가져오기
	public abstract List<BoardDTO> getList(Pager pager) throws Exception;
		
	//상세 페이지 가져오기
	public abstract BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
			
	//글쓰기
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception;
		
	//삭ㅈㅔ
	public int setDelete(BoardDTO boardDTO) throws Exception;
		
	//수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	
	
}
