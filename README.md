# Spring4


## Board

### Notice

글번호, 글 제목, 글 내용, 작성자, 작성일, 조회수
  1      a      a      a   오늘      0
  2      a      a      a   오늘      0
  
1.   테이블 생성
   NOTICE
   NUM
   TITLE
   CONTENTS : textares
   WRITER
   REGDATE
   HITS
   
2.   Notice Sequence

3. 기능
	1) List
		/notice/list  GET방식
		/WEB-INF/views/board/list.jsp
	2) 상세
		/notice/select  GET방식
		/WEB-INF/views/board/select.jsp
	3) 글쓰기
		/notice/insert  GET방식
		/WEB-INF/views/board/Insert.jsp 		title, contents, writers
		/notice/insert  POST방식
		list page로 이동
	4) 삭제