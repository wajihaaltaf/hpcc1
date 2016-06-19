/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import static org.apache.jena.tdb.sys.FileRef.file;
import org.apache.jena.util.FileManager;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.RDFXMLOntologyFormat;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

/**
 *
 * @author Bisma
 */
public class deleteplace extends javax.swing.JFrame {

    /**
     * Creates new form deleteplace
     */
    public deleteplace() {
        initComponents();
        shower();
    }
void shower() 
    {
      
      OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
FileManager.get().readModel( model, "jkp.owl" );
String queryString ="prefix uni: <http://www.semanticweb.org/bisma/ontologies/2016/2/noveljkp.owl#> \n" +
"select * {?Novel uni:isa uni:Author}";
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

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(742, 478));
        setMinimumSize(new java.awt.Dimension(742, 478));
        setPreferredSize(new java.awt.Dimension(742, 478));
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Khmer UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("NOVEL MANIA");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 750, 70);

        jLabel3.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jLabel3.setText("Select Author Name:");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(330, 70, 140, 50);

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1state(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(210, 110, 350, 40);

        jLabel5.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jLabel5.setText("Select Novel Name:");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(330, 140, 140, 50);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(210, 180, 350, 40);

        jLabel2.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jLabel2.setText("Select Character Name:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(320, 210, 170, 50);

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(210, 250, 350, 40);

        jButton1.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 350, 230, 50);

        jButton3.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jButton3.setText("BACK");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(400, 350, 210, 50);

        jLabel1.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Bisma\\Documents\\NetBeansProjects\\OntologyNovel\\images\\7.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-20, 0, 750, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1state(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1state

    }//GEN-LAST:event_jComboBox1state

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String getauthor=(String) jComboBox1.getSelectedItem();
        jComboBox2.removeAllItems();
        getauthor=getauthor.replaceAll("\\s+","");
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
        FileManager.get().readModel( model, "jkp.owl" );
        String queryString ="prefix uni: <http://www.semanticweb.org/bisma/ontologies/2016/2/noveljkp.owl#> \n" +
        "select * {?Novel uni:written_by uni:"+getauthor+"}";
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

            jComboBox2.addItem(array[i]);
        }
        jComboBox2.addItem(lastOne);

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        jComboBox3.removeAllItems();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String author= (String) jComboBox1.getSelectedItem();
        String novel= (String) jComboBox2.getSelectedItem();
        String character= (String) jComboBox3.getSelectedItem();
        if( "".equals(character) || "".equals(author) || "".equals(novel) )
        {
            JOptionPane.showMessageDialog(null, "Enter all fields");
        }
        else {

            try {
                character= character.replaceAll("\\s+","");
                author= author.replaceAll("\\s+","");
                novel= novel.replaceAll("\\s+","");
                IRI ontologyIRI = IRI.create("http://www.semanticweb.org/bisma/ontologies/2016/2/noveljkp.owl");
                OWLOntologyManager man = OWLManager.createOWLOntologyManager();
                OWLOntology ontology = man.loadOntologyFromOntologyDocument(new File("jkp.owl"));
                OWLDataFactory factory = man.getOWLDataFactory();
                PrefixManager pm = new DefaultPrefixManager(ontologyIRI+"#");
                OWLClass person = factory.getOWLClass(":Novel", pm);
                OWLClass woman = factory.getOWLClass(IRI.create(ontologyIRI + "#Character"));
                OWLNamedIndividual authorname = factory.getOWLNamedIndividual(":"+character, pm);
                //insert with adding type:

                OWLClassAssertionAxiom classAssertion;
                classAssertion = factory.getOWLClassAssertionAxiom(woman, authorname);
                man.removeAxiom(ontology, classAssertion);
                man.saveOntology(ontology, new RDFXMLOntologyFormat());

            } catch (OWLOntologyCreationException ex) {
                Logger.getLogger(insertauthor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (OWLOntologyStorageException ex) {
                Logger.getLogger(insertauthor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Deletion s=new Deletion();
        s.setVisible(true);
        deleteplace.this.setVisible(false);
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
            java.util.logging.Logger.getLogger(deleteplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deleteplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deleteplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deleteplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deleteplace().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
