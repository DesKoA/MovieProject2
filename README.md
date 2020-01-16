# !!!Commit and Push 하기전 반드시 Pull부터 해주세요!!!
1. MovieProject 우클릭 -> Team -> 위에있는 Pull 클릭
2. Commit and push시 Message입력


# 추가 해야 하는 사항
1. 

2.

3.

4.

5.

## 구조

## 패키지
- src.data > 클래스들의 필드, 생성자, 게터 세터, toString...
- src.db > 클래스들의 SQL문
- src.ui > UI구현 클래스
- src.test > 기능 테스트

## 폴더
- files > sql, image등의 파일들을 관리
- lib > jar등 필요한 path 등록

## 흐름도
1. 첫 시작시 메인화면(로그인 or 영화 목록 보여주기) 

2. 

3.

4.

5.

## 참고코드
-- 폰트 계단 현상 방지
System.setProperty("awt.useSystemAAFontSettings", "on");
System.setProperty("swing.aatext", "true");

-- 윈도우 화면처럼
try {
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
		e.printStackTrace();
	}