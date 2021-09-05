package com.sy.s4.notice;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sy.s4.MyJunitTest;

public class NoticeDAOTest extends MyJunitTest{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void getList() {
		List<NoticeDTO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void getSelect() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1);
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		
	}
	//@Test
	public void setUpdate() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(21L);
		noticeDTO.setTitle("s21");
		noticeDTO.setContents("Hello");
		noticeDTO.setWriter("kaki");
		int result = noticeDAO.setUpdate(noticeDTO);
		assertNotEquals(0, result);
	}
	
	@Test
	public void setInsert() throws Exception {
		Random random = new Random();
		
		for(int i =0; i<200; i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("title"+i);
			noticeDTO.setContents("contents"+i);
			noticeDTO.setWriter("writer"+i);
			
			int result = noticeDAO.setInsert(noticeDTO);
			
			if(i%10==0){
				Thread.sleep(500);
			}

		}
		System.out.println("-------------finish---------------");
	}
	
}
