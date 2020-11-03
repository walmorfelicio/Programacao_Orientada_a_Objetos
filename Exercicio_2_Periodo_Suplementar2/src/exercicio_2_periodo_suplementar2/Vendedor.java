/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_2_periodo_suplementar2;

/**
 *
 * @author walmor
 */

public class Vendedor extends Empregado{
    
    /*
         valorVendas: valor monetário dos artigos vendidos.
         comissão: Porcentagem do valorVendas que será adicionado
         ao vencimento base do Vendedor.
    */
    
    private double valorVendas, comissao;
    
    public Vendedor(String nome, String endereco, String telefone){
        super(nome, endereco, telefone);
    }
    
    public double getValorVendas(){
        return valorVendas;
    }
    
    public void setValorVendas(double valorVendas){
        this.valorVendas = valorVendas;
    }
    
    public double getComissao(){
        return comissao;
    }
    
    public void setComissao(double comissao){
        this.comissao += comissao;
    }
    
    public double calcularSalario(){
        setSalario(getSalario() + this.comissao);
        return getSalario();
    }
    
    public String toString(){
        return "\n\tVendedor: " + getNome() + "\n\tEndereço: " + getEndereco() + "\n\tTelefone: " + getTelefone()
                + "\n\tValor de Vendas: R$ " + Double.toString(getValorVendas()) + "\n\tComissão: R$ " + 
                Double.toString(getComissao());
    }
}
