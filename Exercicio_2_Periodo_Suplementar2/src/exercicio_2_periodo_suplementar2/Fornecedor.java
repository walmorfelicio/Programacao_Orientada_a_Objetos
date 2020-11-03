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
public class Fornecedor extends Pessoa{
    
    private double valorCredito, valorDivida;
    
    public Fornecedor(String nome, String endereco, String telefone, double valorCredito){
        super(nome, endereco, telefone);
        this.valorCredito = valorCredito;
    }
    
    public double getValorCredito(){
        return valorCredito;
    }
    
    public double getValorDivida(){
        return valorDivida;
    }
    
    public void setValorCredito(double valorCredito){
        this.valorCredito = valorCredito;
    }
    
    public void setValorDivida(double valorDivida){
        this.valorDivida = valorDivida;
    }
    
    public double obterSaldo(){
        return valorCredito - valorDivida;
    }
    
    public String toString(){
        return "\n\tFornecedor: " + getNome() + "\n\tEndereço: " + getEndereco() + "\n\tTelefone: " + getTelefone()
                + "\n\tValor do Crédito: R$ " + Double.toString(getValorCredito()) + "\n\tValor de alguma dívida: R$ " + 
                Double.toString(getValorDivida());
    }
}
