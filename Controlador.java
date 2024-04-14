import javax.swing.JTextArea;

/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
  Autor: Daniel Nogueira
  Matricula: 201911910
  Inicio...: 04 de Agosto de 2021
  Alteracao: 04 de Agosto de 2021
  Nome.....: Controlador
  Funcao...: Classe que serve de intermediario no controle da animacao das barrinhas
  =-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Controlador {
  private Animacao esq, dir; //instancias de animacao
  private JTextArea textArea;

  public Controlador(JTextArea textArea){
    this.textArea = textArea;
  }

  //getters e setters
  public Animacao getEsq() {
    return esq;
  }

  public void setEsq(Animacao esq) {
    this.esq = esq;
  }

  public Animacao getDir() {
    return dir;
  }

  public void setDir(Animacao dir) {
    this.dir = dir;
  }

  public JTextArea getTextArea() {
    return textArea;
  }

  public void setTextArea(JTextArea textArea) {
    this.textArea = textArea;
  }

}
