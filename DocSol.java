import java.io.*;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.text.*;
import pic.str;
public class DocSol extends JFrame implements ActionListener{
	
	JPanel launch,signup_page,login_page;
	JLabel launcher,first_name,last_name,susername,lusername,password,lpassword,retypepassword,signup_notice,signup_label,login_label,userimage,imagelabel,login_notice;
	JButton login,signup,sok,sback,lok,lback,browse;
	JTextField t_first_name,t_last_name,tusername,ltusername;
	JPasswordField tpassword,rpassword,ltpassword;
	JFileChooser fc;
	CardLayout card;
    ImageIcon splash,signup_image,login_image,user_image;
	String snotice="",lnotice="",details,user,userid,userpassword,line,userpic="userpic.png";
	Container c;
	JPanel control,options,createoptions,viewoptions,changeoptions;
	JSplitPane jsp;
	JButton usericon,createbutton,change,view,logout,add,delete;
	JLabel creator,creatorname,optionsname,optionsname2,croptionsname,add_info,subject;
	JTextField getSubject;
	JButton done,submitSave,submitBack,submitDelete,go;
	JLabel findSol,fileSol,fileSol2;
	JTextField search1,search2;
	JCheckBox cb[]=new JCheckBox[10];
	JLabel l[]=new JLabel[10];
	JTextPane ta;
	JScrollPane sta;
	JEditorPane ep;
	String ls[]=new String[10];
	String hold,checkid,checkpassword,checkpic,checkuser,look;
	File file,file1,file2,file3,file4;
	Box shoriz7;
	int i,flag=0;
	FileWriter fw;
	FileReader fr;
	BufferedWriter bw;
	BufferedReader br;
	Color my,myColor,alternate;
	int subjectCounter,checkflag=1;
	//new addition
	JButton back;
	JLabel display1,display2;
	JTextPane t1,t2;
	JSplitPane ansp,ansp2;
	JScrollPane asp,asp2;
	JPanel aj1;
	str obj;
	//ends here
	
