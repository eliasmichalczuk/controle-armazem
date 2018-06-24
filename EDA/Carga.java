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
public class Carga {
    public int codBarra;
    public int danfe;
    public int codCliente;
    public int codCorredor;
    public String tipoCarga;

    public Carga(int codBarra, int danfe, int codCliente, int codCorredor, String tipoCarga) {
        this.codBarra = codBarra;
        this.danfe = danfe;
        this.codCliente = codCliente;
        this.codCorredor = codCorredor;
        this.tipoCarga = tipoCarga;
    }
    
    
}
