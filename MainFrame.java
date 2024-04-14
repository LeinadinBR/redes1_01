import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
  Autor: Daniel Nogueira
  Matricula: 201911910
  Inicio...: 30 de Julho de 2021
  Alteracao: 20 de Fevereiro de 2022
  Nome.....: MainFrame
  Funcao...: Classe que serve de frame principal do programa
  =-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class MainFrame extends JFrame {
  private Display display;                //objeto de display
  private PanelSimulacao panelSimulacao;  //painel onde a animacao de simulacao acontece
  private PanelTexto panelTexto;          //painel onde os textos e botaos estao
  private MeioComunicacao meioComunicacao;  //simulacao do meio de comunicacao
  private MeioFisico meioFisicoTransmissor, meioFisicoReceptor;  //simulacao do meio fisico
  private MeioAplicacao meioAplicacaoTransmissor, meioAplicacaoReceptor;  //simulacao do meio de aplicacao
  private Controlador controle;                                           //objeto de controle
  private JTextArea textArea;

  /* *********************
  * Metodo: MainFrame
  * Funcao: construtor
  * Parametros: nenhum
  ********************* */
  public MainFrame(){
    inicializar();

    this.setLayout(null);
    this.add(panelTexto);
    this.add(textArea);
    this.add(panelSimulacao);

    this.setSize(new Dimension(900, 650));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setFocusable(false);
    this.setVisible(true);
    this.setTitle("Whatsapp 3 - Potencia Maxima");
    this.setLocationRelativeTo(null);

    acaoDoTextField();
    renderizar();
  }

  /* *********************
  * Metodo: inicializar
  * Funcao: inicializa os objetos da classe
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  private void inicializar(){
    textArea = new JTextArea();
    textArea.setLayout(null);
    textArea.setBounds(100, 500, 700, 60);
    textArea.setVisible(false);
    textArea.setEditable(false);

    controle = new Controlador(textArea);

    display = new Display();
    panelTexto = new PanelTexto();
    panelTexto.setBounds(0, 0, 900, 50);
    panelSimulacao = new PanelSimulacao(display, panelTexto, textArea);
    panelSimulacao.setBounds(0, 5, 900, 600);

    controle.setDir(panelSimulacao.getBarrinhaDir());
    controle.setEsq(panelSimulacao.getBarrinhaEsq());

    meioAplicacaoTransmissor = new MeioAplicacao(panelTexto.getTexto1(), controle);
    meioAplicacaoReceptor = new MeioAplicacao(panelTexto.getTexto2(), controle);
    meioFisicoTransmissor = new MeioFisico(meioAplicacaoTransmissor, controle);
    meioFisicoReceptor = new MeioFisico(meioAplicacaoReceptor, controle);
    meioComunicacao = new MeioComunicacao(meioFisicoTransmissor, meioFisicoReceptor, controle);
  }

  /* *********************
  * Metodo: renderizar
  * Funcao: chama a funcao de renderizar de panelSimulacao
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  private void renderizar(){
    panelSimulacao.renderizar();
  }

  /* *********************
  * Metodo: acaoDoTextField
  * Funcao: da a acao para o botao que envia as mensagens
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  private void acaoDoTextField(){
    panelTexto.getOkBtn().addActionListener(l -> {
      if (panelTexto.getTexto1().getText()!= null){
        meioAplicacaoTransmissor.codificarParaBits(meioAplicacaoTransmissor.getCaixaTexto().getText(), panelTexto.getComboBox().getSelectedIndex());
        panelTexto.getTexto1().setText("");
      }
    });
  }
}
