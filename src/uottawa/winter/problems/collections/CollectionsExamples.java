package uottawa.winter.problems.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionsExamples {


	public static List<Student> returnList(){
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(3, "shravan"));
		students.add(new Student(2, "kumar"));
		students.add(new Student(1, "sabavat"));
		students.add(new Student(3, "shravan"));
		students.add(new Student(1, "sabavat"));
		return students;
	}

	public static Set<Student> returnSet(){
		Set<Student> students = new HashSet<Student>();
		students.add(new Student(1, "shravan"));
		students.add(new Student(2, "kumar"));
		students.add(new Student(3, "sabavat"));
		students.add(new Student(1, "shravan"));
		students.add(new Student(2, "kumar"));
		return students;
	}

	public static Map<Student,Student> returnMap(){
		Map<Student, Student> students = new HashMap<Student, Student>();
		students.put(new Student(1, "shravan"),new Student(1, "shravan"));
		students.put(new Student(2, "kumar"),new Student(2, "kumar"));
		students.put(new Student(3, "sabavat"),new Student(3, "sabavat"));
		students.put(new Student(1, "shravan"),new Student(1, "shravan"));
		students.put(new Student(2, "kumar"),new Student(2, "kumar"));
		return students;
	}

	public static Map<Student,Student> returnTreeMap(){
		Map<Student, Student> students = new TreeMap<Student, Student>();
		students.put(new Student(3, "sabavat"),new Student(3, "sabavat"));
		students.put(new Student(1, "shravan"),new Student(1, "shravan"));
		students.put(new Student(2, "kumar"),new Student(2, "kumar"));
		students.put(new Student(2, "kumar"),new Student(2, "shravan"));
		return students;
	}

	public static void main(String[] args){


		List<Student> studentsList = returnList();
		Set<Student> studentsSet = returnSet();
		Map<Student, Student> studentsMap = returnMap();
		Map<Student, Student> studentsTreeMap = returnTreeMap();
		
		
		for(Map.Entry<Student, Student> student : studentsMap.entrySet()){
			Student key = student.getKey();
			Student value = student.getValue();
			System.out.println("key "+ key.getId() +"::::"+"value "+ value.getName());
		}
		
		/*for(Map.Entry<Student, Student> student : studentsTreeMap.entrySet()){
			Student key = student.getKey();
			Student value = student.getValue();
			System.out.println("key "+ key.getId() +"::::"+"value "+ value.getName());
		}*/

		//sort using comparator
		List<Student> studentKeys = new ArrayList(studentsMap.entrySet());
		Collections.sort(studentKeys, new Comparator(){
			public int compare(Object o1, Object o2){
				Map.Entry<Student, Student> s1 = (Map.Entry<Student, Student>)o1;
				Map.Entry<Student, Student> s2 = (Map.Entry<Student, Student>)o2;
				if(s1.getKey().id > s2.getKey().id){
					return -1;
				}else if (s1.getKey().id < s2.getKey().id){
					return 1;
				}
				return 0;
			}
		});
		//put them back in a new map;
		
		//sort by value
		//sort using comparator
		List<Student> studentMaps = new ArrayList(studentsMap.entrySet());
		Collections.sort(studentMaps, new Comparator(){
			public int compare(Object o1, Object o2){
				Map.Entry<Student, Student> s1 = (Map.Entry<Student, Student>)o1;
				Map.Entry<Student, Student> s2 = (Map.Entry<Student, Student>)o2;
				return s1.getValue().name.compareTo(s2.getValue().name);
			}
		});
		//put them back in a new map;

	}

}
