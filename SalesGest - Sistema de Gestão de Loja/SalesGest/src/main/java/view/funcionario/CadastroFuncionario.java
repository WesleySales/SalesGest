
package view.funcionario;

import entities.funcionario.CargoFuncionario;
import entities.funcionario.Usuario;
import entities.funcionario.UsuarioDAO;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wesle
 */
public class CadastroFuncionario extends javax.swing.JFrame {

    private UsuarioDAO usuarioDAO;
    private CargoFuncionario cargo;
    public int contFuncionarios;
    public double folhaSalarial;

    public CadastroFuncionario() {
        initComponents();
        this.usuarioDAO = new UsuarioDAO();
        exibirListaDeFuncionarios();
        
        contagemFuncionarios.setText(String.valueOf(contFuncionarios));
        contagemFuncionarios1.setText(String.valueOf(folhaSalarial));
    }
        
    private void configurarPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK); // Cor do texto normal
                }
            }
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY); // Cor do placeholder
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        btnEncerrar = new javax.swing.JButton();
        btnDeletarFuncionario = new javax.swing.JButton();
        btnCadastrarFuncionario = new javax.swing.JButton();
        btnEditarFuncionario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        contagemFuncionarios = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        contagemFuncionarios1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("MENU FUNCIONÁRIOS");

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Cargo", "Login", "Salario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFuncionarios);

        btnEncerrar.setText("X");
        btnEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarActionPerformed(evt);
            }
        });

        btnDeletarFuncionario.setText("DELETAR");
        btnDeletarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarFuncionarioActionPerformed(evt);
            }
        });

        btnCadastrarFuncionario.setText("CADASTRAR NOVO FUNCIONÁRIO");
        btnCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFuncionarioActionPerformed(evt);
            }
        });

        btnEditarFuncionario.setText("EDITAR");
        btnEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarFuncionarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Numero de Funcionarios:");

        contagemFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setText("Folha Salarial: ");

        contagemFuncionarios1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(contagemFuncionarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(btnEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(contagemFuncionarios))
                            .addComponent(btnCadastrarFuncionario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeletarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(contagemFuncionarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(contagemFuncionarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarFuncionario)
                    .addComponent(btnEditarFuncionario)
                    .addComponent(btnDeletarFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void exibirListaDeFuncionarios() {
        DefaultTableModel model = (DefaultTableModel) tblFuncionarios.getModel();
        tblFuncionarios.setDefaultEditor(Object.class, null);
        model.setRowCount(0);

        List<Usuario> funcionarios = usuarioDAO.listarTodosUsuarios();
        contFuncionarios = funcionarios.size();
        folhaSalarial = usuarioDAO.getFolhaSalarial(funcionarios);
        
        if (!funcionarios.isEmpty()) {
            for (Usuario u : funcionarios) {
                model.addRow(new Object[]{
                    u.getId(),
                    u.getNome(),
                    u.getCargo().getNome_cargo(),
                    u.getLogin(),
                    u.getCargo().getRemuneracao_base()
                });
            }
        } else {
            System.out.println("A lista esta vazia");
        }
    }
    
    private void btnEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnEncerrarActionPerformed

    private void btnCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFuncionarioActionPerformed
        var telaCadastro = new TelaCadastroFuncionario();
        telaCadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastrarFuncionarioActionPerformed

    private void btnDeletarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarFuncionarioActionPerformed
        int selecionado = tblFuncionarios.getSelectedRow();

        if (selecionado != -1) {
            int id_funcionario = (int) tblFuncionarios.getValueAt(selecionado, 0);
            usuarioDAO.deletarUsuario(id_funcionario);
            JOptionPane.showMessageDialog(rootPane, "Produto deletado com sucesso");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para DELETAR.");
        }

        exibirListaDeFuncionarios();
    }//GEN-LAST:event_btnDeletarFuncionarioActionPerformed

    private void btnEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFuncionarioActionPerformed
        int selecionado = tblFuncionarios.getSelectedRow();

        if (selecionado != -1) {
            int id_funcionario = (int) tblFuncionarios.getValueAt(selecionado, 0);
            var u = usuarioDAO.buscarUsuarioPorId(id_funcionario);

//            String novoNome = JOptionPane.showInputDialog(rootPane, "Editando: " + p.getNome() + ". Digite o novo nome: ");
//            double novoPreco = Double.parseDouble(JOptionPane.showInputDialog(rootPane, "Editando: " + p.getNome() + ". Digite o novo preco: "));
//            int novoEstoque = Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Editando: " + p.getNome() + ". Digite o novo estoque: "));
//
//            String resultado = produto.editarProduto(novoNome, novoPreco, novoEstoque, id_produto);
//
//            JOptionPane.showMessageDialog(rootPane, p.getNome() + " - " + resultado);
//            exibirListaDeProdutos();

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para DELETAR.");
        }
    }//GEN-LAST:event_btnEditarFuncionarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarFuncionario;
    private javax.swing.JButton btnDeletarFuncionario;
    private javax.swing.JButton btnEditarFuncionario;
    private javax.swing.JButton btnEncerrar;
    private javax.swing.JLabel contagemFuncionarios;
    private javax.swing.JLabel contagemFuncionarios1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblFuncionarios;
    // End of variables declaration//GEN-END:variables
}
