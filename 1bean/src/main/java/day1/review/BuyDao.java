package day1.review;

public class BuyDao {
	private String dbFactory;	//String타입의 프로퍼티
	
	public BuyDao(String dbFactory) {
		System.out.println("BuyDao 생성자**********");
		this.dbFactory=dbFactory;
	}
	public void setDbFactory(String dbFactory) {
		this.dbFactory = dbFactory;
	}
	
	public void buy() {
		System.out.println("dao buy()~~~");
		System.out.println(dbFactory +"를 이용하여 db에 연결합니다." );
	}

}