	DocSol()
	{
		file1=new File("pic/data.txt");
		file2=new File("pic/data2.txt");
		c=getContentPane();
		try {
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	    
		   SwingUtilities.updateComponentTreeUI(c);
		} 		catch (Exception e) {
		    e.printStackTrace();}
		launch=new JPanel();
		my=new Color(135,206,250);
		launch.setBackground(my);
		//launch.setBackground("picture/open.png");
		card=new CardLayout();
		c.setLayout(card);
		c.add("First card",launch);
		//description of launch;
		Box lhoriz1=Box.createHorizontalBox();
		splash=new ImageIcon("picture/file.png");
		launcher=new JLabel(splash);
		lhoriz1.add(launcher);
		
		Box lhoriz2=Box.createHorizontalBox();
		login=new JButton("LOG IN");
		signup=new JButton("SIGN UP");
		login.addActionListener(this);
		signup.addActionListener(this);
		lhoriz2.add(login);
		lhoriz2.add(Box.createHorizontalStrut(55));
		lhoriz2.add(signup);
		
		Box lvert=Box.createVerticalBox();
		lvert.add(Box.createVerticalStrut(20));
		lvert.add(lhoriz1);
		lvert.add(Box.createVerticalStrut(80));
		lvert.add(lhoriz2);
		launch.add(lvert);
		//launch page ends here
		
		signup_page=new JPanel();
		signup_page.setBackground(my);
		c.add("Second Card",signup_page);
		// description of signup page
		Box shoriz1=Box.createHorizontalBox();
		signup_image=new ImageIcon("picture/file.png");
		signup_label=new JLabel(signup_image);
		shoriz1.add(signup_label);
		
		Box shoriz2=Box.createHorizontalBox();
		first_name=new JLabel("First Name");
		t_first_name=new JTextField(20);
		shoriz2.add(first_name);
		shoriz2.add(Box.createHorizontalStrut(50));
		shoriz2.add(t_first_name);
		
		Box shoriz3=Box.createHorizontalBox();
		last_name=new JLabel("Last Name");
		t_last_name=new JTextField(20);
		shoriz3.add(last_name);
		shoriz3.add(Box.createHorizontalStrut(50));
		shoriz3.add(t_last_name);
		
		Box shoriz4=Box.createHorizontalBox();
		susername=new JLabel("Username");
		tusername=new JTextField(20);
		shoriz4.add(susername);
		shoriz4.add(Box.createHorizontalStrut(50));
		shoriz4.add(tusername);
		
		Box shoriz5=Box.createHorizontalBox();
		password=new JLabel("Password");
		tpassword=new JPasswordField(20);
		shoriz5.add(password);
		shoriz5.add(Box.createHorizontalStrut(50));
		shoriz5.add(tpassword);
		
		Box shoriz6=Box.createHorizontalBox();
		retypepassword=new JLabel("Retype Password");
		rpassword=new JPasswordField(20);
		shoriz6.add(retypepassword);
		shoriz6.add(Box.createHorizontalStrut(10));
		shoriz6.add(rpassword);
		
		shoriz7=Box.createHorizontalBox();
		signup_notice=new JLabel(snotice);
		shoriz7.add(signup_notice);
		
		Box shoriz8=Box.createHorizontalBox();
		sok=new JButton("OK");
		sback=new JButton("BACK");
		sok.addActionListener(this);
		sback.addActionListener(this);
		shoriz8.add(sok);
		shoriz8.add(Box.createHorizontalStrut(100));
		shoriz8.add(sback);
		
		Box shoriz9=Box.createHorizontalBox();
		userimage=new JLabel("User Image");
		imagelabel=new JLabel("Choose an image");
		browse=new JButton("Browse");
		browse.addActionListener(this);
		shoriz9.add(userimage);
		shoriz9.add(Box.createHorizontalStrut(100));
		shoriz9.add(imagelabel);
		shoriz9.add(Box.createHorizontalStrut(150));
		shoriz9.add(browse);
		
		Box svert=Box.createVerticalBox();
		svert.add(Box.createVerticalStrut(20));
		svert.add(shoriz1);
		svert.add(Box.createVerticalStrut(20));
		svert.add(shoriz2);
		svert.add(Box.createVerticalStrut(20));
		svert.add(shoriz3);
		svert.add(Box.createVerticalStrut(20));
		svert.add(shoriz4);
		svert.add(Box.createVerticalStrut(20));
		svert.add(shoriz5);
		svert.add(Box.createVerticalStrut(20));
		svert.add(shoriz6);
		svert.add(Box.createVerticalStrut(20));
		svert.add(shoriz9);
		svert.add(Box.createVerticalStrut(20));
		svert.add(shoriz7);
		svert.add(Box.createVerticalStrut(20));
		svert.add(shoriz8);
		signup_page.add(svert);
		//signup page ends here
		
		login_page=new JPanel();
		login_page.setBackground(my);
		c.add("Third Card",login_page);
		// description of login page
		Box loghoriz1=Box.createHorizontalBox();
		login_image=new ImageIcon("picture/file.png");
		login_label=new JLabel(login_image);
		loghoriz1.add(login_label);
		
		Box loghoriz2=Box.createHorizontalBox();
		lusername=new JLabel("Username");
		ltusername=new JTextField(20);
		loghoriz2.add(lusername);
		loghoriz2.add(Box.createHorizontalStrut(50));
		loghoriz2.add(ltusername);
		
		Box loghoriz3=Box.createHorizontalBox();
		lpassword=new JLabel("Password");
		ltpassword=new JPasswordField(20);
		loghoriz3.add(lpassword);
		loghoriz3.add(Box.createHorizontalStrut(50));
		loghoriz3.add(ltpassword);

		Box loghoriz4=Box.createHorizontalBox();
		lok=new JButton("OK");
		lback=new JButton("BACK");
		lok.addActionListener(this);
		lback.addActionListener(this);
		loghoriz4.add(lok);
		loghoriz4.add(Box.createHorizontalStrut(100));
		loghoriz4.add(lback);
		
		Box loghoriz5=Box.createHorizontalBox();
		login_notice=new JLabel(lnotice);
		loghoriz5.add(login_notice);
		
		Box logvert=Box.createVerticalBox();
		logvert.add(Box.createVerticalStrut(20));
		logvert.add(loghoriz1);
		logvert.add(Box.createVerticalStrut(40));
		logvert.add(loghoriz2);
		logvert.add(Box.createVerticalStrut(20));
		logvert.add(loghoriz3);
		logvert.add(Box.createVerticalStrut(30));
		logvert.add(loghoriz5);
		logvert.add(Box.createVerticalStrut(30));
		logvert.add(loghoriz4);
		login_page.add(logvert);
		
		//beginning of calculator
        control=new JPanel();
		myColor =new Color(123,104,238);
		alternate =new Color(95,158,160);
		control.setBackground(myColor);
        options=new JPanel();
		options.setBackground(Color.WHITE);
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,control,options);
		jsp.setDividerLocation(200);
		c.add("Fourth Card",jsp);
		createoptions=new JPanel();
		createoptions.setBackground(Color.WHITE);
		viewoptions=new JPanel();
		viewoptions.setBackground(Color.WHITE);
		changeoptions=new JPanel();
		changeoptions.setBackground(Color.WHITE);
		
