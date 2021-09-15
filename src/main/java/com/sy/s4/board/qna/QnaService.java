package com.sy.s4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sy.s4.board.BoardDTO;
import com.sy.s4.board.BoardFilesDTO;
import com.sy.s4.board.BoardService;
import com.sy.s4.util.FileManager;
import com.sy.s4.util.Pager;

@Service
public class QnaService implements BoardService{
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	//답글
	public int setReply(QnaDTO qnaDTO) throws Exception {
		//1. 부모의 정보 조회해오기
		QnaDTO parent = (QnaDTO)qnaDAO.getSelect(qnaDTO);
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. update
		int result = qnaDAO.setReplyUpdate(parent);
		
		//3. insert
		result = qnaDAO.setReply(qnaDTO);
		
		return result;
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		Long totlaCount = qnaDAO.getCount(pager);
		pager.makeNum(totlaCount);
		pager.makeRow();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}
	
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) throws Exception{
		return qnaDAO.getFiles(boardDTO);
	}
	
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		String realPath = this.servletContext.getRealPath("/resources/upload/qna");			
		System.out.println(realPath);
		
		File file = new File(realPath);
		
		System.out.println("before num : " + boardDTO.getNum());
		
		int result = qnaDAO.setInsert(boardDTO);
		
		System.out.println("after num : " + boardDTO.getNum());
		
		//max()
		
		for(MultipartFile multipartFile : files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			System.out.println(fileName);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			
			result = qnaDAO.setFile(boardFilesDTO);
		}
		return result; 
	}

	@Override
	public int setDelete(Long num) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setUpdate(boardDTO);
	}

	
	
}
