package uottawa.winter.problems.collections;

public class Student implements Comparable<Student>{

	int id;
	String name;

	Student(int id, String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		int random = 99;
		int result = 1;
		result = result * random + id;
		result = result * random + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(this.getClass() != obj.getClass()){
			return false;
		}
		Student stud = (Student)obj;
		if(this.id != stud.id){
			return false;
		}
		if(null != name){
			if(this.name != stud.name){
				return false;
			}
		}else{
			return false;
		}
		return true;
	}


	@Override
	public int compareTo(Student student) {
		if(student.id > this.id){
			return -1;
		}else if (student.id < this.id){
			return 1;
		}
		return 0;
	}





}
