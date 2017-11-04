package com.millan.RelojDespertador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;


public class Despertador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnDespertador;
	private JMenuItem mntmSalir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Despertador frame = new Despertador();
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
	public Despertador() {

		initComponents();
		
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		iniciarMenu();
		
	}

	private void iniciarMenu() {
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Menu Archivo
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setMnemonic('S');
		mnArchivo.add(mntmSalir);
		menuBar.add(mnArchivo);
		
		//Menu Despertador
		mnDespertador = new JMenu("Despertador");
		ButtonGroup grupoDespertadorActivo = new ButtonGroup();
		JRadioButtonMenuItem rdbtnmntmActivado = new JRadioButtonMenuItem("Activado");
		JRadioButtonMenuItem rdbtnmntmDesactivado = new JRadioButtonMenuItem("Desactivado");
		rdbtnmntmActivado.setSelected(true);
		grupoDespertadorActivo.add(rdbtnmntmActivado);
		grupoDespertadorActivo.add(rdbtnmntmDesactivado);
		mnDespertador.add(rdbtnmntmActivado);
		mnDespertador.add(rdbtnmntmDesactivado);
		menuBar.add(mnDespertador);
		
		//PopupMenu Pais
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		
		JMenuItem mntmAnadir = new JMenuItem("Añadir");
		JMenuItem mntmElimnar = new JMenuItem("Elimnar");
		JSeparator separator = new JSeparator();
		
		mntmElimnar.setVisible(false);
		separator.setVisible(false);
		
		popupMenu.add(mntmAnadir);
		popupMenu.add(mntmElimnar);
		popupMenu.add(separator);		
		
		//Menu Pais
		JMenu mnPais = new JMenu("Pais");
		mnPais.add(popupMenu);
		menuBar.add(mnPais);
		
		
		//Menu Ayuda
		JMenu mnAyuda = new JMenu("Ayuda");
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de", 'c');
		mnAyuda.add(mntmAcercaDe);
		menuBar.add(mnAyuda);
		
		
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
