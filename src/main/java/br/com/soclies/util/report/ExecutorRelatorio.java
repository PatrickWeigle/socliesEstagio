package br.com.soclies.util.report;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.hibernate.jdbc.Work;

/**
 * Classe responsável por executar o relatório e exportar para PDF
 *
 * @author fernando ortiz
 */
public class ExecutorRelatorio implements Work {

    private String caminhoRelatorio;
    // usamos para capturar cabeçalhos
    private HttpServletResponse response;
    private Map<String, Object> parametros;
    private String nomeArquivoSaida;

    private boolean relatorioGerado;

    /* Construtor Padrão da classe. */
    public ExecutorRelatorio(String caminhoRelatorio, HttpServletResponse response, Map<String, Object> parametros, String nomeArquivoSaida) {
        this.caminhoRelatorio = caminhoRelatorio;
        this.response = response;
        this.parametros = parametros;
        this.nomeArquivoSaida = nomeArquivoSaida;
    }

    @Override
    public void execute(Connection cnctn) throws SQLException {
        try {
            // pegando o fluxo de dados de um arquivo
            InputStream relatorioStream = this.getClass().getResourceAsStream(this.caminhoRelatorio);
            // resultado do relatorio sem formato algum
            JasperPrint print = JasperFillManager.fillReport(relatorioStream, this.parametros, cnctn);

            // verificando quantidade de paginas
            this.relatorioGerado = print.getPages().size() > 0;

            if (this.relatorioGerado) {
                JRExporter exportador = new JRPdfExporter();

                // exportando relatorio PDF - exporta com response para a maquina do cliente (resposta HTTP)
                exportador.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                //informa o objeto (neste caso JasperPrint) que será usado para gerar o arquivo (PDF)
                exportador.setParameter(JRExporterParameter.JASPER_PRINT, print);
                // setando o tipo de arquivo que sera enviado 
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=\""
                        + this.nomeArquivoSaida + "\"");
                //executa o JRExporter exportando o relatório
                exportador.exportReport();

            }

        } catch (Exception ex) {
            throw new SQLException("Erro ao executar relatório " + this.caminhoRelatorio, ex);
        }

    }

    public boolean isRelatorioGerado() {
        return relatorioGerado;
    }

}
