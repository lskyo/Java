package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Goddess;
import dao.GoddessDao;

public class GoddessAction {
	
	public void add(Goddess goddess) throws Exception{
		GoddessDao dao = new GoddessDao();
		dao.addGoddess(goddess);
		
	}
	
	public Goddess get(Integer id) throws SQLException{
		GoddessDao dao = new GoddessDao();
		return dao.get(id);
	}
	
	public void edit(Goddess goddess) throws Exception{
		GoddessDao dao = new GoddessDao();
		dao.updateGoddess(goddess);
		
	}

	public void del(Integer id) throws SQLException{
		GoddessDao dao = new GoddessDao();
		dao.delGoddess(id);
	}
	
	public List<Goddess> query() throws Exception{
		GoddessDao dao = new GoddessDao();
		return dao.query();
	}
	
	public List<Goddess> query(List<Map<String, Object>> params) throws Exception{
		GoddessDao dao = new GoddessDao();
		return dao.query(params);
	}
	
	
//	public static void main(String[] args) throws Exception{
//		GoddessDao g = new GoddessDao();
//		
////		List<Goddess> result = g.query("美" , "187");
//		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("name", "user_name");
//		param.put("rela", "like");
//		param.put("value", "'%美%'");
//		params.add(param);
//		param = new HashMap<String, Object>();
//		param.put("name", "mobile");
//		param.put("rela", "like");
//		param.put("value", "'%123456%'");
//		params.add(param);
//		List<Goddess> result = g.query(params);
//		for(Goddess goddess : result){
//			System.out.println(goddess);
//		}
//		
//		
//		//查询
////		List<Goddess> gs = g.query();
////		for(Goddess goddess : gs){
////			System.out.println(goddess.getUser_name() + "," + goddess.getAge());
////		}
//		
//		//添加
////		Goddess g1 = new Goddess();
////		g1.setUser_name("小夏");
////		g1.setAge(21);
////		g1.setSex(1);
////		g1.setBirthday(new Date());
////		g1.setEmail("xiaoxia@qq.com");
////		g1.setMobile("18712345678");
////		g1.setUpdate_user("myadmin");
////		g1.setIsdel(1);
////		g1.setId(3);
////		g.addGoddess(g1);
//		
//		//获取
////		Goddess g2 = g.get(1);
////		System.out.println(g2);
//		
//		
//		//更新
////		g.updateGoddess(g1);
//		
//		
//		//删除
////		g.delGoddess(3);
//		
//		
//	}
}
