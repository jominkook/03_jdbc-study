package com.kyungbae.menu.view;


import com.kyungbae.menu.model.dto.MenuDto;

// 응답 결과를 출력하는 화면
public class PrintResultView {

    // 서비스 요청 성공 메시지 출력용 화면
    public void displaySuccessMessage(String code) {
        switch (code) {
            case "insert" -> System.out.println("메뉴 등록 성공");
            case "update" -> System.out.println("메뉴 수정 성공");
            case "delete" -> System.out.println("메뉴 삭제 성공");
        }
    }

    public void displayFailMessage(String code) {
        switch (code) {
            case "insert" -> System.out.println("메뉴 등록 실패");
            case "update" -> System.out.println("메뉴 수정 실패");
            case "delete" -> System.out.println("메뉴 삭제 실패");
            case "selectMenu" -> System.out.println("메뉴 조회 실패");
        }
    }

    public void displayMenu(MenuDto menu) {
        System.out.println(menu);
    }

}
