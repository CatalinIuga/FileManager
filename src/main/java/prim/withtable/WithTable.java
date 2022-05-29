package prim.withtable;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WithTable extends javax.swing.JFrame {
//     Actiuni posibile:
// -	Crearea de fisiere/directoare
// -	Stergerea de fisier/directoare
// -	Redenumirea de fisiere (sau directoare daca acestea nu contin fisiere)
// -	Vizualizare si modificarea de continut pentru fisiere de tip text
// -	Vizualizare de imagini


    static String dir_c; // director curent
    static String[] files; // fisierele din directorul curent
    File selected_file;
    model tabel; // tabel fisiere

    public WithTable() {
        initComponents();
        dir_c = System.getProperty("user.dir"); // directorul curent
        change_directory(); // functie care creeaza tabelul cu datele din directorul curenttabel = new model();
        jTable1.setModel(tabel);
        jTable1.setAutoCreateRowSorter(true);
    }

    // puteam folosi ArrayList nu stiu de ce m-am complicat
    // adauga un fisier nou la lista de fisiere
    public String[] add_new_file(int n, String[] s, String x) {
        String new_arr[] = new String[n + 1];
        System.arraycopy(s, 0, new_arr, 0, n);
        new_arr[n] = x;
        return new_arr;
    }

    private void change_directory() {
        if (dir_c != null) {
            File f = new File(dir_c);
            files = f.list(); // toate fisierele din directorul curent
        } else if (dir_c == null) { // caz in care am ajuns la directorul cu partitii
            files = new String[0];
            FileSystem fileSystem = FileSystems.getDefault();
            Iterable<Path> dirs = fileSystem.getRootDirectories(); // returneaza lista cu partitiile din sistemul curent de fisiere
            for (Path name : dirs) {
                files = add_new_file(files.length, files, name.toString()); // punem partitiile gasite in files
            }
        }
        tabel = new model(); // refacem tabelul 
        jTable1.setModel(tabel);
        jTable1.setAutoCreateRowSorter(true);
        textfield.setText(dir_c); // zona in care afisam directorul curent
        tabel.fireTableRowsInserted(files.length - 1, files.length - 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jFrame2 = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        textfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        nume_nou_fisier = new javax.swing.JTextField();
        fisier_nou = new javax.swing.JButton();
        rename_fisier = new javax.swing.JButton();
        nume_folder_nou = new javax.swing.JTextField();
        nume_fisier_nou = new javax.swing.JTextField();
        sterge = new javax.swing.JButton();
        inapoi = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        deschide = new javax.swing.JButton();
        folder_nou = new javax.swing.JButton();

        jFrame1.setMinimumSize(new java.awt.Dimension(500, 400));
        jFrame1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jFrame1WindowClosed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton8.setText("Save");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Cancel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addContainerGap())
        );

        jFrame2.setTitle("Imaginea selectata");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textfield.setEditable(false);
        textfield.setText("C:");
        textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Curent Directory");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Size", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nume_nou_fisier.setText("new Name");

        fisier_nou.setText("new file");
        fisier_nou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        rename_fisier.setText("rename");
        rename_fisier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        nume_folder_nou.setText("new Folder");
        nume_folder_nou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nume_folder_nouActionPerformed(evt);
            }
        });

        nume_fisier_nou.setText("new File");
        nume_fisier_nou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        sterge.setText("delete");
        sterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        inapoi.setText("Back");
        inapoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        inapoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        deschide.setText("open");
        deschide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        folder_nou.setText("new folder");
        folder_nou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fisier_nou, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(folder_nou, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(rename_fisier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nume_folder_nou)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(nume_nou_fisier)
                        .addGap(1, 1, 1))
                    .addComponent(nume_fisier_nou)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(deschide, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inapoi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(sterge, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inapoi)
                    .addComponent(refresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deschide)
                    .addComponent(sterge))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rename_fisier)
                    .addComponent(nume_nou_fisier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(folder_nou)
                    .addComponent(nume_folder_nou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nume_fisier_nou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fisier_nou))
                .addContainerGap(237, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // sterge un director
    public void remove_dir(File s) {
        File[] lol = s.listFiles();
        if (lol != null) {
            for (File f : lol) {
                remove_dir(f);
            }
        }
        if (!s.delete()) {
            System.out.println("Not deleted " + s);
        }
    }

    // verifica daca un fisier este o imagine
    public boolean image_check(File a) throws IOException {
        BufferedImage buf = ImageIO.read(a);
        if (buf != null) {
            return true;
        } else {
            return false;
        }
    }

    // buton de salvare a fisierului care a fost editat
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String s = jTextArea1.getText();
        try {
            FileWriter f = new FileWriter(selected_file);
            f.write(s);
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(WithTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    // deselecteaza fisierul ales cand inchidem fereastra de editare text
    private void jFrame1WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jFrame1WindowClosed
        // TODO add your handling code here:
        selected_file = null;
    }//GEN-LAST:event_jFrame1WindowClosed

    // butonul de cancel, inchide fereastra de editare a unui fisier
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        jFrame1.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    // dublu click pe un element din tabel, aceleasi functionalizati ca si butonul de open
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            int row = jTable1.getSelectedRow();
            if (dir_c != null) {
                try {
                    File aux = new File(dir_c + "\\" + jTable1.getValueAt(row, 0));
                    if (aux.isDirectory()) {
                        dir_c = aux.getAbsolutePath();
                        change_directory();
                    } else if (image_check(aux)) {
                        BufferedImage buf = ImageIO.read(aux);
                        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                        Image img = buf.getScaledInstance(screenSize.width - 25, screenSize.height - 100, Image.SCALE_SMOOTH);
                        jFrame2.pack();
                        jFrame2.setVisible(true);

                    } else {
                        selected_file = aux;
                        jTextArea1.removeAll();
                        try {
                            jTextArea1.read(new BufferedReader(new FileReader(aux)), null);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(WithTable.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(WithTable.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jTextArea1.validate();
                        jFrame1.setPreferredSize(new Dimension(500, 1000));
                        jFrame1.setVisible(true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(WithTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                dir_c = (String) jTable1.getValueAt(row, 0) + "\\";
                change_directory();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    // creaza un nou folder
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (dir_c != null) {
            String s = nume_folder_nou.getText();
            File f = new File(dir_c + "\\" + s);
            if (!f.exists()) {
                System.out.println("Created " + s);
                f.mkdir();
                change_directory();
            } else {
                System.out.println("!Created " + s);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // butonul de open, la director mergem in directorul respectiv, fiser/imagine deschidem o noua 
    // freastra pentru vizualizarea continutului sau editarea textului(pentru fisiere tip text)
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if (dir_c != null) {
            File aux = new File(dir_c + "\\" + jTable1.getValueAt(row, 0));
            if (aux.isDirectory()) {
                dir_c = aux.getAbsolutePath();
                change_directory();
            } else try {
                if (image_check(aux)) {
                    BufferedImage buf = ImageIO.read(aux);
                    Image img = buf.getScaledInstance(720,480, Image.SCALE_SMOOTH);
                    jFrame2.add(new JLabel(new ImageIcon(img)));
                    jFrame2.repaint();
                    jFrame2.pack();
                    jFrame2.setVisible(true);
                } else {
                    selected_file = aux;
                    jTextArea1.removeAll();
                    jTextArea1.read(new BufferedReader(new FileReader(aux)), null);
                    jTextArea1.validate();
                    jFrame1.setVisible(true);
                }
            } catch (IOException ex) {
                Logger.getLogger(WithTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dir_c = (String) jTable1.getValueAt(row, 0) + "\\";
            change_directory();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    // refresh
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        change_directory();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // butonul de inapoi
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (dir_c != null) {
            dir_c = new File(dir_c).getParent();
            change_directory();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    // sterge fisier sau director
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            File aux = new File(dir_c + "\\" + jTable1.getValueAt(row, 0));
            if (aux.isDirectory()) {
                remove_dir(aux);
                if (aux.exists()) {
                    System.out.println("!Deleted folder " + aux);
                } else {
                    System.out.println("Deleted folder " + aux);
                }
            } else {
                if (aux.delete()) {
                    System.out.println("Deleted file " + jTable1.getValueAt(row, 0));
                } else {
                    System.out.println("Could not delete " + jTable1.getValueAt(row, 0));
                }

            }
        }
        change_directory();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    // redenumeste un fisier
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String s = nume_nou_fisier.getText();
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            File old = new File(dir_c + "\\" + jTable1.getValueAt(row, 0));
            File newf = new File(dir_c + "\\" + s);
            if (old.renameTo(newf)) {
                System.out.println("Renamed " + s);
            } else {
                System.out.println("!Renamed " + s);
            }
            change_directory();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    // creare fisier nou
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (dir_c != null) {
            String s = nume_fisier_nou.getText();
            File f = new File(dir_c + "\\" + s);
            if (!f.exists()) {
                try {
                    f.createNewFile();
                    System.out.println("Created " + s);

                } catch (IOException ex) {
                    Logger.getLogger(WithTable.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                change_directory();
            } else {
                System.out.println("!Created " + s);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldActionPerformed

    private void nume_folder_nouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nume_folder_nouActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nume_folder_nouActionPerformed

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
            java.util.logging.Logger.getLogger(WithTable.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WithTable.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WithTable.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WithTable.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new WithTable().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deschide;
    private javax.swing.JButton fisier_nou;
    private javax.swing.JButton folder_nou;
    private javax.swing.JButton inapoi;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nume_fisier_nou;
    private javax.swing.JTextField nume_folder_nou;
    private javax.swing.JTextField nume_nou_fisier;
    private javax.swing.JButton refresh;
    private javax.swing.JButton rename_fisier;
    private javax.swing.JButton sterge;
    private javax.swing.JTextField textfield;
    // End of variables declaration//GEN-END:variables
}
