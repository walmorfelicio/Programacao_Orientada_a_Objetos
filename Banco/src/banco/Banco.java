package banco;
import java.util.Scanner;

public class Banco {
    
    public void executar(){
        Scanner entrada1, entrada2;
        entrada1 = new Scanner(System.in);
        entrada2 = new Scanner(System.in);
        Agencia agenc = new Agencia();
        int opcao, op2;
        String cpf;
        double valor;
        boolean semaf = false;
        while(true){
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n\t\tPrograma Bancário\n\t\t  Bem-Vindo(a)");
            while(true){
               System.out.print("\n\t O que deseja fazer?\n\t  1 - Ser nosso Cliente\n\t  2 - Já é Cliente\n\t  3 - Sair\n\t   >> ");
               opcao = entrada1.nextInt();
               if((opcao > 0) && (opcao < 4))
                  break;
               System.out.println("\n\tOpção Inválida. Tente Novamente.");
               System.out.println("----------------------------------------------------------------------------------------------------------------------");
            }
            switch(opcao){
              case 1:        /*      Cadastrando Cliente    */
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
                agenc.criarCliente();
                break;
              case 2:       /*      Já é Cliente    */
                while(true){
                   System.out.println("----------------------------------------------------------------------------------------------------------------------");
                   System.out.print("\n\tInsira seu CPF >>  ");
                   cpf = entrada2.nextLine();
                   if(cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}"))
                      break;
                   System.out.println("\n\tCPF não informado corretamente. Tente Novamente.");
                }
                if(agenc.checarCPF(cpf) == 1){
                   for(Cliente cli : agenc.getClientes()){
                       if(cli.getCPF().equals(cpf)){
                          while(true){
                            System.out.println("----------------------------------------------------------------------------------------------------------------------");
                            System.out.print("\n\t1 - Sacar\n\t2 - Depositar\n\t3 - Atualizar Dados\n\t4 - Ver Saldo\n\t5 - Excluir Conta\n\t6 - Voltar\n\t  >> ");
                            opcao = entrada1.nextInt();
                            if((opcao > 0) && (opcao < 7))
                                break;
                            System.out.println("\n\tOpção Inválida. Tente Novamente.");
                          }
                          if(opcao == 6)
                             break;
                          switch(opcao){
                              case 1:  /* Sacar */
                                while(true){
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                    System.out.print("\n\tVocê possui R$" + cli.saldo() + "\n\tQuanto deseja sacar?  >> R$ ");
                                    valor = entrada1.nextDouble();
                                    if((valor > 0) && (valor <= cli.saldo())){
                                        cli.sacar(valor);
                                        System.out.println("\n\tVocê sacou R$ " + valor + "\n\tSeu saldo é R$ " + cli.saldo());
                                        break;
                                    }else{
                                       System.out.print("\n\tValor Inválido. Tente Novamente.\n\tDeseja continuar (tecle 0) ? >> ");
                                       opcao = entrada1.nextInt();
                                       if(opcao != 0){
                                          opcao = -1;
                                          break;
                                       }
                                    }
                                }
                                break;
                              case 2:   /* Depositar */
                                 while(true){
                                     System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                     System.out.print("\n\tQuanto deseja depositar?  >>   R$ ");
                                     valor = entrada1.nextDouble();
                                     if(valor >= 0){
                                         cli.depositar(valor);
                                         break;
                                     }else{
                                         System.out.print("\n\tValor Inválido?\n\tDeseja continuar (tecle 0) ?  >>  ");
                                         opcao = entrada1.nextInt();
                                         if(opcao != 0){
                                             opcao = -1;
                                             break;
                                         }
                                     }
                                 }
                                 break;
                               case 3:    /* Atualizar Dados */
                                 System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                 agenc.atualizarDadosCliente(agenc, cpf);
                                 break;
                               case 4:   /* Ver Saldo */
                                 System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                 System.out.println("\n\tSeu saldo é R$ " + cli.saldo());
                                 break;
                               case 5:  /* Excluir Conta */
                                 System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                 System.out.print("\n\tDeseja realmente excluir sua conta neste Banco (1 - Sim, Não -> Outro número)?  >>  ");
                                 op2 = entrada1.nextInt();
                                 if(op2 == 1){
                                     int num = agenc.excluirContaCorrente(cli.getNumContaCorrente());
                                     if(num == 1)
                                         System.out.println("\n\tConta do Cliente Removida com Sucesso.");
                                     else
                                         System.out.println("\n\tFalha na remoção da conta.");
                                 }
                                 break;
                          }
                          break;
                       }
                   }
                }else{
                    System.out.println("\n\tCPF " + cpf + " não está cadastrado no Banco.");
                }
                break;
              case 3:     /*      Sair do Sistema Bancário    */
                return;
            }
        }
    }
    
    public static void main(String[] args){
        Banco b = new Banco();
        b.executar();
    }
}
