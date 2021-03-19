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

	 public SistemaAcademicoDAO() {
		 this.conexao = new FabricaConexao().getConnection();
	}
	 
	 public void inserirPessoa(Pessoa pessoa) {
		 PreparedStatement stmt = null;
		 if (pessoa instanceof Aluno) {
			  try {
					 stmt = conexao.prepareStatement("INSERT INTO " +""
					 		                        + "aluno(nome, cpf, idade, curso)" +
			                                         "VALUES(?,?,?,?)");
					 stmt.setString(1, pessoa.getNome());
					 stmt.setString(2, pessoa.getCpf());
					 stmt.setInt(3, pessoa.getIdade());
					 stmt.setString(4, ((Aluno)pessoa).getCurso().getNome());

					 stmt.executeUpdate();
					 stmt.close();

					 System.out.println("Gravado!");
				 } catch (SQLException e) {
					 throw new RuntimeException(e);
				 	}
		 } else {
			 
			 try {
				 stmt = conexao.prepareStatement("INSERT INTO professor(nome, cpf, idade, salario)" +
			                                      "VALUES(?,?,?,?)");

				 stmt.setString(1, pessoa.getNome());
				 stmt.setString(2, pessoa.getCpf());
				 stmt.setInt(3, pessoa.getIdade());
				 stmt.setDouble(4, ((Professor)pessoa).getSalario());

				 stmt.executeUpdate();
				 stmt.close();

				 System.out.println("Gravado!");
			 } catch (SQLException e) {
				 throw new RuntimeException(e);
			 	}
		 }

		 	 }
	 
	 public void removerPessoa(Pessoa pessoa) {
		 PreparedStatement stmt = null;
		 if (pessoa instanceof Aluno) {
			  try {
					 stmt = conexao.prepareStatement("DELETE FROM aluno WHERE cpf= ?");                                    
					 stmt.setString(1, pessoa.getCpf());
					 stmt.executeUpdate();
					 stmt.close();

					 System.out.println("Removido!");
				 } catch (SQLException e) {
					 throw new RuntimeException(e);
				 	}
		 } else {
			 
			 try {
				 stmt = conexao.prepareStatement("DELETE FROM professor WHERE cpf= ?");
				 stmt.setString(1, pessoa.getCpf());
		
				 stmt.executeUpdate();
				 stmt.close();

				 System.out.println("Removido!");
			 } catch (SQLException e) {
				 throw new RuntimeException(e);
			 	}
		 }

		 	 }

	 
	public void procuraProfessor(String numCpf) {
		PreparedStatement pStmt;
		try {
			pStmt = conexao.prepareStatement("SELECT * FROM professor where cpf = ? ");
			pStmt.setString(1, numCpf);
			ResultSet rs = pStmt.executeQuery();
			System.out.println("Resultado da query");
			while(rs.next()) {
			System.out.println(rs.getString(1) + " - " + 
	                rs.getString(2) + " - " +
			           rs.getInt(3) + " - " +
	                rs.getDouble(4));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void procuraAluno(String numCpf) {
		PreparedStatement pStmt;
		try {
			pStmt = conexao.prepareStatement("SELECT * FROM aluno where cpf = ? ");
			pStmt.setString(1, numCpf);
			ResultSet rs = pStmt.executeQuery();
			System.out.println("Resultado da query");
			while(rs.next()) {
			System.out.println(rs.getString(1) + " - " + 
	                rs.getString(2) + " - " +
			           rs.getInt(3) + " - " +
	                rs.getString(4));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public List<Pessoa> getAlunos() throws SQLException {
		List<Pessoa> alunos = new ArrayList<Pessoa>();
		
		PreparedStatement stmt =null; 
		ResultSet rs = null; 
		Pessoa aluno;
		try {
			stmt = conexao.prepareStatement("SELECT * FROM aluno");
			rs = stmt.executeQuery();
			while(rs.next()){
				Curso curso = new Curso();
				String cursoDescricao = "";
				cursoDescricao = rs.getString("curso");
				if (cursoDescricao.equals("Ciência da Computação")) {
					curso.setCodigo(1);
					curso.setNome("Ciência da Computação");
								
				aluno = new Aluno(rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"), curso);
				
				alunos.add(aluno);
					
			}}
			rs.close();
			stmt.close();
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Pessoa> getProfessores() throws SQLException {
		List<Pessoa> professores = new ArrayList<Pessoa>();
		
		PreparedStatement stmt =null; 
		ResultSet rs = null; 
		Pessoa professor;
		String sql = "SELECT * FROM professor";
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){				
				professor = new Professor(rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"), rs.getDouble("salario"));
				
				professores.add(professor);
					
			}
			rs.close();
			stmt.close();
			return professores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	 
	 

}
