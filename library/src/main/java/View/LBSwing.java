package View;
import library.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class LBSwing extends JFrame implements ActionListener
{
	JMenuBar menuBar;
	JMenu mFile,mAboutBook,mMember,mThesis,mList ,mHelp;
	//For Menu FIle
	JMenuItem mItemNew, mItemSave, mItemExit;
	//FOr Menu About Book
	JMenuItem mAddBook,mBorrowBook,mReturnBook;
	//For Menu Member
	JMenuItem mMembers;
	//For Menu Thesis
	JMenuItem mThesises;
	//For Menu List 
	JMenuItem lstMember,lstCatetory,lstBorrow;
	// For Menu Help
	JMenuItem mItemWelcome, mItemHelpContents, mItemCheckUpdate, mItemAbout;
	
	//JTree for Library
	JTree jTreeLb;
	JTabbedPane JTab;
	
	// Search Area
	JComboBox cboField;
	JTextField txtSearch;
	
	//List Book
	JTable tbBook;
	DefaultTableModel tbModel;
	
	//List Member
	JTable tbMember;
	DefaultTableModel tbmodelMember;
	
	//For add Book
	JTextField txtId,txtTitle,txtPublisher,txtPublisherYear,txtISBN,txtPrice,txtAuthor,txtEdition;
	JButton btnAdd,btnCancel;
	
	//For Add member
	JTextField txtMemberID,txtMemberName,txtMemberAddress,txtMemberDOM,txtMemberTOM;
	JButton buttonAdd,buttonCancel;

	//For Borrow Book
	JTextField txtBID,txtDOI,txtDOD;
	JButton btnReturn,btnBorrow;
	//For Add Thesis
	JTextField txtThesisIID, txtThesisTitle,txtThesisPublisher,txtThesisPublisherYear,txtThesisWriter,txtThesisTOT,txtBookId;
	JButton btAdd,btCancel;
	
	//Declare Book ArrayList
	ArrayList<Book> ListBook;
	ArrayList<Member> ListMember;
	public LBSwing()
	{
		   ListBook = new ArrayList<Book>();
		       // Create object MenuItem of file
				mItemNew = new JMenuItem("New");
				mItemSave= new JMenuItem("Save");
				mItemExit = new JMenuItem("Exit");
				
				// Create object Menu File and add its items
				mFile = new JMenu("File");
				mFile.add(mItemNew);
				mFile.add(mItemSave);
				mFile.add(new JSeparator());
				mFile.add(mItemExit);	
				//=============== END OF FILE ===============
				
				
				// Create Object of Menu About Book
				mAddBook = new JMenuItem("Add New Book");
				mBorrowBook = new JMenuItem("Borrow Book");
				mReturnBook = new JMenuItem("Return Book");
				// Create Object Menu About Book and Add its Items
				mAboutBook = new JMenu("About Book");
				mAboutBook.add(mAddBook);
				mAboutBook.addSeparator();
				mAboutBook.add(mBorrowBook);
				mAboutBook.addSeparator();
				mAboutBook.add(mReturnBook);
			   //================== END OF About BOOk===============
				
				//Create Object of Menu Member
				mMembers = new JMenuItem("Add Member");
				//Create object Menu Report and Add its Item
				mMember = new JMenu("Members");
			    mMember.add(mMembers);
				//==================== END OF MEMBER ================
				
			    
			    //Create Object of Menu Thesis
			    mThesises = new JMenuItem("Add Thesis");
			    //Create Object of Menu Thesis And add Its Item
			    mThesis = new JMenu("Thesis");
			    mThesis.add(mThesises);
			    //================= End of Thesis===================
			    
			    
				//Create Object of Menu List
				lstMember = new JMenuItem("List Members");
				lstCatetory = new JMenuItem("List Book By Catetory");
				lstBorrow = new JMenuItem("List of Borrowed Book");
				//Create Object of Menu List and add Its Item
				mList  = new JMenu("List");
				mList.add(lstMember);
				mList.add(lstCatetory);
				mList.add(lstBorrow);
				//===================== End OF List===============================
				
				//create object menu item of help
				mItemWelcome = new JMenuItem( "Welcome");
				mItemHelpContents = new  JMenuItem( "Help Contents");
				mItemCheckUpdate = new JMenuItem( "Check Update");
				mItemAbout = new JMenuItem( "About Employee Mgt");
				
				//Create object menu bar and its menus
				mHelp = new JMenu( "Help");
				mHelp.add(mItemWelcome);
				mHelp.add(mItemHelpContents);
				mHelp.add(new JSeparator());
				mHelp.add(mItemCheckUpdate);
				mHelp.add(mItemAbout);
				//==================END OF HELP=============================
				
				
				// create object menu bar and add its menus
				menuBar = new JMenuBar();
				menuBar.add(mFile);
				menuBar.add(mAboutBook);
				menuBar.add(mMember);
				menuBar.add(mThesis);
				menuBar.add(mList);
				menuBar.add(mHelp);
				
				// ======================END MENU BAR===================
				 JTree leftJTree = createJTree();
				 JTab = new JTabbedPane();
				 
				 JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,leftJTree,JTab);
					jsp.setDividerLocation(180);
					// Add Menu bar to Frame
					add(menuBar);
					add(jsp);
					setTitle("Library Project Version Noob");
					setJMenuBar(menuBar);
					setExtendedState(MAXIMIZED_BOTH);
					setVisible(true);
				
				
				
				
	}
	private void performAddBook()
	{
		JPanel BlockAddBook = new JPanel(new GridLayout(8,2,10,10));
		BlockAddBook.add(new JLabel("ID :"));
		BlockAddBook.add(txtId = new JTextField());
		BlockAddBook.add(new JLabel("Title :"));
		BlockAddBook.add(txtTitle = new JTextField());
		BlockAddBook.add(new JLabel("Publisher :"));
		BlockAddBook.add(txtPublisher = new JTextField());
		BlockAddBook.add(new JLabel("Publisher Year :"));
		BlockAddBook.add(txtPublisherYear = new JTextField());
		BlockAddBook.add(new JLabel("ISBN :"));
		BlockAddBook.add(txtISBN = new JTextField());
		BlockAddBook.add(new JLabel("Price :"));
		BlockAddBook.add(txtPrice = new JTextField());
		BlockAddBook.add(new JLabel("Author :"));
		BlockAddBook.add(txtAuthor = new JTextField());
		BlockAddBook.add(new JLabel("Edition :"));
		BlockAddBook.add(txtEdition = new JTextField());
		

		JPanel actionbtn = new JPanel(new FlowLayout());
		actionbtn.add(btnAdd = new JButton("Add"));
		btnAdd.addActionListener(this);
		actionbtn.add(btnCancel = new JButton("Cancel"));
		
		JPanel BlockAddBookFinal = new JPanel(new BorderLayout(10,10));
		JPanel BookP = new JPanel(new BorderLayout(10,10));
		TitledBorder titleBorder = BorderFactory.createTitledBorder("Adding New Book");
		titleBorder.setTitleJustification(TitledBorder.CENTER);
		
		
		BlockAddBookFinal.setBorder(titleBorder);
		BlockAddBookFinal.add(new JSeparator(),BorderLayout.CENTER);
		BlockAddBookFinal.add(BlockAddBook,BorderLayout.CENTER);
		BlockAddBookFinal.add(actionbtn,BorderLayout.SOUTH);
		
		BookP.add(BlockAddBookFinal,BorderLayout.NORTH);
		
		JTab.addTab("Adding New Book",BookP);
		JTab.setSelectedComponent(BookP);
	}
	
	private JPanel performOpenBook_ListBook(JPanel BookList)
	{
		TitledBorder tBorderListBook = BorderFactory.createTitledBorder("List OF Book");
		tBorderListBook.setTitleJustification(TitledBorder.CENTER);
		BookList.setBorder(tBorderListBook);
		
		// Create Search Area and Count Book
		JPanel SearchandCountPanel = new JPanel(new GridLayout (1,2,10,10));
		//Add Search Area
		JPanel SearchPanel = new JPanel(new FlowLayout());
		SearchPanel.add(new JLabel("Field:"));
		String[] Search = {"ID"};
		SearchPanel.add(cboField = new JComboBox(Search));
		SearchPanel.add(new JLabel("Search"));
		SearchPanel.add(txtSearch = new JTextField(12));
		//Add Search Area
		SearchandCountPanel.add(SearchPanel);
		
		tbModel = new DefaultTableModel();
		tbModel.addColumn("ID");
		tbModel.addColumn("Title");
		tbModel.addColumn("Publisher");
		tbModel.addColumn("Publisher Year");
		tbModel.addColumn("ISBN");
		tbModel.addColumn("Price");
		tbModel.addColumn("Author");
		tbModel.addColumn("Edition");
	
		tbBook = new JTable(tbModel);
		
		JPanel searchandlistpanel = new JPanel(new BorderLayout(10,10));
		searchandlistpanel.add(SearchandCountPanel,BorderLayout.NORTH);
		searchandlistpanel.add(new JScrollPane(tbBook),BorderLayout.CENTER);
		
		
		JPanel blockBookList_Final = new JPanel(new BorderLayout(10,10));
		blockBookList_Final.add(new JLabel("List Of Your Book"), BorderLayout.NORTH);
	    blockBookList_Final.add(searchandlistpanel, BorderLayout.NORTH);
	    
	    
		return blockBookList_Final;
		
	}
	
