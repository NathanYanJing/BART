package it.unibas.bartgui.view.panel.editor.Dependency.parseHtml;

/**
 *
 * @author Grandinetti Giovanni <grandinetti.giovanni13@gmail.com>
 */
public class MyNumber {
    private int position;
    private String openTag;
    private String closeTag;
    
    private String value;

    public MyNumber(String value) {
        this.value = value;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the openTag
     */
    public String getOpenTag() {
        return openTag = "<font size='4' color='#990000'> ";
    }

    /**
     * @return the closeTag
     */
    public String getCloseTag() {
        return closeTag=" </font>";
    }

    @Override
    public String toString() {
        return getOpenTag()+value+getCloseTag();
    }
}
