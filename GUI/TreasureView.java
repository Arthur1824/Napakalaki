/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Treasure;

/**
 *
 * @author Arthur18
 */
public class TreasureView extends javax.swing.JPanel {
    
    private Treasure treasureModel;
    private boolean selected;
    
    
    public void setTreasure(Treasure t){
        
        treasureModel=t;
        this.treasureName.setText(treasureModel.getName());
        this.type.setText(treasureModel.getType().toString());
        this.bonus.setText(Integer.toString(treasureModel.getBonus()));
        
        repaint();
        
    }
    
    public boolean isSelected(){
       
        return selected;
    }
    
    public Treasure getTreasure(){
        
        return treasureModel;
    }

    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        this.selected = false;
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

        treasureName = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        bonus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        treasureName.setText("TreasureName");
        add(treasureName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 25));

        type.setText("Type");
        add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 90, 10));

        bonus.setText("Bonus");
        add(bonus, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 60, 10));

        jLabel1.setText("Tipo -> ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 10));

        jLabel2.setText("Bonus -> ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        if(selected==true){
            
            setBackground(new java.awt.Color(240, 240, 240));
            selected=false;
        }
        
        else{
            
            setBackground(new java.awt.Color(255, 0, 0));
            selected=true;
        }
        repaint();
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bonus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel treasureName;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}