//	/*private JPanel performOpenBook_SelectALLInfo()
//	{
//		JPanel blockallinfo = new JPanel (new BorderLayout(10,10));
//		blockallinfo.add(performOpenBook_addbook(),BorderLayout.CENTER);
//		
//		JPanel blockallinfo_final = new JPanel(new BorderLayout(10,10));
//		blockallinfo_final.add(blockallinfo, BorderLayout.NORTH);
//
//		JPanel actionbtn = new JPanel(new FlowLayout());
//		actionbtn.add(btnAdd = new JButton("Add"));
//		btnAdd.addActionListener(this);
//		actionbtn.add(btnCancel = new JButton("Cancel"));
//		blockallinfo_final.add(actionbtn, BorderLayout.SOUTH);
//		
//		return blockallinfo_final;
//	}
//	private void performShowBook()
//	{
//		
//		JPanel BookPanel = new JPanel(new BorderLayout(10,10));
//		JPanel BookList= new JPanel(new BorderLayout(10,10));
//		JPanel BookAdd = new JPanel(new BorderLayout(10,10));
//		//Create Group box for Book
//		
//		TitledBorder titleBorder = BorderFactory.createTitledBorder("Adding New Book");
//		titleBorder.setTitleJustification(TitledBorder.CENTER);
//		BookAdd.setBorder(titleBorder);
//
//		BookAdd.add(performOpenBook_SelectALLInfo());
//		BookList.add(performOpenBook_ListBook(BookList),BorderLayout.NORTH);
//		//BookPanel.add(new JScrollPane(BookList),BorderLayout.CENTER);
//		BookPanel.add(new JScrollPane(BookAdd),BorderLayout.CENTER);
//		
//		
//		JTab.addTab("Add New Book", BookPanel);
//		JTab.setSelectedComponent(BookPanel);
//		
//	}
//	*/
//	
	
	
	
	
	private void performAddMember()
	{
		
		JPanel BlockAddMember = new JPanel(new GridLayout(5,2,10,10));
		BlockAddMember.add(new JLabel("Member ID :"));
		BlockAddMember.add(txtMemberID= new JTextField());
		BlockAddMember.add(new JLabel("Member Name :"));
		BlockAddMember.add(txtMemberName = new JTextField());
		BlockAddMember.add(new JLabel("Address :"));
		BlockAddMember.add(txtMemberAddress = new JTextField());
		BlockAddMember.add(new JLabel("Date Of Member :"));
		BlockAddMember.add(txtMemberDOM = new JTextField());
		BlockAddMember.add(new JLabel("Type Of member :"));
		BlockAddMember.add(txtMemberTOM = new JTextField());
		
		
		JPanel actionbutton = new JPanel(new FlowLayout());
		actionbutton.add(buttonAdd = new JButton("Add"));
		buttonAdd.addActionListener(this);
		actionbutton.add(buttonCancel = new JButton("Cancel"));
		
		JPanel BlockAddMemberFinal = new JPanel(new BorderLayout(10,10));
		JPanel MemberP = new JPanel(new BorderLayout(10,10));
		TitledBorder titleBorder2 = BorderFactory.createTitledBorder("Adding New Member");
		titleBorder2.setTitleJustification(TitledBorder.CENTER);
		
		
		BlockAddMemberFinal.setBorder(titleBorder2);
		BlockAddMemberFinal.add(new JSeparator(),BorderLayout.CENTER);
		BlockAddMemberFinal.add(BlockAddMember,BorderLayout.CENTER);
		BlockAddMemberFinal.add(actionbutton,BorderLayout.SOUTH);
		
		MemberP.add(BlockAddMemberFinal,BorderLayout.NORTH);
		
		

		
		JTab.addTab("Add Member",MemberP);
		JTab.setSelectedComponent(MemberP);
		
	}
	private void performAddThesis()
	{
		JPanel BlockAddThesis = new JPanel(new GridLayout(6,2,10,10));
		BlockAddThesis.add(new JLabel("Thesis ID :"));
		BlockAddThesis.add(txtThesisIID= new JTextField());
		BlockAddThesis.add(new JLabel("Thesis Title :"));
		BlockAddThesis.add(txtThesisTitle = new JTextField());
		BlockAddThesis.add(new JLabel("Thesis Publisher :"));
		BlockAddThesis.add(txtThesisPublisher = new JTextField());
		BlockAddThesis.add(new JLabel("Thesis Publisher Year :"));
		BlockAddThesis.add(txtThesisPublisherYear = new JTextField());
		BlockAddThesis.add(new JLabel("Thesis Writer :"));
		BlockAddThesis.add(txtThesisWriter = new JTextField());
		BlockAddThesis.add(new JLabel("Type of Thesis:"));
		BlockAddThesis.add(txtThesisTOT= new JTextField());
		
		JPanel actionbt = new JPanel(new FlowLayout());
		actionbt.add(btAdd = new JButton("Add"));
		btAdd.addActionListener(this);
		actionbt.add(btCancel = new JButton("Cancel"));
		
		JPanel BlockAddThesisFinal = new JPanel(new BorderLayout(10,10));
		TitledBorder titleBorder2 = BorderFactory.createTitledBorder("Adding New Thesis");
		titleBorder2.setTitleJustification(TitledBorder.CENTER);
		BlockAddThesisFinal.setBorder(titleBorder2);
		BlockAddThesisFinal.add(new JSeparator(),BorderLayout.CENTER);
		BlockAddThesisFinal.add(BlockAddThesis,BorderLayout.CENTER);
		BlockAddThesisFinal.add(actionbt,BorderLayout.SOUTH);

		
		JTab.addTab("Add Thesis", BlockAddThesisFinal);
		JTab.setSelectedComponent(BlockAddThesisFinal);
		
	}
	private void performOpenBook_Borrow()
	{
		JPanel blockBorrow = new JPanel (new GridLayout(4,2,10,10));
		blockBorrow.add(new JLabel("Book ID: "));
		blockBorrow.add(txtBID = new JTextField());
		blockBorrow.add(new JLabel("Member ID: "));
		blockBorrow.add(txtMemberID = new JTextField());
		blockBorrow.add(new JLabel("Date of Issue :"));
		blockBorrow.add(txtDOI = new JTextField());
		blockBorrow.add(new JLabel("Date of Due: "));
		blockBorrow.add(txtDOD = new JTextField());

		//Create Block Book info Final
		JPanel actionBtnPanel = new JPanel(new FlowLayout());
		actionBtnPanel.add(btnBorrow = new JButton("Borrow"));
		btnBorrow.addActionListener(this);
		actionBtnPanel.add(btnCancel = new JButton("Cancel"));
		
		JPanel blockBorrow_Final = new JPanel(new BorderLayout(10,10));
		blockBorrow_Final.add(new JLabel( "Please Complete Information below:"),BorderLayout.NORTH);
		//blockBookInfo_Final.add(new JSeparator(),BorderLayout.CENTER);
		blockBorrow_Final.add(blockBorrow,BorderLayout.CENTER);
		blockBorrow_Final.add(actionBtnPanel,BorderLayout.SOUTH);
		
		JPanel bookPanel = new JPanel(new BorderLayout(10,10));
		JPanel borrow = new JPanel();
		//Create Group Box new Employee
		TitledBorder tBorderAddBook = BorderFactory.createTitledBorder("BORROW BOOK");
		tBorderAddBook.setTitleJustification(TitledBorder.CENTER);
		borrow.setBorder(tBorderAddBook);
		
		borrow.add(blockBorrow_Final,BorderLayout.NORTH);	
		//bookPanel.add(new JScrollPane(empList), BorderLayout.CENTER);
		bookPanel.add(new JScrollPane(borrow), BorderLayout.EAST);
		JTab.addTab("Borrow Book:", borrow);
		JTab.setSelectedComponent(borrow);
	}
	private void performOpenBook_Return()
	{
		JPanel blockReturn = new JPanel (new GridLayout(4,2,10,10));
		blockReturn.add(new JLabel("Book ID: "));
		blockReturn.add(txtBID = new JTextField());
		blockReturn.add(new JLabel("Member ID: "));
		blockReturn.add(txtMemberID = new JTextField());
		blockReturn.add(new JLabel("Date of Issue :"));
		blockReturn.add(txtDOI = new JTextField());
		blockReturn.add(new JLabel("Date of Due: "));
		blockReturn.add(txtDOD = new JTextField());

		//Create Block Book info Final
		JPanel actionBtnPanel = new JPanel(new FlowLayout());
		actionBtnPanel.add(btnReturn = new JButton("Return"));
		btnReturn.addActionListener(this);
		actionBtnPanel.add(btnCancel = new JButton("Cancel"));
		
		JPanel blockBookInfo_Final = new JPanel(new BorderLayout(10,10));
		blockBookInfo_Final.add(new JLabel( "Please Complete Information below:"),BorderLayout.NORTH);
		//blockBookInfo_Final.add(new JSeparator(),BorderLayout.CENTER);
		blockBookInfo_Final.add(blockReturn,BorderLayout.CENTER);
		blockBookInfo_Final.add(actionBtnPanel,BorderLayout.SOUTH);
		
		JPanel bookPanel = new JPanel(new BorderLayout(10,10));
		JPanel Return = new JPanel();
		//Create Group Box new Employee
		TitledBorder tBorderAddBook = BorderFactory.createTitledBorder("RETURN BOOK");
		tBorderAddBook.setTitleJustification(TitledBorder.CENTER);
		Return.setBorder(tBorderAddBook);
		
		Return.add(blockBookInfo_Final,BorderLayout.NORTH);	
		//bookPanel.add(new JScrollPane(empList), BorderLayout.CENTER);
		bookPanel.add(new JScrollPane(Return), BorderLayout.EAST);
		JTab.addTab("Return Book:", Return);
		JTab.setSelectedComponent(Return);
	}

	private JPanel performOpenMember_ListMember(JPanel MemberList)
	{
		TitledBorder tBorderListMember = BorderFactory.createTitledBorder("List OF Member");
		tBorderListMember.setTitleJustification(TitledBorder.CENTER);
		MemberList.setBorder(tBorderListMember);
		
		tbmodelMember = new DefaultTableModel();
		tbmodelMember.addColumn("ID");
		tbmodelMember.addColumn("Name");
		tbmodelMember.addColumn("Address");
		tbmodelMember.addColumn("Date of Member");
		tbmodelMember.addColumn("Type of Member");
		
	
		tbMember = new JTable(tbmodelMember);
		
		JPanel searchandlistpanel1 = new JPanel(new BorderLayout(10,10));
		searchandlistpanel1.add(new JScrollPane(tbMember),BorderLayout.CENTER);
		
		
		JPanel blockBookList_Final = new JPanel(new BorderLayout(10,10));
		blockBookList_Final.add(new JLabel("List Of Your Member "), BorderLayout.NORTH);
	    blockBookList_Final.add(new JSeparator(),BorderLayout.CENTER);
	    blockBookList_Final.add(searchandlistpanel1, BorderLayout.CENTER);
	    
	   	return blockBookList_Final;
		
	}
	
	private void performShowlstBook()
	{
		JPanel BookPanel = new JPanel(new GridLayout(10,10));
		JPanel BookList= new JPanel(new BorderLayout(10,10));
		JPanel BookAdd= new JPanel(new BorderLayout(10,10));
		
		TitledBorder titleBorder = BorderFactory.createTitledBorder("Show List");
		titleBorder.setTitleJustification(TitledBorder.CENTER);
		BookAdd.setBorder(titleBorder);
		BookList.add(performOpenBook_ListBook(BookList),BorderLayout.NORTH);
		BookPanel.add(BookList,BorderLayout.CENTER);
		
		
		JTab.addTab("List Book By Catetory", BookPanel);
		JTab.setSelectedComponent(BookPanel);
		
	}
	
	private void performShowlstMember()
	{
		JPanel MemberPanel = new JPanel(new GridLayout(10,10));
		JPanel MemberList= new JPanel(new BorderLayout(10,10));
		JPanel MemberAdd= new JPanel(new BorderLayout(10,10));
		
		TitledBorder titleBorder = BorderFactory.createTitledBorder("Show List");
		titleBorder.setTitleJustification(TitledBorder.CENTER);
		MemberAdd.setBorder(titleBorder);
		
		MemberList.add(performOpenMember_ListMember(MemberList),BorderLayout.NORTH);
		MemberPanel.add(MemberList,BorderLayout.CENTER);
		
		
		JTab.addTab("List Of Member", MemberPanel);
		JTab.setSelectedComponent(MemberPanel);
		
	}
	private JTree createJTree()
	{

		// Create Tree Node Of Library
		DefaultMutableTreeNode nodeBook = new DefaultMutableTreeNode("Books");
		DefaultMutableTreeNode nodeAddBook = new DefaultMutableTreeNode("Add New Book");
		DefaultMutableTreeNode nodeBoroBook = new DefaultMutableTreeNode("Borrow Book");
		DefaultMutableTreeNode nodeReturnBook = new DefaultMutableTreeNode("Return Book");
		nodeBook.add(nodeAddBook);
		nodeBook.add(nodeBoroBook);
		nodeBook.add(nodeReturnBook);
		//=====================End tree node of Books===================
		
		DefaultMutableTreeNode nodeMember = new DefaultMutableTreeNode("Member");
		DefaultMutableTreeNode nodeMembers = new DefaultMutableTreeNode("Add Member");
		nodeMember.add(nodeMembers);
		//=====================End tree node of Member==========================
		
		DefaultMutableTreeNode nodeThesis = new DefaultMutableTreeNode("Thesis");
		DefaultMutableTreeNode nodeThesises = new DefaultMutableTreeNode("Add Thesis");
		nodeThesis.add(nodeThesises);
		//=====================End tree node of Thesis==========================
		
		//create tree node List
		DefaultMutableTreeNode nodeList = new DefaultMutableTreeNode("List");
		DefaultMutableTreeNode nodelistMember = new DefaultMutableTreeNode( "List of Member");
		DefaultMutableTreeNode nodelistCategory = new DefaultMutableTreeNode( "List Book By Category");
		DefaultMutableTreeNode nodelistBorrow = new DefaultMutableTreeNode( "List Of Borrowed Book");
		nodeList.add(nodelistMember);
		nodeList.add(nodelistCategory);
		nodeList.add(nodelistBorrow);
		//================== ENd of Node of List================
		
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
		rootNode.add(nodeBook);
		rootNode.add(nodeMember);
		rootNode.add(nodeThesis);
		rootNode.add(nodeList);
		
		
		//create object of jTree Library
		jTreeLb = new JTree(rootNode);
		jTreeLb.setRowHeight(25);
		jTreeLb.setRootVisible(false);
		jTreeLb.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		//Expand all tree nodes
		jTreeLb.addMouseListener(new MouseAdapter()
				{
			public void mousePressed(MouseEvent e)
			{
				// Find Selected Node of Tree
				int selectedNode = jTreeLb.getRowForLocation(e.getX(), e.getY());
				// COndition when mouse pressed on a Specific node
				if(selectedNode != -1)
					//When mouse Pressed is Double click
					if(e.getClickCount() == 2)
					{   
						//Get for Tree whole tree path
						TreePath treepath = jTreeLb.getPathForLocation(e.getX(), e.getY());
						//Get Last Selected Path
						String lastselectedpath = treepath.getLastPathComponent().toString();
						if(lastselectedpath.equals("Add New Book"))
						{
							 performAddBook();
						}
						else if(lastselectedpath.equals("Borrow Book"))
						{
						      performOpenBook_Borrow();
						}
						else if(lastselectedpath.equals("Return Book"))
						{
							 performOpenBook_Return();
						}
						else if(lastselectedpath.equals("Add Member"))
						{
								performAddMember();
						} 
						else if(lastselectedpath.equals("Add Thesis"))
						{
						      performAddThesis();
						
						}
						else if(lastselectedpath.equals("List of Member"))
						{
						   performShowlstMember();
						
						}
						else if(lastselectedpath.equals("List Book By Category"))
						{
						   performShowlstBook();
						
						}
						
						
						
					}
				
			}
			});
		for(int i =0; i<=jTreeLb.getRowCount(); i++)
		jTreeLb.expandRow(i);
		//Add tree to panel
		//leftPanel.add(jTreeEmp);
		
		return jTreeLb;
		
	}
	
	    
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnBorrow) {
			
			String id= txtBookId.getText();
			String name = txtMemberName.getText();
			String doi = txtDOI.getText();
			String dod = txtDOD.getText();
			
			
			
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(BookEntity.class)
					.buildSessionFactory();
			//Get session object from factory
			Session sessionObj = factory.getCurrentSession();
			try {
			
			sessionObj.beginTransaction();
			
			BookEntity book = sessionObj.get(BookEntity.class, id);
			//Update 
			//book.setStatus(false);
			
			book.setStatus(2);
			sessionObj.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Return successfully");
			
			}
			finally {
			factory.close();
			}


		
			
			
		}
		
		
		if(e.getSource() == buttonAdd)
		{
			 //Create Object of Books
			String id= txtMemberID.getText();
			String name = txtMemberName.getText();
			String address = txtMemberAddress.getText();
			String dom = txtMemberDOM.getText();
			
			String tom = txtMemberTOM.getText();
			
			MemberEntity memberEntity = new MemberEntity(id, name,address, dom,tom);
			//Step 2 : Add Data Into JTable
//			tbModel.addRow(BookObj.toStringData());
//			//Step 3 : Add Object to Array
//			ListBook.add(BookObj);	
			
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(MemberEntity.class)
					.buildSessionFactory();
//Get session object from factory
			Session sessionObj = factory.getCurrentSession();
			try {
			
			System.out.println("Creating new student object...");
			
			sessionObj.beginTransaction();
			System.out.println("Saveing the Book...");
			sessionObj.save(memberEntity);
			sessionObj.getTransaction().commit();
			System.out.println("Done!");

}

finally {
factory.close();
}

		
	}
		if(e.getSource() == btnAdd)
		{
			 //Create Object of Books
			String id= txtId.getText();
			System.out.println(id);
			String title = txtTitle.getText();
			String publisher = txtPublisher.getText();
			String yearPublished = txtPublisherYear.getText();
			
			String ISBN = txtISBN.getText();
			double price = Double.parseDouble(txtPrice.getText());
			String author = txtAuthor.getText();
			int edition = Integer.parseInt(txtEdition.getText());
		
			Book BookObj = new Book(id, title,publisher, yearPublished,true,ISBN,price,author,edition);
			//Step 2 : Add Data Into JTable
			//tbModel.addRow(BookObj.toStringData());
			//Step 3 : Add Object to Array
			ListBook.add(BookObj);	
			
			//Step : add to database
			//Create Factory of Session
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
														.addAnnotatedClass(BookEntity.class)
														.buildSessionFactory();
			//Get session object from factory
			Session sessionObj = factory.getCurrentSession();
			try {
			
				System.out.println("Creating new student object...");
				BookEntity book= new BookEntity(id,title,publisher,yearPublished,1,ISBN,price,author,edition);
				sessionObj.beginTransaction();
				System.out.println("Saveing the Book...");
				sessionObj.save(book);
				sessionObj.getTransaction().commit();
				System.out.println("Done!");
			
			}
			
			finally {
				factory.close();
			}
		
		}
	}
	
	public static void main(String[] arg)
	{
		new LBSwing();
	}
}
