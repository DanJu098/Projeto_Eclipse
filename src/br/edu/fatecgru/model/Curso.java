package br.edu.fatecgru.model;


public class Curso {
    private Integer id;
    private String nomeCurso;
    private String campus;
    private String periodo;
    private Disciplina disciplina; // novo campo
    
    public Curso() {	
    }
	public Curso(Integer id, String nomeCurso, String campus, String periodo, Disciplina disciplina) {
		this.id = id;
		this.nomeCurso = nomeCurso;
		this.campus = campus;
		this.periodo = periodo;
		this.disciplina = disciplina;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
}