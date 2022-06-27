package absensi.java;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.Timestamp;   
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import javafx.scene.control.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import backoffice.Form_login;
import java.awt.Color;
import java.awt.Cursor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import lib.*;
import penyimpanan.Karyawan;

public class Form_absen_otomatis  extends javax.swing.JFrame {
	int timeRun = 0;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
	DateTimeFormatter day = DateTimeFormatter.ofPattern("EEEE"); 
	public static String tanggal;
	Lib_aplikasi lib;
	
	 public Form_absen_otomatis() {
	        initComponents();
	         Karyawan.refresh_penyimpanan_absen();
	         
	        Karyawan.isi_map();
	        ImageIcon img = new ImageIcon(System.getProperty("user.dir") +"/src/img/LOGO-app.png");

	        this.setIconImage(img.getImage());
	        LocalDateTime now = LocalDateTime.now(); 
	        menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        txt_RFID.setHorizontalAlignment(JTextField.CENTER);
	        txt_msk.setHorizontalAlignment(JTextField.CENTER);
	        txt_nm.setHorizontalAlignment(JTextField.CENTER);
	        txt_title1.setHorizontalAlignment(JTextField.CENTER);
	        lbl_jam.setHorizontalAlignment(JTextField.CENTER);
	        status.setHorizontalAlignment(JTextField.CENTER);
	        lbl_tanggal.setHorizontalAlignment(JTextField.CENTER);
	        nm.setHorizontalAlignment(JTextField.CENTER);
	        msk.setHorizontalAlignment(JTextField.CENTER);
	        lbl_info.setHorizontalAlignment(JTextField.CENTER);
	        txt_RFID.requestFocus();
	        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	          new Thread()
	        {
	            public void run()
	        {
	            while(timeRun == 0)
	        {
	            Calendar cal = new GregorianCalendar();
	            int hour = cal.get(Calendar.HOUR_OF_DAY);
	            int min = cal.get(Calendar.MINUTE);
	            int sec = cal.get(Calendar.SECOND);
	            int AM_PM = cal.get(Calendar.AM_PM);
	            
	            String day_night = "";
	            String menit = "";
	            String jam = "";
	            String detik = "";
	            if(AM_PM ==1)
	        {
	            day_night = "PM";
	        }
	            else
	        {
	            day_night = "AM";
	        }
	            if(min < 10){
	                menit="0"+min;
	            } else{
	                 menit=""+min;
	            }
	              if(sec < 10){
	                detik="0"+sec;
	            } else{
	                  detik=""+sec;
	            }
	             if(hour < 10){
	                jam="0"+hour;
	            } else{
	                 jam=""+hour;
	            }
	              
	            String time = jam + ":" + menit + ":" + detik;
	            lbl_jam.setText(time);
	            lbl_tanggal.setText(day.format(now)+", "+dtf.format(now));
	            get_tanggal();
	        }
	        }
	        }.start();
	    }
	        public  void rfid_focus(){
	       
	             txt_RFID.requestFocus();
	    }
	        public  String get_tanggal(){
	             tanggal = lbl_tanggal.getText()+" "+lbl_jam.getText();
	            return tanggal;
	        }
	    private void status_success(){
	        status.setForeground(Color.GREEN);
	        status.setText("Berhasil Melakukan absen!");
	    }
	    private void status_fail(String msg){
	        status.setForeground(Color.WHITE);
	        status.setText(msg);
	    }
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        lbl_jam = new javax.swing.JLabel();
	        txt_RFID = new javax.swing.JTextField();
	        lbl_info = new javax.swing.JLabel();
	        menu = new javax.swing.JLabel();
	        nm = new javax.swing.JLabel();
	        txt_msk = new javax.swing.JLabel();
	        txt_nm = new javax.swing.JLabel();
	        msk = new javax.swing.JLabel();
	        txt_title1 = new javax.swing.JLabel();
	        lbl_tanggal = new javax.swing.JLabel();
	        bg_transparent_bk4 = new javax.swing.JLabel();
	        bg_transparent_bk5 = new javax.swing.JLabel();
	        bg_transparent_bk2 = new javax.swing.JLabel();
	        bg_transparent_bk3 = new javax.swing.JLabel();
	        status = new javax.swing.JLabel();
	        bg_transparent_bk6 = new javax.swing.JLabel();
	        bg_transparent_bk1 = new javax.swing.JLabel();
	        bg_transparent_bk7 = new javax.swing.JLabel();
	        BG = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setTitle("Aplikasi Absensi Karyawan");
	        setUndecorated(true);
	        setResizable(false);
	        getContentPane().setLayout(null);

	        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/barcode.png"))); // NOI18N
	        getContentPane().add(jLabel1);
	        jLabel1.setBounds(190, 410, 90, 80);