		//layout for control
		Box controlhoriz1=Box.createHorizontalBox();
		user_image=new ImageIcon(userpic);      //------------------->bug here
		usericon=new JButton(user_image);
		usericon.setPreferredSize(new Dimension(150,180));
		usericon.setBorderPainted(false);
		usericon.addActionListener(this);
		controlhoriz1.add(usericon);
		
		Box controlhoriz2=Box.createHorizontalBox();
		createbutton=new JButton("FIND");
		createbutton.addActionListener(this);
		controlhoriz2.add(createbutton);
		
		Box controlhoriz3=Box.createHorizontalBox();
		change=new JButton("MATCH");
		change.addActionListener(this);
		controlhoriz3.add(change);
		
		Box controlhoriz4=Box.createHorizontalBox();
		view=new JButton("MAIL");
		view.addActionListener(this);
		controlhoriz4.add(view);
		
		Box controlhoriz10=Box.createHorizontalBox();
		findSol=new JLabel("");
		controlhoriz10.add(findSol);
		
		Box controlhoriz11=Box.createHorizontalBox();
		search1=new JTextField("");
		search1.setVisible(false);
		controlhoriz11.add(search1);
		
		Box controlhoriz12=Box.createHorizontalBox();
		fileSol=new JLabel("");
		controlhoriz12.add(fileSol);
		
		Box controlhoriz13=Box.createHorizontalBox();
		search2=new JTextField("");
		search2.setVisible(false);
		controlhoriz13.add(search2);
		
		Box controlhoriz14=Box.createHorizontalBox();
		go=new JButton("GO");
		go.addActionListener(this);
		go.setVisible(false);
		controlhoriz14.add(go);
		
		Box controlhoriz7=Box.createHorizontalBox();
		logout=new JButton("LOG OUT");
		logout.addActionListener(this);
		controlhoriz7.add(logout);
		
		Box controlhoriz5=Box.createHorizontalBox();
		creator=new JLabel("Created By");
		//creator.setForeground(Color.RED);
		controlhoriz5.add(creator);
		
		Box controlhoriz6=Box.createHorizontalBox();
		creatorname=new JLabel("Akash Ojha");
		creatorname.setForeground(Color.RED);
		controlhoriz6.add(creatorname);
		
		
		Box controlvert=Box.createVerticalBox();
		controlvert.add(controlhoriz1);
		controlvert.add(Box.createVerticalStrut(60));
		controlvert.add(controlhoriz2);
		controlvert.add(Box.createVerticalStrut(30));
		controlvert.add(controlhoriz3);
		controlvert.add(Box.createVerticalStrut(30));
		controlvert.add(controlhoriz4);
		controlvert.add(Box.createVerticalStrut(30));
		controlvert.add(controlhoriz10);
		controlvert.add(controlhoriz11);
		controlvert.add(Box.createVerticalStrut(10));
		controlvert.add(controlhoriz12);
		controlvert.add(controlhoriz13);
		controlvert.add(Box.createVerticalStrut(20));
		controlvert.add(controlhoriz14);
		controlvert.add(Box.createVerticalStrut(30));
		controlvert.add(controlhoriz7);
		controlvert.add(Box.createVerticalStrut(100));
		controlvert.add(controlhoriz5);
		controlvert.add(Box.createVerticalStrut(10));
		controlvert.add(controlhoriz6);
		control.add(controlvert);
		//deccription of options
		
