package dados;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import negocio.Aluno;
import negocio.Curso;
import negocio.Pessoa;
import negocio.Professor;

public class SistemaAcademicoDAO {
	private Connection conexao = null;
	 private PreparedStatement pStmt = null;


	 public SistemaAcademicoDAO() {
		 this.conexao = new FabricaConexao().getConnection();
	}
	 
	public void inserirPessoa(Pessoa pessoa) {
		 if (pessoa instanceof Aluno) {
			  try {
				  pStmt = conexao.prepareStatement("INSERT INTO " +""
					 		                        + "alunos(nome, cpf, idade, codigoCurso)" +
			                                         "VALUES(?,?,?,?)");
				  pStmt.setString(1, pessoa.getNome());
				  pStmt.setString(2, pessoa.getCpf());
				  pStmt.setInt(3, pessoa.getIdade());
				  pStmt.setDouble(4, ((Aluno)pessoa).getCurso().getCodigo());

				  pStmt.executeUpdate();
				  pStmt.close();

					 System.out.println("Gravado!");
				 } catch (SQLException e) {
					 throw new RuntimeException(e);
				 	}
		 } else {
			 
			 try {
				 pStmt = conexao.prepareStatement("INSERT INTO professores(nome, cpf, idade, salario)" +
			                                      "VALUES(?,?,?,?)");

				 pStmt.setString(1, pessoa.getNome());
				 pStmt.setString(2, pessoa.getCpf());
				 pStmt.setInt(3, pessoa.getIdade());
				 pStmt.setDouble(4, ((Professor)pessoa).getSalario());

				 pStmt.executeUpdate();
				 pStmt.close();

				 System.out.println("Gravado!");
			 } catch (SQLException e) {
				 throw new RuntimeException(e);
			 	}
		 }

	}
	 
	public void removerPessoa(Pessoa pessoa) {
		 if (pessoa instanceof Aluno) {
			  try {
				  pStmt = conexao.prepareStatement("DELETE FROM alunos WHERE cpf= ?");                                    
				  pStmt.setString(1, pessoa.getCpf());
				  
				  pStmt.executeUpdate();
				  pStmt.close();
				  
				  System.out.println("Removido!");
				 } catch (SQLException e) {
					 throw new RuntimeException(e);
				 	}
		 } else {
			 
			 try {
				 pStmt = conexao.prepareStatement("DELETE FROM professores WHERE cpf= ?");
				 pStmt.setString(1, pessoa.getCpf());
		
				 pStmt.executeUpdate();
				 pStmt.close();

				 System.out.println("Removido!");
			 } catch (SQLException e) {
				 throw new RuntimeException(e);
			 	}
		 }

	}

	public void procuraProfessor(String numCpf) {
		try {
			pStmt = conexao.prepareStatement("SELECT * FROM professores where cpf = ? ");
			pStmt.setString(1, numCpf);
			
			ResultSet rs = pStmt.executeQuery();
			System.out.println("Resultado da consulta:");
			
			while(rs.next()) {
			System.out.println(rs.getString(1) + " - " + 
	                rs.getString(2) + " - " +
			           rs.getInt(3) + " - " +
	                rs.getDouble(4));}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void procuraAluno(String numCpf) {
		try {
			pStmt = conexao.prepareStatement("SELECT * FROM alunos where cpf = ? ");
			pStmt.setString(1, numCpf);
			
			ResultSet rs = pStmt.executeQuery();
			System.out.println("Resultado da consulta:");
			
			while(rs.next()) {
			System.out.println(rs.getString(1) + " - " + 
	                rs.getString(2) + " - " +
			           rs.getInt(3) + " - " +
	                rs.getString(4));}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	public List<Pessoa> getAlunos() throws SQLException {
		List<Pessoa> alunos = new ArrayList<Pessoa>();
		
		ResultSet rs = null; 
		Pessoa aluno;
		try {
			pStmt = conexao.prepareStatement("SELECT * FROM alunos");
			rs = pStmt.executeQuery();
			
			while(rs.next()){
				Curso curso = new Curso();
				Double codigoCurso = 0.0;
				codigoCurso = rs.getDouble("codigoCurso");
				if (codigoCurso == 1.0) {
					curso.setCodigo(1.0);
					curso.setNome("Ciência da Computação");
								
				aluno = new Aluno(rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"), curso);
				alunos.add(aluno);
					
				}
			}
			rs.close();
			pStmt.close();
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Pessoa> getProfessores() throws SQLException {
		List<Pessoa> professores = new ArrayList<Pessoa>();
		
		ResultSet rs = null; 
		Pessoa professor;
		String sql = "SELECT * FROM professores";
		try {
			pStmt = conexao.prepareStatement(sql);
			rs = pStmt.executeQuery();
			
			while(rs.next()){				
				professor = new Professor(rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"), rs.getDouble("salario"));
				professores.add(professor);	
			}
			rs.close();
			pStmt.close();
			return professores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void inserirCurso(Curso curso) {
		 try {
			 pStmt = conexao.prepareStatement("INSERT INTO " +""
					 		                   + "cursos(codigo, nome)" +
			                                         "VALUES(?,?)");
			  pStmt.setDouble(1, curso.getCodigo());
			  pStmt.setString(2, curso.getNome());

			  pStmt.executeUpdate();
			  pStmt.close();

			System.out.println("Gravado!");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	 }
	
	public void removerCurso(Curso curso) {
			  try {
				  pStmt = conexao.prepareStatement("DELETE FROM cursos WHERE codigo= ?");                                    
				  pStmt.setDouble(1, curso.getCodigo());
				  pStmt.executeUpdate();
				  pStmt.close();

					 System.out.println("Removido!");
				 } catch (SQLException e) {
					 throw new RuntimeException(e);
				 }
		 	 }
	 
	 

}
