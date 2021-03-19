package negocio;

public class Professor  extends Pessoa{
	private double salario;

	public Professor(String nome, String cpf, int idade, double salario) {
		super(nome, cpf, idade);
		this.salario = salario;
	}
	
	public Professor() {
		super();
		this.salario = 0.0;
	}

	public Professor(String nome, String cpf, int idade) {
		super(nome, cpf, idade);
	}



	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "PROFESSOR(A): " + super.toString() + "SALÁRIO: " + salario;
	}
	
	
}
