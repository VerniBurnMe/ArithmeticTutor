//Verni Eal Tapang - BSIT 2H-G1
//Programmer
//Copyright © 2015 

package ArithmeticTutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnterName extends JFrame implements ActionListener{
    
    Font f1 = new Font("Tahoma", Font.BOLD, 20);
    JPanel pnl = new JPanel();
    JLabel lbl1 = new JLabel();
    
    JPanel pnl1 = new JPanel();
    JPanel pnl3 = new JPanel();
    JLabel lblName = new JLabel("          ENTER YOUR NAME          ");
    JTextField txtName = new JTextField();
    
    JPanel pnl2 = new JPanel();
    JButton btnOk = new JButton("OK");
    JButton btnCancel = new JButton("CANCEL");
    
    static String name = new String();
    
    EnterName()
    {
        setVisible(true);
        setSize(370,180);
        setResizable(false);
        setTitle(""+OperatorSelection.opp);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(pnl, BorderLayout.NORTH);
            pnl.setLayout(new FlowLayout(FlowLayout.CENTER));
            pnl.setBackground(Color.gray);
            pnl.add(lbl1);
                lbl1.setFont(f1);
                lbl1.setForeground(Color.white);
                lbl1.setText("THIS IS A "+OperatorSelection.opp.toUpperCase());
                
        add(pnl1, BorderLayout.CENTER);
            pnl1.setLayout(new FlowLayout(FlowLayout.CENTER));
            pnl1.setBackground(Color.gray);
            pnl1.add(pnl3);
                pnl3.setLayout(new GridLayout(2,1));
                pnl3.setBackground(Color.gray);
                pnl3.add(lblName);
                    lblName.setForeground(Color.white);
                pnl3.add(txtName);
        
        add(pnl2, BorderLayout.SOUTH);
            pnl2.setLayout(new GridLayout (1,2));
            pnl2.setBackground(Color.gray);
            pnl2.add(btnOk);
            pnl2.add(btnCancel);
            
            btnOk.addActionListener(this);
            btnCancel.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        Object src = new Object();
        src = a.getSource();
        
        if(src.equals(btnOk))
        {
            String chckName = txtName.getText();
            if(chckName.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter a name", ""+OperatorSelection.opp, JOptionPane.ERROR_MESSAGE, null);
            }
            else
            {
                name = txtName.getText();
                RowCol x = new RowCol();
                dispose();
            }
        }
        else if(src.equals(btnCancel))
        {
            int ans = JOptionPane.showConfirmDialog(null, "Are you sure? ", ""+OperatorSelection.opp, 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(ans==0)
            {
                OperatorSelection x = new OperatorSelection();
                dispose();
            }
        }
    }
    
    public static void main(String[] args) {
        EnterName myClass = new EnterName();
        myClass.setLocationRelativeTo(null);
        myClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

