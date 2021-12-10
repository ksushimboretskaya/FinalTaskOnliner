package elements;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

public class CustomElementDecorator extends DefaultFieldDecorator {
    private final ElementFactory elementFactory = new ElementFactoryImpl();

    public CustomElementDecorator(final SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(final ClassLoader loader, final Field field) {
        if (CustomElement.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return elementFactory.create((Class<? extends CustomElement>) field.getType(), wrappedElement);
    }

    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }
}
