package banco;
import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {
    
    private String cidade;
    private String agencia;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Conta_Corrente> conta_Corrente = new ArrayList<Conta_Corrente>();
    
    public Agencia(){ }
    
    public Agencia(String cidade, String agencia){
        this.cidade = cidade;
        this.agencia = agencia;
    }
    
    public ArrayList<Conta_Corrente> getContas(){
        return conta_Corrente;
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public ArrayList<Conta_Corrente> getConta_Corrente() {
        return conta_Corrente;
    }

    public void setConta_Corrente(ArrayList<Conta_Corrente> conta_Corrente) {
        this.conta_Corrente = conta_Corrente;
    }
    
    public int checarCPF(String cpf){
        if(cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")){
          for(Cliente client : clientes){
            if(client.getCPF().equals(cpf))
               return 1;   /*   CPF existente de um Cliente.     */
          }
        }else{
           return 0;    /*   CPF do Cliente não foi inserido corretamente.    */
        }
        return -1;    /*   Cliente, com tal CPF, não está cadastrado no Banco.     */
    }
    
    public int atualizarDadosCliente(Agencia agencia, String cpf){
        String nome, endereco;
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        for(Cliente cli : agencia.getClientes()){
            if(cli.getCPF().equals(cpf)){
               System.out.print("\n\tNome >>  ");
               nome = in.nextLine();
               System.out.print("\n\tEndereco >> ");
               endereco = in.nextLine();
               cli.setNome(nome);
               cli.setEndereco(endereco);
               return 1;  /* OK  */
            }
        }
        return 0; /* Dados não foram atualizados, pois o cliente não está no Banco. */
    }
    
    public int criarCliente(){
        String cpf, nome, endereco, numContaCorrente;
        double saldo;
        Scanner entradaDados = new Scanner(System.in);
        Scanner entradaDados2;
        while(true){
            System.out.print("\n\tInforme o seu CPF >>  ");
            cpf = entradaDados.nextLine();
            if(cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}"))  // Confere se foi inserido no formato correto de um CPF.
               break;
            System.out.println("\n\tTente Novamente, pois o formato do CPF está inválido.");
        }
        for(Cliente cliente : clientes){
            if(cliente.getCPF().equals(cpf)){
                System.out.println("\n\tCPF " + cpf + " já está cadastrado.");
                return 1;
            }
        }
        System.out.print("\n\tNome >>  ");
        nome = entradaDados.nextLine();
        System.out.print("\n\tEndereço >>  ");
        endereco = entradaDados.nextLine();
        while(true){
            System.out.print("\n\tNúmero da Conta Corrente >>  ");
            numContaCorrente = entradaDados.nextLine();
            if(numContaCorrente.matches("\\d{2}.\\d{3}-\\D"))  // Confere se foi inserido no formato correto uma conta corrente.
                break;
            System.out.print("\n\tTente Novamente");
        }
        entradaDados2 = new Scanner(System.in);
        System.out.print("\n\tSaldo >>  R$ ");
        saldo = entradaDados2.nextDouble();
        Cliente cliente = new Cliente(nome, cpf, endereco, numContaCorrente, saldo);
        clientes.add(cliente);
        criarContaCorrente(numContaCorrente, cpf, agencia, saldo);
        return 2;
    }
    
    public int excluirContaCorrente(String numContaCorrente){
        int total_contas = 0;
        int posicao_conta = 0;
        if(conta_Corrente.isEmpty() || numContaCorrente.isEmpty() || !(numContaCorrente.matches("\\d{2}.\\d{3}-\\D"))){
            //System.out.println("\n\tConta Corrente informada (" + numContaCorrente + ") não é válido.");
            return 0;
        }
        for(int i = 0; i < conta_Corrente.size(); ++i){
            if(conta_Corrente.get(i).getNumContaCorrente().equals(numContaCorrente)){
                posicao_conta = i;
                break;
            }else
                ++total_contas;
        }
        if(total_contas != conta_Corrente.size()){
            for(int j = 0; j < clientes.size(); ++j){
                if(clientes.get(j).getNumContaCorrente().equals(numContaCorrente)){
                    clientes.remove(j);
                    conta_Corrente.remove(posicao_conta);
                    break;
                }
            }
        }else{
            System.out.println("\n\tConta Corrente informada (" + numContaCorrente + ") não está no Banco.");
        }
        return 1;
    }
    
    public int criarContaCorrente(String numContaCorrente, String cpf, String agencia, double saldo){
        Conta_Corrente conta_corrente;
        Scanner entradaDados;
        for(Conta_Corrente conta : conta_Corrente){
            if(conta.getNumContaCorrente().equals(numContaCorrente)){
                System.out.println("\n\tConta Corrente já existe.");
                return 1;
            }
        }
        if(numContaCorrente.isEmpty()){
            entradaDados = new Scanner(System.in);
            while(true){
               System.out.print("\n\tNúmero da Conta Corrente >>  ");
               numContaCorrente = entradaDados.nextLine();
               if(numContaCorrente.matches("\\d{2}.\\d{3}-\\D")){  // Confere se foi inserido no formato correto uma conta corrente.
                 for(Conta_Corrente conta : conta_Corrente){
                  if(conta.getNumContaCorrente().equals(numContaCorrente)){
                     System.out.println("\n\tConta Corrente já existe.");
                     return 1;
                  }
                 }
                 break;
               }else{
                  System.out.println("\n\tTente Novamente");
               }
            }
        }
        conta_corrente = new Conta_Corrente(numContaCorrente, cpf, agencia, saldo);
        conta_Corrente.add(conta_corrente);
        return 2;
    }
    
}
