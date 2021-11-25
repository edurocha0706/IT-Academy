import java.util.Scanner;

/*
	- Foi utilizado o Scanner para a coleta de dados fornecidos pelo usuário;
	- O comando “System.out.print” mostra as opções possível na tela do usuário;
	- O comando “switch” permite que o usuário opte por uma das opções em tela (números de 1 a 6);
	- O comando “do-while” faz com que as opções implementadas internamente sejam repedidas, isso faz com que o menu reapareça após cada resultado obtido ou até que o usuário opte pela opção “Terminar o programa”;
	- Dentro de cada “case” no comando switch nós encontramos as chamadas dos métodos para cada ação a ser executada.

*/
public class desafioDell {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String aux;
	do {	
		System.out.print("\n ------------------ SEJA BEM-VINDO(A) ------------------ "
				 + "\n\n	1. Consultar média de idade dos pacientes\n"
				 + "	2. Consultar internações por ano\n"
				 + "	3. Consultar hospitais\n"
				 + "	4. Calcular tempo de internação\n"
				 + "	5. Determinar tempos de espera na fila\n"
				 + "	6. Terminar o programa\n"
				 + "\nDigite a opção desejada: ");
		

		aux = sc.nextLine();	
		System.out.print("\n ------------------------------------------------------- \n");
			switch (aux) {
			case "1":
				Scanner le1 = new Scanner(System.in);
				System.out.print("\nFavor informar o nome do município residencial: ");
				String x1= le1.nextLine();
				opcoesMenu y1 = new opcoesMenu();
				y1.opcao1(x1);
				break;
			case "2":
				Scanner le2 = new Scanner(System.in);
				System.out.print("\nFavor informar o nome do município residencial: ");
				String x2= le2.nextLine();
				opcoesMenu y2 = new opcoesMenu();
				y2.opcao2(x2);
				break;
			case "3":
				Scanner le3 = new Scanner(System.in);
				System.out.print("\nFavor informar o nome da instituição de saúde executante: ");
				String x3= le3.nextLine();
				opcoesMenu y3 = new opcoesMenu();
				y3.opcao3(x3);
				break;
			case "4":
				Scanner le4 = new Scanner(System.in);
				System.out.print("\nFavor informar o nome da instituição de saúde solicitante: ");
				String x4= le4.nextLine();
				opcoesMenu y4 = new opcoesMenu();
				y4.opcao4(x4);
				break;
			case "5":
				opcoesMenu y5 = new opcoesMenu();
				y5.opcao5();
				break;
			case "6":
				opcoesMenu y6 = new opcoesMenu();
				y6.opcao6();
				break;
			default:
				System.out.print("\nOps... opção inválida. Tente novamente ! \n");
			}
	
	} while (aux != "6");
	}

}
