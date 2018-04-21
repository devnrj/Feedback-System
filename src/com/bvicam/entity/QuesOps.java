package com.bvicam.entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.bvicam.dal.QuesDao;


public class QuesOps {
	private TreeSet<Question> quesList=null;
	private static QuesOps qo = null;
	
	private QuesOps() {
		quesList = new TreeSet<Question>();
	}
	
	public static QuesOps getInstance() {
		synchronized(QuesOps.class) {
			if(qo==null) {
				qo = new QuesOps();
			}
		}
		return qo;
	}
	public void loadQuestions() throws SQLException,ClassNotFoundException{
		QuesDao 	qd = QuesDao.getInstance();
		if(quesList==null) {
			quesList=new TreeSet<Question>(qd.getQuestions());
		}else {
			//quesList=(TreeSet<Question>)(qd.getQuestions().stream().collect(Collectors.toSet()));
			quesList.addAll(qd.getQuestions());
		}
		
	}
	
	public ArrayList<Question> getQuestions(QuesUsage qu) throws ClassNotFoundException, SQLException {
		//fetch questions on the basis of questype and add into list and return to calling func
		this.loadQuestions();
		ArrayList<Question> alist = qo.getQuestionList();	
		alist=(ArrayList<Question>)quesList.stream().
				filter(q -> q.getQuesUsage()==qu)
				.collect(Collectors.<Question> toList());
		return alist;
	}
	public ArrayList<Question> getQuestionList() {
		return (ArrayList<Question>)(quesList.stream().collect(Collectors.toList()));
	}
	
	public void addQuestion(Question qs) {
		quesList.add(qs);
	}
	
	public void deleteQuestion(Question qs) {
		quesList.remove(qs);
	}
	public void updateQuestion(Question qs) {
		if(quesList.contains(qs)) {
			//not complete
		}
	}
	public Question getQuestionById(int qid) throws ClassNotFoundException, SQLException {
		return QuesDao.getInstance().getQuestion(qid);
	}
}
