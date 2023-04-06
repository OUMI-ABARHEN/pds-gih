package ma.uiass.eia.pds.frontend.Test.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.io.File;
import java.net.MalformedURLException;

public class Model_Menu {

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public Model_Menu() {
    }

    private String icon;
    private String name;
    private MenuType type;

    public Icon toIcon() throws MalformedURLException {
        return new ImageIcon(new File("/Users/obarhen/Desktop/pds-gih/gih-frontend/src/main/resources/icon/", icon + ".png").toURI().toURL());
    }

    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
