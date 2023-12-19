package textsystem;
import java.io.*;
import jxl.*;
import java.util.*;
import javax.swing.JOptionPane;

public class RamdomInitTestPaper implements GiveTestPaper {
	//将试题放入试卷（出卷）
	TestPaper testPaper;   //试卷
	File fileExcel;
	Problem [] problem;   //组成试卷的一套题，problem的单元存放一道题，即一个problem对象
	InputStream in = null;
	Workbook wb = null;   //封装Excel，Workbook是jxl包中的类
	Sheet sheet =null;    //封装Excel中的sheet，sheet是jxl包中的类
	LinkedList<Integer> list;   //随机抽取试题时用
	
	//RamdomInitTestPaper
	public RamdomInitTestPaper() {
		testPaper = new TestPaper();
		list = new LinkedList<Integer>();//初始化list
	}
	
	//getTestPaper
	public TestPaper getTestPaper(String excelFileName, int amount) {
		boolean b = setExcel(excelFileName);   //设置用户存放试题的电子表格
		if(b) {
			try {
				randomGiveProblem(amount);   //随机给出amount道试题，见类后面的random GiveProblem
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("试题必须有类型，请检查题库");
				System.exit(0);
			}
			testPaper.setProblem(problem);   //试卷上设置的一套试题是problem
			return testPaper;                //返回试卷
		}
		else {
			JOptionPane.showMessageDialog(null,"没有预备题库","消息对话框",JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	//setExcel
	private boolean setExcel(String excelFileName) {
		boolean b = true;
		try {
			fileExcel = new File(excelFileName);
			in = new FileInputStream(fileExcel);
			testPaper.setProblemSource(fileExcel.getAbsolutePath());   //试卷设置题库来源
		}
		catch(IOException exp) {
			JOptionPane.showMessageDialog(null,"没有预备题库Excel","消息对话框",JOptionPane.WARNING_MESSAGE);
			b = false;
		}
		try {
			wb = Workbook.getWorkbook(in);
			in.close();
		}
		catch(Exception exp) {
			b = false;
		}
		return b;
	}
	
	//randomGiveProblem
	//随机给出amount道试题放入problem数组中
	private void randomGiveProblem(int amount) {
		list.clear();
		if(wb == null) {
			JOptionPane.showMessageDialog(null,"没有预备题库Excel","消息对话框",JOptionPane.WARNING_MESSAGE);
			return;
		}
		sheet = wb.getSheet(0);             //得到Excel中的第一个sheet（从0开始索引）
		int rowsAmount = sheet.getRows();   //得到sheet的总行数
		//注意原始Excel表中sheet中的第0行不是试题，是用户输入的说明
		int realAmount = Math.min(amount, rowsAmount-1);   //实际抽取的试题数量
		problem = new Problem[realAmount];                 //用于存放试题的数组problem
		//将1~rowsAmount-1放入链表
		for(int i = 0; i < rowsAmount-1; i++) {
			list.add(i+1);
		}
		Random random = new Random();
		for(int i = 0; i < problem.length; i++) {
			int m = random.nextInt(list.size());   //[0,list.size()]中的一个随机数
			int index = list.remove(m);            //删除list的第m个节点，同时得到节点数字
			Cell [] cell = sheet.getRow(index);    //返回sheet中的第index行
			//注意原始Excel表中sheet中的第0行不是试题，是用户输入的说明
			//cell的第0列是试题内容，索引从0开始
			problem[i] = new Problem();
			int number = i + 1;
			problem[i].setContent("第" + number + "题." + cell[0].getContents());
			
			//试题的内容
			problem[i].setCorrectAnswer(cell[1].getContents().trim());   //试题的答案
			//试题的选项
			problem[i].setGiveChoiceA(cell[2].getContents().trim());     //试题的A选择
			problem[i].setGiveChoiceB(cell[3].getContents().trim());     //试题的B选择
			problem[i].setGiveChoiceC(cell[4].getContents().trim());     //试题的C选择
			problem[i].setGiveChoiceD(cell[5].getContents().trim());     //试题的D选择
			//试题的类型
			String typeStr = cell[6].getContents().trim();               //试题的类型（判断或选择）
			
			//因为试题有图像，所以typeStr有4种，即p、p#、x、x#
			//第一种：p
			if(typeStr.equalsIgnoreCase("p")) {
				problem[i].setIsJudge(true);
				problem[i].setIsChoice(false);
				problem[i].setImageName("havenot.jpg");
			}
			//第二种：x
			if(typeStr.equalsIgnoreCase("x")) {
				problem[i].setIsJudge(false);
				problem[i].setIsChoice(true);
				problem[i].setImageName("havenot.jpg");
			}
			//第三种：p#
			if(typeStr.equalsIgnoreCase("p#")) {
				problem[i].setIsJudge(true);
				problem[i].setIsChoice(false);
				String imageName = typeStr.substring(typeStr.indexOf("#") + 1);
				problem[i].setImageName(imageName);
			}
			//第四种：x#
			if(typeStr.equalsIgnoreCase("x#")) {
				problem[i].setIsJudge(false);
				problem[i].setIsChoice(true);
				String imageName = typeStr.substring(typeStr.indexOf("#") + 1);
				problem[i].setImageName(imageName);
			}
		}
	}
}
