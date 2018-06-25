/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDA;

/**
 *
 * @author Elias
 */
public class Funcionario {
    public long cpf;
    public long coddep;
    public String nome;
    public String endereco;
    public String telefone;

    public Funcionario(long cpf, long coddep, String nome, String endereco, String telefone) {
        this.cpf = cpf;
        this.coddep = coddep;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    
}
