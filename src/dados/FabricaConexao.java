package dados;
import java.sql.*;


public class FabricaConexao {
	//Usuário do banco
	private static final String USUARIO = "root";
	
	//Senha do banco
	private static final String SENHA = "root";
	
	//Caminho do banco de dados, porta, nome do banco de dados
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sistemaacademico?useSSL=false";

	
	public Connection getConnection()  {
			try {
				DriverManager.registerDriver(new  com.mysql.jdbc.Driver());
				return DriverManager.getConnection(CONNECTION_URL, USUARIO, SENHA);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
	}
	
	/*public static void main(String[] args)  {
		FabricaConexao conexao = new FabricaConexao();
		System.out.println(conexao.getConnection());
		System.out.println("Conexão aberta com sucesso!");
	}*/

	

}
