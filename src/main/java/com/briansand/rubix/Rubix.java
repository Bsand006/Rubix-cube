package com.briansand.rubix;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ToolTipManager;

import org.jogamp.java3d.BranchGroup;
import org.jogamp.java3d.Canvas3D;
import org.jogamp.java3d.utils.universe.SimpleUniverse;

public class Rubix extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1261033389971153019L;

	public Rubix() {

		setLayout(new BorderLayout());

		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();

		Canvas3D canvas = new Canvas3D(config);

		SimpleUniverse universe = new SimpleUniverse(canvas);

		BranchGroup group = new BranchGroup();

		add("Center", canvas);

		universe.getViewingPlatform().setNominalViewingTransform();

		universe.getViewer().getView().setBackClipDistance(100.0);

		universe.addBranchGraph(group);

	}

	public static void main(String[] args) {

		System.setProperty("sun.awt.noerasebackground", "true");

		JPopupMenu.setDefaultLightWeightPopupEnabled(false);

		ToolTipManager ttm = ToolTipManager.sharedInstance();

		Rubix main = new Rubix();

		JFrame f = new JFrame("JFrame");

		f.setSize(750, 500);

		f.getContentPane().add(main);

		f.setVisible(true);
	}

}
