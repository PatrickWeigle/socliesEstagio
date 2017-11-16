package br.com.soclies.util.jpa;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Classe que intercepta métodos com a anotação @Transactional (Obtida de
 * referencia) - copy and past StackOverflow 
 *
 * @author fernando ortiz
 *
 */
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

    private static final long serialVersionUID = 1L;

    private @Inject
    EntityManager manager;

    /* Antes de qualquer metodo com a anotação @Transactional for chamado, o metodo 
        invoke sera chamado */
    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        System.out.println("Chamando Interceptador!!!");
        EntityTransaction trx = manager.getTransaction();
        boolean criador = false;

        try {
            if (!trx.isActive()) {
                // truque para fazer rollback no que já passou
                // (senão, um futuro commit, confirmaria até mesmo operações sem
                // transação)
                trx.begin();
                trx.rollback();

                // agora sim inicia a transação
                trx.begin();

                criador = true;
            }

            return context.proceed();
        } catch (Exception e) {
            if (trx != null && criador) {
                trx.rollback();
            }

            throw e;
        } finally {
            if (trx != null && trx.isActive() && criador) {
                trx.commit();
            }
        }
    }

}
