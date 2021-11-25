import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/*
	- Nesta classe �internacoes� n�s temos o m�todo que ir� ler o arquivo, os m�todos construtores (permite a cria��o dos objetos), os m�todos getters e setters (permitem acesso e edi��o de cada vari�vel do objeto), e o m�todo toString() (permite mostrar em tela as informa��es do objeto);
	- Um objeto ArrayList de intera��es � criado para que possamos receber os dados da planilha a ser lida;
	- O m�todo �LerCSV� recebe o diret�rio onde o arquivo .csv se encontra na m�quina e devolver um arraylist de �internacoes�, ele utiliza o Buffered Reader para ler o arquivo;
	- No m�todo s�o utilizados �try-catch� para identifica��o de poss�veis erros, estes erros, se ocorrerem, s�o sinalizados no console;
	- O comando �while� � utilizado para que enquanto cada linha do arquivo for diferente de �null� o la�o prossiga, neste la�o � implementado um primeiro �if� que considera o cabe�alho existe ou n�o (�eCabecalho� vem como �true� j� que o nosso documento tem cabe�alho) 
	- Na sequ�ncia, dentro do la�o, criamos um Array de Strings onde as informa��es de cada objeto ser�o armazenadas, dentro do comando split() informamos que ser�o 19 colunas e que o divisor de cada coluna, por ser um arquivo .csv ser� o caracter �;�;
	- Em seguida, ainda dentro do la�o, n�s tratamos as colunas que potencialmente poder�o estar com c�lulas vazias evitando erros deste tipo (utilizamos mais um �if� e tamb�m o m�todo �isEmpty()�);
	- Declaramos as vari�veis, definimos os seus tipos e formatos (utiliza��o do m�todo SimpleDateFormat()), efetuamos as devidas convers�es (utiliza��o do m�todo parse());
	- Criamos um novo objeto �interna� do tipo �internacoes� que receber� as informa��es de uma linha do arquivo, por fim adicionamos o objeto �interna� no ArrayList de objetos tipo �internacoes� (utilizando o m�todo add());
	- Por fim, as a��es dentro do comando �while� se repetem at� incluirmos todos as linhas/objetos �interna� no ArrayList �internacoes� que ser� retornado pelo m�todo lerCSV.

*/
public class internacoes{
		
	private Double idade;
	private Double horasNaFila;	
	private Date dataExtracao;
	private Date dataSolicitacao;
	private Date dataAutorizacao;
	private Date dataInternacao;
	private Date dataAlta;
	private String idUsuario, situacao, centralRegOrigem, sexo, municipioResidencia, solicitante,
			municipioSolicitante, codCid, carater, tipoInternacao, tipoLeito, executante;
		
	public internacoes(){
	}

	public static ArrayList<internacoes> lerCSV(String caminhoDoArquivo){
				
	        ArrayList<internacoes> internacoes = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
	            String linha;
	            boolean eCabecalho = true;
	            while ((linha = br.readLine()) != null) {
	                if (eCabecalho || linha.trim().isEmpty()) {
	                    eCabecalho = false;
	                    continue;
	                }
	                String[] colunas = linha.split(";", 19);
	                if (colunas.length != 19) {
	                    System.out.println("O CSV tem mais ou menos de 19 colunas!");
	                    continue;
	                }
	                try {
	                	try {
	                		Double idade=0.0;
	                		if (!colunas[6].isEmpty()) {
	    	                	idade = Double.parseDouble(colunas[6]);
	    	                	}
	    	                	
	    	                Double horasNaFila = Double.parseDouble(colunas[18]);	        		
	                		Date dataExtracao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(colunas[0]);
	                		Date dataAutorizacao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(colunas[14]);	     
		                	Date dataInternacao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(colunas[15]);
		                	
		                	String aux ="2000-00-00 00:00:00.000";
		                	Date dataAlta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(aux);
	                		if (!colunas[16].isEmpty()) {
		                	dataAlta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(colunas[16]);
	                		}
	                		
		                	Date dataSolicitacao = new SimpleDateFormat("yyyy-MM-dd").parse(colunas[4]);
		                	
		                	String idUsuario = colunas[1], situacao = colunas[2], centralRegOrigem = colunas[3], sexo = colunas[5],
                					municipioResidencia = colunas[7], solicitante = colunas[8], municipioSolicitante = colunas[9],
                					codCid = colunas[10], carater = colunas[11], tipoInternacao = colunas[12],
                					tipoLeito = colunas[13], executante = colunas[17];

		                    internacoes interna = new internacoes();
		                    
		                    interna.setDataExtracao(dataExtracao);
		                    interna.setIdUsuario(idUsuario);
		                    interna.setSituacao(situacao);
		                    interna.setCentralRegOrigem(centralRegOrigem);
		                    interna.setDataSolicitacao(dataSolicitacao);
		                    interna.setSexo(sexo);
		                    interna.setIdade(idade);
		                    interna.setMunicipioResidencia(municipioResidencia);
		                    interna.setSolicitante(solicitante);
		                    interna.setMunicipioSolicitante(municipioSolicitante);
		                    interna.setCodCid(codCid);
		                    interna.setCarater(carater);
		                    interna.setTipoInternacao(tipoInternacao);
		                    interna.setTipoLeito(tipoLeito);
		                    interna.setDataAutorizacao(dataAutorizacao);
		                    interna.setDataInternacao(dataInternacao);
		                    interna.setDataAlta(dataAlta);
		                    interna.setExecutante(executante);
		                    interna.setHorasNaFila(horasNaFila);
		                    
		                    internacoes.add(interna);
	                			
	                	} catch (ParseException e){
	                		System.out.println("ParseExcepion occured: "+e.getMessage());
	                	}
	                } catch (Exception ex) {
	                    System.out.println("Deu algum problema!\n " + ex);
	                }
	            }
	        } catch (FileNotFoundException e) {
				e.printStackTrace();
				} catch (IOException e) {
				e.printStackTrace();
				}

