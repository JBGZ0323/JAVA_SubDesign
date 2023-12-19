package textsystem;

public interface Teacher {
	//为便于后期内容和功能的扩展，在这里将评判试卷的方法封装在Teacher接口中
	public void giveTextPaparScore(TestPaper testPaper);
}
