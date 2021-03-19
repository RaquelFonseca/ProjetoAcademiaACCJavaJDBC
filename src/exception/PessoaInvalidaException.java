package exception;

public class PessoaInvalidaException extends Exception {
	
	
	public PessoaInvalidaException() {
		super("Pessoa não encontrada!");
	}

	
	public PessoaInvalidaException(String string) {
		super(string);
	}

}
