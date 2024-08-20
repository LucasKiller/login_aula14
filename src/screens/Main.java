package screens;

import javax.swing.*;
import javax.swing.border.Border;

import entities.Subject;
import utils.FetchTableData;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class Main extends JFrame{
    
    private Container contentPane;
    private JPanel northPanel;
    private JPanel southPanel;

    private JTable table;
    private JScrollPane bar;
    private JPanel tableBackgrond;

    private JButton ler;
    private JButton salvar;

    public Main(Connection conn){
        super("Sistemas de notas");

        initializeComponents(conn);
        prepareScreen();
        initializeScreen();
    }



    private void initializeComponents(Connection conn){
        
        Object[][] tableData = FetchTableData.loadTableData(2, new Subject(1), conn);
        String[] tableColumn = {"Matéria", "Nota 1", "Faltas 1", "Nota 2", "Faltas 2", "Nota 3", "Faltas 3", "Nota 4", "Faltas 4"};

        table = new JTable(tableData, tableColumn);
        bar = new JScrollPane(table);
        tableBackgrond = new JPanel(new GridLayout());
        tableBackgrond.add(bar);

        ler = new JButton("Ler do BD");
        ler.setPreferredSize(new Dimension(250, 50));
        ler.setBackground(Color.LIGHT_GRAY);
        ler.setBorder(BorderFactory.createLineBorder(Color.gray));
        ler.setFont(new Font("Arial", Font.BOLD, 18));
        salvar = new JButton("Salvar no BD");
        salvar.setPreferredSize(new Dimension(250, 50));
        salvar.setBackground(Color.LIGHT_GRAY);
        salvar.setBorder(BorderFactory.createLineBorder(Color.gray));
        salvar.setFont(new Font("Arial", Font.BOLD, 18));

    }

    private void prepareScreen() {
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        northPanel = new JPanel(new FlowLayout());
        southPanel = new JPanel(new FlowLayout());

        northPanel.add(tableBackgrond);
        southPanel.add(ler);
        southPanel.add(salvar);

        contentPane.add(northPanel, BorderLayout.NORTH);
        contentPane.add(southPanel, BorderLayout.SOUTH);
    }

    private void initializeScreen() {
        // setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }

}
