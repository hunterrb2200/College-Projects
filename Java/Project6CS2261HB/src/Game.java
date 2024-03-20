/*Hunter Beauto
 * CS2261
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame {
	//sets up buttons, labels, and threads
	JButton[][] square = new JButton[10][10];
    JButton button1, button2;
    static JLabel label = new JLabel();
    private Thread Timer;

    //main function for task 1
    Game() {
    //creates 10 x 10 grid of buttons	
    super("Whac-a-mole");
        JPanel panel = new JPanel(new GridLayout(10,10));
        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                square[x][y] = new JButton();
                panel.add(square[x][y]);
            }
        }    
        add(panel, BorderLayout.CENTER);      
        panel = new JPanel(new GridLayout(1,2));              
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);        
        setLocationRelativeTo(null);


    }
    
    //starts the timer and when to activate the random change for mole placements
    void start(){
    	Timer=new Thread(new Runnable(){
        	public void run(){
                        	 Runnable r=new Runnable(){                
                            	 public void run() {
                                	 buttonUpdate();  // calls every two seconds
                                 }
                             };
                             while (true){
                            	 javax.swing.SwingUtilities.invokeLater(r);
                                     try{Thread.sleep(2000);} catch (InterruptedException ex) {  
                                    	 return;
                                     }
                             }   
                         }
        }
        		);
        Timer.start();     
    }
    
    //The Random placement of Moles
    //EDIT: for some creates more than one mole 
    public void buttonUpdate(){
    	for(int x=0;x<square.length;x++){
    		for(int y=0;y<square[x].length;y++){
    			square[x][y].setText("");                         
    		}
    	}
    	Random rx=new Random();
    	Random ry=new Random();
    	for(int x=0;x<square.length;x++){
    		for(int y=0;y<square[x].length;y++){
    			int i=rx.nextInt(10)+1;
    			int j=ry.nextInt(10)+1;
    			square[i][j].setText("mole");                         
    		}
    	}
    }
 // stops GUI after closing
    public void processWindowEvent(WindowEvent e) { 
    	if (e.getID() == WindowEvent.WINDOW_CLOSING) {
    		if(Timer.isAlive()){
    			Timer.interrupt();
    		}
    		dispose();
    	}
    }
    
    //Main Start
	public static void main(String[] args) throws InterruptedException {
		final Game theTest=new Game();
		theTest.start();
	}

}
    