	        return internacoes;
	    }

	public Double getIdade() {
		return idade;
	}

	public void setIdade(Double idade) {
		this.idade = idade;
	}

	public Double getHorasNaFila() {
		return horasNaFila;
	}

	public void setHorasNaFila(Double horasNaFila) {
		this.horasNaFila = horasNaFila;
	}

	public Date getDataExtracao() {
		return dataExtracao;
	}

	public void setDataExtracao(Date dataExtracao) {
		this.dataExtracao = dataExtracao;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}

	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}

	public Date getDataInternacao() {
		return dataInternacao;
	}

	public void setDataInternacao(Date dataInternacao) {
		this.dataInternacao = dataInternacao;
	}

	public Date getDataAlta() {
		return dataAlta;
	}

	public void setDataAlta(Date dataAlta) {
		this.dataAlta = dataAlta;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getCentralRegOrigem() {
		return centralRegOrigem;
	}

	public void setCentralRegOrigem(String centralRegOrigem) {
		this.centralRegOrigem = centralRegOrigem;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMunicipioResidencia() {
		return municipioResidencia;
	}

	public void setMunicipioResidencia(String municipioResidencia) {
		this.municipioResidencia = municipioResidencia;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getMunicipioSolicitante() {
		return municipioSolicitante;
	}

	public void setMunicipioSolicitante(String municipioSolicitante) {
		this.municipioSolicitante = municipioSolicitante;
	}

	public String getCodCid() {
		return codCid;
	}

	public void setCodCid(String codCid) {
		this.codCid = codCid;
	}

	public String getCarater() {
		return carater;
	}

	public void setCarater(String carater) {
		this.carater = carater;
	}

	public String getTipoInternacao() {
		return tipoInternacao;
	}

	public void setTipoInternacao(String tipoInternacao) {
		this.tipoInternacao = tipoInternacao;
	}

	public String getTipoLeito() {
		return tipoLeito;
	}

	public void setTipoLeito(String tipoLeito) {
		this.tipoLeito = tipoLeito;
	}

	public String getExecutante() {
		return executante;
	}

	public void setExecutante(String executante) {
		this.executante = executante;
	}

	@Override
	public String toString() {
		return "internacoes [idade=" + idade + ", horasNaFila=" + horasNaFila + ", dataExtracao=" + dataExtracao
				+ ", dataSolicitacao=" + dataSolicitacao + ", dataAutorizacao=" + dataAutorizacao + ", dataInternacao="
				+ dataInternacao + ", dataAlta=" + dataAlta + ", idUsuario=" + idUsuario + ", situacao=" + situacao
				+ ", centralRegOrigem=" + centralRegOrigem + ", sexo=" + sexo + ", municipioResidencia="
				+ municipioResidencia + ", solicitante=" + solicitante + ", municipioSolicitante="
				+ municipioSolicitante + ", codCid=" + codCid + ", carater=" + carater + ", tipoInternacao="
				+ tipoInternacao + ", tipoLeito=" + tipoLeito + ", executante=" + executante + "]";
	}
	}

