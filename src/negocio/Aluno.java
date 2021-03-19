package negocio;

public class Aluno extends Pessoa{

	private Curso curso;
	private Double codigoCurso;
	
	public Aluno(String nome, String cpf, int idade, Curso curso) {
		super(nome, cpf, idade);
		this.curso = curso;
	}
	
	//Para usar no BD
	public Aluno(String nome, String cpf, int idade, Double codigoCurso) {
		super(nome, cpf, idade);
		this.codigoCurso = codigoCurso;
	}
	
	public Double getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(Double codigoCurso) {
		this.codigoCurso = codigoCurso;
	} //

	public Aluno() {
		super();
		this.curso = null;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	@Override
	public String toString() {
		return "ALUNO(A): " + super.toString() + " "+ curso;
	}


}
