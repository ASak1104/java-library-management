package com.dev_course.library;

public enum LibraryMessage {
    MOD_SCREEN("""
            Q. 모드를 선택해주세요.
            1. 일반 모드
            2. 테스트 모드"""),
    FUNCTION_SCREEN("""
            Q. 사용할 기능을 선택해주세요.
            0. 프로그램 종료
            1. 도서 등록
            2. 전체 도서 목록 조회
            3. 제목으로 도서 검색
            4. 도서 대여
            5. 도서 반납
            6. 도서 분실
            7. 도서 삭제"""),
    EXIT("[System] 프로그램을 종료합니다."),
    INVALID_FUNCTION("[System] 사용할 수 없는 기능입니다.\n"),
    INVALID_INPUT("[System] 잘못된 입력 입니다.\n"),
    CREATE_BOOK("[System] 도서 등록 메뉴로 넘어갑니다.\n"),
    DELETE_BOOK("[System] 도서 삭제 처리 메뉴로 넘어갑니다.\n"),
    LIST_BOOK("[System] 전체 도서 목록입니다.\n"),
    END_LIST("[System] 도서 목록 끝\n"),
    FIND_BOOK_BY_TITLE("[System] 제목으로 도서 검색 메뉴로 넘어갑니다.\n"),
    READ_CREATE_BOOK_TITLE("Q. 등록할 도서 제목을 입력하세요."),
    READ_CREATE_BOOK_AUTHOR("Q. 작가 이름을 입력하세요."),
    READ_CREATE_BOOK_PAGES("Q. 페이지 수를 입력하세요."),
    READ_DELETE_BOOK_ID("Q. 삭제 처리할 도서번호를 입력하세요");


    private final String msg;

    LibraryMessage(String msg) {
        this.msg = msg;
    }

    public String msg() {
        return msg;
    }
}
