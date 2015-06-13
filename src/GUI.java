import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI extends JFrame {
    final int WIDTH=500;
    final int HEIGHT=500;
    ImagePanel imagePanel;
    JPanel inputsPanel;
    JPanel resultPanel;
    JButton button;
    JLabel resultLabel;
    JTextField textFieldAB;
    JTextField textFieldAC;
    JTextField textFieldAD;
    JTextField textFieldAE;
    JTextField textFieldBD;
    JTextField textFieldBF;
    JTextField textFieldCE;
    JTextField textFieldCF;
    JTextField textFieldDF;
    JTextField textFieldEF;

    public GUI() {
        prepareFrame();
        prepareImagePanel();
        add(imagePanel,BorderLayout.CENTER);
        prepareInputsPanel();
        add(inputsPanel, BorderLayout.EAST);
        prepareResultPanel();
        add(resultPanel,BorderLayout.SOUTH);
        prepareListeners();
    }

    private void prepareFrame(){
        setLayout(new BorderLayout());
        setTitle("Lab4");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void prepareImagePanel(){
        imagePanel = new ImagePanel();
    }

    private void prepareInputsPanel(){
        inputsPanel = new JPanel(new GridLayout(0,2));

        textFieldAB = new JTextField("3",5);
        textFieldAC = new JTextField("9",5);
        textFieldAD = new JTextField("7",5);
        textFieldAE = new JTextField("1",5);
        textFieldBD = new JTextField("3",5);
        textFieldBF = new JTextField("10",5);
        textFieldCE = new JTextField("9",5);
        textFieldCF = new JTextField("5",5);
        textFieldDF = new JTextField("4",5);
        textFieldEF = new JTextField("2",5);
        button = new JButton("Run!");

        inputsPanel.add(new JLabel("AB:"));
        inputsPanel.add(textFieldAB);
        inputsPanel.add(new JLabel("AC:"));
        inputsPanel.add(textFieldAC);
        inputsPanel.add(new JLabel("AD:"));
        inputsPanel.add(textFieldAD);
        inputsPanel.add(new JLabel("AE:"));
        inputsPanel.add(textFieldAE);
        inputsPanel.add(new JLabel("BD:"));
        inputsPanel.add(textFieldBD);
        inputsPanel.add(new JLabel("BF:"));
        inputsPanel.add(textFieldBF);
        inputsPanel.add(new JLabel("CE:"));
        inputsPanel.add(textFieldCE);
        inputsPanel.add(new JLabel("CF:"));
        inputsPanel.add(textFieldCF);
        inputsPanel.add(new JLabel("DF:"));
        inputsPanel.add(textFieldDF);
        inputsPanel.add(new JLabel("EF:"));
        inputsPanel.add(textFieldEF);
        inputsPanel.add(button);
    }

    private void prepareResultPanel(){
        resultPanel= new JPanel();
        resultLabel = new JLabel("");
        resultPanel.setBackground(Color.white);
        resultPanel.setPreferredSize(new Dimension(200, 40));
        resultPanel.add(resultLabel);
    }

    private void prepareListeners(){
        button.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Main.c[0][1]=Integer.parseInt(textFieldAB.getText());
                Main.c[0][2]=Integer.parseInt(textFieldAC.getText());
                Main.c[0][3]=Integer.parseInt(textFieldAD.getText());
                Main.c[0][4]=Integer.parseInt(textFieldAE.getText());
                Main.c[1][3]=Integer.parseInt(textFieldBD.getText());
                Main.c[1][5]=Integer.parseInt(textFieldBF.getText());
                Main.c[2][4]=Integer.parseInt(textFieldCE.getText());
                Main.c[2][5]=Integer.parseInt(textFieldCF.getText());
                Main.c[3][5]=Integer.parseInt(textFieldDF.getText());
                Main.c[4][5]=Integer.parseInt(textFieldEF.getText());

                FordFulkerson ff = new FordFulkerson(Main.n,Main.f,Main.c);
                resultLabel.setText("Max Flow = "+ff.MaxFlow(Main.s,Main.d));
                for (int i=0; i< ff.Queue.length; i++){
                System.out.println(ff.Queue[i]);
            }
            }
        });
    }
}
