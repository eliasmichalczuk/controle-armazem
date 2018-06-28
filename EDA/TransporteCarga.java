/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDA;

/**
 *
 * @author Administrador
 */
public class TransporteCarga {
    public long cod;
    public long cpf;
    public long codbarra;
    public String data;
    public String hora;

    public TransporteCarga(long cod, long cpf, long codbarra, String data, String hora) {
        this.cod = cod;
        this.cpf = cpf;
        this.codbarra = codbarra;
        this.data = data;
        this.hora = hora;
    }
           
    
}
