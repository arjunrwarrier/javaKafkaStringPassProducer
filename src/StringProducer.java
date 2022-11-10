import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;
public class StringProducer {
    public static void main(String[] args) {
        KafkaProducer producer;
        String broker = "localhost:9092";
        String topic = "stringCount";
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,broker);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        producer = new KafkaProducer(props);
        String word = "india is my country";

        try {
            System.out.println(word);
            producer.send(new ProducerRecord(topic,word));
            Thread.sleep(6000);
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}