package com.sy.s4.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.s4.board.BoardDAO;
import com.sy.s4.board.BoardDTO;
import com.sy.s4.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.sy.s4.board.qna.QnaDAO.";
	
	//답글
	public int setReply(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setReply", qnaDTO);
	}
	
	@Override
	public Long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getSelect", boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setInsert", boardDTO);
	}

	@Override
	public int setDelete(Long num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"setDelete", num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	
	
	public int setReplyUpdate(QnaDTO qnaDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setReplyUpdate", qnaDTO);
	}

	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"setHitUpdate", boardDTO);
	}
	
}
