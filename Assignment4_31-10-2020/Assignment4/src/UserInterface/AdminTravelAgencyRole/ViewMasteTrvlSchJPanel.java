/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminTravelAgencyRole;

import Business.Airliner;
import Business.AirlinerDirectory;
import Business.Airplane;
import Business.CustomerDirectory;
import Business.Fleet;
import Business.Flight;
import Business.FlightSchedule;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aditi
 */
public class ViewMasteTrvlSchJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewMasteTrvlSchJPanel
     */
    JPanel UserProcessContainer;
    AirlinerDirectory airlinerDir;
    Fleet airplanelist;
    List<Flight> flightList;
    List<FlightSchedule>  flightScheduleList;
    
    public ViewMasteTrvlSchJPanel(JPanel UserProcessContainer, AirlinerDirectory ad,CustomerDirectory custDir, Fleet airplanelist, List<Flight> flightList, List<FlightSchedule>  fsl) {
        initComponents();
        this.UserProcessContainer=UserProcessContainer;
        this.airlinerDir=ad;
        this.airplanelist=airplanelist;
        this.flightList=flightList;
        this.flightScheduleList= fsl;
        populateMasterSchedule();
    }

   

    

    
    public void populateMasterSchedule(){
        DefaultTableModel model = (DefaultTableModel) tblMasterSchedule.getModel();
        model.setRowCount(0);
        String airlinerName;
        String flightNum;
        String flightName;
        String source;
        String destination;
        String date1;
        String time;
        List<Airliner> airLineList = airlinerDir.getAirlinerList();
        for (Airliner airL : airLineList) {
            //check airline name in airplane
            airlinerName=airL.getAirLinerName();
            //List<Flight> flightList = airL.getfArrayList();
            for(Flight f: flightList){
                if(f.getAirlinerName().equals(airlinerName)){
                flightNum= f.getFlightNum();
                flightName=f.getFlightName();
                //List<FlightSchedule> fslist = f.getFlightSchedule();
                for(FlightSchedule fs: flightScheduleList)
                {
                    if(fs.getFlightNum().equals(flightNum))
                    {
                        source=fs.getSrc();
                        destination=fs.getDestination();
                        time=fs.getTime();
                        date1=fs.getDate().toString();
                        
                        SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
                        sdfrmt.setLenient(false);
                        String date = sdfrmt.format(fs.getDate());

                        
                        //populate 1 rowi n tabel
                        Object row[] = new Object[7];
            row[0] = airlinerName;
            row[1] = flightNum;
            row[2] = flightName;
            row[3] = source;
            row[4] = destination;
            row[5] = date;
            row[6] = time;
            
            model.addRow(row); 
           
                        
                        
                        
                                
                    }//if flight schedule num matches
                }//for FlightSchedule
            }//if flight of ariliner matches
            }//flight loop
            
            
            
            
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
        tblMasterSchedule = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));

        tblMasterSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airliner", "Flight Number", "Flight Name", "Source", "Destination", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMasterSchedule);

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setText("<Back");
        btnBack.setToolTipText("");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        backAction();

        }
        private void backAction(){
            UserProcessContainer.remove(this);
            //TravelAgencyJPnael
            //Component [] componentArray = UserProcessContainer.getComponents();
            //Component c = componentArray[componentArray.length-1];
            //ManageAirlinersJPanel ms = (ManageAirlinersJPanel) c;
            // ms.populateAirlinerList();
            CardLayout layout = (CardLayout) UserProcessContainer.getLayout();
            layout.previous(UserProcessContainer);

    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMasterSchedule;
    // End of variables declaration//GEN-END:variables
}
