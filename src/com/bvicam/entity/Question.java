package com.bvicam.entity;
public class Question implements Comparable<Question>{
	private int ques_id;
	private String ques_name;
	private QuesUsage qu;
	private QuesType type; 
	
	public Question(){
	}

	public int getQuesId() {
		return ques_id;
	}

	public void setQuesId(int ques_id) {
		this.ques_id = ques_id;
	}

	public String getQuesName() {
		return ques_name;
	}

	public void setQuesName(String ques_name) {
		this.ques_name = ques_name;
	}

	public QuesType getType() {
		return type;
	}

	public void setType(QuesType type) {
		this.type = type;
	}


	public Question(int ques_id, String ques_name, QuesType type) {
		this.ques_id = ques_id;
		this.ques_name = ques_name;
		this.type = type;
	}

	public QuesUsage getQuesUsage() {
		return qu;
	}

	public void setQuesUsage(QuesUsage qu) {
		this.qu = qu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ques_name == null) ? 0 : ques_name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Question [ques_id=" + ques_id + ", ques_name=" + ques_name + ", qu=" + qu + ", type=" + type + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (ques_name == null) {
			if (other.ques_name != null)
				return false;
		} else if (!ques_name.equals(other.ques_name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Question o) {
		return this.ques_id-((Question)o).getQuesId();
	}
	
	
	
}