	        lbl_jam.setFont(new java.awt.Font("Arial", 1, 75)); // NOI18N
	        lbl_jam.setForeground(new java.awt.Color(255, 255, 255));
	        lbl_jam.setText("00:00:00");
	        getContentPane().add(lbl_jam);
	        lbl_jam.setBounds(180, 270, 550, 70);

	        txt_RFID.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
	        txt_RFID.setForeground(new java.awt.Color(51, 51, 51));
	        txt_RFID.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyPressed(java.awt.event.KeyEvent evt) {
	                txt_RFIDKeyPressed(evt);
	            }
	        });
	        getContentPane().add(txt_RFID);
	        txt_RFID.setBounds(270, 410, 440, 80);

	        lbl_info.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
	        lbl_info.setForeground(new java.awt.Color(255, 255, 255));
	        getContentPane().add(lbl_info);
	        lbl_info.setBounds(780, 450, 450, 60);

	        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/70-menu.png"))); // NOI18N
	        menu.setToolTipText("<html>\n      <strong>Menu</strong>\n</html>");
	        menu.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                menuMouseClicked(evt);
	            }
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                menuMouseEntered(evt);
	            }
	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                menuMouseExited(evt);
	            }
	        });
	        getContentPane().add(menu);
	        menu.setBounds(1290, 10, 70, 70);

	        nm.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
	        nm.setForeground(new java.awt.Color(255, 255, 255));
	        nm.setText("Nama");
	        getContentPane().add(nm);
	        nm.setBounds(780, 230, 450, 60);

	        txt_msk.setFont(new java.awt.Font("Tahoma", 0, 38)); // NOI18N
	        txt_msk.setForeground(new java.awt.Color(255, 255, 255));
	        txt_msk.setText("-");
	        getContentPane().add(txt_msk);
	        txt_msk.setBounds(780, 390, 450, 60);

	        txt_nm.setFont(new java.awt.Font("Tahoma", 0, 38)); // NOI18N
	        txt_nm.setForeground(new java.awt.Color(255, 255, 255));
	        txt_nm.setText("-");
	        getContentPane().add(txt_nm);
	        txt_nm.setBounds(780, 290, 450, 60);

	        msk.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
	        msk.setForeground(new java.awt.Color(255, 255, 255));
	        msk.setText("Masuk");
	        getContentPane().add(msk);
	        msk.setBounds(780, 340, 450, 60);

	        txt_title1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
	        txt_title1.setForeground(new java.awt.Color(255, 255, 255));
	        txt_title1.setText("ABSENSI KARYAWAN");
	        getContentPane().add(txt_title1);
	        txt_title1.setBounds(140, 190, 620, 60);

	        lbl_tanggal.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
	        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
	        lbl_tanggal.setText("01/01/2018");
	        getContentPane().add(lbl_tanggal);
	        lbl_tanggal.setBounds(180, 350, 550, 60);

	        bg_transparent_bk4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
	        getContentPane().add(bg_transparent_bk4);
	        bg_transparent_bk4.setBounds(780, 210, 450, 360);

	        bg_transparent_bk5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
	        getContentPane().add(bg_transparent_bk5);
	        bg_transparent_bk5.setBounds(250, 270, 400, 80);

	        bg_transparent_bk2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
	        getContentPane().add(bg_transparent_bk2);
	        bg_transparent_bk2.setBounds(140, 200, 620, 40);

	        bg_transparent_bk3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
	        getContentPane().add(bg_transparent_bk3);
	        bg_transparent_bk3.setBounds(140, 200, 620, 40);

	        status.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
	        status.setForeground(new java.awt.Color(51, 255, 102));
	        getContentPane().add(status);
	        status.setBounds(200, 490, 510, 60);

	        bg_transparent_bk6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
	        getContentPane().add(bg_transparent_bk6);
	        bg_transparent_bk6.setBounds(180, 270, 550, 290);

	        bg_transparent_bk1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
	        getContentPane().add(bg_transparent_bk1);
	        bg_transparent_bk1.setBounds(770, 200, 470, 380);

	        bg_transparent_bk7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
	        getContentPane().add(bg_transparent_bk7);
	        bg_transparent_bk7.setBounds(140, 250, 620, 330);

	        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BG_CLOCK_blured.jpg"))); // NOI18N
	        getContentPane().add(BG);
	        BG.setBounds(0, -320, 2510, 1410);

	        pack();
	    }
	    private void txt_RFIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_RFIDKeyPressed
	         status.setText("");
	         txt_RFID.setBackground(Color.WHITE);
	        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
	              if (txt_RFID.getText().equals(null) || txt_RFID.getText().equals("")) {
	                    status_fail("RFID Tidak Boleh Kosong");
	                    txt_RFID.setBackground(Color.PINK);
	                } else {
	            if (Karyawan.map.containsKey(txt_RFID.getText())) {
	                if (Karyawan.kry_map.containsKey(lbl_tanggal.getText()) && Karyawan.kry_map.containsValue(txt_RFID.getText())){ 
	                status_fail("Anda Sudah melakukan Absen!");
	                txt_RFID.setText("");
	                txt_RFID.setBackground(Color.PINK);
	                }else{
	                    
	                    
	                    txt_RFID.setEditable(false);
	                    status.setVisible(true);
	                    String outputFile = System.getProperty("user.dir") + "/csv/absensi.xls";
	                    // Create a workbook object.
	                    FileInputStream inputStream;
	                    inputStream = null;
	                    try {
	                        inputStream = new FileInputStream(outputFile);
	                    } catch (FileNotFoundException ex) {

	                        Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    Workbook workbook = null;
	                    try {
	                        workbook = new HSSFWorkbook(inputStream);
	                    } catch (IOException ex) {
	                        status_fail("File Excel sedang dipakai!");
	                        Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    // Create a sheet using createSheet method of workbook
	                    Sheet sheet = workbook.getSheet("Absensi");
	                    // Create a row and put some cells in it.
	                    System.out.println(sheet.getLastRowNum());
	                    Row row = sheet.createRow(sheet.getLastRowNum() + 1);
	                    // Create a cell and put a value in it.
	                    org.apache.poi.ss.usermodel.Cell cell = row.createCell(0);
	                    row.createCell(0).setCellValue(lbl_tanggal.getText());
	                    // Or You can put in one line like this.
	                    row.createCell(1).setCellValue(txt_RFID.getText());
	                    row.createCell(2).setCellValue(Karyawan.map.get(txt_RFID.getText()));
	                    row.createCell(3).setCellValue(lbl_jam.getText());
	                    txt_nm.setText(Karyawan.map.get(txt_RFID.getText()));
	                    txt_msk.setText(lbl_jam.getText());
	                    int terlambat = lib.countHour("08:00:00", lbl_jam.getText());
	                    
	                    if (terlambat > 0) {
	                        String lama_terlambat=terlambat + " jam " + lib.menit + " mnt";
	                        lbl_info.setForeground(Color.PINK);
	                        lbl_info.setBackground(Color.WHITE);
	                        lbl_info.setText("Terlambat : "+lama_terlambat);
	                        row.createCell(4).setCellValue(lama_terlambat);
	                        row.createCell(5).setCellValue("Terlambat");
	                    } else {
	                        row.createCell(4).setCellValue("-");
	                        row.createCell(5).setCellValue("-");
	                    }
	                    // Create a FileOutputStream by passing the excel file name.
	                    FileOutputStream outputStream;
	                    outputStream = null;
	                    try {
	                        outputStream = new FileOutputStream(outputFile);     
	                        lib.click_sound();
	                        status_success();
	                    } catch (FileNotFoundException ex) {
	                        status_fail("File Sedang Dipakai!");
	                        Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    try {
	                        // Write the FileOutputStream to workbook object.
	                        workbook.write(outputStream);

	                    } catch (IOException ex) {
	                        status_fail("Gagal Melakukan Absen!");
	                        Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);

	                    }
	                    try {
	                        // Finally close the FileOutputStream.
	                        outputStream.close();
	                    } catch (IOException ex) {
	                        status_fail("Gagal menyimpan data");
	                        Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);

	                    }
	                    try {
	                        TimeUnit.MILLISECONDS.sleep(560);
	                    } catch (InterruptedException ex) {
	                        Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    txt_RFID.setText("");
	                    txt_RFID.setEditable(true);
	                    txt_RFID.requestFocus();
	                    Karyawan.refresh_penyimpanan_absen();
	                    for(Map.Entry entry:Karyawan.kry_map.entrySet()){
	                        System.out.println(entry.getKey()+" "+entry.getValue());
	                    }
	                        
	                    
	                    new java.util.Timer().schedule( 
	                    new java.util.TimerTask() {
	                        @Override
	                        public void run() {
	                            txt_nm.setText("-");
	                            txt_msk.setText("-");
	                            lbl_info.setText("");
	                            status.setText("");
	                        }
	                    },
	                            3750
	                    );

	            }
	              } else {
	               
	                status_fail("RFID Tidak Ditemukan");
	                txt_RFID.setText("");
	                txt_RFID.setBackground(Color.PINK);
	                 
	            }
	            }
	              new java.util.Timer().schedule( 
	                    new java.util.TimerTask() {
	                        @Override
	                        public void run() {
	                            txt_RFID.setBackground(Color.WHITE);
	                            status.setText("");
	                        }
	                    },
	                            4750
	                    );
	        }

	    }//GEN-LAST:event_txt_RFIDKeyPressed

	    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
	        backoffice.Form_menu frm = new backoffice.Form_menu();
	        frm.setVisible(true);
	    }//GEN-LAST:event_menuMouseClicked

	    private void menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseEntered
	        String imageName = System.getProperty("user.dir") +"/src/img/70-menu-hovered.png";
	       try {
	           menu.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
	       } catch (IOException ex) {
	           Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);
	       }
	    }//GEN-LAST:event_menuMouseEntered

	    private void menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseExited
	        String imageName = System.getProperty("user.dir") +"/src/img/70-menu.png";
	       try {
	           menu.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
	       } catch (IOException ex) {
	           Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);
	       }
	    }//GEN-LAST:event_menuMouseExited

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
	                if ("Windows".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Form_absen_otomatis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Form_absen_otomatis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Form_absen_otomatis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Form_absen_otomatis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>
	        //</editor-fold>
	        //</editor-fold>
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new Form_absen_otomatis().setVisible(true);
	            }
	        });
	    }

	    // Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JLabel BG;
	    private javax.swing.JLabel bg_transparent_bk1;
	    private javax.swing.JLabel bg_transparent_bk2;
	    private javax.swing.JLabel bg_transparent_bk3;
	    private javax.swing.JLabel bg_transparent_bk4;
	    private javax.swing.JLabel bg_transparent_bk5;
	    private javax.swing.JLabel bg_transparent_bk6;
	    private javax.swing.JLabel bg_transparent_bk7;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel lbl_info;
	    private javax.swing.JLabel lbl_jam;
	    private javax.swing.JLabel lbl_tanggal;
	    private javax.swing.JLabel menu;
	    private javax.swing.JLabel msk;
	    private javax.swing.JLabel nm;
	    private javax.swing.JLabel status;
	    private javax.swing.JTextField txt_RFID;
	    private javax.swing.JLabel txt_msk;
	    private javax.swing.JLabel txt_nm;
	    private javax.swing.JLabel txt_title1;
	    // End of variables declaration//GEN-END:variables
	}

}
