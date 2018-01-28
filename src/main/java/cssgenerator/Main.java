package cssgenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
  public static void main(String[] args) throws IOException {
    String html = new String(Files.readAllBytes(Paths.get(args[0])));
    parseDocument(html).stream().forEach(System.out::println);
  }

  public static List<String> parseDocument(String document) {
    List<String> allCssLines = new ArrayList<>();
    Elements roots = Jsoup.parse(document).select("body").first().children();
    for (Element root : roots) {
      if (isDOM(root)) {
        List<String> cssLines = new ArrayList<>();
        parseElement(root, cssLines);
        for (String line : cssLines) {
          allCssLines.add(line);
        }
      }
    }
    return allCssLines;
  }

  public static void parseElement(Element element, List<String> cssLines) {
    List<String> cssSelector = new ArrayList<>();
    cssSelector(element, cssSelector);
    if (!cssSelector.isEmpty()) {
      String line = String.join(" > ", cssSelector) + " {}";
      if (!cssLines.contains(line)) {
        cssLines.add(line);
      }
      if (element.children() != null) {
        for (Element child : element.children()) {
          if (isDOM(child)) {
            parseElement(child, cssLines);
          }
        }
      }
    }
  }

  public static void cssSelector(Element element, List<String> cssSelector) {
    cssSelector.add(0, nodeName(element));
    if (element.parent() != null && isDOM(element.parent())) {
      cssSelector(element.parent(), cssSelector);
    }
  }

  public static String nodeName(Element element) {
    if (element.className() == null || element.className().isEmpty()) {
      return element.tagName();
    } else {
      String className = new String();
      if (element.className().contains(" ")) {
        for (String str : element.className().split("\\s+")) {
          className = className + "." + str.trim();
        }
      } else {
        className = "." + element.className();
      }
      return className;
    }
  }

  public static boolean isDOM(Element element) {
    if (Arrays.asList("style", "script", "body", "html").contains(element.tagName())) {
      return false;
    } else {
      return true;
    }
  }
}
