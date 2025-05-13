package br.edu.fatecgru.model;

public class Disciplina {
	
	    private Integer id;
	    private String nome;
	    private Curso curso;
	    private int semestre;
	public Disciplina() {
	}
	public Disciplina(Integer id, String nome, Curso curso, int semestre) {
		super();
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.semestre = semestre;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	
	
}