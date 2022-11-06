package services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseAnalytics {
	
	//O Set não aceita elementos repetidos, portanto, esse método retornará um set contendo 
	//todos os alunos dos cursos, sem repetições, uma vez que um mesmo aluno pode estar
	//matriculado em mais de um curso.
	
	public static Set<Integer> studentsTotal (List<Set<Integer>> setList) {
		
		Set<Integer> students = new HashSet<>();
		
		for (Set<Integer> set : setList) {
			students.addAll(set);
		}
		
		return students;
	}

}
