package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardGoodCheckCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null ? 0 : Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO dao = new BoardDAO();
		
		// 글 조회수 1회 증가시키기(조회수 중복방지처리 - 세션사용 : 'board'+ 고유번호 값을 객체배열(arraylist)에 추가시킨다.
		HttpSession session = request.getSession();
		ArrayList<String> goodIdx=(ArrayList)session.getAttribute("sGoodIdx");
		
		if(goodIdx==null) {
			goodIdx=new ArrayList<>();
		}
		String imsiGoodIdx="boardGood"+idx;
		if(!goodIdx.contains(imsiGoodIdx)) {
			dao.setGoodUpdate(idx);
			goodIdx.add(imsiGoodIdx);
		}
		session.setAttribute("sGoodIdx", goodIdx);
		
		BoardVO vo = dao.getBoardContent(idx);
		
		request.setAttribute("vo", vo);
	}

}