		Box optionshoriz1=Box.createHorizontalBox();
		optionsname=new JLabel("WELCOME "+user);
		optionsname.setForeground(Color.BLUE);
		optionshoriz1.add(optionsname);
		
		Box optionshoriz2=Box.createHorizontalBox();
		optionsname2=new JLabel("");
		optionsname2.setForeground(Color.BLUE);
		optionshoriz2.add(optionsname2);
		
		Box optionsvert=Box.createVerticalBox();
		optionsvert.add(optionshoriz1);
		optionsvert.add(Box.createVerticalStrut(100));
		optionsvert.add(optionshoriz2);
		options.add(optionsvert);
		
		Box croptionshoriz1=Box.createHorizontalBox();
		croptionsname=new JLabel("WELCOME "+user);
		croptionsname.setForeground(Color.BLUE);
		croptionshoriz1.add(croptionsname);
		
		Box croptionshoriz2=Box.createHorizontalBox();
		add=new JButton("ADD");
		delete=new JButton("DELETE");
		add.addActionListener(this);
		delete.addActionListener(this);
		croptionshoriz2.add(add);
		croptionshoriz2.add(Box.createHorizontalStrut(100));
		croptionshoriz2.add(delete);
		
		Box croptionshoriz3=Box.createHorizontalBox();
		add_info=new JLabel("");
		add_info.setForeground(Color.BLUE);
		croptionshoriz3.add(add_info);
		
		Box croptionshoriz4=Box.createHorizontalBox();
		subject=new JLabel("");
		getSubject=new JTextField(50);
		done=new JButton("Enter");
		done.addActionListener(this);
		croptionshoriz4.add(subject);
		croptionshoriz4.add(Box.createHorizontalStrut(50));
		croptionshoriz4.add(getSubject);
		croptionshoriz4.add(Box.createHorizontalStrut(30));
		croptionshoriz4.add(done);
		getSubject.setVisible(false);
		done.setVisible(false);
		
	    Box subject1=Box.createHorizontalBox();
		cb[0]=new JCheckBox();
		l[0]=new JLabel("");
		subject1.add(cb[0]);
		subject1.add(Box.createHorizontalStrut(10));
		subject1.add(l[0]);
		cb[0].setVisible(false);
		
		Box subject2=Box.createHorizontalBox();
		cb[1]=new JCheckBox();
		l[1]=new JLabel("");
		subject2.add(cb[1]);
		subject2.add(Box.createHorizontalStrut(10));
		subject2.add(l[1]);
		cb[1].setVisible(false);
		
		Box subject3=Box.createHorizontalBox();
		cb[2]=new JCheckBox();
		l[2]=new JLabel("");
		subject3.add(cb[2]);
		subject3.add(Box.createHorizontalStrut(10));
		subject3.add(l[2]);
		cb[2].setVisible(false);
		
		Box subject4=Box.createHorizontalBox();
		cb[3]=new JCheckBox();
		l[3]=new JLabel("");
		subject4.add(cb[3]);
		subject4.add(Box.createHorizontalStrut(10));
		subject4.add(l[3]);
		cb[3].setVisible(false);
		
		Box subject5=Box.createHorizontalBox();
		cb[4]=new JCheckBox();
		l[4]=new JLabel("");
		subject5.add(cb[4]);
		subject5.add(Box.createHorizontalStrut(10));
		subject5.add(l[4]);
		cb[4].setVisible(false);
		
