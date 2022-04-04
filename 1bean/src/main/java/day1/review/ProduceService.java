package day1.review;

public class ProduceService {
	private ProduceDao dao;
	public ProduceService() {
		System.out.println("ProduceService 기본 생성자****");
	}

	public void setDao(ProduceDao dao) {	//의존관계 주입
		this.dao = dao;
	}
	
	public void produce() {
		System.out.println("service produce()~~~");
		dao.produce();
	}
}
