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

public class Administrador extends Empregado{
    
    private double ajudaDeCusto;
    
    public Administrador(String nome, String endereco, String telefone, double ajudaDeCusto){
        super(nome, endereco, telefone);
        this.ajudaDeCusto = ajudaDeCusto;
    }
    
    public double getAjudaDeCusto(){
        return ajudaDeCusto;
    }
    
    public void setAjudaDeCusto(double ajudaDeCusto){
        this.ajudaDeCusto = ajudaDeCusto;
    }
    
    public double calcularSalario(){
        setSalario(getSalario() + this.ajudaDeCusto);
        return getSalario();
    }
    
    public String toString(){
        return "\n\tAdministrador: " + getNome() + "\n\tEndereço: " + getEndereco() + "\n\tTelefone: " + getTelefone()
                + "\n\tSalário: R$ " + Double.toString(getSalario()) + "\n\tAjuda de Custo: R$ " + 
                Double.toString(getAjudaDeCusto());
    }
    
}
