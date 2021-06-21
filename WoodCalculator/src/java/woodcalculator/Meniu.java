package woodcalculator;

import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
/**
 *
 * @author Sabau Ionut
 */
public class Meniu extends javax.swing.JFrame {
    DefaultTableModel modelBusteni;
    DefaultTableModel modelCopaci;
    DefaultTableModel modelFisiereBusteni;
    DefaultTableModel modelFisiereCopaci;
    TableColumnModel modelColoanaSterge;
    
    TreeMap<String, Double> dictionarSpecii = new TreeMap<String, Double>();
    TreeMap<String, Double> dictionarSpeciiVG = new TreeMap<String, Double>();
    /**
     * Creates new form MeniuForm
     */
    public Meniu( ) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelAllCalculators);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        modelBusteni = (DefaultTableModel) jTableBusteni.getModel();
        modelCopaci =  (DefaultTableModel) jTableCopaci.getModel();
        
        dictionarSpecii.put("Molid", 0.67);
        dictionarSpecii.put("Brad", 0.69);
        dictionarSpecii.put("Larice", 0.64);
        dictionarSpecii.put("Duglas", 0.65);
        dictionarSpecii.put("Pin Negru", 0.69);
        dictionarSpecii.put("Fag", 0.68);
        dictionarSpecii.put("Mesteacan", 0.60);
        dictionarSpecii.put("Anin Alb", 0.70);
        dictionarSpecii.put("Plop Tremurator", 0.69);
        dictionarSpecii.put("Gorun", 0.67);
        dictionarSpecii.put("Stejar", 0.68);
        dictionarSpecii.put("Paltin", 0.63);
        dictionarSpecii.put("Ulm", 0.67);
        dictionarSpecii.put("Cer", 0.63);
        dictionarSpecii.put("Carpen", 0.64);
        dictionarSpecii.put("Salcam", 0.60);
        dictionarSpecii.put("Frasin", 0.65);
        dictionarSpecii.put("Salcie", 0.58);
        
        dictionarSpeciiVG.put("Molid", 860.);
        dictionarSpeciiVG.put("Brad", 999.4);
        dictionarSpeciiVG.put("Larice", 951.7);
        dictionarSpeciiVG.put("Duglas", 909.1);
        dictionarSpeciiVG.put("Pin Negru", 900.);
        dictionarSpeciiVG.put("Fag", 1025.);
        dictionarSpeciiVG.put("Mesteacan", 1089.1);
        dictionarSpeciiVG.put("Anin Alb", 950.2);
        dictionarSpeciiVG.put("Plop Tremurator", 944.9);
        dictionarSpeciiVG.put("Gorun", 1050.);
        dictionarSpeciiVG.put("Stejar", 1153.1);
        dictionarSpeciiVG.put("Paltin", 820.);
        dictionarSpeciiVG.put("Ulm", 1000.);
        dictionarSpeciiVG.put("Cer", 952.4);
        dictionarSpeciiVG.put("Carpen", 1000.);
        dictionarSpeciiVG.put("Salcam", 1050.);
        dictionarSpeciiVG.put("Frasin", 960.);
        dictionarSpeciiVG.put("Salcie", 986.6);
        
        jComboBoxSpecie.removeAllItems();
        for(String specie : dictionarSpecii.keySet()){
            jComboBoxSpecie.addItem(specie);
        }
        
        
        jComboBoxSpecieVolumGreutate.removeAllItems();
        jComboBoxSpecieGreutateVolum.removeAllItems();
        for(String specie : dictionarSpeciiVG.keySet()){
            jComboBoxSpecieVolumGreutate.addItem(specie);
            jComboBoxSpecieGreutateVolum.addItem(specie);
        }
        
        
        
    }
    
    
    public Meniu( String user) {
           initComponents();
        this.setLocationRelativeTo(null);
        
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelAllCalculators);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        modelBusteni = (DefaultTableModel) jTableBusteni.getModel();
        modelCopaci =  (DefaultTableModel) jTableCopaci.getModel();
        modelFisiereBusteni = (DefaultTableModel)jTableFisiereBusteni.getModel();
        modelFisiereCopaci = (DefaultTableModel)jTableFisiereCopaci.getModel();
        JlabelActivUser.setText(user);
        
        dictionarSpecii.put("Molid", 0.67);
        dictionarSpecii.put("Brad", 0.69);
        dictionarSpecii.put("Larice", 0.64);
        dictionarSpecii.put("Duglas", 0.65);
        dictionarSpecii.put("Pin Negru", 0.69);
        dictionarSpecii.put("Fag", 0.68);
        dictionarSpecii.put("Mesteacan", 0.60);
        dictionarSpecii.put("Anin Alb", 0.70);
        dictionarSpecii.put("Plop Tremurator", 0.69);
        dictionarSpecii.put("Gorun", 0.67);
        dictionarSpecii.put("Stejar", 0.68);
        dictionarSpecii.put("Paltin", 0.63);
        dictionarSpecii.put("Ulm", 0.67);
        dictionarSpecii.put("Cer", 0.63);
        dictionarSpecii.put("Carpen", 0.64);
        dictionarSpecii.put("Salcam", 0.60);
        dictionarSpecii.put("Frasin", 0.65);
        dictionarSpecii.put("Salcie", 0.58);
        
        dictionarSpeciiVG.put("Molid", 860.);
        dictionarSpeciiVG.put("Brad", 999.4);
        dictionarSpeciiVG.put("Larice", 951.7);
        dictionarSpeciiVG.put("Duglas", 909.1);
        dictionarSpeciiVG.put("Pin Negru", 900.);
        dictionarSpeciiVG.put("Fag", 1025.);
        dictionarSpeciiVG.put("Mesteacan", 1089.1);
        dictionarSpeciiVG.put("Anin Alb", 950.2);
        dictionarSpeciiVG.put("Plop Tremurator", 944.9);
        dictionarSpeciiVG.put("Gorun", 1050.);
        dictionarSpeciiVG.put("Stejar", 1153.1);
        dictionarSpeciiVG.put("Paltin", 820.);
        dictionarSpeciiVG.put("Ulm", 1000.);
        dictionarSpeciiVG.put("Cer", 952.4);
        dictionarSpeciiVG.put("Carpen", 1000.);
        dictionarSpeciiVG.put("Salcam", 1050.);
        dictionarSpeciiVG.put("Frasin", 960.);
        dictionarSpeciiVG.put("Salcie", 986.6);
        
        jComboBoxSpecie.removeAllItems();
        for(String specie : dictionarSpecii.keySet()){
            jComboBoxSpecie.addItem(specie);
        }
        
        
        jComboBoxSpecieVolumGreutate.removeAllItems();
        jComboBoxSpecieGreutateVolum.removeAllItems();
        for(String specie : dictionarSpeciiVG.keySet()){
            jComboBoxSpecieVolumGreutate.addItem(specie);
            jComboBoxSpecieGreutateVolum.addItem(specie);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanelMain = new javax.swing.JPanel();
        jPanelTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_minimize = new javax.swing.JLabel();
        jLabel_close = new javax.swing.JLabel();
        jLabelExit = new javax.swing.JLabel();
        JlabelActivUser = new javax.swing.JLabel();
        jPanelManiu = new javax.swing.JPanel();
        jLabelCopacIcon = new javax.swing.JLabel();
        jLabelBusteanIcon = new javax.swing.JLabel();
        jLabelVolumGreutateIcon = new javax.swing.JLabel();
        jLabelGreutateVolumIcon = new javax.swing.JLabel();
        jLabelSalvariIcon = new javax.swing.JLabel();
        jLabelSalvari = new javax.swing.JLabel();
        jLabelVolumGreutate = new javax.swing.JLabel();
        jLabelGreutateVolum = new javax.swing.JLabel();
        jLabelCopac = new javax.swing.JLabel();
        jLabelBustean = new javax.swing.JLabel();
        jLabelSalvariBusteniIcon = new javax.swing.JLabel();
        jLabelSalvariCopaciIcon = new javax.swing.JLabel();
        jLabelSalvariCopaci = new javax.swing.JLabel();
        jLabelSalvariBusteni = new javax.swing.JLabel();
        jLabelHomeIcon = new javax.swing.JLabel();
        jLabelHome = new javax.swing.JLabel();
        jPanelContent = new javax.swing.JPanel();
        jPanelAllCalculators = new javax.swing.JPanel();
        jPanelBusteni = new javax.swing.JPanel();
        jLabelBusteni115 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelCopac = new javax.swing.JPanel();
        jLabelCopac115 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanelVolumGreutate = new javax.swing.JPanel();
        jLabelVolumGreutate115 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanelGreutateVolum = new javax.swing.JPanel();
        jLabelGreutateVolum115 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanelCalculatorBusteni = new javax.swing.JPanel();
        jLabelBusteniBack = new javax.swing.JLabel();
        jLabelBusteanCalculator = new javax.swing.JLabel();
        jLabelBusteniCalculator = new javax.swing.JLabel();
        jLabelVolum = new javax.swing.JLabel();
        jLabelMC = new javax.swing.JLabel();
        jLabelDiametru = new javax.swing.JLabel();
        jTextFieldDiametru = new javax.swing.JTextField();
        jLabelCM = new javax.swing.JLabel();
        jLabelM = new javax.swing.JLabel();
        jLabelLungime = new javax.swing.JLabel();
        jTextFieldLungime = new javax.swing.JTextField();
        jLabelCantitate = new javax.swing.JLabel();
        jTextFieldCantitate = new javax.swing.JTextField();
        jLabelBuc = new javax.swing.JLabel();
        jButtonCalculeaza = new javax.swing.JButton();
        jLabelVolumMC = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableBusteni = new javax.swing.JTable();
        jButtonStergreTotala = new javax.swing.JButton();
        jButtonStergeBustean = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelTotalMC = new javax.swing.JLabel();
        jButtonSalvareBusteni = new javax.swing.JButton();
        jTextFieldNumeFisier = new javax.swing.JTextField();
        jLabelNumeFisier = new javax.swing.JLabel();
        jPanelCalculatorCopaci = new javax.swing.JPanel();
        jLabelVolumCopaciBack = new javax.swing.JLabel();
        jLabelCopaciCalculator = new javax.swing.JLabel();
        jLabelCopaciCalculatorIcon = new javax.swing.JLabel();
        jLabelVolum1 = new javax.swing.JLabel();
        jLabelMC1 = new javax.swing.JLabel();
        jLabelVolumCopac = new javax.swing.JLabel();
        jLabelDiametruPiept = new javax.swing.JLabel();
        jTextFieldDiametruPiept = new javax.swing.JTextField();
        jLabelCM1 = new javax.swing.JLabel();
        jLabelM1 = new javax.swing.JLabel();
        jLabeInaltime = new javax.swing.JLabel();
        jTextFieldInaltime = new javax.swing.JTextField();
        jLabelCantitateCopaci = new javax.swing.JLabel();
        jTextFieldCantitateCopaci = new javax.swing.JTextField();
        jLabelBuc1 = new javax.swing.JLabel();
        jLabelSpecie = new javax.swing.JLabel();
        jComboBoxSpecie = new javax.swing.JComboBox<>();
        jButtonCalculeazaCopac = new javax.swing.JButton();
        jButtonStergreTotalaCopaci = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCopaci = new javax.swing.JTable();
        jButtonStergeCopac = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelTotalCopaci = new javax.swing.JLabel();
        jLabelTotalMC1 = new javax.swing.JLabel();
        jButtonSalvareCopaci = new javax.swing.JButton();
        jTextFieldNumeFisierCopaci = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanelCalculatorVolumGreutate = new javax.swing.JPanel();
        jLabelVolumGreutateBack = new javax.swing.JLabel();
        jLabelVolumGreutate3 = new javax.swing.JLabel();
        jLabelVolumGreutateIcon1 = new javax.swing.JLabel();
        jLabelSpecieVolumGreutate = new javax.swing.JLabel();
        jComboBoxSpecieVolumGreutate = new javax.swing.JComboBox<>();
        jLabelGreutate = new javax.swing.JLabel();
        jLabelTone = new javax.swing.JLabel();
        jLabelVolumGreutate1 = new javax.swing.JLabel();
        jLabelVolum2 = new javax.swing.JLabel();
        jLabelSpecie3 = new javax.swing.JLabel();
        jButtonCalculeazaGreutate = new javax.swing.JButton();
        jTextFieldVolumInput = new javax.swing.JTextField();
        jPanelCalculatorGreutateVolum = new javax.swing.JPanel();
        jLabelGreutateVolumBack = new javax.swing.JLabel();
        jLabelGreutateVolumIcon2 = new javax.swing.JLabel();
        jLabelVolumGreutate4 = new javax.swing.JLabel();
        jLabelGreutate1 = new javax.swing.JLabel();
        jLabelTone1 = new javax.swing.JLabel();
        jLabelVolum5 = new javax.swing.JLabel();
        jLabelSpecieVolumGreutate1 = new javax.swing.JLabel();
        jComboBoxSpecieGreutateVolum = new javax.swing.JComboBox<>();
        jLabelVolum3 = new javax.swing.JLabel();
        jTextFieldGeutateInput = new javax.swing.JTextField();
        jLabelSpecie4 = new javax.swing.JLabel();
        jButtonCalculeazaVolum = new javax.swing.JButton();
        jPanelDisplaySalvari = new javax.swing.JPanel();
        jLabelDisplaySalvariBack = new javax.swing.JLabel();
        jPanelSalvariBusteni1 = new javax.swing.JPanel();
        jLabelSalvariBusteniIcon1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelSalvariCopaci1 = new javax.swing.JPanel();
        jLabelSalvariCopaciIcon1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanelDisplaySalvariBusteni = new javax.swing.JPanel();
        jLabelDisplaySalvariBusteniBack = new javax.swing.JLabel();
        jPanelSalvariBusteni2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabelSalvariBusteniIcon2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableFisiereBusteni = new javax.swing.JTable();
        jButtonStergeFisierBusteni = new javax.swing.JButton();
        jButtonModificaFisierBusteni = new javax.swing.JButton();
        jButtonExportaFisierBusteni = new javax.swing.JButton();
        jPanelDisplaySalvariCopaci = new javax.swing.JPanel();
        jLabelDisplaySalvariCopaciBack = new javax.swing.JLabel();
        jPanelSalvariCopaci2 = new javax.swing.JPanel();
        jLabelSalvariCopaciIcon2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableFisiereCopaci = new javax.swing.JTable();
        jButtonModificaFisierCopaci = new javax.swing.JButton();
        jButtonStergeFisierCopaci = new javax.swing.JButton();
        jButtonExportaFisierCopaci = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelMain.setBackground(new java.awt.Color(0, 51, 51));
        jPanelMain.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jPanelMain.setMaximumSize(new java.awt.Dimension(1115, 530));
        jPanelMain.setMinimumSize(new java.awt.Dimension(1115, 530));
        jPanelMain.setPreferredSize(new java.awt.Dimension(1115, 530));

        jPanelTitle.setBackground(new java.awt.Color(0, 136, 122));
        jPanelTitle.setForeground(new java.awt.Color(0, 51, 51));
        jPanelTitle.setMaximumSize(new java.awt.Dimension(1103, 62));
        jPanelTitle.setMinimumSize(new java.awt.Dimension(1103, 62));
        jPanelTitle.setName(""); // NOI18N
        jPanelTitle.setPreferredSize(new java.awt.Dimension(1103, 62));

        jLabel1.setBackground(new java.awt.Color(0, 136, 122));
        jLabel1.setFont(new java.awt.Font("Bowlby One SC", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WOOD CALCULATOR");

        jLabel_minimize.setBackground(new java.awt.Color(0, 136, 122));
        jLabel_minimize.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_minimize.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_minimize.setText("-");
        jLabel_minimize.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jLabel_minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_minimize.setOpaque(true);
        jLabel_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseExited(evt);
            }
        });

        jLabel_close.setBackground(new java.awt.Color(0, 136, 122));
        jLabel_close.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_close.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_close.setText("x");
        jLabel_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_close.setOpaque(true);
        jLabel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseExited(evt);
            }
        });

        jLabelExit.setBackground(new java.awt.Color(0, 136, 122));
        jLabelExit.setForeground(new java.awt.Color(0, 51, 51));
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelExitMouseExited(evt);
            }
        });

        JlabelActivUser.setBackground(new java.awt.Color(0, 136, 122));
        JlabelActivUser.setFont(new java.awt.Font("Bowlby One SC", 0, 13)); // NOI18N
        JlabelActivUser.setForeground(new java.awt.Color(0, 51, 51));
        JlabelActivUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlabelActivUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JlabelActivUser.setOpaque(true);
        JlabelActivUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JlabelActivUserMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlabelActivUser, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGroup(jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTitleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_close)
                            .addComponent(jLabel_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelTitleLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(JlabelActivUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTitleLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/exitblack.png")));

        jPanelManiu.setBackground(new java.awt.Color(0, 136, 122));
        jPanelManiu.setMaximumSize(new java.awt.Dimension(250, 450));
        jPanelManiu.setMinimumSize(new java.awt.Dimension(250, 450));
        jPanelManiu.setName(""); // NOI18N
        jPanelManiu.setPreferredSize(new java.awt.Dimension(250, 450));

        jLabelCopacIcon.setBackground(new java.awt.Color(0, 136, 122));
        jLabelCopacIcon.setForeground(new java.awt.Color(0, 51, 51));
        jLabelCopacIcon.setOpaque(true);
        jLabelCopacIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCopacIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCopacIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCopacIconMouseExited(evt);
            }
        });

        jLabelBusteanIcon.setBackground(new java.awt.Color(0, 136, 122));
        jLabelBusteanIcon.setForeground(new java.awt.Color(0, 51, 51));
        jLabelBusteanIcon.setOpaque(true);
        jLabelBusteanIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBusteanIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBusteanIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBusteanIconMouseExited(evt);
            }
        });

        jLabelVolumGreutateIcon.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolumGreutateIcon.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolumGreutateIcon.setOpaque(true);
        jLabelVolumGreutateIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateIconMouseExited(evt);
            }
        });

        jLabelGreutateVolumIcon.setBackground(new java.awt.Color(0, 136, 122));
        jLabelGreutateVolumIcon.setForeground(new java.awt.Color(0, 51, 51));
        jLabelGreutateVolumIcon.setOpaque(true);
        jLabelGreutateVolumIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumIconMouseExited(evt);
            }
        });

        jLabelSalvariIcon.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSalvariIcon.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSalvariIcon.setOpaque(true);
        jLabelSalvariIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalvariIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSalvariIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSalvariIconMouseExited(evt);
            }
        });

        jLabelSalvari.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSalvari.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabelSalvari.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSalvari.setText("Salvari");
        jLabelSalvari.setOpaque(true);
        jLabelSalvari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalvariMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSalvariMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSalvariMouseExited(evt);
            }
        });

        jLabelVolumGreutate.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolumGreutate.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabelVolumGreutate.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolumGreutate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelVolumGreutate.setText("Volum-Greutate");
        jLabelVolumGreutate.setOpaque(true);
        jLabelVolumGreutate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateMouseExited(evt);
            }
        });

        jLabelGreutateVolum.setBackground(new java.awt.Color(0, 136, 122));
        jLabelGreutateVolum.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabelGreutateVolum.setForeground(new java.awt.Color(0, 51, 51));
        jLabelGreutateVolum.setText("Greutate-Volum");
        jLabelGreutateVolum.setOpaque(true);
        jLabelGreutateVolum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumMouseExited(evt);
            }
        });

        jLabelCopac.setBackground(new java.awt.Color(0, 136, 122));
        jLabelCopac.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabelCopac.setForeground(new java.awt.Color(0, 51, 51));
        jLabelCopac.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelCopac.setText("volum copac");
        jLabelCopac.setOpaque(true);
        jLabelCopac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCopacMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCopacMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCopacMouseExited(evt);
            }
        });

        jLabelBustean.setBackground(new java.awt.Color(0, 136, 122));
        jLabelBustean.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabelBustean.setForeground(new java.awt.Color(0, 51, 51));
        jLabelBustean.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelBustean.setText("volum busteni");
        jLabelBustean.setOpaque(true);
        jLabelBustean.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBusteanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBusteanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBusteanMouseExited(evt);
            }
        });

        jLabelSalvariBusteniIcon.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSalvariBusteniIcon.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSalvariBusteniIcon.setOpaque(true);
        jLabelSalvariBusteniIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniIconMouseExited(evt);
            }
        });

        jLabelSalvariCopaciIcon.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSalvariCopaciIcon.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSalvariCopaciIcon.setOpaque(true);
        jLabelSalvariCopaciIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciIconMouseExited(evt);
            }
        });

        jLabelSalvariCopaci.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSalvariCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 13)); // NOI18N
        jLabelSalvariCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSalvariCopaci.setText("Copaci");
        jLabelSalvariCopaci.setOpaque(true);
        jLabelSalvariCopaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciMouseExited(evt);
            }
        });

        jLabelSalvariBusteni.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSalvariBusteni.setFont(new java.awt.Font("Bowlby One SC", 0, 13)); // NOI18N
        jLabelSalvariBusteni.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSalvariBusteni.setText("Busteni");
        jLabelSalvariBusteni.setOpaque(true);
        jLabelSalvariBusteni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniMouseExited(evt);
            }
        });

        jLabelHomeIcon.setBackground(new java.awt.Color(0, 136, 122));
        jLabelHomeIcon.setForeground(new java.awt.Color(0, 51, 51));
        jLabelHomeIcon.setOpaque(true);
        jLabelHomeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHomeIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelHomeIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelHomeIconMouseExited(evt);
            }
        });

        jLabelHome.setBackground(new java.awt.Color(0, 136, 122));
        jLabelHome.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabelHome.setForeground(new java.awt.Color(0, 51, 51));
        jLabelHome.setText("Home");
        jLabelHome.setOpaque(true);
        jLabelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelHomeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelManiuLayout = new javax.swing.GroupLayout(jPanelManiu);
        jPanelManiu.setLayout(jPanelManiuLayout);
        jPanelManiuLayout.setHorizontalGroup(
            jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManiuLayout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManiuLayout.createSequentialGroup()
                            .addComponent(jLabelGreutateVolumIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelGreutateVolum, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManiuLayout.createSequentialGroup()
                            .addComponent(jLabelVolumGreutateIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelVolumGreutate, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManiuLayout.createSequentialGroup()
                            .addComponent(jLabelCopacIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelCopac, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManiuLayout.createSequentialGroup()
                            .addComponent(jLabelSalvariIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelSalvari, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManiuLayout.createSequentialGroup()
                            .addGroup(jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelHomeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelBusteanIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelBustean, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addComponent(jLabelHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManiuLayout.createSequentialGroup()
                            .addComponent(jLabelSalvariBusteniIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelSalvariBusteni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManiuLayout.createSequentialGroup()
                            .addComponent(jLabelSalvariCopaciIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelSalvariCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanelManiuLayout.setVerticalGroup(
            jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManiuLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelHomeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelBusteanIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelBustean, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCopacIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCopac, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelVolumGreutateIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelVolumGreutate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelGreutateVolum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelGreutateVolumIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSalvariIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSalvari, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelSalvariBusteniIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelSalvariBusteni, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelManiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelManiuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelSalvariCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelSalvariCopaciIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelCopacIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/copac.png")));
        jLabelBusteanIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/bustean.png")));
        jLabelVolumGreutateIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/VolumGreutate.png")));
        jLabelGreutateVolumIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/GreutateVolum.png")));
        jLabelSalvariIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/salvari.png")));
        jLabelSalvariBusteniIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/SalvariBusteni.png")));
        jLabelSalvariCopaciIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/SalvariCopaci.png")));
        jLabelHomeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/home.png")));

        jPanelContent.setBackground(new java.awt.Color(0, 136, 122));
        jPanelContent.setMaximumSize(new java.awt.Dimension(847, 450));
        jPanelContent.setMinimumSize(new java.awt.Dimension(847, 450));
        jPanelContent.setPreferredSize(new java.awt.Dimension(847, 450));
        jPanelContent.setRequestFocusEnabled(false);

        jPanelAllCalculators.setBackground(new java.awt.Color(0, 136, 122));
        jPanelAllCalculators.setMaximumSize(new java.awt.Dimension(847, 450));
        jPanelAllCalculators.setMinimumSize(new java.awt.Dimension(847, 450));
        jPanelAllCalculators.setPreferredSize(new java.awt.Dimension(847, 450));

        jPanelBusteni.setBackground(new java.awt.Color(0, 136, 122));
        jPanelBusteni.setForeground(new java.awt.Color(0, 51, 51));
        jPanelBusteni.setMaximumSize(new java.awt.Dimension(423, 223));
        jPanelBusteni.setMinimumSize(new java.awt.Dimension(423, 223));
        jPanelBusteni.setName(""); // NOI18N
        jPanelBusteni.setPreferredSize(new java.awt.Dimension(423, 223));

        jLabelBusteni115.setBackground(new java.awt.Color(0, 136, 122));
        jLabelBusteni115.setForeground(new java.awt.Color(0, 51, 51));
        jLabelBusteni115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBusteni115MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBusteni115MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBusteni115MouseExited(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 136, 122));
        jLabel6.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Volum Busteni");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelBusteniLayout = new javax.swing.GroupLayout(jPanelBusteni);
        jPanelBusteni.setLayout(jPanelBusteniLayout);
        jPanelBusteniLayout.setHorizontalGroup(
            jPanelBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusteniLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabelBusteni115, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(jPanelBusteniLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelBusteniLayout.setVerticalGroup(
            jPanelBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusteniLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelBusteni115, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jLabelBusteni115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/bustean115.png")));

        jPanelCopac.setBackground(new java.awt.Color(0, 136, 122));
        jPanelCopac.setForeground(new java.awt.Color(0, 51, 51));
        jPanelCopac.setMaximumSize(new java.awt.Dimension(419, 223));
        jPanelCopac.setMinimumSize(new java.awt.Dimension(419, 223));
        jPanelCopac.setPreferredSize(new java.awt.Dimension(419, 223));
        jPanelCopac.setRequestFocusEnabled(false);

        jLabelCopac115.setBackground(new java.awt.Color(0, 136, 122));
        jLabelCopac115.setForeground(new java.awt.Color(0, 51, 51));
        jLabelCopac115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCopac115MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCopac115MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCopac115MouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 136, 122));
        jLabel7.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Volum Copac");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelCopacLayout = new javax.swing.GroupLayout(jPanelCopac);
        jPanelCopac.setLayout(jPanelCopacLayout);
        jPanelCopacLayout.setHorizontalGroup(
            jPanelCopacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCopacLayout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(jLabelCopac115, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        jPanelCopacLayout.setVerticalGroup(
            jPanelCopacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCopacLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCopac115, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jLabelCopac115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/copac115.png")));

        jPanelVolumGreutate.setBackground(new java.awt.Color(0, 136, 122));
        jPanelVolumGreutate.setForeground(new java.awt.Color(0, 51, 51));
        jPanelVolumGreutate.setMaximumSize(new java.awt.Dimension(423, 221));
        jPanelVolumGreutate.setMinimumSize(new java.awt.Dimension(423, 221));
        jPanelVolumGreutate.setName(""); // NOI18N
        jPanelVolumGreutate.setPreferredSize(new java.awt.Dimension(423, 221));

        jLabelVolumGreutate115.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolumGreutate115.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolumGreutate115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutate115MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutate115MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutate115MouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(0, 136, 122));
        jLabel9.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Volum-Greutate");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelVolumGreutateLayout = new javax.swing.GroupLayout(jPanelVolumGreutate);
        jPanelVolumGreutate.setLayout(jPanelVolumGreutateLayout);
        jPanelVolumGreutateLayout.setHorizontalGroup(
            jPanelVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVolumGreutateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelVolumGreutateLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabelVolumGreutate115, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanelVolumGreutateLayout.setVerticalGroup(
            jPanelVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVolumGreutateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelVolumGreutate115, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabelVolumGreutate115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/VolumGreutate115.png")));

        jPanelGreutateVolum.setBackground(new java.awt.Color(0, 136, 122));
        jPanelGreutateVolum.setForeground(new java.awt.Color(0, 51, 51));
        jPanelGreutateVolum.setMaximumSize(new java.awt.Dimension(419, 221));
        jPanelGreutateVolum.setMinimumSize(new java.awt.Dimension(419, 221));
        jPanelGreutateVolum.setPreferredSize(new java.awt.Dimension(419, 221));

        jLabelGreutateVolum115.setBackground(new java.awt.Color(0, 136, 122));
        jLabelGreutateVolum115.setForeground(new java.awt.Color(0, 51, 51));
        jLabelGreutateVolum115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolum115MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolum115MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolum115MouseExited(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 136, 122));
        jLabel8.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Greutate-Volum");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelGreutateVolumLayout = new javax.swing.GroupLayout(jPanelGreutateVolum);
        jPanelGreutateVolum.setLayout(jPanelGreutateVolumLayout);
        jPanelGreutateVolumLayout.setHorizontalGroup(
            jPanelGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGreutateVolumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelGreutateVolumLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabelGreutateVolum115, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanelGreutateVolumLayout.setVerticalGroup(
            jPanelGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGreutateVolumLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelGreutateVolum115, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabelGreutateVolum115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/GreutateVolum115.png")));

        javax.swing.GroupLayout jPanelAllCalculatorsLayout = new javax.swing.GroupLayout(jPanelAllCalculators);
        jPanelAllCalculators.setLayout(jPanelAllCalculatorsLayout);
        jPanelAllCalculatorsLayout.setHorizontalGroup(
            jPanelAllCalculatorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAllCalculatorsLayout.createSequentialGroup()
                .addGroup(jPanelAllCalculatorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAllCalculatorsLayout.createSequentialGroup()
                        .addComponent(jPanelVolumGreutate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelGreutateVolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAllCalculatorsLayout.createSequentialGroup()
                        .addComponent(jPanelBusteni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelCopac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAllCalculatorsLayout.setVerticalGroup(
            jPanelAllCalculatorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAllCalculatorsLayout.createSequentialGroup()
                .addGroup(jPanelAllCalculatorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBusteni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelCopac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAllCalculatorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelGreutateVolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelVolumGreutate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanelCalculatorBusteni.setBackground(new java.awt.Color(0, 136, 122));
        jPanelCalculatorBusteni.setMaximumSize(new java.awt.Dimension(847, 450));
        jPanelCalculatorBusteni.setMinimumSize(new java.awt.Dimension(847, 450));
        jPanelCalculatorBusteni.setPreferredSize(new java.awt.Dimension(847, 450));

        jLabelBusteniBack.setForeground(new java.awt.Color(0, 51, 51));
        jLabelBusteniBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBusteniBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBusteniBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBusteniBackMouseExited(evt);
            }
        });

        jLabelBusteanCalculator.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabelBusteanCalculator.setForeground(new java.awt.Color(0, 51, 51));
        jLabelBusteanCalculator.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelBusteanCalculator.setText("volum busteni");
        jLabelBusteanCalculator.setOpaque(true);
        jLabelBusteanCalculator.setPreferredSize(new java.awt.Dimension(155, 50));
        jLabelBusteanCalculator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBusteanCalculatorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBusteanCalculatorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBusteanCalculatorMouseExited(evt);
            }
        });

        jLabelBusteniCalculator.setForeground(new java.awt.Color(0, 51, 51));
        jLabelBusteniCalculator.setOpaque(true);
        jLabelBusteniCalculator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBusteniCalculatorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBusteniCalculatorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBusteniCalculatorMouseExited(evt);
            }
        });

        jLabelVolum.setFont(new java.awt.Font("Bowlby One SC", 1, 24)); // NOI18N
        jLabelVolum.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelVolum.setText("Volum");

        jLabelMC.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelMC.setForeground(new java.awt.Color(0, 51, 51));
        jLabelMC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelMC.setText("mc");

        jLabelDiametru.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelDiametru.setForeground(new java.awt.Color(0, 51, 51));
        jLabelDiametru.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDiametru.setText("Diametru mediu");

        jTextFieldDiametru.setBackground(new java.awt.Color(254, 250, 224));
        jTextFieldDiametru.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jTextFieldDiametru.setForeground(new java.awt.Color(0, 51, 51));
        jTextFieldDiametru.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDiametru.setText("...");
        jTextFieldDiametru.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDiametruFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDiametruFocusLost(evt);
            }
        });
        jTextFieldDiametru.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDiametruKeyTyped(evt);
            }
        });

        jLabelCM.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelCM.setForeground(new java.awt.Color(0, 51, 51));
        jLabelCM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelCM.setText("cm");

        jLabelM.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelM.setForeground(new java.awt.Color(0, 51, 51));
        jLabelM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelM.setText("m");

        jLabelLungime.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelLungime.setForeground(new java.awt.Color(0, 51, 51));
        jLabelLungime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelLungime.setText("Lungime");

        jTextFieldLungime.setBackground(new java.awt.Color(254, 250, 224));
        jTextFieldLungime.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jTextFieldLungime.setForeground(new java.awt.Color(0, 51, 51));
        jTextFieldLungime.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldLungime.setText("...");
        jTextFieldLungime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldLungimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldLungimeFocusLost(evt);
            }
        });
        jTextFieldLungime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLungimeKeyTyped(evt);
            }
        });

        jLabelCantitate.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelCantitate.setForeground(new java.awt.Color(0, 51, 51));
        jLabelCantitate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCantitate.setText("Cantitate");

        jTextFieldCantitate.setBackground(new java.awt.Color(254, 250, 224));
        jTextFieldCantitate.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jTextFieldCantitate.setForeground(new java.awt.Color(0, 51, 51));
        jTextFieldCantitate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldCantitate.setText("1");
        jTextFieldCantitate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantitateActionPerformed(evt);
            }
        });
        jTextFieldCantitate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCantitateKeyTyped(evt);
            }
        });

        jLabelBuc.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelBuc.setForeground(new java.awt.Color(0, 51, 51));
        jLabelBuc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelBuc.setText("buc");

        jButtonCalculeaza.setBackground(new java.awt.Color(0, 102, 102));
        jButtonCalculeaza.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jButtonCalculeaza.setForeground(new java.awt.Color(0, 51, 51));
        jButtonCalculeaza.setText("Calculeaza");
        jButtonCalculeaza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCalculeazaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonCalculeazaMouseExited(evt);
            }
        });
        jButtonCalculeaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculeazaActionPerformed(evt);
            }
        });

        jLabelVolumMC.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelVolumMC.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolumMC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVolumMC.setText("...");

        jScrollPane2.setForeground(new java.awt.Color(0, 51, 51));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("");

        jTableBusteni.setBackground(new java.awt.Color(153, 153, 153));
        jTableBusteni.setFont(new java.awt.Font("Bowlby One SC", 0, 13)); // NOI18N
        jTableBusteni.setForeground(new java.awt.Color(0, 51, 51));
        jTableBusteni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nr.crt", "Nr.buc", "Lungime", "Diametru", "Volum"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBusteni.setMaximumSize(new java.awt.Dimension(325, 1000));
        jTableBusteni.setMinimumSize(new java.awt.Dimension(325, 150));
        jTableBusteni.setPreferredSize(new java.awt.Dimension(325, 1000));
        jTableBusteni.setRequestFocusEnabled(false);
        jTableBusteni.getTableHeader().setResizingAllowed(false);
        jTableBusteni.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableBusteni);
        if (jTableBusteni.getColumnModel().getColumnCount() > 0) {
            jTableBusteni.getColumnModel().getColumn(0).setMinWidth(50);
            jTableBusteni.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableBusteni.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableBusteni.getColumnModel().getColumn(1).setMinWidth(50);
            jTableBusteni.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTableBusteni.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        jButtonStergreTotala.setBackground(new java.awt.Color(0, 102, 102));
        jButtonStergreTotala.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jButtonStergreTotala.setForeground(new java.awt.Color(0, 51, 51));
        jButtonStergreTotala.setText("Golire tabel");
        jButtonStergreTotala.setPreferredSize(new java.awt.Dimension(155, 30));
        jButtonStergreTotala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonStergreTotalaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonStergreTotalaMouseExited(evt);
            }
        });
        jButtonStergreTotala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStergreTotalaActionPerformed(evt);
            }
        });

        jButtonStergeBustean.setBackground(new java.awt.Color(0, 102, 102));
        jButtonStergeBustean.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jButtonStergeBustean.setForeground(new java.awt.Color(0, 51, 51));
        jButtonStergeBustean.setText("Sterge bustean");
        jButtonStergeBustean.setPreferredSize(new java.awt.Dimension(155, 30));
        jButtonStergeBustean.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonStergeBusteanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonStergeBusteanMouseExited(evt);
            }
        });
        jButtonStergeBustean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStergeBusteanActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total");
        jLabel4.setPreferredSize(new java.awt.Dimension(57, 30));

        jLabelTotal.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(0, 51, 51));
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotal.setText("...");
        jLabelTotal.setPreferredSize(new java.awt.Dimension(68, 30));

        jLabelTotalMC.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelTotalMC.setForeground(new java.awt.Color(0, 51, 51));
        jLabelTotalMC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTotalMC.setText("mc");
        jLabelTotalMC.setPreferredSize(new java.awt.Dimension(24, 30));

        jButtonSalvareBusteni.setBackground(new java.awt.Color(0, 102, 102));
        jButtonSalvareBusteni.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jButtonSalvareBusteni.setForeground(new java.awt.Color(0, 51, 51));
        jButtonSalvareBusteni.setText("Salvare");
        jButtonSalvareBusteni.setPreferredSize(new java.awt.Dimension(155, 40));
        jButtonSalvareBusteni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSalvareBusteniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSalvareBusteniMouseExited(evt);
            }
        });
        jButtonSalvareBusteni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvareBusteniActionPerformed(evt);
            }
        });

        jTextFieldNumeFisier.setBackground(new java.awt.Color(254, 250, 224));
        jTextFieldNumeFisier.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jTextFieldNumeFisier.setForeground(new java.awt.Color(0, 51, 51));
        jTextFieldNumeFisier.setText("...");
        jTextFieldNumeFisier.setPreferredSize(new java.awt.Dimension(155, 30));
        jTextFieldNumeFisier.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNumeFisierFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNumeFisierFocusLost(evt);
            }
        });

        jLabelNumeFisier.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelNumeFisier.setForeground(new java.awt.Color(0, 51, 51));
        jLabelNumeFisier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumeFisier.setText("Nume Fisier");
        jLabelNumeFisier.setPreferredSize(new java.awt.Dimension(155, 30));

        javax.swing.GroupLayout jPanelCalculatorBusteniLayout = new javax.swing.GroupLayout(jPanelCalculatorBusteni);
        jPanelCalculatorBusteni.setLayout(jPanelCalculatorBusteniLayout);
        jPanelCalculatorBusteniLayout.setHorizontalGroup(
            jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelBusteniBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorBusteniLayout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorBusteniLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorBusteniLayout.createSequentialGroup()
                                .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                                        .addComponent(jLabelCantitate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldCantitate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelBuc, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                                        .addComponent(jLabelLungime, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldLungime, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelM, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                                        .addComponent(jLabelDiametru, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldDiametru, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelCM, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButtonCalculeaza, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(154, 154, 154))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorBusteniLayout.createSequentialGroup()
                                .addComponent(jLabelVolum, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelVolumMC, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelMC, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)))))
                .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonStergeBustean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvareBusteni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumeFisier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumeFisier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBusteanCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotalMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonStergreTotala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                        .addComponent(jLabelBusteniCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(35, 35, 35))
        );
        jPanelCalculatorBusteniLayout.setVerticalGroup(
            jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jLabelVolumMC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelMC, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(jLabelVolum, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDiametru, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDiametru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLungime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLungime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCantitate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCantitate)
                            .addComponent(jLabelBuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                                .addComponent(jLabelBusteniBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorBusteniLayout.createSequentialGroup()
                                .addComponent(jLabelBusteniCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelBusteanCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButtonCalculeaza, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCalculatorBusteniLayout.createSequentialGroup()
                        .addComponent(jLabelNumeFisier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumeFisier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvareBusteni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonStergeBustean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonStergreTotala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanelCalculatorBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTotalMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        jLabelBusteniBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
        jLabelBusteniCalculator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/bustean115.png")));

        jPanelCalculatorCopaci.setBackground(new java.awt.Color(0, 136, 122));
        jPanelCalculatorCopaci.setMaximumSize(new java.awt.Dimension(847, 450));
        jPanelCalculatorCopaci.setMinimumSize(new java.awt.Dimension(847, 450));
        jPanelCalculatorCopaci.setPreferredSize(new java.awt.Dimension(847, 450));

        jLabelVolumCopaciBack.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolumCopaciBack.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolumCopaciBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVolumCopaciBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelVolumCopaciBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelVolumCopaciBackMouseExited(evt);
            }
        });

        jLabelCopaciCalculator.setBackground(new java.awt.Color(0, 136, 122));
        jLabelCopaciCalculator.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabelCopaciCalculator.setForeground(new java.awt.Color(0, 51, 51));
        jLabelCopaciCalculator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCopaciCalculator.setText("volum copaci");
        jLabelCopaciCalculator.setOpaque(true);
        jLabelCopaciCalculator.setPreferredSize(new java.awt.Dimension(155, 50));
        jLabelCopaciCalculator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCopaciCalculatorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCopaciCalculatorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCopaciCalculatorMouseExited(evt);
            }
        });

        jLabelCopaciCalculatorIcon.setBackground(new java.awt.Color(0, 136, 122));
        jLabelCopaciCalculatorIcon.setForeground(new java.awt.Color(0, 51, 51));
        jLabelCopaciCalculatorIcon.setOpaque(true);
        jLabelCopaciCalculatorIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCopaciCalculatorIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCopaciCalculatorIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCopaciCalculatorIconMouseExited(evt);
            }
        });

        jLabelVolum1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolum1.setFont(new java.awt.Font("Bowlby One SC", 1, 24)); // NOI18N
        jLabelVolum1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolum1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelVolum1.setText("Volum");

        jLabelMC1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelMC1.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelMC1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelMC1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelMC1.setText("mc");

        jLabelVolumCopac.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolumCopac.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelVolumCopac.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolumCopac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVolumCopac.setText("...");

        jLabelDiametruPiept.setBackground(new java.awt.Color(0, 136, 122));
        jLabelDiametruPiept.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelDiametruPiept.setForeground(new java.awt.Color(0, 51, 51));
        jLabelDiametruPiept.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDiametruPiept.setText("Diametru la nivelul pieptului");

        jTextFieldDiametruPiept.setBackground(new java.awt.Color(254, 250, 224));
        jTextFieldDiametruPiept.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jTextFieldDiametruPiept.setForeground(new java.awt.Color(0, 51, 51));
        jTextFieldDiametruPiept.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDiametruPiept.setText("...");
        jTextFieldDiametruPiept.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDiametruPieptFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDiametruPieptFocusLost(evt);
            }
        });
        jTextFieldDiametruPiept.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDiametruPieptKeyTyped(evt);
            }
        });

        jLabelCM1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelCM1.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelCM1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelCM1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelCM1.setText("cm");

        jLabelM1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelM1.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelM1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelM1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelM1.setText("m");

        jLabeInaltime.setBackground(new java.awt.Color(0, 136, 122));
        jLabeInaltime.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabeInaltime.setForeground(new java.awt.Color(0, 51, 51));
        jLabeInaltime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabeInaltime.setText("Inaltime");

        jTextFieldInaltime.setBackground(new java.awt.Color(254, 250, 224));
        jTextFieldInaltime.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jTextFieldInaltime.setForeground(new java.awt.Color(0, 51, 51));
        jTextFieldInaltime.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldInaltime.setText("...");
        jTextFieldInaltime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldInaltimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldInaltimeFocusLost(evt);
            }
        });
        jTextFieldInaltime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldInaltimeKeyTyped(evt);
            }
        });

        jLabelCantitateCopaci.setBackground(new java.awt.Color(0, 136, 122));
        jLabelCantitateCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelCantitateCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jLabelCantitateCopaci.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCantitateCopaci.setText("Cantitate");

        jTextFieldCantitateCopaci.setBackground(new java.awt.Color(254, 250, 224));
        jTextFieldCantitateCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jTextFieldCantitateCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jTextFieldCantitateCopaci.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldCantitateCopaci.setText("1");
        jTextFieldCantitateCopaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantitateCopaciActionPerformed(evt);
            }
        });
        jTextFieldCantitateCopaci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCantitateCopaciKeyTyped(evt);
            }
        });

        jLabelBuc1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelBuc1.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelBuc1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelBuc1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelBuc1.setText("buc");

        jLabelSpecie.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSpecie.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelSpecie.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSpecie.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSpecie.setText("specie");

        jComboBoxSpecie.setBackground(new java.awt.Color(0, 102, 102));
        jComboBoxSpecie.setForeground(new java.awt.Color(0, 51, 51));
        jComboBoxSpecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSpecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSpecieActionPerformed(evt);
            }
        });

        jButtonCalculeazaCopac.setBackground(new java.awt.Color(0, 102, 102));
        jButtonCalculeazaCopac.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jButtonCalculeazaCopac.setForeground(new java.awt.Color(0, 51, 51));
        jButtonCalculeazaCopac.setText("Calculeaza");
        jButtonCalculeazaCopac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCalculeazaCopacMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonCalculeazaCopacMouseExited(evt);
            }
        });
        jButtonCalculeazaCopac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculeazaCopacActionPerformed(evt);
            }
        });

        jButtonStergreTotalaCopaci.setBackground(new java.awt.Color(0, 102, 102));
        jButtonStergreTotalaCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jButtonStergreTotalaCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jButtonStergreTotalaCopaci.setText("Golire tabel");
        jButtonStergreTotalaCopaci.setPreferredSize(new java.awt.Dimension(155, 30));
        jButtonStergreTotalaCopaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonStergreTotalaCopaciMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonStergreTotalaCopaciMouseExited(evt);
            }
        });
        jButtonStergreTotalaCopaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStergreTotalaCopaciActionPerformed(evt);
            }
        });

        jScrollPane3.setBackground(new java.awt.Color(0, 136, 122));
        jScrollPane3.setForeground(new java.awt.Color(0, 51, 51));

        jTableCopaci.setBackground(new java.awt.Color(153, 153, 153));
        jTableCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 13)); // NOI18N
        jTableCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jTableCopaci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nr.crt", "Nr.buc", "Specie", "Inaltime", "Diametru la Piept", "Volum"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCopaci.setMaximumSize(new java.awt.Dimension(325, 1000));
        jTableCopaci.setMinimumSize(new java.awt.Dimension(325, 150));
        jTableCopaci.setPreferredSize(new java.awt.Dimension(325, 1000));
        jTableCopaci.getTableHeader().setResizingAllowed(false);
        jTableCopaci.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableCopaci);
        if (jTableCopaci.getColumnModel().getColumnCount() > 0) {
            jTableCopaci.getColumnModel().getColumn(0).setMinWidth(50);
            jTableCopaci.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableCopaci.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableCopaci.getColumnModel().getColumn(1).setMinWidth(50);
            jTableCopaci.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTableCopaci.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        jButtonStergeCopac.setBackground(new java.awt.Color(0, 102, 102));
        jButtonStergeCopac.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jButtonStergeCopac.setForeground(new java.awt.Color(0, 51, 51));
        jButtonStergeCopac.setText("Sterge copac");
        jButtonStergeCopac.setPreferredSize(new java.awt.Dimension(155, 30));
        jButtonStergeCopac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonStergeCopacMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonStergeCopacMouseExited(evt);
            }
        });
        jButtonStergeCopac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStergeCopacActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 136, 122));
        jLabel5.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total");
        jLabel5.setPreferredSize(new java.awt.Dimension(57, 30));

        jLabelTotalCopaci.setBackground(new java.awt.Color(0, 136, 122));
        jLabelTotalCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelTotalCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jLabelTotalCopaci.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalCopaci.setText("...");
        jLabelTotalCopaci.setPreferredSize(new java.awt.Dimension(68, 30));

        jLabelTotalMC1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelTotalMC1.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabelTotalMC1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelTotalMC1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTotalMC1.setText("mc");
        jLabelTotalMC1.setPreferredSize(new java.awt.Dimension(24, 30));

        jButtonSalvareCopaci.setBackground(new java.awt.Color(0, 102, 102));
        jButtonSalvareCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jButtonSalvareCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jButtonSalvareCopaci.setText("Salvare");
        jButtonSalvareCopaci.setPreferredSize(new java.awt.Dimension(155, 40));
        jButtonSalvareCopaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSalvareCopaciMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSalvareCopaciMouseExited(evt);
            }
        });
        jButtonSalvareCopaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvareCopaciActionPerformed(evt);
            }
        });

        jTextFieldNumeFisierCopaci.setBackground(new java.awt.Color(254, 250, 224));
        jTextFieldNumeFisierCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jTextFieldNumeFisierCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jTextFieldNumeFisierCopaci.setText("...");
        jTextFieldNumeFisierCopaci.setPreferredSize(new java.awt.Dimension(155, 30));
        jTextFieldNumeFisierCopaci.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNumeFisierCopaciFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNumeFisierCopaciFocusLost(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 136, 122));
        jLabel11.setFont(new java.awt.Font("Bowlby One SC", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nume Fisier");
        jLabel11.setPreferredSize(new java.awt.Dimension(155, 30));

        javax.swing.GroupLayout jPanelCalculatorCopaciLayout = new javax.swing.GroupLayout(jPanelCalculatorCopaci);
        jPanelCalculatorCopaci.setLayout(jPanelCalculatorCopaciLayout);
        jPanelCalculatorCopaciLayout.setHorizontalGroup(
            jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCalculeazaCopac, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                        .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                                        .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabeInaltime, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelCantitateCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelDiametruPiept)
                                            .addComponent(jLabelSpecie, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jTextFieldDiametruPiept, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jComboBoxSpecie, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldInaltime, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorCopaciLayout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jTextFieldCantitateCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelCM1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelM1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelBuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                                        .addComponent(jLabelVolumCopaciBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(422, 422, 422))))
                            .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(jLabelVolum1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelVolumCopac, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelMC1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)))
                .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelTotalCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelTotalMC1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButtonStergreTotalaCopaci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonStergeCopac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalvareCopaci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldNumeFisierCopaci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCopaciCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabelCopaciCalculatorIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanelCalculatorCopaciLayout.setVerticalGroup(
            jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                        .addComponent(jLabelVolumCopaciBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelVolumCopac, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelVolum1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSpecie)
                            .addComponent(jComboBoxSpecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                                .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelDiametruPiept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDiametruPiept, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldInaltime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabeInaltime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldCantitateCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCantitateCopaci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                                .addComponent(jLabelCM1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelM1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelBuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCalculeazaCopac, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCalculatorCopaciLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabelCopaciCalculatorIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCopaciCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumeFisierCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvareCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonStergeCopac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonStergreTotalaCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelCalculatorCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalMC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTotalCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        jLabelVolumCopaciBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
        jLabelCopaciCalculatorIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/copac115.png")));

        jPanelCalculatorVolumGreutate.setBackground(new java.awt.Color(0, 136, 122));
        jPanelCalculatorVolumGreutate.setMaximumSize(new java.awt.Dimension(847, 450));
        jPanelCalculatorVolumGreutate.setMinimumSize(new java.awt.Dimension(847, 450));
        jPanelCalculatorVolumGreutate.setPreferredSize(new java.awt.Dimension(847, 450));

        jLabelVolumGreutateBack.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolumGreutateBack.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolumGreutateBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateBackMouseExited(evt);
            }
        });

        jLabelVolumGreutate3.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolumGreutate3.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelVolumGreutate3.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolumGreutate3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelVolumGreutate3.setText("volum Greutate");
        jLabelVolumGreutate3.setOpaque(true);
        jLabelVolumGreutate3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutate3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutate3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutate3MouseExited(evt);
            }
        });

        jLabelVolumGreutateIcon1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolumGreutateIcon1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolumGreutateIcon1.setOpaque(true);
        jLabelVolumGreutateIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateIcon1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateIcon1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutateIcon1MouseExited(evt);
            }
        });

        jLabelSpecieVolumGreutate.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSpecieVolumGreutate.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelSpecieVolumGreutate.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSpecieVolumGreutate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSpecieVolumGreutate.setText("specie");
        jLabelSpecieVolumGreutate.setMaximumSize(new java.awt.Dimension(161, 50));
        jLabelSpecieVolumGreutate.setMinimumSize(new java.awt.Dimension(161, 50));
        jLabelSpecieVolumGreutate.setPreferredSize(new java.awt.Dimension(161, 50));

        jComboBoxSpecieVolumGreutate.setBackground(new java.awt.Color(0, 136, 122));
        jComboBoxSpecieVolumGreutate.setForeground(new java.awt.Color(0, 51, 51));
        jComboBoxSpecieVolumGreutate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSpecieVolumGreutate.setMaximumSize(new java.awt.Dimension(140, 50));
        jComboBoxSpecieVolumGreutate.setMinimumSize(new java.awt.Dimension(140, 50));
        jComboBoxSpecieVolumGreutate.setPreferredSize(new java.awt.Dimension(140, 50));
        jComboBoxSpecieVolumGreutate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSpecieVolumGreutateActionPerformed(evt);
            }
        });

        jLabelGreutate.setBackground(new java.awt.Color(0, 136, 122));
        jLabelGreutate.setFont(new java.awt.Font("Bowlby One SC", 1, 24)); // NOI18N
        jLabelGreutate.setForeground(new java.awt.Color(0, 51, 51));
        jLabelGreutate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGreutate.setText("Greutate");
        jLabelGreutate.setMaximumSize(new java.awt.Dimension(161, 50));
        jLabelGreutate.setMinimumSize(new java.awt.Dimension(161, 50));
        jLabelGreutate.setPreferredSize(new java.awt.Dimension(161, 50));

        jLabelTone.setBackground(new java.awt.Color(0, 136, 122));
        jLabelTone.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelTone.setForeground(new java.awt.Color(0, 51, 51));
        jLabelTone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTone.setText("Tone");
        jLabelTone.setMaximumSize(new java.awt.Dimension(70, 50));
        jLabelTone.setMinimumSize(new java.awt.Dimension(70, 50));
        jLabelTone.setPreferredSize(new java.awt.Dimension(70, 50));

        jLabelVolumGreutate1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolumGreutate1.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelVolumGreutate1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolumGreutate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVolumGreutate1.setText("...");
        jLabelVolumGreutate1.setMaximumSize(new java.awt.Dimension(140, 50));
        jLabelVolumGreutate1.setMinimumSize(new java.awt.Dimension(140, 50));
        jLabelVolumGreutate1.setPreferredSize(new java.awt.Dimension(140, 50));

        jLabelVolum2.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolum2.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelVolum2.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolum2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelVolum2.setText("Volum");
        jLabelVolum2.setMaximumSize(new java.awt.Dimension(161, 50));
        jLabelVolum2.setMinimumSize(new java.awt.Dimension(161, 50));
        jLabelVolum2.setPreferredSize(new java.awt.Dimension(161, 50));

        jLabelSpecie3.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSpecie3.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelSpecie3.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSpecie3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelSpecie3.setText("mc");
        jLabelSpecie3.setMaximumSize(new java.awt.Dimension(70, 50));
        jLabelSpecie3.setMinimumSize(new java.awt.Dimension(70, 50));
        jLabelSpecie3.setName(""); // NOI18N
        jLabelSpecie3.setPreferredSize(new java.awt.Dimension(70, 50));

        jButtonCalculeazaGreutate.setBackground(new java.awt.Color(0, 102, 102));
        jButtonCalculeazaGreutate.setFont(new java.awt.Font("Bowlby One SC", 0, 36)); // NOI18N
        jButtonCalculeazaGreutate.setForeground(new java.awt.Color(0, 51, 51));
        jButtonCalculeazaGreutate.setText("Calculeaza");
        jButtonCalculeazaGreutate.setMaximumSize(new java.awt.Dimension(320, 50));
        jButtonCalculeazaGreutate.setMinimumSize(new java.awt.Dimension(320, 50));
        jButtonCalculeazaGreutate.setPreferredSize(new java.awt.Dimension(320, 50));
        jButtonCalculeazaGreutate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCalculeazaGreutateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCalculeazaGreutateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonCalculeazaGreutateMouseExited(evt);
            }
        });
        jButtonCalculeazaGreutate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculeazaGreutateActionPerformed(evt);
            }
        });

        jTextFieldVolumInput.setBackground(new java.awt.Color(254, 250, 224));
        jTextFieldVolumInput.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jTextFieldVolumInput.setForeground(new java.awt.Color(0, 51, 51));
        jTextFieldVolumInput.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldVolumInput.setText("...");
        jTextFieldVolumInput.setMaximumSize(new java.awt.Dimension(140, 50));
        jTextFieldVolumInput.setMinimumSize(new java.awt.Dimension(140, 50));
        jTextFieldVolumInput.setName(""); // NOI18N
        jTextFieldVolumInput.setPreferredSize(new java.awt.Dimension(140, 50));
        jTextFieldVolumInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldVolumInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldVolumInputFocusLost(evt);
            }
        });
        jTextFieldVolumInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVolumInputKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelCalculatorVolumGreutateLayout = new javax.swing.GroupLayout(jPanelCalculatorVolumGreutate);
        jPanelCalculatorVolumGreutate.setLayout(jPanelCalculatorVolumGreutateLayout);
        jPanelCalculatorVolumGreutateLayout.setHorizontalGroup(
            jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculatorVolumGreutateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalculatorVolumGreutateLayout.createSequentialGroup()
                        .addGap(0, 202, Short.MAX_VALUE)
                        .addGroup(jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCalculatorVolumGreutateLayout.createSequentialGroup()
                                .addComponent(jLabelGreutate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelVolumGreutate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCalculatorVolumGreutateLayout.createSequentialGroup()
                                .addGroup(jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSpecieVolumGreutate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVolum2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxSpecieVolumGreutate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelCalculatorVolumGreutateLayout.createSequentialGroup()
                                        .addComponent(jTextFieldVolumInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelSpecie3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jButtonCalculeazaGreutate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelCalculatorVolumGreutateLayout.createSequentialGroup()
                        .addComponent(jLabelVolumGreutateBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelVolumGreutateIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelVolumGreutate3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(250, 250, 250))
        );
        jPanelCalculatorVolumGreutateLayout.setVerticalGroup(
            jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculatorVolumGreutateLayout.createSequentialGroup()
                .addGroup(jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalculatorVolumGreutateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelVolumGreutateBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorVolumGreutateLayout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addGroup(jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorVolumGreutateLayout.createSequentialGroup()
                                .addComponent(jLabelVolumGreutate3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addComponent(jLabelVolumGreutateIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addGroup(jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGreutate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVolumGreutate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSpecieVolumGreutate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSpecieVolumGreutate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVolum2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCalculatorVolumGreutateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelSpecie3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldVolumInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButtonCalculeazaGreutate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jLabelVolumGreutateBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
        jLabelVolumGreutateIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/VolumGreutate115.png")));

        jPanelCalculatorGreutateVolum.setBackground(new java.awt.Color(0, 136, 122));
        jPanelCalculatorGreutateVolum.setMaximumSize(new java.awt.Dimension(847, 450));
        jPanelCalculatorGreutateVolum.setMinimumSize(new java.awt.Dimension(847, 450));
        jPanelCalculatorGreutateVolum.setPreferredSize(new java.awt.Dimension(847, 450));

        jLabelGreutateVolumBack.setBackground(new java.awt.Color(0, 136, 122));
        jLabelGreutateVolumBack.setForeground(new java.awt.Color(0, 51, 51));
        jLabelGreutateVolumBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumBackMouseExited(evt);
            }
        });

        jLabelGreutateVolumIcon2.setBackground(new java.awt.Color(0, 136, 122));
        jLabelGreutateVolumIcon2.setForeground(new java.awt.Color(0, 51, 51));
        jLabelGreutateVolumIcon2.setOpaque(true);
        jLabelGreutateVolumIcon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumIcon2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumIcon2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelGreutateVolumIcon2MouseExited(evt);
            }
        });

        jLabelVolumGreutate4.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolumGreutate4.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelVolumGreutate4.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolumGreutate4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelVolumGreutate4.setText("Greutate volum");
        jLabelVolumGreutate4.setOpaque(true);
        jLabelVolumGreutate4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutate4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutate4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelVolumGreutate4MouseExited(evt);
            }
        });

        jLabelGreutate1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelGreutate1.setFont(new java.awt.Font("Bowlby One SC", 1, 24)); // NOI18N
        jLabelGreutate1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelGreutate1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGreutate1.setText("Volum");
        jLabelGreutate1.setMaximumSize(new java.awt.Dimension(161, 50));
        jLabelGreutate1.setMinimumSize(new java.awt.Dimension(161, 50));
        jLabelGreutate1.setPreferredSize(new java.awt.Dimension(161, 50));

        jLabelTone1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelTone1.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelTone1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelTone1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTone1.setText("mc");
        jLabelTone1.setMaximumSize(new java.awt.Dimension(70, 50));
        jLabelTone1.setMinimumSize(new java.awt.Dimension(70, 50));
        jLabelTone1.setPreferredSize(new java.awt.Dimension(70, 50));

        jLabelVolum5.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolum5.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelVolum5.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolum5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVolum5.setText("...");
        jLabelVolum5.setMaximumSize(new java.awt.Dimension(140, 50));
        jLabelVolum5.setMinimumSize(new java.awt.Dimension(140, 50));
        jLabelVolum5.setPreferredSize(new java.awt.Dimension(140, 50));

        jLabelSpecieVolumGreutate1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSpecieVolumGreutate1.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelSpecieVolumGreutate1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSpecieVolumGreutate1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSpecieVolumGreutate1.setText("specie");
        jLabelSpecieVolumGreutate1.setMaximumSize(new java.awt.Dimension(161, 50));
        jLabelSpecieVolumGreutate1.setMinimumSize(new java.awt.Dimension(161, 50));
        jLabelSpecieVolumGreutate1.setPreferredSize(new java.awt.Dimension(161, 50));

        jComboBoxSpecieGreutateVolum.setBackground(new java.awt.Color(0, 136, 122));
        jComboBoxSpecieGreutateVolum.setForeground(new java.awt.Color(0, 51, 51));
        jComboBoxSpecieGreutateVolum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSpecieGreutateVolum.setMaximumSize(new java.awt.Dimension(140, 50));
        jComboBoxSpecieGreutateVolum.setMinimumSize(new java.awt.Dimension(140, 50));
        jComboBoxSpecieGreutateVolum.setPreferredSize(new java.awt.Dimension(140, 50));
        jComboBoxSpecieGreutateVolum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSpecieGreutateVolumActionPerformed(evt);
            }
        });

        jLabelVolum3.setBackground(new java.awt.Color(0, 136, 122));
        jLabelVolum3.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelVolum3.setForeground(new java.awt.Color(0, 51, 51));
        jLabelVolum3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelVolum3.setText("Greutate");
        jLabelVolum3.setMaximumSize(new java.awt.Dimension(161, 50));
        jLabelVolum3.setMinimumSize(new java.awt.Dimension(161, 50));
        jLabelVolum3.setPreferredSize(new java.awt.Dimension(161, 50));

        jTextFieldGeutateInput.setBackground(new java.awt.Color(254, 250, 224));
        jTextFieldGeutateInput.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jTextFieldGeutateInput.setForeground(new java.awt.Color(0, 51, 51));
        jTextFieldGeutateInput.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldGeutateInput.setText("...");
        jTextFieldGeutateInput.setMaximumSize(new java.awt.Dimension(140, 50));
        jTextFieldGeutateInput.setMinimumSize(new java.awt.Dimension(140, 50));
        jTextFieldGeutateInput.setPreferredSize(new java.awt.Dimension(140, 50));
        jTextFieldGeutateInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldGeutateInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldGeutateInputFocusLost(evt);
            }
        });
        jTextFieldGeutateInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldGeutateInputKeyTyped(evt);
            }
        });

        jLabelSpecie4.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSpecie4.setFont(new java.awt.Font("Bowlby One SC", 0, 24)); // NOI18N
        jLabelSpecie4.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSpecie4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelSpecie4.setText("tone");
        jLabelSpecie4.setMaximumSize(new java.awt.Dimension(70, 50));
        jLabelSpecie4.setMinimumSize(new java.awt.Dimension(70, 50));
        jLabelSpecie4.setPreferredSize(new java.awt.Dimension(70, 50));

        jButtonCalculeazaVolum.setBackground(new java.awt.Color(0, 102, 102));
        jButtonCalculeazaVolum.setFont(new java.awt.Font("Bowlby One SC", 0, 36)); // NOI18N
        jButtonCalculeazaVolum.setForeground(new java.awt.Color(0, 51, 51));
        jButtonCalculeazaVolum.setText("Calculeaza");
        jButtonCalculeazaVolum.setMaximumSize(new java.awt.Dimension(320, 50));
        jButtonCalculeazaVolum.setMinimumSize(new java.awt.Dimension(320, 50));
        jButtonCalculeazaVolum.setPreferredSize(new java.awt.Dimension(320, 50));
        jButtonCalculeazaVolum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCalculeazaVolumMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonCalculeazaVolumMouseExited(evt);
            }
        });
        jButtonCalculeazaVolum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculeazaVolumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCalculatorGreutateVolumLayout = new javax.swing.GroupLayout(jPanelCalculatorGreutateVolum);
        jPanelCalculatorGreutateVolum.setLayout(jPanelCalculatorGreutateVolumLayout);
        jPanelCalculatorGreutateVolumLayout.setHorizontalGroup(
            jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                        .addComponent(jLabelGreutateVolumBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                        .addGap(0, 217, Short.MAX_VALUE)
                        .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                                .addComponent(jLabelGreutateVolumIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelVolumGreutate4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(229, 229, 229))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                                .addComponent(jButtonCalculeazaVolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(244, 244, 244))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                                .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                                        .addComponent(jLabelGreutate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelVolum5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelTone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                                        .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelSpecieVolumGreutate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVolum3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxSpecieGreutateVolum, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldGeutateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelSpecie4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(229, 229, 229))))))
        );
        jPanelCalculatorGreutateVolumLayout.setVerticalGroup(
            jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                        .addComponent(jLabelGreutateVolumBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                        .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalculatorGreutateVolumLayout.createSequentialGroup()
                                .addComponent(jLabelVolumGreutate4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addComponent(jLabelGreutateVolumIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelTone1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelVolum5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelGreutate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSpecieGreutateVolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSpecieVolumGreutate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalculatorGreutateVolumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldGeutateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelVolum3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelSpecie4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonCalculeazaVolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabelGreutateVolumBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
        jLabelGreutateVolumIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/GreutateVolum115.png")));

        jPanelDisplaySalvari.setBackground(new java.awt.Color(0, 136, 122));
        jPanelDisplaySalvari.setMaximumSize(new java.awt.Dimension(847, 450));
        jPanelDisplaySalvari.setMinimumSize(new java.awt.Dimension(847, 450));
        jPanelDisplaySalvari.setPreferredSize(new java.awt.Dimension(847, 450));

        jLabelDisplaySalvariBack.setBackground(new java.awt.Color(0, 136, 122));
        jLabelDisplaySalvariBack.setForeground(new java.awt.Color(0, 51, 51));
        jLabelDisplaySalvariBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDisplaySalvariBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDisplaySalvariBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDisplaySalvariBackMouseExited(evt);
            }
        });

        jPanelSalvariBusteni1.setBackground(new java.awt.Color(0, 136, 122));
        jPanelSalvariBusteni1.setForeground(new java.awt.Color(0, 51, 51));

        jLabelSalvariBusteniIcon1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSalvariBusteniIcon1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSalvariBusteniIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniIcon1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniIcon1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniIcon1MouseExited(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 136, 122));
        jLabel2.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Salvari Busteni");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelSalvariBusteni1Layout = new javax.swing.GroupLayout(jPanelSalvariBusteni1);
        jPanelSalvariBusteni1.setLayout(jPanelSalvariBusteni1Layout);
        jPanelSalvariBusteni1Layout.setHorizontalGroup(
            jPanelSalvariBusteni1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalvariBusteni1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabelSalvariBusteniIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSalvariBusteni1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanelSalvariBusteni1Layout.setVerticalGroup(
            jPanelSalvariBusteni1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalvariBusteni1Layout.createSequentialGroup()
                .addComponent(jLabelSalvariBusteniIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabelSalvariBusteniIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/bustean115.png")));

        jPanelSalvariCopaci1.setBackground(new java.awt.Color(0, 136, 122));
        jPanelSalvariCopaci1.setForeground(new java.awt.Color(0, 51, 51));

        jLabelSalvariCopaciIcon1.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSalvariCopaciIcon1.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSalvariCopaciIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciIcon1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciIcon1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciIcon1MouseExited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 136, 122));
        jLabel3.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Salvari Copaci");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelSalvariCopaci1Layout = new javax.swing.GroupLayout(jPanelSalvariCopaci1);
        jPanelSalvariCopaci1.setLayout(jPanelSalvariCopaci1Layout);
        jPanelSalvariCopaci1Layout.setHorizontalGroup(
            jPanelSalvariCopaci1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalvariCopaci1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabelSalvariCopaciIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSalvariCopaci1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanelSalvariCopaci1Layout.setVerticalGroup(
            jPanelSalvariCopaci1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalvariCopaci1Layout.createSequentialGroup()
                .addComponent(jLabelSalvariCopaciIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabelSalvariCopaciIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/copac115.png")));

        javax.swing.GroupLayout jPanelDisplaySalvariLayout = new javax.swing.GroupLayout(jPanelDisplaySalvari);
        jPanelDisplaySalvari.setLayout(jPanelDisplaySalvariLayout);
        jPanelDisplaySalvariLayout.setHorizontalGroup(
            jPanelDisplaySalvariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplaySalvariLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDisplaySalvariBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(809, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDisplaySalvariLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelSalvariBusteni1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelSalvariCopaci1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        jPanelDisplaySalvariLayout.setVerticalGroup(
            jPanelDisplaySalvariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplaySalvariLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDisplaySalvariBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanelDisplaySalvariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSalvariBusteni1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelSalvariCopaci1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jLabelDisplaySalvariBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));

        jPanelDisplaySalvariBusteni.setBackground(new java.awt.Color(0, 136, 122));
        jPanelDisplaySalvariBusteni.setMaximumSize(new java.awt.Dimension(847, 450));
        jPanelDisplaySalvariBusteni.setMinimumSize(new java.awt.Dimension(847, 450));
        jPanelDisplaySalvariBusteni.setPreferredSize(new java.awt.Dimension(847, 450));

        jLabelDisplaySalvariBusteniBack.setBackground(new java.awt.Color(0, 136, 122));
        jLabelDisplaySalvariBusteniBack.setForeground(new java.awt.Color(0, 51, 51));
        jLabelDisplaySalvariBusteniBack.setOpaque(true);
        jLabelDisplaySalvariBusteniBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDisplaySalvariBusteniBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDisplaySalvariBusteniBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDisplaySalvariBusteniBackMouseExited(evt);
            }
        });

        jPanelSalvariBusteni2.setBackground(new java.awt.Color(0, 136, 122));
        jPanelSalvariBusteni2.setForeground(new java.awt.Color(0, 51, 51));

        jLabel12.setBackground(new java.awt.Color(0, 136, 122));
        jLabel12.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Salvari Busteni");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        jLabelSalvariBusteniIcon2.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSalvariBusteniIcon2.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSalvariBusteniIcon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniIcon2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniIcon2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSalvariBusteniIcon2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelSalvariBusteni2Layout = new javax.swing.GroupLayout(jPanelSalvariBusteni2);
        jPanelSalvariBusteni2.setLayout(jPanelSalvariBusteni2Layout);
        jPanelSalvariBusteni2Layout.setHorizontalGroup(
            jPanelSalvariBusteni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalvariBusteni2Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jLabelSalvariBusteniIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelSalvariBusteni2Layout.setVerticalGroup(
            jPanelSalvariBusteni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSalvariBusteni2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSalvariBusteniIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabelSalvariBusteniIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/bustean115.png")));

        jScrollPane4.setBackground(new java.awt.Color(0, 136, 122));
        jScrollPane4.setForeground(new java.awt.Color(0, 51, 51));

        jTableFisiereBusteni.setBackground(new java.awt.Color(204, 204, 204));
        jTableFisiereBusteni.setFont(new java.awt.Font("Bowlby One SC", 0, 13)); // NOI18N
        jTableFisiereBusteni.setForeground(new java.awt.Color(0, 51, 51));
        jTableFisiereBusteni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nume Fisier", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFisiereBusteni.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableFisiereBusteni);
        if (jTableFisiereBusteni.getColumnModel().getColumnCount() > 0) {
            jTableFisiereBusteni.getColumnModel().getColumn(0).setMinWidth(250);
            jTableFisiereBusteni.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTableFisiereBusteni.getColumnModel().getColumn(0).setMaxWidth(250);
            jTableFisiereBusteni.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        jButtonStergeFisierBusteni.setBackground(new java.awt.Color(0, 102, 102));
        jButtonStergeFisierBusteni.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jButtonStergeFisierBusteni.setForeground(new java.awt.Color(0, 51, 51));
        jButtonStergeFisierBusteni.setText("Sterge");
        jButtonStergeFisierBusteni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonStergeFisierBusteniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonStergeFisierBusteniMouseExited(evt);
            }
        });
        jButtonStergeFisierBusteni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStergeFisierBusteniActionPerformed(evt);
            }
        });

        jButtonModificaFisierBusteni.setBackground(new java.awt.Color(0, 102, 102));
        jButtonModificaFisierBusteni.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jButtonModificaFisierBusteni.setForeground(new java.awt.Color(0, 51, 51));
        jButtonModificaFisierBusteni.setText("Modifica");
        jButtonModificaFisierBusteni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonModificaFisierBusteniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonModificaFisierBusteniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonModificaFisierBusteniMouseExited(evt);
            }
        });
        jButtonModificaFisierBusteni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificaFisierBusteniActionPerformed(evt);
            }
        });

        jButtonExportaFisierBusteni.setBackground(new java.awt.Color(0, 102, 102));
        jButtonExportaFisierBusteni.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jButtonExportaFisierBusteni.setForeground(new java.awt.Color(0, 51, 51));
        jButtonExportaFisierBusteni.setText("Exporta");
        jButtonExportaFisierBusteni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonExportaFisierBusteniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonExportaFisierBusteniMouseExited(evt);
            }
        });
        jButtonExportaFisierBusteni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportaFisierBusteniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDisplaySalvariBusteniLayout = new javax.swing.GroupLayout(jPanelDisplaySalvariBusteni);
        jPanelDisplaySalvariBusteni.setLayout(jPanelDisplaySalvariBusteniLayout);
        jPanelDisplaySalvariBusteniLayout.setHorizontalGroup(
            jPanelDisplaySalvariBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplaySalvariBusteniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDisplaySalvariBusteniBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222)
                .addComponent(jPanelSalvariBusteni2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDisplaySalvariBusteniLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelDisplaySalvariBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonStergeFisierBusteni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(jButtonModificaFisierBusteni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(jButtonExportaFisierBusteni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74))
        );
        jPanelDisplaySalvariBusteniLayout.setVerticalGroup(
            jPanelDisplaySalvariBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplaySalvariBusteniLayout.createSequentialGroup()
                .addGroup(jPanelDisplaySalvariBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDisplaySalvariBusteniLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDisplaySalvariBusteniBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDisplaySalvariBusteniLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelSalvariBusteni2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanelDisplaySalvariBusteniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDisplaySalvariBusteniLayout.createSequentialGroup()
                        .addComponent(jButtonModificaFisierBusteni, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonStergeFisierBusteni, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExportaFisierBusteni, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jLabelDisplaySalvariBusteniBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));

        jPanelDisplaySalvariCopaci.setBackground(new java.awt.Color(0, 136, 122));
        jPanelDisplaySalvariCopaci.setMaximumSize(new java.awt.Dimension(847, 450));
        jPanelDisplaySalvariCopaci.setMinimumSize(new java.awt.Dimension(847, 450));
        jPanelDisplaySalvariCopaci.setPreferredSize(new java.awt.Dimension(847, 450));

        jLabelDisplaySalvariCopaciBack.setBackground(new java.awt.Color(0, 136, 122));
        jLabelDisplaySalvariCopaciBack.setForeground(new java.awt.Color(0, 51, 51));
        jLabelDisplaySalvariCopaciBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDisplaySalvariCopaciBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDisplaySalvariCopaciBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDisplaySalvariCopaciBackMouseExited(evt);
            }
        });

        jPanelSalvariCopaci2.setBackground(new java.awt.Color(0, 136, 122));
        jPanelSalvariCopaci2.setForeground(new java.awt.Color(0, 51, 51));
        jPanelSalvariCopaci2.setOpaque(false);
        jPanelSalvariCopaci2.setPreferredSize(new java.awt.Dimension(221, 208));

        jLabelSalvariCopaciIcon2.setBackground(new java.awt.Color(0, 136, 122));
        jLabelSalvariCopaciIcon2.setForeground(new java.awt.Color(0, 51, 51));
        jLabelSalvariCopaciIcon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciIcon2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciIcon2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSalvariCopaciIcon2MouseExited(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(0, 136, 122));
        jLabel13.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Salvari Copaci");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelSalvariCopaci2Layout = new javax.swing.GroupLayout(jPanelSalvariCopaci2);
        jPanelSalvariCopaci2.setLayout(jPanelSalvariCopaci2Layout);
        jPanelSalvariCopaci2Layout.setHorizontalGroup(
            jPanelSalvariCopaci2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalvariCopaci2Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jLabelSalvariCopaciIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelSalvariCopaci2Layout.setVerticalGroup(
            jPanelSalvariCopaci2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalvariCopaci2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSalvariCopaciIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabelSalvariCopaciIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/copac115.png")));

        jScrollPane5.setBackground(new java.awt.Color(0, 136, 122));
        jScrollPane5.setForeground(new java.awt.Color(0, 51, 51));

        jTableFisiereCopaci.setBackground(new java.awt.Color(204, 204, 204));
        jTableFisiereCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 13)); // NOI18N
        jTableFisiereCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jTableFisiereCopaci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nume Fisier", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFisiereCopaci.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTableFisiereCopaci);
        if (jTableFisiereCopaci.getColumnModel().getColumnCount() > 0) {
            jTableFisiereCopaci.getColumnModel().getColumn(0).setMinWidth(250);
            jTableFisiereCopaci.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTableFisiereCopaci.getColumnModel().getColumn(0).setMaxWidth(250);
        }

        jButtonModificaFisierCopaci.setBackground(new java.awt.Color(0, 102, 102));
        jButtonModificaFisierCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jButtonModificaFisierCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jButtonModificaFisierCopaci.setText("Modifica");
        jButtonModificaFisierCopaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonModificaFisierCopaciMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonModificaFisierCopaciMouseExited(evt);
            }
        });
        jButtonModificaFisierCopaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificaFisierCopaciActionPerformed(evt);
            }
        });

        jButtonStergeFisierCopaci.setBackground(new java.awt.Color(0, 102, 102));
        jButtonStergeFisierCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jButtonStergeFisierCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jButtonStergeFisierCopaci.setText("Sterge");
        jButtonStergeFisierCopaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonStergeFisierCopaciMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonStergeFisierCopaciMouseExited(evt);
            }
        });
        jButtonStergeFisierCopaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStergeFisierCopaciActionPerformed(evt);
            }
        });

        jButtonExportaFisierCopaci.setBackground(new java.awt.Color(0, 102, 102));
        jButtonExportaFisierCopaci.setFont(new java.awt.Font("Bowlby One SC", 0, 18)); // NOI18N
        jButtonExportaFisierCopaci.setForeground(new java.awt.Color(0, 51, 51));
        jButtonExportaFisierCopaci.setText("Exporta");
        jButtonExportaFisierCopaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonExportaFisierCopaciMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonExportaFisierCopaciMouseExited(evt);
            }
        });
        jButtonExportaFisierCopaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportaFisierCopaciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDisplaySalvariCopaciLayout = new javax.swing.GroupLayout(jPanelDisplaySalvariCopaci);
        jPanelDisplaySalvariCopaci.setLayout(jPanelDisplaySalvariCopaciLayout);
        jPanelDisplaySalvariCopaciLayout.setHorizontalGroup(
            jPanelDisplaySalvariCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplaySalvariCopaciLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDisplaySalvariCopaciBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219)
                .addComponent(jPanelSalvariCopaci2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDisplaySalvariCopaciLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelDisplaySalvariCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonModificaFisierCopaci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonStergeFisierCopaci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExportaFisierCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );
        jPanelDisplaySalvariCopaciLayout.setVerticalGroup(
            jPanelDisplaySalvariCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplaySalvariCopaciLayout.createSequentialGroup()
                .addGroup(jPanelDisplaySalvariCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDisplaySalvariCopaciLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDisplaySalvariCopaciBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDisplaySalvariCopaciLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanelSalvariCopaci2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(jPanelDisplaySalvariCopaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDisplaySalvariCopaciLayout.createSequentialGroup()
                        .addComponent(jButtonModificaFisierCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonStergeFisierCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExportaFisierCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        jLabelDisplaySalvariCopaciBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAllCalculators, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContentLayout.createSequentialGroup()
                    .addComponent(jPanelCalculatorBusteni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContentLayout.createSequentialGroup()
                    .addComponent(jPanelCalculatorVolumGreutate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContentLayout.createSequentialGroup()
                    .addComponent(jPanelCalculatorGreutateVolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContentLayout.createSequentialGroup()
                    .addComponent(jPanelDisplaySalvari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContentLayout.createSequentialGroup()
                    .addComponent(jPanelCalculatorCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelDisplaySalvariBusteni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelDisplaySalvariCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAllCalculators, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContentLayout.createSequentialGroup()
                    .addComponent(jPanelCalculatorBusteni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContentLayout.createSequentialGroup()
                    .addComponent(jPanelCalculatorVolumGreutate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContentLayout.createSequentialGroup()
                    .addComponent(jPanelCalculatorGreutateVolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContentLayout.createSequentialGroup()
                    .addComponent(jPanelDisplaySalvari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContentLayout.createSequentialGroup()
                    .addComponent(jPanelCalculatorCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelDisplaySalvariBusteni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelDisplaySalvariCopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jPanelManiu, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelManiu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimizeMouseClicked

    private void jLabel_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseEntered

        Border jLabel_minimize_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        //set border to the jLabel_minimize
        jLabel_minimize.setBorder(jLabel_minimize_border);
        jLabel_minimize.setBackground(new Color(254, 250, 224));

    }//GEN-LAST:event_jLabel_minimizeMouseEntered

    private void jLabel_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseExited
        jLabel_minimize.setBackground(new Color(0, 136, 122));
        Border jLabel_minimize_border = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black);
        jLabel_minimize.setBorder(jLabel_minimize_border);
    }//GEN-LAST:event_jLabel_minimizeMouseExited

    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseClicked
        if(jTableBusteni.getRowCount()==0 && jTableCopaci.getRowCount()==0){
            System.exit(0);
        }
        else{
            if(jTableBusteni.getRowCount()!=0 && jTableCopaci.getRowCount()!=0){
                JOptionPane.showMessageDialog(null, "Înainte de a închide aplicația, vă rugăm să salvați fișierele în lucru din\nVOLUM BUȘTENI și VOLUM COPAC\nsau să goliți ambele tabele!\nÎn cazul golirii tabelelor, datele se vor ȘTERGE DEFINITIV!");
                }
            else{
                if(jTableBusteni.getRowCount()!=0){
                   JOptionPane.showMessageDialog(null, "Înainte de a închide aplicația, vă rugăm să salvați fișierul în lucru din\nVOLUM BUȘTENI sau să goliți tabelul!\nÎn cazul golirii tabelului, datele se vor ȘTERGE DEFINITIV!"); 
                }
                else{
                    JOptionPane.showMessageDialog(null, "Înainte de a închide aplicația, vă rugăm să salvați fișierul în lucru din\nVOLUM COPACI sau să goliți tabelul!\nÎn cazul golirii tabelului, datele se vor ȘTERGE DEFINITIV!"); 
                }
            }
        }
    }//GEN-LAST:event_jLabel_closeMouseClicked

    private void jLabel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseEntered
        jLabel_close.setBackground(Color.red);
        jLabel_close.setForeground(Color.white);
        Border jLabel_close_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_close.setBorder(jLabel_close_border);

    }//GEN-LAST:event_jLabel_closeMouseEntered

    private void jLabel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseExited
        jLabel_close.setBackground(new Color(0, 136, 122));
        jLabel_close.setForeground(new Color(0, 51, 51));
        Border jLabel_close_border = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black);
        jLabel_close.setBorder(jLabel_close_border);

    }//GEN-LAST:event_jLabel_closeMouseExited

    private void jLabelBusteni115MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteni115MouseEntered
        jLabelBusteni115.setBackground(new Color(0, 121, 106));
        jLabel6.setBackground(new Color(0, 121, 106));
        jPanelBusteni.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelBusteni115MouseEntered

    private void jLabelBusteni115MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteni115MouseExited
         jLabelBusteni115.setBackground(new Color(0, 136, 122));
         jLabel6.setBackground(new Color(0, 136, 122));
         jPanelBusteni.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelBusteni115MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabelBusteni115.setBackground(new Color(0, 121, 106));
        jLabel6.setBackground(new Color(0, 121, 106));
        jPanelBusteni.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
         jLabelBusteni115.setBackground(new Color(0, 136, 122));
         jLabel6.setBackground(new Color(0, 136, 122));
         jPanelBusteni.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabelCopac115MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopac115MouseEntered
        jLabelCopac115.setBackground(new Color(0, 121, 106));
        jLabel7.setBackground(new Color(0, 121, 106));
        jPanelCopac.setBackground(new Color(0, 121, 106));
                
    }//GEN-LAST:event_jLabelCopac115MouseEntered

    private void jLabelCopac115MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopac115MouseExited
         jLabelCopac115.setBackground(new Color(0, 136, 122));
         jLabel7.setBackground(new Color(0, 136, 122));
         jPanelCopac.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelCopac115MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
       jLabelCopac115.setBackground(new Color(0, 121, 106));
        jLabel7.setBackground(new Color(0, 121, 106));
        jPanelCopac.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabelCopac115.setBackground(new Color(0, 136, 122));
         jLabel7.setBackground(new Color(0, 136, 122));
         jPanelCopac.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabelVolumGreutate115MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutate115MouseEntered
        
        jLabelVolumGreutate115.setBackground(new Color(0, 121, 106));
        jLabel8.setBackground(new Color(0, 121, 106));
        jPanelVolumGreutate.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelVolumGreutate115MouseEntered

    private void jLabelVolumGreutate115MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutate115MouseExited
        jLabelVolumGreutate115.setBackground(new Color(0, 136, 122));
         jLabel8.setBackground(new Color(0, 136, 122));
         jPanelVolumGreutate.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelVolumGreutate115MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
       jLabelVolumGreutate115.setBackground(new Color(0, 121, 106));
        jLabel8.setBackground(new Color(0, 121, 106));
        jPanelVolumGreutate.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        jLabelVolumGreutate115.setBackground(new Color(0, 136, 122));
         jLabel8.setBackground(new Color(0, 136, 122));
         jPanelVolumGreutate.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabelGreutateVolum115MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolum115MouseEntered
        jLabelGreutateVolum115.setBackground(new Color(0, 121, 106));
        jLabel9.setBackground(new Color(0, 121, 106));
        jPanelGreutateVolum.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelGreutateVolum115MouseEntered

    private void jLabelGreutateVolum115MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolum115MouseExited
        jLabelGreutateVolum115.setBackground(new Color(0, 136, 122));
         jLabel9.setBackground(new Color(0, 136, 122));
         jPanelGreutateVolum.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelGreutateVolum115MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabelGreutateVolum115.setBackground(new Color(0, 121, 106));
        jLabel9.setBackground(new Color(0, 121, 106));
        jPanelGreutateVolum.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
       jLabelGreutateVolum115.setBackground(new Color(0, 136, 122));
         jLabel9.setBackground(new Color(0, 136, 122));
         jPanelGreutateVolum.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabelBusteanIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteanIconMouseEntered
        jLabelBusteanIcon.setBackground(new Color(0, 121, 106));
        jLabelBustean.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelBusteanIconMouseEntered

    private void jLabelBusteanIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteanIconMouseExited
        jLabelBusteanIcon.setBackground(new Color(0, 136, 122));
        jLabelBustean.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelBusteanIconMouseExited

    private void jLabelBusteanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteanMouseEntered
        jLabelBusteanIcon.setBackground(new Color(0, 121, 106));
        jLabelBustean.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelBusteanMouseEntered

    private void jLabelBusteanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteanMouseExited
        jLabelBusteanIcon.setBackground(new Color(0, 136, 122));
        jLabelBustean.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelBusteanMouseExited

    private void jLabelCopacIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopacIconMouseEntered
        
        jLabelCopacIcon.setBackground(new Color(0, 121, 106));
        jLabelCopac.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelCopacIconMouseEntered

    private void jLabelCopacIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopacIconMouseExited
         jLabelCopacIcon.setBackground(new Color(0, 136, 122));
        jLabelCopac.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelCopacIconMouseExited

    private void jLabelCopacMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopacMouseEntered
       jLabelCopacIcon.setBackground(new Color(0, 121, 106));
        jLabelCopac.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelCopacMouseEntered

    private void jLabelCopacMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopacMouseExited
        jLabelCopacIcon.setBackground(new Color(0, 136, 122));
        jLabelCopac.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelCopacMouseExited

    private void jLabelVolumGreutateIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateIconMouseEntered
        
        jLabelVolumGreutateIcon.setBackground(new Color(0, 121, 106));
        jLabelVolumGreutate.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelVolumGreutateIconMouseEntered

    private void jLabelVolumGreutateIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateIconMouseExited
        jLabelVolumGreutateIcon.setBackground(new Color(0, 136, 122));
        jLabelVolumGreutate.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelVolumGreutateIconMouseExited

    private void jLabelVolumGreutateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateMouseEntered
        jLabelVolumGreutateIcon.setBackground(new Color(0, 121, 106));
        jLabelVolumGreutate.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelVolumGreutateMouseEntered

    private void jLabelVolumGreutateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateMouseExited
        jLabelVolumGreutateIcon.setBackground(new Color(0, 136, 122));
        jLabelVolumGreutate.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelVolumGreutateMouseExited

    private void jLabelGreutateVolumIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumIconMouseEntered
        
        jLabelGreutateVolumIcon.setBackground(new Color(0, 121, 106));
        jLabelGreutateVolum.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelGreutateVolumIconMouseEntered

    private void jLabelGreutateVolumIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumIconMouseExited
        jLabelGreutateVolumIcon.setBackground(new Color(0, 136, 122));
        jLabelGreutateVolum.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelGreutateVolumIconMouseExited

    private void jLabelGreutateVolumMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumMouseEntered
        jLabelGreutateVolumIcon.setBackground(new Color(0, 121, 106));
        jLabelGreutateVolum.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelGreutateVolumMouseEntered

    private void jLabelGreutateVolumMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumMouseExited
        jLabelGreutateVolumIcon.setBackground(new Color(0, 136, 122));
        jLabelGreutateVolum.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelGreutateVolumMouseExited

    private void jLabelSalvariIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariIconMouseEntered
        jLabelSalvariIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvari.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteni.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaci.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelSalvariIconMouseEntered

    private void jLabelSalvariIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariIconMouseExited
        jLabelSalvariIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvari.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteni.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaci.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelSalvariIconMouseExited

    private void jLabelSalvariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariMouseEntered
        jLabelSalvariIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvari.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteni.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaci.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelSalvariMouseEntered

    private void jLabelSalvariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariMouseExited
        jLabelSalvariIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvari.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteni.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaci.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelSalvariMouseExited

    private void jLabelSalvariBusteniIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniIconMouseEntered
        jLabelSalvariIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvari.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteni.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaci.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelSalvariBusteniIconMouseEntered

    private void jLabelSalvariBusteniIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniIconMouseExited
        jLabelSalvariIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvari.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteni.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaci.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelSalvariBusteniIconMouseExited

    private void jLabelSalvariBusteniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniMouseEntered
        jLabelSalvariIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvari.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteni.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaci.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelSalvariBusteniMouseEntered

    private void jLabelSalvariBusteniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniMouseExited
        jLabelSalvariIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvari.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteni.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaci.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelSalvariBusteniMouseExited

    private void jLabelSalvariCopaciIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciIconMouseEntered
        jLabelSalvariIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvari.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteni.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaci.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelSalvariCopaciIconMouseEntered

    private void jLabelSalvariCopaciIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciIconMouseExited
        jLabelSalvariIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvari.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteni.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaci.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelSalvariCopaciIconMouseExited

    private void jLabelSalvariCopaciMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciMouseEntered
        jLabelSalvariIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvari.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariBusteni.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 121, 106));
        jLabelSalvariCopaci.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelSalvariCopaciMouseEntered

    private void jLabelSalvariCopaciMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciMouseExited
        jLabelSalvariIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvari.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteni.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaci.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelSalvariCopaciMouseExited

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered
        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/exitred.png")));

    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited
        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/exitblack.png")));

    }//GEN-LAST:event_jLabelExitMouseExited

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        LoginForm login = new LoginForm();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        JlabelActivUser.setText(null);
        this.dispose();
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelBusteanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteanMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorBusteni);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        
       
        
    }//GEN-LAST:event_jLabelBusteanMouseClicked

    private void jLabelBusteanIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteanIconMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorBusteni);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        
    }//GEN-LAST:event_jLabelBusteanIconMouseClicked

    private void jLabelBusteni115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteni115MouseClicked
       jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorBusteni);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelBusteni115.setBackground(new Color(0, 136, 122));
         jLabel6.setBackground(new Color(0, 136, 122));
         jPanelBusteni.setBackground(new Color(0, 136, 122));
        
    }//GEN-LAST:event_jLabelBusteni115MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
      jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorBusteni);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelBusteni115.setBackground(new Color(0, 136, 122));
         jLabel6.setBackground(new Color(0, 136, 122));
         jPanelBusteni.setBackground(new Color(0, 136, 122));
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabelCopacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopacMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorCopaci);
        jPanelContent.repaint();
        jPanelContent.revalidate();
    }//GEN-LAST:event_jLabelCopacMouseClicked

    private void jLabelVolumGreutateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorVolumGreutate);
        jPanelContent.repaint();
        jPanelContent.revalidate();
    }//GEN-LAST:event_jLabelVolumGreutateMouseClicked

    private void jLabelGreutateVolumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorGreutateVolum);
        jPanelContent.repaint();
        jPanelContent.revalidate();
    }//GEN-LAST:event_jLabelGreutateVolumMouseClicked

    private void jLabelCopacIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopacIconMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorCopaci);
        jPanelContent.repaint();
        jPanelContent.revalidate();
    }//GEN-LAST:event_jLabelCopacIconMouseClicked

    private void jLabelVolumGreutateIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateIconMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorVolumGreutate);
        jPanelContent.repaint();
        jPanelContent.revalidate();
    }//GEN-LAST:event_jLabelVolumGreutateIconMouseClicked

    private void jLabelGreutateVolumIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumIconMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorGreutateVolum);
        jPanelContent.repaint();
        jPanelContent.revalidate();
    }//GEN-LAST:event_jLabelGreutateVolumIconMouseClicked

    private void jLabelSalvariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvari);
        jPanelContent.repaint();
        jPanelContent.revalidate();
    }//GEN-LAST:event_jLabelSalvariMouseClicked

    private void jLabelSalvariIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariIconMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvari);
        jPanelContent.repaint();
        jPanelContent.revalidate();
    }//GEN-LAST:event_jLabelSalvariIconMouseClicked

    private void jLabelBusteniBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteniBackMouseClicked
        if(jTableBusteni.getRowCount()==0){
            jPanelContent.removeAll();
            jPanelContent.repaint();
            jPanelContent.revalidate();
            jPanelContent.add(jPanelAllCalculators);
            jPanelContent.repaint();
            jPanelContent.revalidate();
            jLabelBusteniBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
        }
        else{
            JOptionPane.showMessageDialog(null, "Înainte de a părăsi această pagină, vă rugăm să salvați fișierul sau să goliți tabelul!\nÎn cazul golirii tabelului, datele se vor ȘTERGE DEFINITIV! ");
        }
    }//GEN-LAST:event_jLabelBusteniBackMouseClicked

    private void jLabelBusteniBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteniBackMouseEntered
        jLabelBusteniBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/backred.png")));
    }//GEN-LAST:event_jLabelBusteniBackMouseEntered

    private void jLabelBusteniBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteniBackMouseExited
        jLabelBusteniBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelBusteniBackMouseExited

    private void jLabelVolumGreutateBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateBackMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelAllCalculators);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelVolumGreutateBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelVolumGreutateBackMouseClicked

    private void jLabelVolumGreutateBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateBackMouseEntered
        jLabelVolumGreutateBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/backred.png")));
    }//GEN-LAST:event_jLabelVolumGreutateBackMouseEntered

    private void jLabelVolumGreutateBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateBackMouseExited
        jLabelVolumGreutateBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelVolumGreutateBackMouseExited

    private void jLabelGreutateVolumBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumBackMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelAllCalculators);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelGreutateVolumBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelGreutateVolumBackMouseClicked

    private void jLabelGreutateVolumBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumBackMouseEntered
        jLabelGreutateVolumBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/backred.png")));
    }//GEN-LAST:event_jLabelGreutateVolumBackMouseEntered

    private void jLabelGreutateVolumBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumBackMouseExited
        jLabelGreutateVolumBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelGreutateVolumBackMouseExited

    private void jLabelDisplaySalvariBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDisplaySalvariBackMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelAllCalculators);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelDisplaySalvariBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelDisplaySalvariBackMouseClicked

    private void jLabelDisplaySalvariBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDisplaySalvariBackMouseEntered
        jLabelDisplaySalvariBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/backred.png")));
    }//GEN-LAST:event_jLabelDisplaySalvariBackMouseEntered

    private void jLabelDisplaySalvariBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDisplaySalvariBackMouseExited
        jLabelDisplaySalvariBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelDisplaySalvariBackMouseExited

    private void jLabelHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMouseEntered
        jLabelHomeIcon.setBackground(new Color(0, 121, 106));
        jLabelHome.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelHomeMouseEntered

    private void jLabelHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMouseExited
        jLabelHomeIcon.setBackground(new Color(0, 136, 122));
        jLabelHome.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelHomeMouseExited

    private void jLabelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelAllCalculators);
        jPanelContent.repaint();
        jPanelContent.revalidate();
    }//GEN-LAST:event_jLabelHomeMouseClicked

    private void jLabelHomeIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeIconMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelAllCalculators);
        jPanelContent.repaint();
        jPanelContent.revalidate();
    }//GEN-LAST:event_jLabelHomeIconMouseClicked

    private void jLabelCopac115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopac115MouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorCopaci);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelCopac115.setBackground(new Color(0, 136, 122));
         jLabel7.setBackground(new Color(0, 136, 122));
         jPanelCopac.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelCopac115MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorCopaci);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelCopac115.setBackground(new Color(0, 136, 122));
         jLabel7.setBackground(new Color(0, 136, 122));
         jPanelCopac.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabelVolumGreutate115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutate115MouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorVolumGreutate);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelVolumGreutate115.setBackground(new Color(0, 136, 122));
         jLabel8.setBackground(new Color(0, 136, 122));
         jPanelVolumGreutate.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelVolumGreutate115MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorVolumGreutate);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelVolumGreutate115.setBackground(new Color(0, 136, 122));
         jLabel8.setBackground(new Color(0, 136, 122));
         jPanelVolumGreutate.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabelGreutateVolum115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolum115MouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorGreutateVolum);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelGreutateVolum115.setBackground(new Color(0, 136, 122));
         jLabel9.setBackground(new Color(0, 136, 122));
         jPanelGreutateVolum.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelGreutateVolum115MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelCalculatorGreutateVolum);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelGreutateVolum115.setBackground(new Color(0, 136, 122));
         jLabel9.setBackground(new Color(0, 136, 122));
         jPanelGreutateVolum.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabel8MouseClicked

    private void JlabelActivUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlabelActivUserMouseEntered
        
    }//GEN-LAST:event_JlabelActivUserMouseEntered

    private void jLabelBusteanCalculatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteanCalculatorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelBusteanCalculatorMouseClicked

    private void jLabelBusteanCalculatorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteanCalculatorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelBusteanCalculatorMouseEntered

    private void jLabelBusteanCalculatorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteanCalculatorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelBusteanCalculatorMouseExited

    private void jLabelBusteniCalculatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteniCalculatorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelBusteniCalculatorMouseClicked

    private void jLabelBusteniCalculatorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteniCalculatorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelBusteniCalculatorMouseEntered

    private void jLabelBusteniCalculatorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBusteniCalculatorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelBusteniCalculatorMouseExited

    private void jTextFieldCantitateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantitateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantitateActionPerformed

    private void jButtonCalculeazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculeazaActionPerformed
            if(VerifyFields()){
                Double diametru;
                Double lungime;
                Double cantitate;
                diametru = Double.parseDouble(jTextFieldDiametru.getText());
                lungime = Double.parseDouble(jTextFieldLungime.getText());
                cantitate = Double.parseDouble(jTextFieldCantitate.getText());
                
                DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
                dfs.setDecimalSeparator('.');
                DecimalFormat df = new DecimalFormat("0.00", dfs);
                df.setRoundingMode(RoundingMode.HALF_DOWN);
                
                String x = df.format(Double.parseDouble((df.format(Math.PI/4*lungime*diametru*diametru/10000)))*cantitate);
  
               
    
                jLabelVolumMC.setText(x);
                modelBusteni.insertRow(modelBusteni.getRowCount(), new Object[] {modelBusteni.getRowCount()+1, jTextFieldCantitate.getText(), jTextFieldLungime.getText(), jTextFieldDiametru.getText(), jLabelVolumMC.getText()});
                
                jTextFieldDiametru.setText("...");
                jTextFieldLungime.setText("...");
                jTextFieldCantitate.setText("1");
                
                jLabelTotal.setText("");
                Double total=0.0;
                for(int i=0 ; i<modelBusteni.getRowCount(); i++){
                    total = total + Double.parseDouble((String) jTableBusteni.getValueAt(i, 4));
                }
                
                String Total = df.format(total);
                jLabelTotal.setText(String.valueOf(Total));
                
            }
            
            
    }//GEN-LAST:event_jButtonCalculeazaActionPerformed

    private void jTextFieldDiametruFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDiametruFocusGained
        if(jTextFieldDiametru.getText().trim().toLowerCase().equals("..."))
        {
            jTextFieldDiametru.setText("");
        }
    }//GEN-LAST:event_jTextFieldDiametruFocusGained

    private void jTextFieldDiametruFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDiametruFocusLost
        if(jTextFieldDiametru.getText().trim().toLowerCase().equals("...") ||
           jTextFieldDiametru.getText().trim().toLowerCase().equals(""))
        {
            jTextFieldDiametru.setText("...");
        }
    }//GEN-LAST:event_jTextFieldDiametruFocusLost

    private void jTextFieldLungimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLungimeFocusGained
        if(jTextFieldLungime.getText().trim().toLowerCase().equals("..."))
        {
            jTextFieldLungime.setText("");
        }
    }//GEN-LAST:event_jTextFieldLungimeFocusGained

    private void jTextFieldLungimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLungimeFocusLost
        if(jTextFieldLungime.getText().trim().toLowerCase().equals("...") ||
           jTextFieldLungime.getText().trim().toLowerCase().equals(""))
        {
            jTextFieldLungime.setText("...");
        }
    }//GEN-LAST:event_jTextFieldLungimeFocusLost

    private void jTextFieldDiametruKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiametruKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_jTextFieldDiametruKeyTyped

    private void jTextFieldLungimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLungimeKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c) && c != 46 ){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_jTextFieldLungimeKeyTyped

    private void jTextFieldCantitateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCantitateKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_jTextFieldCantitateKeyTyped

    private void jButtonStergeBusteanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStergeBusteanActionPerformed
        try{
            int SelectedRowIndex = jTableBusteni.getSelectedRow();
            modelBusteni.removeRow(SelectedRowIndex);
            jLabelTotal.setText("");
                Double total=0.0;
                for(int i=0 ; i<modelBusteni.getRowCount(); i++){
                    total = total + Double.parseDouble((String) jTableBusteni.getValueAt(i, 4));
                }
                
                jLabelTotal.setText(String.valueOf(total));
        }
        catch(Exception ex){
            
        }
        
        
    }//GEN-LAST:event_jButtonStergeBusteanActionPerformed

    private void jLabelVolumCopaciBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumCopaciBackMouseClicked
        if(jTableCopaci.getRowCount()==0){
            jPanelContent.removeAll();
            jPanelContent.repaint();
            jPanelContent.revalidate();
            jPanelContent.add(jPanelAllCalculators);
            jPanelContent.repaint();
            jPanelContent.revalidate();
            jLabelVolumCopaciBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
        }
        else{
            JOptionPane.showMessageDialog(null, "Înainte de a părăsi această pagină, vă rugăm să salvați fișierul sau să goliți tabelul!\nÎn cazul golirii tabelului, datele se vor ȘTERGE DEFINITIV! ");
        }
        
    }//GEN-LAST:event_jLabelVolumCopaciBackMouseClicked

    private void jLabelVolumCopaciBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumCopaciBackMouseEntered
        jLabelVolumCopaciBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/backred.png")));
    }//GEN-LAST:event_jLabelVolumCopaciBackMouseEntered

    private void jLabelVolumCopaciBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumCopaciBackMouseExited
        jLabelVolumCopaciBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelVolumCopaciBackMouseExited

    private void jButtonStergreTotalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStergreTotalaActionPerformed
        while(modelBusteni.getRowCount()>0){
            for(int i=0 ;i<modelBusteni.getRowCount() ; i++){
                modelBusteni.removeRow(i);
            }
        }
        jLabelTotal.setText("...");
    }//GEN-LAST:event_jButtonStergreTotalaActionPerformed

    private void jLabelCopaciCalculatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopaciCalculatorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCopaciCalculatorMouseClicked

    private void jLabelCopaciCalculatorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopaciCalculatorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCopaciCalculatorMouseEntered

    private void jLabelCopaciCalculatorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopaciCalculatorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCopaciCalculatorMouseExited

    private void jLabelCopaciCalculatorIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopaciCalculatorIconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCopaciCalculatorIconMouseClicked

    private void jLabelCopaciCalculatorIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopaciCalculatorIconMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCopaciCalculatorIconMouseEntered

    private void jLabelCopaciCalculatorIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCopaciCalculatorIconMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCopaciCalculatorIconMouseExited

    private void jTextFieldDiametruPieptFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDiametruPieptFocusGained
        if(jTextFieldDiametruPiept.getText().trim().toLowerCase().equals("..."))
        {
            jTextFieldDiametruPiept.setText("");
        }
    }//GEN-LAST:event_jTextFieldDiametruPieptFocusGained

    private void jTextFieldDiametruPieptFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDiametruPieptFocusLost
        if(jTextFieldDiametruPiept.getText().trim().toLowerCase().equals("...") ||
           jTextFieldDiametruPiept.getText().trim().toLowerCase().equals(""))
        {
            jTextFieldDiametruPiept.setText("...");
        }
    }//GEN-LAST:event_jTextFieldDiametruPieptFocusLost

    private void jTextFieldDiametruPieptKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiametruPieptKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_jTextFieldDiametruPieptKeyTyped

    private void jTextFieldInaltimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldInaltimeFocusGained
        if(jTextFieldInaltime.getText().trim().toLowerCase().equals("..."))
        {
            jTextFieldInaltime.setText("");
        }
		
    }//GEN-LAST:event_jTextFieldInaltimeFocusGained

    private void jTextFieldInaltimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldInaltimeFocusLost
        if(jTextFieldInaltime.getText().trim().toLowerCase().equals("...") ||
           jTextFieldInaltime.getText().trim().toLowerCase().equals(""))
        {
            jTextFieldInaltime.setText("...");
        }
    }//GEN-LAST:event_jTextFieldInaltimeFocusLost

    private void jTextFieldInaltimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldInaltimeKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c) && c != 46  ){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_jTextFieldInaltimeKeyTyped

    private void jTextFieldCantitateCopaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantitateCopaciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantitateCopaciActionPerformed

    private void jTextFieldCantitateCopaciKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCantitateCopaciKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_jTextFieldCantitateCopaciKeyTyped

    private void jComboBoxSpecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSpecieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSpecieActionPerformed

    private void jButtonCalculeazaCopacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculeazaCopacActionPerformed
        if(VerifyFieldsCopaci()){
                String specie = (String)jComboBoxSpecie.getSelectedItem();
                Double diametruPiept;
                Double inaltime;
                Double cantitateCopaci;
                Double coeficient;
                
                diametruPiept = Double.parseDouble(jTextFieldDiametruPiept.getText());        
                inaltime = Double.parseDouble(jTextFieldInaltime.getText());
                cantitateCopaci = Double.parseDouble(jTextFieldCantitateCopaci.getText());
                coeficient = dictionarSpecii.get(specie);
                               
                DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
                dfs.setDecimalSeparator('.');
                DecimalFormat df = new DecimalFormat("0.00", dfs);
                df.setRoundingMode(RoundingMode.HALF_DOWN);
                
                String x = df.format(Double.parseDouble((df.format(Math.PI/4*inaltime*diametruPiept*diametruPiept/10000)))*cantitateCopaci*coeficient);
  
                //System.out.println(x);
                //System.out.println(String.format("%.2f", x));
    
                jLabelVolumCopac.setText(x);
                modelCopaci.insertRow(modelCopaci.getRowCount(), new Object[] {modelCopaci.getRowCount()+1, jTextFieldCantitateCopaci.getText(),specie, jTextFieldInaltime.getText(), jTextFieldDiametruPiept.getText(), jLabelVolumCopac.getText()});
                
                
                jTextFieldDiametruPiept.setText("...");
                jTextFieldInaltime.setText("...");
                jTextFieldCantitateCopaci.setText("1");
                
                jLabelTotalCopaci.setText("");
                Double total=0.0;
                for(int i=0 ; i<modelCopaci.getRowCount(); i++){
                    total = total + Double.parseDouble((String) jTableCopaci.getValueAt(i, 5));
                }
                
                String totalCopaci = df.format(total);
                jLabelTotalCopaci.setText(String.valueOf(totalCopaci));
                
            }
    }//GEN-LAST:event_jButtonCalculeazaCopacActionPerformed

    private void jButtonStergreTotalaCopaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStergreTotalaCopaciActionPerformed
        while(modelCopaci.getRowCount()>0){
            for(int i=0 ;i<modelCopaci.getRowCount() ; i++){
                modelCopaci.removeRow(i);
            }
        }
        jLabelTotalCopaci.setText("...");
    }//GEN-LAST:event_jButtonStergreTotalaCopaciActionPerformed

    private void jButtonStergeCopacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStergeCopacActionPerformed
        try{
            int SelectedRowIndex = jTableCopaci.getSelectedRow();
            modelCopaci.removeRow(SelectedRowIndex);
            jLabelTotalCopaci.setText("");
                Double total=0.0;
                for(int i=0 ; i<modelCopaci.getRowCount(); i++){
                    total = total + Double.parseDouble((String) jTableCopaci.getValueAt(i, 5));
                }
                
                jLabelTotalCopaci.setText(String.valueOf(total));
        }
        catch(Exception ex){
            
        }
    }//GEN-LAST:event_jButtonStergeCopacActionPerformed

    private void jLabelVolumGreutate3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutate3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelVolumGreutate3MouseClicked

    private void jLabelVolumGreutate3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutate3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelVolumGreutate3MouseEntered

    private void jLabelVolumGreutate3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutate3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelVolumGreutate3MouseExited

    private void jLabelVolumGreutateIcon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateIcon1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelVolumGreutateIcon1MouseClicked

    private void jLabelVolumGreutateIcon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateIcon1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelVolumGreutateIcon1MouseEntered

    private void jLabelVolumGreutateIcon1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutateIcon1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelVolumGreutateIcon1MouseExited

    private void jComboBoxSpecieVolumGreutateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSpecieVolumGreutateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSpecieVolumGreutateActionPerformed

    private void jButtonCalculeazaGreutateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculeazaGreutateActionPerformed
        if(VerifyFieldsVolumGreutate()){
                String specie = (String)jComboBoxSpecieVolumGreutate.getSelectedItem();
                Double volum;
                Double coeficient;
                volum = Double.parseDouble(jTextFieldVolumInput.getText());
                coeficient = dictionarSpeciiVG.get(specie);
                
                DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
                dfs.setDecimalSeparator('.');
                DecimalFormat df = new DecimalFormat("0.00", dfs);
                df.setRoundingMode(RoundingMode.HALF_DOWN);

                
                String x = df.format((volum*coeficient)/1000);
                jTextFieldVolumInput.setText("...");
                
                jLabelVolumGreutate1.setText(x);
                
            }
    }//GEN-LAST:event_jButtonCalculeazaGreutateActionPerformed

    private void jTextFieldVolumInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVolumInputKeyTyped
         char c = evt.getKeyChar();
        
        if(!Character.isDigit(c) && c != 46  ){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_jTextFieldVolumInputKeyTyped

    private void jTextFieldVolumInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldVolumInputFocusGained
        if(jTextFieldVolumInput.getText().trim().toLowerCase().equals("..."))
        {
            jTextFieldVolumInput.setText("");
        }
    }//GEN-LAST:event_jTextFieldVolumInputFocusGained

    private void jTextFieldVolumInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldVolumInputFocusLost
        if(jTextFieldVolumInput.getText().trim().toLowerCase().equals("...") ||
           jTextFieldVolumInput.getText().trim().toLowerCase().equals(""))
        {
            jTextFieldVolumInput.setText("...");
        }
    }//GEN-LAST:event_jTextFieldVolumInputFocusLost

    private void jLabelGreutateVolumIcon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumIcon2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelGreutateVolumIcon2MouseClicked

    private void jLabelGreutateVolumIcon2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumIcon2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelGreutateVolumIcon2MouseEntered

    private void jLabelGreutateVolumIcon2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGreutateVolumIcon2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelGreutateVolumIcon2MouseExited

    private void jLabelVolumGreutate4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutate4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelVolumGreutate4MouseClicked

    private void jLabelVolumGreutate4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutate4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelVolumGreutate4MouseEntered

    private void jLabelVolumGreutate4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVolumGreutate4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelVolumGreutate4MouseExited

    private void jComboBoxSpecieGreutateVolumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSpecieGreutateVolumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSpecieGreutateVolumActionPerformed

    private void jTextFieldGeutateInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldGeutateInputFocusGained
        if(jTextFieldGeutateInput.getText().trim().toLowerCase().equals("..."))
        {
            jTextFieldGeutateInput.setText("");
        }
    }//GEN-LAST:event_jTextFieldGeutateInputFocusGained

    private void jTextFieldGeutateInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldGeutateInputFocusLost
        if(jTextFieldGeutateInput.getText().trim().toLowerCase().equals("...") ||
           jTextFieldGeutateInput.getText().trim().toLowerCase().equals(""))
        {
            jTextFieldGeutateInput.setText("...");
        }
    }//GEN-LAST:event_jTextFieldGeutateInputFocusLost

    private void jTextFieldGeutateInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGeutateInputKeyTyped
         char c = evt.getKeyChar();
        
        if(!Character.isDigit(c) && c != 46  ){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_jTextFieldGeutateInputKeyTyped

    private void jButtonCalculeazaVolumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculeazaVolumActionPerformed
        if(VerifyFieldsGreutateVolum()){
                String specie = (String)jComboBoxSpecieGreutateVolum.getSelectedItem();
                Double greutate;
                Double coeficient;
                greutate = Double.parseDouble(jTextFieldGeutateInput.getText());
                coeficient = dictionarSpeciiVG.get(specie);
                
                DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
                dfs.setDecimalSeparator('.');
                DecimalFormat df = new DecimalFormat("0.00", dfs);
                df.setRoundingMode(RoundingMode.HALF_DOWN);

                
                String x = df.format((greutate*1000)/coeficient);
                jTextFieldGeutateInput.setText("...");
                jLabelVolum5.setText(x);
                
            }
    }//GEN-LAST:event_jButtonCalculeazaVolumActionPerformed

    private void jLabelSalvariCopaciIcon1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciIcon1MouseExited
        jLabelSalvariCopaciIcon1.setBackground(new Color(0, 136, 122));
        jPanelSalvariCopaci1.setBackground(new Color(0, 136, 122));
        jLabel3.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelSalvariCopaciIcon1MouseExited

    private void jLabelSalvariCopaciIcon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciIcon1MouseEntered
        jLabelSalvariCopaciIcon1.setBackground(new Color(0, 121, 106));
        jPanelSalvariCopaci1.setBackground(new Color(0, 121, 106));
        jLabel3.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelSalvariCopaciIcon1MouseEntered

    private void jLabelSalvariCopaciIcon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciIcon1MouseClicked
        jLabelSalvariCopaciIcon1.setBackground(new Color(0, 136, 122));
        jPanelSalvariCopaci1.setBackground(new Color(0, 136, 122));
        jLabel3.setBackground(new Color(0, 136, 122));
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvariCopaci);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        
        while(modelFisiereCopaci.getRowCount()>0){
            for(int i=0 ;i<modelFisiereCopaci.getRowCount() ; i++){
                modelFisiereCopaci.removeRow(i);
            }
        }
        String username = JlabelActivUser.getText();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT DISTINCT fname, data FROM `copaci` WHERE `username`=?";
        
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            while(rs.next()){
                String fname = (String)rs.getString("fname");
                String stringDate  = (String)rs.getString("data");
                Date sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDate);
                String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sdf);
                modelFisiereCopaci.insertRow(modelFisiereCopaci.getRowCount(), new Object[] {fname, data});
                
            }
        }
        catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ParseException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jLabelSalvariCopaciIcon1MouseClicked

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabelSalvariCopaciIcon1.setBackground(new Color(0, 136, 122));
        jPanelSalvariCopaci1.setBackground(new Color(0, 136, 122));
        jLabel3.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabelSalvariCopaciIcon1.setBackground(new Color(0, 121, 106));
        jPanelSalvariCopaci1.setBackground(new Color(0, 121, 106));
        jLabel3.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        jLabelSalvariCopaciIcon1.setBackground(new Color(0, 136, 122));
        jPanelSalvariCopaci1.setBackground(new Color(0, 136, 122));
        jLabel3.setBackground(new Color(0, 136, 122));
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvariCopaci);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        
        while(modelFisiereCopaci.getRowCount()>0){
            for(int i=0 ;i<modelFisiereCopaci.getRowCount() ; i++){
                modelFisiereCopaci.removeRow(i);
            }
        }
        String username = JlabelActivUser.getText();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT DISTINCT fname, data FROM `copaci` WHERE `username`=?";
        
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            while(rs.next()){
                String fname = (String)rs.getString("fname");
                String stringDate  = (String)rs.getString("data");
                Date sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDate);
                String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sdf);
                modelFisiereCopaci.insertRow(modelFisiereCopaci.getRowCount(), new Object[] {fname, data});
                
            }
        }
        catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ParseException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabelSalvariBusteniIcon1.setBackground(new Color(0, 136, 122));
        jPanelSalvariBusteni1.setBackground(new Color(0, 136, 122));
        jLabel2.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabelSalvariBusteniIcon1.setBackground(new Color(0, 121, 106));
        jPanelSalvariBusteni1.setBackground(new Color(0, 121, 106));
        jLabel2.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        jLabelSalvariBusteniIcon1.setBackground(new Color(0, 136, 122));
        jPanelSalvariBusteni1.setBackground(new Color(0, 136, 122));
        jLabel2.setBackground(new Color(0, 136, 122));
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvariBusteni);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        
        while(modelFisiereBusteni.getRowCount()>0){
            for(int i=0 ;i<modelFisiereBusteni.getRowCount() ; i++){
                modelFisiereBusteni.removeRow(i);
            }
        }
        String username = JlabelActivUser.getText();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT DISTINCT fname, data FROM `busteni` WHERE `username`=?";
        
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            while(rs.next()){
                String fname = (String)rs.getString("fname");
                String stringDate  = (String)rs.getString("data");
                Date sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDate);
                String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sdf);
                modelFisiereBusteni.insertRow(modelFisiereBusteni.getRowCount(), new Object[] {fname, data});
              
                
            }
        }
        catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ParseException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabelSalvariBusteniIcon1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniIcon1MouseExited
        jLabelSalvariBusteniIcon1.setBackground(new Color(0, 136, 122));
        jPanelSalvariBusteni1.setBackground(new Color(0, 136, 122));
        jLabel2.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelSalvariBusteniIcon1MouseExited

    private void jLabelSalvariBusteniIcon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniIcon1MouseEntered
        jLabelSalvariBusteniIcon1.setBackground(new Color(0, 121, 106));
        jPanelSalvariBusteni1.setBackground(new Color(0, 121, 106));
        jLabel2.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelSalvariBusteniIcon1MouseEntered

    private void jLabelSalvariBusteniIcon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniIcon1MouseClicked
        jLabelSalvariBusteniIcon1.setBackground(new Color(0, 136, 122));
        jPanelSalvariBusteni1.setBackground(new Color(0, 136, 122));
        jLabel2.setBackground(new Color(0, 136, 122));
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvariBusteni);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        while(modelFisiereBusteni.getRowCount()>0){
            for(int i=0 ;i<modelFisiereBusteni.getRowCount() ; i++){
                modelFisiereBusteni.removeRow(i);
            }
        }
        String username = JlabelActivUser.getText();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT DISTINCT fname, data FROM `busteni` WHERE `username`=?";
        
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            while(rs.next()){
                String fname = (String)rs.getString("fname");
                String stringDate  = (String)rs.getString("data");
                Date sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDate);
                String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sdf);
                
                modelFisiereBusteni.insertRow(modelFisiereBusteni.getRowCount(), new Object[] {fname, data});
                
            }
        }
        catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ParseException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jLabelSalvariBusteniIcon1MouseClicked

    private void jLabelDisplaySalvariBusteniBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDisplaySalvariBusteniBackMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvari);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelDisplaySalvariBusteniBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelDisplaySalvariBusteniBackMouseClicked

    private void jLabelDisplaySalvariBusteniBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDisplaySalvariBusteniBackMouseEntered
        jLabelDisplaySalvariBusteniBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/backred.png")));
    }//GEN-LAST:event_jLabelDisplaySalvariBusteniBackMouseEntered

    private void jLabelDisplaySalvariBusteniBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDisplaySalvariBusteniBackMouseExited
        jLabelDisplaySalvariBusteniBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelDisplaySalvariBusteniBackMouseExited

    private void jLabelDisplaySalvariCopaciBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDisplaySalvariCopaciBackMouseClicked
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvari);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jLabelDisplaySalvariCopaciBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelDisplaySalvariCopaciBackMouseClicked

    private void jLabelDisplaySalvariCopaciBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDisplaySalvariCopaciBackMouseEntered
        jLabelDisplaySalvariCopaciBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/backred.png")));
    }//GEN-LAST:event_jLabelDisplaySalvariCopaciBackMouseEntered

    private void jLabelDisplaySalvariCopaciBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDisplaySalvariCopaciBackMouseExited
        jLabelDisplaySalvariCopaciBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/back.png")));
    }//GEN-LAST:event_jLabelDisplaySalvariCopaciBackMouseExited

    private void jLabelSalvariBusteniIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniIconMouseClicked
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteni.setBackground(new Color(0, 136, 122));
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvariBusteni);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        
        while(modelFisiereBusteni.getRowCount()>0){
            for(int i=0 ;i<modelFisiereBusteni.getRowCount() ; i++){
                modelFisiereBusteni.removeRow(i);
            }
        }
        String username = JlabelActivUser.getText();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT DISTINCT fname, data FROM `busteni` WHERE `username`=?";
        
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            while(rs.next()){
                String fname = (String)rs.getString("fname");
                String stringDate  = (String)rs.getString("data");
                Date sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDate);
                String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sdf);
                modelFisiereBusteni.insertRow(modelFisiereBusteni.getRowCount(), new Object[] {fname, data});
                
            }
        }
        catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ParseException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSalvariBusteniIconMouseClicked

    private void jLabelSalvariBusteniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniMouseClicked
        jLabelSalvariBusteniIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariBusteni.setBackground(new Color(0, 136, 122));
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvariBusteni);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        
        while(modelFisiereBusteni.getRowCount()>0){
            for(int i=0 ;i<modelFisiereBusteni.getRowCount() ; i++){
                modelFisiereBusteni.removeRow(i);
            }
        }
        String username = JlabelActivUser.getText();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT DISTINCT fname, data FROM `busteni` WHERE `username`=?";
        
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            while(rs.next()){
                String fname = (String)rs.getString("fname");
                String stringDate  = (String)rs.getString("data");
                Date sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDate);
                String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sdf);
                modelFisiereBusteni.insertRow(modelFisiereBusteni.getRowCount(), new Object[] {fname, data});
                
            }
        }
        catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ParseException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSalvariBusteniMouseClicked

    private void jLabelSalvariCopaciIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciIconMouseClicked
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaci.setBackground(new Color(0, 136, 122));
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvariCopaci);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        
        while(modelFisiereCopaci.getRowCount()>0){
            for(int i=0 ;i<modelFisiereCopaci.getRowCount() ; i++){
                modelFisiereCopaci.removeRow(i);
            }
        }
        String username = JlabelActivUser.getText();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT DISTINCT fname, data FROM `copaci` WHERE `username`=?";
        
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            while(rs.next()){
                String fname = (String)rs.getString("fname");
                String stringDate  = (String)rs.getString("data");
                Date sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDate);
                String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sdf);
                modelFisiereCopaci.insertRow(modelFisiereCopaci.getRowCount(), new Object[] {fname, data});
                
            }
        }
        catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ParseException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSalvariCopaciIconMouseClicked

    private void jLabelSalvariCopaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciMouseClicked
        jLabelSalvariCopaciIcon.setBackground(new Color(0, 136, 122));
        jLabelSalvariCopaci.setBackground(new Color(0, 136, 122));
        jPanelContent.removeAll();
        jPanelContent.repaint();
        jPanelContent.revalidate();
        jPanelContent.add(jPanelDisplaySalvariCopaci);
        jPanelContent.repaint();
        jPanelContent.revalidate();
        
        while(modelFisiereCopaci.getRowCount()>0){
            for(int i=0 ;i<modelFisiereCopaci.getRowCount() ; i++){
                modelFisiereCopaci.removeRow(i);
            }
        }
        String username = JlabelActivUser.getText();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT DISTINCT fname, data FROM `copaci` WHERE `username`=?";
        
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            while(rs.next()){
                String fname = (String)rs.getString("fname");
                String stringDate  = (String)rs.getString("data");
                Date sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDate);
                String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sdf);
                modelFisiereCopaci.insertRow(modelFisiereCopaci.getRowCount(), new Object[] {fname, data});
                
            }
        }
        catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ParseException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSalvariCopaciMouseClicked

    private void jLabelSalvariBusteniIcon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniIcon2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSalvariBusteniIcon2MouseClicked

    private void jLabelSalvariBusteniIcon2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniIcon2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSalvariBusteniIcon2MouseEntered

    private void jLabelSalvariBusteniIcon2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariBusteniIcon2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSalvariBusteniIcon2MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabelSalvariCopaciIcon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciIcon2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSalvariCopaciIcon2MouseClicked

    private void jLabelSalvariCopaciIcon2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciIcon2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSalvariCopaciIcon2MouseEntered

    private void jLabelSalvariCopaciIcon2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalvariCopaciIcon2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSalvariCopaciIcon2MouseExited

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseExited

    private void jButtonSalvareBusteniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvareBusteniActionPerformed

        String username=JlabelActivUser.getText();
        String fname = jTextFieldNumeFisier.getText();
        
        if(jTableBusteni.getRowCount()!=0){
        if(VerifyNumeFisierBusteni()){
            if(!CheckNumeFisierBusteni(fname)){
                PreparedStatement ps;
                ResultSet rs;
                String registerBusteanQuery = "INSERT INTO `busteni` (`cantitate`, `lungime`, `diametru`, `volum`, `username`, `fname`) VALUES (?, ?, ?, ?, ?, ?)";
                
                try{
                    
                    ps = My_CNX.getConnection().prepareStatement(registerBusteanQuery);
                    int ok=1;
                    for(int i=0; i<jTableBusteni.getRowCount() ; i++){
                        int cantitate=Integer.parseInt((String) jTableBusteni.getValueAt(i, 1));
                        int lungime=Integer.parseInt((String) jTableBusteni.getValueAt(i, 2));
                        int diametru=Integer.parseInt((String) jTableBusteni.getValueAt(i, 3));
                        double volum=Double.parseDouble((String) jTableBusteni.getValueAt(i, 4));
                        ps.setInt(1, cantitate);
                        ps.setInt(2, lungime);
                        ps.setInt(3, diametru);
                        ps.setDouble(4, volum);
                        ps.setString(5, username);
                        ps.setString(6, fname);
                        try{
                            if(ps.executeUpdate() != 0){
                               ok=1;
                            //JOptionPane.showMessageDialog(null, "Fisier salvat cu succes!");
                            /**LoginForm login = new LoginForm();
                            login.setVisible(true);
                            login.pack();
                            login.setLocationRelativeTo(null);
                            this.dispose();**/
                            }
                            else{
                                //JOptionPane.showMessageDialog(null, "Salvare fisier esuata!");
                                ok=0;
                            }
                        }
                        catch(SQLException ex){
                            ok=0;
                            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
                        }
                    }
                    if(ok==1){
                        while(modelBusteni.getRowCount()>0){
                            for(int i=0 ;i<modelBusteni.getRowCount() ; i++){
                                modelBusteni.removeRow(i);
                            }
                         }
                        jLabelVolumMC.setText("...");
                        jLabelTotal.setText("...");
                        jTextFieldNumeFisier.setText("...");
                        JOptionPane.showMessageDialog(null, "Fisier salvat cu succes!");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Salvare fisier esuata!");
                    }
                    
                    
                    
                }
                catch(SQLException ex){
                     Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
                     }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Salvare fisier esuata!");
            }
            
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Tabelul este GOL!");
        }
            
    }//GEN-LAST:event_jButtonSalvareBusteniActionPerformed

    private void jTextFieldNumeFisierFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeFisierFocusGained
        if(jTextFieldNumeFisier.getText().trim().toLowerCase().equals("..."))
        {
            jTextFieldNumeFisier.setText("");
        }
    }//GEN-LAST:event_jTextFieldNumeFisierFocusGained

    private void jTextFieldNumeFisierFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeFisierFocusLost
        if(jTextFieldNumeFisier.getText().trim().toLowerCase().equals("...") ||
           jTextFieldNumeFisier.getText().trim().toLowerCase().equals(""))
        {
            jTextFieldNumeFisier.setText("...");
        }
    }//GEN-LAST:event_jTextFieldNumeFisierFocusLost

    private void jTextFieldNumeFisierCopaciFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeFisierCopaciFocusGained
        if(jTextFieldNumeFisierCopaci.getText().trim().toLowerCase().equals("..."))
        {
            jTextFieldNumeFisierCopaci.setText("");
        }
    }//GEN-LAST:event_jTextFieldNumeFisierCopaciFocusGained

    private void jTextFieldNumeFisierCopaciFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeFisierCopaciFocusLost
        if(jTextFieldNumeFisierCopaci.getText().trim().toLowerCase().equals("...") ||
           jTextFieldNumeFisierCopaci.getText().trim().toLowerCase().equals(""))
        {
            jTextFieldNumeFisierCopaci.setText("...");
        }
    }//GEN-LAST:event_jTextFieldNumeFisierCopaciFocusLost

    private void jButtonSalvareCopaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvareCopaciActionPerformed
        String username=JlabelActivUser.getText();
        String fname = jTextFieldNumeFisierCopaci.getText();
        if(jTableCopaci.getRowCount()!=0){
        if(VerifyNumeFisierCopaci()){
            if(!CheckNumeFisierCopaci(fname)){
                PreparedStatement p;
                ResultSet rs;
                String registerCopacQuery = "INSERT INTO `copaci`(`cantitate`, `specie`, `inaltime`, `diametrupiept`, `volum`, `username`, `fname`) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
                
                try{
                    
                    p = My_CNX.getConnection().prepareStatement(registerCopacQuery);
                    int ok=1;
                    for(int i=0; i<jTableCopaci.getRowCount() ; i++){
                        
                        int cantitate=Integer.parseInt((String) jTableCopaci.getValueAt(i, 1));
                        String specie= (String)jTableCopaci.getValueAt(i, 2);
                        int inaltime=Integer.parseInt((String) jTableCopaci.getValueAt(i, 3));
                        int diametrupiept=Integer.parseInt((String) jTableCopaci.getValueAt(i, 4));
                        double volum=Double.parseDouble((String) jTableCopaci.getValueAt(i, 5));
                        p.setInt(1, cantitate);
                        p.setString(2, specie);
                        p.setInt(3, inaltime);
                        p.setInt(4, diametrupiept);
                        p.setDouble(5, volum);
                        p.setString(6, username);
                        p.setString(7, fname);
                        try{
                            if(p.executeUpdate() != 0){
                               ok=1;
                            }
                            else{
                                ok=0;
                            }
                        }
                        catch(SQLException ex){
                            ok=0;
                            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
                        }
                    }
                    if(ok==1){
                        while(modelCopaci.getRowCount()>0){
                            for(int i=0 ;i<modelCopaci.getRowCount() ; i++){
                                modelCopaci.removeRow(i);
                            }
                         }
                        jLabelVolumCopac.setText("...");
                        jLabelTotalCopaci.setText("...");
                        jTextFieldNumeFisierCopaci.setText("...");
                        JOptionPane.showMessageDialog(null, "Fisier salvat cu succes!");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Salvare fisier esuata!");
                    }
                    
                    
                    
                }
                catch(SQLException ex){
                     Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
                     }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Salvare fisier esuata!");
            }
            
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Tabelul este GOL!");
        }
    }//GEN-LAST:event_jButtonSalvareCopaciActionPerformed

    private void jButtonStergeFisierBusteniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStergeFisierBusteniActionPerformed
        if(jTableFisiereBusteni.getSelectedRow() != -1){
            int selectedFileIndex = jTableFisiereBusteni.getSelectedRow();
            String fname = (String) jTableFisiereBusteni.getValueAt(selectedFileIndex, 0);
            String username = JlabelActivUser.getText();
            
            PreparedStatement st;
            String query = "DELETE FROM `busteni` WHERE `username`= ? AND `fname`= ?";
            
            try{
                st = My_CNX.getConnection().prepareStatement(query);
        
                st.setString(1, username);
                st.setString(2, fname);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Fisirul >>>"+fname+"<<< a fost sters cu succes!", " ", 2);
                while(modelFisiereBusteni.getRowCount()>0){
                    for(int i=0 ;i<modelFisiereBusteni.getRowCount() ; i++){
                        modelFisiereBusteni.removeRow(i);
                    }
                }
                String username1 = JlabelActivUser.getText();
                PreparedStatement st1;
                ResultSet rs1;
                String query1 = "SELECT DISTINCT fname FROM `busteni` WHERE `username`=?";
        
                try{
                    st1 = My_CNX.getConnection().prepareStatement(query1);
                    st1.setString(1, username1);
                    rs1 = st1.executeQuery();
                    while(rs1.next()){
                        String fname1 = (String)rs1.getString("fname");
                        modelFisiereBusteni.insertRow(modelFisiereBusteni.getRowCount(), new Object[] {fname1});
                    }
                    }
                catch(SQLException ex){
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            catch(SQLException ex){
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE,null,ex);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Selectati un fisier!", " ", 2);
        }
    }//GEN-LAST:event_jButtonStergeFisierBusteniActionPerformed

    private void jButtonModificaFisierBusteniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificaFisierBusteniActionPerformed
        jButtonModificaFisierBusteni.setBackground(new Color(0, 102, 102));
        if(jTableBusteni.getRowCount()==0){
            int ok = 0;
            if(-1 != jTableFisiereBusteni.getSelectedRow()){
                int selectedFileIndex = jTableFisiereBusteni.getSelectedRow();
                String fname = (String) jTableFisiereBusteni.getValueAt(selectedFileIndex, 0);
                String username = JlabelActivUser.getText();

                PreparedStatement st;
                ResultSet rs;
                String query = "SELECT * FROM `busteni` WHERE `username` = ? AND `fname`= ?";

                try{
                    st = My_CNX.getConnection().prepareStatement(query);

                    st.setString(1, username);
                    st.setString(2, fname);
                    rs = st.executeQuery();

                    int nrCrt =1;
                    while(rs.next()){
                        String nrBuc = (String)rs.getString("cantitate");
                        String lungime = (String)rs.getString("lungime");
                        String diametru = (String)rs.getString("diametru");
                        String volum = (String)rs.getString("volum");
                        modelBusteni.insertRow(modelBusteni.getRowCount(), new Object[] {nrCrt,nrBuc,lungime,diametru,volum});
                        nrCrt++;
                        ok=1;
                    }
                    Double total=0.0;
                    for(int i=0 ; i<modelBusteni.getRowCount(); i++){
                        total = total + Double.parseDouble((String) jTableBusteni.getValueAt(i, 4));
                    }

                    DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
                    dfs.setDecimalSeparator('.');
                    DecimalFormat df = new DecimalFormat("0.00", dfs);
                    df.setRoundingMode(RoundingMode.HALF_DOWN);

                    String x = df.format(total);

                    jLabelTotal.setText(String.valueOf(x));
                    jPanelContent.removeAll();
                    jPanelContent.repaint();
                    jPanelContent.revalidate();
                    jPanelContent.add(jPanelCalculatorBusteni);
                    jPanelContent.repaint();
                    jPanelContent.revalidate();
                    jTextFieldNumeFisier.setText(fname);

                }
                catch(SQLException ex){
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE,null,ex);
                }
                if(ok==1)
                  {
                   String query1 = "DELETE FROM `busteni` WHERE `username`=? AND `fname` = ?";
                   try{
                        st = My_CNX.getConnection().prepareStatement(query1);
                        st.setString(1, username);
                        st.setString(2, fname);
                        st.executeUpdate();
                    }
                   catch(SQLException ex){
                        Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE,null,ex);
                   }
                  }
            }
            else{
                JOptionPane.showMessageDialog(null, "Selectati un fisier!", " ", 2);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Înainte de a modifica alt fișier, vă rugăm să salvați fișierul în lucru sau să goliți tabelul!\nÎn cazul golirii tabelului, datele se vor ȘTERGE DEFINITIV! ");
        }

    }//GEN-LAST:event_jButtonModificaFisierBusteniActionPerformed

    private void jButtonModificaFisierCopaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificaFisierCopaciActionPerformed
        jButtonModificaFisierCopaci.setBackground(new Color(0, 102, 102));
        if(jTableCopaci.getRowCount()==0){
            int ok = 0;
            if(-1 != jTableFisiereCopaci.getSelectedRow()){
                int selectedFileIndex = jTableFisiereCopaci.getSelectedRow();
                String fname = (String) jTableFisiereCopaci.getValueAt(selectedFileIndex, 0);
                String username = JlabelActivUser.getText();

                PreparedStatement st;
                ResultSet rs;
                String query = "SELECT * FROM `copaci` WHERE `username` = ? AND `fname`= ?";

                try{
                    st = My_CNX.getConnection().prepareStatement(query);

                    st.setString(1, username);
                    st.setString(2, fname);
                    rs = st.executeQuery();

                    int nrCrt =1;
                    while(rs.next()){
                        String nrBuc = (String)rs.getString("cantitate");
                        String specie = (String)rs.getString("specie");
                        String inaltime = (String)rs.getString("inaltime");
                        String diametrupiept = (String)rs.getString("diametrupiept");
                        String volum = (String)rs.getString("volum");
                        modelCopaci.insertRow(modelCopaci.getRowCount(), new Object[] {nrCrt,nrBuc,specie,inaltime,diametrupiept,volum});
                        ok=1;
                        nrCrt++;
                    }
                    Double total=0.0;
                    for(int i=0 ; i<modelCopaci.getRowCount(); i++){
                        total = total + Double.parseDouble((String) jTableCopaci.getValueAt(i, 5));
                    }

                    DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
                    dfs.setDecimalSeparator('.');
                    DecimalFormat df = new DecimalFormat("0.00", dfs);
                    df.setRoundingMode(RoundingMode.HALF_DOWN);

                    String x = df.format(total);


                    jLabelTotalCopaci.setText(String.valueOf(x));
                    jPanelContent.removeAll();
                    jPanelContent.repaint();
                    jPanelContent.revalidate();
                    jPanelContent.add(jPanelCalculatorCopaci);
                    jPanelContent.repaint();
                    jPanelContent.revalidate();
                    jTextFieldNumeFisierCopaci.setText(fname);

                }
                catch(SQLException ex){
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE,null,ex);
                }
                if(ok==1)
                  {
                   String query1 = "DELETE FROM `copaci` WHERE `username`=? AND `fname` = ?";
                   try{
                        st = My_CNX.getConnection().prepareStatement(query1);
                        st.setString(1, username);
                        st.setString(2, fname);
                        st.executeUpdate();
                    }
                   catch(SQLException ex){
                        Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE,null,ex);
                   }
                  }
            }
            else{
                JOptionPane.showMessageDialog(null, "Selectati un fisier!", " ", 2);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Înainte de a modifica alt fișier, vă rugăm să salvați fișierul în lucru sau să goliți tabelul!\nÎn cazul golirii tabelului, datele se vor ȘTERGE DEFINITIV! ");
        }
    }//GEN-LAST:event_jButtonModificaFisierCopaciActionPerformed

    private void jButtonStergeFisierCopaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStergeFisierCopaciActionPerformed
        if(jTableFisiereCopaci.getSelectedRow() != -1){
            int selectedFileIndex = jTableFisiereCopaci.getSelectedRow();
            String fname = (String) jTableFisiereCopaci.getValueAt(selectedFileIndex, 0);
            String username = JlabelActivUser.getText();
            
            PreparedStatement st;
            String query = "DELETE FROM `copaci` WHERE `username`= ? AND `fname`= ?";
            
            try{
                st = My_CNX.getConnection().prepareStatement(query);
        
                st.setString(1, username);
                st.setString(2, fname);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Fisirul >>>"+fname+"<<< a fost sters cu succes!", " ", 2);
                while(modelFisiereCopaci.getRowCount()>0){
                    for(int i=0 ;i<modelFisiereCopaci.getRowCount() ; i++){
                        modelFisiereCopaci.removeRow(i);
                    }
                }
                String username1 = JlabelActivUser.getText();
                PreparedStatement st1;
                ResultSet rs1;
                String query1 = "SELECT DISTINCT fname FROM `copaci` WHERE `username`=?";
        
                try{
                    st1 = My_CNX.getConnection().prepareStatement(query1);
                    st1.setString(1, username1);
                    rs1 = st1.executeQuery();
                    while(rs1.next()){
                        String fname1 = (String)rs1.getString("fname");
                        modelFisiereCopaci.insertRow(modelFisiereCopaci.getRowCount(), new Object[] {fname1});
                    }
                    }
                catch(SQLException ex){
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            catch(SQLException ex){
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE,null,ex);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Selectati un fisier!", " ", 2);
        }
    }//GEN-LAST:event_jButtonStergeFisierCopaciActionPerformed

    private void jButtonExportaFisierCopaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportaFisierCopaciActionPerformed
        if(jTableFisiereCopaci.getSelectedRow() != -1){  
          
            int selectedFileIndex = jTableFisiereCopaci.getSelectedRow();
            String fname = (String) jTableFisiereCopaci.getValueAt(selectedFileIndex, 0);
            String username = JlabelActivUser.getText();
            String data = (String) jTableFisiereCopaci.getValueAt(selectedFileIndex, 1);
            
            JFileChooser fc = new JFileChooser();
            fc.setSelectedFile(new File(fname+".pdf"));
            fc.showSaveDialog(this);
            File f = fc.getSelectedFile();
           
          try {
              
              GeneratePDFCopaci pdfGenerator = new GeneratePDFCopaci();
              pdfGenerator.generate(f, fname, username, data);
              
          } catch (FileNotFoundException | DocumentException ex) {
              Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
          }
            System.out.println(fname+".pdf file saved to "+f);
      }
      else{
          JOptionPane.showMessageDialog(null, "Selectati un fisier!", " ", 2);
      }
    }//GEN-LAST:event_jButtonExportaFisierCopaciActionPerformed

    private void jButtonExportaFisierBusteniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportaFisierBusteniActionPerformed
      if(jTableFisiereBusteni.getSelectedRow() != -1){  
          
            int selectedFileIndex = jTableFisiereBusteni.getSelectedRow();
            String fname = (String) jTableFisiereBusteni.getValueAt(selectedFileIndex, 0);
            String username = JlabelActivUser.getText();
            String data = (String) jTableFisiereBusteni.getValueAt(selectedFileIndex, 1);
            
            JFileChooser fc = new JFileChooser();
            fc.setSelectedFile(new File(fname+".pdf"));
            fc.showSaveDialog(this);
            File f = fc.getSelectedFile();
           
          try {
              
              GeneratePDFBusteni pdfGenerator = new GeneratePDFBusteni();
              pdfGenerator.generate(f, fname, username, data);
              
          } catch (FileNotFoundException | DocumentException ex) {
              Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
          }
            System.out.println(fname+".pdf file saved to "+f);
      }
      else{
          JOptionPane.showMessageDialog(null, "Selectati un fisier!", " ", 2);
      }
        
        
    }//GEN-LAST:event_jButtonExportaFisierBusteniActionPerformed

    private void jLabelHomeIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeIconMouseEntered
        jLabelHomeIcon.setBackground(new Color(0, 121, 106));
        jLabelHome.setBackground(new Color(0, 121, 106));
    }//GEN-LAST:event_jLabelHomeIconMouseEntered

    private void jLabelHomeIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeIconMouseExited
        jLabelHomeIcon.setBackground(new Color(0, 136, 122));
        jLabelHome.setBackground(new Color(0, 136, 122));
    }//GEN-LAST:event_jLabelHomeIconMouseExited

    private void jButtonCalculeazaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCalculeazaMouseEntered
        jButtonCalculeaza.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonCalculeazaMouseEntered

    private void jButtonCalculeazaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCalculeazaMouseExited
        jButtonCalculeaza.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonCalculeazaMouseExited

    private void jButtonSalvareBusteniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvareBusteniMouseEntered
        jButtonSalvareBusteni.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonSalvareBusteniMouseEntered

    private void jButtonSalvareBusteniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvareBusteniMouseExited
        jButtonSalvareBusteni.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonSalvareBusteniMouseExited

    private void jButtonStergeBusteanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergeBusteanMouseEntered
        jButtonStergeBustean.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonStergeBusteanMouseEntered

    private void jButtonStergeBusteanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergeBusteanMouseExited
        jButtonStergeBustean.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonStergeBusteanMouseExited

    private void jButtonStergreTotalaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergreTotalaMouseEntered
        jButtonStergreTotala.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonStergreTotalaMouseEntered

    private void jButtonStergreTotalaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergreTotalaMouseExited
        jButtonStergreTotala.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonStergreTotalaMouseExited

    private void jButtonCalculeazaCopacMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCalculeazaCopacMouseEntered
        jButtonCalculeazaCopac.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonCalculeazaCopacMouseEntered

    private void jButtonCalculeazaCopacMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCalculeazaCopacMouseExited
        jButtonCalculeazaCopac.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonCalculeazaCopacMouseExited

    private void jButtonSalvareCopaciMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvareCopaciMouseEntered
        jButtonSalvareCopaci.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonSalvareCopaciMouseEntered

    private void jButtonSalvareCopaciMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvareCopaciMouseExited
        jButtonSalvareCopaci.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonSalvareCopaciMouseExited

    private void jButtonStergeCopacMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergeCopacMouseEntered
        jButtonStergeCopac.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonStergeCopacMouseEntered

    private void jButtonStergeCopacMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergeCopacMouseExited
        jButtonStergeCopac.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonStergeCopacMouseExited

    private void jButtonStergreTotalaCopaciMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergreTotalaCopaciMouseEntered
        jButtonStergreTotalaCopaci.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonStergreTotalaCopaciMouseEntered

    private void jButtonStergreTotalaCopaciMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergreTotalaCopaciMouseExited
        jButtonStergreTotalaCopaci.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonStergreTotalaCopaciMouseExited

    private void jButtonCalculeazaGreutateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCalculeazaGreutateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCalculeazaGreutateMouseClicked

    private void jButtonCalculeazaGreutateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCalculeazaGreutateMouseEntered
        jButtonCalculeazaGreutate.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonCalculeazaGreutateMouseEntered

    private void jButtonCalculeazaGreutateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCalculeazaGreutateMouseExited
        jButtonCalculeazaGreutate.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonCalculeazaGreutateMouseExited

    private void jButtonCalculeazaVolumMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCalculeazaVolumMouseEntered
        jButtonCalculeazaVolum.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonCalculeazaVolumMouseEntered

    private void jButtonCalculeazaVolumMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCalculeazaVolumMouseExited
        jButtonCalculeazaVolum.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonCalculeazaVolumMouseExited

    private void jButtonModificaFisierBusteniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificaFisierBusteniMouseEntered
        jButtonModificaFisierBusteni.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonModificaFisierBusteniMouseEntered

    private void jButtonModificaFisierBusteniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificaFisierBusteniMouseExited
        jButtonModificaFisierBusteni.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonModificaFisierBusteniMouseExited

    private void jButtonStergeFisierBusteniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergeFisierBusteniMouseEntered
        jButtonStergeFisierBusteni.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonStergeFisierBusteniMouseEntered

    private void jButtonStergeFisierBusteniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergeFisierBusteniMouseExited
        jButtonStergeFisierBusteni.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonStergeFisierBusteniMouseExited

    private void jButtonExportaFisierBusteniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExportaFisierBusteniMouseEntered
        jButtonExportaFisierBusteni.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonExportaFisierBusteniMouseEntered

    private void jButtonExportaFisierBusteniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExportaFisierBusteniMouseExited
        jButtonExportaFisierBusteni.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonExportaFisierBusteniMouseExited

    private void jButtonModificaFisierBusteniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificaFisierBusteniMouseClicked
        jButtonModificaFisierBusteni.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonModificaFisierBusteniMouseClicked

    private void jButtonModificaFisierCopaciMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificaFisierCopaciMouseEntered
        jButtonModificaFisierCopaci.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonModificaFisierCopaciMouseEntered

    private void jButtonModificaFisierCopaciMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificaFisierCopaciMouseExited
        jButtonModificaFisierCopaci.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonModificaFisierCopaciMouseExited

    private void jButtonStergeFisierCopaciMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergeFisierCopaciMouseEntered
        jButtonStergeFisierCopaci.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonStergeFisierCopaciMouseEntered

    private void jButtonStergeFisierCopaciMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStergeFisierCopaciMouseExited
        jButtonStergeFisierCopaci.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonStergeFisierCopaciMouseExited

    private void jButtonExportaFisierCopaciMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExportaFisierCopaciMouseEntered
        jButtonExportaFisierCopaci.setBackground(new Color(254, 250, 224));
    }//GEN-LAST:event_jButtonExportaFisierCopaciMouseEntered

    private void jButtonExportaFisierCopaciMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExportaFisierCopaciMouseExited
        jButtonExportaFisierCopaci.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_jButtonExportaFisierCopaciMouseExited
    
    public boolean VerifyFields()
    {
        String diametru = jTextFieldDiametru.getText();
        String lungime = jTextFieldLungime.getText();
        String cantitate = jTextFieldCantitate.getText();
       
        if(diametru.trim().equals("...") || lungime.trim().equals("...") || cantitate.trim().equals("...")){
            JOptionPane.showMessageDialog(null, "One ore more fields are empty!","Empty Fields",2);
            return false;
        }
        else
             return true;
 
    }
    public boolean VerifyFieldsCopaci()
    {
        String diametruPiept = jTextFieldDiametruPiept.getText();
        String inaltime = jTextFieldInaltime.getText();
        String cantitateCopaci = jTextFieldCantitateCopaci.getText();
       
        if(diametruPiept.trim().equals("...") || inaltime.trim().equals("...") || cantitateCopaci.trim().equals("...")){
            JOptionPane.showMessageDialog(null, "One ore more fields are empty!","Empty Fields",2);
            return false;
        }
        else
             return true;
 
    }
    public boolean VerifyFieldsVolumGreutate()
    {
        String volum = jTextFieldVolumInput.getText();
        if(volum.trim().equals("...")){
            JOptionPane.showMessageDialog(null, "One ore more fields are empty!","Empty Fields",2);
            return false;
        }
        else
             return true;
 
    }
    
    public boolean VerifyFieldsGreutateVolum()
    {
        String greutate = jTextFieldGeutateInput.getText();
        if(greutate.trim().equals("...")){
            JOptionPane.showMessageDialog(null, "One ore more fields are empty!","Empty Fields",2);
            return false;
        }
        else
             return true;
 
    }
    
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
            java.util.logging.Logger.getLogger(Meniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Meniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Meniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Meniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Meniu().setVisible(true);
        });
    }
    public boolean VerifyNumeFisierBusteni()
    {
        String fname = jTextFieldNumeFisier.getText();
        if(fname.trim().equals("")||fname.trim().equals("...")){
            JOptionPane.showMessageDialog(null, "Nume Fisier Necompletat!","Empty Field",2);
            return false;
        }
        else
            return true;
    }
    
    public boolean CheckNumeFisierBusteni(String fname){
        String username = JlabelActivUser.getText();
        PreparedStatement st;
        ResultSet rs;
        boolean numeFisierBusteni_exist = false;
        String query = "SELECT * FROM `busteni` WHERE `fname` = ? AND `username` = ? ";
        
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, fname);
            st.setString(2, username);
            rs = st.executeQuery();
            
            if(rs.next()){
                numeFisierBusteni_exist = true;
                JOptionPane.showMessageDialog(null, " Nume Fisier Existent!, Alegeti alt nume!", "Faild!", 2);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
        }
                
        return numeFisierBusteni_exist;
        
    }
    public boolean VerifyNumeFisierCopaci()
    {
        String fname = jTextFieldNumeFisierCopaci.getText();
        if(fname.trim().equals("")||fname.trim().equals("...")){
            JOptionPane.showMessageDialog(null, "Nume Fisier Necompletat!","Empty Field",2);
            return false;
        }
        else
            return true;
    }
    
    public boolean CheckNumeFisierCopaci(String fname){
        String username = JlabelActivUser.getText();
        PreparedStatement st;
        ResultSet rs;
        boolean numeFisierCopaci_exist = false;
        String query = "SELECT * FROM `copaci` WHERE `fname` = ? AND `username` = ? ";
        
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, fname);
            st.setString(2, username);
            rs = st.executeQuery();
            
            
            if(rs.next()){
                numeFisierCopaci_exist = true;
                JOptionPane.showMessageDialog(null, " Nume Fisier Existent!, Alegeti alt nume!", "Faild!", 2);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE,null,ex);
        }
                
        return numeFisierCopaci_exist;
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlabelActivUser;
    private javax.swing.JButton jButtonCalculeaza;
    private javax.swing.JButton jButtonCalculeazaCopac;
    private javax.swing.JButton jButtonCalculeazaGreutate;
    private javax.swing.JButton jButtonCalculeazaVolum;
    private javax.swing.JButton jButtonExportaFisierBusteni;
    private javax.swing.JButton jButtonExportaFisierCopaci;
    private javax.swing.JButton jButtonModificaFisierBusteni;
    private javax.swing.JButton jButtonModificaFisierCopaci;
    private javax.swing.JButton jButtonSalvareBusteni;
    private javax.swing.JButton jButtonSalvareCopaci;
    private javax.swing.JButton jButtonStergeBustean;
    private javax.swing.JButton jButtonStergeCopac;
    private javax.swing.JButton jButtonStergeFisierBusteni;
    private javax.swing.JButton jButtonStergeFisierCopaci;
    private javax.swing.JButton jButtonStergreTotala;
    private javax.swing.JButton jButtonStergreTotalaCopaci;
    private javax.swing.JComboBox<String> jComboBoxSpecie;
    private javax.swing.JComboBox<String> jComboBoxSpecieGreutateVolum;
    private javax.swing.JComboBox<String> jComboBoxSpecieVolumGreutate;
    private javax.swing.JLabel jLabeInaltime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBuc;
    private javax.swing.JLabel jLabelBuc1;
    private javax.swing.JLabel jLabelBustean;
    private javax.swing.JLabel jLabelBusteanCalculator;
    private javax.swing.JLabel jLabelBusteanIcon;
    private javax.swing.JLabel jLabelBusteni115;
    private javax.swing.JLabel jLabelBusteniBack;
    private javax.swing.JLabel jLabelBusteniCalculator;
    private javax.swing.JLabel jLabelCM;
    private javax.swing.JLabel jLabelCM1;
    private javax.swing.JLabel jLabelCantitate;
    private javax.swing.JLabel jLabelCantitateCopaci;
    private javax.swing.JLabel jLabelCopac;
    private javax.swing.JLabel jLabelCopac115;
    private javax.swing.JLabel jLabelCopacIcon;
    private javax.swing.JLabel jLabelCopaciCalculator;
    private javax.swing.JLabel jLabelCopaciCalculatorIcon;
    private javax.swing.JLabel jLabelDiametru;
    private javax.swing.JLabel jLabelDiametruPiept;
    private javax.swing.JLabel jLabelDisplaySalvariBack;
    private javax.swing.JLabel jLabelDisplaySalvariBusteniBack;
    private javax.swing.JLabel jLabelDisplaySalvariCopaciBack;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelGreutate;
    private javax.swing.JLabel jLabelGreutate1;
    private javax.swing.JLabel jLabelGreutateVolum;
    private javax.swing.JLabel jLabelGreutateVolum115;
    private javax.swing.JLabel jLabelGreutateVolumBack;
    private javax.swing.JLabel jLabelGreutateVolumIcon;
    private javax.swing.JLabel jLabelGreutateVolumIcon2;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelHomeIcon;
    private javax.swing.JLabel jLabelLungime;
    private javax.swing.JLabel jLabelM;
    private javax.swing.JLabel jLabelM1;
    private javax.swing.JLabel jLabelMC;
    private javax.swing.JLabel jLabelMC1;
    private javax.swing.JLabel jLabelNumeFisier;
    private javax.swing.JLabel jLabelSalvari;
    private javax.swing.JLabel jLabelSalvariBusteni;
    private javax.swing.JLabel jLabelSalvariBusteniIcon;
    private javax.swing.JLabel jLabelSalvariBusteniIcon1;
    private javax.swing.JLabel jLabelSalvariBusteniIcon2;
    private javax.swing.JLabel jLabelSalvariCopaci;
    private javax.swing.JLabel jLabelSalvariCopaciIcon;
    private javax.swing.JLabel jLabelSalvariCopaciIcon1;
    private javax.swing.JLabel jLabelSalvariCopaciIcon2;
    private javax.swing.JLabel jLabelSalvariIcon;
    private javax.swing.JLabel jLabelSpecie;
    private javax.swing.JLabel jLabelSpecie3;
    private javax.swing.JLabel jLabelSpecie4;
    private javax.swing.JLabel jLabelSpecieVolumGreutate;
    private javax.swing.JLabel jLabelSpecieVolumGreutate1;
    private javax.swing.JLabel jLabelTone;
    private javax.swing.JLabel jLabelTone1;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotalCopaci;
    private javax.swing.JLabel jLabelTotalMC;
    private javax.swing.JLabel jLabelTotalMC1;
    private javax.swing.JLabel jLabelVolum;
    private javax.swing.JLabel jLabelVolum1;
    private javax.swing.JLabel jLabelVolum2;
    private javax.swing.JLabel jLabelVolum3;
    private javax.swing.JLabel jLabelVolum5;
    private javax.swing.JLabel jLabelVolumCopac;
    private javax.swing.JLabel jLabelVolumCopaciBack;
    private javax.swing.JLabel jLabelVolumGreutate;
    private javax.swing.JLabel jLabelVolumGreutate1;
    private javax.swing.JLabel jLabelVolumGreutate115;
    private javax.swing.JLabel jLabelVolumGreutate3;
    private javax.swing.JLabel jLabelVolumGreutate4;
    private javax.swing.JLabel jLabelVolumGreutateBack;
    private javax.swing.JLabel jLabelVolumGreutateIcon;
    private javax.swing.JLabel jLabelVolumGreutateIcon1;
    private javax.swing.JLabel jLabelVolumMC;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_minimize;
    private javax.swing.JPanel jPanelAllCalculators;
    private javax.swing.JPanel jPanelBusteni;
    private javax.swing.JPanel jPanelCalculatorBusteni;
    private javax.swing.JPanel jPanelCalculatorCopaci;
    private javax.swing.JPanel jPanelCalculatorGreutateVolum;
    private javax.swing.JPanel jPanelCalculatorVolumGreutate;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelCopac;
    private javax.swing.JPanel jPanelDisplaySalvari;
    private javax.swing.JPanel jPanelDisplaySalvariBusteni;
    private javax.swing.JPanel jPanelDisplaySalvariCopaci;
    private javax.swing.JPanel jPanelGreutateVolum;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelManiu;
    private javax.swing.JPanel jPanelSalvariBusteni1;
    private javax.swing.JPanel jPanelSalvariBusteni2;
    private javax.swing.JPanel jPanelSalvariCopaci1;
    private javax.swing.JPanel jPanelSalvariCopaci2;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPanel jPanelVolumGreutate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableBusteni;
    private javax.swing.JTable jTableCopaci;
    private javax.swing.JTable jTableFisiereBusteni;
    private javax.swing.JTable jTableFisiereCopaci;
    private javax.swing.JTextField jTextFieldCantitate;
    private javax.swing.JTextField jTextFieldCantitateCopaci;
    private javax.swing.JTextField jTextFieldDiametru;
    private javax.swing.JTextField jTextFieldDiametruPiept;
    private javax.swing.JTextField jTextFieldGeutateInput;
    private javax.swing.JTextField jTextFieldInaltime;
    private javax.swing.JTextField jTextFieldLungime;
    private javax.swing.JTextField jTextFieldNumeFisier;
    private javax.swing.JTextField jTextFieldNumeFisierCopaci;
    private javax.swing.JTextField jTextFieldVolumInput;
    // End of variables declaration//GEN-END:variables
}
