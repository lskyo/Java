package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import action.GoddessAction;
import model.Goddess;

public class View {

	private static final String CONTEXT = "\n欢迎来到女神禁区：\n" + "下面是女神禁区的功能列表：\n"
			+ "[MAIN/M]:主菜单\n" + "[QUERY/Q]:查看全部女神的信息\n"
			+ "[GET/G]:查看某位女神的详细信息\n" + "[ADD/A]:添加女神的信息\n"
			+ "[UPDATE/U]:更新女神的信息\n" + "[DELETE/D]:删除女神的信息\n"
			+ "[SEARCH/S]:查询女神的信息（根据姓名、手机号来查询）\n" + "[EXIT/E]:退出女神禁区\n"
			+ "\n请选择：";

	private static final String OPERATION_MAIN = "MAIN";
	private static final String OPERATION_QUERY = "QUERY";
	private static final String OPERATION_GET = "GET";
	private static final String OPERATION_ADD = "ADD";
	private static final String OPERATION_UPDATE = "UPDATE";
	private static final String OPERATION_DELETE = "DELETE";
	private static final String OPERATION_SEARCH = "SEARCH";
	private static final String OPERATION_EXIT = "EXIT";

	// private static final String OPERATION_BREAK = "BREAK";

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		List<Map<String, Object>> params = null;// new ArrayList<Map<String,
												// Object>>();
		Map<String, Object> param = null;// new HashMap<String, Object>();
		String in = null;
		Goddess goddess = null;
		GoddessAction action = new GoddessAction();
		System.out.println(CONTEXT);

		while (scan.hasNext()) {
			in = scan.next().toString();
			if (OPERATION_EXIT.equals(in.toUpperCase())
					|| OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())) {
				System.out.println("您已成功退出女神禁区。");
				break;
			} else if (OPERATION_ADD.equals(in.toUpperCase())
					|| OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())) {
				goddess = new Goddess();
				System.out.println("请输入女神的[姓名]：");
				goddess.setUser_name(scan.next().toString());
				System.out.println("请输入女神的[性别]：");
				goddess.setSex(scan.nextInt());
				System.out.println("请输入女神的[年龄]：");
				goddess.setAge(scan.nextInt());
				System.out.println("请输入女神的[生日]，格式为yyyy-MM-dd：");
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = null;
				while (true) {
					try {
						birthday = sf.parse(scan.next().toString());
						goddess.setBirthday(birthday);
					} catch (ParseException e) {
						System.out.println("您输入的格式有误，请重新输入：");
						continue;
					}
					break;
				}
				System.out.println("请输入女神的[邮箱]：");
				goddess.setEmail(scan.next().toString());
				System.out.println("请输入女神的[手机号]：");
				goddess.setMobile(scan.next().toString());
				goddess.setIsdel(0);

				action.add(goddess);
				System.out.println("女神添加成功！");
				System.out.println(CONTEXT);
			} else if (OPERATION_QUERY.equals(in.toUpperCase())
					|| OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())) {
				List<Goddess> list = action.query();
				System.out.println("以下是所有存储的女神：");
				for (Goddess g : list) {
					System.out.println(g.getId() + "," + g.getUser_name());
				}
				System.out.println(CONTEXT);
			} else if (OPERATION_MAIN.equals(in.toUpperCase())
					|| OPERATION_MAIN.substring(0, 1).equals(in.toUpperCase())) {
				System.out.println(CONTEXT);
			} else if (OPERATION_GET.equals(in.toUpperCase())
					|| OPERATION_GET.substring(0, 1).equals(in.toUpperCase())) {
				System.out.println("请输入女神ID：");
				System.out.println(action.get(scan.nextInt()));
				System.out.println(CONTEXT);
			} else if (OPERATION_UPDATE.equals(in.toUpperCase())
					|| OPERATION_UPDATE.substring(0, 1)
							.equals(in.toUpperCase())) {
				goddess = new Goddess();
				System.out.println("请输入女神ID：");
				goddess.setId(scan.nextInt());
				System.out.println("请输入女神的[姓名]：");
				goddess.setUser_name(scan.next().toString());
				System.out.println("请输入女神的[性别]：");
				goddess.setSex(scan.nextInt());
				System.out.println("请输入女神的[年龄]：");
				goddess.setAge(scan.nextInt());
				System.out.println("请输入女神的[生日]，格式为yyyy-MM-dd：");
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = null;
				while (true) {
					try {
						birthday = sf.parse(scan.next().toString());
						goddess.setBirthday(birthday);
					} catch (ParseException e) {
						System.out.println("您输入的格式有误，请重新输入：");
						continue;
					}
					break;
				}
				System.out.println("请输入女神的[邮箱]：");
				goddess.setEmail(scan.next().toString());
				System.out.println("请输入女神的[手机号]：");
				goddess.setMobile(scan.next().toString());
				goddess.setIsdel(0);
				action.edit(goddess);
				System.out.println("女神修改成功！");
				System.out.println(CONTEXT);
			} else if (OPERATION_SEARCH.equals(in.toUpperCase())
					|| OPERATION_SEARCH.substring(0, 1)
							.equals(in.toUpperCase())) {
				System.out.println("请输入要查询名字【1】或手机号【2】：");
				Integer num = scan.nextInt();
				params = new ArrayList<Map<String, Object>>();
				param = new HashMap<String, Object>();
				if (num == 1) {
					System.out.println("请输入女神的名字：");
					param.put("name", "user_name");
					param.put("rela", "like");
					param.put("value", "'%" + scan.next().toString() + "%'");
				} else {
					System.out.println("请输入女神的电话：");
					param.put("name", "mobile");
					param.put("rela", "like");
					param.put("value", scan.next().toString());
				}
				params.add(param);
				List<Goddess> list = action.query(params);
				for (Goddess sg : list) {
					System.out.println(sg);
				}
				System.out.println(CONTEXT);
			} else if (OPERATION_DELETE.equals(in.toUpperCase())
					|| OPERATION_DELETE.substring(0, 1)
							.equals(in.toUpperCase())) {
				System.out.println("请输入要删除的女神的ＩＤ：");
				action.del(scan.nextInt());
				System.out.println("女神删除成功！");
				System.out.println(CONTEXT);
			} else {
				System.out.println("您输入的值为：" + in);
			}
		}
		System.out.println("欢迎下次光临！");
	}
}
