# !!!Commit and Push �ϱ��� �ݵ�� Pull���� ���ּ���!!!
1. MovieProject ��Ŭ�� -> Team -> �����ִ� Pull Ŭ��
2. Commit and push�� Message�Է�


# �߰� �ؾ� �ϴ� ����
1. 

2.

3.

4.

5.

## ����

## ��Ű��
- src.data > Ŭ�������� �ʵ�, ������, ���� ����, toString...
- src.db > Ŭ�������� SQL��
- src.ui > UI���� Ŭ����
- src.test > ��� �׽�Ʈ

## ����
- files > sql, image���� ���ϵ��� ����
- lib > jar�� �ʿ��� path ���

## �帧��
1. ù ���۽� ����ȭ��(�α��� or ��ȭ ��� �����ֱ�) 

2. 

3.

4.

5.

## �����ڵ�
-- ��Ʈ ��� ���� ����
System.setProperty("awt.useSystemAAFontSettings", "on");
System.setProperty("swing.aatext", "true");

-- ������ ȭ��ó��
try {
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
		e.printStackTrace();
	}