		Box subject6=Box.createHorizontalBox();
		cb[5]=new JCheckBox();
		l[5]=new JLabel("");
		subject6.add(cb[5]);
		subject6.add(Box.createHorizontalStrut(10));
		subject6.add(l[5]);
		cb[5].setVisible(false);
		
		Box subject7=Box.createHorizontalBox();
		cb[6]=new JCheckBox();
		l[6]=new JLabel("");
		subject7.add(cb[6]);
		subject7.add(Box.createHorizontalStrut(10));
		subject7.add(l[6]);
		cb[6].setVisible(false);
		
		Box subject8=Box.createHorizontalBox();
		cb[7]=new JCheckBox();
		l[7]=new JLabel("");
		subject8.add(cb[7]);
		subject8.add(Box.createHorizontalStrut(10));
		subject8.add(l[7]);
		cb[7].setVisible(false);
		
		Box subject9=Box.createHorizontalBox();
		cb[8]=new JCheckBox();
		l[8]=new JLabel("");
		subject9.add(cb[8]);
		subject9.add(Box.createHorizontalStrut(10));
		subject9.add(l[8]);
		cb[8].setVisible(false);
		
		Box subject10=Box.createHorizontalBox();
		cb[9]=new JCheckBox();
		l[9]=new JLabel("");
		subject10.add(cb[9]);
		subject10.add(Box.createHorizontalStrut(10));
		subject10.add(l[9]);
		cb[9].setVisible(false);
		
		Box subjectSubmit=Box.createHorizontalBox();
		submitSave=new JButton("SAVE");
		submitBack=new JButton("BACK");
		submitDelete=new JButton("DELETE");
		submitSave.addActionListener(this);
		submitBack.addActionListener(this);
		submitDelete.addActionListener(this);
		submitSave.setVisible(false);
		submitBack.setVisible(false);
		submitDelete.setVisible(false);
		subjectSubmit.add(submitSave);
		subjectSubmit.add(Box.createHorizontalStrut(40));
		subjectSubmit.add(submitBack);
		subjectSubmit.add(Box.createHorizontalStrut(40));
		subjectSubmit.add(submitDelete);
		
		
		Box croptionsvert=Box.createVerticalBox();
		croptionsvert.add(croptionshoriz1);
		croptionsvert.add(Box.createVerticalStrut(50));
		croptionsvert.add(croptionshoriz2);
		croptionsvert.add(Box.createVerticalStrut(50));
		croptionsvert.add(croptionshoriz3);
		croptionsvert.add(Box.createVerticalStrut(30));
		croptionsvert.add(croptionshoriz4);
		croptionsvert.add(Box.createVerticalStrut(30));
		croptionsvert.add(subject1);
		croptionsvert.add(Box.createVerticalStrut(20));
		croptionsvert.add(subject2);
		croptionsvert.add(Box.createVerticalStrut(20));
		croptionsvert.add(subject3);
		croptionsvert.add(Box.createVerticalStrut(20));
		croptionsvert.add(subject4);
		croptionsvert.add(Box.createVerticalStrut(20));
		croptionsvert.add(subject5);
		croptionsvert.add(Box.createVerticalStrut(20));
		croptionsvert.add(subject6);
		croptionsvert.add(Box.createVerticalStrut(20));
		croptionsvert.add(subject7);
		croptionsvert.add(Box.createVerticalStrut(20));
		croptionsvert.add(subject8);
		croptionsvert.add(Box.createVerticalStrut(20));
		croptionsvert.add(subject9);
		croptionsvert.add(Box.createVerticalStrut(20));
		croptionsvert.add(subject10);
		croptionsvert.add(Box.createVerticalStrut(40));
		croptionsvert.add(subjectSubmit);
		createoptions.add(croptionsvert);
		
		//matching panel formation
		aj1=new JPanel();
		Box match1=Box.createHorizontalBox();
		display1=new JLabel("");
		back=new JButton("Back");
		back.addActionListener(this);
		match1.add(display1);
		match1.add(Box.createHorizontalStrut(100));
		match1.add(back);
		match1.add(Box.createHorizontalGlue());
		
