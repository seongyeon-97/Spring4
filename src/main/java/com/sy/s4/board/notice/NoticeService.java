package com.sy.s4.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sy.s4.board.BoardDTO;
import com.sy.s4.board.BoardFilesDTO;
import com.sy.s4.board.BoardService;
import com.sy.s4.board.CommentsDTO;
import com.sy.s4.util.FileManager;
import com.sy.s4.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	public int setCommentDelete(CommentsDTO commentsDTO) throws Exception{
		return noticeDAO.setCommentDelete(commentsDTO);
	}
	
	public List<CommentsDTO> getCommentList(CommentsDTO commentsDTO, Pager pager) throws Exception{
		pager.setPerPage(5L);
		pager.makeRow();
		pager.makeNum(noticeDAO.getCommentCount(commentsDTO));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("comments", commentsDTO);
		map.put("pager", pager);
		return noticeDAO.getCommentList(map);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		Long totlaCount = noticeDAO.getCount(pager); 
		pager.makeNum(totlaCount);
		pager.makeRow();
		return noticeDAO.getList(pager);
	}
	
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) throws Exception{
		return noticeDAO.getFiles(boardDTO);
	}
	
	public CommentsDTO getCommentSelect(CommentsDTO commentsDTO) throws Exception{
		return noticeDAO.getCommentSelect(commentsDTO);
	}
	
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub		
		noticeDAO.setHitUpdate(boardDTO);
		return noticeDAO.getSelect(boardDTO);
	}

	public int setComment(CommentsDTO commentsDTO) throws Exception{
		return noticeDAO.setComment(commentsDTO);
	}
		
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
		//1. 받아온 file 저장하기 위해 어느 폴더에 저장할 것인지 설정
		String realPath = this.servletContext.getRealPath("/resources/upload/notice");			
		System.out.println(realPath);
		
		File file = new File(realPath);
		
		System.out.println("before num : " + boardDTO.getNum());
		
		int result = noticeDAO.setInsert(boardDTO);
		
		System.out.println("after num : " + boardDTO.getNum());
		
		//max()
		
		for(MultipartFile multipartFile : files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			System.out.println(fileName);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			
			result = noticeDAO.setFile(boardFilesDTO);
		}
		return result; 
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		String realPath = servletContext.getRealPath("/resources/upload/notice");
		List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		
		for(int i =0; i<ar.size(); i++) {
			File file = new File(realPath, ar.get(i).getFileName());
			file.delete();
		}
		
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}
	
	
}
