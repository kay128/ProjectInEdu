package action;

public class Paging {
	
	
	private StringBuffer page_html; //넘겨주는 html 값
	
	private int current_page;
	
	private int total_inlist;
	
	private int st_inlist; // 페이지 내 리스트 관련
	private int ed_inlist;
	int term_inlist = 5; //페이지 관련
	
	int st_page;
	int ed_page;
	int last_page;
	int term_page = 5;
	
	//목표 형태: "<a href='IteratorAction.action?start=0'>1</a> | <a href='IteratorAction.action?start=5'>2</a>";
	//ed > 5   ed 버튼(무조건 끝으로)
	//st == 0    st 버튼(무조건 처음으로) X 1 2 3 4 5
	//0-4 5-9 10-14
	//i=0 ~ 4
	//current_page
	
	public Paging(int current_page, int total_inlist, String bdname){
		//초기화
		
		this.current_page = current_page;
		System.out.println("현재 페이지: "+current_page);
		
		this.total_inlist = total_inlist;
		
		System.out.println("전체 크기: "+total_inlist);
		
		last_page = (int) Math.ceil((float)total_inlist/term_inlist);
		System.out.println("last_page: " + last_page);
		if(last_page == 0){
			last_page = 1;
		}
		if(current_page > last_page){
			current_page = last_page;
		}
		
		st_inlist = (current_page-1)*term_inlist;
		ed_inlist = st_inlist + term_inlist-1;
		
		st_page = (int)((current_page-1)/term_page)*term_page+1; //1부터
		ed_page = st_page + term_page - 1;
		
		System.out.println("ed_page? 1 "+ed_page);

		if(ed_page > last_page){
			ed_page = last_page;
		}
		
		System.out.println("ed_page? 2 "+ed_page);
		
		page_html = new StringBuffer();
		
		String st_button = "<a href='written_list.action?"+bdname+"_current_page=1'><font style='font-size:12pt;'>[First]</font></a> &nbsp;";
		String ed_button = "<a href='written_list.action?"+bdname+"_current_page="+last_page+"'><font style='font-size:12pt;'>[End]</font></a>";
		/*<img src='/langlang/img/before.jpg' alt='go first' height='10p' width='10px'>*/
		if(current_page > 1){
			page_html.append(st_button);
		}
		
		if(current_page > term_page){
			page_html.append("<a href='written_list.action?"+bdname+"_current_page="+(st_page-1)+"'><font style='font-size:12pt;'>[Before]</font></a>&nbsp;");
		}			
		
		for(int i = st_page; i <= ed_page; i++){
			System.out.println(i+"번째 반복");
			if(i==current_page){
				page_html.append("<font style='weight:bold; font-size:16pt; color: rgb(249, 226, 134); text-shadow: -2px -2px 0 rgb(0, 0, 0);'>"+i+"</font>&nbsp;");
			}else{
				page_html.append("<a href='written_list.action?"+bdname+"_current_page="+i+"'><font style='font-size:12pt;'>"+i+"</font></a>&nbsp;");
			}
			if(i == last_page){
				break;
			}
			
		}
		
		if(last_page-st_page >= term_page){
			page_html.append("<a href='written_list.action?"+bdname+"_current_page="+(ed_page+1)+"'><font style='font-size:12pt;'>[After]</font></a>&nbsp;");
		}
		
		if(current_page < last_page){
			page_html.append(ed_button);
		}
		
	}

	public StringBuffer getPage_html() {
		return page_html;
	}

	public void setPage_html(StringBuffer page_html) {
		this.page_html = page_html;
	}

	public int getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}

	public int getTotal_inlist() {
		return total_inlist;
	}

	public void setTotal_inlist(int total_inlist) {
		this.total_inlist = total_inlist;
	}

	public int getSt_inlist() {
		return st_inlist;
	}

	public void setSt_inlist(int st_inlist) {
		this.st_inlist = st_inlist;
	}

	public int getEd_inlist() {
		return ed_inlist;
	}

	public void setEd_inlist(int ed_inlist) {
		this.ed_inlist = ed_inlist;
	}

	public int getTerm_inlist() {
		return term_inlist;
	}

	public void setTerm_inlist(int term_inlist) {
		this.term_inlist = term_inlist;
	}

	public int getSt_page() {
		return st_page;
	}

	public void setSt_page(int st_page) {
		this.st_page = st_page;
	}

	public int getEd_page() {
		return ed_page;
	}

	public void setEd_page(int ed_page) {
		this.ed_page = ed_page;
	}

	public int getLast_page() {
		return last_page;
	}

	public void setLast_page(int last_page) {
		this.last_page = last_page;
	}

	public int getTerm_page() {
		return term_page;
	}

	public void setTerm_page(int term_page) {
		this.term_page = term_page;
	}
	
	
	
}
