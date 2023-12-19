 package textsystem;

//Problem类
public class Problem {
	boolean isChoice;   //是否为选择题
	boolean isJudge;    //是否为判断题
	String content;     //题目内容
	String giveChoiceA,giveChoiceB,giveChoiceC,giveChoiceD;   //提供A-D的四种选择
	String imageName;   //题目所带的图像文件的名字
	String correctAnswer = "QWEQ@#$@!@#1QWEQ";   //题目的正确答案
	//用户回答的初始答案和correctAnswer不同，防止出题人忘记给正确答案
	String userAnswer = "";   //初始值必须是不含任何字符的串
	
	public boolean getIsChoice() {
		return isChoice;
	}
	//下方使用到布尔类型boolean
	//定义了一个布尔型变量b
	public void setIsChoice(boolean b) {
		isChoice = b;   //将变量b视为真
	}
	//创建了一个布尔型变量IsJudge
	public boolean getIsJudge() {
		return isJudge;   //返回变量IsJudge
	}
	public void setIsJudge(boolean b) {
		isJudge = b;      //变量IsJudge设为真
	}
	
	//下方使用到字符串类型String
	//定义了一个字符串类型变量
	public void setContent(String c) {
		content = c;
	}
	public String getContent() {
		return content;
	}
	
	//correctAnswer
	public void setCorrectAnswer(String a) {
		correctAnswer = a;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
	//userAnswer
	public void setUserAnswer(String u) {
		userAnswer = u;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	
	//giveChoiceA
	public void setGiveChoiceA(String a) {
		giveChoiceA = a;
	}
	public String getGiveChoiceA() {
		return giveChoiceA;
	}
	
	//giveChoiceB
	public void setGiveChoiceB(String b) {
		giveChoiceB = b;
	}
	public String getGiveChoiceB() {
		return giveChoiceB;
	}
	
	//giveChoiceC
	public void setGiveChoiceC(String c) {
		giveChoiceC = c;
	}
	public String getGiveChoiceC() {
		return giveChoiceC;
	}
	
	//giveChoiceD
	public void setGiveChoiceD(String d) {
		giveChoiceD = d;
	}
	public String getGiveChoiceD() {
		return giveChoiceD;
	}
	
	//imageName
	public void setImageName(String c) {
		imageName = c;
	}
	public String getImageName() {
		return imageName;
	}
}
