package cookiesessionpage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//session购物车实例
public class SessionShoppingCart {
	
	//初始化购物车集合 Map<商品名称,数量>
	public static Map<String,Integer> map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//购物车逻辑
	//用session存储一个map，map中包含购物车信息
	public void shopadd(HttpServletRequest request,HttpServletResponse response,Integer id){
		
		//所有商品列表
		ArrayList<Shop> shoplist1 = shoplist();
		
		map = (Map<String, Integer>) request.getSession().getAttribute("cart");
		
		//判断购物车是否为空，如果为空则创建购物车集合
		if(map==null) {
			map = new LinkedHashMap<String, Integer>();
			request.getSession().setAttribute("cart",map);
		}
		
		//判断购物车内是否包含改商品，如果存在则数量加1
		if(map.containsKey(shoplist1.get(id).getShopname())) {
			map.put(shoplist1.get(id).getShopname(),map.get(shoplist1.get(id).getShopname())+1);
		}else {	//不存在则数量为1
			map.put(shoplist1.get(id).getShopname(),1);
		}
		
	}
	
	public Map<String,Integer> getShoppingCart(){
		return map;
	}
	
	//生成商品列表
	public ArrayList<Shop> shoplist() {
		//模拟一个商品列表
		ArrayList<Shop> list1 = new ArrayList();
		
		list1.add(new Shop(0,"商品1",5,150));
		list1.add(new Shop(1,"商品2",3,300));
		list1.add(new Shop(2,"商品3",10,100));
		
		return list1;
	}

}
