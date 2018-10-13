package book.member.dto;

public class Book {
	private String name;//å�̸�
	private int cost;//����
	private int amount;//����
	private int sale;//���� ����
	private int count;//�Ǹż���
	
	
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
	
//��ƿ�
	public boolean buyAmount(int num) {
		boolean isStop = false;
		
		if(this.amount<num) {
			System.out.println("��� �����մϴ�.");
			isStop = true;
			
		}else { this.amount -= num; }
		
		return isStop;
	}
	
	public void buyCount(int num) {
		this.count += num;
	}
	
//�̽�ȯ
	public String toString() {
        return "BookDto ["
            + "cost=" + cost
            + "amount=" + amount
            + "sale=" + sale
            + "count" + count
            + "]";
    }
	
}
