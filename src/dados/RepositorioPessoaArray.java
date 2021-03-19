package dados;

import exception.CapacidadeExcedidaException;
import exception.PessoaInvalidaException;
import negocio.Pessoa;
import negocio.RepositorioPessoas;

public class RepositorioPessoaArray implements RepositorioPessoas{
	private Pessoa[] pessoas;
	private int indice;
	
	public RepositorioPessoaArray(int tamanho) {
		this.pessoas = new Pessoa[tamanho];
		this.indice = 0;
	}
	
	private boolean estaCheio() {
		return this.indice == this.pessoas.length;
	}
	
	public void inserir(Pessoa pessoa) throws CapacidadeExcedidaException {
		if (estaCheio()) {
			throw new CapacidadeExcedidaException();
		} 
		else {
			this.pessoas[indice] = pessoa;
			this.indice++;
		}
	}
	
	public Pessoa procurar(String numCPF) throws PessoaInvalidaException {
		Pessoa pessoaProcurada = null;
		for (int i = 0; i < this.indice; i++) {
			if (pessoas[i].getCpf().equals(numCPF))
				pessoaProcurada = pessoas[i];
		}
		if (pessoaProcurada != null) {
			return pessoaProcurada;
		} else {
			throw new PessoaInvalidaException("Pessoa não encontrada!");
		}

	}
	
	public void remover(String numCPF) throws PessoaInvalidaException {
		Pessoa pessoa = procurar(numCPF);
		if (pessoa == null) {
			throw new PessoaInvalidaException("Impossível remover! Pessoa inexistente!");
		}
		for (int i = 0; i < this.indice; i++) {
			if (this.pessoas[i].getCpf().equals(numCPF)) {
				this.pessoas[i] = this.pessoas[this.indice-1];
				this.pessoas[this.indice-1] = null;
				this.indice--;
			} 	
		}
	}

	public void alunosCadastrados() {
		System.out.println("Pessoas cadastrados(as) no Array:");
		for (int i = 0; i < indice; i++) {
			System.out.println(this.pessoas[i].getNome().toUpperCase());
		}
		System.out.println();
	}

}
