package utils;

public class BoardPage {
	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
		String pagingStr = "";
		
		int totalPages = (int)(Math.ceil(((double)totalCount / pageSize)));
		
		
		int pageTemp = (((pageNum-1) / blockPage) * blockPage) + 1;
		
		
		if(pageTemp != 1) {
			pagingStr += "<a href='"+reqUrl+"?pageNum=1&sort=desc'>[첫페이지]</a>";
			pagingStr +="&nbsp;";
			pagingStr +="<a href='"+reqUrl+"?pageNum="+(pageTemp - 1)+"&sort=desc'>[이전블록]</a>";
		}
		
		int blockCount = 1;
		while(blockCount <= blockPage && pageTemp <= totalPages) {
			
			if(pageTemp == pageNum) {
				pagingStr += "&nbsp;" + pageTemp + "&nbsp;";
			}else{
				pagingStr += "&nbsp;<a href='"+reqUrl+"?pageNum="+pageTemp+"&sort=desc'>"+pageTemp+"</a>&nbsp;";
			}
			
			pageTemp++;
			blockCount++;
		}
		
		if(pageTemp <= totalPages) {
			pagingStr += "<a href='"+reqUrl+"?pageNum="+pageTemp+"&sort=desc'>[다음블록]</a>&nbsp;";
			pagingStr +="&nbsp;";
			pagingStr +="<a href='"+reqUrl+"?pageNum="+totalPages+"&sort=desc'>[마지막페이지]</a>";
		}
		
		
		
		return pagingStr;	
	}
	

}
