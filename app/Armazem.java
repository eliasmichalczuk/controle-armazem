/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import DAO.Connect;

/**
 *
 * @author Elias
 */
public class Armazem {
    private static Connect bd;
    private static TelaInicial tela;
    private static CadCliente cliente;
    
    public static void main(String[] args){
        bd = new Connect();
        tela = new TelaInicial();
        tela.setVisible( true );
        //cliente = new Cadastro1();
        //cliente.setVisible(true);
    }
    
     public static Connect getBD(){
        return bd;
    }
    
    public static void showTelaInicial(){
        tela.setVisible( true );
    }
    
}
