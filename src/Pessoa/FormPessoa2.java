import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoa2 {
    private JFrame frame;
    private JTextField nomeField;
    private JComboBox<String> sexoCombo; // Substituindo JTextField por JComboBox
    private JTextField idadeField;
    private JTextField numeroField; // Não editável
    private Pessoa umaPessoa;

    public FormPessoa2() {
        frame = new JFrame("Cadastro de Pessoa");
        frame.setLayout(new GridLayout(6, 2)); // Atualizando layout para acomodar os botões

        // Campos do formulário
        frame.add(new JLabel("Número:"));
        numeroField = new JTextField();
        numeroField.setEditable(false); // Campo número não editável
        frame.add(numeroField);

        frame.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        frame.add(nomeField);

        frame.add(new JLabel("Sexo:"));
        sexoCombo = new JComboBox<>(new String[]{"M", "F"}); // JComboBox para seleção de sexo
        frame.add(sexoCombo);

        frame.add(new JLabel("Idade:"));
        idadeField = new JTextField();
        frame.add(idadeField);

        // Botões
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    char sexo = sexoCombo.getSelectedItem().toString().charAt(0); // Seleção do JComboBox
                    int idade = Integer.parseInt(idadeField.getText());

                    umaPessoa = new Pessoa(nome, sexo, idade);
                    numeroField.setText(String.valueOf(Pessoa.getKp())); // Atualiza o campo número

                    JOptionPane.showMessageDialog(frame, "Pessoa cadastrada com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(okButton);

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
        frame.add(showButton);

        JButton clearButton = new JButton("Limpar");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpa os campos de texto e reseta a seleção do JComboBox
                nomeField.setText("");
                sexoCombo.setSelectedIndex(0); // Reseta para o primeiro item
                idadeField.setText("");
                numeroField.setText("");
                umaPessoa = null;
                JOptionPane.showMessageDialog(frame, "Campos limpos com sucesso!");
            }
        });
        frame.add(clearButton);

        JButton exitButton = new JButton("Sair");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fecha o programa
            }
        });
        frame.add(exitButton);

        // Configurações da janela
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new FormPessoa2(); // Inicia o formulário
    }
}
