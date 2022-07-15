
package proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour reservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date_arrivee" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="date_depart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation", propOrder = {
    "dateArrivee",
    "dateDepart"
})
public class Reservation {

    @XmlElement(name = "date_arrivee")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateArrivee;
    @XmlElement(name = "date_depart")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDepart;

    /**
     * Obtient la valeur de la propriété dateArrivee.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateArrivee() {
        return dateArrivee;
    }

    /**
     * Définit la valeur de la propriété dateArrivee.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateArrivee(XMLGregorianCalendar value) {
        this.dateArrivee = value;
    }

    /**
     * Obtient la valeur de la propriété dateDepart.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDepart() {
        return dateDepart;
    }

    /**
     * Définit la valeur de la propriété dateDepart.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDepart(XMLGregorianCalendar value) {
        this.dateDepart = value;
    }

}
