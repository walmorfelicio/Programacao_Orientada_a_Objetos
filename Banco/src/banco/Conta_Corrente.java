package banco;

public class Conta_Corrente {
    
    private String numContaCorrente, cpf, agencia;
    private double saldo;

    public Conta_Corrente(String numContaCorrente, String cpf, String agencia, double saldo) {
        this.numContaCorrente = numContaCorrente;
        this.cpf = cpf;
        this.agencia = agencia;
        this.saldo = saldo;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void depositar(double valor){
        this.saldo += valor;
    }
    
    public String getNumContaCorrente() {
        return numContaCorrente;
    }

    public void setNumContaCorrente(String numContaCorrente) {
        this.numContaCorrente = numContaCorrente;
    }
    
    public double sacar(double valor){
        if(valor <= saldo)
           saldo -= valor;
        if(saldo <= 0)
           saldo = 0;
        return valor;
    }
    
    public void consultarNumContAgen(){
        System.out.println("\n\tConta Corrente >>  " + getNumContaCorrente() + "\n\tAgência >>  " + getAgencia());
    }
}
