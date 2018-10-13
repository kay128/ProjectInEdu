package lab27.vo;

public class CompanyVO {
	//COMPANY 테이블에 있는 목록들
	private int company_id;	//회사 id
	private String company_name;	//회사명
	private int read_count; //조회수 
	private String company_logo;	//로고
	private String company_type;	//업종
	private String company_area;	//분야
	private String company_ceo; //대표자
	private int company_year; //설립연도
	private String company_page; //홈페이지
	private String company_info; //회사소개
	private int company_emp;	//사원수
	private int company_money;	//맻룰액
	private int company_cap;	//자본금
	private String company_loc;	//소재지
	private int is_korea_ceo;	//한국계면 1 일본개면 -1
	
	//검색을 위한 추가적인 항목
	private int limit_year; //설립연도 검색 상한
	private String user_id; //관심목록을 확인하기 위해선 현재 사용자의 id를 확인해야한다. 
	
	//list를 찍어줄 때 추가적으로 필요한 항목
	private int recruit_now;//현재 모집 여부 1이면 모집중 0이면  x
	private int is_pavorite; //관심기업 여부 1이면 관심 기업, 0이면x
	private double star_avg; //별점 평균
	private int rating_count; //댓글 수
	
	//포맷팅을 위한 항목
	String company_cap_s;
	String company_money_s;
	
	




	CompanyVO(){}
	
	public void formatting() {
		company_cap_s="";
		company_money_s="";
		if(company_cap/100000000>0) {
			company_cap_s += (company_cap/100000000)+ "억";
		}
		if((company_cap%100000000)/10000>0 ) {
			company_cap_s += (company_cap%100000000)/10000+"만";
		}
		
		if(company_money/100000000>0) {
			company_money_s += (company_money/100000000)+ "억";
		}
		if((company_money%100000000)/10000>0) {
			company_money_s += (company_money%100000000)/10000+"만";
		}

	}
	
	public String getCompany_cap_s() {
		return company_cap_s;
	}



	public void setCompany_cap_s(String company_cap_s) {
		this.company_cap_s = company_cap_s;
	}




	
	public String getCompany_money_s() {
		return company_money_s;
	}

	public void setCompany_money_s(String company_money_s) {
		this.company_money_s = company_money_s;
	}

	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public String getCompany_logo() {
		return company_logo;
	}
	public void setCompany_logo(String company_logo) {
		this.company_logo = company_logo;
	}
	public String getCompany_type() {
		return company_type;
	}
	public void setCompany_type(String company_type) {
		this.company_type = company_type;
	}
	public String getCompany_area() {
		return company_area;
	}
	public void setCompany_area(String company_area) {
		this.company_area = company_area;
	}
	public String getCompany_ceo() {
		return company_ceo;
	}
	public void setCompany_ceo(String company_ceo) {
		this.company_ceo = company_ceo;
	}
	public int getCompany_year() {
		return company_year;
	}
	public void setCompany_year(int company_year) {
		this.company_year = company_year;
	}
	public String getCompany_page() {
		return company_page;
	}
	public void setCompany_page(String company_page) {
		this.company_page = company_page;
	}
	public String getCompany_info() {
		return company_info;
	}
	public void setCompany_info(String company_info) {
		this.company_info = company_info;
	}
	public int getCompany_emp() {
		return company_emp;
	}
	public void setCompany_emp(int company_emp) {
		this.company_emp = company_emp;
	}
	public int getCompany_money() {
		return company_money;
	}
	public void setCompany_money(int company_money) {
		this.company_money = company_money;
	}
	public int getCompany_cap() {
		return company_cap;
	}
	public void setCompany_cap(int company_cap) {
		this.company_cap = company_cap;
	}
	public String getCompany_loc() {
		return company_loc;
	}
	public void setCompany_loc(String company_loc) {
		this.company_loc = company_loc;
	}
	public int getIs_korea_ceo() {
		return is_korea_ceo;
	}
	public void setIs_korea_ceo(int is_korea_ceo) {
		this.is_korea_ceo = is_korea_ceo;
	}
	public int getLimit_year() {
		return limit_year;
	}
	public void setLimit_year(int limit_year) {
		this.limit_year = limit_year;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getRecruit_now() {
		return recruit_now;
	}
	public void setRecruit_now(int recruit_now) {
		this.recruit_now = recruit_now;
	}
	public int getIs_pavorite() {
		return is_pavorite;
	}
	public void setIs_pavorite(int is_pavorite) {
		this.is_pavorite = is_pavorite;
	}
	public double getStar_avg() {
		int start_int = (int)(this.star_avg*10);
		return start_int*0.1;
	}
	public void setStar_avg(double star_avg) {
		
		this.star_avg=star_avg;
	}
	public int getRating_count() {
		return rating_count;
	}
	public void setRating_count(int rating_count) {
		this.rating_count = rating_count;
	}
	
	//where문을 담기 위한 검색 가능 여부 확인
	public boolean is_searchable() {
		if((company_name==null || company_name.length()<1) && company_year<=0 && limit_year <=0
				&& (company_loc==null || company_loc.length()<1) && company_emp<=0 && company_money<=0 && company_cap<=0 &&is_korea_ceo==0) {
			return false;
		}
		
		return true;
		
	}


	//검색을 위한 생성자.
	public CompanyVO(String company_name, int company_year, int limit_year, int company_emp, int company_money, int company_cap,
			String company_loc, int is_korea_ceo) {
		super();
	
		this.company_year = company_year;
		this.company_emp = company_emp;
		this.limit_year = limit_year;
		this.is_korea_ceo = is_korea_ceo;
		if(company_name!=null && company_name.length()>=1) {
			this.company_name="'%"+company_name+"%'";
			
		}
		if(company_loc !=null && company_loc.length()>=1) {
			this.company_loc = "'%"+company_loc + "%'";
		}
		if(company_year>limit_year && limit_year!=0) {
			int temp = this.company_year;
			this.company_year = this.limit_year;
			this.limit_year = this.company_year;
		}
		
		if(company_money>0) {
			this.company_money=company_money*10000;
			
			
		}
		
		if(company_cap>0) {
			this.company_cap=company_cap*100000000;
			
			
		}
	
	}
}
