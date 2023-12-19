package testgui;
import textsystem.*;
import testview.TestPaperView;
import testview.IntegrationView;

public class AppWindow{
	public static void main(String[] args){
		String testName ="";
		IntegrationView integrationView = new IntegrationView();
		GiveTestPaper initTestPaper = new RamdomInitTestPaper();
		//创建初始试卷对象
		TestPaper testPaper = initTestPaper.getTestPaper("题库/测试题库.xls",5);   //得到有5个题目的试卷
		TestPaperView testView = new TestPaperView();
		testView.setTestPaper(testPaper);                             //设置试卷
		testView.setTeacher(new TeacherOne());                        //设置阅卷老师
		testName ="java测试题";
		testView.setTestName(testName);
		testView.setTotalTime(15);                                    //考试时间15分钟
		integrationView.addTestPaperView(testName,testView);
		initTestPaper = new RamdomInitTestPaper();                    //创建初始试卷对象
		testPaper = initTestPaper.getTestPaper("题库/测试题库.xls",6);
		testView = new TestPaperView();
		testView.setTestPaper(testPaper);
		testView.setTeacher(new TeacherOne());
		testName = "Java 训练";
		testView.setTestName(testName);
		testView.setTotalTime(10);
		integrationView.addTestPaperView(testName,testView);
	}
}