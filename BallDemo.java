import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> misBolas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        misBolas = new ArrayList<BouncingBall>();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int nBolas)
    {
        Random aleatorio = new Random();
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        //crearvarias bolas
        for(int i=0;i<nBolas;i++){
            int radio= aleatorio.nextInt(25)+4;
            int r =aleatorio.nextInt(256);
            int v =aleatorio.nextInt(256);
            int a =aleatorio.nextInt(256); 
            int x =aleatorio.nextInt(256);
            int y =aleatorio.nextInt(156); 
            Color color= new Color(r,v,a);
            BouncingBall ball = new BouncingBall(x, y, radio, color, ground, myCanvas);
            ball.draw();
            misBolas.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50); 
            // small delay
            for(int i =0;i<nBolas;i++){
                misBolas.get(i).move();
                // stop once ball has travelled a certain distance on x axis
                if( misBolas.get(i).getXPosition() >= 550 ) {
                    finished = true;
                }
            }

            
        }
    }
}
