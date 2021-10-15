package com.todo.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc, cate, due;
		int prior;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[�׸� �߰�]\n"
				+ "���� �Է� > ");
		
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.printf("�ߺ��� ������ �׸��� �ֽ��ϴ�.");
			return;
		}
		
		System.out.println("ī�װ� �Է� > ");
		cate = sc.next();
		
		sc.nextLine();
		System.out.println("���� �Է� > ");
		desc = sc.nextLine().trim();
		
		System.out.println("�������� �Է� (��/��/��) > ");
		due = sc.nextLine().trim();
		
		System.out.println("�߿䵵 �Է� (1. Critical, 2. High, 3. Medium, 4. Low) > ");
		prior = sc.nextInt();
		
		TodoItem t = new TodoItem(title, desc, cate, due, prior);
		if (list.addItem(t) > 0) {
			System.out.println("���ο� �׸��� �߰��Ǿ����ϴ�.");
		}
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		System.out.println("[�׸� ����]\n"
				+ "������ �׸��� ���� �Է� > ");
		int count = sc.nextInt();
		
		System.out.println("�׸� ��ȣ �Է� > ");
		for (int i = 0; i < count; i++) {
			int index = sc.nextInt();
			arr.add(index);
		}
		
		if (l.deleteItem(arr) > 0) {
			System.out.println("�׸��� ���ŵǾ����ϴ�.");
		}
	}
	
	public static void percItem(TodoList l) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[�׸� ���൵ �Է�]\n"
				+ "�׸� ��ȣ �Է� > ");
		int index =  sc.nextInt();
		
		System.out.println("���൵ �Է� (0-100) > ");
		int perc =  sc.nextInt();
		
		l.percItem(index, perc);
	}

	public static void setPrior(TodoList l) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[�׸� �߿䵵 �Է�]\n"
				+ "�׸� ��ȣ �Է� > ");
		int index = sc.nextInt();
		
		System.out.println("�߿䵵 �Է� (1. Critical, 2. High, 3. Medium, 4. Low) > ");
		int prior = sc.nextInt();
		
		l.setPrior(index, prior);
	}

	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[�׸� ����]\n"
				+ "�׸� ��ȣ �Է� > ");
		int num = sc.nextInt();

		System.out.println("���ο� ���� �Է� > ");
		String new_title = sc.next().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("�ߺ��� ������ �׸��� �ֽ��ϴ�.");
			return;
		}
		
		System.out.println("���ο� ī�װ� �Է� > ");
		String new_category = sc.next();
		
		sc.nextLine();
		System.out.println("���ο� ���� �Է� > ");
		String new_description = sc.nextLine().trim();
		
		//sc.nextLine();
		System.out.println("���ο� �������� �Է� (��/��/��) > ");
		String new_due_date = sc.nextLine().trim();
		
		System.out.println("���ο� �߿䵵 ���� (1. Critical, 2. High, 3. Medium, 4. Low) > ");
		int new_priority = sc.nextInt();

		TodoItem t = new TodoItem(new_title, new_description, new_category , new_due_date, new_priority);
		t.setId(num);
		if (l.editItem(t) > 0) {
			System.out.println("�׸��� �����Ǿ����ϴ�.");
		}
	}
	
	public static void completeItem(TodoList l) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		System.out.println("[�׸� �Ϸ� ó��]\n"
				+ "�Ϸ��� �׸��� ���� �Է� > ");
		int count = sc.nextInt();
		
		System.out.println("�׸� ��ȣ �Է� > ");
		for (int i = 0; i < count; i++) {
			int index = sc.nextInt();
			arr.add(index);
		}
		
		if (l.completeItem(arr) > 0) {
			System.out.println("�׸��� �Ϸ�Ǿ����ϴ�.");
		}
	}
	
	public static void uncompleteItem(TodoList l) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		System.out.println("[�׸� �̿Ϸ� ó��]\n"
				+ "�̿Ϸ��� �׸��� ���� �Է� > ");
		int count = sc.nextInt();
		
		System.out.println("�׸� ��ȣ �Է� > ");
		for (int i = 0; i < count; i++) {
			int index = sc.nextInt();
			arr.add(index);
		}
		
		if (l.uncompleteItem(arr) > 0) {
			System.out.println("�׸��� �̿Ϸ� ó���Ǿ����ϴ�.");
		}
	}
	
	public static void findList(TodoList l, String word) {
		int count = 0;
		for (TodoItem item : l.getList(word)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.println("�� " + count + "���� �׸��� ã�ҽ��ϴ�.");
	}
	
	public static void deleteByDate(TodoList l) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		// ��¥�� ���� �׸�� ã�Ƽ� ���̱�
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        String current_date = f.format(new Date());
		for (TodoItem item : l.getPastDate(current_date)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.println("�� " + count + "���� �׸��� ã�ҽ��ϴ�.\n\n");
		
		// ��¥�� ���� �׸�� �������� ����
		System.out.println("��¥�� ���� �׸���� �����Ͻðڽ��ϱ�? (yes/no) >");
		String decide = sc.next();
		
		if (decide.equals("yes")) {
			l.deleteByDate(current_date);
			System.out.println("��¥�� ���� �׸���� �����߽��ϴ�.");
		}
		
	}
	
	public static void findCateList(TodoList l, String word) {
		int count = 0;
		for (TodoItem item : l.getListCategory(word)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.println("�� " + count + "���� �׸��� ã�ҽ��ϴ�.");
	}
	
	public static void findPerc(TodoList l, int perc) {
		int count = 0;
		for (TodoItem item : l.getPerc(perc)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.println("�� " + count + "���� �׸��� ã�ҽ��ϴ�.");
	}
	
	public static void listCateAll(TodoList l) {
		int count = 0;
		
		for (String item : l.getCategories()) {
			System.out.println(item + " ");
			count++;
		}
		
		System.out.printf("�� %d���� ī�װ��� �����մϴ�.", count);
	}
	
	public static void listPriorAll(TodoList l) {
		System.out.printf("[��ü ���, �� %d��]\n", l.getCount());
		for (TodoItem item : l.getPrior()) {
			System.out.println(item.toString());
		}
	}

	public static void listAll(TodoList l) {
		System.out.printf("[��ü ���, �� %d��]\n", l.getCount());
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}
	
	public static void listAll(TodoList l, int num) {
		int count = 0;
		
		for (TodoItem item : l.getList(num)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.println("�� " + count + "���� �׸��� ã�ҽ��ϴ�.");
	}
	
	public static void listAll(TodoList l, String orderby, int ordering) {
		System.out.printf("[��ü ���, �� %d��]\n", l.getCount());
		for (TodoItem item : l.getOrderedList(orderby, ordering)) {
			System.out.println(item.toString());
		}
	}
}
