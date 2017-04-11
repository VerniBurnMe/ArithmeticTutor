//Verni Eal Tapang - BSIT 2H-G1
//Programmer
//Copyright © 2015 

package ArithmeticTutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RowCol extends JFrame implements ActionListener{
    
    Font f1 = new Font("Tahoma", Font.BOLD, 20);
    Font f2 = new Font("Tahoma", Font.BOLD, 30);
    JPanel pnl1 = new JPanel();
    JPanel pnl2 = new JPanel();
    JLabel lbl1 = new JLabel("PLEASE ENTER ROW AND COLUMN");
    JLabel lblNote = new JLabel("                        "
                              + "           NOTE: RANGE 1-10 ONLY!");
    
    JPanel pnl3 = new JPanel();
    JPanel pnl4 = new JPanel();
    JLabel lblRow = new JLabel("Row:");
    JLabel lblCol = new JLabel("Col:");
    JTextField txtRow = new JTextField();
    JTextField txtCol = new JTextField();
    
    JPanel pnl5 = new JPanel();
    JButton btnEnter = new JButton("          ENTER          ");
    
    static int row=0, col=0;
    
    RowCol()
    {
        setVisible(true);
        setSize(400,230);
        setResizable(false);
        setTitle(""+OperatorSelection.opp);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(pnl1, BorderLayout.NORTH);
            pnl1.setLayout(new FlowLayout(FlowLayout.CENTER));
            pnl1.setBackground(Color.gray);
            pnl1.add(pnl2);
                pnl2.setLayout(new GridLayout(2,1));
                pnl2.setBackground(Color.gray);
                pnl2.add(lbl1);
                    lbl1.setFont(f1);
                    lbl1.setForeground(Color.white);
                pnl2.add(lblNote);
                    lblNote.setForeground(Color.white);
                
        add(pnl3, BorderLayout.CENTER);
            pnl3.setLayout(new FlowLayout(FlowLayout.CENTER));
            pnl3.setBackground(Color.gray);
            pnl3.add(pnl4);
                pnl4.setLayout(new GridLayout(2,2));
                pnl4.setBackground(Color.gray);
                pnl4.add(lblRow);
                    lblRow.setFont(f2);
                pnl4.add(txtRow);
                    txtRow.setFont(f2);
                
                pnl4.add(lblCol);
                    lblCol.setFont(f2);
                pnl4.add(txtCol);
                    txtCol.setFont(f2);
                    
        add(pnl5, BorderLayout.SOUTH);
            pnl5.setLayout(new FlowLayout(FlowLayout.CENTER));
            pnl5.setBackground(Color.gray);
            pnl5.add(btnEnter);
                btnEnter.setFont(f2);
                
        btnEnter.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        Object src = new Object();
        src = a.getSource();
        
        if(src.equals(btnEnter))
        {
            String rowS = txtRow.getText();
            String colS = txtCol.getText();
            
            if(rowS.equals("")||colS.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter row & column", ""+OperatorSelection.opp, JOptionPane.ERROR_MESSAGE, null);
            }
            else if(rowS.contains("a")||colS.contains("a"))
            {
                JOptionPane.showMessageDialog(null, "Row & column cannot contain letter", ""+OperatorSelection.opp, JOptionPane.ERROR_MESSAGE, null);
            }
            else
            {
                row = Integer.parseInt(txtRow.getText());
                col = Integer.parseInt(txtCol.getText());

                if(row>10)
                {
                    JOptionPane.showMessageDialog(null, "Invalid row", ""+OperatorSelection.opp, JOptionPane.ERROR_MESSAGE, null);
                    txtRow.setText("");
                }
                else if(col>10)
                {
                    JOptionPane.showMessageDialog(null, "Invalid column", ""+OperatorSelection.opp, JOptionPane.ERROR_MESSAGE, null);
                    txtCol.setText("");
                }
                else if(row>10||col>10)
                {
                    JOptionPane.showMessageDialog(null, "Invalid row & column", ""+OperatorSelection.opp, JOptionPane.ERROR_MESSAGE, null);
                    txtRow.setText("");
                    txtCol.setText("");
                }
                else if((row<=1)||(col<=1))
                {
                    JOptionPane.showMessageDialog(null, "Invalid row & column", ""+OperatorSelection.opp, JOptionPane.ERROR_MESSAGE, null);
                    txtRow.setText("");
                    txtCol.setText("");
                }
                else
                {
                    Table x = new Table();
                    dispose();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        RowCol myClass = new RowCol();
        myClass.setLocationRelativeTo(null);
        myClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
