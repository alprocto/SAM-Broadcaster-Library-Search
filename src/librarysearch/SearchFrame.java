/*
 * Copyright (C) 2015 alprocto
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package librarysearch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author alprocto
 */
public class SearchFrame extends javax.swing.JFrame {

    Songs songSearchResults;

    DefaultListModel searchSimpleResultListModel = new DefaultListModel();

    /**
     * Creates new form NewJFrame
     */
    public SearchFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search = new javax.swing.JTabbedPane();
        searchSimple = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchSimpleTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        searchSimpleArtist = new javax.swing.JTextField();
        searchSimpleSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchSimpleResults = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Title");

        jLabel2.setText("Artist");

        searchSimpleArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSimpleArtistActionPerformed(evt);
            }
        });

        searchSimpleSearch.setText("Search");
        searchSimpleSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSimpleSearchActionPerformed(evt);
            }
        });

        searchSimpleResults.setModel(searchSimpleResultListModel);
        jScrollPane2.setViewportView(searchSimpleResults);

        jLabel4.setText("Duration   Artist - Title");

        javax.swing.GroupLayout searchSimpleLayout = new javax.swing.GroupLayout(searchSimple);
        searchSimple.setLayout(searchSimpleLayout);
        searchSimpleLayout.setHorizontalGroup(
            searchSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchSimpleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(searchSimpleLayout.createSequentialGroup()
                        .addGroup(searchSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(searchSimpleArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchSimpleLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(searchSimpleLayout.createSequentialGroup()
                                .addComponent(searchSimpleTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchSimpleSearch))))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        searchSimpleLayout.setVerticalGroup(
            searchSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchSimpleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchSimpleTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchSimpleArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchSimpleSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        search.addTab("Simple Search", searchSimple);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchSimpleSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSimpleSearchActionPerformed
        songSearchResults = new Songs();
        ResultSet rs = null;
        if (!searchSimpleArtist.getText().equals("") && !searchSimpleTitle.getText().equals("")) {
            String statement = "SELECT * FROM `songlist` WHERE `artist` LIKE '%" + searchSimpleArtist.getText() + "%' && `title` LIKE '%" + searchSimpleTitle.getText() + "%' ORDER BY `title`";
            rs = Functions.sqlSelect(statement);
        } else if (!searchSimpleArtist.getText().equals("")) {
            String statement = "SELECT * FROM `songlist` WHERE `artist` LIKE '%" + searchSimpleArtist.getText() + "%' ORDER BY `title`";
            rs = Functions.sqlSelect(statement);
        } else if (!searchSimpleTitle.getText().equals("")) {
            String statement = "SELECT * FROM `songlist` WHERE `title` LIKE '%" + searchSimpleTitle.getText() + "%' ORDER BY `title`";
            rs = Functions.sqlSelect(statement);
        }
        if (rs != null) {
            try {
                while (rs.next()) {
                    songSearchResults.addSong(rs.getInt("ID"), rs.getString("artist"), rs.getString("title"), rs.getInt("duration"));
                }
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(SearchFrame.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
            Functions.sqlCloseResultSet(rs);
        }

        searchSimpleResultListModel.clear();

        for (int i = 0; i < songSearchResults.getLenght(); i++) {
            if (songSearchResults.getArtist(i).equals("")) {
                searchSimpleResultListModel.addElement(String.format("%1$8s", songSearchResults.getDurationString(i)) + "   " + songSearchResults.getTitle(i));
            } else {
                searchSimpleResultListModel.addElement(String.format("%1$9s", songSearchResults.getDurationString(i)) + "   "  + songSearchResults.getArtist(i) + " - " + songSearchResults.getTitle(i));
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_searchSimpleSearchActionPerformed

    private void searchSimpleArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSimpleArtistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchSimpleArtistActionPerformed

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
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane search;
    private javax.swing.JPanel searchSimple;
    private javax.swing.JTextField searchSimpleArtist;
    private javax.swing.JList searchSimpleResults;
    private javax.swing.JButton searchSimpleSearch;
    private javax.swing.JTextField searchSimpleTitle;
    // End of variables declaration//GEN-END:variables
}
