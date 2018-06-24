package DAO;
import EDA.Cliente;
import EDA.Paciente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author UDESC
 */
public class Connect {
    static Connection c = null;
    
    private boolean conectar(){
        try {
            //Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/armazem",
                                            "postgres", "postgres");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean cadastrarCliente(Cliente cl){
        if( !conectar() ) return false;
        Cliente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "INSERT INTO cliente (codCliente, nomeFantasia, quantidadeCarga)"
                    + "VALUES ("+cl.codCliente+", '"+cl.nomeFantasia+"',"+cl.quantidadeCarga+")";
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE INSERÇÃO: cadastrarCliente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    
    public boolean alterarCliente(Cliente cl){
        if( !conectar() ) return false;
        Cliente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "UPDATE cliente SET nomeFantasia = '"+cl.nomeFantasia+"', cpf = "+cl.quantidadeCarga+", "
                    + "WHERE codCliente = "+cl.codCliente;
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE ATUALIZAÇÃO: alterarCliente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    
    public Cliente getCliente(long cod ){
        if( !conectar() ) return null;
        Cliente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM cliente WHERE codCliente = "+cod;
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                long codCliente = rs.getLong("codCliente");
                String nomeFantasia = rs.getString("nomeFantasia");
                long  quantidadeCarga = rs.getLong("quantidadeCarga");
                resultado = new Cliente(codCliente, nomeFantasia, quantidadeCarga);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getCliente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
    public ArrayList<Cliente> getClientes(){
        if( !conectar() ) return null;
        ArrayList<Cliente> resultado = new ArrayList();
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM cliente";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                long codCliente = rs.getLong("codCliente");
                String nomeFantasia = rs.getString("nomeFantasia");
                long  quantidadeCarga = rs.getLong("quantidadeCarga");
                resultado.add ( new Cliente(codCliente, nomeFantasia, quantidadeCarga));
                //resultado.add = new Cliente(codCliente, nomeFantasia, quantidadeCarga);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getClientes");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
    public boolean excluirCliente(int cod)
    {
         if( !conectar() ) return false;
         try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "delete FROM cliente where codCliente = "+cod;
            ResultSet rs = stmt.executeQuery( sql );
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE DELETE: excluirCliente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
         return true;
    }
    
    
    // banco hospital
    
    public ArrayList<Paciente> getPacientes(){
        if( !conectar() ) return null;
        ArrayList<Paciente> resultado = new ArrayList();
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM pacientes";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                int codp = rs.getInt("codp");
                String  name = rs.getString("nome");
                String  cpf = rs.getString("cpf");
                int idade  = rs.getInt("idade");
                String cidade = rs.getString("cidade");
                resultado.add( new Paciente(codp, name, cpf, idade, cidade) );
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getPacientes");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
    
    public Paciente getPaciente(int codigo){
        if( !conectar() ) return null;
        Paciente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM pacientes WHERE codp = "+codigo;
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                int codp = rs.getInt("codp");
                String  name = rs.getString("nome");
                String  cpf = rs.getString("cpf");
                int idade  = rs.getInt("idade");
                String cidade = rs.getString("cidade");
                resultado = new Paciente(codp, name, cpf, idade, cidade);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getPaciente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
    
    
    public boolean cadastrarPaciente(Paciente p){
        if( !conectar() ) return false;
        Paciente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "INSERT INTO pacientes (codp, nome, cpf, idade, cidade)"
                    + "VALUES ("+p.codp+", '"+p.nome+"', '"+p.cpf+"', "+p.idade+", '"+p.cidade+"')";
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE INSERÇÃO: cadastrarPaciente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    
    
    
    public boolean alterarPaciente(Paciente p){
        if( !conectar() ) return false;
        Paciente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "UPDATE pacientes SET nome = '"+p.nome+"', cpf = '"+p.cpf+"', "
                    + "idade = "+p.idade+", cidade = '"+p.cidade+"' "
                    + "WHERE codp = "+p.codp;
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE ATUALIZAÇÃO: alterarPaciente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    
}