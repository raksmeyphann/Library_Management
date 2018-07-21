package View;
import library.*;
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
	
	//List
	JTable tbBook;
	DefaultTableModel tbModel;
	
	
	
	//For add Book
	JTextField txtId,txtTitle,txtPublisher,txtPublisherYear,txtISBN,txtPrice,txtAuthor,txtEdition;
	JButton btnAdd,btnCancel;
	
	//For Add member
	JTextField txtMemberID,txtMemberName,txtMemberAddress,txtMemberDOM,txtMemberTOM;
	JButton buttonAdd,buttonCancel;
	
	//For Add Thesis
	JTextField txtThesisIID, txtThesisTitle,txtThesisPublisher,txtThesisPublisherYear,txtThesisWriter,txtThesisTOT;
	JButton btAdd,btCancel;
	
	//Declare Book ArrayList
	ArrayList<Book> ListBook;
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
	
	private JPanel performOpenBook_addbook()
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
		
		JPanel BlockAddBookFinal = new JPanel(new BorderLayout(10,10));
		BlockAddBookFinal.add(new JLabel("Book Information"),BorderLayout.NORTH);
		BlockAddBookFinal.add(new JSeparator(),BorderLayout.CENTER);
		BlockAddBookFinal.add(BlockAddBook,BorderLayout.CENTER);
		return BlockAddBookFinal;
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
	    blockBookList_Final.add(new JSeparator(),BorderLayout.CENTER);
	    blockBookList_Final.add(searchandlistpanel, BorderLayout.SOUTH);
	    
	    
		return blockBookList_Final;
		
	}
	
	private JPanel performOpenBook_SelectALLInfo()
	{
		JPanel blockallinfo = new JPanel (new BorderLayout(10,10));
		blockallinfo.add(performOpenBook_addbook(),BorderLayout.CENTER);
		
		JPanel blockallinfo_final = new JPanel(new BorderLayout(10,10));
		blockallinfo_final.add(blockallinfo, BorderLayout.NORTH);

		JPanel actionbtn = new JPanel(new FlowLayout());
		actionbtn.add(btnAdd = new JButton("Add"));
		btnAdd.addActionListener(this);
		actionbtn.add(btnCancel = new JButton("Cancel"));
		blockallinfo_final.add(actionbtn, BorderLayout.SOUTH);
		
		return blockallinfo_final;
	}
	private void performShowBook()
	{
		
		JPanel BookPanel = new JPanel(new BorderLayout(10,10));
		JPanel BookList= new JPanel(new BorderLayout(10,10));
		JPanel BookAdd = new JPanel(new BorderLayout(10,10));
		//Create Group box for Book
		
		TitledBorder titleBorder = BorderFactory.createTitledBorder("Adding New Book");
		titleBorder.setTitleJustification(TitledBorder.CENTER);
		BookAdd.setBorder(titleBorder);

		BookAdd.add(performOpenBook_SelectALLInfo());
		BookList.add(performOpenBook_ListBook(BookList),BorderLayout.NORTH);
		BookPanel.add(new JScrollPane(BookList),BorderLayout.CENTER);
		BookPanel.add(new JScrollPane(BookAdd),BorderLayout.EAST);
		
		
		JTab.addTab("Add New Book", BookPanel);
		JTab.setSelectedComponent(BookPanel);
		
	}
	
	/*private void performAddThesis()
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
	*/
	private JTree createJTree()
	{

		// Create Tree Node Of Library
		DefaultMutableTreeNode nodeBook = new DefaultMutableTreeNode("Books");
		DefaultMutableTreeNode nodeAddBook = new DefaultMutableTreeNode("Add New Book");
		DefaultMutableTreeNode nodeBoroBook = new DefaultMutableTreeNode("Borrow book");
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
		DefaultMutableTreeNode nodelistBorrow = new DefaultMutableTreeNode( "List Return Book");
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
							 performShowBook();
						}
						else if(lastselectedpath.equals("List Employee"))
						{
						      
						}
						else if(lastselectedpath.equals("Employee Tax"))
						{
							
						}
						else if(lastselectedpath.equals("Add Member"))
						{
							//	performAddMember();		
						}
						else if(lastselectedpath.equals("Add Thesis"))
						{
						//      performAddThesis();
						
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
		if(e.getSource() == btnAdd)
		{
			 //Create Object of Books
			String id= txtId.getText();
			String title = txtTitle.getText();
			String publisher = txtPublisher.getText();
			String yearPublished = txtPublisherYear.getText();
			
			String ISBN = txtISBN.getText();
			double price = Double.parseDouble(txtPrice.getText());
			String author = txtAuthor.getText();
			int edition = Integer.parseInt(txtEdition.getText());
		
			Book BookObj = new Book(id, title,publisher, yearPublished,true,ISBN,price,author,edition);
			//Step 2 : Add Data Into JTable
			tbModel.addRow(BookObj.toStringData());
			//Step 3 : Add Object to Array
			ListBook.add(BookObj);	
		
	}
	}
	public static void main(String[] arg)
	{
		new LBSwing();
	}
}
