import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/*
	- Nesta classe “internacoes” nós temos o método que irá ler o arquivo, os métodos construtores (permite a criação dos objetos), os métodos getters e setters (permitem acesso e edição de cada variável do objeto), e o método toString() (permite mostrar em tela as informações do objeto);
	- Um objeto ArrayList de interações é criado para que possamos receber os dados da planilha a ser lida;
	- O método “LerCSV” recebe o diretório onde o arquivo .csv se encontra na máquina e devolver um arraylist de “internacoes”, ele utiliza o Buffered Reader para ler o arquivo;
	- No método são utilizados “try-catch” para identificação de possíveis erros, estes erros, se ocorrerem, são sinalizados no console;
	- O comando “while” é utilizado para que enquanto cada linha do arquivo for diferente de “null” o laço prossiga, neste laço é implementado um primeiro “if” que considera o cabeçalho existe ou não (“eCabecalho” vem como “true” já que o nosso documento tem cabeçalho) 
	- Na sequência, dentro do laço, criamos um Array de Strings onde as informações de cada objeto serão armazenadas, dentro do comando split() informamos que serão 19 colunas e que o divisor de cada coluna, por ser um arquivo .csv será o caracter “;”;
	- Em seguida, ainda dentro do laço, nós tratamos as colunas que potencialmente poderão estar com células vazias evitando erros deste tipo (utilizamos mais um “if” e também o método “isEmpty()”);
	- Declaramos as variáveis, definimos os seus tipos e formatos (utilização do método SimpleDateFormat()), efetuamos as devidas conversões (utilização do método parse());
	- Criamos um novo objeto “interna” do tipo “internacoes” que receberá as informações de uma linha do arquivo, por fim adicionamos o objeto “interna” no ArrayList de objetos tipo “internacoes” (utilizando o método add());
	- Por fim, as ações dentro do comando “while” se repetem até incluirmos todos as linhas/objetos “interna” no ArrayList “internacoes” que será retornado pelo método lerCSV.

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

