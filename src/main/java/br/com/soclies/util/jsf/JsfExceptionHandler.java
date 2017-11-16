package br.com.soclies.util.jsf;

import br.com.soclies.service.NegocioException;
import java.io.IOException;
import java.util.Iterator;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.faces.view.facelets.FaceletException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Classe para tratar excessões JSF.
 *
 * @author Fernando Ortiz
 */
public class JsfExceptionHandler extends ExceptionHandlerWrapper {

    // colocando nessa variavel o ExceptionHandler da aplicacao
    private ExceptionHandler wrapped;

    // variavel do tipo Log do apache commons log
    private static Log log = LogFactory.getLog(JsfExceptionHandler.class);

    /**
     * Construtor Padrão.
     *
     * @param wrapped
     */
    public JsfExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    /**
     * Empacotando o tratador de excessões padrão do JSF, criando uma camada
     * acima para tratamento do tratador do JSF. Nosso tratador tem PRIORIDADES.
     *
     * @return variavel de instancia do ExceptionHandler    
     */
    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    /**
     * Método que será chamado quando existir uma excessão JSF. Framework JSF
     * vai instanciar a classe e depois chamar a o handle().
     *
     * @throws FaceletException
     */
    @Override
    public void handle() throws FaceletException {
        // iterando elementos usando a interface Iterator
        // guardando em events todos os eventos enfileirados de exeções
        Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();

        // enquanto tiver um evento na fila do iterador.
        while (events.hasNext()) {
            // guardando o próximo evento.
            ExceptionQueuedEvent event = events.next();

            // buscando o contexto da exceção.. quem foi o causador
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

            Throwable exception = context.getException();
            NegocioException negocioException = getNegocioException(exception);

            boolean handled = false;

            try {
                // verificando se a excessão é uma instancia de uma sessão expirada
                if (exception instanceof ViewExpiredException) {
                    handled = true;
                    redirect("/");
                } else if (negocioException != null) {
                    handled = true;
                    FacesUtil.addErrorMessage(negocioException.getMessage());
                } else {
                    handled = true;
                    // primeiro parametro é a mensagem de erro, e a segunda é a causa da exceção
                    log.error("Erro de Sistema: " + exception.getMessage(), exception);
                    redirect("/Erro.xhtml");
                }
            } finally {
                if (handled) {
                    events.remove();
                }
            }
        }

        // terminou o trabalho
        getWrapped().handle();
    }

    /**
     * Tratando outros tipos de excessões com recursividade.
     *
     * @param exception
     * @return
     */
    private NegocioException getNegocioException(Throwable exception) {
        if (exception instanceof NegocioException) {
            return (NegocioException) exception;
        } else if (exception.getCause() != null) {
            return getNegocioException(exception.getCause());
        }
        return null;
    }

    /**
     * buscando a raiz do contexto do erro da aplicação
     */
    private void redirect(String pages) {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            String contextPath = externalContext.getRequestContextPath();

            externalContext.redirect(contextPath + pages);
            facesContext.responseComplete();
        } catch (IOException e) {
            throw new FaceletException(e);
        }
    }
}
