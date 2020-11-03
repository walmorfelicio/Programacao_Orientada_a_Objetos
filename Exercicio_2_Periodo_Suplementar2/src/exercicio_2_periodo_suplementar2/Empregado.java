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

public class Empregado extends Pessoa{
    
    private double salario;
    
    public Empregado() { }
    
    public Empregado(String nome, String endereco, String telefone){
        super(nome, endereco, telefone);
    }
    
    public double getSalario(){
        return salario;
    }
    
    public void setSalario(double salario){
        this.salario = salario;
    }
    
    public double calcularSalario(){
        return getSalario();
    }
    
}
