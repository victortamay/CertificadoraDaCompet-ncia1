
import java.util.List;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Eduardo
 */
public class Banco {
    private static Banco bd;
    private static List<Funcionario> funcionarios;
    private static List<Produto> produtos;
    private static List<Produto> entradas;
    private static List<Produto> saidas;
    
    private Banco() {
        funcionarios = new ArrayList<Funcionario>();
        produtos = new ArrayList<Produto>();
        entradas = new ArrayList<Produto>();
        saidas = new ArrayList<Produto>();
    }
    
    public static Banco getBanco() {
        if(bd == null) {
            bd = new Banco();
        }
        return bd;
    }
    
    public Funcionario getFuncionario(String cpf) {
        for(Funcionario f : funcionarios) {
            if(f.getCpf().equals(cpf)) {
                return f;
            }
        }
        return null;
    }
    
    public void addFuncionario(Funcionario f) {
        funcionarios.add(f);
    }
    
    public void removerFuncionario(String cpf) {
        for(Funcionario f : funcionarios) {
            if(f.getCpf().equals(cpf)) {
                funcionarios.remove(f);
                break;
            }
        }
    }
    
    public void addProduto(Produto p) {
        produtos.add(p);
    }
    
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    } 
    
    public Produto getProduto(String cod) {
        for(Produto p : produtos) {
            if(p.getCodigoDeBarras().equals(cod)) {
                return p;
            }
        }
        
        return null;
    }
    
    public void registrarEntrada(String cod, int quantidade) {
        for(Produto p : produtos) {
            if(p.getCodigoDeBarras().equals(cod)) {
                p.setQuantidade(p.getQuantidade() + quantidade);
                entradas.add(new Produto(p.getNome(), cod, quantidade, p.getPrecoCusto(), p.getPrecoVenda()));
                break;
            }
        }
    }
            
    public List<Produto> getEntradas() {
        return entradas;
    }
    
    public void registrarSaida(String cod, int quantidade) {
        for(Produto p : produtos) {
            if(p.getCodigoDeBarras().equals(cod)) {
                p.setQuantidade(p.getQuantidade() - quantidade);
                saidas.add(new Produto(p.getNome(), cod, quantidade, p.getPrecoCusto(), p.getPrecoVenda()));
                break;
            }
        }
    }
    
    public List<Produto> getSaidas() {
        return saidas;
    }
}
