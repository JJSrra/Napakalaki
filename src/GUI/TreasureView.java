/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Treasure;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author diego
 */
public class TreasureView extends javax.swing.JPanel {

	private Treasure treasureModel;
	private boolean selected;
	
	/**
	 * Creates new form TreasureView
	 */
	public TreasureView() {
		initComponents();
		
		selected = false;
		setOpaque(false);
		this.setBackground(java.awt.Color.LIGHT_GRAY);
	}
	
	public boolean isSelected(){
		return selected;
	}
	
	public Treasure getTreasure(){
		return treasureModel;
	}
	
	public void setTreasure(Treasure treasure){
		treasureModel = treasure;
		
		// Actualizar la imagen
		treasureImage.setIcon(new ImageIcon(this.getClass().getResource("/Resources/Treasures/" + treasureModel.getName() + ".jpg")));
		
		// Actualizar labels
		treasureNameLabel.setText(treasureModel.getName());
		treasureKindLabel.setText(treasureModel.getType().toString());
		treasureBonusLabel.setText("+" + Integer.toString(treasureModel.getBonus()));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treasureImagePanel = new javax.swing.JPanel();
        treasureImage = new javax.swing.JLabel();
        treasureNameLabel = new javax.swing.JLabel();
        treasureKindLabel = new javax.swing.JLabel();
        treasureBonusLabel = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout treasureImagePanelLayout = new javax.swing.GroupLayout(treasureImagePanel);
        treasureImagePanel.setLayout(treasureImagePanelLayout);
        treasureImagePanelLayout.setHorizontalGroup(
            treasureImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(treasureImage)
        );
        treasureImagePanelLayout.setVerticalGroup(
            treasureImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(treasureImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        treasureNameLabel.setText("Nombre");

        treasureKindLabel.setText("Tipo");

        treasureBonusLabel.setText("Bonus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(treasureImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(treasureBonusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(treasureKindLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(treasureNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(treasureNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(treasureKindLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(treasureBonusLabel)
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addComponent(treasureImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        selected = !selected;
		setOpaque(selected);
		repaint();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel treasureBonusLabel;
    private javax.swing.JLabel treasureImage;
    private javax.swing.JPanel treasureImagePanel;
    private javax.swing.JLabel treasureKindLabel;
    private javax.swing.JLabel treasureNameLabel;
    // End of variables declaration//GEN-END:variables
}
