package serialization;

import com.thoughtworks.xstream.XStream;

public class XstreamTest {
    public static void main(String[] args){
        XStream xstream = new XStream();

        Painter painter = new Painter();
        painter.setGenre("Seascape");
        painter.setName("Joaquin Sorolla");

        //SERIALIZATION
        String xml = xstream.toXML(painter);
        System.out.println("Serialization: " + xml);

        System.out.println("------------------");

        //DESERIALIZATION
        Painter newData= (Painter)xstream.fromXML(xml);
        System.out.println("Deserialization: " + newData );
    }
}
