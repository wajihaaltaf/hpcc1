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
public class NovelSearch extends javax.swing.JFrame {

    /**
     * Creates new form NovelSearch
     */
    public NovelSearch() {
        initComponents();
        shower();
    }
void shower()
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(730, 500));
        setMinimumSize(new java.awt.Dimension(730, 500));
        setPreferredSize(new java.awt.Dimension(730, 500));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Khmer UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOVEL MANIA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 4, 770, 70);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(180, 130, 410, 60);

        jButton1.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(300, 220, 200, 40);

        jButton2.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jButton2.setText("BACK");
        jButton2.setMaximumSize(new java.awt.Dimension(87, 25));
        jButton2.setMinimumSize(new java.awt.Dimension(87, 25));
        jButton2.setPreferredSize(new java.awt.Dimension(87, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(300, 280, 200, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/8.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -40, 770, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Name = jComboBox1.getSelectedItem().toString();
        NovelDetail s= new  NovelDetail(Name);
        s.setVisible(true);
        NovelSearch.this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        user s= new  user();
        s.setVisible(true);
       NovelSearch.this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(NovelSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovelSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovelSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovelSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovelSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
