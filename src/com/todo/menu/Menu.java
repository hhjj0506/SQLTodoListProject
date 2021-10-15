package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("--- TODO List 명령어 사용법 ---");
        System.out.println("add - 항목을 추가합니다.");
        System.out.println("del - 항목을 삭제합니다.");
        System.out.println("edit - 항목을 수정합니다.");
        System.out.println("comp - 항목을 완료 처리합니다.");
        System.out.println("uncomp - 항목을 미완료 처리합니다.");
        System.out.println("del_date - 이미 목표 날짜가 지난 항목들을 보이고 삭제할지 선택합니다.");
        System.out.println("percent - 항목의 진행도를 퍼센트로 입력합니다.");
        System.out.println("prior - 항목의 중요도를 설정합니다.");
        System.out.println("find - 키워드를 입력하면 제목과 내용 중 해당 키워드를 포함하고 있는 항목들이 출력됩니다.");
        System.out.println("find_cate - 키워드를 입력하면 카테고리 중 해당 키워드를 포함하고 있는 항목들이 출력됩니다.");
        System.out.println("ls - 저장된 모든 항목들을 보입니다.");
        System.out.println("ls_perc - 가장 많이 진행된 순서대로 항목들을 출력합니다.");
        System.out.println("ls_comp - 완료된 모든 항목들을 출력합니다.");
        System.out.println("ls_prior - 중요한 항목들을 순서대로 출력합니다.");
        System.out.println("ls_cate - 현재 등록되어있는 모든 카테고리들을 중복되지 않게 출력합니다.");
        System.out.println("ls_name - 저장된 모든 항목들을 제목순으로 정렬하여 보입니다.");
        System.out.println("ls_name_desc - 저장된 모든 항목들을 제목역순으로 정렬하여 보입니다.");
        System.out.println("ls_date - 저장된 모든 항목들을 날짜순으로 정렬하여 보입니다.");
        System.out.println("ls_date_desc - 저장된 모든 항목들을 날짜역순으로 정렬하여 보입니다.");
        System.out.println("exit - 프로그램을 종료합니다.");
    }

	public static void prompt() {
		System.out.println("\n명령어 입력 > ");
	}
}
