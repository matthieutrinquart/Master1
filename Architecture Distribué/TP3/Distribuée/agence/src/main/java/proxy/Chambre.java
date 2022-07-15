
package proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour chambre complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="chambre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="list_res" type="{http://hotel/}reservation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nb_lit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pic_bytes" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chambre", propOrder = {
    "listRes",
    "nbLit",
    "numero",
    "picBytes"
})
public class Chambre {

    @XmlElement(name = "list_res", nillable = true)
    protected List<Reservation> listRes;
    @XmlElement(name = "nb_lit")
    protected int nbLit;
    protected int numero;
    @XmlElement(name = "pic_bytes")
    protected byte[] picBytes;

    /**
     * Gets the value of the listRes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listRes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListRes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reservation }
     * 
     * 
     */
    public List<Reservation> getListRes() {
        if (listRes == null) {
            listRes = new ArrayList<Reservation>();
        }
        return this.listRes;
    }

    /**
     * Obtient la valeur de la propriété nbLit.
     * 
     */
    public int getNbLit() {
        return nbLit;
    }

    /**
     * Définit la valeur de la propriété nbLit.
     * 
     */
    public void setNbLit(int value) {
        this.nbLit = value;
    }

    /**
     * Obtient la valeur de la propriété numero.
     * 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Définit la valeur de la propriété numero.
     * 
     */
    public void setNumero(int value) {
        this.numero = value;
    }

    /**
     * Obtient la valeur de la propriété picBytes.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPicBytes() {
        return picBytes;
    }

    /**
     * Définit la valeur de la propriété picBytes.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPicBytes(byte[] value) {
        this.picBytes = value;
    }

}
