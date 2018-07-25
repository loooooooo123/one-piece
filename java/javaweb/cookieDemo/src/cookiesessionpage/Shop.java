package cookiesessionpage;

//JavaBean商品类
public class Shop {
	
	//商品id
	private int id;
	//商品名
	private String shopname;
	//商品数量
	private int count;
	//商品价格
	private int money;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//构造函数
	public Shop(int id,String shopname,int count,int money){
		this.id=id;
		this.shopname=shopname;
		this.count=count;
		this.money=money;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the shopname
	 */
	public String getShopname() {
		return shopname;
	}

	/**
	 * @param shopname the shopname to set
	 */
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	

}
