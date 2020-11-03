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

public class Exercicio_2_Periodo_Suplementar2 {

    public static void main(String[] args){
        // TODO code application logic here
        Vendedor vendedor = new Vendedor("João","Rua  JK","8899-0077");
        Fornecedor fornecedor = new Fornecedor("Thiago", "Rua JK 3", "8800-9977", 200);
        Administrador administrador = new Administrador("Walmor","Rua João Úrsulo", "8877-9900", 500);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\n\t\tDados do Vendedor\n\n" + vendedor.toString());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\n\t\tDados do Fornecedor\n\n" + fornecedor.toString());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\n\t\tDados do Administrador\n\n" + administrador.toString());
    }
    
}
