package lab27.vo;

public class Paging {
		private StringBuffer page_html; 	//넘겨주는 html 값. sublist를 처리한다.
		private int current_page;			//현재 page 값. 해당 값으로 돌아간다.
		
		private int total_count;			//전체 post 갯수 
		private int st_inlist; 				//list내 시작 값(list 번호)
		private int ed_inlist;				//list내 종료 값(list 번호)
		int term_inlist = 5; 				//1 페이지 출력 간격
		
		int st_page;						//page 시작 값(page 번호)
		int ed_page;						//page 종료 값(page 번호_출력 페이지 번호 중 마지막)
		int last_page;						//마지막 page 값(전체 페이지 리스트 중)
		int term_page = 5;					//1 페이지 리스트 출력 간격
		
		//목표 형태: "<a href='IteratorAction.action?start=0'>1</a> | <a href='IteratorAction.action?start=5'>2</a>";
		//ed > 5   ed 버튼(무조건 끝으로)
		//st == 0    st 버튼(무조건 처음으로) X 1 2 3 4 5
		//0-4 5-9 10-14
		//i=0 ~ 4
		//current_page
		
		public Paging(int current_page, int total_count, String board_name){
			//현재 페이지, 전체 post 갯수, 보드 명을 받아온다.
			
			this.current_page = current_page;								//현재 페이지
			System.out.println("현재 페이지: "+current_page);
			
			this.total_count = total_count;									//post 전체 갯수
			
			System.out.println("전체 목록 길이: "+total_count);
			
			last_page = (int) Math.ceil((float)total_count/term_inlist);	//총 페이지 갯수 계산
			System.out.println("last_page: " + last_page);
			if(last_page == 0){												//목록이 비었다면, page 수를 1로 설정
				last_page = 1;
			}
			if(current_page > last_page){									//예외처리. 혹시 전체 페이지가 현재 페이지 보다 작다면! 
				current_page = last_page;
			}
			
			st_inlist = (current_page-1)*term_inlist;						//시작 post 번호_현재 출력 페이지 내(결과 내 list index번호)
			ed_inlist = st_inlist + term_inlist-1;							//마지막 post 번호_현재 출력 페이지 내
			
			
			st_page = (int)((current_page-1)/term_page)*term_page+1; 		//시작 페이지 번호_페이지 목록 중
			ed_page = st_page + term_page - 1;								//마지막 페이지 번호_페이지 목록 중
			
			System.out.println("ed_page? 1 "+ed_page);

			if(ed_page > last_page){										//계산된 마지막 페이지 번호가 총 페이지 수 보다 길 경우. 오류 방지
				ed_page = last_page;
			}
			
			System.out.println("ed_page? 2 "+ed_page);
			
			page_html = new StringBuffer();
			
			String startEx = "<ul class=\"pagination justify-content-center\" style=\"margin: 20px 0\">";
			page_html.append(startEx);
			String endEx = "</ul>";
			String st_button = "<li class=\"page-item\"><a class=\"page-link\"href=\"market.lab27?command=market_list&current_page=1\">First</a></li>";
			String ed_button = "<li class=\"page-item\"><a class=\"page-link\"href='market.lab27?command=market_list&current_page="+last_page+"'>End</a></li>";

			if(current_page > 1){											//현재 페이지가 1보다 크면, 처음으로 버튼 생성
				page_html.append(st_button);
			}
			
			if(current_page > term_page){									//현재 페이지가 1번의 페이지 리스트 이후에 있으면, 이전으로 버튼 생성
				page_html.append("<li class=\"page-item\"><a class=\"page-link\"href='market.lab27?command=market_list&current_page="+(st_page-1)+"'>Previous</a></li>");
			}			
			
			for(int i = st_page; i <= ed_page; i++){						//첫 페이지부터 마지막 페이지 까지(현 페이지 리스트 목록 내) 를 a링크 담아 출력하기
				System.out.println(i+"번째 반복");
				if(i==current_page){										//현재페이지. 링크가 없다
					page_html.append("<li class=\"page-item\"><a class=\"page-link\">"+i+"</a></li>");
				}else{														//현재 페이지 이외의 페이지. 링크를 담아야한다.
					page_html.append("<li class=\"page-item\"><a class=\"page-link\"href='market.lab27?command=market_list&current_page="+i+"'>"+i+"</a></li>");
				}
				if(i == last_page){											//만약, 최종 페이지 라면 출력중지!
					break;
				}
				
			}
			
			if(last_page-st_page >= term_page){								//최종페이지에서 현재 페이지리스트의 첫번째 페이지 값을 뺐을 때 페이지 리스트 간격보다 크다면 다음으로 버튼생성
				page_html.append("<li class=\"page-item\"><a class=\"page-link\"href='market.lab27?command=market_list&current_page="+(ed_page+1)+"'>Next</a></li>");
			}
			
			if(current_page < last_page){									//현재 페이지가 최종 페이지 보다 작으면 마지막으로 버튼을 생성
				page_html.append(ed_button);
			}
			page_html.append(endEx);
			
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

		public int getTotal_count() {
			return total_count;
		}

		public void setTotal_count(int total_count) {
			this.total_count = total_count;
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
