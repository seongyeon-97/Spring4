package com.sy.s4.board;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sy.s4.MyJunitTest;
import com.sy.s4.board.notice.NoticeDAO;

public class CommentDAOTest2 extends MyJunitTest{
	
	@Autowired
	NoticeDAO noticeDAO;
	
	@Test
	public void test() throws Exception {
		for(int i = 0; i<100; i++) {
			CommentsDTO commentsDTO = new CommentsDTO();
			commentsDTO.setNum(481L);
			commentsDTO.setWriter("t1");
			commentsDTO.setContents("comments"+i);
			commentsDTO.setBoard("N");
			noticeDAO.setComment(commentsDTO);
			if(i%10 == 0) {
				Thread.sleep(1000);
			}
		}
		System.out.println("finish");
	}

}
