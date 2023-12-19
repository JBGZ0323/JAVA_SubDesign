package textsystem;

public interface GiveTestPaper {
	//为便于后期内容和功能的扩展，将抽取试题形成试卷的方法封装在GiveTestPaper接口中
	public TestPaper getTestPaper(String excelFileName,int amount);
}
