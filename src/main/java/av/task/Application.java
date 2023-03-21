package av.task;

import av.task.common.GetCursOnDateResultParser;
import av.task.common.Valute;
import ru.cbr.web.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        DailyInfo service = new DailyInfo();
        DailyInfoSoap port = service.getDailyInfoSoap();

        XMLGregorianCalendar onDate = null;
        try {
            onDate = av.task.common.XMLGregorianCalendar.getXMLGregorianCalendarNow();
        } catch (DatatypeConfigurationException e) {
            //todo log
        }

        EnumValutesResponse.EnumValutesResult en = port.enumValutes(false);
        GetCursOnDateResponse.GetCursOnDateResult curs = port.getCursOnDate(onDate);

        onDate = port.getLatestDateTime();
        GetCursOnDateXMLResponse.GetCursOnDateXMLResult xmlResult = port.getCursOnDateXML(onDate);

        try {
            List<Valute> valute = GetCursOnDateResultParser.getValuteByValuteCh(List.of("USD", "EUR"), xmlResult);
//            Valute valute = GetCursOnDateResultParser.getValuteByValuteCh("USD", xmlResult);
            System.out.println(valute);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
