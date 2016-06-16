/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

/**
 *
 * @author Bisma
 */
public class insertplace extends javax.swing.JFrame {

    /**
     * Creates new form insertplace
     */
    public insertplace() {
        initComponents();
           shower();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(742, 478));
        setMinimumSize(new java.awt.Dimension(742, 478));
        setPreferredSize(new java.awt.Dimension(742, 478));
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Khmer UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NOVEL MANIA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 750, 70);

        jLabel6.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jLabel6.setText("Enter Place Name:");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 100, 170, 50);

        jLabel2.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jLabel2.setText("Place Belongs to:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 160, 120, 50);

        jLabel4.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jLabel4.setText("Enter Place Discription:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 220, 160, 50);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(220, 100, 350, 40);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(220, 160, 350, 40);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 230, 350, 160);

        jButton1.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jButton1.setText("INSERT");
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 410, 230, 50);

        jButton3.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jButton3.setText("BACK");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(400, 410, 210, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/7.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 890, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void shower()
    {
         OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
FileManager.get().readModel( model, "jkp.owl" );
String queryString ="prefix uni: <http://www.semanticweb.org/bisma/ontologies/2016/2/noveljkp.owl#> \n" +
"select * {?Novel uni:isa uni:Novel}";
Query query = QueryFactory.create(queryString);
QueryExecution qe= QueryExecutionFactory.create(query, model);
org.apache.jena.query.ResultSet resultset = qe.execSelect();
java.io.ByteArrayOutputStream baos= new java.io.ByteArrayOutputStream();
            ResultSetFormatter.outputAsCSV(baos, resultset);
            String answer= baos.toString();
           answer= java.util.Arrays.toString(answer.split("http://www.semanticweb.org/bisma/ontologies/2016/2/noveljkp.owl#"));
       String[]  array = answer.split(",");
       String lastOne = array[array.length-1];
       lastOne=lastOne.substring(0,lastOne.length()-1);
       for(int i=1;i<array.length-1;i++)
       {
       
           jComboBox1.addItem(array[i]);
       }
            jComboBox1.addItem(lastOne);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       admin s=new admin();
        s.setVisible(true);
      insertplace.this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(insertplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insertplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insertplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insertplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insertplace().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
