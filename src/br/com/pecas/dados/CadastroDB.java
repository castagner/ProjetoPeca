package br.com.pecas.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pecas.entidade.Cadastro;
import br.com.pecas.util.Conexao;

public class CadastroDB {

	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public CadastroDB() {
		connection = Conexao.getConnection();
	}
	
	public boolean inserir (Cadastro cadastro) throws SQLException{
		try {
			PreparedStatement stmt = this.connection
		    .prepareStatement("INSERT INTO PECA(nome, peso, tipo, dataCadastro, valor) values (?, ?, ?, ? ,?)");
		
			stmt.setString(1, cadastro.getNome());
			stmt.setDouble(2, cadastro.getPeso());
			stmt.setString(3, cadastro.getTipo());
			stmt.setString(4, cadastro.getDataCadastro());
			stmt.setDouble(5, cadastro.getValor());
			
			stmt.execute();
			return true;
			
		}catch (SQLException e) {
				System.err.println(e.toString());
			} finally {
				connection.close();
			}
			return false;
	}
		
		public boolean alterar (Cadastro cadastro) throws SQLException{
			try {
				PreparedStatement stmt = this.connection
			    .prepareStatement("UPDATE  PECA SET nome = ?, peso = ?, dataCadastro = ?, valor = ? WHERE id = ?");
				
				stmt.setString(1, cadastro.getNome());
				stmt.setDouble(2, cadastro.getPeso());
				stmt.setString(3, cadastro.getTipo());
				stmt.setString(4, cadastro.getDataCadastro());
				stmt.setDouble(5, cadastro.getValor());
				stmt.setInt(6, cadastro.getID());
				 
				stmt.execute();
				return true;
			} catch (SQLException e){
				System.err.println(e.toString());
			}finally{
				connection.close();
			}
			return false;
		}
		
		public List<Cadastro> getAll(){
			List<Cadastro> lstCadastro = new ArrayList<>();
			
			try {
				ps = this.connection.prepareStatement("SELECT id, nome, peso, tipo, dataCadastro, valor from PECA");
				rs = ps.executeQuery();
				
				while (rs.next()) {
					lstCadastro.add(new Cadastro (rs.getInt("id"), rs.getString("nome"), rs.getDouble("peso"),
				    rs.getString("tipo"), rs.getString("dataCadastro"), rs.getDouble("valor")));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return lstCadastro();
			
		}
			
}
