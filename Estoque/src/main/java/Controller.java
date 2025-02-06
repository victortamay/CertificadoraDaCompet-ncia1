
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Eduardo
 */
public class Controller {
    private static Controller controllerUnic;
    private static Banco bd;
    
    private Controller() {
        bd = Banco.getBanco();
    }
    
    public static Controller getController() {
        if(controllerUnic == null) {
            controllerUnic = new Controller();
        }
        
        return controllerUnic;
    }
    
    public void cadastrarFunc(String cpf, String nome, String email, String data, String cargo) throws EstoqueException {
        Funcionario f = bd.getFuncionario(cpf);
        if(f == null) {
            Funcionario novo = new Funcionario(cpf, nome, email, data, cargo);
            bd.addFuncionario(novo);
        } else {
            throw new EstoqueException("Funcionário já cadastrado.");
        }
    }
    
    public void cadastrarProduto(String nome, String cod, int quant, double custo, double venda) throws EstoqueException {
        Produto p = bd.getProduto(cod);
        
        if(p == null) {
            bd.addProduto(new Produto(nome, cod, quant, custo, venda));
            bd.getEntradas().add(new Produto(nome, cod, quant, custo, venda));
        } else {
            throw new EstoqueException("Produto já cadastrado");
        }
    }
    
    public void registrarEntrada(String cod, int quantidade) throws EstoqueException {
        Produto p = bd.getProduto(cod);
        
        if(p == null) {
            throw new EstoqueException("Produto não cadastrado.");
        } else {
            bd.registrarEntrada(cod, quantidade);
        }
    }
    
    public void registrarSaida(String cod, int quantidade) throws EstoqueException {
        Produto p = bd.getProduto(cod);
        
        if(p == null) {
            throw new EstoqueException("Produto não cadastrado.");
        } else if(p.getQuantidade() < quantidade) {
            throw new EstoqueException("Há apenas "+Integer.toString(p.getQuantidade())+" unidades desse produto em estoque.");
        } else {
            bd.registrarSaida(cod, quantidade);
        }
    }
    
    public void removerFuncionario(String cpf) throws EstoqueException {
        Funcionario f = bd.getFuncionario(cpf);
        if(f == null) {
            throw new EstoqueException("Esse funcionário não está cadastrado.");
        } else {
            bd.removerFuncionario(cpf);
        }
    }
}
