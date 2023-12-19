package testapp;
import textsystem.*;

public class AppTest {

	public static void main(String[] args) {
		GiveTestPaper initTestPaper = new RamdomInitTestPaper();   //创建初始试卷对象
		TestPaper testPaper = initTestPaper.getTestPaper("题库/测试题库.xls", 5);   //得到有5道题目的试卷
		Problem [] problem = testPaper.getAllProblem();   //得到试卷中的全部题目
		for(int i = 0; i < problem.length; i++) {
			int m = i+1;
			System.out.println("第" + m + "题.");
			System.out.println(problem[i].getContent());
			if(problem[i].getIsJudge()) {
				inputOne(problem[i]);
			}
			else if(problem[i].getIsChoice()) {
				inputTwo(problem[i]);
			}
			System.out.println();
		}
		//模拟用户答题
		problem[0].setUserAnswer("B");    //模拟用户给出的答案
		problem[1].setUserAnswer("A");
		problem[2].setUserAnswer("C");
		problem[3].setUserAnswer("A");
		problem[0].setUserAnswer("B");
		problem[1].setUserAnswer("D");
		testPaper.acceptTeacher(new TeacherOne());   //让老师批改试卷
	}
	static void inputOne(Problem problem) {
		System.out.printf("%s\t%s\n", problem.getGiveChoiceA(), problem.getGiveChoiceB());
		System.out.println("图像的名字" + problem.getImageName());
		System.out.println("正确答案" + problem.getCorrectAnswer());
	}
	static void inputTwo(Problem problem) {
		System.out.printf("%s\t%s\n", problem.getGiveChoiceA(), problem.getGiveChoiceB());
		System.out.printf("%s\t%s\n", problem.getGiveChoiceC(), problem.getGiveChoiceD());
		System.out.println("图像的名字" + problem.getImageName());
		System.out.println("正确答案" + problem.getCorrectAnswer());
	}

}
