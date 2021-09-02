package com.sy.s4.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public  List<NoticeDTO> getList(){
		return noticeDAO.getList();
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) {
		return noticeDAO.getSelect(noticeDTO);
	}
}
