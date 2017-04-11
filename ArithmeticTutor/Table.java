//Verni Eal Tapang - BSIT 2H-G1
//Programmer
//Copyright © 2015 

package ArithmeticTutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Table extends JFrame implements ActionListener{
    
    Font f1 = new Font("Tahoma", Font.BOLD, 35);
    Font f2 = new Font("Century Gothic", Font.ITALIC, 18);
    JPanel pnl1 = new JPanel();
    JPanel pnl2 = new JPanel();
    JPanel pnlOpp = new JPanel();
    JPanel pnlWlcm = new JPanel();
    JLabel lblWlcm = new JLabel();
    JLabel lblOpp = new JLabel();
    
    JPanel pnl3 = new JPanel();
    JTextField tbl[][] = new JTextField[RowCol.row][RowCol.col];
    
    JPanel pnl4 = new JPanel();
    JButton btnTryAgain = new JButton("Try Again");
    JButton btnShowAnswer = new JButton("Show Answer");
    JButton btnCheckAnswer = new JButton("Check Answer");
    JButton btnExit = new JButton("Exit");
    
    Table()
    {
        setSize(600,600);
        setVisible(true);
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
                    pnl2.add(pnlWlcm);
                        pnlWlcm.setLayout(new FlowLayout(FlowLayout.CENTER));
                        pnlWlcm.setBackground(Color.gray);
                        pnlWlcm.add(lblWlcm);
                            lblWlcm.setFont(f2);
                            lblWlcm.setForeground(Color.white);
                            lblWlcm.setText("WELCOME "+EnterName.name.toUpperCase());
                    pnl2.add(pnlOpp);
                        pnlOpp.setLayout(new FlowLayout(FlowLayout.CENTER));
                        pnlOpp.setBackground(Color.gray);
                        pnlOpp.add(lblOpp);
                            lblOpp.setFont(f1);
                            lblOpp.setForeground(Color.white);
                            lblOpp.setText(""+OperatorSelection.opp.toUpperCase());
                         
                            
        add(pnl3, BorderLayout.CENTER);
        pnl3.setLayout(new GridLayout(RowCol.row, RowCol.col));
        for(int i=0; i<RowCol.row; i++)
        {
            for(int j=0; j<RowCol.col; j++)
            {
                tbl[i][j] = new JTextField();
                tbl[i][j].setBorder(LineBorder.createBlackLineBorder());
                pnl3.add(tbl[i][j]);
                tbl[i][0].setBackground(Color.yellow);
                tbl[0][j].setBackground(Color.yellow);
                tbl[i][j].setFont(new Font("Century Gothic", Font.PLAIN, 20));
                tbl[i][j].setHorizontalAlignment(JTextField.CENTER);
            }
        }
           tbl[0][0].setForeground(Color.white);
           tbl[0][0].setBackground(Color.DARK_GRAY);
           tbl[0][0].setEditable(false);
           tbl[0][0].setText(""+OperatorSelection.sym);
           
        add(pnl4, BorderLayout.SOUTH);
            pnl4.setLayout(new GridLayout(1,4));
            pnl4.setBackground(Color.gray);
            pnl4.add(btnTryAgain);
            pnl4.add(btnShowAnswer);
            pnl4.add(btnCheckAnswer);
            pnl4.add(btnExit);
            
            btnTryAgain.addActionListener(this);
            btnShowAnswer.addActionListener(this);
            btnCheckAnswer.addActionListener(this);
            btnExit.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        Object src = new Object();
        src = a.getSource();
        
        if(src.equals(btnTryAgain))
        {
            Table x = new Table();
            dispose();
        }
        else if(src.equals(btnShowAnswer))
        {
            int temp=0;
            for(int i=1; i<RowCol.row; i++)
            {
                for(int j=1; j<RowCol.col; j++)
                {
                    if((tbl[0][j].getText().equals(""))||(tbl[i][0].getText().equals("")))
                    {
                        temp++;
                        break;
                    }
                }
            }
            if(temp>0)
                JOptionPane.showMessageDialog(null, "Please fill all the yellow boxes", ""+OperatorSelection.opp, JOptionPane.ERROR_MESSAGE, null);
            else if(temp==0)
            {
                int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to show answer?", ""+OperatorSelection.opp, 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(ans==0)
                {
                    btnShowAnswer.setEnabled(false);
                    btnCheckAnswer.setEnabled(false);
                    if(OperatorSelection.sym.equals("+"))
                    {
                        addTable();
                    }
                    else if(OperatorSelection.sym.equals("-"))
                    {
                        subTable();
                    }
                    else if(OperatorSelection.sym.equals("*"))
                    {
                        mulTable();
                    }
                    else if(OperatorSelection.sym.equals("/"))
                    {
                        divTable();
                    }
                }
            }
        }
        else if(src.equals(btnCheckAnswer))
        {
            int temp=0;
            for(int i=1; i<RowCol.row; i++)
            {
                for(int j=1; j<RowCol.col; j++)
                {
                    if((tbl[0][j].getText().equals(""))||(tbl[i][0].getText().equals("")))
                    {
                        temp++;
                        break;
                    }
                }
            }
            if(temp>0)
                JOptionPane.showMessageDialog(null, "Please fill all the yellow boxes", ""+OperatorSelection.opp, JOptionPane.ERROR_MESSAGE, null);
            else if(temp==0)
            {
                if(OperatorSelection.sym.equals("+"))
                {
                    addCheckAnswer();
                }
                else if(OperatorSelection.sym.equals("-"))
                {
                    subCheckAnswer();
                }
                else if(OperatorSelection.sym.equals("*"))
                {
                    mulCheckAnswer();
                }
                else if(OperatorSelection.sym.equals("/"))
                {
                    divCheckAnswer();
                }
            }
        }
        else if(src.equals(btnExit))
        {
            int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", ""+OperatorSelection.opp, 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(ans==0)
                System.exit(0);
        }
    }
    
    public void addTable()
    {
        for(int i=1; i<RowCol.row; i++)
        {
            for(int j=1; j<RowCol.col; j++)
            {
                if(tbl[i][j].getText().equals(""))
                {
                    tbl[i][j].setText(""+(Integer.parseInt(tbl[i][0].getText())+Integer.parseInt(tbl[0][j].getText())));
                    tbl[i][j].setForeground(Color.yellow);
                    tbl[i][j].setBackground(Color.gray);
                    tbl[i][j].setEditable(false);
                }
            }
        }
    }
    public void subTable()
    {
        for(int i=1; i<RowCol.row; i++)
        {
            for(int j=1; j<RowCol.col; j++)
            {
                if(tbl[i][j].getText().equals(""))
                {
                    tbl[i][j].setText(""+(Integer.parseInt(tbl[i][0].getText())-Integer.parseInt(tbl[0][j].getText())));
                    tbl[i][j].setForeground(Color.yellow);
                    tbl[i][j].setBackground(Color.gray);
                    tbl[i][j].setEditable(false);
                }
            }
        }
    }
    public void mulTable()
    {
        for(int i=1; i<RowCol.row; i++)
        {
            for(int j=1; j<RowCol.col; j++)
            {
                if(tbl[i][j].getText().equals(""))
                {
                    tbl[i][j].setText(""+(Integer.parseInt(tbl[i][0].getText())*Integer.parseInt(tbl[0][j].getText())));
                    tbl[i][j].setForeground(Color.yellow);
                    tbl[i][j].setBackground(Color.gray);
                    tbl[i][j].setEditable(false);
                }
            }
        }
    }
    public void divTable()
    {
        for(int i=1; i<RowCol.row; i++)
        {
            for(int j=1; j<RowCol.col; j++)
            {
                if(tbl[i][j].getText().equals(""))
                {
                    tbl[i][j].setText(""+(Integer.parseInt(tbl[i][0].getText())/Integer.parseInt(tbl[0][j].getText())));
                    tbl[i][j].setForeground(Color.yellow);
                    tbl[i][j].setBackground(Color.gray); 
                    tbl[i][j].setEditable(false);
                }
            }
        }
    }
    
    public void addCheckAnswer()
    {
        for(int i=1; i<RowCol.row; i++)
        {
            for(int j=1; j<RowCol.col; j++)
            {
                int crcAns=0;
                if((tbl[0][j].getText().equals(""))||(tbl[i][0].getText().equals("")))
                {
                    tbl[i][j].setBackground(Color.white);
                    break;
                }
                crcAns = Integer.parseInt(tbl[0][j].getText()) + Integer.parseInt(tbl[i][0].getText());
                String crcStr = new String();
                crcStr = Integer.toString(crcAns);
                if(tbl[i][j].getText().equals(crcStr))
                {
                    tbl[i][j].setForeground(Color.black);
                    tbl[i][j].setBackground(Color.lightGray);
                }
                else if(tbl[i][j].getText().equals(""))
                {
                    tbl[i][j].setBackground(Color.white);
                }
                else
                {
                    tbl[i][j].setForeground(Color.red);
                    tbl[i][j].setBackground(Color.lightGray);
                }
            }
        }
    }
    public void subCheckAnswer()
    {
        for(int i=1; i<RowCol.row; i++)
        {
            for(int j=1; j<RowCol.col; j++)
            {
                int crcAns=0;
                if((tbl[0][j].getText().equals(""))||(tbl[i][0].getText().equals("")))
                {
                    tbl[i][j].setBackground(Color.white);
                    break;
                }
                crcAns = Integer.parseInt(tbl[0][j].getText()) - Integer.parseInt(tbl[i][0].getText());
                String crcStr = new String();
                crcStr = Integer.toString(crcAns);
                if(tbl[i][j].getText().equals(crcStr))
                {
                    tbl[i][j].setForeground(Color.black);
                    tbl[i][j].setBackground(Color.lightGray);
                }
                else if(tbl[i][j].getText().equals(""))
                {
                    tbl[i][j].setBackground(Color.white);
                }
                else
                {
                    tbl[i][j].setForeground(Color.red);
                    tbl[i][j].setBackground(Color.lightGray);
                }
            }
        }
    }
    public void mulCheckAnswer()
    {
        for(int i=1; i<RowCol.row; i++)
        {
            for(int j=1; j<RowCol.col; j++)
            {
                int crcAns=0;
                if((tbl[0][j].getText().equals(""))||(tbl[i][0].getText().equals("")))
                {
                    tbl[i][j].setBackground(Color.white);
                    break;
                }
                crcAns = Integer.parseInt(tbl[0][j].getText()) * Integer.parseInt(tbl[i][0].getText());
                String crcStr = new String();
                crcStr = Integer.toString(crcAns);
                if(tbl[i][j].getText().equals(crcStr))
                {
                    tbl[i][j].setForeground(Color.black);
                    tbl[i][j].setBackground(Color.lightGray);
                }
                else if(tbl[i][j].getText().equals(""))
                {
                    tbl[i][j].setBackground(Color.white);
                }
                else
                {
                    tbl[i][j].setForeground(Color.red);
                    tbl[i][j].setBackground(Color.lightGray);
                }
            }
        }
    }
    public void divCheckAnswer()
    {
        for(int i=1; i<RowCol.row; i++)
        {
            for(int j=1; j<RowCol.col; j++)
            {
                int crcAns=0;
                if((tbl[0][j].getText().equals(""))||(tbl[i][0].getText().equals("")))
                {
                    tbl[i][j].setBackground(Color.white);
                    break;
                }
                crcAns = Integer.parseInt(tbl[0][j].getText()) / Integer.parseInt(tbl[i][0].getText());
                String crcStr = new String();
                crcStr = Integer.toString(crcAns);
                if(tbl[i][j].getText().equals(crcStr))
                {
                    tbl[i][j].setForeground(Color.black);
                    tbl[i][j].setBackground(Color.lightGray);
                }
                else if(tbl[i][j].getText().equals(""))
                {
                    tbl[i][j].setBackground(Color.white);
                }
                else
                {
                    tbl[i][j].setForeground(Color.red);
                    tbl[i][j].setBackground(Color.lightGray);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Table myClass = new Table();
        myClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myClass.setLocationRelativeTo(null);
    }
}