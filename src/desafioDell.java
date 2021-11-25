import java.util.Scanner;

/*
	- Foi utilizado o Scanner para a coleta de dados fornecidos pelo usu�rio;
	- O comando �System.out.print� mostra as op��es poss�vel na tela do usu�rio;
	- O comando �switch� permite que o usu�rio opte por uma das op��es em tela (n�meros de 1 a 6);
	- O comando �do-while� faz com que as op��es implementadas internamente sejam repedidas, isso faz com que o menu reapare�a ap�s cada resultado obtido ou at� que o usu�rio opte pela op��o �Terminar o programa�;
	- Dentro de cada �case� no comando switch n�s encontramos as chamadas dos m�todos para cada a��o a ser executada.

*/
public class desafioDell {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String aux;
	do {	
		System.out.print("\n ------------------ SEJA BEM-VINDO(A) ------------------ "
				 + "\n\n	1. Consultar m�dia de idade dos pacientes\n"
				 + "	2. Consultar interna��es por ano\n"
				 + "	3. Consultar hospitais\n"
				 + "	4. Calcular tempo de interna��o\n"
				 + "	5. Determinar tempos de espera na fila\n"
				 + "	6. Terminar o programa\n"
				 + "\nDigite a op��o desejada: ");
		

		aux = sc.nextLine();	
		System.out.print("\n ------------------------------------------------------- \n");
			switch (aux) {
			case "1":
				Scanner le1 = new Scanner(System.in);
				System.out.print("\nFavor informar o nome do munic�pio residencial: ");
				String x1= le1.nextLine();
				opcoesMenu y1 = new opcoesMenu();
				y1.opcao1(x1);
				break;
			case "2":
				Scanner le2 = new Scanner(System.in);
				System.out.print("\nFavor informar o nome do munic�pio residencial: ");
				String x2= le2.nextLine();
				opcoesMenu y2 = new opcoesMenu();
				y2.opcao2(x2);
				break;
			case "3":
				Scanner le3 = new Scanner(System.in);
				System.out.print("\nFavor informar o nome da institui��o de sa�de executante: ");
				String x3= le3.nextLine();
				opcoesMenu y3 = new opcoesMenu();
				y3.opcao3(x3);
				break;
			case "4":
				Scanner le4 = new Scanner(System.in);
				System.out.print("\nFavor informar o nome da institui��o de sa�de solicitante: ");
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
				System.out.print("\nOps... op��o inv�lida. Tente novamente ! \n");
			}
	
	} while (aux != "6");
	}

}
