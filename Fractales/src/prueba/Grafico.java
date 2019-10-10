package prueba;
import java.applet.Applet;
import java.awt.Graphics;

public class Grafico extends Applet {
 double xp1=0;
 double y=10;
 double xp2=900;

 int nivel_de_recursividad=7;

 public Grafico() { }

 public static void main(String[] args) { }

 public void paint(Graphics g){
   paintRecursivo(g,nivel_de_recursividad,xp1,y,xp2);
 }

 private void paintRecursivo(Graphics g, int i, double xp12, double y0, double xp22) {
	 double dx=(xp22-xp12)/3.;
	 double dy=y0+100;
	
	 if(i<=0){
	      g.drawLine((int)xp12,(int)y0,(int)xp22,(int)y0);
	 }
	 else{
	     paintRecursivo(g,i-1,xp12,dy,xp12+dx);
	     paintRecursivo(g,i-1,xp22-dx,dy,xp22);
	     g.drawLine((int)xp12,(int)y0,(int)xp22,(int)y0);
   
} }}