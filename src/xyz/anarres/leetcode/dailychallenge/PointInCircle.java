package xyz.anarres.leetcode.dailychallenge;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;

import javax.swing.JFrame;

/**
 * Given the radius and x-y positions of the center of a circle, write a function randPoint which generates a uniform random point in the circle.
 * - input and output values are in floating-point.
 * - radius and x-y position of the center of the circle is passed into the class constructor.
 * - a point on the circumference of the circle is considered to be in the circle.
 * - randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.
 * 
 * @author anarres
 *
 */
public class PointInCircle extends JFrame{
	double x_center = 0;
	double y_center = 0;
	double radius = 0;

	public PointInCircle(double radius, double x_center, double y_center) {
		// circle (center(x_center, y_center), radius)
		this.radius = radius;
		this.x_center = x_center;
		this.y_center = y_center;
		setTitle("uniform random numbers in circle");
	}

	public static void main(String[] args) {
		PointInCircle circle = new PointInCircle(500, 500, 500);
		System.out.println(Arrays.toString(circle.randPoint()));
		
		// lets see what'll do, in a simple case
		circle.setSize(1000, 1000);
		circle.setVisible(true);
		circle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		circle.repaint();

		circle = new PointInCircle(10, 5, -7.5);
		System.out.println(Arrays.toString(circle.randPoint()));

	}
	public double[] randPoint() {
		// our random point will be at distance dependent on root, from the center

		double distance = Math.sqrt(Math.random()) * radius;
		double angle = 2 * Math.random() * Math.PI;
		double x = x_center + distance * Math.cos(angle);
		double y = y_center + distance * Math.sin(angle);

		return (new double[] {x, y});
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i<100000; i++) {
			double[] point = randPoint();
			int x = (int)(point[0]);
			int y = (int)(point[1]);
			
			// System.out.println(x + ", " + y);
			g2d.drawLine(x, y, x, y);
		}
	}
}
