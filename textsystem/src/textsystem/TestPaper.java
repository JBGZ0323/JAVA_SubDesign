package textsystem;

//试卷
//TextPaper类
public class TestPaper {
	private Problem [] problem = null;   //数组的每一个单元存放一道题目
	int index = -1;
	String problemSource;    //试卷的题库
	public void setProblem(Problem [] problem) {
		this.problem = problem;
	}
	
	//getProblem
	public Problem getProblem(int i) {
		if(problem == null) {
			return null;
		}
		if(problem.length == 0) {
			return null;
		}
		if(i >= problem.length || i < 0) {
			return null;
		}
		return problem[i];
	}
	
	//nextProblem	
	public Problem nextProblem() {
		index++;
		if(problem == null) {
			return null;
		}
		if(problem.length == 0) {
			return null;
		}
		if(index == problem.length) {
			index = problem.length-1;   //到最后一道题结束（停止）
		}
		return problem[index];
	}
	
	//previousProblem
	public Problem previousProblem() {
		index--;
		if(problem == null) {
			return null;
		}
		if(problem.length == 0) {
			return null;
		}
		if(index < 0) {
			index = 0;   //到第一道题结束（停止）
		}
		return problem[index];
	}
	public Problem [] getAllProblem() {
		if(problem == null) {
			return null;
		}
		if(problem.length == 0) {
			return null;
		}
		return problem;
		}
	
	//getProblemAmount
	public int getProblemAmount() {
		if(problem == null) {
			return 0;
		}
		return problem.length;
	}
	
	//ProblemSource
	public void setProblemSource(String source) {
		problemSource = source;
	}
	public String getProblemSource() {
		return problemSource;
	}
	
	//acceptTeacher
	public void acceptTeacher(Teacher teacher) {   //让老师来批改试卷（访问者模式）
		teacher.giveTextPaparScore(this);          //teacher批卷
	}
}
