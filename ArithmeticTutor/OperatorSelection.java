//Verni Eal Tapang - BSIT 2H-G1
//Programmer
//Copyright © 2015 

package ArithmeticTutor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OperatorSelection extends JFrame implements ActionListener{
    
    JPanel pnl1 = new JPanel();
    JLabel title = new JLabel("SELECT OPERATION");
    Font f1 = new Font("Tahoma", Font.BOLD, 16);
    Font f2 = new Font("Century Gothic", Font.ITALIC, 18);
    
    JPanel pnlBtn = new JPanel();
    JPanel pnl = new JPanel();
    JButton btnAdd = new JButton();
    JButton btnSub = new JButton();
    JButton btnMul = new JButton();
    JButton btnDiv = new JButton();
    ImageIcon icoAdd = new ImageIcon("C:\\Users\\VEFT\\Documents\\NetBeansProjects\\TapangVerniEal\\src\\ArithmeticTutor\\rsrc\\plus.png");
    ImageIcon icoSub = new ImageIcon("C:\\Users\\VEFT\\Documents\\NetBeansProjects\\TapangVerniEal\\src\\ArithmeticTutor\\rsrc\\minus.png");
    ImageIcon icoMul = new ImageIcon("C:\\Users\\VEFT\\Documents\\NetBeansProjects\\TapangVerniEal\\src\\ArithmeticTutor\\rsrc\\mul.png");
    ImageIcon icoDiv = new ImageIcon("C:\\Users\\VEFT\\Documents\\NetBeansProjects\\TapangVerniEal\\src\\ArithmeticTutor\\rsrc\\div.png");
    
    JPanel pnlWlcm = new JPanel();
    JLabel wlcm = new JLabel("WELCOME TO ARITHMETIC TUTOR");
    
    static String opp = new String();
    static String sym = new String();
    
    OperatorSelection()
    {
        setSize(500,170);
        setVisible(true);
        setResizable(false);
        setTitle("Arithmetic Tutor");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
                
        add(pnlWlcm, BorderLayout.NORTH);
            pnlWlcm.add(wlcm);
            pnlWlcm.setLayout(new FlowLayout(FlowLayout.CENTER));
            pnlWlcm.setBackground(Color.gray);
                wlcm.setFont(new Font("Tahoma", Font.BOLD, 28));
                wlcm.setForeground(Color.white);
        
        add(pnl1, BorderLayout.CENTER);
            pnl1.add(title);
                pnl1.setLayout(new FlowLayout(FlowLayout.CENTER));
                pnl1.setBackground(Color.gray);
                title.setFont(f1);
                title.setForeground(Color.white);
                
        add(pnl, BorderLayout.SOUTH);
            pnl.add(pnlBtn);
            pnl.setLayout(new FlowLayout(FlowLayout.CENTER));
            pnl.setBackground(Color.gray);
            pnlBtn.setLayout(new GridLayout(1,4,5,0));
                pnlBtn.setBackground(Color.gray);
            pnlBtn.add(btnAdd);
                btnAdd.setIcon(icoAdd);
            pnlBtn.add(btnSub);
                btnSub.setIcon(icoSub);
            pnlBtn.add(btnMul);
                btnMul.setIcon(icoMul);
            pnlBtn.add(btnDiv);
                btnDiv.setIcon(icoDiv);
                
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
    }
    public void actionPerformed(ActionEvent a)
    {
        Object src = new Object();
        src = a.getSource();
        
        if(src.equals(btnAdd))
        {
            opp = "Addition Tutor";
            sym = "+";
            EnterName x = new EnterName();
            dispose();
        }
        if(src.equals(btnSub))
        {
            opp = "Subtraction Tutor";
            sym = "-";
            EnterName x = new EnterName();
            dispose();
        }
        if(src.equals(btnMul))
        {
            opp = "Multiplication Tutor";
            sym = "*";
            EnterName x = new EnterName();
            dispose();
        }
        if(src.equals(btnDiv))
        {
            opp = "Division Tutor";
            sym = "/";
            EnterName x = new EnterName();
            dispose();
        }
    }
    
    public static void main(String[] args) {
        OperatorSelection myClass = new OperatorSelection();
        myClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myClass.setLocationRelativeTo(null);
    }
}
