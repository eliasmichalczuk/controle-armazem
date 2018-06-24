/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import DAO.Connect;
import EDA.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author Elias
 */
public class CadCliente extends javax.swing.JFrame {
 boolean ehCadastro = true;
    /**
     * Creates new form Cadastro1
     */
    public CadCliente(boolean cadastrar) {
        initComponents();
        if( cadastrar ){
            rotuloTitulo.setText("Cadastrar Cliente");
            botaoAcao.setText("Cadastrar");
        }
        else{
            rotuloTitulo.setText("Alterar Cliente");
            botaoAcao.setText("Consultar");
            alterarEdicaoCampos( false );
            campocodigo.setEnabled( true );
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rotuloTitulo = new javax.swing.JLabel();
        labelcodigo = new javax.swing.JLabel();
        labelnome = new javax.swing.JLabel();
        labelqtd = new javax.swing.JLabel();
        botaoAcao = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        campocodigo = new javax.swing.JTextField();
        campoqtd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        camponome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rotuloTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        rotuloTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rotuloTitulo.setText("Dados do cliente");

        labelcodigo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        labelcodigo.setText("Código:");

        labelnome.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        labelnome.setText("Nome:");

        labelqtd.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        labelqtd.setText("Quantidade: ");

        botaoAcao.setBackground(new java.awt.Color(204, 255, 204));
        botaoAcao.setText("acao");
        botaoAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAcaoActionPerformed(evt);
            }
        });

        botaoCancelar.setBackground(new java.awt.Color(255, 153, 153));
        botaoCancelar.setText("Voltar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clinica Tabajara");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rotuloTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelcodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelnome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(camponome, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoAcao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(labelqtd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rotuloTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelcodigo)
                    .addComponent(campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelnome)
                    .addComponent(camponome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoqtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAcao)
                    .addComponent(botaoCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAcaoActionPerformed
        if( ehCadastro ){
            tratarCadastro();
        }

        else{ //é alteração
            tratarAlteracao();
        }
    }//GEN-LAST:event_botaoAcaoActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        int acao = JOptionPane.showConfirmDialog(this, "Você tem certeza que deseja voltar?\n"
            + "Todos os dados digitados serão perdidos.", "Confirmação",
            JOptionPane.YES_NO_OPTION );

        if( acao == JOptionPane.NO_OPTION ) return;

        Armazem.showTelaInicial();
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

       private void tratarAlteracao()
       {
           if( campocodigo.isEnabled() ){
            int codigo;
            try{
                codigo = Integer.parseInt( campocodigo.getText() );
            } catch ( NumberFormatException ex ){
                showErroPreenchimento();
                return;
            }

            Cliente cl = Armazem.getBD().getCliente(codigo);
            if( cl==null ){
                JOptionPane.showMessageDialog(this, "Nenhum cliente foi encontrado com este código!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                campocodigo.setText( ""+cl.codCliente );
                camponome.setText( cl.nomeFantasia );
                campoqtd.setText(""+cl.quantidadeCarga );
                alterarEdicaoCampos( true );
                campocodigo.setEnabled( false );
                botaoAcao.setText("Alterar");
            }
        }

        else{ // realizar alteração na tabela
            if( verificarErros() ){
                showErroPreenchimento();
                return;
            }
            long cod, qtd;
            try{
                cod = Long.parseLong( campocodigo.getText() );
                qtd = Long.parseLong( campoqtd.getText() );
            } catch ( NumberFormatException ex ){
                showErroPreenchimento();
                return;
            }
            Cliente cliente = new Cliente(cod, camponome.getText(), qtd);
            boolean resultado = Armazem.getBD().alterarCliente(cliente);
            if( resultado == false ){
                showErroBD();
                return;
            }
            int opcao = JOptionPane.showConfirmDialog(this, "Dados alterados com sucesso.\n"
                    + "Deseja alterar outro registro?", "Operação Realizada com Sucesso", JOptionPane.YES_NO_OPTION);
            if( opcao == JOptionPane.YES_OPTION ){
                limpaCampos();
                alterarEdicaoCampos( false );
                campocodigo.setEnabled( true );
                botaoAcao.setText("Consultar");
            }
            else{
                Main.showMainWindow();
                this.dispose();
            }
        }
       }
       private void tratarCadastro(){
        if( verificarErros() ){
                showErroPreenchimento();
                return;
            }
            long cod, qtd;
            String nome;
            try{
                cod = Long.parseLong( campocodigo.getText() );
                qtd = Long.parseLong( campoqtd.getText() );
            } catch ( NumberFormatException ex ){
                showErroPreenchimento();
                return;
            }
            
            Cliente cliente = new Cliente(cod, camponome.getText(), qtd);
            boolean resultado = Armazem.getBD().cadastrarCliente(cliente);
            if( resultado == false ){
                showErroBD();
                return;
            }
            int opcao = JOptionPane.showConfirmDialog(this, "Paciente adicionado com sucesso.\n"
                    + "Deseja adicionar outro registro?", "Operação Realizada com Sucesso", JOptionPane.YES_NO_OPTION);
            if( opcao == JOptionPane.YES_OPTION ){
                limpaCampos();
            }
            else{
                Main.showMainWindow();
                this.dispose();
            }
    }
    private boolean verificarErros(){
        if( camponome.getText().length()<=3 && campoqtd.getText().length()<=1 ){
            showErroPreenchimento();
            return true;
        }
        return false;
    }
    
    private void showErroPreenchimento(){
        JOptionPane.showMessageDialog(this, "Verifique o preenchimento dos dados!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    private void showErroBD(){
        JOptionPane.showMessageDialog(this, "Ocorreu algum erro ao registrar dados no BD!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
        private void limpaCampos(){
        camponome.setText("");
        campoqtd.setText("");
    }
        
    
    private void alterarEdicaoCampos(boolean opcao){
        camponome.setEnabled( opcao );
        campoqtd.setEnabled( opcao );
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAcao;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JTextField campocodigo;
    private javax.swing.JTextField camponome;
    private javax.swing.JTextField campoqtd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelcodigo;
    private javax.swing.JLabel labelnome;
    private javax.swing.JLabel labelqtd;
    private javax.swing.JLabel rotuloTitulo;
    // End of variables declaration//GEN-END:variables
}
