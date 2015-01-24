package longplay.network;

import static org.junit.Assert.*;

public class URLProviderTest {

    @org.junit.Test
    public void testLoadPage() throws Exception {
        String url = "http://n.meximas.com/style.css";
        String expected = "* {\n" +
                "    margin: 0;\n" +
                "    padding: 0;\n" +
                "    outline: 0;\n" +
                "}\n" +
                "\n" +
                "body, html {\n" +
                "    height: 100%;\n" +
                "}\n" +
                "\n" +
                "body {\n" +
                "    font-size: 12px;\n" +
                "    font-family: arial, sans-serif;\n" +
                "    min-width: 100%;\n" +
                "}\n" +
                "\n" +
                ".shell {\n" +
                "    width: 980px;\n" +
                "    margin: 0 auto;\n" +
                "    box-shadow: 0 0 15px;\n" +
                "    padding: 10px;\n" +
                "}\n" +
                "\n" +
                "article, aside, details, footer, header, menu, nav, section {\n" +
                "    display: block;\n" +
                "}\n" +
                "\n" +
                ".clear {\n" +
                "    display: block;\n" +
                "    height: 0;\n" +
                "    font-size: 0;\n" +
                "    line-height: 0;\n" +
                "    clear: both;\n" +
                "}\n" +
                "\n" +
                "/*=====================================================================================*/\n" +
                "\n" +
                ".header {\n" +
                "    background: url(\"images/bg01.png\");\n" +
                "}\n" +
                "\n" +
                ".header-top {\n" +
                "    height: 70px;\n" +
                "    /*background: url(\"images/bottom-fade.png\") repeat-x bottom;*/\n" +
                "}\n" +
                "\n" +
                ".logo {\n" +
                "    float: left;\n" +
                "    padding-left: 20px;\n" +
                "}\n" +
                "\n" +
                "#navigation {\n" +
                "    float: right;\n" +
                "    padding: 10px;\n" +
                "    margin-top: 10px;\n" +
                "}\n" +
                "#navigation ul {\n" +
                "    list-style: none outside none;\n" +
                "    font-size: 17px;\n" +
                "    font-weight: 400;\n" +
                "}\n" +
                "#navigation ul li {\n" +
                "    display: inline;\n" +
                "    padding-left: 18px;\n" +
                "    padding-right: 18px;\n" +
                "}\n" +
                "#navigation ul li a {\n" +
                "    color: #d5d4d4;\n" +
                "}\n" +
                "#navigation ul li a:hover,\n" +
                "#navigation ul li.active a {\n" +
                "    color: #fff;\n" +
                "    text-decoration: none;\n" +
                "}\n" +
                "\n" +
                ".separator {\n" +
                "    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.3);\n" +
                "    height: 2px;\n" +
                "    width: 100%;\n" +
                "    margin-bottom: 20px;\n" +
                "}\n" +
                "\n" +
                ".header-center {\n" +
                "    background: url(\"images/smooth.jpg\") no-repeat;\n" +
                "    height: 400px;\n" +
                "    box-shadow: 0 0 5px;\n" +
                "    padding: 15px;\n" +
                "    margin-bottom: 10px;\n" +
                "}\n" +
                "\n" +
                ".hc-text {\n" +
                "    display: block;\n" +
                "    float: right;\n" +
                "    background: rgba(0, 0, 0, 0.3);\n" +
                "    padding: 10px;\n" +
                "    font-size: 17px;\n" +
                "    color: white;\n" +
                "}\n" +
                "\n" +
                "/*===============================================================================*/\n" +
                "\n" +
                ".main {\n" +
                "    background: url(\"images/bg-main.png\") repeat;\n" +
                "}\n" +
                "\n" +
                ".sidebar {\n" +
                "    display: block;\n" +
                "    float: left;\n" +
                "    width: 200px;\n" +
                "}\n" +
                "\n" +
                "/*===============================================================================*/\n" +
                "\n" +
                ".footer {\n" +
                "    background: url(\"images/bg01.png\") repeat;\n" +
                "    height: 72px;\n" +
                "}\n" +
                "\n" +
                ".footer .cpr {\n" +
                "    color: #ffffff;\n" +
                "    float: left;\n" +
                "    padding-top: 30px;\n" +
                "    margin-left: 48%;\n" +
                "}";
        String result = Request.loadPage(url);
        assertEquals(expected, result);
    }
}