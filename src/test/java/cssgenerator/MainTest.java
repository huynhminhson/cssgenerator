package cssgenerator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class MainTest {
  @Test
  public void nodeNameWithElementHasNoClass() {
    String html = "<div></div>";
    Element element = Jsoup.parse(html).select("div").first();
    assertEquals(Main.nodeName(element), "div");
  }

  @Test
  public void nodeNameWithElementHasOnlyOneCss() {
    String html = "<div class=\"a\"></div>";
    Element element = Jsoup.parse(html).select("div").first();
    assertEquals(Main.nodeName(element), ".a");
  }

  @Test
  public void nodeNameWithElementHasManyCss() {
    String html = "<div class=\"a b c d e\"></div>";
    Element element = Jsoup.parse(html).select("div").first();
    assertEquals(Main.nodeName(element), ".a.b.c.d.e");
  }

  @Test
  public void cssSelectorWithDocumentHasOneElement() {
    String html = "<div class=\"a b c d e\"></div>";
    Element element = Jsoup.parse(html).select("div").first();
    List<String> cssSelector = new ArrayList<>();
    Main.cssSelector(element, cssSelector);
    assertEquals(cssSelector, Arrays.asList(".a.b.c.d.e"));
  }

  @Test
  public void cssSelectorWithDocumentHasManyElements() {
    String html =
        "<div class=\"a\"><div class=\"b\"><div class=\"c\"><div class=\"d\"></div></div></div></div>";
    Element element = Jsoup.parse(html).select(".d").first();
    List<String> cssSelector = new ArrayList<>();
    Main.cssSelector(element, cssSelector);
    assertEquals(cssSelector, Arrays.asList(".a", ".b", ".c", ".d"));
  }

  @Test
  public void parseElementWithAValidHtml() {
    String html = "<div class=\"a\"><div class=\"b\"></div><div class=\"c\"></div></div>";
    Element element = Jsoup.parse(html).select(".a").first();
    List<String> cssLines = new ArrayList<>();
    Main.parseElement(element, cssLines);
    assertEquals(cssLines, Arrays.asList(".a {}", ".a > .b {}", ".a > .c {}"));
  }

  @Test
  public void parseDocumentWithValidHtmlString() {
    String html = "<div class=\"a\"><div class=\"b\"></div><div class=\"c\"></div></div>";
    assertEquals(Main.parseDocument(html), Arrays.asList(".a {}", ".a > .b {}", ".a > .c {}"));
  }
}
