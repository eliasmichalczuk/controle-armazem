/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDA;

/**
 *
 * @author udesc
 */
public class Cliente {
    public long codCliente;
    public String nomeFantasia;
    public long quantidadeCarga;

    public Cliente(long codCLiente, String nomeFantasia, long quantidadeCarga) {
        this.codCliente = codCLiente;
        this.nomeFantasia = nomeFantasia;
        this.quantidadeCarga = quantidadeCarga;
    }
    
    
}
