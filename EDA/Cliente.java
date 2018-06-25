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
    public long qtd;
    public String nom21;
    public String nome;
    public String endereco;

    public Cliente(long codCLiente, String nomeFantasia, long quantidadeCarga) {
        this.codCliente = codCLiente;
        this.nomeFantasia = nomeFantasia;
        this.quantidadeCarga = quantidadeCarga;
    }

    public Cliente(long qtd, String nom21, String nome, String endereco) {
        this.qtd = qtd;
        this.nom21 = nom21;
        this.nome = nome;
        this.endereco = endereco;
    }
    
    
}
