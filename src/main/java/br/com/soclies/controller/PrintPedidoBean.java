package br.com.soclies.controller;

import br.com.soclies.util.jsf.FacesUtil;
import br.com.soclies.util.report.ExecutorRelatorio;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author patrickweigle
 */
@Named
@RequestScoped
public class PrintPedidoBean {
    @Inject
    private FacesContext facesContext;

    @Inject
    private HttpServletResponse response;

    @Inject
    private EntityManager manager;
    
    public void emitirPedido(Long numero_Pedido) {
        Map<String, Object> parametros = new HashMap<>();
        // nomes dos parametros devem ser iguais os nomes do relatorio
        parametros.put("numeroPedido", numero_Pedido);

        ExecutorRelatorio executorRelatorio
                = new ExecutorRelatorio("/relatorios/printPedido.jasper", this.response, parametros,
                        "PedidoPrint.pdf");

        Session session = manager.unwrap(Session.class);
        session.doWork(executorRelatorio);

        if (executorRelatorio.isRelatorioGerado()) {
            // interropendo a execução do ciclo de vida do JSF
            facesContext.responseComplete();
        } else {
            FacesUtil.addErrorMessage("O relatório não retornou dados.");
        }
    }
}
