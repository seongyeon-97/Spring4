package com.sy.s4.board.notice;

import java.util.List;

import com.sy.s4.board.BoardDTO;
import com.sy.s4.board.BoardFilesDTO;

public class NoticeDTO extends BoardDTO{
	// is a 관계, has a 관계
	private List<BoardFilesDTO> files;

	public List<BoardFilesDTO> getFiles() {
		return files;
	}

	public void setFiles(List<BoardFilesDTO> files) {
		this.files = files;
	}
	
	
}
