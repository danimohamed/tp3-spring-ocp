package ocp;

import config.AmbiguityConfig;
import org.junit.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Etape 10 : sans @Primary, l'injection est ambigue.
 */
public class AmbiguiteTest {

    @Test
    public void injectionAmbigueLeveUneException() {
        try {
            new AnnotationConfigApplicationContext(AmbiguityConfig.class);
            fail("Une NoUniqueBeanDefinitionException etait attendue");
        } catch (RuntimeException e) {
            Throwable cause = e;
            while (cause.getCause() != null) {
                cause = cause.getCause();
            }
            assertTrue("Cause attendue NoUniqueBeanDefinitionException mais "
                            + cause.getClass().getSimpleName(),
                    cause instanceof NoUniqueBeanDefinitionException);
        }
    }
}
