package gov.weather;

import com.sun.tools.javadoc.Start;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by kvang on 2/28/17.
 */
public class NdfdXMLBindingStubTest {

    NdfdXMLBindingStub binding;

    @Before
    public void setUp() throws Exception {
        binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();
    }



    @Test
    public void latLonListZipCode() throws Exception {
        String response = binding.latLonListZipCode("53704");
        // Setting the expected value to ??? so this assertion will fail, but
        // will also allow us to see the returned value
        //assertEquals("Result did not match expected value", "???", response);
        String latlong = unmarshallResult(response);
        assertEquals("???", latlong);

    }

    @Test
    public void cornerPoints() throws Exception {
        String response = binding.cornerPoints(SectorType.alaska);

        //assertEquals("Results did not match expected value", "???", response);

        String cp = unmarshallResult(response);
        assertEquals("???", cp);

    }

    @Test
    public void latLonListCityNames() throws Exception {
        String response = binding.latLonListCityNames(DisplayLevelType.value4);

        //assertEquals("Result did not match expected value", "???", response);

        String cityName = unmarshallResult(response);
        assertEquals("???", cityName);
    }

    private String unmarshallResult(String response) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DwmlType dwml =
                    (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(response));
            return dwml.getLatLonList();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*private String unmarshallResultCityName(String response) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DwmlType dwml =
                    (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(response));
            return dwml.getCityNameList();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }*/


    /*private String unmarshallResultCornerPoints(String response) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DwmlType dwml =
                    (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(response));
            return dwml.getLatLonList();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}