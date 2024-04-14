/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
  Autor: Daniel Nogueira
  Matricula: 201911910
  Inicio...: 03 de Agosto de 2021
  Alteracao: 20 de Fevereiro de 2022
  Nome.....: MeioComunicacao
  Funcao...: Classe que serve para simular o meio da comunicacao
  =-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class MeioComunicacao {
  private MeioFisico meioFisico1, meioFisico2;  //referencias aos meios fisicos que essa classe conecta
  private Controlador controle;                 //referencia ao controlador de animacao

  /* *********************
  * Metodo: MeioComunicacao
  * Funcao: Construtor
  * Parametros: MeioFisico meioFisico1, MeioFisico meioFisico2, Controlador controle
  ********************* */
  public MeioComunicacao(MeioFisico meioFisico1, MeioFisico meioFisico2, Controlador controle){
    this.meioFisico1 = meioFisico1;
    this.meioFisico1.setMeioComunicacao(this);
    this.meioFisico2 = meioFisico2;
    this.meioFisico2.setMeioComunicacao(this);
    this.controle = controle;
  }

  /* *********************
  * Metodo: transmitir
  * Funcao: Funcao que passa os bits de um MeioFisico para o outro
  * Parametros: int tipoCOdificacao
  * Retorno: void
  ********************* */
  public void transmitir(int tipoCodificacao){
    meioFisico2.setBitsArmazenados(new int[meioFisico1.getBitsArmazenados().length]);
    controle.getTextArea().setText("");
    //ele pausa a thread para que possa perceber a animacao
    try {
      for (int i=0; i<meioFisico1.getBitsArmazenados().length; i++){
        visualizarTransmissao(meioFisico1.getBitsArmazenados()[i]);
        meioFisico2.getBitsArmazenados()[i] = meioFisico1.getBitsArmazenados()[i];
      }
    }
    catch (InterruptedException e){
    }

    //passa para a proxima etapa do envio da mensagem
    meioFisico2.decodificaoEspecifica(tipoCodificacao);
  }

  /* *********************
  * Metodo: visualizarTransmissao
  * Funcao: Funcao que atualiza a caixa de texto
  * Parametros: int i
  * Retorno: void
  ********************* */
  public void visualizarTransmissao(int i) throws InterruptedException{
    String s = String.valueOf(i);
    controle.getTextArea().append(s + " ");
    Thread.sleep(50);
  }
}
