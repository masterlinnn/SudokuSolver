/**
 * @author masterlinnn
 * @project Sudoku Solver
 */
package pkg2021;

/*====================Imports=====================*/
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.DataValidation;
import util.DatabaseConnection;

/*====================Imports=====================*/
public class Login extends javax.swing.JFrame {//Login Class

    /*====================Objects=====================*/
    private CardLayout cardLayout; //Cardlayout Change between PersonalInfo Panel and AccountInfo Panel
    private DataValidation dataValidation = new DataValidation();//Verify all the data inputed are correct
    private DatabaseConnection dbConnection = new DatabaseConnection();//Database Connection 
    /*====================Objects=====================*/

  /*====================Valiables=====================*/
    private int accNumber = 0;
    private String username = "";
    private String password = "";

    private ResultSet rs;
    private String sql;

    private int gameMode = 0;

    /*====================Valiables=====================*/
    
    
    public Login(boolean loggedIn) {//Login Class Constructor
   
        super("Sudoku Solver @Login");
        initComponents();
        
        cardLayout = (CardLayout) ((pnlMain.getLayout()));
        cardLayout.show(pnlMain, "LoginCard");

    }//Login Class Constructor
    

      public Login(boolean loggedIn, int inAccNum) {//Login Class Constructor
         super("Sudoku Solver @Login");
         accNumber = inAccNum;
         initComponents();
        
        /*
            LoginCard
            SelectLevelCard
         */
        cardLayout = (CardLayout) ((pnlMain.getLayout()));
        if (loggedIn) {
            cardLayout.show(pnlMain, "SelectLevelCard");
        }else{
         cardLayout.show(pnlMain, "LoginCard");
        }

    }//Login Class Constructor
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgLevel = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        pnlLogin = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtUsernameHelper = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        pwdPassword = new javax.swing.JPasswordField();
        txtPasswordHelper = new javax.swing.JTextField();
        tglShowPass = new javax.swing.JToggleButton();
        lblLoginBtn = new javax.swing.JLabel();
        lblBackBtn = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        pblSelectLevel = new javax.swing.JPanel();
        lblIconSL = new javax.swing.JLabel();
        lblTitleSL = new javax.swing.JLabel();
        lblTitle1SL = new javax.swing.JLabel();
        radEasy = new javax.swing.JRadioButton();
        radMedium = new javax.swing.JRadioButton();
        radHard = new javax.swing.JRadioButton();
        lblNextBtn = new javax.swing.JLabel();
        lblBackgroundSL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlMain.setLayout(new java.awt.CardLayout());

        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Icon.png"))); // NOI18N
        pnlLogin.add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 160, 130));

        lblTitle.setFont(new java.awt.Font("Rage Italic", 1, 68)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Sudoku Solver");
        lblTitle.setToolTipText("");
        pnlLogin.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 70));

        lblTitle1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("Login");
        pnlLogin.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 800, 60));

        lblUsername.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblUsername.setText("Username               :");
        pnlLogin.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 240, 30));

        txtUsername.setBackground(new java.awt.Color(0, 0, 0));
        txtUsername.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtUsername.setToolTipText("Enter Your Username");
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUsername.setOpaque(false);
        pnlLogin.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 350, 30));

        txtUsernameHelper.setEditable(false);
        txtUsernameHelper.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtUsernameHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsernameHelper.setBorder(null);
        txtUsernameHelper.setFocusable(false);
        txtUsernameHelper.setOpaque(false);
        pnlLogin.add(txtUsernameHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 600, 40));

        lblPassword.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblPassword.setText("Password               :");
        pnlLogin.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 230, 30));

        pwdPassword.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        pwdPassword.setToolTipText("Enter Your Password");
        pwdPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        pwdPassword.setOpaque(false);
        pnlLogin.add(pwdPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 350, 30));

        txtPasswordHelper.setEditable(false);
        txtPasswordHelper.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtPasswordHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPasswordHelper.setBorder(null);
        txtPasswordHelper.setFocusable(false);
        txtPasswordHelper.setOpaque(false);
        pnlLogin.add(txtPasswordHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 600, 40));

        tglShowPass.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        tglShowPass.setText("Show Password");
        tglShowPass.setToolTipText("Show The Password (Click Three Times)");
        tglShowPass.setBorderPainted(false);
        tglShowPass.setContentAreaFilled(false);
        tglShowPass.setFocusPainted(false);
        tglShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglShowPassActionPerformed(evt);
            }
        });
        pnlLogin.add(tglShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 200, 30));

        lblLoginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Login1.png"))); // NOI18N
        lblLoginBtn.setToolTipText("Login To Account");
        lblLoginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLoginBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLoginBtnMouseExited(evt);
            }
        });
        pnlLogin.add(lblLoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 280, 70));

        lblBackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back1.png"))); // NOI18N
        lblBackBtn.setToolTipText("Back To Menu");
        lblBackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackBtnMouseExited(evt);
            }
        });
        pnlLogin.add(lblBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 250, 60));

        lblBackground.setBackground(new java.awt.Color(0, 0, 0));
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Background3.jpg"))); // NOI18N
        pnlLogin.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pnlMain.add(pnlLogin, "LoginCard");

        pblSelectLevel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconSL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Icon.png"))); // NOI18N
        pblSelectLevel.add(lblIconSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 160, 130));

        lblTitleSL.setFont(new java.awt.Font("Rage Italic", 1, 68)); // NOI18N
        lblTitleSL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleSL.setText("Sudoku Solver");
        lblTitleSL.setToolTipText("");
        pblSelectLevel.add(lblTitleSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 70));

        lblTitle1SL.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        lblTitle1SL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1SL.setText("Select Which Level Would You Like To Play:");
        pblSelectLevel.add(lblTitle1SL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 800, 60));

        btgLevel.add(radEasy);
        radEasy.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        radEasy.setText(" Easy");
        radEasy.setToolTipText("Select Easy Level");
        radEasy.setOpaque(false);
        pblSelectLevel.add(radEasy, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 180, -1));

        btgLevel.add(radMedium);
        radMedium.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        radMedium.setText(" Medium");
        radMedium.setToolTipText("Select Medium Level");
        radMedium.setOpaque(false);
        pblSelectLevel.add(radMedium, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 180, -1));

        btgLevel.add(radHard);
        radHard.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        radHard.setText(" Hard");
        radHard.setToolTipText("Select Hard Level");
        radHard.setOpaque(false);
        pblSelectLevel.add(radHard, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 180, -1));

        lblNextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Next1.png"))); // NOI18N
        lblNextBtn.setToolTipText("Proceed To Game");
        lblNextBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNextBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNextBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNextBtnMouseExited(evt);
            }
        });
        pblSelectLevel.add(lblNextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 250, 70));

        lblBackgroundSL.setBackground(new java.awt.Color(0, 0, 0));
        lblBackgroundSL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Background3.jpg"))); // NOI18N
        pblSelectLevel.add(lblBackgroundSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pnlMain.add(pblSelectLevel, "SelectLevelCard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnMouseEntered
        lblBackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back2.png")));
    }//GEN-LAST:event_lblBackBtnMouseEntered

    private void lblBackBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnMouseExited
        lblBackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back1.png")));
    }//GEN-LAST:event_lblBackBtnMouseExited

    private void lblBackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnMouseClicked
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_lblBackBtnMouseClicked

    private void lblLoginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginBtnMouseClicked
        boolean infoCheck = true;
        /*====================  Check Username =====================*/
        if (infoCheck) {
            if (dataValidation.checkPresent(txtUsername.getText())) {
                infoCheck = true;
                username = txtUsername.getText();
                txtUsernameHelper.setVisible(false);
            } else {
                infoCheck = false;
                txtUsernameHelper.setForeground(Color.red);
                txtUsernameHelper.setText("******  You Must Input Username!  ******");
                txtUsernameHelper.setVisible(true);
            }
        }
        /*====================  Check Username =====================*/

        /*====================  Check Password =====================*/
        if (infoCheck) {
            if (dataValidation.checkPresent(String.valueOf(pwdPassword.getPassword()))) {
                infoCheck = true;
                password = String.valueOf(pwdPassword.getPassword());
                txtPasswordHelper.setVisible(false);
            } else {
                infoCheck = false;
                txtPasswordHelper.setForeground(Color.red);
                txtPasswordHelper.setText("******  You Must Input Password!  ******");
                txtPasswordHelper.setVisible(true);
            }
        }
        /*====================  Check Password =====================*/

        if (infoCheck) {
            if (dbConnection.findUser(username)) {
                sql = "SELECT AccountNumber, Username, Password From tblAccount WHERE StrComp(Username," + "'" + username + "'" + ", 0) = 0";
                rs = dbConnection.getRs(sql);//Get Result From Database
                java.util.List<Integer> accNumberList = new java.util.ArrayList<>();

                try {
                    while (rs.next()) {
                        accNumberList.add(rs.getInt("AccountNumber"));
                        if (username.equals(rs.getString("Username")) && password.equals(rs.getString("Password"))) //Check If Password Is Correct
                        {
                            JOptionPane.showMessageDialog(this, "Successfully Logged In !");
                            accNumber = accNumberList.get(0);
                            cardLayout.show(pnlMain, "SelectLevelCard");
                        } else {
                            txtPasswordHelper.setForeground(Color.RED);
                            txtPasswordHelper.setText("Incorrect Password");
                            txtPasswordHelper.setVisible(true);
                            pwdPassword.setText("");
                        }
                    }
                } catch (SQLException sqlEx) {
                    System.out.println(sqlEx.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username: (" + username + ") Not Found!");
                txtUsername.setText("");
                pwdPassword.setText("");
            }
        }

    }//GEN-LAST:event_lblLoginBtnMouseClicked

    private void lblLoginBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginBtnMouseEntered
        lblLoginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Login2.png")));
    }//GEN-LAST:event_lblLoginBtnMouseEntered

    private void lblLoginBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginBtnMouseExited
        lblLoginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Login1.png")));
    }//GEN-LAST:event_lblLoginBtnMouseExited

    private void tglShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglShowPassActionPerformed
        char orgPassword = pwdPassword.getEchoChar();
        tglShowPass.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    pwdPassword.setEchoChar((char) 0);
                } else {
                    pwdPassword.setEchoChar(orgPassword);
                }
            }
        });
    }//GEN-LAST:event_tglShowPassActionPerformed

    private void lblNextBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextBtnMouseClicked
        if (!radEasy.isSelected() && !radMedium.isSelected() && !radHard.isSelected()) {
            JOptionPane.showMessageDialog(this, "You Need To Select Level!");
        }
        if (radEasy.isSelected() && !radMedium.isSelected() && !radHard.isSelected()) {
            gameMode = 1;
            this.dispose();//Close Login Interface
            new Game(accNumber, gameMode).setVisible(true);//Open Game Interface
        }
        if (!radEasy.isSelected() && radMedium.isSelected() && !radHard.isSelected()) {
            gameMode = 2;
            this.dispose();//Close Login Interface
            new Game(accNumber, gameMode).setVisible(true);//Open Game Interface
        }
        if (!radEasy.isSelected() && !radMedium.isSelected() && radHard.isSelected()) {
            gameMode = 3;
            this.dispose();//Close Login Interface
            new Game(accNumber, gameMode).setVisible(true);//Open Game Interface
        }

    }//GEN-LAST:event_lblNextBtnMouseClicked

    private void lblNextBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextBtnMouseEntered
        lblNextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Next2.png")));
    }//GEN-LAST:event_lblNextBtnMouseEntered

    private void lblNextBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextBtnMouseExited
        lblNextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Next1.png")));
    }//GEN-LAST:event_lblNextBtnMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgLevel;
    private javax.swing.JLabel lblBackBtn;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBackgroundSL;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblIconSL;
    private javax.swing.JLabel lblLoginBtn;
    private javax.swing.JLabel lblNextBtn;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle1SL;
    private javax.swing.JLabel lblTitleSL;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pblSelectLevel;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JRadioButton radEasy;
    private javax.swing.JRadioButton radHard;
    private javax.swing.JRadioButton radMedium;
    private javax.swing.JToggleButton tglShowPass;
    private javax.swing.JTextField txtPasswordHelper;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsernameHelper;
    // End of variables declaration//GEN-END:variables
}//Login Class
