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
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import util.DataValidation;
import util.DatabaseConnection;

/*====================Imports=====================*/
public class CreateUser extends javax.swing.JFrame {//CreateUser Class

    /*====================Objects=====================*/
    private CardLayout cardLayout; //Cardlayout Change between PersonalInfo Panel and AccountInfo Panel
    private DataValidation dataValidation = new DataValidation();//Verify all the data inputed are correct
    private DatabaseConnection dbConnection = new DatabaseConnection();//Database Connection 
    /*====================Objects=====================*/

    /*====================Valiables=====================*/
    private boolean personInfoCheck = true;
    private boolean accountInfoCheck = true;

    private String personName = "";
    private String personSurname = "";
    private String personGender = "";
    private String personDOB = "";
    private String personIDNumber = "";
    private String personPhoneNumber = "";
    private String username = "";
    private String password = "";

    private String sql;
    /*====================Valiables=====================*/

    public CreateUser() {//CreateUser Class Constructor
        super("Sudoku Solver @Createuser");
        initComponents();
        /*
            Cards:
            PersonalInfo
            AccountInfo
         */
        cardLayout = (CardLayout) ((pnlMain.getLayout()));
        cardLayout.show(pnlMain, "PersonalInfo");
        // cardLayout.show(pnlMain, "AccountInfo");

    }//CreateUser Class Constructor

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgGender = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        pnlPersonInfo = new javax.swing.JPanel();
        lblIconPI = new javax.swing.JLabel();
        lblTitlePI = new javax.swing.JLabel();
        lblTitle2PI = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtNameHelper = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        txtSurnameHelper = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        radMale = new javax.swing.JRadioButton();
        radFemale = new javax.swing.JRadioButton();
        radOther = new javax.swing.JRadioButton();
        txtGenderHelper = new javax.swing.JTextField();
        lblBirthDate = new javax.swing.JLabel();
        txtBirthDate = new com.toedter.calendar.JDateChooser();
        txtBirthDateHelper = new javax.swing.JTextField();
        lblIDNumber = new javax.swing.JLabel();
        txtIDNum = new javax.swing.JTextField();
        txtIDNumHelper = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        txtPhoneNumberHelper = new javax.swing.JTextField();
        lblBackBtnPI = new javax.swing.JLabel();
        lblNextBtn = new javax.swing.JLabel();
        lblBackGroundPI = new javax.swing.JLabel();
        pnlAccInfo = new javax.swing.JPanel();
        lblIconAI = new javax.swing.JLabel();
        lblTitleAI = new javax.swing.JLabel();
        lblTitle2AI = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtUsernameHelper = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        pwdPassword = new javax.swing.JPasswordField();
        txtPasswordHelper = new javax.swing.JTextField();
        lblConfirmPass = new javax.swing.JLabel();
        pwdConfirmPass = new javax.swing.JPasswordField();
        txtConfirmPasHelper = new javax.swing.JTextField();
        tglShowPass = new javax.swing.JToggleButton();
        lblFinishBtn = new javax.swing.JLabel();
        lblBackGroundAI = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlMain.setLayout(new java.awt.CardLayout());

        pnlPersonInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconPI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Icon.png"))); // NOI18N
        pnlPersonInfo.add(lblIconPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 160, 130));

        lblTitlePI.setFont(new java.awt.Font("Rage Italic", 1, 68)); // NOI18N
        lblTitlePI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitlePI.setText("Sudoku Solver");
        lblTitlePI.setToolTipText("");
        pnlPersonInfo.add(lblTitlePI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 70));

        lblTitle2PI.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitle2PI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2PI.setText("Create User - Personal Infomation");
        pnlPersonInfo.add(lblTitle2PI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 800, 70));

        lblName.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblName.setText("Name                     :");
        pnlPersonInfo.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 220, 30));

        txtName.setBackground(new java.awt.Color(0, 0, 0));
        txtName.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtName.setToolTipText("Enter Your Name");
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtName.setOpaque(false);
        pnlPersonInfo.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 350, 30));

        txtNameHelper.setEditable(false);
        txtNameHelper.setBackground(new java.awt.Color(0, 0, 0));
        txtNameHelper.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtNameHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNameHelper.setToolTipText("");
        txtNameHelper.setBorder(null);
        txtNameHelper.setFocusable(false);
        txtNameHelper.setOpaque(false);
        pnlPersonInfo.add(txtNameHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 600, 30));

        lblSurname.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblSurname.setText("Surname                :");
        pnlPersonInfo.add(lblSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 230, 30));

        txtSurname.setBackground(new java.awt.Color(0, 0, 0));
        txtSurname.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtSurname.setToolTipText("Enter Your Surname");
        txtSurname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSurname.setOpaque(false);
        pnlPersonInfo.add(txtSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 350, 30));

        txtSurnameHelper.setEditable(false);
        txtSurnameHelper.setBackground(new java.awt.Color(0, 0, 0));
        txtSurnameHelper.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtSurnameHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSurnameHelper.setToolTipText("");
        txtSurnameHelper.setBorder(null);
        txtSurnameHelper.setFocusable(false);
        txtSurnameHelper.setOpaque(false);
        pnlPersonInfo.add(txtSurnameHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 600, 30));

        lblGender.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblGender.setText("Gender                   :");
        pnlPersonInfo.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 230, 30));

        btgGender.add(radMale);
        radMale.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        radMale.setText("Male");
        radMale.setToolTipText("Select Your Gender");
        radMale.setOpaque(false);
        pnlPersonInfo.add(radMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        btgGender.add(radFemale);
        radFemale.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        radFemale.setText("Female");
        radFemale.setToolTipText("Select Your Gender");
        radFemale.setOpaque(false);
        pnlPersonInfo.add(radFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        btgGender.add(radOther);
        radOther.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        radOther.setText("Other");
        radOther.setToolTipText("Select Your Gender");
        radOther.setOpaque(false);
        pnlPersonInfo.add(radOther, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, -1, -1));

        txtGenderHelper.setEditable(false);
        txtGenderHelper.setBackground(new java.awt.Color(0, 0, 0));
        txtGenderHelper.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtGenderHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGenderHelper.setToolTipText("");
        txtGenderHelper.setBorder(null);
        txtGenderHelper.setFocusable(false);
        txtGenderHelper.setOpaque(false);
        pnlPersonInfo.add(txtGenderHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 600, 30));

        lblBirthDate.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblBirthDate.setText("Date Of Birth          :");
        pnlPersonInfo.add(lblBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 230, 30));

        txtBirthDate.setBackground(new java.awt.Color(255, 255, 204));
        txtBirthDate.setForeground(new java.awt.Color(255, 255, 204));
        txtBirthDate.setToolTipText("Select Your Birthdate");
        txtBirthDate.setDateFormatString("yyyy-MM-dd");
        txtBirthDate.setFocusable(false);
        txtBirthDate.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtBirthDate.setOpaque(false);
        pnlPersonInfo.add(txtBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 350, 30));

        txtBirthDateHelper.setEditable(false);
        txtBirthDateHelper.setBackground(new java.awt.Color(0, 0, 0));
        txtBirthDateHelper.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtBirthDateHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBirthDateHelper.setToolTipText("");
        txtBirthDateHelper.setBorder(null);
        txtBirthDateHelper.setFocusable(false);
        txtBirthDateHelper.setOpaque(false);
        pnlPersonInfo.add(txtBirthDateHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 600, 30));

        lblIDNumber.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblIDNumber.setText("ID Number              :");
        pnlPersonInfo.add(lblIDNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 230, 30));

        txtIDNum.setBackground(new java.awt.Color(0, 0, 0));
        txtIDNum.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtIDNum.setToolTipText("Enter Your Identity Number(No Space)");
        txtIDNum.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtIDNum.setOpaque(false);
        pnlPersonInfo.add(txtIDNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, 350, 30));

        txtIDNumHelper.setEditable(false);
        txtIDNumHelper.setBackground(new java.awt.Color(0, 0, 0));
        txtIDNumHelper.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtIDNumHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDNumHelper.setToolTipText("");
        txtIDNumHelper.setBorder(null);
        txtIDNumHelper.setFocusable(false);
        txtIDNumHelper.setOpaque(false);
        pnlPersonInfo.add(txtIDNumHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 600, 30));

        lblPhoneNumber.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblPhoneNumber.setText("Phone Number       :");
        pnlPersonInfo.add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, 240, 30));

        txtPhoneNumber.setBackground(new java.awt.Color(0, 0, 0));
        txtPhoneNumber.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtPhoneNumber.setToolTipText("Enter Your Phone Number(No Space)");
        txtPhoneNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtPhoneNumber.setOpaque(false);
        pnlPersonInfo.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, 350, 30));

        txtPhoneNumberHelper.setEditable(false);
        txtPhoneNumberHelper.setBackground(new java.awt.Color(0, 0, 0));
        txtPhoneNumberHelper.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtPhoneNumberHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhoneNumberHelper.setToolTipText("");
        txtPhoneNumberHelper.setBorder(null);
        txtPhoneNumberHelper.setFocusable(false);
        txtPhoneNumberHelper.setOpaque(false);
        pnlPersonInfo.add(txtPhoneNumberHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 640, 600, 30));

        lblBackBtnPI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back1.png"))); // NOI18N
        lblBackBtnPI.setToolTipText("Back To Menu");
        lblBackBtnPI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackBtnPIMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackBtnPIMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackBtnPIMouseExited(evt);
            }
        });
        pnlPersonInfo.add(lblBackBtnPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 740, 250, -1));

        lblNextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Next1.png"))); // NOI18N
        lblNextBtn.setToolTipText("Proceed To Account Information");
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
        pnlPersonInfo.add(lblNextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 680, 250, -1));

        lblBackGroundPI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Background2.jpg"))); // NOI18N
        pnlPersonInfo.add(lblBackGroundPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 800));

        pnlMain.add(pnlPersonInfo, "PersonalInfo");

        pnlAccInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconAI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Icon.png"))); // NOI18N
        pnlAccInfo.add(lblIconAI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 160, 130));

        lblTitleAI.setFont(new java.awt.Font("Rage Italic", 1, 68)); // NOI18N
        lblTitleAI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleAI.setText("Sudoku Solver");
        lblTitleAI.setToolTipText("");
        pnlAccInfo.add(lblTitleAI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 70));

        lblTitle2AI.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitle2AI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2AI.setText("Create User - Account Infomation");
        pnlAccInfo.add(lblTitle2AI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 800, 70));

        lblUsername.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblUsername.setText("Username               :");
        pnlAccInfo.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 230, 30));

        txtUsername.setBackground(new java.awt.Color(0, 0, 0));
        txtUsername.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtUsername.setToolTipText("Username Must Be 4-16 Characters Long(No Special Character)");
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUsername.setOpaque(false);
        pnlAccInfo.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 350, 30));

        txtUsernameHelper.setEditable(false);
        txtUsernameHelper.setBackground(new java.awt.Color(0, 0, 0));
        txtUsernameHelper.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtUsernameHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsernameHelper.setToolTipText("");
        txtUsernameHelper.setBorder(null);
        txtUsernameHelper.setFocusable(false);
        txtUsernameHelper.setOpaque(false);
        pnlAccInfo.add(txtUsernameHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 590, 50));

        lblPassword.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblPassword.setText("Password               :");
        pnlAccInfo.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 230, 30));

        pwdPassword.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        pwdPassword.setToolTipText("Password Must Be:4-16 characters with Digit and Uppercase");
        pwdPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        pwdPassword.setOpaque(false);
        pnlAccInfo.add(pwdPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 350, 30));

        txtPasswordHelper.setEditable(false);
        txtPasswordHelper.setBackground(new java.awt.Color(0, 0, 0));
        txtPasswordHelper.setFont(new java.awt.Font("Arial", 0, 21)); // NOI18N
        txtPasswordHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPasswordHelper.setToolTipText("");
        txtPasswordHelper.setBorder(null);
        txtPasswordHelper.setFocusable(false);
        txtPasswordHelper.setOpaque(false);
        pnlAccInfo.add(txtPasswordHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 590, 50));

        lblConfirmPass.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblConfirmPass.setText("Confirm Password :");
        pnlAccInfo.add(lblConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 230, 30));

        pwdConfirmPass.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        pwdConfirmPass.setToolTipText("Enter Your Password Again");
        pwdConfirmPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        pwdConfirmPass.setOpaque(false);
        pnlAccInfo.add(pwdConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 350, 30));

        txtConfirmPasHelper.setEditable(false);
        txtConfirmPasHelper.setBackground(new java.awt.Color(0, 0, 0));
        txtConfirmPasHelper.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtConfirmPasHelper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtConfirmPasHelper.setToolTipText("");
        txtConfirmPasHelper.setBorder(null);
        txtConfirmPasHelper.setFocusable(false);
        txtConfirmPasHelper.setOpaque(false);
        pnlAccInfo.add(txtConfirmPasHelper, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 590, 50));

        tglShowPass.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tglShowPass.setText("Show Password");
        tglShowPass.setToolTipText("Show The Password (Click Three Times)");
        tglShowPass.setContentAreaFilled(false);
        tglShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglShowPassActionPerformed(evt);
            }
        });
        pnlAccInfo.add(tglShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, -1, -1));

        lblFinishBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Finish1.png"))); // NOI18N
        lblFinishBtn.setToolTipText("Finish Create New User");
        lblFinishBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFinishBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFinishBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblFinishBtnMouseExited(evt);
            }
        });
        pnlAccInfo.add(lblFinishBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, 260, -1));

        lblBackGroundAI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Background2.jpg"))); // NOI18N
        pnlAccInfo.add(lblBackGroundAI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 800));

        pnlMain.add(pnlAccInfo, "AccountInfo");

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

    private void tglShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglShowPassActionPerformed
        char orgPassword1 = pwdPassword.getEchoChar();
        char orgPassword2 = pwdConfirmPass.getEchoChar();
        tglShowPass.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    pwdPassword.setEchoChar((char) 0);
                    pwdConfirmPass.setEchoChar((char) 0);
                } else {
                    pwdPassword.setEchoChar(orgPassword1);
                    pwdConfirmPass.setEchoChar(orgPassword2);
                }
            }
        });
    }//GEN-LAST:event_tglShowPassActionPerformed

    private void lblBackBtnPIMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnPIMouseEntered
        lblBackBtnPI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back2.png")));
    }//GEN-LAST:event_lblBackBtnPIMouseEntered

    private void lblBackBtnPIMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnPIMouseExited
        lblBackBtnPI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Back1.png")));
    }//GEN-LAST:event_lblBackBtnPIMouseExited

    private void lblBackBtnPIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackBtnPIMouseClicked
        //Get Option Seleceted  0 = yes, 1 = no
        int result = JOptionPane.showConfirmDialog(null, "Do You Want To Proceed?(You Will Lose All The Input!)",
                "Select An Option From The Following...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (result == 0) {
            this.dispose();
            new Menu().setVisible(true);
        }
    }//GEN-LAST:event_lblBackBtnPIMouseClicked

    private void lblNextBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextBtnMouseClicked
        /*
            personInfoCheck Validate if all the fields has valid input
         */

        /*==================== Check Name =====================*/
        if (dataValidation.checkPresent(txtName.getText())) {
            personInfoCheck = true;
            txtNameHelper.setVisible(false);
        } else {
            personInfoCheck = false;
            txtNameHelper.setForeground(Color.red);
            txtNameHelper.setText("********      You Need To Input Your Name!      ********");
            txtNameHelper.setVisible(true);
        }
        /*==================== Check Name =====================*/

        /*==================== Check Surname =====================*/
        if (dataValidation.checkPresent(txtSurname.getText())) {
            personInfoCheck = true;
            txtSurnameHelper.setVisible(false);
        } else {
            personInfoCheck = false;
            txtSurnameHelper.setForeground(Color.red);
            txtSurnameHelper.setText("*******     You Need To Input Your Surname!     *******");
            txtSurnameHelper.setVisible(true);
        }
        /*==================== Check Surname =====================*/

        /*==================== Check  Gender =====================*/
        if (!radMale.isSelected() && !radFemale.isSelected() && !radOther.isSelected()) {
            personInfoCheck = false;
            txtGenderHelper.setForeground(Color.red);
            txtGenderHelper.setText("*******      You Need To Select Your Gender!      *******");
            txtGenderHelper.setVisible(true);
        } else {
            personInfoCheck = true;
            txtGenderHelper.setVisible(false);
        }
        /*==================== Check  Gender =====================*/

        /*==================== Check Date Of Birth =====================*/
        String invalidDate = "com.toedter.calendar.JCalendar[JCalendar,0,0,0x0,invalid,layout=java.awt.BorderLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]";
        if (txtBirthDate.getJCalendar().toString().contentEquals(invalidDate)) {
            personInfoCheck = false;
            txtBirthDateHelper.setForeground(Color.red);
            txtBirthDateHelper.setText("*******   You need to select your Date Of Birth!   *******");
            txtBirthDateHelper.setVisible(true);
        } else {
            personInfoCheck = true;
            txtBirthDateHelper.setVisible(false);
        }
        /*==================== Check Date Of Birth =====================*/


        /*====================  Check ID Number =====================*/
        if (!dataValidation.checkPresent(txtIDNum.getText())) {
            personInfoCheck = false;
            txtIDNumHelper.setForeground(Color.red);
            txtIDNumHelper.setText("*******     You need to input your ID Number!     *******");
            txtIDNumHelper.setVisible(true);
        } else {
            if (txtIDNum.getText().length() != 13) {
                personInfoCheck = false;
                txtIDNumHelper.setForeground(Color.red);
                txtIDNumHelper.setText("*******      ID Number Must Be 13 Digits!      *******");
                txtIDNumHelper.setVisible(true);
            } else {
                if (txtIDNum.getText().matches("[0-9]+") == false) {
                    personInfoCheck = false;
                    txtIDNumHelper.setForeground(Color.red);
                    txtIDNumHelper.setText("*******     ID Number Only Contain Numbers!     *******");
                    txtIDNumHelper.setVisible(true);
                } else {
                    personInfoCheck = true;
                    txtIDNumHelper.setVisible(false);
                }
            }
        }
        /*====================  Check ID Number =====================*/


        /*====================  Check Phone Number =====================*/
        if (!dataValidation.checkPresent(txtPhoneNumber.getText())) {
            personInfoCheck = false;
            txtPhoneNumberHelper.setForeground(Color.red);
            txtPhoneNumberHelper.setText("*******        You Must Input Phone Number!        *******");
            txtPhoneNumberHelper.setVisible(true);
        } else {
            String passwordRegex = "^(\\+27|0)[1|6-8][0-9]{8}$";//Password Regex
            Pattern passwordPattern = Pattern.compile(passwordRegex);//Compile Password Regexs
            Matcher m = passwordPattern.matcher(String.valueOf(txtPhoneNumber.getText()));//Match Input Phone with Pattern
            if (!m.matches()) {//Determine if Input Phone match the pattern
                personInfoCheck = false;
                txtPhoneNumberHelper.setForeground(Color.red);
                txtPhoneNumberHelper.setText("******  You Must Input Valid Phone Number!  ******");
                txtPhoneNumberHelper.setVisible(true);
            } else {
                personInfoCheck = true;
                txtPhoneNumberHelper.setVisible(false);
            }
        }
        /*====================  Check Phone Number =====================*/


        /*==================== Insert Into Database  =====================*/
        if (personInfoCheck) {
            personName = txtName.getText();

            personSurname = txtSurname.getText();

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

            personIDNumber = String.valueOf(txtIDNum.getText());

            personPhoneNumber = String.valueOf(txtPhoneNumber.getText());

            sql = "INSERT INTO tblUserInfomation(PersonName,PersonSurname,PersonGender,PersonDOB,PersonIDNumber,PersonPhone) "
                    + "VALUES('" + personName + "','" + personSurname + "','" + personGender + "',#" + personDOB + "#,'" + personIDNumber + "','" + personPhoneNumber + "')";
            //System.out.println(sql);
            dbConnection.executeUpdate(sql); //Execute Query 
            JOptionPane.showMessageDialog(this, "Personal Infomation Saved To Database Successfully!!!");

            cardLayout.show(pnlMain, "AccountInfo");
            accountInfoCheck = false;
        }
        /*==================== Insert Into Database  =====================*/

    }//GEN-LAST:event_lblNextBtnMouseClicked

    private void lblNextBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextBtnMouseEntered
        lblNextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Next2.png")));
    }//GEN-LAST:event_lblNextBtnMouseEntered

    private void lblNextBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextBtnMouseExited
        lblNextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Next1.png")));
    }//GEN-LAST:event_lblNextBtnMouseExited

    private void lblFinishBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFinishBtnMouseClicked

        /*====================  Check Username =====================*/
        if (dataValidation.checkPresent(txtUsername.getText())) {
            accountInfoCheck = true;
            txtUsernameHelper.setVisible(false);
        } else {
            accountInfoCheck = false;
            txtUsernameHelper.setForeground(Color.red);
            txtUsernameHelper.setText("******  You Must Input Username!  ******");
            txtUsernameHelper.setVisible(true);
        }

        if (accountInfoCheck) {
            if (dataValidation.usernameValidate(txtUsername.getText())) {
                accountInfoCheck = true;
                txtUsernameHelper.setVisible(false);
            } else {
                accountInfoCheck = false;
                txtUsernameHelper.setForeground(Color.red);
                txtUsernameHelper.setText("Username Must Be 4-16 Characters Long(No Special Character)!");
                txtUsernameHelper.setVisible(true);
            }
        }

        if (accountInfoCheck) {
            if (dbConnection.findUser(txtUsername.getText())) {
                accountInfoCheck = false;
                txtUsernameHelper.setForeground(Color.red);
                txtUsernameHelper.setText("Username Already Exist!");
                txtUsernameHelper.setVisible(true);
            } else {
                accountInfoCheck = true;
                txtUsernameHelper.setVisible(false);
            }
        }
        /*====================  Check Username =====================*/

         /*====================  Check Password =====================*/
        if (accountInfoCheck) {
            if (dataValidation.checkPresent(String.valueOf(pwdPassword.getPassword()))) {
                accountInfoCheck = true;
                txtPasswordHelper.setVisible(false);
            } else {
                accountInfoCheck = false;
                txtPasswordHelper.setForeground(Color.red);
                txtPasswordHelper.setText("******  You Must Input Password!  ******");
                txtPasswordHelper.setVisible(true);
            }
        }

        if (accountInfoCheck) {
            if (dataValidation.passwordValidate(String.valueOf(pwdPassword.getPassword()))) {
                accountInfoCheck = true;
                txtPasswordHelper.setVisible(false);
            } else {
                accountInfoCheck = false;
                txtPasswordHelper.setForeground(Color.red);
                txtPasswordHelper.setText("Password Must Be:4-16 characters with Digit and Uppercase!");
                txtPasswordHelper.setVisible(true);
            }
        }
        /*====================  Check Password =====================*/

        /*====================  Check Password match=====================*/
        if (accountInfoCheck) {
            if (dataValidation.matchPassword(String.valueOf(pwdPassword.getPassword()), String.valueOf(pwdConfirmPass.getPassword()))) {
                accountInfoCheck = true;
                txtConfirmPasHelper.setVisible(false);
            } else {
                accountInfoCheck = false;
                txtConfirmPasHelper.setForeground(Color.red);
                txtConfirmPasHelper.setText("Password Does Not Match!");
                txtConfirmPasHelper.setVisible(true);
            }
        }
        /*====================  Check Password match=====================*/

        if (accountInfoCheck) {
            username = txtUsername.getText();

            password = String.valueOf(pwdPassword.getPassword());

            sql = "INSERT INTO tblAccount(Username,Password,BestTime) "
                    + "VALUES('" + username + "','" + password + "'," + "'99:99:99')";

            // System.out.println(sql);
            dbConnection.executeUpdate(sql); //Execute Query 
            JOptionPane.showMessageDialog(this, "Account Infomation Saved To Database Successfully!!!");

            this.dispose();
            new Menu().setVisible(true);
        }

    }//GEN-LAST:event_lblFinishBtnMouseClicked

    private void lblFinishBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFinishBtnMouseEntered
        lblFinishBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Finish2.png")));
    }//GEN-LAST:event_lblFinishBtnMouseEntered

    private void lblFinishBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFinishBtnMouseExited
        lblFinishBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Finish1.png")));
    }//GEN-LAST:event_lblFinishBtnMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgGender;
    private javax.swing.JLabel lblBackBtnPI;
    private javax.swing.JLabel lblBackGroundAI;
    private javax.swing.JLabel lblBackGroundPI;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblFinishBtn;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIDNumber;
    private javax.swing.JLabel lblIconAI;
    private javax.swing.JLabel lblIconPI;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNextBtn;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTitle2AI;
    private javax.swing.JLabel lblTitle2PI;
    private javax.swing.JLabel lblTitleAI;
    private javax.swing.JLabel lblTitlePI;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlAccInfo;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPersonInfo;
    private javax.swing.JPasswordField pwdConfirmPass;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.JRadioButton radMale;
    private javax.swing.JRadioButton radOther;
    private javax.swing.JToggleButton tglShowPass;
    private com.toedter.calendar.JDateChooser txtBirthDate;
    private javax.swing.JTextField txtBirthDateHelper;
    private javax.swing.JTextField txtConfirmPasHelper;
    private javax.swing.JTextField txtGenderHelper;
    private javax.swing.JTextField txtIDNum;
    private javax.swing.JTextField txtIDNumHelper;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameHelper;
    private javax.swing.JTextField txtPasswordHelper;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPhoneNumberHelper;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtSurnameHelper;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsernameHelper;
    // End of variables declaration//GEN-END:variables
}
