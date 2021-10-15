/**
 * @author masterlinnn
 * @project Sudoku Solver
 */
package pkg2021;

import java.awt.CardLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import util.DataValidation;
import util.DatabaseConnection;

public class Forgot extends javax.swing.JFrame {//Forgot Class

    /*====================Objects=====================*/
    private CardLayout cardLayout; //Cardlayout Change between PersonalInfo Panel and AccountInfo Panel
    private DataValidation dataValidation = new DataValidation();//Verify all the data inputed are correct
    private DatabaseConnection dbConnection = new DatabaseConnection();//Database Connection 
    /*====================Objects=====================*/

 /*====================Valiables=====================*/

    private String personName = "";
    private String personSurname = "";
    private String personGender = "";
    private String personDOB = "";
    private String personIDNumber = "";
    private String personPhoneNumber = "";
    private int accNumber = 0;
    private String password = "";

    private ResultSet rs;
    private String sql;

    /*====================Valiables=====================*/
    public Forgot() {//Forgot Class
        super("Sudoku Solver @Forgot Username/Password");
        initComponents();
        /*
            VerifyCard
            SelectionCard
            UsernameCard
            PasswordCard
         */
        cardLayout = (CardLayout) ((pnlMain.getLayout()));
        cardLayout.show(pnlMain, "VerifyCard");
        //cardLayout.show(pnlMain, "SelectionCard");
        // cardLayout.show(pnlMain, "UsernameCard");
        // cardLayout.show(pnlMain, "PasswordCard");
    }//Forgot Class

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgGender = new javax.swing.ButtonGroup();
        btgSelection = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        pnlVerify = new javax.swing.JPanel();
        lblIconV = new javax.swing.JLabel();
        lblTitleV = new javax.swing.JLabel();
        lblTitle1V = new javax.swing.JLabel();
        lblTitle2V = new javax.swing.JLabel();
        lblNameV = new javax.swing.JLabel();
        txtNameV = new javax.swing.JTextField();
        lblSurnameV = new javax.swing.JLabel();
        txtSurnameV = new javax.swing.JTextField();
        lblGenderV = new javax.swing.JLabel();
        radMale = new javax.swing.JRadioButton();
        radFemale = new javax.swing.JRadioButton();
        radOther = new javax.swing.JRadioButton();
        lblDOBV = new javax.swing.JLabel();
        txtBirthDate = new com.toedter.calendar.JDateChooser();
        lblIDNumV = new javax.swing.JLabel();
        txtIDNumV = new javax.swing.JTextField();
        lblPhoneNumV = new javax.swing.JLabel();
        txtPhoneNumV = new javax.swing.JTextField();
        lblVerifyBtnV = new javax.swing.JLabel();
        lblBackBtnV = new javax.swing.JLabel();
        lblbackgroundV = new javax.swing.JLabel();
        pnlSelection = new javax.swing.JPanel();
        lblIconS = new javax.swing.JLabel();
        lblTitleS = new javax.swing.JLabel();
        lblTitle1S = new javax.swing.JLabel();
        radUsername = new javax.swing.JRadioButton();
        radPassword = new javax.swing.JRadioButton();
        lblNextBtn = new javax.swing.JLabel();
        lblBackgroundS = new javax.swing.JLabel();
        pnlShowUsername = new javax.swing.JPanel();
        lblIconU = new javax.swing.JLabel();
        lblTitleU = new javax.swing.JLabel();
        lblTitle1U = new javax.swing.JLabel();
        lblMessageU = new javax.swing.JLabel();
        lblUsernameU = new javax.swing.JLabel();
        lblBackBtnU = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        pnlChangePassword = new javax.swing.JPanel();
        lblIconP = new javax.swing.JLabel();
        lblTitleP = new javax.swing.JLabel();
        lblTitle1P = new javax.swing.JLabel();
        lblUsernameP = new javax.swing.JLabel();
        lblPasswordP = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtPasswordHelper = new javax.swing.JTextField();
        lblConfirmPassP = new javax.swing.JLabel();
        txtConfirmPass = new javax.swing.JTextField();
        txtConfirmPasHelper = new javax.swing.JTextField();
        lblResetPassBtn = new javax.swing.JLabel();
        lblBackgroundP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlMain.setLayout(new java.awt.CardLayout());