		Box match2=Box.createHorizontalBox();
		display2=new JLabel("");
		match2.add(display2);
		match2.add(Box.createHorizontalGlue());
		
		Box matchvert=Box.createVerticalBox();
		matchvert.add(match1);
		matchvert.add(Box.createVerticalStrut(20));
		matchvert.add(match2);
		aj1.add(matchvert);
		
	}//end of constructor

	//details of eventhandling
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==signup)
		{
			card.show(c,"Second Card");
			
		}
		
		if(ae.getSource()==login)
		{
			card.show(c,"Third Card");
			
		}
		
		if(ae.getSource()==sback)
		{
			imagelabel.setText("Choose an image");
			signup_notice.setText("");
			t_first_name.setText("");
			t_last_name.setText("");
			tusername.setText("");
			tpassword.setText("");
			rpassword.setText("");
			card.first(c);
			
		}
		
		if(ae.getSource()==lback)
		{
			ltusername.setText("");
			ltpassword.setText("");
			login_notice.setText("");
			card.first(c);
			
		}
		
		if(ae.getSource()==browse)
		{
			/**fc=new JFileChooser();
		i=fc.showOpenDialog(this);
		if(i==JFileChooser.APPROVE_OPTION)
			 file=fc.getSelectedFile();
	    //user_image=new ImageIcon(userpic);
		userpic=(String)file.getName();*/
		load();
		imagelabel.setText(userpic);
		}
		
		if(ae.getSource()==sok)
		{
			if(rpassword.getText().equals(tpassword.getText()))
			{
			userid=tusername.getText();
			userpassword=tpassword.getText();
			user=t_first_name.getText()+" "+t_last_name.getText();
			
			//login_notice.setText(user);  ------------> delete it later
			signup_notice.setText("");
			t_first_name.setText("");
			  t_last_name.setText("");
			  tusername.setText("");
			  tpassword.setText("");
			  rpassword.setText("");
			  try{
			  create();
			  }
			  catch(Exception ec){}
			card.first(c);
			}
			else
			{
			  signup_notice.setForeground(Color.RED);
			  signup_notice.setText("Password doesn't match");
			}
			
		}
		
		if(ae.getSource()==lok)
		{
	      
		  try{
			  fr=new FileReader(file1);
		  br=new BufferedReader(fr);
		  
		  while((line=br.readLine())!=null)
		  {
			  userid=line;
			  userpassword=br.readLine();
			  user=br.readLine();
			  userpic=br.readLine();
			  if(userid.equals(ltusername.getText()) && userpassword.equals(ltpassword.getText()))
			  {
				  flag=1;
				  br.close();
				  break;
			  }
		  }
		  
		  if(flag==1)
		  {
			  flag=0;
			  optionsname.setText("WELCOME "+user.toUpperCase());
			  //optionsname2.setText(userpic);
			  //user_image=new ImageIcon(userpic);
			  user_image=new ImageIcon(new ImageIcon(userpic).getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT));
			  usericon.setIcon(user_image);
			  ltusername.setText("");
			ltpassword.setText("");
			login_notice.setText("");
			  card.show(c,"Fourth Card");
		  }
		  else{
			  br.close();
			  login_notice.setForeground(Color.RED);
			  login_notice.setText(" Username and Password doesn't match");
		  }
		  }//end of try
		  catch(Exception eet){}
			
		}
		
		if(ae.getSource()==usericon)
		{
			load();
			user_image=new ImageIcon(new ImageIcon(userpic).getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT));
			usericon.setIcon(user_image);
		}
		
		if(ae.getSource()==createbutton)
		{
			findSol.setText("FIND");
			search1.setVisible(true);
			fileSol.setText("FILE NAME");
			search2.setVisible(true);
			go.setVisible(true);
			checkflag=1;
			/*croptionsname.setText("WELCOME "+user.toUpperCase());
			for(subjectCounter=0;subjectCounter<10;subjectCounter++)
			{
				ls[subjectCounter]="NULL";
				
			}
			jsp.setRightComponent(createoptions);*/
			
		}
		
		if(ae.getSource()==logout)
		{
			fileSol.setText("");
			findSol.setText("");
			search1.setVisible(false);
			search2.setVisible(false);
			go.setVisible(false);
			jsp.setRightComponent(options);
			card.first(c);
		}
		
		if(ae.getSource()==change)
		{
			findSol.setText("FILE 1");
			search1.setVisible(true);
			fileSol.setText("FILE 2");
			search2.setVisible(true);
			go.setVisible(true);
			checkflag=2;
			/*add_info.setText("Please enter the subject name");
			subject.setText("Subject");
			getSubject.setVisible(true);
			done.setVisible(true);*/

		}
		
		if(ae.getSource()==done)
		{
			hold=getSubject.getText();
			getSubject.setText("");
			submitSave.setVisible(true);
			submitBack.setVisible(true);
			for(subjectCounter=0;subjectCounter<10;subjectCounter++)
			{
				if(ls[subjectCounter].equals("NULL"))
				{
			     l[subjectCounter].setText(hold);
			     cb[subjectCounter].setVisible(true);
				 ls[subjectCounter]=hold;
				 break;
				}
			}
			
		}
		
		if(ae.getSource()==go) 
		{
			String fileget,tempdisplay,oat;
			String  relevantfile,relevantfile2;
			int pos,toadd;
			ta=new JTextPane();
			sta=new JScrollPane(ta);
			ta.setBackground(alternate);
			//sta.getVerticalScrollBar().setValue(0);
			//jsp.setRightComponent(sta);
			StyledDocument doc = ta.getStyledDocument();
        Style style = ta.addStyle("I'm a Style", null);
		
        StyleConstants.setForeground(style, Color.red);
     /*   try { doc.insertString(doc.getLength(), "BLAH ",style); }
        catch (BadLocationException e){}

        StyleConstants.setForeground(style, Color.black);
        try { doc.insertString(doc.getLength(),oat,style); }
        catch (BadLocationException e){}*/
			if(checkflag==1)
			{
				try{
				look=search1.getText();
				toadd=look.length();
				fileget=search2.getText();
				file3=new File(fileget);
				fr=new FileReader(file3);
				br=new BufferedReader(fr);
				while((line=br.readLine())!=null){
					pos=line.indexOf(look);
					while(pos!=-1){
						tempdisplay=line.substring(0,pos);
						//System.out.println("@"+tempdisplay);
						StyleConstants.setForeground(style, Color.black);
						doc.insertString(doc.getLength(),tempdisplay,style);
						
						StyleConstants.setForeground(style, Color.red);
						 doc.insertString(doc.getLength(),look,style);
						line=line.substring(pos+toadd);
						pos=line.indexOf(look);
						//System.out.println("#"+line);
						//oat=oat+line;
				//to be done later
					}
						    line+="\n";
							StyleConstants.setForeground(style, Color.black);
							doc.insertString(doc.getLength(),line,style);
						
					
					
				}//end of while
				sta.getVerticalScrollBar().setValue(0);
				jsp.setRightComponent(sta);
				
				}	
		//end of try
		      catch(Exception e){}
			}//end of if
			else if(checkflag==2){
				try{
				//aj1=new JPanel();
				t1=new JTextPane();
				t2=new JTextPane();
				asp=new JScrollPane(t1);
				asp2=new JScrollPane(t2);
				ansp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,asp,asp2);
				ansp.setDividerLocation(700);
				ansp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,ansp,aj1);
				ansp2.setDividerLocation(600);
				c.add("fifth",ansp2);
				card.show(c,"fifth");
				relevantfile=search1.getText();
				relevantfile2=search2.getText();
				obj=new str();
				obj.open(relevantfile,relevantfile2);
				StyledDocument doc2 = t1.getStyledDocument();
                Style style2 = t1.addStyle("I'm a Style", null);
				StyleConstants.setForeground(style2, Color.black);
				doc2.insertString(doc.getLength(),obj.a,style2);
				StyledDocument doc3 = t2.getStyledDocument();
                Style style3 = t2.addStyle("I'm a Style", null);
				StyleConstants.setForeground(style3, Color.black);
				doc3.insertString(doc.getLength(),obj.b,style3);
				display1.setText(obj.ans);
				display1.setForeground(Color.BLUE);
				display2.setText(obj.ans2);
				display2.setForeground(Color.BLUE);
				}//end of try
				catch(Exception e){}
				
				
			}//end of else
		}
		
		if(ae.getSource()==delete)
		{
			submitDelete.setVisible(true);
			add_info.setText("Please select the subject to be deleted");
		}
		
		if(ae.getSource()==submitDelete)
		{
			for(subjectCounter=0;subjectCounter<10;subjectCounter++)
			{
				if(cb[subjectCounter].isSelected())
				{
					ls[subjectCounter]="NULL";
					cb[subjectCounter].setVisible(false);
					l[subjectCounter].setText("");
					//COMMAND TO UNSELECT THE CHECKBOX
				}
			}	
		}
		
		if(ae.getSource()==submitBack)
		{
			//add_info.setText("");
			setNull();
			jsp.setRightComponent(options);
		}
		
		if(ae.getSource()==submitSave)
		{
			try{
			entry();
			}
			catch(Exception e)
			{}
			setNull();
			jsp.setRightComponent(options);
		}
		
		if(ae.getSource()==back)
		{
			card.show(c,"Fourth Card");
		}
		
	}//end of actionlistener
	
	
	public void create() throws IOException
	{
		//file1=new File("data.txt");
		//file2=new File("data2.txt");
		fw=new FileWriter(file1,true);
		bw=new BufferedWriter(fw);
		bw.write(userid);
		bw.newLine();
		bw.write(userpassword);
		bw.newLine();
		bw.write(user);
		bw.newLine();
		bw.write(userpic);
		bw.newLine();
		bw.close();
		//file1.delete();
		//file2.renameTo(file1);
	}
	
	void load()
	{
		fc=new JFileChooser();
		i=fc.showOpenDialog(this);
		if(i==JFileChooser.APPROVE_OPTION)
			 file=fc.getSelectedFile();
	    //user_image=new ImageIcon(userpic);
		userpic=(String)file.getName();

	}
	
	void setNull()
	{
		add_info.setText("");
		submitSave.setVisible(false);
		submitBack.setVisible(false);
		submitDelete.setVisible(false);
		for(subjectCounter=0;subjectCounter<10;subjectCounter++)
			{
					ls[subjectCounter]="NULL";
					cb[subjectCounter].setVisible(false);
					l[subjectCounter].setText("");
					//COMMAND TO UNSELECT THE CHECKBOX
			}	
		
	}
	 
	 void entry()throws Exception
	 {
		 fr=new FileReader(file1);
		 br=new BufferedReader(fr);
		 fw=new FileWriter(file2);
		 bw=new BufferedWriter(fw);
		 while((line=br.readLine())!=null)
		 {
			  checkid=line;
			  checkpassword=br.readLine();
			  checkuser=br.readLine();
			  checkpic=br.readLine();
			  
			  	 bw.write(checkid);
				 bw.newLine();
			     bw.write(checkpassword);
				 bw.newLine();
				 bw.write(checkuser);
				 bw.newLine();
				 bw.write(checkpic);
				 bw.newLine();
			  if(checkid.equals(userid) && checkpassword.equals(userpassword))
			  {
				 for(subjectCounter=0;subjectCounter<10;subjectCounter++)
				 {
					bw.write(ls[subjectCounter]);
					bw.newLine(); 
				 }
				 bw.write("END OF USER");
				 bw.newLine();
			  }//end of if
			  

		 }// end of while
		 
		 br.close();
		 bw.close();
	 }
	
	public static void main(String args[])
	{
		DocSol frame =new DocSol();
		frame.setSize(1000,700);
		frame.setTitle("Document Solution");
	    ImageIcon img=new ImageIcon("picture/file.png");
	    frame.setIconImage(img.getImage());// -------------> bug
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		
	}//end of main
	
	
	
	

}//end of class
