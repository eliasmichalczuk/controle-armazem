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
    
    public String cdata;
    public String tdata;
    public String chora;
    public String thora;
    public long posicao;
    public long inicio;
    public long fim;
    public long cod;
    
    public String dep;
    public int soma;
    public int qtd;
    

    public Funcionario(long cpf, long coddep, String nome, String endereco, String telefone) {
        this.cpf = cpf;
        this.coddep = coddep;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Funcionario(String cdata, String tdata, String chora, String thora,long posicao, long inicio, long fim, long cod) {
        this.cdata = cdata;
        this.tdata = tdata;
        this.chora = chora;
        this.thora = thora;
        this.posicao = posicao;
        this.inicio = inicio;
        this.fim = fim;
        this.cod = cod;
    }

    public Funcionario(String nome, String tdata, String chora) {
        this.nome = nome;
        this.tdata = tdata;
        this.chora = chora;
    }

    public Funcionario(String dep, int soma, int qtd) {
        this.dep = dep;
        this.soma = soma;
        this.qtd = qtd;
    }
        
    
    
}
