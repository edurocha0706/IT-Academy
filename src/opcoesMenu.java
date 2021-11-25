import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class opcoesMenu {
/*
	- Uma nova classe �opcoes� foi criada para armazenar os m�todos que executariam cada uma das op��es do menu inicial, foram ent�o criados os m�todos �opcoes1(), opcoes2(), opcoes3(), opcoes4(), opcoes5(), opcoes6()�;
	- Iniciamos com a cria��o de uma c�pia da listagem contida no arquivo .csv, � aqui que informamos o caminho do arquivo a ser copiado (informado por par�metro ao chamarmos o m�todo LerCSV(*caminhodoarquivo*));
	- No m�todo op��o1(), que se refere a esta primeira funcionalidade, o usu�rio fornece um par�metro do tipo String;
	- Implementamos o comando �for� para percorrer a lista, dentro do �for� adicionamos �ifs-else� que s� ser�o acessados se o munic�pio informado pelo usu�rio for o mesmo que constar na linha/objeto, se atendida esta condi��o, ent�o se verifica o g�nero/sexo nesta mesma posi��o da lista (posi��o �i�), obedecendo as condi��es as vari�veis auxiliares, de contagem e de soma s�o alteradas para posteriormente serem utilizadas para c�lculo da m�dia;
	- Ap�s o c�lculo das m�dias, as informa��es s�o mostradas ao usu�rio em tela (para tirarmos os d�gitos ap�s o ponto, foi feito um �cast� para alterarmos as vari�reis de �Double� para �int�).
*/
	ArrayList<internacoes> lista1 = internacoes.lerCSV("c:\\gerint_solicitacoes_mod.csv");

	public void opcao1(String nomeMunicipio) {
			
		String nm = nomeMunicipio;
		double totalPacientes=0.0;
		double mediaIdadePorGeneroM=0.0;
		double mediaIdadePorGeneroF=0.0;
		double mediaIdadeGeral=0.0;

		double contM=0.0,contF=0.0,contNI=0.0;
		double somaM=0.0,somaF=0.0,somaNI=0.0;
		double idadeAux=0.0;
				
		for(int i=0;i<lista1.size();i++) {
			
			if(nm.equalsIgnoreCase(lista1.get(i).getMunicipioResidencia())==true){
				totalPacientes++;

				if (lista1.get(i).getSexo().equalsIgnoreCase("MASCULINO")==true) {					
					idadeAux = lista1.get(i).getIdade();
					contM++;
					somaM+=idadeAux;
				} else if (lista1.get(i).getSexo().equalsIgnoreCase("FEMININO")==true) {					
					idadeAux = lista1.get(i).getIdade();
					contF++;
					somaF+=idadeAux;
				}
			}
		}		
			if(somaM!=0)
			mediaIdadePorGeneroM=somaM/contM;
			
			if(somaF!=0)
			mediaIdadePorGeneroF=somaF/contF;

			mediaIdadeGeral=(somaM+somaF+somaNI)/(contM+contF+contNI);
		
		System.out.println("\n -> O n�mero total de pacientes do munic�pio: "+(int)totalPacientes);
		System.out.println("\n -> A m�dia de idade dos pacientes separados por g�nero:\n\n	MASCULINO: "+(int)mediaIdadePorGeneroM
							+"\n	FEMININO: "+(int)mediaIdadePorGeneroF);
		System.out.println("\n -> A m�dia de idade de todos os pacientes : "+(int)mediaIdadeGeral);
		System.out.print("\n\n* Caso voc� n�o tenha encontrado a informa��o desejada, por favor selecione novamente a op��o no menu "
				+ "\n  e forne�a novos valores de entrada (evite o uso de caracteres especiais ou acentua��o).\n");
	}
	/*
	- No m�todo opcao2(), o usu�rio fornece um par�metro �nome de cidade� do tipo String;
	- � criado um novo ArrayList �lista2� para receber os valores solicitados a serem impressos em tela;
	- Tamb�m s�o criadas vari�veis tipo �Date� que receberam valores no formato de hora utilizado na planilha original. Essas datas criadas correspondem �s datas entre as quais queremos obter os resultados solicitados, ou seja, elas ir�o auxiliar a obter os quantitativos para cada ano de 2018,2019,2020 e 2021;
	- � implementado o comando �try-catch� para identificar poss�veis erros de convers�o de vari�reis;
	- Seguindo o exemplo da funcionalidade anterior, percorremos a lista, e caso os valores na planilha atendam ao valor digitado pelo usu�rio, o programa utilizar� os m�todos after(*dataIn�cioDoPer�odo*) e before(*dataFimDoPer�odo*) nos seus �ifs� correspondentes para acessar o m�todo add(), adicionando os objetos/linhas ao novo ArrayList a ser exibido, e acessar tamb�m as vari�veis de contagem ();
	- Por fim, � impresso em tela, atrav�s de um novo �for�, o ArrayList �internacoes� abastecido com os objetos/linhas que obedeceram o �munic�pio� informado pelo usu�rio, e tamb�m impresso em tela as vari�veis dos contadores que indicam os anos solicitados (2018,2019,2020 e 2021).
	 
	*/	
	public void opcao2(String nomeMunicipio) {
		
		String nm = nomeMunicipio;
		ArrayList<internacoes> lista2 = new ArrayList<>();

		String aux0 ="2017-12-31 23:59:59.000";
		String aux1 ="2019-01-01 00:00:00.000";
		String aux2 ="2018-12-31 23:59:59.000";
		String aux3 ="2020-01-01 00:00:00.000";
		String aux4 ="2019-12-31 23:59:59.000";
		String aux5 ="2021-01-01 00:00:00.000";
		String aux6 ="2020-12-31 23:59:59.000";
		String aux7 ="2022-01-01 00:00:00.000";
		try {
        Date data0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(aux0);	     
        Date data1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(aux1);		
        Date data2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(aux2);	     
        Date data3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(aux3);			
        Date data4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(aux4);	     
        Date data5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(aux5);	        
        Date data6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(aux6);	     
        Date data7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(aux7);	
        
        int cont1=0,cont2=0,cont3=0,cont4=0;
        
        for(int i=0;i<lista1.size();i++) {
			if(nm.equalsIgnoreCase(lista1.get(i).getMunicipioResidencia())==true){
					if(lista1.get(i).getDataInternacao().after(data0)==true && lista1.get(i).getDataInternacao().before(data7))
						lista2.add(lista1.get(i));								
					if(lista1.get(i).getDataInternacao().after(data0)==true && lista1.get(i).getDataInternacao().before(data1))
						cont1++;				
					if(lista1.get(i).getDataInternacao().after(data2)==true && lista1.get(i).getDataInternacao().before(data3))
						cont2++;				
					if(lista1.get(i).getDataInternacao().after(data4)==true && lista1.get(i).getDataInternacao().before(data5))
						cont3++;				
					if(lista1.get(i).getDataInternacao().after(data6)==true && lista1.get(i).getDataInternacao().before(data7))
						cont4++;								
			}
        }
		System.out.println("\nLista de pacientes com data de interna��o entre 2018 e 2021:\n");
			for(internacoes l : lista2) {
			System.out.println(l);
			}
		System.out.println("\nQuantidade de pacientes internados (por ano):\n\n	2018 -> "+cont1+"\n	2019 -> "+cont2+"\n	2020 -> "
							+cont3+"\n	2021 -> "+cont4);
		} catch (ParseException e){
    		System.out.println("ParseExcepion occured: "+e.getMessage());
    	}
		System.out.print("\n\n* Caso voc� n�o tenha encontrado a informa��o desejada, por favor selecione novamente a op��o no menu "
				+ "\n  e forne�a novos valores de entrada (evite o uso de caracteres especiais ou acentua��o).\n");
	}
	/*
	- No m�todo opcao3(), o usu�rio fornece uma �institui��o de sa�de� como par�metro do tipo String;
	- Um novo ArrayList tipo String � criado para armazenas as informa��es que ser�o impressas em tela;
	- Utilizamos um �for� para percorrer a lista, j� no comando �if� todos os objetos/linhas que obedecerem � informa��o fornecida pelo usu�rio ter�o os seus �ids do pacientes, idade, munic�pio residencial e solicitante, as datas de autoriza��o, interna��o e alta, e o executante� armazenadas no novo ArrayList �lista3�;
	- As vari�veis do tipo �Date� necessitaram ser convertidas para o tipo String durante o armazenamento (utilizado o m�todo toString());
	- O ArrayList de Strings �lista3� � impresso em tela utilizando um comando �for�.
	 
	*/
	public void opcao3(String nomeExecutante) {
		String nm = nomeExecutante;
		ArrayList<String> lista3 = new ArrayList<>();
		
        for(int i=0;i<lista1.size();i++) {
			if(nm.equalsIgnoreCase(lista1.get(i).getExecutante())==true){
				lista3.add("ID PACIENTE -> "+lista1.get(i).getIdUsuario()+" ; "+
						   "IDADE = "+lista1.get(i).getIdade().toString()+" ; "+
						   "MUNIC�PIO RESIDENCIAL -> "+lista1.get(i).getMunicipioResidencia()+" ; "+
						   "MUNIC�PIO SOLICITANTE -> "+lista1.get(i).getMunicipioSolicitante()+" ; "+
						   "DATA DA AUTORIZA��O -> "+lista1.get(i).getDataAutorizacao().toString()+" ; "+
						   "DATA DA INTERNA��O -> "+lista1.get(i).getDataInternacao().toString()+" ; "+		
						   "DATA DA ALTA -> "+lista1.get(i).getDataAlta().toString()+" ; "+			
						   "EXECUTANTE -> "+lista1.get(i).getExecutante());
			}
        }

		System.out.println("\nLista de todos os pacientes que foram internados, sua idade, o munic�pio residencial e solicitante de"
				         + "\n  cada um deles, as datas de autoriza��o, de interna��o e alta e o executante:\n");
        for(String m : lista3) {
			System.out.println(m);
			}
		System.out.print("\n\n* Caso voc� n�o tenha encontrado a informa��o desejada, por favor selecione novamente a op��o no menu "
				+ "\n  e forne�a novos valores de entrada (evite o uso de caracteres especiais ou acentua��o).\n");
	}
	/*
	- No m�todo opcao4() recebemos o nome da �institui��o de sa�de� fornecida pelo usu�rio;
	- � criado um novo objeto do tipo ArrayList de Strings chamado de �lista4�;
	- Em um comando �for� percorremos a lista principal, utilizamos um �if� para identificar se a institui��o de sa�de fornecida pelo usu�rio fui correspond�ncia na lista, caso exista valor correspondente, ser�o adicionados a nova �lista4� os campos �id do paciente, hospital executante e o tempo de interna��o em dias�;
	- Para calcular o tempo de interna��o em dias foi necess�rio armazenar em uma vari�vel �aux� do tipo �long� a diferen�a entre a �data de alta� do paciente e a �data de solicita��o�, para este calculo foi necess�rio transformar ambas as dadas para a mesma unidade utilizando o m�todo getTime() que converse a data para �milissegundos�;
	- Calculada a diferen�a entre as datas em milissegundos, o valor � dividido por �86400000L� (para termos o resultado em dias) e � armazenado na vari�vel �diasDeInterna��o�;
	- O ArrayList de Strings �lista4� � impresso em tela utilizando um comando �for�.
	 
	*/
	public void opcao4(String nomeSolicitante) {
		
		String nm = nomeSolicitante;
		ArrayList<String> lista4 = new ArrayList<>();
		long aux = 0;
		long diasDeInternacao = 0;

		for(int i=0;i<lista1.size();i++) {
			if(nm.equalsIgnoreCase(lista1.get(i).getSolicitante())==true){

				aux = (lista1.get(i).getDataAlta().getTime() - lista1.get(i).getDataSolicitacao().getTime());
				diasDeInternacao = (aux / 86400000L);	
				lista4.add("ID DO PACIENTE -> "+lista1.get(i).getIdUsuario()+"; HOSPITAL EXECUTANTE -> "+lista1.get(i).getExecutante()+
						 	"; TEMPO DE INTERNA��O -> "+String.valueOf(diasDeInternacao)+" DIAS");
			}
		}

		System.out.println("\nLista de todos os pacientes que foram internados, sua idade, o munic�pio residencial e solicitante de"
				+ "\n  cada um deles, as datas de autoriza��o, de interna��o e alta e o executante:\n");
        for(String n : lista4) {
			System.out.println(n);
			}
		System.out.print("\n\n* Caso voc� n�o tenha encontrado a informa��o desejada, por favor selecione novamente a op��o no menu "
				+ "\n  e forne�a novos valores de entrada (evite o uso de caracteres especiais ou acentua��o).\n");
	}
	/*
	- No m�todo opcao5() temos a execu��o de comandos �for�, estes comandos efetuam compara��es sucessivas para, utilizando o comando �if�, determinar o maior elemento da lista principal (compara um a um dos elementos do Array), quando o maior elemento � encontrado, este � armazenado na vari�vel �maiorValor�;
	- No comando �for� seguinte, a vari�vel �maiorValor� � localizada e sem seguida, atrav�s do m�todo setHorasNaFila(), ela � zerada para que possamos localizar o segundo maior valor no comando �for� seguinte;
	- Na impress�o dos dados em tela foi utilizado o �DecimalFormat� para tirarmos o �.0� das vari�veis �Double�.	 
	*/	
	public void opcao5() {
		
		Double maiorValor=0.0;
		Double aux0,aux1,aux2,aux3,aux4;
		
		for(int i=0;i<lista1.size();i++) {
			if(lista1.get(i).getHorasNaFila() > maiorValor)
				maiorValor = lista1.get(i).getHorasNaFila();
		}
		aux0 = maiorValor;
		for(int i=0;i<lista1.size();i++) {
			if(lista1.get(i).getHorasNaFila() == maiorValor)
				lista1.get(i).setHorasNaFila(0.0);
		}
		maiorValor = 0.0;
		for(int i=0;i<lista1.size();i++) {
			if(lista1.get(i).getHorasNaFila() > maiorValor)
				maiorValor = lista1.get(i).getHorasNaFila();	
		}
		aux1 = maiorValor;
		for(int i=0;i<lista1.size();i++) {
			if(lista1.get(i).getHorasNaFila() == maiorValor)
				lista1.get(i).setHorasNaFila(0.0);
		}
		maiorValor = 0.0;
		for(int i=0;i<lista1.size();i++) {
			if(lista1.get(i).getHorasNaFila() > maiorValor)
				maiorValor = lista1.get(i).getHorasNaFila();	
		}
		aux2 = maiorValor;
		for(int i=0;i<lista1.size();i++) {
			if(lista1.get(i).getHorasNaFila() == maiorValor)
				lista1.get(i).setHorasNaFila(0.0);
		}
		maiorValor = 0.0;
		for(int i=0;i<lista1.size();i++) {
			if(lista1.get(i).getHorasNaFila() > maiorValor) 
				maiorValor = lista1.get(i).getHorasNaFila();	
		}
		aux3 = maiorValor;
		for(int i=0;i<lista1.size();i++) {
			if(lista1.get(i).getHorasNaFila() == maiorValor) 
				lista1.get(i).setHorasNaFila(0.0);
		}
		maiorValor = 0.0;
		for(int i=0;i<lista1.size();i++) {
			if(lista1.get(i).getHorasNaFila() > maiorValor)
				maiorValor = lista1.get(i).getHorasNaFila();
		}
		aux4 = maiorValor;
		for(int i=0;i<lista1.size();i++) {
			if(lista1.get(i).getHorasNaFila() == maiorValor)
				lista1.get(i).setHorasNaFila(0.0);	
		}
		DecimalFormat format = new DecimalFormat("##");
		System.out.println("\nOs 5 maiores tempos de espera da lista (em horas) s�o:\n"+"\n  1� -> "+format.format(aux0)+
		"\n  2� -> "+format.format(aux1)+"\n  3� -> "+format.format(aux2)+"\n  4� -> "+format.format(aux3)+"\n  5� -> "+format.format(aux4));	
	}
	/*
	- O m�todo opcoes6() apenas direciona ao comando �System.exit(0)�, este que � respons�vel por encerrar o programa;
	- Em tela a mensagem de encerramento do programa � mostrada e o menu n�o retorna a aparecer.

	*/
	public void opcao6() {

		System.out.println("Programa finalizado com sucesso !");	
		System.exit(0);
	}
}
