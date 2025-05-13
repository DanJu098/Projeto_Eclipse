package br.edu.fatecgru.view;
import java.util.List;
import java.util.ArrayList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;



import br.edu.fatecgru.dao.AlunoDAO;
import br.edu.fatecgru.dao.CampusDAO;
import br.edu.fatecgru.dao.CursoDAO;
import br.edu.fatecgru.model.Aluno;
import br.edu.fatecgru.model.Curso;
import br.edu.fatecgru.util.ConexaoBanco;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRa;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEnd;
	private JTextField txtMunicipio;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCel;
	private JFormattedTextField txtData;
	private JComboBox<String> cmbUf;
	private JComboBox<String> cmbCursos;
	private JComboBox<String> cmbCampus;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JRadioButton rdbtnMatutino;
	private JRadioButton rdbtnVespertino;
	private JRadioButton rdbtnNoturno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 540);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Aluno");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAluno();
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarAluno();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Consultar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarAluno();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Excluir");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirAluno();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Sair");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Notas e Faltas");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Salvar");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Alterar");
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Consultar");
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Excluir");
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_2 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Sobre");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//============
				JOptionPane.showMessageDialog(null, "Informações do Menu");
				//============
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 73, 752, 381);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(53, 40, 68, 24);
		panel.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("Nome");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(266, 40, 68, 24);
		panel.add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeNascimento.setBounds(53, 88, 130, 24);
		panel.add(lblDataDeNascimento);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(53, 144, 68, 24);
		panel.add(lblEmail);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereo.setBounds(53, 197, 68, 24);
		panel.add(lblEndereo);
		
		JLabel lblMunicpio = new JLabel("Município");
		lblMunicpio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMunicpio.setBounds(53, 258, 68, 24);
		panel.add(lblMunicpio);
		
		JLabel lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf_1.setBounds(300, 88, 68, 24);
		panel.add(lblCpf_1);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUf.setBounds(300, 258, 30, 24);
		panel.add(lblUf);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(419, 258, 68, 24);
		panel.add(lblCelular);
		
		txtRa = new JTextField();
		txtRa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRa.setBounds(97, 42, 86, 20);
		panel.add(txtRa);
		txtRa.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(344, 42, 371, 20);
		panel.add(txtNome);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(131, 148, 584, 20);
		panel.add(txtEmail);
		
		txtEnd = new JTextField();
		txtEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEnd.setColumns(10);
		txtEnd.setBounds(131, 201, 584, 20);
		panel.add(txtEnd);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(131, 262, 159, 20);
		panel.add(txtMunicipio);
		
		cmbUf = new JComboBox<>();
        cmbUf.setModel(new DefaultComboBoxModel<>(new String[] { "-", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cmbUf.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cmbUf.setBounds(339, 262, 67, 22);
        panel.add(cmbUf);
		
		txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtData.setBounds(191, 90, 86, 20);
		panel.add(txtData);
		
		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpf.setBounds(344, 90, 130, 20);
		panel.add(txtCpf);

		
		txtCel = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		txtCel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCel.setBounds(497, 260, 108, 20);
		panel.add(txtCel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurso.setBounds(10, 57, 68, 24);
		panel_1.add(lblCurso);
		
		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCampus.setBounds(10, 115, 68, 24);
		panel_1.add(lblCampus);
		
		JLabel lblPerodo = new JLabel("Período");
		lblPerodo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPerodo.setBounds(10, 190, 68, 24);
		panel_1.add(lblPerodo);
		
		cmbCursos = new JComboBox();
		cmbCursos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbCursos.setBounds(95, 58, 309, 22);
		panel_1.add(cmbCursos);
		
		cmbCampus = new JComboBox();
		cmbCampus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbCampus.setBounds(95, 118, 309, 22);
		panel_1.add(cmbCampus);
		
		JButton btnNewButton = new JButton("Matricular");
		btnNewButton.setBounds(10, 264, 94, 78);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.setBounds(220, 264, 94, 78);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Consultar");
		btnNewButton_2.setBounds(446, 264, 94, 78);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Desmatricular");
		btnNewButton_3.setBounds(633, 264, 104, 78);
		panel_1.add(btnNewButton_3);
		
		lblNewLabel_3 = new JLabel("RA");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 6, 68, 24);
		panel_1.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(95, 8, 86, 20);
		panel_1.add(textField);
		
		rdbtnMatutino = new JRadioButton("Matutino");
		rdbtnMatutino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMatutino.setBounds(95, 193, 121, 23);
		panel_1.add(rdbtnMatutino);
		
		rdbtnVespertino = new JRadioButton("Vespertino");
		rdbtnVespertino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnVespertino.setBounds(323, 193, 121, 23);
		panel_1.add(rdbtnVespertino);
		
		rdbtnNoturno = new JRadioButton("Noturno");
		rdbtnNoturno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNoturno.setBounds(531, 193, 121, 23);
		panel_1.add(rdbtnNoturno);
		
		ButtonGroup periodo = new ButtonGroup();
		periodo.add(rdbtnMatutino);
		periodo.add(rdbtnVespertino);
		periodo.add(rdbtnNoturno);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("RA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(36, 41, 68, 24);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblnomeDoAluno = new JLabel("//nome do aluno");
		lblnomeDoAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnomeDoAluno.setBounds(223, 41, 420, 24);
		panel_2.add(lblnomeDoAluno);
		
		JLabel lblcursoDoAluno = new JLabel("//curso do aluno");
		lblcursoDoAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcursoDoAluno.setBounds(36, 95, 607, 24);
		panel_2.add(lblcursoDoAluno);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplina.setBounds(36, 148, 68, 24);
		panel_2.add(lblDisciplina);
		
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSemestre.setBounds(36, 204, 68, 24);
		panel_2.add(lblSemestre);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota.setBounds(223, 204, 38, 24);
		panel_2.add(lblNota);
		
		JLabel lblFaltas = new JLabel("Faltas");
		lblFaltas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaltas.setBounds(355, 204, 38, 24);
		panel_2.add(lblFaltas);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setBounds(88, 45, 86, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(403, 206, 86, 20);
		panel_2.add(textField_6);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2.setBounds(106, 149, 383, 22);
		panel_2.add(comboBox_2);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2_1.setBounds(112, 205, 77, 22);
		panel_2.add(comboBox_2_1);
		
		JComboBox comboBox_2_2 = new JComboBox();
		comboBox_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2_2.setBounds(271, 205, 38, 22);
		panel_2.add(comboBox_2_2);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(30, 249, 94, 78);
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(166, 249, 94, 78);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setBounds(301, 249, 94, 78);
		panel_2.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_2 = new JButton("New button");
		btnNewButton_3_2.setBounds(460, 249, 94, 78);
		panel_2.add(btnNewButton_3_2);
		
		JButton btnNewButton_3_1_1 = new JButton("New button");
		btnNewButton_3_1_1.setBounds(613, 249, 94, 78);
		panel_2.add(btnNewButton_3_1_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("RA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 11, 68, 24);
		panel_3.add(lblNewLabel_2);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(54, 13, 86, 20);
		panel_3.add(textField_7);
		
		JLabel lblCpf_2 = new JLabel("//nome do aluno");
		lblCpf_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf_2.setBounds(173, 11, 552, 24);
		panel_3.add(lblCpf_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Curso");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 46, 54, 24);
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("// curso do aluno");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(84, 44, 641, 24);
		panel_3.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Disciplina");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(10, 93, 68, 24);
		panel_3.add(lblNewLabel_2_1_2);
		
		JComboBox comboBox_2_3 = new JComboBox();
		comboBox_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2_3.setBounds(84, 96, 379, 22);
		panel_3.add(comboBox_2_3);
		
		JLabel lblSemestre_1 = new JLabel("Semestre");
		lblSemestre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSemestre_1.setBounds(489, 93, 68, 24);
		panel_3.add(lblSemestre_1);
		
		JLabel lblSemestre_3 = new JLabel("// semestre ");
		lblSemestre_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSemestre_3.setBounds(573, 93, 98, 24);
		panel_3.add(lblSemestre_3);
		
		JLabel lblNota_1 = new JLabel("Nota");
		lblNota_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota_1.setBounds(10, 157, 38, 24);
		panel_3.add(lblNota_1);
		
		JLabel lblFaltas_1 = new JLabel("Faltas");
		lblFaltas_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaltas_1.setBounds(10, 198, 38, 24);
		panel_3.add(lblFaltas_1);
		
		JLabel lblNota_1_1 = new JLabel("//nota do aluno");
		lblNota_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota_1_1.setBounds(58, 157, 98, 24);
		panel_3.add(lblNota_1_1);
		
		JLabel lblFaltas_1_1 = new JLabel("//faltas do aluno");
		lblFaltas_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaltas_1_1.setBounds(68, 198, 114, 24);
		panel_3.add(lblFaltas_1_1);
		
		
		preencherComboBoxCursos();
		preencherComboBoxCampus();
		
	}
	private void salvarAluno() {
	    try {
	        Aluno aluno = new Aluno();
	        aluno.setRA(txtRa.getText());
	        aluno.setNome(txtNome.getText());
	        aluno.setEmail(txtEmail.getText());
	        aluno.setEndereco(txtEnd.getText());
	        aluno.setMunicipio(txtMunicipio.getText());
	        aluno.setUf((String) cmbUf.getSelectedItem());
	        aluno.setCpf(txtCpf.getText());
	        aluno.setCelular(txtCel.getText());
	        aluno.setDataNasc(txtData.getText());

	        Connection conexao = ConexaoBanco.getConexao(); // ou sua classe de conexão
	        AlunoDAO alunoDAO = new AlunoDAO(conexao);
	        alunoDAO.salvar(aluno);

	        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
	        limparCampos();

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Erro ao salvar aluno: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	private void alterarAluno() {
	    try {
	        Aluno aluno = new Aluno();
	        aluno.setRA(txtRa.getText());
	        aluno.setNome(txtNome.getText());
	        aluno.setEmail(txtEmail.getText());
	        aluno.setEndereco(txtEnd.getText());
	        aluno.setMunicipio(txtMunicipio.getText());
	        aluno.setUf((String) cmbUf.getSelectedItem());
	        aluno.setCpf(txtCpf.getText());
	        aluno.setCelular(txtCel.getText());
	        aluno.setDataNasc(txtData.getText());

	        Connection conexao = ConexaoBanco.getConexao(); // ou sua classe de conexão
	        AlunoDAO alunoDAO = new AlunoDAO(conexao);
	        alunoDAO.alterar(aluno);

	        JOptionPane.showMessageDialog(this, "Aluno alterado com sucesso!");
	        limparCampos();

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Erro ao salvar aluno: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	private void consultarAluno() {
	    try {
	        String ra = txtRa.getText();
	        Connection conexao = ConexaoBanco.getConexao(); // sua conexão
	        AlunoDAO alunoDAO = new AlunoDAO(conexao);
	        Aluno aluno = alunoDAO.consultar(ra);

	        if (aluno != null) {
	            txtNome.setText(aluno.getNome());
	            txtCpf.setText(aluno.getCpf());
	            txtData.setText(aluno.getDataNasc());
	            txtEnd.setText(aluno.getEndereco());
	            txtEmail.setText(aluno.getEmail());
	            txtMunicipio.setText(aluno.getMunicipio());
	            cmbUf.setSelectedItem(aluno.getUf());
	            txtCel.setText(aluno.getCelular());
	            
	        } else {
	            JOptionPane.showMessageDialog(this, "Aluno não encontrado com RA: " + ra);
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Erro ao consultar aluno: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	private void excluirAluno() {
		try {
			String ra = txtRa.getText();
	        Connection conexao = ConexaoBanco.getConexao(); // sua conexão
	        AlunoDAO alunoDAO = new AlunoDAO(conexao);
	        alunoDAO.excluir(ra);
	        JOptionPane.showMessageDialog(this, "Aluno excluído com sucesso!");
	        limparCampos();
		
		}catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Erro ao consultar aluno: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	public void preencherComboBoxCursos() {
	    try {
	        Connection conn = ConexaoBanco.getConexao(); // ou outro método que retorna sua conexão
	        CursoDAO cursoDAO = new CursoDAO(conn);
	        List<String> cursos = cursoDAO.listarCursos();
	        
	        cmbCursos.removeAllItems(); // Limpa antes de adicionar novos
	        cmbCursos.addItem("-");
	        for (String curso : cursos) {
	            cmbCursos.addItem(curso);
	        }

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Erro ao consultar cursos: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	public void preencherComboBoxCampus() {
	    try {
	        Connection conn = ConexaoBanco.getConexao(); // ou outro método que retorna sua conexão
	        CampusDAO campusDAO = new CampusDAO(conn);
	        List<String> campus = campusDAO.listarCampus();
	        
	        cmbCampus.removeAllItems(); // Limpa antes de adicionar novos
	        cmbCampus.addItem("-");
	        for (String campuss : campus) {
	            cmbCampus.addItem(campuss);
	        }

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Erro ao consultar cursos: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	
	private void limparCampos() {
	    txtRa.setText("");
	    txtNome.setText("");
	    txtEmail.setText("");
	    txtEnd.setText("");
	    txtMunicipio.setText("");
	    txtCpf.setText("");
	    txtCel.setText("");
	    txtData.setText("");
	    cmbUf.setSelectedIndex(0);
	}
}