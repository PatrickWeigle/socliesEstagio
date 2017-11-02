package br.com.soclies.util.jsf;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * Fabrica de excessões Handler.
 *
 * @author Fernando Ortiz
 */

public class JsfExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory parent;

    /**
     * Construtor Padrão.
     * @param parent 
     */
    public JsfExceptionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    @Override
    /* transferindo a responsabilidade para a classe que implementa o tratamento
        de ViewExpiredExcpetion */
    public ExceptionHandler getExceptionHandler() {
        return new JsfExceptionHandler(parent.getExceptionHandler());
    }

}
