import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputField = new JTextField();
		inputField.setBounds(35, 111, 378, 28);
		contentPane.add(inputField);
		inputField.setColumns(10);
	
		final JRadioButton twoPages = new JRadioButton("2 Pages");
		twoPages.setSelected(true);;
		twoPages.setBounds(35, 76, 80, 23);
		contentPane.add(twoPages);
		
		final JRadioButton threePages = new JRadioButton("3 Pages");
		threePages.setBounds(116, 76, 80, 23);
		contentPane.add(threePages);
		
		final JRadioButton fourPages = new JRadioButton("4 Pages");
		fourPages.setBounds(201, 76, 80, 23);
		contentPane.add(fourPages);
		
		final JRadioButton fivePages = new JRadioButton("5 Pages");
		fivePages.setBounds(284, 76, 141, 23);
		contentPane.add(fivePages);
		
		ButtonGroup group = new ButtonGroup();
		group.add(twoPages);
		group.add(threePages);
		group.add(fourPages);
		group.add(fivePages);
		
		JButton btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText() + "A");
			}
		});
		btnA.setBounds(47, 165, 32, 29);
		contentPane.add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText() + "B");
			}
		});
		btnB.setBounds(105, 165, 32, 29);
		contentPane.add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText() + "C");
			}
		});
		btnC.setBounds(164, 165, 32, 29);
		contentPane.add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText() + "D");
			}
		});
		btnD.setBounds(218, 165, 32, 29);
		contentPane.add(btnD);
		
		JButton btnE = new JButton("E");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText() + "E");
			}
		});
		btnE.setBounds(278, 165, 32, 29);
		contentPane.add(btnE);
		
		JButton btnF = new JButton("F");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText() + "F");
			}
		});
		btnF.setBounds(345, 165, 32, 29);
		contentPane.add(btnF);
		
		/*Implements FIFO algorithm according to selected radio button*/
		JButton FIFO = new JButton("FIFO");
		FIFO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(twoPages.isSelected() == true){
					System.out.println("FIFO");
					
					ArrayList<Character> page = new ArrayList<Character>(2);
					ArrayList<Character> list = new ArrayList<Character>();
					ArrayList<Character> temp = new ArrayList<Character>(2);
					
					for(int j = 0; j < inputField.getText().length();j++){
						list.add(inputField.getText().charAt(j));
					}
					
					for(int i = 0; i < list.size(); i++){
						if(page.isEmpty()){
							
							page.add(list.get(i));
							temp.add(list.get(i));
						System.out.println("Insert " + list.get(i) + " " + page);
						
						}else if(page.contains(list.get(i))){
							if(temp.size() != 2){
								temp.add(list.get(i));
							}else{
								temp.remove(0);
							}
							temp.add(list.get(i));
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
							
						}else if(!page.contains(list.get(i)) && page.size() != 2){
							page.add(list.get(i));
							
								if(temp.size() != 2){
									temp.add(list.get(i));
								}else{
									temp.remove(0);
									temp.add(list.get(i));
								}
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
							
						}else {
							
							if(!page.get(0).equals(temp.get(1))){
							//System.out.println("temp " + temp);
							page.set(0, list.get(i));
							
								if(temp.size() != 2){
									temp.add(list.get(i));
								}else{
									temp.remove(0);
									temp.add(list.get(i));
								}
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
							
							} else{
								
								page.set(1, list.get(i));
									if(temp.size() != 2){
										temp.add(list.get(i));
									}else{
										temp.remove(0);
										temp.add(list.get(i));
									}
								
								System.out.println("Insert " + list.get(i) + " " + page);
								continue;
							}
						}
					}
				}
					else if(threePages.isSelected() == true)
					{
						System.out.println("FIFO");
					BlockingQueue<Character> page = new LinkedBlockingQueue<Character>(3);
					BlockingQueue<Character> temp = new LinkedBlockingQueue<Character>(3);
					ArrayList<Character> list = new ArrayList<Character>();
					
					for(int j = 0; j < inputField.getText().length();j++){
					
						list.add(inputField.getText().charAt(j));
					}
					
					for(int i = 0; i < list.size(); i++){
						if(page.isEmpty()){
						page.offer(list.get(i));
						temp.offer(list.get(i));
						System.out.println("Insert " + list.get(i) + " " + page);
						continue;
						
						}else if(page.contains(list.get(i))){
							temp.poll(); 
							temp.offer(list.get(i));
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
						}else if(page.remainingCapacity() != 0 && !page.contains(list.get(i)) && list.get(i) != temp.peek()){
							//page.poll();
							page.offer(list.get(i));
							temp.poll();
							temp.offer(list.get(i));
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
						}else if(page.remainingCapacity() == 0 && !page.contains(list.get(i)) && list.get(i) != temp.peek())
							page.poll();
							page.offer(list.get(i));
							temp.poll();
							temp.offer(list.get(i));
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
					}
					System.out.println("end of statement " + page);
					
			}
			else if(fourPages.isSelected() == true){
				System.out.println("FIFO");
				
					BlockingQueue<Character> page = new LinkedBlockingQueue<Character>(4);
					BlockingQueue<Character> temp = new LinkedBlockingQueue<Character>(4);
					ArrayList<Character> list = new ArrayList<Character>();
					
					for(int j = 0; j < inputField.getText().length();j++){
					
						list.add(inputField.getText().charAt(j));
					}
					
					for(int i = 0; i < list.size(); i++){
						if(page.isEmpty()){
						page.offer(list.get(i));
						temp.offer(list.get(i));
						System.out.println("Insert " + list.get(i) + " " + page);
						continue;
						
						}else if(page.contains(list.get(i))){
							temp.poll(); 
							temp.offer(list.get(i));
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
						}else if(page.remainingCapacity() != 0 && !page.contains(list.get(i)) && list.get(i) != temp.peek()){
							//page.poll();
							page.offer(list.get(i));
							temp.poll();
							temp.offer(list.get(i));
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
						}else if(page.remainingCapacity() == 0 && !page.contains(list.get(i)) && list.get(i) != temp.peek())
							page.poll();
							page.offer(list.get(i));
							temp.poll();
							temp.offer(list.get(i));
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
					}
					System.out.println("end of statement " + page);
				
		}else if(fivePages.isSelected() == true){
			System.out.println("FIFO");
					BlockingQueue<Character> page = new LinkedBlockingQueue<Character>(5);
					BlockingQueue<Character> temp = new LinkedBlockingQueue<Character>(5);
					ArrayList<Character> list = new ArrayList<Character>();
					
					for(int j = 0; j < inputField.getText().length();j++){
					
						list.add(inputField.getText().charAt(j));
					}
					
					for(int i = 0; i < list.size(); i++){
						if(page.isEmpty()){
						page.offer(list.get(i));
						temp.offer(list.get(i));
						System.out.println("Insert " + list.get(i) + " " + page);
						continue;
						
						}else if(page.contains(list.get(i))){
							temp.poll(); 
							temp.offer(list.get(i));
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
						}else if(page.remainingCapacity() != 0 && !page.contains(list.get(i)) && list.get(i) != temp.peek()){
							//page.poll();
							page.offer(list.get(i));
							temp.poll();
							temp.offer(list.get(i));
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
						}else if(page.remainingCapacity() == 0 && !page.contains(list.get(i)) && list.get(i) != temp.peek())
							page.poll();
							page.offer(list.get(i));
							temp.poll();
							temp.offer(list.get(i));
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
					}
					System.out.println("end of statement " + page);
				}

				}
			
		});
		FIFO.setBounds(35, 223, 117, 29);
		contentPane.add(FIFO);
		
		JButton LRU = new JButton("LRU");
		LRU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(twoPages.isSelected() == true){
					System.out.println("LRU");
					
					ArrayList<Character> page = new ArrayList<Character>(2);
					ArrayList<Character> list = new ArrayList<Character>();
					ArrayList<Character> temp = new ArrayList<Character>(2);
					
					for(int j = 0; j < inputField.getText().length();j++){
						list.add(inputField.getText().charAt(j));
					}
					
					for(int i = 0; i < list.size(); i++){
						if(page.isEmpty()){
							
							page.add(list.get(i));
							
							System.out.println("Insert " + list.get(i) + " " + page);
								if(temp.size() != 2){
									temp.add(list.get(i));
								}else{
									temp.remove(0);
									temp.add(list.get(i));
									System.out.println("Insert " + list.get(i) + " " + page);
								}
							continue;
						
						}else if(page.contains(list.get(i))){
							if(temp.size() != 2){
								temp.add(list.get(i));
							}else{
								temp.remove(0);
							}
							temp.add(list.get(i));
							System.out.println("Insert " + list.get(i) + " " + page);
							continue;
							
						}else if(!page.contains(list.get(i)) && page.size() != 2){
							page.add(list.get(i));
							
								if(temp.size() != 2){
									temp.add(list.get(i));
								}else{
									temp.remove(0);
									temp.add(list.get(i));
								}
								System.out.println("Insert " + list.get(i) + " " + page);
							continue;
							
						}else {
							
							if(!page.get(0).equals(temp.get(1))){
							
							System.out.println("temp " + temp);
							page.set(0, list.get(i));
							
								if(temp.size() != 2){
									temp.add(list.get(i));
								}else{
									temp.remove(0);
									temp.add(list.get(i));
								}
								System.out.println("Insert " + list.get(i) + " " + page);
							continue;
							
							} else{
								
								page.set(1, list.get(i));
									if(temp.size() != 2){
										temp.add(list.get(i));
									}else{
										temp.remove(0);
										temp.add(list.get(i));
									}
								
									System.out.println("Insert " + list.get(i) + " " + page);
								continue;
							}
						}
					}
		}else if(threePages.isSelected() == true){
	System.out.println("LRU");
	
	ArrayList<Character> page = new ArrayList<Character>(3);
	ArrayList<Character> list = new ArrayList<Character>();
	ArrayList<Character> temp = new ArrayList<Character>(3);
	
	for(int j = 0; j < inputField.getText().length();j++){
		list.add(inputField.getText().charAt(j));
	}
	
	for(int i = 0; i < list.size(); i++){
		if(page.isEmpty()){
			
			page.add(list.get(i));
			
			System.out.println("Insert " + list.get(i) + " " + page);
				if(temp.size() != 3){
					temp.add(list.get(i));
				}else{
					temp.remove(0);
					temp.add(list.get(i));
					System.out.println("Insert " + list.get(i) + " " + page);
				}
			continue;
		
		}else if(page.contains(list.get(i))){
			if(temp.size() != 3){
				temp.add(list.get(i));
			}else{
				temp.remove(0);
			}
			temp.add(list.get(i));
			System.out.println("Insert " + list.get(i) + " " + page);
			continue;
			
		}else if(!page.contains(list.get(i)) && page.size() != 3){
			page.add(list.get(i));
			
				if(temp.size() != 3){
					temp.add(list.get(i));
				}else{
					temp.remove(0);
					temp.add(list.get(i));
				}
				System.out.println("Insert " + list.get(i) + " " + page);
			continue;
			
		}else {
			
			if(!page.get(0).equals(temp.get(1))){
			
			System.out.println("temp " + temp);
			page.set(0, list.get(i));
			
				if(temp.size() != 3){
					temp.add(list.get(i));
				}else{
					temp.remove(0);
					temp.add(list.get(i));
				}
				System.out.println("Insert " + list.get(i) + " " + page);
			continue;
			
			} else{
				
				page.set(1, list.get(i));
					if(temp.size() != 3){
						temp.add(list.get(i));
					}else{
						temp.remove(0);
						temp.add(list.get(i));
					}
				
					System.out.println("Insert " + list.get(i) + " " + page);
				continue;
			}
		}
	}
}else if(fourPages.isSelected() == true){
	System.out.println("LRU");
	
	ArrayList<Character> page = new ArrayList<Character>(4);
	ArrayList<Character> list = new ArrayList<Character>();
	ArrayList<Character> temp = new ArrayList<Character>(4);
	
	for(int j = 0; j < inputField.getText().length();j++){
		list.add(inputField.getText().charAt(j));
	}
	
	for(int i = 0; i < list.size(); i++){
		if(page.isEmpty()){
			
			page.add(list.get(i));
			
			System.out.println("Insert " + list.get(i) + " " + page);
				if(temp.size() != 4){
					temp.add(list.get(i));
				}else{
					temp.remove(0);
					temp.add(list.get(i));
					System.out.println("Insert " + list.get(i) + " " + page);
				}
			continue;
		
		}else if(page.contains(list.get(i))){
			if(temp.size() != 4){
				temp.add(list.get(i));
			}else{
				temp.remove(0);
			}
			temp.add(list.get(i));
			System.out.println("Insert " + list.get(i) + " " + page);
			continue;
			
		}else if(!page.contains(list.get(i)) && page.size() != 4){
			page.add(list.get(i));
			
				if(temp.size() != 4){
					temp.add(list.get(i));
				}else{
					temp.remove(0);
					temp.add(list.get(i));
				}
				System.out.println("Insert " + list.get(i) + " " + page);
			continue;
			
		}else {
			
			if(!page.get(0).equals(temp.get(1))){
			
			System.out.println("temp " + temp);
			page.set(0, list.get(i));
			
				if(temp.size() != 4){
					temp.add(list.get(i));
				}else{
					temp.remove(0);
					temp.add(list.get(i));
				}
				System.out.println("Insert " + list.get(i) + " " + page);
			continue;
			
			} else{
				
				page.set(1, list.get(i));
					if(temp.size() != 4){
						temp.add(list.get(i));
					}else{
						temp.remove(0);
						temp.add(list.get(i));
					}
				
					System.out.println("Insert " + list.get(i) + " " + page);
				continue;
			}
		}
	}
}else if(fivePages.isSelected() == true){
	System.out.println("LRU");
	
	ArrayList<Character> page = new ArrayList<Character>(5);
	ArrayList<Character> list = new ArrayList<Character>();
	ArrayList<Character> temp = new ArrayList<Character>(5);
	
	for(int j = 0; j < inputField.getText().length();j++){
		list.add(inputField.getText().charAt(j));
	}
	
	for(int i = 0; i < list.size(); i++){
		if(page.isEmpty()){
			
			page.add(list.get(i));
			
			System.out.println("Insert " + list.get(i) + " " + page);
				if(temp.size() != 5){
					temp.add(list.get(i));
				}else{
					temp.remove(0);
					temp.add(list.get(i));
					System.out.println("Insert " + list.get(i) + " " + page);
				}
			continue;
		
		}else if(page.contains(list.get(i))){
			if(temp.size() != 5){
				temp.add(list.get(i));
			}else{
				temp.remove(0);
			}
			temp.add(list.get(i));
			System.out.println("Insert " + list.get(i) + " " + page);
			continue;
			
		}else if(!page.contains(list.get(i)) && page.size() != 5){
			page.add(list.get(i));
			
				if(temp.size() != 5){
					temp.add(list.get(i));
				}else{
					temp.remove(0);
					temp.add(list.get(i));
				}
				System.out.println("Insert " + list.get(i) + " " + page);
			continue;
			
		}else {
			
			if(!page.get(0).equals(temp.get(1))){
			page.set(0, list.get(i));
			
				if(temp.size() != 5){
					temp.add(list.get(i));
				}else{
					temp.remove(0);
					temp.add(list.get(i));
				}
				System.out.println("Insert " + list.get(i) + " " + page);
			continue;
			
			} else{
				
				page.set(1, list.get(i));
					if(temp.size() != 5){
						temp.add(list.get(i));
					}else{
						temp.remove(0);
						temp.add(list.get(i));
					}
				
					System.out.println("Insert " + list.get(i) + " " + page);
				continue;
			}
		}
	}
}
			}
		});
		LRU.setBounds(164, 223, 117, 29);
		contentPane.add(LRU);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText("");
				
			}
		});
		btnClear.setBounds(293, 223, 117, 29);
		contentPane.add(btnClear);
	}
	
}
