package br.edu.fatecgru.model;

public class Aluno {
    private Integer id;
    private String nome;
    private String cpf;
    private String RA;
    private String dataNasc;
    private String endereco;
    private String email;
    private String municipio;
    private String uf;
    private String celular;
    private Curso curso;

    public Aluno() {
    }

    public Aluno(Integer id, String nome, String cpf, String RA, String dataNasc, String endereco,
                 String email, String municipio, String uf, String celular, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.RA = RA;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.email = email;
        this.municipio = municipio;
        this.uf = uf;
        this.celular = celular;
        this.curso = curso;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRA() {
		return RA;
	}

	public void setRA(String rA) {
		RA = rA;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}