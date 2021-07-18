import java.util.Collection;


public interface Node {
    Collection<? extends String> getChildren();
    String getValue();
}
