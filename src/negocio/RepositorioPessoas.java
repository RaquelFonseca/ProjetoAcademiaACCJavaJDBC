package negocio;

import exception.CapacidadeExcedidaException;
import exception.PessoaInvalidaException;

public interface RepositorioPessoas {
	
	void inserir(Pessoa pessoa) throws CapacidadeExcedidaException;
	
	Pessoa procurar(String numCPF) throws PessoaInvalidaException;
	
	void remover(String numCPF) throws PessoaInvalidaException;
	
	void alunosCadastrados();
	
	

}
