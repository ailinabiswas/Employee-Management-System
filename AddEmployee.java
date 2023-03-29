
package employeemanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran=new Random();
    int number=ran.nextInt(999999);
    
    JTextField tfname,tffname,tfaddress,tfphone,tfaadhar,tfemail,tfsalary,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId;
    JButton add,back;
    
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading=new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        image.add(heading);
        
        JLabel labelname=new JLabel("Name");
        heading.setBounds(50,150,150,30);
        heading.setFont(new Font("serif",Font.PLAIN,20));
        image.add(labelname);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        image.add(tfname);
        
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        image.add(labelfname);
        
        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        image.add(tffname);
        
        JLabel labeldob=new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        image.add(labeldob);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        image.add(dcdob);
        
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        image.add(labelsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(600,200,150,30);
        image.add(tfsalary);
        
        JLabel labeladdress=new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        image.add(labeladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        image.add(tfaddress);
        
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        image.add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        image.add(tfphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        image.add(labelemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        image.add(tfemail);
        
        JLabel labeleducation=new JLabel("Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        image.add(labeleducation);
        
        String courses[]={"BBA","BCA","BA","BSc","B.Com","BTech","MBA","MCA","MA","MTech","MSc","PHD"};
        cbeducation=new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600,300,150,30);
        image.add(cbeducation);
        
        JLabel labeldesignation=new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        image.add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        image.add(tfdesignation);
        
        JLabel labelaadhar=new JLabel("Aadhar Number");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        image.add(labelaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        image.add(tfaadhar);
        
        JLabel labelempId=new JLabel("Employee ID");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        image.add(labelempId);
        
        lblempId=new JLabel(""+number);
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        image.add(lblempId);
        
        add=new JButton("Add Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image.add(add);
        
        back=new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image.add(back);
        
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==add){
        String name=tfname.getText();
        String fname=tffname.getText();
        String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
        String salary=tfsalary.getText();
        String address=tfaddress.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String education=(String)cbeducation.getSelectedItem();
        String designation=tfdesignation.getText();
        String aadhar=tfaadhar.getText();
        String empId=lblempId.getText();
        
        try{
            Conn conn=new Conn();
            String query="insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details added successfully");
            setVisible(false);
            new Home();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else{
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String args[]){
        new AddEmployee();
    }
}
