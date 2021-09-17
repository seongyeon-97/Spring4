package com.sy.s4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.sy.s4.board.BoardFilesDTO;

@Component
public class FileDown extends AbstractView{
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		//model -> Controller의 model
		
		//폴더명
		String board = (String)model.get("board");
		
		//파일명
		BoardFilesDTO boardFilesDTO = (BoardFilesDTO)model.get("dto");
		
		//realPath 작업
		board = request.getSession().getServletContext().getRealPath("/resources/upload/" + board);
		
		//파일의 정보를 담고 있는 파일객체 준비
		File file = new File(board, boardFilesDTO.getFileName());
		
		//한글처리
		response.setCharacterEncoding("UTF-8");
		
		//파일의 크기 정보 저정 후 보내줄수 있게
		response.setContentLength((int)file.length());
		
		//파일 다운시 파일 이름 인코딩
		//String downName = URLEncoder.encode(boardFilesDTO.getOriName(), "UTF-8");
		String fileName = boardFilesDTO.getFileName();
		String downName = fileName.substring(fileName.lastIndexOf("_")+1);
		
		//response header 설정
		response.setHeader("Content-DisPosition", "attachment;fileName=\"" + downName + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//파일을 읽이서 client에 전송 후 자원 끊기
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		FileCopyUtils.copy(fi, os);
		os.close();
		fi.close();
		
		
	}
	
}
