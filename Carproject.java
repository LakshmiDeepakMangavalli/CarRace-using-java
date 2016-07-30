import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Carproject extends JPanel implements KeyListener
{

	int x=690;   //starting point of divider lines
	int y=0,y1=125,y2=250,y3=375,y4=500,y5=625,y6=750,y7=875;

	int xp1=600;    //pot hole1
	int yp1=-400;

	int xp2=650;    //pot hole2
	int yp2=-1000;

	int xp3=800;   //pot hole3
	int yp3=-700;

	int xend=500;    //ending strip
	int yend=-1500; 

	int carx=595; //car red rect position
   	int cary=615;

	int carLength = 50; //car red rect
   	int carWidth = 100;

	int x1=595;   //car yellow rect position
	int yg=640;

	int l=50;  //car yellow rect
	int w=55;

	Label t=new Label("GAME OVER");   //labels
	Label t1=new Label("YOU WIN");
	Font myFont = new Font("Courier", Font.BOLD,50);  //setting font
 	
	private void movement()     //movements
	{

		y+=1;     //divider lines movement
		y1+=1;
		y2+=1;
		y3+=1;
		y4+=1;
		y5+=1;
		y6+=1;
		y7+=1;

		if(y==900)     //recycling divider lines
			y=-100;
		if(y1==900)
			y1=-100;
		if(y2==900)
			y2=-100;
		if(y3==900)
			y3=-100;
		if(y4==900)
			y4=-100;
		if(y5==900)
			y5=-100;
		if(y6==900)
			y6=-100;
		if(y7==900)
			y7=-100;

		if( (yp1>=cary && yp1<=(cary+100) && xp1<=(carx+50) && xp1>=carx) || (yp1>=cary && yp1<=(cary+100) && xp1+50<=(carx+50) && xp1+50>=carx) || (yp1+30>=cary && yp1+30<=(cary+100) && xp1+25<=(carx+50) && xp1+25>=carx) )    //Game over
		{
			t.setBounds(500,200,400,200);
			t.setForeground(Color.white);
			t.setBackground(Color.black);
			t.setFont(myFont);
			add(t);
			yend=-10000;
		}

		yp1=yp1+1;

		if( (yp2>=cary && yp2<=(cary+100) && xp2<=(carx+50) && xp2>=carx) || (yp2>=cary && yp2<=(cary+100) && xp2+50<=(carx+50) && xp2+50>=carx) || (yp2+30>=cary && yp2+30<=(cary+100) && xp2+25<=(carx+50) && xp2+25>=carx) )    //Game over
		{
			t.setBounds(500,200,400,200);
			t.setForeground(Color.white);
			t.setBackground(Color.black);
			t.setFont(myFont);
			add(t);
			yend=-10000;
		}

		yp2=yp2+1;

		if( (yp3>=cary && yp3<=(cary+100) && xp3<=(carx+50) && xp3>=carx) || (yp3>=cary && yp3<=(cary+100) && xp3+50<=(carx+50) && xp3+50>=carx) || (yp3+30>=cary && yp3+30<=(cary+100) && xp3+25<=(carx+50) && xp3+25>=carx) )    //Game over
		{
			t.setBounds(500,200,400,200);
			t.setForeground(Color.white);
			t.setBackground(Color.black);
			t.setFont(myFont);
			add(t);
			yend=-10000;
		}

		yp3=yp3+1;
	
		if(cary==yend)    //you won
		{
			t1.setBounds(500,200,400,200);
			t1.setForeground(Color.white);
			t1.setBackground(Color.black);
			t1.setFont(myFont);
			add(t1);
		}

		yend=yend+1;		
	}

	public void paint(Graphics g) 
	{
		g.setColor(Color.black);
		g.fillRect(0,0,1400,900);

		g.setColor(Color.cyan); //baground except road
		g.fillRect(0,0,500,900);
		g.fillRect(900,0,500,900);

	      	g.setColor(Color.white);
		g.fillRect(x, y, 10, 75);    //designing divider lines
		g.fillRect(x,y1,10,75);
		g.fillRect(x,y2,10,75);
		g.fillRect(x,y3,10,75);
		g.fillRect(x,y4,10,75);	
		g.fillRect(x,y5,10,75);
		g.fillRect(x,y6,10,75);	
		g.fillRect(x,y7,10,75);

		g.setColor(Color.magenta); //pot hole1
		g.fillOval(xp1,yp1,50,30);

		g.setColor(Color.magenta); //pot hole2
		g.fillOval(xp2,yp2,50,30);

		g.setColor(Color.magenta); //pot hole3
		g.fillOval(xp3,yp3,50,30);

		g.setColor(Color.white);
		g.fillRect(xend,yend,400,10);  //designing end strip

		g.setColor(Color.red);  //car red rect
 		g.fillRect(carx, cary, carLength, carWidth);

		g.setColor(Color.yellow);  //car yellow rect
		g.fillRect(x1,yg,l,w); 
 		
	}

	public void keyPressed(KeyEvent e) 
	{
      		if (e.getKeyChar() == 'S' || e.getKeyChar() == 's'||e.getKeyCode() == KeyEvent.VK_DOWN)    //movement down
		{
                	cary += 2;
 			yg+=2;
      		}
      		if (e.getKeyChar() == 'W' || e.getKeyChar() == 'w'||e.getKeyCode() == KeyEvent.VK_UP)   //movement front
		{
         		cary-= 2;
       			yg-=2;
      		}
      		if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a'||e.getKeyCode() == KeyEvent.VK_LEFT)    //movement left
		{
         		carx -= 2;
         		x1-=2;
			if(carx<=500)
			{
				t.setBounds(500,200,400,200);  //game over left side
				t.setForeground(Color.white);
				t.setBackground(Color.black);
				t.setFont(myFont);
				add(t);
				yend=-10000;
			}
		}
		if (e.getKeyChar() == 'D' || e.getKeyChar() == 'd'||e.getKeyCode() == KeyEvent.VK_RIGHT)   //movement right
		{
			carx += 2;
       			x1+=2;

			if((carx+50)>=900)
			{
				t.setBounds(500,200,400,200);  //game over right side
				t.setForeground(Color.white);
				t.setBackground(Color.black);
				t.setFont(myFont);
				add(t);
				yend=-10000;
			}
		}
 		repaint();
	}

   	public void keyReleased(KeyEvent e) 
	{
	}
	public void keyTyped(KeyEvent e) 
	{
   	}
  	public void addKeyListner()
	{
	}

	public static void main(String args[]) throws InterruptedException 
	{
		JFrame fm = new JFrame("ROAD FIGHTER");   //designing frame
		Carproject p=new Carproject();
		fm.add(p);
		fm.setSize(1400, 900);
		fm.setVisible(true);
		fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fm.addKeyListener(p);
		for( ; ; )
		{
			p.movement();
			p.repaint();
			Thread.sleep(10);
		}
	}
}
