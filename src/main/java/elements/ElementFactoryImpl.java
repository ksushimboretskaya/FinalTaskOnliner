package elements;

import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

import static java.text.MessageFormat.format;

public class ElementFactoryImpl implements ElementFactory {

    @Override
    public <E extends CustomElement> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Error:" + e.getMessage());
        }
    }

    private <E extends CustomElement> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(format("{0}.{1}Impl", getClass().getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("ClassNotFounderException: " + e.getMessage());
        }
    }
}