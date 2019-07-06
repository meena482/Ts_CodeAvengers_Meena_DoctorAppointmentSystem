import java.awt.event.ActionEvent;
import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.Statement;
 import java.util.ArrayList;
 import javax.swing.JOptionPane;
 import javax.swing.table.DefaultTableModel;
 import javax.swing.table.TableModel;
 public class DoctorDetails extends javax.swing.JFrame {

        private javax.swing.JButton jButton_Delete;
	    private javax.swing.JButton jButton_Insert;
	    private javax.swing.JButton jButton_Update;
	    private javax.swing.JButton jButton_Logout;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	   
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable jTable_Display_Users;
	    private javax.swing.JTextField jTextField_d_id;
	    private javax.swing.JTextField jTextField_doc_name;
	    private javax.swing.JTextField jTextField_specalist;
	    private javax.swing.JTextField jTextField_city; 
	    private javax.swing.JTextField jTextField_visitingtime;
		private String query; 
	  
		public DoctorDetails() {
         initComponents();
         Show_Users_In_JTable();
     }
     
       public Connection getConnection()
    {
        Connection con;
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<User> getUsersList()
    {
        ArrayList<User> usersList = new ArrayList<User>();
        Connection connection = getConnection();
        
        String query = "SELECT * FROM  users ";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            User user;
            while(rs.next())
            {
                user = new User(rs.getString("d_id"),rs.getString("doc_name"),rs.getString("specalist"),rs.getString("city"), rs.getString("visitingtime"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }
   
    public void Show_Users_In_JTable()
    {
        ArrayList<User> list = getUsersList();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
        Object[] row = new Object[5];
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getd_id();
            row[1] = list.get(i).getdoc_name();
            row[2] = list.get(i).getspecalist();
            row[3] = list.get(i).getcity();
            row[4] = list.get(i).getvisitingtime();
          model.addRow(row);
        }
     }
         
    
    public void executeSQlQuery(String query, String message)
    {
        Connection con = getConnection();
        Statement st;
        try{
            st = con.createStatement();
            if((st.executeUpdate(query)) == 1)
            {
                // refresh jtable data
                DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
                model.setRowCount(0);
                Show_Users_In_JTable();
                
                JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
            }else{
                JOptionPane.showMessageDialog(null, "Data Not "+message);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
     @SuppressWarnings("unchecked")
                            
     private void initComponents() {

         jPanel1 = new javax.swing.JPanel();
         jLabel1 = new javax.swing.JLabel();
         jLabel2 = new javax.swing.JLabel();
         jLabel3 = new javax.swing.JLabel();
         jLabel4 = new javax.swing.JLabel();
         jLabel5= new javax.swing.JLabel();
         jTextField_d_id = new javax.swing.JTextField();
         jTextField_doc_name = new javax.swing.JTextField();
         jTextField_specalist = new javax.swing.JTextField();
         jTextField_city = new javax.swing.JTextField();
         jTextField_visitingtime= new javax.swing.JTextField();
         jScrollPane1 = new javax.swing.JScrollPane();
         jTable_Display_Users = new javax.swing.JTable();
         jButton_Insert = new javax.swing.JButton();
         jButton_Update = new javax.swing.JButton();
         jButton_Delete = new javax.swing.JButton();
         jButton_Logout = new javax.swing.JButton();

         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

         jPanel1.setBackground(new java.awt.Color(204, 204, 204));

         jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); 
         jLabel1.setText("d_id:");

         jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); 
         jLabel2.setText("doc_name:");

         jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); 
         jLabel3.setText("specalist:");

         jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); 
         jLabel4.setText("city:");
         
         jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); 
         jLabel5.setText("visitingtime:");
         
         jTextField_d_id.setFont(new java.awt.Font("Verdana", 0, 14)); 
         jTextField_d_id.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_doc_nameActionPerformed(evt);
             }
         });

         jTextField_doc_name.setFont(new java.awt.Font("Verdana", 0, 14)); 
         jTextField_doc_name.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_doc_nameActionPerformed(evt);
             }
         });

         jTextField_specalist.setFont(new java.awt.Font("Verdana", 0, 14)); 
         jTextField_specalist.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_specalistActionPerformed(evt);
             }
         });

         jTextField_city.setFont(new java.awt.Font("Verdana", 0, 14)); 
         jTextField_city.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_cityActionPerformed(evt);
             }
         });
         
         
         jTextField_visitingtime.setFont(new java.awt.Font("Verdana", 0, 14)); 
         jTextField_visitingtime.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_visitingtimeActionPerformed(evt);
             }
         });
         

         jTable_Display_Users.setModel(new javax.swing.table.DefaultTableModel(
             new Object [][] {

             },
             new String [] {
                 "d_id", "doc_name", "specalist", "city","visitingtime"
             }
         ));
         jTable_Display_Users.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 jTable_Display_UsersMouseClicked(evt);
             }
         });
         jScrollPane1.setViewportView(jTable_Display_Users);

         jButton_Insert.setFont(new java.awt.Font("Verdana", 1, 14));
         jButton_Insert.setText("Insert");
         jButton_Insert.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton_InsertActionPerformed(evt);
             }
         });

         jButton_Update.setFont(new java.awt.Font("Verdana", 1, 14)); 
         jButton_Update.setText("Update");
         jButton_Update.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton_UpdateActionPerformed(evt);
             }
         });

         jButton_Delete.setFont(new java.awt.Font("Verdana", 1, 14)); 
         jButton_Delete.setText("Delete");
         jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton_DeleteActionPerformed(evt);
             }
         });

         jButton_Logout.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
         jButton_Logout.setText("Logout");
         jButton_Logout.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton_LogoutActionPerformed(evt);
             
             }        
     });
         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(33, 33, 33)
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(jPanel1Layout.createSequentialGroup()
                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                	     .addComponent(jLabel5)	
                                	     .addComponent(jLabel4)
                                         .addComponent(jLabel3))
                                 .addGap(12, 12, 12))
                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                     .addComponent(jLabel2)
                                     .addComponent(jLabel1))
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(jTextField_d_id, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jTextField_doc_name, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jTextField_specalist, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jTextField_city, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_visitingtime, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                          .addGroup(jPanel1Layout.createSequentialGroup()
                         .addContainerGap()
                         .addComponent(jButton_Insert)
                         .addGap(18, 18, 18)
                         .addComponent(jButton_Update)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                         .addComponent(jButton_Delete)
                 .addGap(18, 18, 18)
                 .addComponent(jButton_Logout)))

                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
         );
         jPanel1Layout.setVerticalGroup(
                 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(jPanel1Layout.createSequentialGroup()
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                             .addGap(36, 36, 36)
                             .addComponent(jLabel1))
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                             .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                             .addComponent(jTextField_d_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addGap(11, 11, 11)
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel2)
                         .addComponent(jTextField_doc_name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGap(18, 18, 18)
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(jTextField_specalist, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel4)
                         .addComponent(jTextField_city, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGap(18,18,18)
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(jLabel5)
                             .addComponent(jTextField_visitingtime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jButton_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jButton_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jButton_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))

                 .addGap(192, 192, 192))
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );

         pack();
     }
     
      private void jTextField_visitingtimeActionPerformed(ActionEvent evt) {
		
	}

	
	private void jTextField_cityActionPerformed(ActionEvent evt) {
		
	}

	private void jTextField_specalistActionPerformed(ActionEvent evt) {
	}

	private void jTextField_doc_nameActionPerformed(ActionEvent evt) {
		
	}

    private void jTextField_d_idActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
     } 
     private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {                                                  
         
          int i = jTable_Display_Users.getSelectedRow();

          TableModel model = jTable_Display_Users.getModel();
         
          jTextField_d_id.setText(model.getValueAt(i,0).toString());

          jTextField_doc_name.setText(model.getValueAt(i,1).toString());

          jTextField_specalist.setText(model.getValueAt(i,2).toString());

          jTextField_city.setText(model.getValueAt(i,3).toString());
          
          jTextField_visitingtime.setText(model.getValueAt(i,4).toString());
          
        }                                                 

      private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	  String query = "INSERT INTO users(d_id,doc_name,specalist,city,visitingtime) VALUES ('"+jTextField_d_id.getText()+"','"+jTextField_doc_name.getText()+"','"+jTextField_specalist.getText()+"','"+jTextField_city.getText()+"','"+jTextField_visitingtime.getText()+"')";
    	  executeSQlQuery(query, "Inserted");
      }                                              
      private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                               
         String query = "UPDATE users SET doc_name='"+jTextField_doc_name.getText()+"',specalist='"+jTextField_specalist.getText()+"',city='"+jTextField_city.getText()+"',visitingtime='"+jTextField_visitingtime.getText()+"'WHERE d_id = "+jTextField_d_id.getText();
         executeSQlQuery(query, "Updated");
      }                                              

      private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                               
          String query = "DELETE FROM users WHERE d_id = "+jTextField_d_id.getText();
           executeSQlQuery(query, "Deleted");
      }   
      private void jButton_LogoutActionPerformed(java.awt.event.ActionEvent evt) {
    	  WelcomePage a=new WelcomePage();
			a.setVisible(true);
			dispose();
      }  
      public static void main(String args[]) {
          
          try {
              for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                  if ("Nimbus".equals(info.getName())) {
                      javax.swing.UIManager.setLookAndFeel(info.getClassName());
                      break;
                  }
              }
          } catch (ClassNotFoundException ex) {
              java.util.logging.Logger.getLogger(DoctorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
              java.util.logging.Logger.getLogger(DoctorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
              java.util.logging.Logger.getLogger(DoctorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
              java.util.logging.Logger.getLogger(DoctorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          
          java.awt.EventQueue.invokeLater(new Runnable() {
              public void run() {
                  new DoctorDetails().setVisible(true);
                  
              }
          });
      }
}