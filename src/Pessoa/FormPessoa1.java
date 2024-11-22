import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoa1 {
    private JFrame frame;
    private JTextField nomeField;
    private JTextField sexoField;
    private JTextField idadeField;
    private JTextField numeroField; // Não editável
    private Pessoa umaPessoa;

    public FormPessoa1() {
        frame = new JFrame("Cadastro de Pessoa");
        frame.setLayout(new GridLayout(6, 2)); // Ajustado para comportar os novos botões

        // Campos do formulário
        frame.add(new JLabel("Número:"));
        numeroField = new JTextField();
        numeroField.setEditable(false); // Campo número não editável
        frame.add(numeroField);

        frame.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        frame.add(nomeField);

        frame.add(new JLabel("Sexo:"));
        sexoField = new JTextField(); // Campo sexo como JTextField
        frame.add(sexoField);

        frame.add(new JLabel("Idade:"));
        idadeField = new JTextField();
        frame.add(idadeField);

        // Botão OK
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    char sexo = sexoField.getText().toUpperCase().charAt(0); // Garantir M/F maiúsculo
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
        frame.add(showButton);

        // Botão Limpar
        JButton clearButton = new JButton("Limpar");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeField.setText("");
                sexoField.setText("");
                idadeField.setText("");
                numeroField.setText("");
                umaPessoa = null; // Remove a pessoa cadastrada atual
            }
        });
        frame.add(clearButton);

        // Botão Sair
        JButton exitButton = new JButton("Sair");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fecha a aplicação
            }
        });
        frame.add(exitButton);

        // Configurações da janela
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new FormPessoa1(); // Inicia o formulário
    }
}
