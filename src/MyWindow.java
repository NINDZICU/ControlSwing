import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 25.11.2016.
 */
public class MyWindow extends JFrame {
    private JPanel editPanel;
    private JTable table;
    private JLabel nameLabel;
    private JLabel familyLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JTextField nameField;
    private JTextField familyField;
    private JTextField ageField;
    private JButton saveButton;
    private JCheckBox gender;



    private JScrollPane scroll;
    private Object[] headers = { "Id", "Name", "Surname", "Age","gender"};
    private Object[][] data = {
            { 1,"John", "Smith","12", "1" },
            { 2,"Ivan", "Black", "32","1" },
            { 3,"George", "White","25","1" },
            { 4,"John", "Smith","12", "1" },
            { 5,"Ivan", "Black", "32","1" },
            { 6,"George", "White","25","1" },
            { 7,"John", "Smith","12", "1" },
            { 8,"Ivan", "Black", "32","1" },
            { 9,"George", "White","25","1" },
            { 10,"John", "Smith","12", "1" },
            { 11,"Ivan", "Black", "32","1" },
            { 12,"George", "White","25","1" },
    };

    public MyWindow() {
        super("Control");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new GridBagLayout());
        editPanel = new JPanel(new GridBagLayout());
        editPanel.setBounds(10,10,150,300);
        table = new JTable(data, headers);
         scroll = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        getContentPane().add(scroll,BorderLayout.WEST);


//        productFormPanel = new JPanel(new GridBagLayout());

        add(editPanel, BorderLayout.EAST);
        nameLabel = new JLabel("Name", JLabel.LEFT);
        editPanel.add(nameLabel, this.newLabelConstraints());
        nameField = new JTextField(10);
        nameLabel.setLabelFor(nameField);
        editPanel.add(nameField, this.newTextFieldConstraints());

        familyLabel = new JLabel("Surname", JLabel.LEFT);
        editPanel.add(familyLabel, this.newLabelConstraints());
        familyField = new JTextField();
        familyLabel.setLabelFor(familyField);
        editPanel.add(familyField, this.newTextFieldConstraints());

        ageLabel = new JLabel("Age", JLabel.LEFT);
        editPanel.add(ageLabel, this.newLabelConstraints());
        ageField = new JTextField();
        ageLabel.setLabelFor(ageField);
        editPanel.add(ageField, this.newTextFieldConstraints());

        genderLabel = new JLabel("Male?",JLabel.LEFT);
        editPanel.add(genderLabel, this.newLabelConstraints());
        gender = new JCheckBox();
        genderLabel.setLabelFor(gender);
        editPanel.add(gender,this.newTextFieldConstraints());

        saveButton = new JButton("Save");
        editPanel.add(saveButton, this.newButtonConstraints());
        setResizable(false);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= nameField.getText();
                String surname= familyField.getText();
                String age= ageField.getText();
                Boolean gen= true;
                int id = Integer.valueOf(data[data.length-1][0].toString());
                System.out.println(id);
                Object [][] data1 = new Object[id+1][5];
                for (int i = 0; i < data.length ; i++) {
                    for (int j = 0; j < 5; j++) {
                        data1[i][j]=data[i][j];
                    }
                }
                data1[id][0]=id+1;
                data1[id][1]=name;
                data1[id][2]=surname;
                data1[id][3]=age;
                data1[id][4]=gen;
                data=data1;
                repaint();
            }
        });



        setVisible(true);
        this.setBounds(100,100,600,200);


    }

    private GridBagConstraints newConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        return c;
    }

    private GridBagConstraints newLabelConstraints() {
        GridBagConstraints c = this.newConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 0.0;
        return c;
    }

    private GridBagConstraints newTextFieldConstraints() {
        GridBagConstraints c = this.newConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;
        return c;
    }
    private GridBagConstraints newButtonConstraints(){
        GridBagConstraints c = this.newConstraints();
        c.insets = new Insets(20, 0, 0, 0);
        c.gridwidth  = GridBagConstraints.REMAINDER;
        return c;
    }
}
