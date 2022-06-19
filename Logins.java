import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Logins implements ActionListener
{
String nm,usernm,password;
JFrame f1,f2,f3;
JButton b1,b2,b3,b4;
JTextField t1,t2,t3;
JLabel l1,l2,l3,l4,l5,l6,l7;
JPasswordField p1,p2;
Logins()
{
f1=new JFrame();
f2=new JFrame();
f3=new JFrame();
f1.setSize(300,300);
f2.setSize(400,300);
f3.setSize(400,300);
b1=new JButton("Sign up");

b2=new JButton("Sign in");
b1.addActionListener(this);
b2.addActionListener(this);
b1.setBounds(30,50,100,50);
b2.setBounds(150,50,100,50);
f1.add(b1);
f1.add(b2);
f1.setLayout(null);
f2.setLayout(null);
f3.setLayout(null);
f1.setVisible(true);
f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
l1=new JLabel("NAME");
l2=new JLabel("USERNAME");
l3=new JLabel("PASSWORD");
l4=new JLabel("USERNAME");
l5=new JLabel("PASSWORD");
t1=new JTextField(15);
t2=new JTextField(15);
t3=new JTextField(15);
b3=new JButton("Sign Up");
b4=new JButton("Sign In");
l6=new JLabel();
l7=new JLabel();
p1=new JPasswordField(15);
p2=new JPasswordField(15);
b3.addActionListener(this);
b4.addActionListener(this);
l1.setBounds(20,25,100,30);
t1.setBounds(100,25,200,30);
l2.setBounds(20,65,100,30);
t2.setBounds(100,65,200,30);
l3.setBounds(20,105,100,30);

p1.setBounds(100,105,200,30);
b3.setBounds(150,150,100,50);
l4.setBounds(20,25,100,30);
t3.setBounds(100,25,200,30);
l5.setBounds(20,65,100,30);
p2.setBounds(100,65,200,30);
b4.setBounds(150,110,100,50);
l6.setBounds(100,220,200,30);
l7.setBounds(100,220,200,30);
f2.add(l1);f2.add(l2);
f2.add(l3);f2.add(t1);
f2.add(t2);f2.add(p1);
f2.add(b3);f2.add(l6);
f3.add(l4);f3.add(l5);
f3.add(t3);f3.add(p2);
f3.add(b4);f3.add(l7);
f2.setVisible(false);
f3.setVisible(false);
}
public void actionPerformed(ActionEvent e)
{
String s=e.getActionCommand();
String s1=new String();
Boolean a=true;
try
{
Class.forName("org.postgresql.Driver");
Connection
c=DriverManager.getConnection("postgres://jaksydqc:8FCiR71Y-u6Ojil3aYJDTrh
qrj8FYaty@ziggy.db.elephantsql.com/jaksydqc","zhbsswdk","f3j37UZpFRVCmm
H3iXuPYv6j0a78skrV");
Statement stat=c.createStatement();
ResultSet rs;
int b;
if(s.equals("Sign up"))
{

f2.setVisible(true);
}
else if(s.equals("Sign in"))
{
f3.setVisible(true);
}
else if(s.equals("Sign Up"))
{
nm=t1.getText();
usernm=t2.getText();
password=p1.getText();
rs=stat.executeQuery("select name from Login where name = '"+nm+"';");
if(rs.next())
{
a=false;
}
if(a)
{
s1="insert into Login values('"+nm+ "','"+usernm+ "','"+password+ "');";
b=stat.executeUpdate(s1);
l6.setText("succesfully registered");
}
else
{
l6.setText("ALREADY REGISTERED");
}
t1.setText("");
t2.setText("");
p1.setText("");
}
else if(s.equals("Sign In"))
{
usernm=t3.getText();
password=p2.getText();
p2.setEchoChar('*');
rs=stat.executeQuery("select password from Login where username =
'"+usernm+"';");

while(rs.next())
{
String p=rs.getString("password");
p=p.trim();
if(password.equals(p))
{
a=false;
}
if(a)
{
l7.setText("INCORRECT PASSWORD");
}
else
{
l7.setText("WELCOME");
}
t3.setText("");
p2.setText("");
}
}
stat.close();
c.close();
}
catch(java.lang.Exception ex)
{
System.out.println(ex);
}
}
public static void main(String[]args)
{
new Logins();
}
}
