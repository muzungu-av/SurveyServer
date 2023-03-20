package av.task;

import ru.cbr.web.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

public class Application {
    public static void main(String[] args) {
        DailyInfo service = new DailyInfo();
        DailyInfoSoap port = service.getDailyInfoSoap();

        XMLGregorianCalendar onDate = null;
        try {
            onDate = av.task.XMLGregorianCalendar.getXMLGregorianCalendarNow();
        } catch (DatatypeConfigurationException e) {
            //todo log
        }

        EnumValutesResponse.EnumValutesResult en = port.enumValutes(false);
        GetCursOnDateResponse.GetCursOnDateResult curs = port.getCursOnDate(onDate);

        onDate = port.getLatestDateTime();
        GetCursOnDateXMLResponse.GetCursOnDateXMLResult result = port.getCursOnDateXML(onDate);
        Valute valute = null;

        try {
            valute = GetCursOnDateResultParser.getValuteByValuteCh("AUD", result);
            /*  list = GetCursOnDateResultParser.getValuteByValuteCode("840", result); */
            System.out.println(valute.toString());
        } catch (Exception e) {
            //todo log
        }

    }
}
