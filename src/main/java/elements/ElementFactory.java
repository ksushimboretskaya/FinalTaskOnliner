package elements;

import org.openqa.selenium.WebElement;

public interface ElementFactory {
    <E extends CustomElement> E create(Class<E> elementClass, WebElement wrappedElement);
}