import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoa3 {
    private JFrame frame;
    private JTextField nomeField;
    private JRadioButton masculinoButton;
    private JRadioButton femininoButton;
    private JTextField idadeField;
    private JTextField numeroField; // Não editável
    private Pessoa umaPessoa;

    public FormPessoa3() {
        frame = new JFrame("Cadastro de Pessoa");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        // Número
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(new JLabel("Número:"), gbc);

        numeroField = new JTextField(20);
        numeroField.setEditable(false); // Campo número não editável
        gbc.gridx = 1;
        frame.add(numeroField, gbc);

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(new JLabel("Nome:"), gbc);

        nomeField = new JTextField(20);
        gbc.gridx = 1;
        frame.add(nomeField, gbc);

        // Sexo
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(new JLabel("Sexo:"), gbc);

        masculinoButton = new JRadioButton("Masculino (M)");
        femininoButton = new JRadioButton("Feminino (F)");

        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(masculinoButton);
        sexoGroup.add(femininoButton);

        JPanel sexoPanel = new JPanel();
        sexoPanel.add(masculinoButton);
        sexoPanel.add(femininoButton);
        gbc.gridx = 1;
        frame.add(sexoPanel, gbc);

        // Idade
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(new JLabel("Idade:"), gbc);

        idadeField = new JTextField(20);
        gbc.gridx = 1;
        frame.add(idadeField, gbc);

        // Botão OK
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    char sexo;

                    // Determinar o sexo selecionado
                    if (masculinoButton.isSelected()) {
                        sexo = 'M';
                    } else if (femininoButton.isSelected()) {
                        sexo = 'F';
                    } else {
                        throw new IllegalArgumentException("Por favor, selecione um sexo.");
                    }

                    int idade = Integer.parseInt(idadeField.getText());

                    umaPessoa = new Pessoa(nome, sexo, idade);
                    numeroField.setText(String.valueOf(Pessoa.getKp())); // Atualiza o campo número

                    JOptionPane.showMessageDialog(frame, "Pessoa cadastrada com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(okButton, gbc);

        // Botão Mostrar
        JButton showButton = new JButton("Mostrar");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (umaPessoa != null) {
                    JOptionPane.showMessageDialog(frame,
                            "Nome: " + umaPessoa.getNome() +
                                    "\nSexo: " + umaPessoa.getSexo() +
                                    "\nIdade: " + umaPessoa.getIdade() +
                                    "\nPessoas cadastradas: " + Pessoa.getKp());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhuma pessoa cadastrada ainda.");
                }
            }
        });
        gbc.gridx = 1;
        frame.add(showButton, gbc);

        // Botão Limpar
        JButton limparButton = new JButton("Limpar");
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeField.setText("");
                idadeField.setText("");
                numeroField.setText("");
                sexoGroup.clearSelection(); // Desmarca os botões de rádio
                umaPessoa = null; // Reseta a pessoa cadastrada
                JOptionPane.showMessageDialog(frame, "Formulário limpo com sucesso!");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(limparButton, gbc);

        // Botão Sair
        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela
            }
        });
        gbc.gridx = 1;
        frame.add(sairButton, gbc);

        // Configurações da janela
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FormPessoa3(); // Inicia o formulário
    }
}
