package DAO;
import EDA.Cliente;
import EDA.Dep;
import EDA.Funcionario;
import EDA.Paciente;
import EDA.TransporteCarga;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
            String sql = "SELECT * FROM cliente WHERE codcliente = "+cod;
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
    
    public boolean excluirCliente(long cod)
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
    
    public ArrayList<Dep> getDeps(){
        if( !conectar() ) return null;
        ArrayList<Dep> resultado = new ArrayList();
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM departamento";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                long cod = rs.getLong("codDepartamento");
                String desc = rs.getString("descricao");
                long salario = rs.getLong("baseSalarial");
                resultado.add(new Dep(cod, salario, desc));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getDeps");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
    public boolean cadastrarFunc(Funcionario f){
        if( !conectar() ) return false;
        Cliente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
                String sql = "INSERT INTO funcionario (CPFFuncionario, codDepartamento, nome, endereço, telefone)"
                    + "VALUES ("+f.cpf+", "+f.coddep+",'"+f.nome+"','"+f.endereco+"','"+f.telefone+"')";
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
    
    public boolean alterarFunc(Funcionario f){
        if( !conectar() ) return false;
        Cliente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "UPDATE funcionario SET nome = '"+f.nome+"', codDepartamento = "+(f.coddep+1)+", endereço = '"+f.endereco+"',  telefone = '"+f.telefone+"'"
                    + "WHERE CPFFuncionario = "+f.cpf;
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE ATUALIZAÇÃO: alterarFunc");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    
    public Funcionario getFunc(long cpf ){
        if( !conectar() ) return null;
        Funcionario resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM funcionario WHERE CPFFuncionario = "+cpf;
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                cpf = rs.getLong("CPFFuncionario");
                long coddep = rs.getLong("codDepartamento");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereço");
                String telefone = rs.getString("telefone");
                resultado = new Funcionario(cpf, coddep, nome, endereco, telefone);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getFunc");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    public ArrayList<Funcionario> getFuncs(){
        if( !conectar() ) return null;
         ArrayList<Funcionario> resultado = null;
//        try{
//            Statement stmt = null;
//            stmt = c.createStatement();
//            String sql = "SELECT * FROM funcionario";
//            ResultSet rs = stmt.executeQuery( sql );
//            while ( rs.next() ) {
//                long cpf = rs.getLong("CPFFuncionario");
//                long coddep = rs.getLong("codDepartamento");
//                String nome = rs.getString("nome");
//                String endereco = rs.getString("endereco");
//                String telefone = rs.getString("telefone");
//                resultado.add(new Funcionario(cpf, coddep, nome, endereco, telefone));
//            }
//            
//            rs.close();
//            stmt.close();
//            c.close();
//        } catch ( Exception e ) {
//            System.err.println( "ERRO DURANTE CONSULTA: getFuncs");
//            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//        }
        resultado.add(new Funcionario(8, 1, "mano", "mano", "mano"));
        return resultado;
    }
    public ArrayList<Funcionario> getFuncs1(){
        if( !conectar() ) return null;
        ArrayList<Funcionario> resultado = new ArrayList();
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM funcionario";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                long cpf = rs.getLong("CPFFuncionario");
                long coddep = rs.getLong("codDepartamento");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereço");
                String telefone = rs.getString("telefone");
                resultado.add(new Funcionario(cpf, coddep, nome, endereco, telefone));
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
    
    
    public boolean excluirFunc(long cod)
    {
         if( !conectar() ) return false;
         try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "delete FROM funcionario where CPFFuncionario = "+cod;
            ResultSet rs = stmt.executeQuery( sql );
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE DELETE: excluirFunc");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
         return true;
    }
    
    public ArrayList<Funcionario> consultaUm(){
        if( !conectar() ) return null;
       ArrayList<Funcionario> resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT funcionario.nome as \"Operador de empilhadeira\" , tranportaCarga.data as \"Data do transporte\" ,tranportaCarga.hora as \"Hora do tranporte\"\n" +
"FROM funcionario , operadorEmpilhadeira , carga , tranportaCarga\n" +
"WHERE funcionario.CPFFuncionario = operadorEmpilhadeira.CPFFuncionario -- funcionario x operadorEmpilhadeira\n" +
"AND carga.codBarra = tranportaCarga.codBarra -- carga x transporta\n" +
"AND tranportaCarga.CPFFuncionario = funcionario.CPFFuncionario -- funcionario x transporta\n" +
"order by tranportaCarga.data asc";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                String ope = rs.getString("Operador de empilhadeira");
                String data = rs.getString("Data do transporte");
                String hora = rs.getString("Hora do tranporte");
                resultado.add(new Funcionario(ope,data,hora));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getFunc");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }

public ArrayList<Cliente> consultaDois(){
        if( !conectar() ) return null;
       ArrayList<Cliente> resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT cliente.nomeFantasia,notaFiscal.quantidadeCarga,ordem.tipoOrdem,tipoCarga.descricao\n" +
"FROM cliente , notaFiscal, carga , tipoCarga , ordem\n" +
"WHERE cliente.codCliente = notaFiscal.codCliente\n" +
"AND carga.DANFE = notaFiscal.DANFE\n" +
"AND carga.codCliente = cliente.codCliente\n" +
"AND carga.codTipoCarga=tipoCarga.codTipoCarga\n" +
"AND ordem.codBarra = carga.codBarra\n" +
"and ordem.codOrdem = cliente.codordemSELECT cliente.nomeFantasia,notaFiscal.quantidadeCarga,ordem.tipoOrdem,tipoCarga.descricao\n" +
"FROM cliente , notaFiscal, carga , tipoCarga , ordem\n" +
"WHERE cliente.codCliente = notaFiscal.codCliente\n" +
"AND carga.DANFE = notaFiscal.DANFE\n" +
"AND carga.codTipoCarga=tipoCarga.codTipoCarga\n" +
"AND ordem.codBarra = carga.codBarra\n" +
"order by notaFiscal.quantidadeCarga asc";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                long qtd = rs.getInt("quantidadeCarga");
                String nom21 = rs.getString("nomeFantasia");
                String nome = rs.getString("tipoOrdem");
                String endereco = rs.getString("descricao");
                resultado.add(new Cliente(qtd, nom21, nome, endereco));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getFunc");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }

    public ArrayList<Funcionario> consultaTres(){
        if( !conectar() ) return null;
       ArrayList<Funcionario> resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT tranportaCarga.data as \"Data do transporte\",tranportaCarga.hora as \"Hora do tranporte\",confereCarga.hora as \"Hora da Conferencia\",confereCarga.data as \"Data da Conferencia\",alocacao.posicaoCorredor as \"Posição\",corredor.incioCorredor as \"inicio\",corredor.finalCorredor as \"fim\",armazem.codArmazem as \"codarm\"\n" +
"FROM confereCarga,tranportaCarga,alocacao,corredor,armazem\n" +
"WHERE confereCarga.codBarra = tranportaCarga.codBarra\n" +
"AND alocacao.codBarra = confereCarga.codBarra\n" +
"AND alocacao.codBarra = tranportaCarga.codBarra\n" +
"AND corredor.codCorredor = alocacao.codCorredor\n" +
"AND corredor.codArmazem = armazem.codArmazem\n" +
"order by tranportaCarga.data asc";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                String tdata = rs.getString("Data do transporte");
                String thora = rs.getString("Hora do tranporte");
                String chora = rs.getString("Hora da Conferencia");
                String cdata = rs.getString("Data da Conferencia");
                long posicao = rs.getLong("Posição");
                long inicio = rs.getLong("incio");
                long fim = rs.getLong("fim");
                long cod = rs.getLong("codarm");
                resultado.add(new Funcionario(cdata,tdata,chora,thora,posicao,inicio,fim,cod));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getFunc");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    public ArrayList<Funcionario> consultaQuatro(){
        if( !conectar() ) return null;
       ArrayList<Funcionario> resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT funcionario.nome , confereCarga.data,confereCarga.hora\n" +
"FROM funcionario , operadorEmpilhadeira , carga , confereCarga\n" +
"WHERE funcionario.CPFFuncionario = operadorEmpilhadeira.CPFFuncionario -- funcionario x operadorEmpilhadeira\n" +
"AND carga.codBarra = confereCarga.codBarra -- carga x transporta\n" +
"AND confereCarga.CPFFuncionario = funcionario.CPFFuncionario -- funcionario x transporta";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                    String nome = rs.getString("nome");
                    String data = rs.getString("data");
                    String hora = rs.getString("hora");
                resultado.add(new Funcionario(nome,data,hora));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getFunc");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
    public ArrayList<Funcionario> consultaCinco(){
        if( !conectar() ) return null;
       ArrayList<Funcionario> resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT departamento.descricao as \"Departamento\" , sum(baseSalarial) as \"Soma dos salarios\" , count(funcionario.CPFFuncionario) as \"Quantidade de funcionarios\"\n" +
"FROM funcionario , departamento\n" +
"WHERE funcionario.codDepartamento = departamento.codDepartamento\n" +
"group by departamento.descricao\n" +
"order by sum(baseSalarial) desc";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                    String dep = rs.getString("Departamento");
                    int soma = rs.getInt("Soma dos salarios");
                    int qtd = rs.getInt("Quantidade de funcionarios");
                resultado.add(new Funcionario(dep,soma,qtd));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getFunc");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }

    public ArrayList<TransporteCarga>getCargas(String query)
    {
      if( !conectar() ) return null;
      ArrayList<TransporteCarga> resultado = new ArrayList();
         try{
            Statement stmt = null;
            stmt = c.createStatement();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf1.parse(query);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            String sql = "Select * from tranportaCarga where data > '"+sqlStartDate+"'";
            //String sql = "Select * from tranportaCarga";
             System.out.println(sqlStartDate);
            ResultSet rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                Long cod = rs.getLong("codtransporta");
                Long cpf = rs.getLong("cpffuncionario");
                Long codbarras = rs.getLong("codbarra");
                String data = rs.getString("data");
                String hora = rs.getString("hora");
                resultado.add(new TransporteCarga(cod, cpf, codbarras, data , hora));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE DELETE: getCargas");
            e.printStackTrace();
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
         return resultado;  
    }



    
    // banco hospital
 
    
}
