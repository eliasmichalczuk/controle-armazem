package app;

import DAO.BancoDados;


/**
 * @author UDESC
 */
public class Main {
    private static BancoDados bd;
    private static MainWindow window;
            
    public static void main(String[] args){
        bd = new BancoDados();
        window = new MainWindow();
        window.setVisible( true );
    }
    
    public static BancoDados getBD(){
        return bd;
    }
    
    public static void showMainWindow(){
        window.setVisible( true );
    }
    
}
