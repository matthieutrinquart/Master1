
package proxy;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "hotelService", targetNamespace = "http://hotel/", wsdlLocation = "http://localhost:1111/HotelRepository1?wsdl")
public class HotelService
    extends Service
{

    private final static URL HOTELSERVICE_WSDL_LOCATION;
    private final static WebServiceException HOTELSERVICE_EXCEPTION;
    private final static QName HOTELSERVICE_QNAME = new QName("http://hotel/", "hotelService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:1111/HotelRepository1?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HOTELSERVICE_WSDL_LOCATION = url;
        HOTELSERVICE_EXCEPTION = e;
    }

    public HotelService() {
        super(__getWsdlLocation(), HOTELSERVICE_QNAME);
    }

    public HotelService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HOTELSERVICE_QNAME, features);
    }

    public HotelService(URL wsdlLocation) {
        super(wsdlLocation, HOTELSERVICE_QNAME);
    }

    public HotelService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HOTELSERVICE_QNAME, features);
    }

    public HotelService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HotelService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Ihotel
     */
    @WebEndpoint(name = "hotelPort")
    public Ihotel getHotelPort() {
        return super.getPort(new QName("http://hotel/", "hotelPort"), Ihotel.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Ihotel
     */
    @WebEndpoint(name = "hotelPort")
    public Ihotel getHotelPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://hotel/", "hotelPort"), Ihotel.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HOTELSERVICE_EXCEPTION!= null) {
            throw HOTELSERVICE_EXCEPTION;
        }
        return HOTELSERVICE_WSDL_LOCATION;
    }

}
