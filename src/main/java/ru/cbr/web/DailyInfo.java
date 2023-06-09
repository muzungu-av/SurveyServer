
package ru.cbr.web;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Веб сервис для получения ежедневных данных ver 21.02.2023
 * <p>
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 */
@WebServiceClient(name = "DailyInfo", targetNamespace = "http://web.cbr.ru/", wsdlLocation = "file:/DATA/Project/Java/TestTasks/CBR_get_currency/SurveyServer/DailyInfo.asmx.xml")
public class DailyInfo extends Service {

    private final static URL DAILYINFO_WSDL_LOCATION;
    private final static WebServiceException DAILYINFO_EXCEPTION;
    private final static QName DAILYINFO_QNAME = new QName("http://web.cbr.ru/", "DailyInfo");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/DATA/Project/Java/TestTasks/CBR_get_currency/SurveyServer/DailyInfo.asmx.xml");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DAILYINFO_WSDL_LOCATION = url;
        DAILYINFO_EXCEPTION = e;
    }

    public DailyInfo() {
        super(__getWsdlLocation(), DAILYINFO_QNAME);
    }

    public DailyInfo(WebServiceFeature... features) {
        super(__getWsdlLocation(), DAILYINFO_QNAME, features);
    }

    public DailyInfo(URL wsdlLocation) {
        super(wsdlLocation, DAILYINFO_QNAME);
    }

    public DailyInfo(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DAILYINFO_QNAME, features);
    }

    public DailyInfo(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DailyInfo(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns DailyInfoSoap
     */
    @WebEndpoint(name = "DailyInfoSoap")
    public DailyInfoSoap getDailyInfoSoap() {
        return super.getPort(new QName("http://web.cbr.ru/", "DailyInfoSoap"), DailyInfoSoap.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns DailyInfoSoap
     */
    @WebEndpoint(name = "DailyInfoSoap")
    public DailyInfoSoap getDailyInfoSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://web.cbr.ru/", "DailyInfoSoap"), DailyInfoSoap.class, features);
    }

    /**
     * @return returns DailyInfoSoap
     */
    @WebEndpoint(name = "DailyInfoSoap12")
    public DailyInfoSoap getDailyInfoSoap12() {
        return super.getPort(new QName("http://web.cbr.ru/", "DailyInfoSoap12"), DailyInfoSoap.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns DailyInfoSoap
     */
    @WebEndpoint(name = "DailyInfoSoap12")
    public DailyInfoSoap getDailyInfoSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://web.cbr.ru/", "DailyInfoSoap12"), DailyInfoSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DAILYINFO_EXCEPTION != null) {
            throw DAILYINFO_EXCEPTION;
        }
        return DAILYINFO_WSDL_LOCATION;
    }

}
