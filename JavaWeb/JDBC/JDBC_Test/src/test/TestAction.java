package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Goddess;
import action.GoddessAction;

public class TestAction {

	public static void main(String[] args) throws Exception {
		GoddessAction action = new GoddessAction();

		// 查询
		// List<Goddess> result = action.query();
		// for (int i = 0; i < result.size(); i++) {
		// System.out.println(result.get(i).getId()
		// + result.get(i).getUser_name());
		// }

		Goddess g = new Goddess();
		g.setId(4);
		g.setUser_name("小青");
		g.setSex(1);
		g.setAge(25);
		g.setBirthday(new Date());
		g.setEmail("xiaoqing");
		g.setMobile("15612345678");
		g.setIsdel(0);

		// 新增
		// action.add(g);

		// action.edit(g);

		// action.del(5);

		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "user_name");
		map.put("rela", "=");
		map.put("value", "'小美'");
		params.add(map);
		
		List<Goddess> result = action.query(params);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId()
					+ result.get(i).getUser_name());
		}

	}

}
