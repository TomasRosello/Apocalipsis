/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apocalipsis;

/**
 *
 * @author tomas
 */
public class Documento extends javax.swing.JFrame {

    int ser = 0, id = 0;
    Apocalipsis a;
    Integer d, v, c;
    /**
     * Creates new form Documento
     */
    public Documento(Apocalipsis a) {
        this.a = a;
        d = a.getHumanos().get(0).getDiaNacimiento();
        v = a.getHumanos().get(0).getVelocidad();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("HUMANO");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("1/" + a.getHumanos().size());

        jLabel3.setText("Dia de nacimiento:");

        jLabel4.setText("Velocidad:");

        jLabel5.setText(d.toString());

        jLabel6.setText(v.toString());
        jLabel6.setToolTipText("");

        jButton1.setText("<<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(">>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(">");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("<\n");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addComponent(jLabel1))
                        .addGap(12, 12, 12)))
                .addComponent(jButton2)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(ser > 0)
            ser--;
        else{
            ser = 3;
        }
        menus();
        id = 0;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(ser < 3)
            ser++;
        else{
            ser = 0;
        }
        menus();
        id = 0;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Integer idt = id+1;
        switch(ser){
            case 0: if(id == a.getHumanos().size()-1)
                        id = 0;
                    else{
                        id++;
                    }
                    d = a.getHumanos().get(id).getDiaNacimiento();
                    v = a.getHumanos().get(id).getVelocidad();
                    jLabel2.setText(idt.toString() + "/" + a.getHumanos().size());
                    jLabel5.setText(d.toString());
                    jLabel6.setText(v.toString());
                    break;
            case 1: if(id == a.getCV().size()-1)
                        id = 0;
                    else{
                        id++;
                    }
                    d = a.getCV().get(id).getDiaNacimiento();
                    v = a.getCV().get(id).getVelocidad();
                    c = a.getCV().get(id).getVampirosmatados();
                    jLabel2.setText(idt.toString() + "/" + a.getCV().size());
                    jLabel5.setText(d.toString());
                    jLabel6.setText(v.toString());
                    jLabel8.setText(c.toString());
                    break;
            case 2: if(id == a.getVampiros().size()-1)
                        id = 0;
                    else{
                        id++;
                    }
                    d = a.getVampiros().get(id).getDiaNacimiento();
                    v = a.getVampiros().get(id).getDraculizados();
                    jLabel2.setText(idt.toString() + "/" + a.getVampiros().size());
                    jLabel5.setText(d.toString());
                    jLabel6.setText(v.toString());
                    break;
            case 3: if(id == a.getZombies().size()-1)
                        id = 0;
                    else{
                        id++;
                    }
                    d = a.getZombies().get(id).getDiaNacimiento();
                    v = a.getZombies().get(id).getZombieficados();
                    jLabel2.setText(idt.toString() + "/" + a.getZombies().size());
                    jLabel5.setText(d.toString());
                    jLabel6.setText(v.toString());
                    break;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Integer idt = id+1;
        switch(ser){
            case 0: if(id == 0)
                        id = a.getHumanos().size()-1;
                    else{
                        id--;
                    }
                    d = a.getHumanos().get(id).getDiaNacimiento();
                    v = a.getHumanos().get(id).getVelocidad();
                    jLabel2.setText(idt.toString() + "/" + a.getHumanos().size());
                    jLabel5.setText(d.toString());
                    jLabel6.setText(v.toString());
                    break;
            case 1: if(id == 0)
                        id = a.getCV().size()-1;
                    else{
                        id--;
                    }
                    d = a.getCV().get(id).getDiaNacimiento();
                    v = a.getCV().get(id).getVelocidad();
                    c = a.getCV().get(id).getVampirosmatados();
                    jLabel2.setText(idt.toString() + "/" + a.getCV().size());
                    jLabel5.setText(d.toString());
                    jLabel6.setText(v.toString());
                    jLabel8.setText(c.toString());
                    break;
            case 2: if(id == 0)
                        id = a.getVampiros().size()-1;
                    else{
                        id--;
                    }
                    d = a.getVampiros().get(id).getDiaNacimiento();
                    v = a.getVampiros().get(id).getDraculizados();
                    jLabel2.setText(idt.toString() + "/" + a.getVampiros().size());
                    jLabel5.setText(d.toString());
                    jLabel6.setText(v.toString());
                    break;
            case 3: if(id == 0)
                        id = a.getZombies().size()-1;
                    else{
                        id--;
                    }
                    d = a.getZombies().get(id).getDiaNacimiento();
                    v = a.getZombies().get(id).getZombieficados();
                    jLabel2.setText(idt.toString() + "/" + a.getZombies().size());
                    jLabel5.setText(d.toString());
                    jLabel6.setText(v.toString());
                    break;
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    private void menus(){
        switch(ser){
            case 0: jLabel1.setText("HUMANO");
                    if(!a.getHumanos().isEmpty()){
                        jLabel2.setText("1/" + a.getHumanos().size());
                        jLabel3.setText("Dia de nacimiento:");
                        jLabel4.setText("Velocidad:");
                        d = a.getHumanos().get(0).getDiaNacimiento();
                        jLabel5.setText(d.toString());
                        v = a.getHumanos().get(0).getVelocidad();
                        jLabel6.setText(v.toString());
                        jLabel7.setText("");
                        jLabel8.setText("");
                    }
                    else
                        jLabel2.setText("0/" + a.getHumanos().size());
                        jLabel3.setText("Dia de nacimiento:");
                        jLabel4.setText("Velocidad:");
                        jLabel5.setText("");
                        jLabel6.setText("");
                        jLabel7.setText("");
                        jLabel8.setText("");
                    break;
            case 1: jLabel1.setText("CAZAVAMPIRO");
                    if(!a.getCV().isEmpty()){
                        jLabel2.setText("1/" + a.getCV().size());
                        jLabel3.setText("Dia de nacimiento:");
                        jLabel4.setText("Velocidad:");
                        d = a.getCV().get(0).getDiaNacimiento();
                        jLabel5.setText(d.toString());
                        v = a.getCV().get(0).getVelocidad();
                        jLabel6.setText(v.toString());
                        c = a.getCV().get(0).getVampirosmatados();
                        jLabel7.setText("Vampiros matados:");
                        jLabel8.setText(c.toString());
                    }
                    else
                        jLabel2.setText("0/" + a.getCV().size());
                        jLabel3.setText("Dia de nacimiento:");
                        jLabel4.setText("Velocidad:");
                        jLabel5.setText("");
                        jLabel6.setText("");
                        jLabel7.setText("Vampiros matados:");
                        jLabel8.setText("");
                    break;
            case 2: jLabel1.setText("VAMPIRO");
                    if(!a.getVampiros().isEmpty()){
                        jLabel2.setText("1/" + a.getVampiros().size());
                        jLabel3.setText("Dia de nacimiento:");
                        jLabel4.setText("Vampiros convertidos:");
                        d = a.getVampiros().get(0).getDiaNacimiento();
                        jLabel5.setText(d.toString());
                        v = a.getVampiros().get(0).getDraculizados();
                        jLabel6.setText(v.toString());
                        jLabel7.setText("");
                        jLabel8.setText("");
                    }
                    else
                        jLabel2.setText("0/" + a.getVampiros().size());
                        jLabel3.setText("Dia de nacimiento:");
                        jLabel4.setText("Vampiros convertidos:");
                        jLabel5.setText("");
                        jLabel6.setText("");
                        jLabel7.setText("");
                        jLabel8.setText("");
                    break;
            case 3: jLabel1.setText("ZOMBIE");
                    if(!a.getZombies().isEmpty()){
                        jLabel2.setText("1/" + a.getZombies().size());
                        jLabel3.setText("Dia de nacimiento:");
                        jLabel4.setText("Vampiros convertidos:");
                        d = a.getZombies().get(0).getDiaNacimiento();
                        jLabel5.setText(d.toString());
                        v = a.getZombies().get(0).getZombieficados();
                        jLabel6.setText(v.toString());
                        jLabel7.setText("");
                        jLabel8.setText("");
                    }
                    jLabel2.setText("1/" + a.getZombies().size());
                    jLabel3.setText("Dia de nacimiento:");
                    jLabel4.setText("Vampiros convertidos:");
                    jLabel5.setText("");
                    jLabel6.setText("");
                    jLabel7.setText("");
                    jLabel8.setText("");
                    break;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
