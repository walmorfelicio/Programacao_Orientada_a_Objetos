package banco;
import java.util.Scanner;

public class Cliente {
    
    private String nome, cpf, endereco, numContaCorrente;
    private double saldo;
    
    public Cliente(String nome, String cpf, String endereco, String numContaCorrente, double saldo){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numContaCorrente = numContaCorrente;
        this.saldo = saldo;
    }
    
    public Cliente(){ }
    
    public void cadastrarInformações(Agencia agencia){
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.print("\n\tNome >>  ");
        this.nome = in.nextLine();
        while(true){
          System.out.print("\n\tInforme o seu CPF >>  ");
          this.cpf = in.nextLine();
          if(cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")){  // Confere se foi inserido no formato correto de um CPF.
             for(Cliente c : agencia.getClientes()){
                 if(c.getCPF().equals(cpf)){
                     System.out.println("\n\tCPF deste cliente já está cadastrado.");
                     return;
                 }
             }
             break;
          }
          System.out.println("\n\tTente Novamente, pois o formato do CPF está inválido.");
        }
        while(true){
           System.out.println("\n\tNúmero da Conta Corrente >>  ");
           this.numContaCorrente = in.nextLine();
           if(this.numContaCorrente.matches("\\d{2}.\\d{3}-\\D")){  // Confere se foi inserido no formato correto uma conta corrente.
             for(Conta_Corrente conta : agencia.getContas()){
              if(conta.getNumContaCorrente().equals(this.numContaCorrente)){
                 System.out.println("\n\tConta Corrente já existe.");
                 return;
              }
             }
             break;
           }else{
              System.out.println("\n\tTente Novamente");
           }
        }
        System.out.println("\n\tInforme seu endereço >>  ");
        this.endereco = in.nextLine();
        while(true){
           System.out.println("\n\tInforme o saldo >>  R$ ");
           this.saldo = in2.nextDouble();
           if(saldo >= 0)
               break;
           System.out.println("\n\tSaldo Inválido. Tente Novamente.");
        }
        agencia.getContas().add(new Conta_Corrente(numContaCorrente, cpf, agencia.getAgencia(), saldo));
        agencia.getClientes().add(this);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumContaCorrente() {
        return numContaCorrente;
    }

    public void setNumContaCorrente(String numContaCorrente) {
        this.numContaCorrente = numContaCorrente;
    }

    public double saldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double sacar(double valor){
        if(valor <= saldo)
           saldo -= valor;
        return valor;
    }
    
    public double depositar(double valor){
        saldo += valor;
        return valor;
    }
}
