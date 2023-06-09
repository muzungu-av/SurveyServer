package av.task.common;

import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import com.sun.org.apache.xerces.internal.dom.TextImpl;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.cbr.web.GetCursOnDateXMLResponse.GetCursOnDateXMLResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetCursOnDateResultParser {

    public static List<Valute> getValuteByValuteCh(List<String> valuteCh, GetCursOnDateXMLResult xmlResult) throws Exception {
        List resultValues = new ArrayList();
        Iterator<String> iter = valuteCh.iterator();
        while (iter.hasNext()) {
            String valCh = iter.next();
            Valute v = getValuteByValuteCh(valCh, xmlResult);
            resultValues.add(v);
        }
        return resultValues;
    }

    public static Valute getValuteByValuteCh(String valuteCh, GetCursOnDateXMLResult xmlResult) throws Exception {
        Valute answer = new Valute();
        List<Object> list = xmlResult.getContent();
        ElementNSImpl e = (ElementNSImpl) list.get(0);
        NodeList chCodeList = e.getElementsByTagName("VchCode");
        int length = chCodeList.getLength();
        boolean isFound = false;
        for (int i = 0; i < length; i++) {
            if (isFound) break;
            Node valuteChNode = chCodeList.item(i);
            TextImpl textimpl = (TextImpl) valuteChNode.getFirstChild();
            String chVal = textimpl.getData();
            if (chVal.equalsIgnoreCase(valuteCh)) {
                isFound = true;
                Node parent = valuteChNode.getParentNode();
                NodeList nodeList = parent.getChildNodes();
                int paramLength = nodeList.getLength();
                for (int j = 0; j < paramLength; j++) {
                    Node currentNode = nodeList.item(j);
                    String name = currentNode.getNodeName();
                    Node currentValue = currentNode.getFirstChild();
                    String value = currentValue.getNodeValue();
                    if (name.equalsIgnoreCase("Vname")) {
                        answer.setName(value);
                    }
                    if (name.equalsIgnoreCase("Vnom")) {
                        answer.setNom(new BigDecimal(value));
                    }
                    if (name.equalsIgnoreCase("Vcurs")) {
                        answer.setCurs(new BigDecimal(value));
                    }
                    if (name.equalsIgnoreCase("Vcode")) {
                        answer.setCode(Integer.parseInt(value));
                    }
                    if (name.equalsIgnoreCase("VchCode")) {
                        answer.setChCode(value);
                    }
                }
            }
        }
        return answer;
    }

    public static Valute getValuteByValuteCode(String valuteCode, GetCursOnDateXMLResult xmlResult) throws Exception {
        Valute answer = new Valute();
        List<Object> list = xmlResult.getContent();
        ElementNSImpl e = (ElementNSImpl) list.get(0);
        NodeList chCodeList = e.getElementsByTagName("Vcode");
        int length = chCodeList.getLength();
        boolean isFound = false;
        for (int i = 0; i < length; i++) {
            if (isFound) break;
            Node valuteChNode = chCodeList.item(i);
            TextImpl textimpl = (TextImpl) valuteChNode.getFirstChild();
            String chVal = textimpl.getData();
            if (chVal.equalsIgnoreCase(valuteCode)) {
                isFound = true;
                Node parent = valuteChNode.getParentNode();
                NodeList nodeList = parent.getChildNodes();
                int paramLength = nodeList.getLength();
                for (int j = 0; j < paramLength; j++) {
                    Node currentNode = nodeList.item(j);
                    String name = currentNode.getNodeName();
                    Node currentValue = currentNode.getFirstChild();
                    String value = currentValue.getNodeValue();
                    if (name.equalsIgnoreCase("Vname")) {
                        answer.setName(value);
                    }
                    if (name.equalsIgnoreCase("Vnom")) {
                        answer.setNom(new BigDecimal(value));
                    }
                    if (name.equalsIgnoreCase("Vcurs")) {
                        answer.setCurs(new BigDecimal(value));
                    }
                    if (name.equalsIgnoreCase("Vcode")) {
                        answer.setCode(Integer.parseInt(value));
                    }
                    if (name.equalsIgnoreCase("VchCode")) {
                        answer.setChCode(value);
                    }
                }
            }
        }
        return answer;
    }
}
