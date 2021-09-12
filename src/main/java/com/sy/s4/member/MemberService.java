package com.sy.s4.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int setDelete(String id) throws Exception{
		return memberDAO.setDelete(id);
	}
	
	public int setUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.setUpdate(memberDTO);
	}
	
	public int setJoin(MemberDTO memberDTO) throws Exception{
		return memberDAO.setJoin(memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public MemberDTO getIdCheck(MemberDTO memberDTO) throws Exception{
		return memberDAO.getIdCheck(memberDTO);
	}
}
