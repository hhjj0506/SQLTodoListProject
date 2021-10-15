package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		//l.importData("todolist.txt");
		boolean isList = false;
		boolean quit = false;

		Menu.displaymenu();
		do {
			Menu.prompt();
			isList = false;
			String choice = sc.next();
			switch (choice) {
			
			case "help":
				Menu.displaymenu();
				break;
			
			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "del_date":
				TodoUtil.deleteByDate(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "find":
				String s = sc.nextLine().trim();
				TodoUtil.findList(l, s);
				break;
				
			case "find_cate":
				String s1 = sc.nextLine().trim();
				TodoUtil.findCateList(l, s1);
				break;
				
			case "comp":
				TodoUtil.completeItem(l);
				break;
				
			case "uncomp":
				TodoUtil.uncompleteItem(l);
				break;
			
			case "percent":
				TodoUtil.percItem(l);
				break;
				
			case "prior":
				TodoUtil.setPrior(l);
				break;
			
			case "ls_prior":
				System.out.println("�߿䵵������ �����Ͽ����ϴ�.");
				TodoUtil.listPriorAll(l);
				break;
				
			case "ls_perc":
				System.out.println("���൵������ �����Ͽ����ϴ�.");
				TodoUtil.listPercent(l);
				break;
				
			case "ls_comp":
				TodoUtil.listAll(l, 1);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;
				
			case "ls_cate":
				TodoUtil.listCateAll(l);
				break;

			case "ls_name":
				System.out.println("��������� �����Ͽ����ϴ�.");
				TodoUtil.listAll(l, "title", 1);
				break;

			case "ls_name_desc":
				System.out.println("���񿪼����� �����Ͽ����ϴ�.");
				TodoUtil.listAll(l, "title", 0);
				break;
				
			case "ls_date":
				System.out.println("��¥������ �����Ͽ����ϴ�.");
				TodoUtil.listAll(l, "due_date", 1);
				break;
				
			case "ls_date_desc":
				System.out.println("��¥�������� �����Ͽ����ϴ�.");
				TodoUtil.listAll(l, "due_date", 0);
				break;

			case "exit":
				quit = true;
				break;

			default:
				System.out.println("��Ȯ�� ��ɾ �Է��ϼ���. (���� - help)");
				break;
			}
			
			if(isList) TodoUtil.listAll(l);
		} while (!quit);
		System.out.println("���α׷��� �����մϴ�.");
	}
}
