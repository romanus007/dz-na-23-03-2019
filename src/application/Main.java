package application;
	
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;


public class Main extends Application {
	
	@Override
	public void start(Stage ps) {
		ps.setTitle("Animation example");
		Group rout = new Group();
		Scene theScene =new Scene(rout);
		ps.setScene(theScene);
		
		Canvas canvas = new Canvas(1500,500);
		rout.getChildren().add(canvas);
		
		Image rectangle =new Image("rectangle.png");
		Image car =new Image("car2.jpg");
		Image background =new Image("background.png");
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		final long startNanoTime = System.nanoTime();
		
		ArrayList<String> input = new ArrayList<String>();
		theScene.setOnKeyPressed(
	            new EventHandler<KeyEvent>()
	            {
	                public void handle(KeyEvent e)
	                {
	                	// код клавиши
	                    String code = e.getCode().toString(); 
	                    if ( !input.contains(code) )
	                        input.add( code );
	                }
	            });
		
		theScene.setOnKeyReleased(
	            new EventHandler<KeyEvent>()
	            {
	                public void handle(KeyEvent e)
	                {
	                    String code = e.getCode().toString();
	                    input.remove( code );
	                }
	            });
		

	        // Создаем объекты изображений

	        Image left = new Image( "left.png" );
	        Image leftG = new Image( "leftG.png" );

	        Image right = new Image( "right.png" );
	        Image rightG = new Image( "rightG.png" );
		
		
		
		new AnimationTimer() {

			@Override
			
			public void handle(long t) {	                
				double diff = (t- startNanoTime)/1000000000.0;
				double x = diff*200;
				double y = +x;
				double z = 212 +x;
				double k = 424 +x;
				double l = 636 +x;
				double m = 848 +x;
				double o = 1060 +x;
				double p = 1272 +x;
				double q = 1484 +x;
				
				double a = 600-diff*30;
 				double b = 600+diff*30;
				
				
				int r = 50;
				while (r!=0) {
				if (y>1500) {
					y=y-1700;
				}
				if (z>1500) {
					z=z-1700;
				}
				if (k>1500) {
					k=k-1700;
				}
				if (l>1500) {
					l=l-1700;
				}
				if (m>1500) {
					m=m-1700;
				}
				if (o>1500) {
					o=o-1700;
				}
				if (p>1500) {
					p=p-1700;
				}
				if (q>1500) {
					q=q-1700;
				}
				if (a<100) {
					a=a+500;
				}
				if (b>1100) {
					b=b-500;
				}
				r-=1;
				}
				gc.drawImage(background, 0, 0);
				gc.drawImage(rectangle,y,80);
				gc.drawImage(rectangle,z,80);
				gc.drawImage(rectangle,k,80);
				gc.drawImage(rectangle,l,80);
				gc.drawImage(rectangle,m,80);
				gc.drawImage(rectangle,o,80);
				gc.drawImage(rectangle,p,80);
				gc.drawImage(rectangle,q,80);
				gc.drawImage(rectangle,y,380);
				gc.drawImage(rectangle,z,380);
				gc.drawImage(rectangle,k,380);
				gc.drawImage(rectangle,l,380);
				gc.drawImage(rectangle,m,380);
				gc.drawImage(rectangle,o,380);
				gc.drawImage(rectangle,p,380);
				gc.drawImage(rectangle,q,380);
				
                if (input.contains("LEFT")) {

                    gc.drawImage( car, a, 200 );
                }                
                else if (input.contains("RIGHT")) {
                    gc.drawImage( car, b, 200 );
                    
                    }
                else {
                    gc.drawImage( car, 600, 200 );
                }
							
			}
			
	
		}.start();
		ps.show();
		
			
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}