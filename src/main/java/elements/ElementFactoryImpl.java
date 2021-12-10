package elements;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

import static java.text.MessageFormat.format;

public class ElementFactoryImpl implements ElementFactory {
    private final Logger logger = LogManager.getLogger("Element factory logger");

    @Override
    public <E extends CustomElement> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException e) {
            logger.info("Error with exception: InstantiationException");
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            logger.info("Error with exception: IllegalAccessException");
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            logger.info("Error with exception: InvocationTargetException");
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            logger.info("Error with exception: NoSuchMethodException");
            throw new RuntimeException(e);
        }
    }

    private <E extends CustomElement> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(format("{0}.{1}Impl", getClass().getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            logger.info("Error with exception: ClassNotFoundException");
            throw new RuntimeException(e);
        }
    }
}