package dados;

import java.util.ArrayList;

import exception.PessoaInvalidaException;
import negocio.Pessoa;
import negocio.RepositorioPessoas;

public class RepositorioPessoaList implements RepositorioPessoas{
	
	private ArrayList<Pessoa> pessoas;

	public RepositorioPessoaList() {
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	public void inserir(Pessoa pessoa){
		this.pessoas.add(pessoa);
	}
	
	public Pessoa procurar(String numCPF) throws PessoaInvalidaException{
		Pessoa pessoaProcurada = null;
		for (Pessoa pessoa : this.pessoas) {
			if (pessoa.getCpf().equals(numCPF)) {
				pessoaProcurada = pessoa;
			}
		}
		if (pessoaProcurada != null) {
			return pessoaProcurada;
		} else {
			throw new PessoaInvalidaException("CPF não encontrado!");
		}

	}
	
	public void remover(String numCPF) throws PessoaInvalidaException {
		Pessoa paraRemover = procurar(numCPF);
		this.pessoas.remove(paraRemover);
	}
	
	public void alunosCadastrados() {
		System.out.println("Pessoas cadastrados(as) na LISTA:");
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getNome().toUpperCase());
		}
		System.out.println();
	}
	

}
