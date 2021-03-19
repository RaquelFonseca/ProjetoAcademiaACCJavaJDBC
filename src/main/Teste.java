package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import dados.FabricaConexao;
import dados.RepositorioPessoaArray;
import dados.RepositorioPessoaList;
import dados.SistemaAcademicoDAO;
import exception.CapacidadeExcedidaException;
import exception.PessoaInvalidaException;
import negocio.Aluno;
import negocio.Curso;
import negocio.Pessoa;
import negocio.Professor;
import negocio.RepositorioPessoas;

public class Teste {

	public static void main(String[] args) {
		
		// Alunas
		Curso curso1 = new Curso(1, "Ciência da Computação");
		Pessoa fulana = new Aluno("Fulana de Tal", "000.000.000-00", 20, curso1);
		Pessoa cicrana = new Aluno("Cicrana de Tal", "111.111.111-11", 21, curso1);
		Pessoa beltrana = new Aluno("Beltrana de Tal", "222.222.222-22", 23, curso1);

		// Professores
		Pessoa professor = new Professor("Professor", "999.999.999-99", 40, 10000.00);
		Pessoa professorSubst = new Professor("Professor Substituto", "888.888.888-88", 40, 80000.00);

		SistemaAcademicoDAO db = new SistemaAcademicoDAO();
		
		// adicionar pessoas nas tabela aluno e professor
		/*db.inserirPessoa(fulana);
		db.inserirPessoa(cicrana);
		db.inserirPessoa(beltrana);
		db.inserirPessoa(professor);
		db.inserirPessoa(professorSubst);*/
		
		// remover pessoas das tabelas aluno e professor
		/*db.removerPessoa(cicrana);
		db.removerPessoa(professorSubst);*/
		
		// COnsultas
		/*db.procuraProfessor("999.999.999-99");
		db.procuraAluno("000.000.000-00");*/
		
		//for(Contato c : contatoDao.getContatos()) {
			//System.out.println("Contato: "+c.getNome());
		//}
		
		/*try {
			for (Pessoa aluno: db.getAlunos()) {
				System.out.println(aluno.toString());	
			}
			
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			
			for (Pessoa prof: db.getProfessores()) {
				System.out.println(prof.toString());	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		
		
		// TESTE DAS EXCEÇÕES, LISTA, ARRAY, E ETC
		/*Curso curso1 = new Curso(1, "Ciência da Computação");
		
		// Alunas
		Pessoa fulana = new Aluno("Fulana de Tal", "000.000.000-00", 20, curso1);
		Pessoa cicrana = new Aluno("Cicrana de Tal", "111.111.111-11", 21, curso1);
		Pessoa beltrana = new Aluno("Beltrana de Tal", "222.222.222-33", 23, curso1);
		
		// Professor
		Pessoa professor = new Professor("Professor", "999.999.999-99", 40, 10000.00);
		
		// Repositórios
		//RepositorioPessoas repoAlunos = new RepositorioPessoaArray(3);
		RepositorioPessoas repoAlunos = new RepositorioPessoaList();
		
		
		try {
			repoAlunos.inserir(fulana);
			repoAlunos.alunosCadastrados();
			
			repoAlunos.inserir(cicrana);
			repoAlunos.alunosCadastrados();
			
			repoAlunos.inserir(professor);
			repoAlunos.alunosCadastrados();
			
			//repoAlunos.inserir(beltrana);
			repoAlunos.alunosCadastrados();
			
			//repoAlunos.remover("000.00.000-00");
			
			repoAlunos.alunosCadastrados();
			
			//repoAlunos.inserir(beltrana);
			repoAlunos.alunosCadastrados();
			
			Pessoa pessoa = repoAlunos.procurar("000.00.000-00");
			//System.out.println("Pessoa procurada: " + pessoa);
		
		} catch (CapacidadeExcedidaException e) {
			e.printStackTrace();
		} catch (PessoaInvalidaException e) {
			e.printStackTrace();
		} finally {
			repoAlunos.alunosCadastrados();
		}
			
		/*repoAlunos.remover(fulana.getCpf());
		
		repoAlunos.alunosCadastrados();*/
		
	}

}
