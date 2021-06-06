package br.com.ecommit.efeitoAp008.util;

import br.com.ecommit.efeitoAp008.model.PersonCsvRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CsvRecordToPersonMapper {

    public void convertAndTransform(List<List<String>> csvData) {
        csvData.forEach(strings -> {
            System.out.println(strings);
        });
       /* final Person person = Person.builder()
                .firstName(csvRecord.getFirstName().trim().toUpperCase())
                .lastName(csvRecord.getLastName().trim().toUpperCase())
                .build();
        log.info("Converting ({}) into ({})", csvRecord, person);
        return person;*/
    }
}
