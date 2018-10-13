package book.member.dto;

public class Book {
	private String name;//책이름
	private int cost;//가격
	private int amount;//수량
	private int sale;//할인 여부
	private int count;//판매수량
	
	
	public Book() {
	
	}

	public Book(String name, int cost, int amount, int sale, int count) {
		this.name = name;
		this.cost = cost;
		this.amount = amount;
		this.sale = sale;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
//김아영
	public boolean buyAmount(int num) {
		boolean isStop = false;
		
		if(this.amount<num) {
			System.out.println("재고가 부족합니다.");
			isStop = true;
			
		}else { this.amount -= num; }
		
		return isStop;
	}
	
	public void buyCount(int num) {
		this.count += num;
	}
	
//이승환
	public String toString() {
        return "BookDto ["
            + "cost=" + cost
            + "amount=" + amount
            + "sale=" + sale
            + "count" + count
            + "]";
    }
	
}