        pnlVerify.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Icon.png"))); // NOI18N
        pnlVerify.add(lblIconV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 160, 130));

        lblTitleV.setFont(new java.awt.Font("Rage Italic", 1, 68)); // NOI18N
        lblTitleV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleV.setText("Sudoku Solver");
        lblTitleV.setToolTipText("");
        pnlVerify.add(lblTitleV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 70));

        lblTitle1V.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitle1V.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1V.setText("Forgot Username/Password");
        pnlVerify.add(lblTitle1V, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 800, 70));

        lblTitle2V.setFont(new java.awt.Font("Arial", 0, 28)); // NOI18N
        lblTitle2V.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2V.setText("Please Verify Your Personal Infomation To Continue:");
        pnlVerify.add(lblTitle2V, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 800, 50));

        lblNameV.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblNameV.setText("Name                     :");
        pnlVerify.add(lblNameV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 220, 30));

        txtNameV.setBackground(new java.awt.Color(0, 0, 0));
        txtNameV.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtNameV.setToolTipText("Enter Your Name");
        txtNameV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtNameV.setOpaque(false);
        pnlVerify.add(txtNameV, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 350, 30));

        lblSurnameV.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblSurnameV.setText("Surname                :");
        pnlVerify.add(lblSurnameV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 230, 30));

        txtSurnameV.setBackground(new java.awt.Color(0, 0, 0));
        txtSurnameV.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtSurnameV.setToolTipText("Enter Your Surname");
        txtSurnameV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSurnameV.setOpaque(false);
        pnlVerify.add(txtSurnameV, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 350, 30));

        lblGenderV.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblGenderV.setText("Gender                   :");
        pnlVerify.add(lblGenderV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 230, 30));

        btgGender.add(radMale);
        radMale.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        radMale.setText("Male");
        radMale.setToolTipText("Select Your Gender");
        radMale.setOpaque(false);
        pnlVerify.add(radMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        btgGender.add(radFemale);
        radFemale.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        radFemale.setText("Female");
        radFemale.setToolTipText("Select Your Gender");
        radFemale.setOpaque(false);
        pnlVerify.add(radFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, -1, -1));

        btgGender.add(radOther);
        radOther.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        radOther.setText("Other");
        radOther.setToolTipText("Select Your Gender");
        radOther.setOpaque(false);
        pnlVerify.add(radOther, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, -1, -1));

        lblDOBV.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblDOBV.setText("Date Of Birth          :");
        pnlVerify.add(lblDOBV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 230, 30));

        txtBirthDate.setBackground(new java.awt.Color(255, 255, 204));
        txtBirthDate.setForeground(new java.awt.Color(255, 255, 204));
        txtBirthDate.setToolTipText("Select Your Birthdate");
        txtBirthDate.setDateFormatString("yyyy-MM-dd");
        txtBirthDate.setFocusable(false);
        txtBirthDate.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtBirthDate.setOpaque(false);
        pnlVerify.add(txtBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 350, 30));

        lblIDNumV.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblIDNumV.setText("ID Number              :");
        pnlVerify.add(lblIDNumV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 230, 30));

        txtIDNumV.setBackground(new java.awt.Color(0, 0, 0));
        txtIDNumV.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtIDNumV.setToolTipText("Enter Your ID Number");
        txtIDNumV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtIDNumV.setOpaque(false);
        pnlVerify.add(txtIDNumV, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 350, 30));

        lblPhoneNumV.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblPhoneNumV.setText("Phone Number       :");
        pnlVerify.add(lblPhoneNumV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 240, 30));

        txtPhoneNumV.setBackground(new java.awt.Color(0, 0, 0));
        txtPhoneNumV.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtPhoneNumV.setToolTipText("Enter Your Phone Number");
        txtPhoneNumV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtPhoneNumV.setOpaque(false);
        pnlVerify.add(txtPhoneNumV, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 350, 30));

        lblVerifyBtnV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Verify1.png"))); // NOI18N
        lblVerifyBtnV.setToolTipText("Check If Personal Information Exist");
        lblVerifyBtnV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVerifyBtnVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVerifyBtnVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVerifyBtnVMouseExited(evt);
            }
        });
        pnlVerify.add(lblVerifyBtnV, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 250, -1));

        lblBackBtnV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back1.png"))); // NOI18N
        lblBackBtnV.setToolTipText("Back To Menu");
        lblBackBtnV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackBtnVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackBtnVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackBtnVMouseExited(evt);
            }
        });
        pnlVerify.add(lblBackBtnV, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 250, -1));

        lblbackgroundV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Background4.jpg"))); // NOI18N
        pnlVerify.add(lblbackgroundV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 630));

        pnlMain.add(pnlVerify, "VerifyCard");
        pnlVerify.getAccessibleContext().setAccessibleName("");

        pnlSelection.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Icon.png"))); // NOI18N
        pnlSelection.add(lblIconS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 160, 130));

        lblTitleS.setFont(new java.awt.Font("Rage Italic", 1, 68)); // NOI18N
        lblTitleS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleS.setText("Sudoku Solver");
        lblTitleS.setToolTipText("");
        pnlSelection.add(lblTitleS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 70));

        lblTitle1S.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitle1S.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1S.setText("Select Which Of The Following To Recover:");
        pnlSelection.add(lblTitle1S, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 800, 70));

        btgSelection.add(radUsername);
        radUsername.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        radUsername.setText("Username");
        radUsername.setToolTipText("Check Your Username");
        radUsername.setOpaque(false);
        pnlSelection.add(radUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 180, -1));

        btgSelection.add(radPassword);
        radPassword.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        radPassword.setText("Password");
        radPassword.setToolTipText("Reset Your Password");
        radPassword.setOpaque(false);
        pnlSelection.add(radPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 180, -1));

        lblNextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Next1.png"))); // NOI18N
        lblNextBtn.setToolTipText("Proceed To Selected Option");
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
        pnlSelection.add(lblNextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 250, 80));

        lblBackgroundS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Background4.jpg"))); // NOI18N
        pnlSelection.add(lblBackgroundS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -180, 800, 810));

        pnlMain.add(pnlSelection, "SelectionCard");

        pnlShowUsername.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Icon.png"))); // NOI18N
        pnlShowUsername.add(lblIconU, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 160, 130));

        lblTitleU.setFont(new java.awt.Font("Rage Italic", 1, 68)); // NOI18N
        lblTitleU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleU.setText("Sudoku Solver");
        lblTitleU.setToolTipText("");
        pnlShowUsername.add(lblTitleU, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 70));

        lblTitle1U.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitle1U.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1U.setText("Forgot Username");
        pnlShowUsername.add(lblTitle1U, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 800, 70));

        lblMessageU.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblMessageU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessageU.setText("Your Username Is : ");
        pnlShowUsername.add(lblMessageU, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 800, 90));

        lblUsernameU.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        lblUsernameU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsernameU.setToolTipText("Your Username");
        lblUsernameU.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        pnlShowUsername.add(lblUsernameU, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 460, 90));

        lblBackBtnU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back1.png"))); // NOI18N
        lblBackBtnU.setToolTipText("Back To Menu");
        lblBackBtnU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackBtnUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackBtnUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackBtnUMouseExited(evt);
            }
        });
        pnlShowUsername.add(lblBackBtnU, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 250, -1));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Background4.jpg"))); // NOI18N
        pnlShowUsername.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 630));

        pnlMain.add(pnlShowUsername, "UsernameCard");

        pnlChangePassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Icon.png"))); // NOI18N
        pnlChangePassword.add(lblIconP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 100));

        lblTitleP.setFont(new java.awt.Font("Rage Italic", 1, 68)); // NOI18N
        lblTitleP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleP.setText("Sudoku Solver");
        lblTitleP.setToolTipText("");
        pnlChangePassword.add(lblTitleP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 70));

        lblTitle1P.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitle1P.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1P.setText("Forgot Password");
        pnlChangePassword.add(lblTitle1P, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 800, 70));

        lblUsernameP.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        lblUsernameP.setText("Your Username Is : ");
        pnlChangePassword.add(lblUsernameP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 600, 50));

        lblPasswordP.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblPasswordP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPasswordP.setText("Enter New Password :");
        pnlChangePassword.add(lblPasswordP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 260, 70));

        txtPassword.setBackground(new java.awt.Color(0, 0, 0));
        txtPassword.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtPassword.setToolTipText("Enter New Password");
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtPassword.setOpaque(false);
        pnlChangePassword.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 350, 30));

        txtPasswordHelper.setEditable(false);
        txtPasswordHelper.setBackground(new java.awt.Color(0, 0, 0));
        txtPasswordHelper.setFont(new java.awt.Font("Arial", 0, 21)); // NOI18N
        txtPasswordHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPasswordHelper.setToolTipText("");
        txtPasswordHelper.setBorder(null);
        txtPasswordHelper.setFocusable(false);
        txtPasswordHelper.setOpaque(false);
        pnlChangePassword.add(txtPasswordHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 610, 50));

        lblConfirmPassP.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblConfirmPassP.setText("Confirm Password     :");
        pnlChangePassword.add(lblConfirmPassP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 260, 30));

        txtConfirmPass.setBackground(new java.awt.Color(0, 0, 0));
        txtConfirmPass.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtConfirmPass.setToolTipText("Enter New Password Again");
        txtConfirmPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtConfirmPass.setOpaque(false);
        pnlChangePassword.add(txtConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 350, 30));

        txtConfirmPasHelper.setEditable(false);
        txtConfirmPasHelper.setBackground(new java.awt.Color(0, 0, 0));
        txtConfirmPasHelper.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtConfirmPasHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtConfirmPasHelper.setToolTipText("");
        txtConfirmPasHelper.setBorder(null);
        txtConfirmPasHelper.setFocusable(false);
        txtConfirmPasHelper.setOpaque(false);
        pnlChangePassword.add(txtConfirmPasHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 610, 50));

        lblResetPassBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/ResetPass1.png"))); // NOI18N
        lblResetPassBtn.setToolTipText("Reset Your Password");
        lblResetPassBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResetPassBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblResetPassBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblResetPassBtnMouseExited(evt);
            }
        });
        pnlChangePassword.add(lblResetPassBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 330, 70));

        lblBackgroundP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Background4.jpg"))); // NOI18N
        pnlChangePassword.add(lblBackgroundP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 630));

        pnlMain.add(pnlChangePassword, "PasswordCard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackBtnVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnVMouseClicked
        //Get Option Seleceted  0 = yes, 1 = no
        int result = JOptionPane.showConfirmDialog(null, "Do You Want To Proceed?(You Will Lose All The Input!)",
                "Select An Option From The Following...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (result == 0) {
            this.dispose();
            new Menu().setVisible(true);
        }
    }//GEN-LAST:event_lblBackBtnVMouseClicked

    private void lblBackBtnVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnVMouseEntered
        lblBackBtnV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back2.png")));
    }//GEN-LAST:event_lblBackBtnVMouseEntered

    private void lblBackBtnVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnVMouseExited
        lblBackBtnV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back1.png")));
    }//GEN-LAST:event_lblBackBtnVMouseExited

    private void lblVerifyBtnVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerifyBtnVMouseClicked
        boolean infoCheck = true;

        /*==================== Check Name =====================*/
        if (infoCheck) {
            if (dataValidation.checkPresent(txtNameV.getText())) {
                infoCheck = true;
            } else {
                infoCheck = false;
                JOptionPane.showMessageDialog(this, "You Must Enter Your Name!");
            }
        }
        /*==================== Check Name =====================*/

 /*==================== Check Surname =====================*/
        if (infoCheck) {
            if (dataValidation.checkPresent(txtSurnameV.getText())) {
                infoCheck = true;
            } else {
                infoCheck = false;
                JOptionPane.showMessageDialog(this, "You Must Enter Your Surname!");
            }
        }
        /*==================== Check Surname =====================*/

 /*==================== Check  Gender =====================*/
        if (infoCheck) {
            if (!radMale.isSelected() && !radFemale.isSelected() && !radOther.isSelected()) {
                infoCheck = false;
                JOptionPane.showMessageDialog(this, "You Need To Select Your Gender!");
            } else {
                infoCheck = true;
            }
        }
        /*==================== Check  Gender =====================*/

 /*==================== Check Date Of Birth =====================*/
        if (infoCheck) {
            String invalidDate = "com.toedter.calendar.JCalendar[JCalendar,0,0,0x0,invalid,layout=java.awt.BorderLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]";
            if (txtBirthDate.getJCalendar().toString().contentEquals(invalidDate)) {
                infoCheck = false;
                JOptionPane.showMessageDialog(this, "You need to select your Date Of Birth!");
            } else {
                infoCheck = true;
            }
        }
        /*==================== Check Date Of Birth =====================*/


 /*====================  Check ID Number =====================*/
        if (infoCheck) {
            if (!dataValidation.checkPresent(txtIDNumV.getText())) {
                infoCheck = false;
                JOptionPane.showMessageDialog(this, "You need to input your ID Number!");
            } else {
                infoCheck = true;
            }
        }
        /*====================  Check ID Number =====================*/


 /*====================  Check Phone Number =====================*/
        if (infoCheck) {
            if (!dataValidation.checkPresent(txtPhoneNumV.getText())) {
                infoCheck = false;
                JOptionPane.showMessageDialog(this, "You Must Input Phone Number!");
            } else {
                infoCheck = true;
            }
        }
        /*====================  Check Phone Number =====================*/


 /*==================== Connect Database  =====================*/
        if (infoCheck) {
            personName = txtNameV.getText();
            personSurname = txtSurnameV.getText();
            if (radMale.isSelected() && !radFemale.isSelected() && !radOther.isSelected()) {
                personGender = "Male";
            }
            if (!radMale.isSelected() && radFemale.isSelected() && !radOther.isSelected()) {
                personGender = "Female";
            }
            if (!radMale.isSelected() && !radFemale.isSelected() && radOther.isSelected()) {
                personGender = "Other";
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//Date Formate
            String BDate = dateFormat.format(txtBirthDate.getDate());//Get Selected Date
            personDOB = BDate;

            personIDNumber = String.valueOf(txtIDNumV.getText());

            personPhoneNumber = String.valueOf(txtPhoneNumV.getText());

            sql = "SELECT AccountNumber "
                    + "FROM tblUserInfomation "
                    + "WHERE PersonName = '" + personName + "'"
                    + " AND PersonSurname = '" + personSurname + "'"
                    + " AND PersonGender =  '" + personGender + "'"
                    + " AND PersonDOB = #" + personDOB + "#"
                    + " AND PersonIDNumber = '" + personIDNumber + "'"
                    + " AND PersonPhone = '" + personPhoneNumber + "'";
            //System.out.println(sql);
            java.util.List<Integer> accNumberList = new java.util.ArrayList<>();
            try {
                rs = dbConnection.getRs(sql);
                while (rs.next()) {
                    accNumberList.add(rs.getInt("AccountNumber"));
                }
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
            if (accNumberList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Personal Information Not Found!");
            } else {
                JOptionPane.showMessageDialog(this, "Personal Information Found!");
                accNumber = accNumberList.get(0);
                //System.out.println(accNumber);
                cardLayout.show(pnlMain, "SelectionCard");
            }
        }
        /*==================== Update Database  =====================*/

    }//GEN-LAST:event_lblVerifyBtnVMouseClicked

    private void lblVerifyBtnVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerifyBtnVMouseEntered
        lblVerifyBtnV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Verify2.png")));
    }//GEN-LAST:event_lblVerifyBtnVMouseEntered

    private void lblVerifyBtnVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerifyBtnVMouseExited
        lblVerifyBtnV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Verify1.png")));
    }//GEN-LAST:event_lblVerifyBtnVMouseExited

    private void lblNextBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextBtnMouseClicked
        if (!radUsername.isSelected() && !radPassword.isSelected()) {
            JOptionPane.showMessageDialog(this, "You Need To Select An Option!");
        }
        if (radUsername.isSelected() && !radPassword.isSelected()) {
            lblUsernameU.setText(getUsername());
            cardLayout.show(pnlMain, "UsernameCard");
        }
        if (radPassword.isSelected() && !radUsername.isSelected()) {
            lblUsernameP.setText("Your Username Is : " + getUsername());
            cardLayout.show(pnlMain, "PasswordCard");
        }
    }//GEN-LAST:event_lblNextBtnMouseClicked

    private void lblNextBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextBtnMouseEntered
        lblNextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Next2.png")));
    }//GEN-LAST:event_lblNextBtnMouseEntered

    private void lblNextBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextBtnMouseExited
        lblNextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Next1.png")));
    }//GEN-LAST:event_lblNextBtnMouseExited

    private void lblResetPassBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetPassBtnMouseEntered
        lblResetPassBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/ResetPass2.png")));
    }//GEN-LAST:event_lblResetPassBtnMouseEntered

    private void lblResetPassBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetPassBtnMouseExited
        lblResetPassBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/ResetPass1.png")));
    }//GEN-LAST:event_lblResetPassBtnMouseExited

    private void lblBackBtnUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnUMouseClicked
        //Get Option Seleceted  0 = yes, 1 = no
        int result = JOptionPane.showConfirmDialog(null, "Do You Want To Reset Password?",
                "Select An Option From The Following...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (result == 0) {
          //lblUsernameP.setText("Your Username Is : " + getUsername());
          cardLayout.show(pnlMain, "PasswordCard");
        }else{
            this.dispose();
            new Menu().setVisible(true);
        }
    }//GEN-LAST:event_lblBackBtnUMouseClicked

    private void lblBackBtnUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnUMouseEntered
        lblBackBtnV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back2.png")));
    }//GEN-LAST:event_lblBackBtnUMouseEntered

    private void lblBackBtnUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnUMouseExited
        lblBackBtnV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back1.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_lblBackBtnUMouseExited

    private void lblResetPassBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetPassBtnMouseClicked
        boolean passCheck = true;

        if (dataValidation.checkPresent(txtPassword.getText())) {
            passCheck = true;
            txtPasswordHelper.setVisible(false);
        } else {
            passCheck = false;
            txtPasswordHelper.setForeground(Color.red);
            txtPasswordHelper.setText("******  You Must Input Password!  ******");
            txtPasswordHelper.setVisible(true);
        }

        if (passCheck) {
            if (dataValidation.passwordValidate(txtPassword.getText())) {
                passCheck = true;
                txtPasswordHelper.setVisible(false);
            } else {
                passCheck = false;
                txtPasswordHelper.setForeground(Color.red);
                txtPasswordHelper.setText("Password Must Be:4-16 characters with Digit and Uppercase!");
                txtPasswordHelper.setVisible(true);
            }
        }
        
        if (passCheck) {
            if (dataValidation.checkPresent(txtConfirmPass.getText())) {
                passCheck = true;
                txtConfirmPasHelper.setVisible(false);
            } else {
                passCheck = false;
                txtConfirmPasHelper.setForeground(Color.red);
                txtConfirmPasHelper.setText("******  You Must Re-Enter Password!  ******");
                txtConfirmPasHelper.setVisible(true);
            }
        }

        if (passCheck) {
            if (dataValidation.matchPassword(txtPassword.getText(), txtConfirmPass.getText())) {
                passCheck = true;
                txtConfirmPasHelper.setVisible(false);
            } else {
                passCheck = false;
                txtConfirmPasHelper.setForeground(Color.red);
                txtConfirmPasHelper.setText("Password Does Not Match!");
                txtConfirmPasHelper.setVisible(true);
            }
        }
        
        if (passCheck) {
            password = txtPassword.getText();
            sql = "UPDATE tblAccount "
                + "SET Password = '" + password + "' "
               +  "WHERE AccountNumber = " + accNumber;
            dbConnection.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Account : (" + getUsername() + ") Password Has Changed!");
            this.dispose();
            new Menu().setVisible(true);
        }

    }//GEN-LAST:event_lblResetPassBtnMouseClicked

    private String getUsername(){
        String rString = "";
         sql = "SELECT Username "
                    + "FROM tblAccount "
                    + "WHERE AccountNumber = " + accNumber;
            java.util.List<String> UsernameList = new java.util.ArrayList<>();
            try {
                rs = dbConnection.getRs(sql);
                while (rs.next()) {
                    UsernameList.add(rs.getString("Username"));
                }
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
            
            rString = UsernameList.get(0);
            return rString;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgGender;
    private javax.swing.ButtonGroup btgSelection;
    private javax.swing.JLabel lblBackBtnU;
    private javax.swing.JLabel lblBackBtnV;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBackgroundP;
    private javax.swing.JLabel lblBackgroundS;
    private javax.swing.JLabel lblConfirmPassP;
    private javax.swing.JLabel lblDOBV;
    private javax.swing.JLabel lblGenderV;
    private javax.swing.JLabel lblIDNumV;
    private javax.swing.JLabel lblIconP;
    private javax.swing.JLabel lblIconS;
    private javax.swing.JLabel lblIconU;
    private javax.swing.JLabel lblIconV;
    private javax.swing.JLabel lblMessageU;
    private javax.swing.JLabel lblNameV;
    private javax.swing.JLabel lblNextBtn;
    private javax.swing.JLabel lblPasswordP;
    private javax.swing.JLabel lblPhoneNumV;
    private javax.swing.JLabel lblResetPassBtn;
    private javax.swing.JLabel lblSurnameV;
    private javax.swing.JLabel lblTitle1P;
    private javax.swing.JLabel lblTitle1S;
    private javax.swing.JLabel lblTitle1U;
    private javax.swing.JLabel lblTitle1V;
    private javax.swing.JLabel lblTitle2V;
    private javax.swing.JLabel lblTitleP;
    private javax.swing.JLabel lblTitleS;
    private javax.swing.JLabel lblTitleU;
    private javax.swing.JLabel lblTitleV;
    private javax.swing.JLabel lblUsernameP;
    private javax.swing.JLabel lblUsernameU;
    private javax.swing.JLabel lblVerifyBtnV;
    private javax.swing.JLabel lblbackgroundV;
    private javax.swing.JPanel pnlChangePassword;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSelection;
    private javax.swing.JPanel pnlShowUsername;
    private javax.swing.JPanel pnlVerify;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.JRadioButton radMale;
    private javax.swing.JRadioButton radOther;
    private javax.swing.JRadioButton radPassword;
    private javax.swing.JRadioButton radUsername;
    private com.toedter.calendar.JDateChooser txtBirthDate;
    private javax.swing.JTextField txtConfirmPasHelper;
    private javax.swing.JTextField txtConfirmPass;
    private javax.swing.JTextField txtIDNumV;
    private javax.swing.JTextField txtNameV;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPasswordHelper;
    private javax.swing.JTextField txtPhoneNumV;
    private javax.swing.JTextField txtSurnameV;
    // End of variables declaration//GEN-END:variables
}//Forgot Class
