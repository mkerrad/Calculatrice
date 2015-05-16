import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculatrice implements ActionListener
{
	JTextArea barre;
	double nb;
	int i;
	boolean test;
	String operator;
	public Calculatrice()
	{
		JFrame calc = new JFrame("Calculatrice");
		calc.setSize(400,400);
		JPanel fond = new JPanel();
		JPanel clavier = new JPanel();
		JPanel operation = new JPanel();
		JPanel clean = new JPanel();
		JPanel égal = new JPanel();
		égal.setLayout(new BorderLayout());
		fond.setLayout(new BorderLayout());
		operation.setLayout(new GridLayout(4,1));
		clean.setLayout(new GridLayout(2,1));
		clavier.setLayout(new GridLayout(4,3));
		JButton[] boutons = new JButton[10];
		for (i=1;i<10;i++)
		{
			boutons[i] = new JButton(String.valueOf(i));
			boutons[i].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				String str = ((JButton)arg0.getSource()).getText();
				if (test)
				{
					test = false;
				}
				else
				{
					if(!barre.getText().equals("0"))
					{
					str = barre.getText() + str;
					}
				}
				barre.setText(str);
			}
			});
		}
		JButton b10 = new JButton("0" );
		b10.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			String str = ((JButton)arg0.getSource()).getText();
			if (test)
			{
				test = false;
			}
			else
			{
				if(!barre.getText().equals("0"))
				{
				str = barre.getText() + str;
				}
			}
			barre.setText(str);
		}
		});
		JButton b11 = new JButton("," );
		b11.addActionListener(this);
		JButton b12 = new JButton("√" );
	    b12.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			double nb, resultat;
			nb = new Double(barre.getText());
			resultat = Math.sqrt(nb);
			setText(resultat);
		}
		});
		JButton plus = new JButton("+" );
		plus.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			double nb2;
			nb2 = new Double(barre.getText());
			nb = nb + nb2;
			setText(nb);
			test = true;
			operator = "+";
		}
		});
		JButton moins = new JButton("-" );
		moins.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			double nb2;
			nb2 = new Double(barre.getText());
			nb = - nb - nb2;
			setText(nb);
			test = true;
			operator = "-";
		}
		});
		JButton fois = new JButton("*" );
		fois.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			double nb2;
			nb2 = new Double(barre.getText());
			if(nb==0)
				nb=1;
			nb = nb * nb2;
			setText(nb);
			test = true;
			operator = "*";
		}
		});
		JButton divise = new JButton("/" );
		divise.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			double nb2;
			nb2 = new Double(barre.getText());
			if(nb==0)
			{
				nb=1;
				nb = nb2/nb;
			}
			else
			{
				nb=nb/nb2;
			}
			setText(nb);
			test = true;
			operator = "/";
		}
		});
		JButton c = new JButton("C" );
		c.addActionListener(new ActionListener(){ 
		public void actionPerformed(ActionEvent arg0) { 
			nb = 0;
			setText(nb);
			test = true;
		}
		});
		JButton carre = new JButton("x²" );
		carre.addActionListener(new ActionListener(){ 
		public void actionPerformed(ActionEvent arg0) { 
			double nb, resultat;
			nb = Float.parseFloat(barre.getText());
			resultat = nb*nb;
			setText(resultat);
		}
		});
		JButton egal = new JButton("=" );
		egal.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent arg0) { 
				if (operator == "+")
				{
					double nb2;
					nb2 = new Double(barre.getText());
					nb = nb + nb2;
					setText(nb);
					nb = 0;
					test = true;
				}
				else if (operator == "-")
				{
					double nb2;
					nb2 = new Double(barre.getText());
					nb = - nb - nb2;
					setText(nb);
					test = true;
				}
				else if (operator == "*")
				{
					double nb2;
					nb2 = new Double(barre.getText());
					if(nb==0)
						nb=1;
					nb = nb * nb2;
					setText(nb);
					test = true;
				}
				else if (operator == "/")
				{
					double nb2;
					nb2 = new Double(barre.getText());
					if(nb==0)
					{
						nb=1;
						nb = nb2/nb;
					}
					else
					{
						nb=nb/nb2;
					}
					setText(nb);
					test = true;
				}
			}
	    });
		for (i=1;i<10;i++)
		{
			clavier.add(boutons[i]);
		}
		clavier.add(b10);
		clavier.add(b11);
		clavier.add(b12);
		clean.add(c);
		clean.add(carre);
		operation.add(fois);
		operation.add(divise);
		operation.add(moins);
		operation.add(plus);
		barre= new JTextArea(2,2);
		barre.setLayout(new BorderLayout());
		égal.add(egal);
		fond.add(barre,BorderLayout.NORTH);
		fond.add(operation,BorderLayout.EAST);
		fond.add(clean,BorderLayout.WEST); 
		fond.add(clavier,BorderLayout.CENTER);
		fond.add(égal,BorderLayout.SOUTH);
		calc.setContentPane(fond);
		calc.setVisible(true);
		calc.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		calc.setResizable(false);
		calc.setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e)
	{ 
		String a = e.getActionCommand();
		barre.setText(a);
	}
	public static void main(String[] args) {
		new Calculatrice();
	}
	private void setText(Double nb)
	{
		if(nb-nb.intValue()==0)
			barre.setText(String.valueOf(nb.intValue()));
		else
			barre.setText(String.valueOf(nb));
	}
}